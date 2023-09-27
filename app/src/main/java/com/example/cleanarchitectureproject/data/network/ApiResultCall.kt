package com.example.cleanarchitectureproject.data.network

import com.example.cleanarchitectureproject.domain.model.ApiResult
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiResultCall<T> (
    private val callDelegate: Call<T>
) : Call<ApiResult<T>> {

    override fun enqueue(callback: Callback<ApiResult<T>>) = callDelegate.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            val body = response.body()
            val code = response.code()
            val error = response.errorBody().toString()

            if (response.isSuccessful) {
                if (body != null) {
                    callback.onResponse(
                        this@ApiResultCall,
                        Response.success(ApiResult.Success(body))
                    )
                } else {
                    callback.onResponse(
                        this@ApiResultCall,
                        Response.success(ApiResult.Exception(IllegalStateException("body값이 null로 넘어옴")))
                    )
                }
            } else {
                callback.onResponse(
                    this@ApiResultCall,
                    Response.success(ApiResult.Error(code, error))
                )
            }

//            response.body()?.let {
//                when(response.code()) {
//                    in 200..299 -> {
//                        callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Success(it)))
//                    }
//                    in 400..409 -> {
//                        callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Error(response.code(), response.message())))
//                    }
//                }
//            }?: callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Error(0, "Response is Null")))
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            callback.onResponse(this@ApiResultCall, Response.success(ApiResult.Exception(t)))
            call.cancel()
        }
    })

    override fun clone(): Call<ApiResult<T>> = ApiResultCall(callDelegate.clone())

    override fun execute(): Response<ApiResult<T>> = throw UnsupportedOperationException("ResponseCall does not support execute.")

    override fun isExecuted(): Boolean = callDelegate.isExecuted

    override fun cancel() = callDelegate.cancel()

    override fun isCanceled(): Boolean = callDelegate.isCanceled

    override fun request(): Request = callDelegate.request()

    override fun timeout(): Timeout = callDelegate.timeout()
}