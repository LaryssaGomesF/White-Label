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
import com.example.whitelabelpdi.domain.usecases.FetchEventsUseCase
import com.example.whitelabelpdi.view.model.HomeItemView
import com.example.whitelabelpdi.view.model.ScheduleEvent
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
class ScheduleViewModel @Inject constructor(
    private val fetchEventsUseCase: FetchEventsUseCase
): ViewModel() {

    private val _events: MutableLiveData<PageState<List<ScheduleEvent>, BaseFailure>> =
        MutableLiveData()
    val events: LiveData<PageState<List<ScheduleEvent>, BaseFailure>>
        get() = _events

    fun getEvents(){
        viewModelScope.launch {
            fetchEventsUseCase.fetchEvents()
                .flowOn(Dispatchers.IO)
                .onStart {
                    _events.postValue(LoadingState)
                }.catch { error ->
                    if (error is UnknownHostException) {
                        _events.postValue(
                            ErrorState(
                                NoNetworkConnectionFailure()
                            )
                        )
                    } else {
                        _events.postValue(
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
                    _events.postValue(SuccessState(list))
                }
        }
    }
}