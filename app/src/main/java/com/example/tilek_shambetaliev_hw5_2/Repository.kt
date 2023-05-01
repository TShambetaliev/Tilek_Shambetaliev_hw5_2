package com.example.tilek_shambetaliev_hw5_2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveLove = MutableLiveData<LoveModel>()

        RetrofitServise().api.percentageNames(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        liveLove.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }
            })
        return liveLove
    }
}