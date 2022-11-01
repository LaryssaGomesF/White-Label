package com.example.whitelabelpdi.domain.repository

import com.example.whitelabelpdi.domain.models.EventsDomain
import kotlinx.coroutines.flow.Flow

interface FetchEventsRepository {

    suspend fun fetchEvents(): Flow<List<EventsDomain>>
}