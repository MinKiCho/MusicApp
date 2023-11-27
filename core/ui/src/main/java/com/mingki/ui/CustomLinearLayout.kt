package com.mingki.ui

import android.content.Context
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

class CustomLinearLayout(private val context: Context) : LinearLayoutManager(context) {

    override fun smoothScrollToPosition(
        recyclerView: RecyclerView?,
        state: RecyclerView.State?,
        position: Int
    ) {
        super.smoothScrollToPosition(recyclerView, state, position)

        val smoothScroller = CustomSmoothScroller(context)
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }
}

class CustomSmoothScroller(context: Context) : LinearSmoothScroller(context) {
    private val SPEED = 300f

    override fun getVerticalSnapPreference(): Int {
        return SNAP_TO_START
    }

    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
        return SPEED / displayMetrics!!.densityDpi
    }
}