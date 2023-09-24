package com.example.cleanarchitectureproject.domain.usecase

import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import retrofit2.Response
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(): Response<TestResponse> {
        return mainRepository.getQuestions()
    }
}