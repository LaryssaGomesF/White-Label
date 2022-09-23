package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.ClassesDomain
import com.example.whitelabelpdi.domain.repository.FetchClassesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchClassesUseCaseImp @Inject constructor(
    private val fetchClassesRepository: FetchClassesRepository
) : FetchClassesUseCase {

    override suspend fun fetchClasses(teacherId: String): Flow<List<ClassesDomain>> =
        fetchClassesRepository.fetchClasses(teacherId)
}