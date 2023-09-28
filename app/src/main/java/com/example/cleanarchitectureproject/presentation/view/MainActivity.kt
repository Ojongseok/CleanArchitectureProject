package com.example.cleanarchitectureproject.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureproject.R
import com.example.cleanarchitectureproject.data.model.TestRequest
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

        binding.root.setOnClickListener {
            hideKeyboard(binding.etDefault)
        }

        binding.tvDefault.setOnClickListener {
            BaseDialog(
                context = this,
                layoutId = R.layout.dialog_base,
                title = "프로세스를 종료하시겠습니까?",
                subTitle = "",
                positive = {
                    viewmodel.getQuestions(TestRequest("whdtjr6889@naver.com", "pass1234"))
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
            viewmodel.loading.collect {

            }
            viewmodel.testResponse.collectLatest {
            }
        }
    }
}