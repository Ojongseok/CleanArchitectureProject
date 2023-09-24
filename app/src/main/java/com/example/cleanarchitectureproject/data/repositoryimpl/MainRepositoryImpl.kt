package com.example.cleanarchitectureproject.data.repositoryimpl

import com.example.cleanarchitectureproject.data.api.RetrofitService
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val service: RetrofitService
): MainRepository {
    override suspend fun getQuestions(): Response<TestResponse> {
        return service.getQuestions()
    }

}