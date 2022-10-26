package com.example.domain.main.repository

import com.example.domain.main.entities.CatResponse

interface MainRepository {
    suspend fun fetchApi(): CatResponse
}