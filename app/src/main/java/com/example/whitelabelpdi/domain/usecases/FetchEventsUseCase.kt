package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.EventsDomain
import kotlinx.coroutines.flow.Flow

interface FetchEventsUseCase {

    suspend fun fetchEvents(): Flow<List<EventsDomain>>
}