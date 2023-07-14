package com.example.myweatherapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class LocalCityWeather(
    @PrimaryKey(autoGenerate = true)
    val id:Long? = null,
    val cityName:String,
    val degreeInCel:Double,
    val feelsLikeDegreeInCel:Double,
    val windSpeed:Double,
    val windDirection:String,
    val cloudCover:Int
)