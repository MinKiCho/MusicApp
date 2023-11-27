package com.mingki.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mingki.home.fragment.FifthFragment
import com.mingki.home.fragment.FirstFragment
import com.mingki.home.fragment.FourthFragment
import com.mingki.home.fragment.SecondFragment
import com.mingki.home.fragment.ThirdFragment

class HomePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            4 -> FifthFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }

}