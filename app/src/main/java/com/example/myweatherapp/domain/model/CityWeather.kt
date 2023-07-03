package com.example.myweatherapp.domain.model

import com.example.myweatherapp.data.dto.Current
import com.example.myweatherapp.data.dto.Location

data class CityWeather(
    val current: Current,
    val location: Location
)