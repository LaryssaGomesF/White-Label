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
import com.example.whitelabelpdi.config.Config
import com.example.whitelabelpdi.domain.models.asView
import com.example.whitelabelpdi.domain.usecases.FetchHomeFeaturesUseCase
import com.example.whitelabelpdi.view.model.ClassesView
import com.example.whitelabelpdi.view.model.HomeItemView
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
class HomeViewModel @Inject constructor(
    private val fetchHomeFeaturesUseCase: FetchHomeFeaturesUseCase,
    private val Config: Config
): ViewModel() {

    private val _featuresHome: MutableLiveData<PageState<List<HomeItemView>, BaseFailure>> =
        MutableLiveData()
    val featuresHome: LiveData<PageState<List<HomeItemView>, BaseFailure>>
        get() = _featuresHome

  private val _configIsTeachers: MutableLiveData<Boolean> =
        MutableLiveData()
    val configIsTeachers: LiveData<Boolean>
        get() = _configIsTeachers


    fun getConfigHome(){
        _configIsTeachers.postValue(Config.isTeachers)
    }

    fun getFeaturesTeachers(){
        viewModelScope.launch {
            fetchHomeFeaturesUseCase.fetchHomeFeaturesTeachers()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _featuresHome.postValue(LoadingState)
                }.catch { error ->
                    if (error is UnknownHostException) {
                        _featuresHome.postValue(
                            ErrorState(
                                NoNetworkConnectionFailure()
                            )
                        )
                    } else {
                        _featuresHome.postValue(
                            ErrorState(
                                RequestFailure()
                            )
                        )
                    }
                }.map { list ->
                    list.map { homeFeatures ->
                        homeFeatures.asView()
                    }
                }.collect { list ->
                    _featuresHome.postValue(SuccessState(list))
                }
        }
    }

    fun getFeaturesStudents(){
        viewModelScope.launch {
            fetchHomeFeaturesUseCase.fetchHomeFeaturesStudents()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _featuresHome.postValue(LoadingState)
                }.catch { error ->
                    if (error is UnknownHostException) {
                        _featuresHome.postValue(
                            ErrorState(
                                NoNetworkConnectionFailure()
                            )
                        )
                    } else {
                        _featuresHome.postValue(
                            ErrorState(
                                RequestFailure()
                            )
                        )
                    }
                }.map { list ->
                    list.map { homeFeatures ->
                        homeFeatures.asView()
                    }
                }.collect { list ->
                    _featuresHome.postValue(SuccessState(list))
                }
        }
    }
}