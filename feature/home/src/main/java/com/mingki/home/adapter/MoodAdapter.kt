package com.mingki.home.adapter

import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.home.databinding.ItemMoodBinding
import com.mingki.home.databinding.ItemTodayReleaseBinding
import com.mingki.model.Topic
import com.mingki.model.TopicItem
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class MoodAdapter : BaseListAdapter<Topic>(){

    override fun onBindViewHolder(holder: BaseViewHolder<Topic>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.setVariable(BR.item, getItem(position))
        addChildAdapter(holder.binding as ItemMoodBinding, getItem(position).items)
    }


    fun addChildAdapter(binding: ItemMoodBinding, item: List<TopicItem>) {
        val adapterToday = TodayReleaseChildAdapter()
        binding.recyclerview.apply {
            adapter = adapterToday
        }
        adapterToday.submitList(item)
    }


    override fun getItemViewType(position: Int): Int = R.layout.item_mood
}