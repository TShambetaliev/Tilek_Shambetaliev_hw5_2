package com.example.tilek_shambetaliev_hw5_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tilek_shambetaliev_hw5_2.Pref
import com.example.tilek_shambetaliev_hw5_2.R
import com.example.tilek_shambetaliev_hw5_2.databinding.FragmentOnBoardBinding
import com.example.tilek_shambetaliev_hw5_2.ui.adapter.OnBoardAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment: Fragment() {

    lateinit var binding : FragmentOnBoardBinding
    lateinit var adapter: OnBoardAdapter

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter= OnBoardAdapter(this::onClick)

        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        if (pref.isUserSeen()){
            findNavController().navigate(R.id.calculateFragment)
            }
    }

    fun onClick(){
        pref.isUserSeenOnBoarding()
        findNavController().navigate(R.id.onBoardFragment)
    }

}