package com.example.cleanarchitectureproject.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.model.ApiResult
import com.example.cleanarchitectureproject.domain.usecase.GetQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase
): ViewModel() {
    private val _questionList = MutableStateFlow(TestResponse())
    val questionList = _questionList.asStateFlow()

    fun getQuestions(request: TestRequest) {
        viewModelScope.launch {
            getQuestionsUseCase(request).collect { response ->
                when(response) {
                    is ApiResult.Loading -> {
                        Log.d("taag", "로딩즁")
                    }
                    is ApiResult.Success -> {
                        Log.d("taag", response.toString())
                    }
                    is ApiResult.Error -> {
                        Log.d("taag", response.toString())
                    }
                    is ApiResult.Exception -> {
                        Log.d("taag", response.toString())
                    }
                }
            }


        }
    }
}