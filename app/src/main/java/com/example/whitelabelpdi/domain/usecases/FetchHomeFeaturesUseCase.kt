package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.FeaturesHomeDomain
import kotlinx.coroutines.flow.Flow

interface FetchHomeFeaturesUseCase {

   suspend fun fetchHomeFeatures(): Flow<List<FeaturesHomeDomain>>
}