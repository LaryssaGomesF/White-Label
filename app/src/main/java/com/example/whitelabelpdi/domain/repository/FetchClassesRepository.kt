package com.example.whitelabelpdi.domain.repository

import com.example.whitelabelpdi.domain.models.ClassesDomain
import kotlinx.coroutines.flow.Flow

interface FetchClassesRepository {

    suspend fun fetchClasses(teacherId: String): Flow<List<ClassesDomain>>
}