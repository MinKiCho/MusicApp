package com.mingki.home.adapter

import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.model.TopicItem
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class TodayReleaseChildAdapter : BaseListAdapter<TopicItem>() {

    override fun onBindViewHolder(holder: BaseViewHolder<TopicItem>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.item, getItem(position))
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_child_today_release
}