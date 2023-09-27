package com.example.cleanarchitectureproject.data.repositoryimpl

import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.data.network.ApiResultCall
import com.example.cleanarchitectureproject.data.network.ApiService
import com.example.cleanarchitectureproject.domain.model.ApiResult
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val service: ApiService
): MainRepository {
    override suspend fun getQuestions(): ApiResult<TestResponse> {
        return service.getQuestions()
    }

}