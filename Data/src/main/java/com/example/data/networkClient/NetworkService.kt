package com.example.data.networkClient

import com.example.domain.main.entities.CatResponse
import retrofit2.http.GET

interface NetworkService {

    @GET("fact")
    suspend fun fetchApi(
    ): CatResponse
}