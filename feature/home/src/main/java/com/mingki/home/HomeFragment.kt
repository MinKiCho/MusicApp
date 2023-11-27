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
import com.mingki.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Math.abs


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var homePagerAdapter: HomePagerAdapter
    private val binding get() = _binding!!

    //    private lateinit var _binding: FragmentHomeBinding
    private lateinit var concatAdapter: ConcatAdapter

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

        binding.homeViewpager2.apply {
            adapter = homePagerAdapter
            setPageTransformer(setAnimation)
            offscreenPageLimit = 1
        }

        TabLayoutMediator(binding.homeTabLayout, binding.homeViewpager2) { tab, position ->
        }.attach()


//        concatAdapter = ConcatAdapter(
//            topicAdapter
//        )

//        binding.homeRecyclerView.adapter = concatAdapter
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
            backgroundImage.translationX = (-position * (pageWidth/2))
        } else {
            view.alpha = 1.0f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}