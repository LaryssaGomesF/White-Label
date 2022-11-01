package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.EventsDomain
import com.example.whitelabelpdi.domain.repository.FetchEventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchEventsUseCaseImp @Inject constructor(
    private val fetchEventsRepository: FetchEventsRepository
) : FetchEventsUseCase {

    override suspend fun fetchEvents(): Flow<List<EventsDomain>> {
        return fetchEventsRepository.fetchEvents()
    }
}