package com.mingki.home.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mingki.ui.CustomLinearLayout
import com.mingki.home.R
import com.mingki.home.adapter.HomePagerChildAdapter
import com.mingki.home.databinding.FragmentFourthBinding
import com.mingki.model.TopicItem


class FourthFragment : Fragment() {
    private lateinit var binding : FragmentFourthBinding
    private lateinit var homePagerChildAdapter: HomePagerChildAdapter
    private var handler : Handler ?= null
    private var runnable : Runnable?=null

    val topicItems = listOf<TopicItem>(
        TopicItem("1", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("2", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("3", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("4", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("5", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("6", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("7", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("8", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("9", "분홍신", "아이유","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("10", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정")
    ).toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.topicTitle.text = getString(R.string.fourth_title)

        binding.totalMusic.text = String.format(getString(R.string.total_music), 15)
        binding.date.text =  String.format(getString(R.string.date), "2023.1.1")

        homePagerChildAdapter = HomePagerChildAdapter()
        binding.topicRecyclerview.apply {
            adapter = homePagerChildAdapter
            layoutManager = CustomLinearLayout(requireContext())
            addOnItemTouchListener(itemTouchListener)
        }

        homePagerChildAdapter.submitList(topicItems)
    }


    override fun onResume() {
        super.onResume()
        setAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        if(handler != null){
            handler!!.removeCallbacks(runnable!!)
        }
    }

    private fun setAutoScroll() {
        if(handler != null){
            handler!!.removeCallbacks(runnable!!)
        }
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                val linearLayoutManager =
                    (binding.topicRecyclerview.layoutManager as LinearLayoutManager)
                if (linearLayoutManager.findLastVisibleItemPosition() < (homePagerChildAdapter.itemCount - 1)) {
                    linearLayoutManager.smoothScrollToPosition(
                        binding.topicRecyclerview,
                        RecyclerView.State(),
                        linearLayoutManager.findLastCompletelyVisibleItemPosition() + 2
                    )

                } else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (homePagerChildAdapter.itemCount - 1)) {

                }
                handler!!.postDelayed(this, 3000)
            }
        }
        handler!!.postDelayed(runnable!!, 3000)
    }

    private val itemTouchListener = object : RecyclerView.SimpleOnItemTouchListener() {
        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
            return true
        }
    }
}