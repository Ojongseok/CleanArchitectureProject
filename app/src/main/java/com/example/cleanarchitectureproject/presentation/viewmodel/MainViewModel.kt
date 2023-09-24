package com.example.cleanarchitectureproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cleanarchitectureproject.data.model.TestResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _questionList = MutableStateFlow<List<TestResponse>>(emptyList())
    val questionList = _questionList.asStateFlow()    // 전체 문항들

    fun getQuestions() {

    }
}