package com.example.data.respositoryImpl

import com.example.data.networkClient.NetworkService
import com.example.domain.main.repository.MainRepository
import com.example.domain.main.entities.CatResponse
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val service: NetworkService
) : MainRepository {

    override suspend fun fetchApi(): CatResponse {
        return service.fetchApi()
    }

}