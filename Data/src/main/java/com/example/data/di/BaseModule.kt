package com.example.data.di

import com.example.data.network.NetworkHelper
import com.example.data.networkClient.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseModule {


    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        return NetworkHelper().getRetrofitObject()
    }
}