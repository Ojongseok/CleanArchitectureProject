package com.example.cleanarchitectureproject.domain.repository

import com.example.cleanarchitectureproject.data.model.TestResponse
import retrofit2.Response

interface MainRepository {
    suspend fun getQuestions(): Response<TestResponse>
}