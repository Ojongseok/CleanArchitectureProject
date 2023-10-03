package com.example.cleanarchitectureproject.domain.model

sealed class ApiResult<out T> {
    // 로딩중
    object Loading : ApiResult<Nothing>()

    // 성공적으로 수신한 경우
    data class Success<T>(val data: T) : ApiResult<T>()
    // 에러 메시지가 포함된 응답을 성공적으로 수신한 경우
    data class Error(val code: Int, val message: String) : ApiResult<Nothing>()
    // 실패
    data class Exception(val error: Throwable) : ApiResult<Nothing>()
}