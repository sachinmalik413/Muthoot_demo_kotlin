package com.example.muthootdemo2.di

import com.example.data.networkClient.NetworkService
import com.example.data.respositoryImpl.NetworkRepositoryImpl
import com.example.domain.main.repository.MainRepository
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
    fun provideMainRepository(service: NetworkService): MainRepository =
        NetworkRepositoryImpl(service)

}