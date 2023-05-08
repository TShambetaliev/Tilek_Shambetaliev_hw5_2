package com.example.tilek_shambetaliev_hw5_2

import android.app.Application
import androidx.room.Room
import com.example.tilek_shambetaliev_hw5_2.local.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_file")
                .allowMainThreadQueries().build()
    }
}