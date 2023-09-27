package com.example.cleanarchitectureproject.data.network

import com.example.cleanarchitectureproject.domain.model.ApiResult
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class ApiResultCallAdapter<T>(
    private val successType: Type
): CallAdapter<T, Call<ApiResult<T>>> {
    override fun responseType() = successType

    override fun adapt(call: Call<T>): Call<ApiResult<T>> = ApiResultCall(call)
}