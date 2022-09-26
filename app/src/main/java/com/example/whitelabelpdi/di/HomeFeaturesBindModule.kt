package com.example.whitelabelpdi.di

import com.example.whitelabelpdi.data.repository.FetchHomeFeaturesRepositoryImp
import com.example.whitelabelpdi.domain.repository.FetchHomeFeaturesRepository
import com.example.whitelabelpdi.domain.usecases.FetchHomeFeaturesUseCase
import com.example.whitelabelpdi.domain.usecases.FetchHomeFeaturesUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface HomeFeaturesBindModule {


    @Binds
    fun bindFetchHomeFeaturesUseCase(imp: FetchHomeFeaturesUseCaseImp): FetchHomeFeaturesUseCase

    @Binds
    fun bindFetchHomeFeaturesRepository(imp: FetchHomeFeaturesRepositoryImp): FetchHomeFeaturesRepository
}