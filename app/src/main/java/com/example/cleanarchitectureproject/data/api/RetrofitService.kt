package com.example.cleanarchitectureproject.data.api

import com.example.cleanarchitectureproject.data.model.TestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("/api/v1/survey/questions")
    suspend fun getQuestions(): Response<TestResponse>

}