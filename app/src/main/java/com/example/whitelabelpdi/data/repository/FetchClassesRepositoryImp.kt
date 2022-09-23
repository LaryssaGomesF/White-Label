package com.example.whitelabelpdi.data.repository

import com.example.whitelabelpdi.domain.models.ClassesDomain
import com.example.whitelabelpdi.domain.repository.FetchClassesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchClassesRepositoryImp @Inject constructor() : FetchClassesRepository {
    override suspend fun fetchClasses(teacherId: String): Flow<List<ClassesDomain>> =
        flow {
            try {
                emit(generateMockListClasses())
            } catch (e: Exception) {
                throw e
            }
        }


    fun generateMockListClasses() : List<ClassesDomain> =
        listOf(
            ClassesDomain(idClass = "1", nameClass = "Turma A", numberGradeClass = "8ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "2", nameClass = "Turma B", numberGradeClass = "8ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "3", nameClass = "Turma C", numberGradeClass = "8ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "4", nameClass = "Turma A", numberGradeClass = "9ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "5", nameClass = "Turma B", numberGradeClass = "9ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "6", nameClass = "Turma C", numberGradeClass = "9ºano", subjectClass = "Historia"),
            ClassesDomain(idClass = "7", nameClass = "Turma A", numberGradeClass = "1ºano EM", subjectClass = "Historia"),
            ClassesDomain(idClass = "8", nameClass = "Turma B", numberGradeClass = "1ºano EM", subjectClass = "Historia"),
            ClassesDomain(idClass = "9", nameClass = "Turma C", numberGradeClass = "1ºano EM", subjectClass = "Historia")
        )
}