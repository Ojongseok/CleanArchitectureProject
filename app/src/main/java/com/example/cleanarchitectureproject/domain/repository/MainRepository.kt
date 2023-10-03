package com.example.cleanarchitectureproject.domain.repository

import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.data.network.ApiResult

interface MainRepository {
    suspend fun getQuestions(): ApiResult<TestResponse>
}