package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.FeaturesHomeDomain
import com.example.whitelabelpdi.domain.repository.FetchHomeFeaturesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchHomeFeaturesUseCaseImp @Inject constructor(
    private val fetchHomeFeaturesRepository: FetchHomeFeaturesRepository
) : FetchHomeFeaturesUseCase {

    override suspend fun fetchHomeFeaturesTeachers(): Flow<List<FeaturesHomeDomain>> {
        return fetchHomeFeaturesRepository.fetchHomeFeaturesTeachers()
    }

    override suspend fun fetchHomeFeaturesStudents(): Flow<List<FeaturesHomeDomain>> {
        return fetchHomeFeaturesRepository.fetchHomeFeaturesStudents()
    }
}