package com.example.cleanarchitectureproject.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitectureproject.data.model.TestResponse
import com.example.cleanarchitectureproject.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {
    private val _questionList = MutableStateFlow(TestResponse())
    val questionList = _questionList.asStateFlow()

    fun getQuestions() {
        viewModelScope.launch {
            val response = mainRepository.getQuestions()

            response.body()?.let {
                _questionList.emit(it)
            }

        }
    }
}