package com.example.cleanarchitectureproject.data.network

import com.example.cleanarchitectureproject.data.model.TestResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v1/articles")
    suspend fun getQuestions(): ApiResult<TestResponse>

}