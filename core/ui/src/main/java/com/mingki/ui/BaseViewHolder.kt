package com.mingki.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T) {
        with(binding) {
//            setVariable(BR.item, item)
            executePendingBindings()
        }
    }
}