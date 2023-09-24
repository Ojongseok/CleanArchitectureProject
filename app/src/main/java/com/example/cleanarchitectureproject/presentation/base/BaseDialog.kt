package com.example.cleanarchitectureproject.presentation.base

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.cleanarchitectureproject.R
import com.example.cleanarchitectureproject.databinding.DialogBaseBinding

class BaseDialog(
    context: Context,
    @LayoutRes val layoutId: Int,
    val title: String,
    val subTitle: String,
    val positive: () -> Unit,
    val negative: () -> Unit,
    val type: Int = 0
): DialogFragment() {
    private var _binding : DialogBaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCanceledOnTouchOutside(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dialog = this

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_ok -> {
                dismiss()
                positive()
            }
            R.id.btn_cancel -> {
                dismiss()
                negative()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}