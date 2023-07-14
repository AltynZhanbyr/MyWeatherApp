package com.example.myweatherapp.presentation.main_screen

import com.example.myweatherapp.data.local.entity.LocalCityWeather
import com.example.myweatherapp.domain.model.CityWeather

data class CityState(
    val isLoading:Boolean = false,
    val cityWeather: LocalCityWeather? = null,
    val error:String = ""
)