package com.mingki.home.adapter

import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.model.Topic
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class TopicAdapter :BaseListAdapter<Topic>() {

    override fun onBindViewHolder(holder: BaseViewHolder<Topic>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.item, getItem(position))
    }
    override fun getItemViewType(position: Int): Int = R.layout.item_topic
}