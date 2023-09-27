package com.example.cleanarchitectureproject.domain.usecase

import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.model.ApiResult
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(
        request: TestRequest
    ): Flow<ApiResult<TestResponse>> = flow {
        emit(ApiResult.Loading)

        val response = mainRepository.getQuestions()

        emit(response)
    }
}