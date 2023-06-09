package com.example.tilek_shambetaliev_hw5_2.di

import android.content.Context
import com.example.tilek_shambetaliev_hw5_2.LoveApi
import com.example.tilek_shambetaliev_hw5_2.Pref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi() : LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Singleton
    @Provides
    fun providePref(@ApplicationContext context: Context):Pref{
        return Pref(context)
    }
}