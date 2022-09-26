package com.example.whitelabelpdi.data.repository

import com.example.whitelabelpdi.R
import com.example.whitelabelpdi.domain.models.FeaturesHomeDomain
import com.example.whitelabelpdi.domain.repository.FetchHomeFeaturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchHomeFeaturesRepositoryImp @Inject constructor(

) : FetchHomeFeaturesRepository {
    override suspend fun fetchHomeFeatures(): Flow<List<FeaturesHomeDomain>> {
        return flow {
            try {
                emit(
                    listOf(
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_report
                        ),
                        FeaturesHomeDomain(
                            title = "Plano pedagógico",
                            icon = R.drawable.icon_pedagogical_plan
                        ),
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_arrow_back
                        ),
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_arrow_back
                        ),
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_arrow_back
                        ),
                        FeaturesHomeDomain(
                            title = "Relatórios",
                            icon = R.drawable.icon_arrow_back
                        ),
                    )
                )
            } catch (e: Exception) {
                throw e
            }
        }
    }
}