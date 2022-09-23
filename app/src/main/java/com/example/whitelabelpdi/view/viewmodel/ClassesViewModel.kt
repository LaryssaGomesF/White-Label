package com.example.whitelabelpdi.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whitelabelpdi.common.failure.BaseFailure
import com.example.whitelabelpdi.common.failure.NoNetworkConnectionFailure
import com.example.whitelabelpdi.common.failure.RequestFailure
import com.example.whitelabelpdi.common.pagestate.ErrorState
import com.example.whitelabelpdi.common.pagestate.LoadingState
import com.example.whitelabelpdi.common.pagestate.PageState
import com.example.whitelabelpdi.common.pagestate.SuccessState
import com.example.whitelabelpdi.domain.models.asView
import com.example.whitelabelpdi.domain.usecases.FetchClassesUseCase
import com.example.whitelabelpdi.view.model.ClassesView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ClassesViewModel @Inject constructor(
    private val fetchClassesUseCase: FetchClassesUseCase
) : ViewModel() {

    private val _classes: MutableLiveData<PageState<List<ClassesView>, BaseFailure>> =
        MutableLiveData()
    val classes: LiveData<PageState<List<ClassesView>, BaseFailure>>
        get() = _classes

    fun getClasses(idTeacher: String) {
        viewModelScope.launch {
            fetchClassesUseCase.fetchClasses(idTeacher)
                .flowOn(Dispatchers.IO)
                .onStart {
                    _classes.postValue(LoadingState)
                }.catch { error ->
                    if (error is UnknownHostException) {
                        _classes.postValue(
                            ErrorState(
                                NoNetworkConnectionFailure()
                            )
                        )
                    } else {
                        _classes.postValue(
                            ErrorState(
                                RequestFailure()
                            )
                        )
                    }
                }.map { list ->
                    list.map { classes ->
                        classes.asView()
                    }
                }.collect { list ->
                    _classes.postValue(SuccessState(list))
                }
        }
    }
}