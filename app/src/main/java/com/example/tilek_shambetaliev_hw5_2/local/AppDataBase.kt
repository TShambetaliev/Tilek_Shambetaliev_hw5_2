package com.example.tilek_shambetaliev_hw5_2.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tilek_shambetaliev_hw5_2.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase(){

    abstract fun getDao():LoveDao

}
