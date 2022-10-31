package com.example.whitelabelpdi.di

import com.example.whitelabelpdi.config.Config
import com.example.whitelabelpdi.config.ConfigImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ConfigModule {

    @Binds
    fun bindConfig(imp: ConfigImp): Config
}