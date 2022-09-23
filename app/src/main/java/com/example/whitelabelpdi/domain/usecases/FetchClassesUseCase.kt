package com.example.whitelabelpdi.domain.usecases

import com.example.whitelabelpdi.domain.models.ClassesDomain
import kotlinx.coroutines.flow.Flow

interface FetchClassesUseCase {

    suspend fun fetchClasses(teacherId: String): Flow<List<ClassesDomain>>
}