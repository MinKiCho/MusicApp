package com.mingki.home

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import com.mingki.home.adapter.TopicAdapter
import com.mingki.home.databinding.FragmentHomeBinding
import com.mingki.model.Topic
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var topicAdapter: TopicAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        init()
    }

    private fun init() {
        val items = listOf<Topic>(
            Topic("1", "몰라", "몰라", "몰라", Color.BLACK),
            Topic("2", "몰라2", "몰라", "몰라", Color.WHITE),
            Topic("3", "몰라3", "몰라", "몰라", Color.RED),
            Topic("4", "몰라4", "몰라", "몰라", Color.GREEN),
            Topic("5", "몰라5", "몰라", "몰라", Color.BLUE)
        )
        topicAdapter = TopicAdapter()

        topicAdapter.submitList(items)
        binding.homeViewpager2.apply {
            adapter = topicAdapter
        }
//        concatAdapter = ConcatAdapter(
//            topicAdapter
//        )

//        binding.homeRecyclerView.adapter = concatAdapter
    }
}