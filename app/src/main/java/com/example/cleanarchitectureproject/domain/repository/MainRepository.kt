package com.example.cleanarchitectureproject.domain.repository

import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.model.ApiResult
import retrofit2.Response

interface MainRepository {
    suspend fun getQuestions(): ApiResult<TestResponse>
}