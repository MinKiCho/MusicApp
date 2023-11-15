package com.mingki.home.adapter

import android.util.Log
import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.model.TopicItem
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class TopicChildAdapter() : BaseListAdapter<TopicItem>() {
    override fun onBindViewHolder(holder: BaseViewHolder<TopicItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.item, getItem(position))
        Log.d("topicAdapter child", getItem(position).artist)
    }


    override fun getItemViewType(position: Int): Int = R.layout.item_topic_child
}