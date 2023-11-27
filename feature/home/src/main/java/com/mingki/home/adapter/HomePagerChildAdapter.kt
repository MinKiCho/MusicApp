package com.mingki.home.adapter

import com.mingki.home.BR
import com.mingki.home.R
import com.mingki.model.TopicItem
import com.mingki.ui.BaseListAdapter
import com.mingki.ui.BaseViewHolder

class HomePagerChildAdapter : BaseListAdapter<TopicItem>() {
    override fun getItemCount(): Int {
        return if (currentList.size == 0) {
            0
        } else {
            Integer.MAX_VALUE
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<TopicItem>, position: Int) {
        super.onBindViewHolder(holder, position%10)
        holder.binding.setVariable(BR.item, getItem(position%10))

    }

    override fun getItemViewType(position: Int): Int  = R.layout.item_home_child
}