package com.example.whitelabelpdi.data.repository

import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.common.Constants
import com.example.whitelabelpdi.domain.models.FeaturesHomeDomain
import com.example.whitelabelpdi.domain.repository.FetchHomeFeaturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchHomeFeaturesRepositoryImp @Inject constructor(

) : FetchHomeFeaturesRepository {
    override suspend fun fetchHomeFeaturesTeachers(): Flow<List<FeaturesHomeDomain>> {
        return flow {
            try {
                emit(
                    listOf(
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_report,
                            id = Constants.REPORTS
                        ),
                        FeaturesHomeDomain(
                            title = "Plano pedagógico",
                            icon = R.drawable.icon_pedagogical_plan,
                            id = Constants.PEDAGOGICAL_PLAN
                        ),
                        FeaturesHomeDomain(
                            title = "Comunicados",
                            icon = R.drawable.icon_warning,
                            id = Constants.WARNINGS
                        ),
                        FeaturesHomeDomain(
                            title = "Turmas",
                            icon = R.drawable.icon_people,
                            id = Constants.CLASSES
                        )
                    )
                )
            } catch (e: Exception) {
                throw e
            }
        }
    }

    override suspend fun fetchHomeFeaturesStudents(): Flow<List<FeaturesHomeDomain>> {
        return flow {
            try {
                emit(
                    listOf(
                        FeaturesHomeDomain(
                            title = "Boletim",
                            icon = R.drawable.icon_pedagogical_plan,
                            id = Constants.REPORT_CARD
                        ),
                        FeaturesHomeDomain(
                            title = "Comunicados",
                            icon = R.drawable.icon_warning,
                            id = Constants.WARNINGS
                        ),
                        FeaturesHomeDomain(
                            title = "Disciplinas",
                            icon = R.drawable.icon_subjects,
                            id = Constants.SUBJECTS
                        )
                    )
                )
            } catch (e: Exception) {
                throw e
            }
        }
    }
}