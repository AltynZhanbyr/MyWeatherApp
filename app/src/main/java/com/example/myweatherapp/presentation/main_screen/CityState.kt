package com.example.myweatherapp.presentation.main_screen

import com.example.myweatherapp.data.local.entity.LocalCityWeather

data class CityState(
    val isLoading:Boolean = false,
    val cityWeather: LocalCityWeather? = null,
    val error:String = ""
)