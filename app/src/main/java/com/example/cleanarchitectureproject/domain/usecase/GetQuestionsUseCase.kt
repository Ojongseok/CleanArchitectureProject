package com.example.cleanarchitectureproject.domain.usecase

import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.data.network.ApiResult
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(
        request: TestRequest
    ): ApiResult<TestResponse> {
        return mainRepository.getQuestions()
    }
}