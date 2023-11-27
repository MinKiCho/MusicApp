package com.mingki.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun bind(item: T) {
        with(binding) {
//            setVariable(BR.item, item)
            executePendingBindings()
        }
    }
}