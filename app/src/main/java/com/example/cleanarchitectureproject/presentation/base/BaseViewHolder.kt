package com.example.cleanarchitectureproject.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<ITEM: Any>(
    val context: Context,
    @LayoutRes layoutId: Int,
    parent: ViewGroup
): RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false)) {
    fun onBindViewHolder(item: Any?) {
        
    }
}