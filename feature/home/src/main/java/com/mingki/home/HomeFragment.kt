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
import com.mingki.model.TopicItem
import com.mingki.ui.ViewPager2Animation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var topicAdapter: TopicAdapter
    val topicItems = listOf<TopicItem>(
        TopicItem("1", "몰라","몰라", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("2", "몰라2", "몰라","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("3", "몰라3", "몰라","몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("4", "몰라4", "몰라", "몰라","몰라", "이미지가 있다고 가정"),
        TopicItem("5", "몰라5", "몰라", "몰라", "몰라","이미지가 있다고 가정"),
        TopicItem("6", "몰라", "몰라", "몰라","몰라", "이미지가 있다고 가정"),
        TopicItem("7", "몰라2", "몰라", "몰라", "몰라","이미지가 있다고 가정"),
        TopicItem("8", "몰라3", "몰라", "몰라", "몰라","이미지가 있다고 가정"),
        TopicItem("9", "몰라4", "몰라", "몰라", "몰라","이미지가 있다고 가정"),
        TopicItem("10", "몰라5", "몰라", "몰라", "몰라","이미지가 있다고 가정")
    )
    val topic = listOf<Topic>(
        Topic("1", "휴식이 필요할 떄 듣는 잔잔한 힐링인디", topicItems, Color.BLACK),
        Topic("2", "여유롭고 차분하게, 앰비언트", topicItems, Color.WHITE),
        Topic("3", "당신에게 감성의 끝을 선사할 팝", topicItems, Color.RED),
        Topic("4", "가만히 듣다 보면 울컥하는 인디 록", topicItems, Color.GREEN),
        Topic("5", "새벽을 채우는 몽환 바이브", topicItems, Color.BLUE)
    )

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
        topicAdapter = TopicAdapter()
        binding.homeViewpager2.apply {
            adapter = topicAdapter
//            setPageTransformer(ViewPager2Animation())
        }

        topicAdapter.submitList(topic)

//        concatAdapter = ConcatAdapter(
//            topicAdapter
//        )

//        binding.homeRecyclerView.adapter = concatAdapter
    }
}