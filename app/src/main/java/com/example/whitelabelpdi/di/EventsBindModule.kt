package com.example.whitelabelpdi.di

import com.example.whitelabelpdi.data.repository.FetchEventsRepositoryImp
import com.example.whitelabelpdi.domain.repository.FetchEventsRepository
import com.example.whitelabelpdi.domain.usecases.FetchEventsUseCase
import com.example.whitelabelpdi.domain.usecases.FetchEventsUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface EventsBindModule {

    @Binds
    fun bindFetchEventsUseCase(imp: FetchEventsUseCaseImp): FetchEventsUseCase

    @Binds
    fun bindFetchEventsRepository(imp: FetchEventsRepositoryImp): FetchEventsRepository
}