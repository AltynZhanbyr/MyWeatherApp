package com.example.myweatherapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myweatherapp.data.local.entity.LocalCityWeather

@Database(
    entities = [LocalCityWeather::class],
    version = 1
)
abstract class MainDB():RoomDatabase() {
    abstract fun getDao():MainDao
}