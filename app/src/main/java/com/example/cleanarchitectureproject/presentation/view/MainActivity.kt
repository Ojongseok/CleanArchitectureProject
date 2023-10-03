package com.example.cleanarchitectureproject.presentation.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cleanarchitectureproject.R
import com.example.cleanarchitectureproject.data.model.TestRequest
import com.example.cleanarchitectureproject.data.network.ApiResult
import com.example.cleanarchitectureproject.databinding.ActivityMainBinding
import com.example.cleanarchitectureproject.presentation.base.BaseActivity
import com.example.cleanarchitectureproject.presentation.base.BaseDialog
import com.example.cleanarchitectureproject.presentation.util.Extensions.repeatOnStarted
import com.example.cleanarchitectureproject.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    val viewmodel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewmodel = viewmodel

        binding.tvDefault.setOnClickListener {
            BaseDialog(
                context = this,
                layoutId = R.layout.dialog_base,
                title = "API 요청 보내기",
                subTitle = "",
                positive = {
                    viewmodel.getQuestions(TestRequest("whdtjr6889@naver.com", "pass1234"))
                    viewmodel.onProgress(true)
                },
                negative = {
                    showToast("취소 버튼 클릭")
                }
            ).show(supportFragmentManager,"")

        }
    }

    override fun initView() {
        // BaseActivity에 있는 initView()

    }

    override fun subscribeUi() {
        repeatOnStarted {
            viewmodel.testResponse.collect {
                Log.d("taag", it.toString())
                viewmodel.onProgress(false)
            }
        }

        repeatOnStarted {
            viewmodel.errorState.collect {
                Log.d("taag", it.toString())

                it?.let {
                    when(it) {
                        is ApiResult.Failure.HttpError -> showToast("${it.code}번 에러에요")
                        is ApiResult.Failure.NetworkError -> showToast("네트워크 상태 확인")
                        is ApiResult.Failure.UnknownApiError -> showToast("몰루?")
                    }
                }
                viewmodel.onProgress(false)
            }
        }
    }
}