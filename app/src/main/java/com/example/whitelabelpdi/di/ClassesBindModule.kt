package com.example.whitelabelpdi.di

import com.example.whitelabelpdi.data.repository.FetchClassesRepositoryImp
import com.example.whitelabelpdi.domain.repository.FetchClassesRepository
import com.example.whitelabelpdi.domain.usecases.FetchClassesUseCase
import com.example.whitelabelpdi.domain.usecases.FetchClassesUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ClassesBindModule {

    @Binds
    fun bindFetchClassesUseCase(imp: FetchClassesUseCaseImp): FetchClassesUseCase

    @Binds
    fun bindFetchClassesRepository(imp: FetchClassesRepositoryImp): FetchClassesRepository

}