package com.example.domain.main.usecases

import com.example.domain.main.repository.MainRepository
import com.example.domain.main.entities.CatResponse
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend fun fetchApi(): CatResponse {
        return repository.fetchApi()
    }
}