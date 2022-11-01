package com.example.whitelabelpdi.data.repository

import com.example.whitelabelpdi.domain.models.EventsDomain
import com.example.whitelabelpdi.domain.repository.FetchEventsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchEventsRepositoryImp @Inject constructor(): FetchEventsRepository {

    override suspend fun fetchEvents(): Flow<List<EventsDomain>> {
        return flow {
            try {
                emit(
                    listOf(
                        EventsDomain(
                            title = "Atividade 1 - Ciencias",
                            description = "Sistema Nervoso",
                            id = 0,
                            data = "01/11/2022"
                        ),
                        EventsDomain(
                            title = "Atividade 2 - Ciencias",
                            description = "Sistema Respiratorio",
                            id = 1,
                            data = "15/11/2022"
                        ),
                        EventsDomain(
                            title = "Atividade 1 - Geografia",
                            description = "Globalização",
                            id = 2,
                            data = "22/11/2022"
                        ),
                        EventsDomain(
                            title = "Prova - Matematica",
                            description = "Soma de Frações",
                            id = 3,
                            data = "31/11/2022"
                        )
                    )
                )
            } catch (e: Exception) {
                throw e
            }
        }
    }
}