package com.example.cleanarchitectureproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.data.network.ApiResult
import com.example.cleanarchitectureproject.data.network.onFailure
import com.example.cleanarchitectureproject.data.network.onSuccess
import com.example.cleanarchitectureproject.domain.usecase.GetQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase
): ViewModel() {
    private val _errorState = MutableStateFlow<ApiResult.Failure?>(null)
    val errorState = _errorState.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _testResponse = MutableStateFlow(TestResponse())
    val testResponse = _testResponse.asStateFlow()

    fun getQuestions(request: TestRequest) {
        viewModelScope.launch {
            getQuestionsUseCase(request)
                .onSuccess {
                    _testResponse.value = it
                }
                .onFailure {
                    _errorState.value = it
                }
        }
    }

    fun onProgress(state: Boolean) {
        viewModelScope.launch {
            _loading.emit(state)
        }
    }
}