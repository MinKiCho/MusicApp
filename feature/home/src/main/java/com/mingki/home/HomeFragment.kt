package com.mingki.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.mingki.home.adapter.HomePagerAdapter
import com.mingki.home.adapter.MondayAdapter
import com.mingki.home.adapter.MoodAdapter
import com.mingki.home.adapter.TodayReleaseAdapter
import com.mingki.home.databinding.FragmentHomeBinding
import com.mingki.model.Topic
import com.mingki.model.TopicItem
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Math.abs


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var homePagerAdapter: HomePagerAdapter
    private lateinit var moodAdapter: MoodAdapter
    private lateinit var todayReleaseAdapter: TodayReleaseAdapter
    private lateinit var mondayAdapter: MondayAdapter

    private val binding get() = _binding!!

    private lateinit var concatAdapter: ConcatAdapter
    val topicItems = listOf<TopicItem>(
        TopicItem("1", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("2", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("3", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("4", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("5", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("6", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("7", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("8", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("9", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정"),
        TopicItem("10", "분홍신", "아이유", "몰라", "몰라", "이미지가 있다고 가정")
    ).toList()

    val today = listOf(Topic("1", "오늘 발매 음악", topicItems))
    val mood = listOf(Topic("1", "무드가 흐르는 순간 MOOD:ON", topicItems))
    val monday = listOf(Topic("1", "나도 몰래 기분 째지는 월요일", topicItems))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        init()

    }


    private fun init() {
        homePagerAdapter = HomePagerAdapter(requireActivity())
        moodAdapter = MoodAdapter()
        todayReleaseAdapter = TodayReleaseAdapter()
        mondayAdapter = MondayAdapter()

        binding.homeViewpager2.apply {
            adapter = homePagerAdapter
            setPageTransformer(setAnimation)
            offscreenPageLimit = 1
        }

        TabLayoutMediator(binding.homeTabLayout, binding.homeViewpager2) { tab, position ->
        }.attach()


        concatAdapter = ConcatAdapter(
            todayReleaseAdapter, moodAdapter , mondayAdapter
        )

        binding.homeRecyclerView.adapter = concatAdapter

        moodAdapter.submitList(mood)
        todayReleaseAdapter.submitList(today)
        mondayAdapter.submitList(monday)
    }

    private val setAnimation = ViewPager2.PageTransformer { view, position ->
        val pageWidth = view.width
        val title = view.findViewById<TextView>(R.id.topicTitle)
        val playButton = view.findViewById<ImageView>(R.id.playButton)
        val recyclerview = view.findViewById<RecyclerView>(R.id.topicRecyclerview)
        val backgroundImage = view.findViewById<ImageView>(R.id.imageView)
        val totalMusic = view.findViewById<TextView>(R.id.totalMusic)
        val date = view.findViewById<TextView>(R.id.date)
        val absPosition = abs(position)

        if (position < -1) {
            view.alpha = 1.0f
        } else if (position <= 1) {
            title.alpha = 1.0f - (absPosition)
            totalMusic.alpha = 1.0f - (absPosition)
            totalMusic.translationX = (position) * (pageWidth)
            date.alpha = 1.0f - (absPosition)
            date.translationX = (position) * (pageWidth)
            playButton.translationX = (position) * (pageWidth / 2)
            playButton.alpha = 1.0f - (absPosition * 2)
            recyclerview.translationX = (position) * (pageWidth / 2)
            recyclerview.alpha = 1.0f - (absPosition)
            backgroundImage.translationX = (-position * (pageWidth / 2))
        } else {
            view.alpha = 1.0f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}