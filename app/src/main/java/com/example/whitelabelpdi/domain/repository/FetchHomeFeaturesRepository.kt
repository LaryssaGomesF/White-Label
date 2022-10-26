package com.example.whitelabelpdi.domain.repository

import com.example.whitelabelpdi.domain.models.FeaturesHomeDomain
import kotlinx.coroutines.flow.Flow

interface FetchHomeFeaturesRepository {

    suspend fun fetchHomeFeatures(): Flow<List<FeaturesHomeDomain>>

    suspend fun fetchHomeFeaturesStudents(): Flow<List<FeaturesHomeDomain>>
}