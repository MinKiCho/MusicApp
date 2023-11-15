package com.mingki.home.adapter

import android.util.Log
import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.home.databinding.ItemTopicBinding
import com.mingki.model.Topic
import com.mingki.model.TopicItem
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class TopicAdapter : BaseListAdapter<Topic>() {

    override fun onBindViewHolder(holder: BaseViewHolder<Topic>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.item, getItem(position))
//        Log.d("topicAdapter", getItem(position).title)

        addChildAdapter(getItem(position).items, holder)
    }

    private fun addChildAdapter(item: List<TopicItem>, holder: BaseViewHolder<Topic>) {
        val topChildAdapter = TopicChildAdapter()
        (holder.binding as ItemTopicBinding).topicRecyclerview.apply {
            adapter = topChildAdapter
        }
        topChildAdapter.submitList(item)
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_topic
}