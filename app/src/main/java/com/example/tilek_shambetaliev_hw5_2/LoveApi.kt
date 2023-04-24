package com.example.tilek_shambetaliev_hw5_2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun percentageNames(
        @Query("fname") firstname: String,
        @Query("sname") secondName: String
    ): Call<LoveModel>

}