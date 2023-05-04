package com.example.tilek_shambetaliev_hw5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tilek_shambetaliev_hw5_2.databinding.FragmentResaultBinding
import dagger.hilt.android.AndroidEntryPoint


class ResaultFragment : Fragment() {

    lateinit var binding: FragmentResaultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentResaultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result=arguments?.getSerializable("key") as LoveModel
        binding.tvFirstName.text=result.firstName
        binding.tvSecondName.text= result.secondName
        binding.tvResult.text=result.percentage
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}