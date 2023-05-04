package com.example.tilek_shambetaliev_hw5_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.tilek_shambetaliev_hw5_2.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding
    val viewModel: LoveViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.liveLove(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner, Observer { LoveModel ->
                        Log.e("ololol", "initClickers: ${LoveModel}")
                        findNavController().navigate(R.id.resaultFragment, bundleOf("key" to LoveModel))
                    })
            }
        }
    }

    /*RetrofitServise().api.percentageNames(
    etFirstName.text.toString(),
    etSecondName.text.toString()
    ).enqueue(object : Callback<LoveModel> {
        override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
            if (response.isSuccessful) {
                Log.d("ololo", "onResponse: ${response.body()}")
                findNavController().navigate(
                    R.id.resaultFragment,
                    bundleOf("key" to response.body())
                )
            }
        }

        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            Log.d("ololo", "onFailure: ${t.message}")
        }
    })*/
}