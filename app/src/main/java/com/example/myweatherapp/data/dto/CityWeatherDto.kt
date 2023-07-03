package com.example.myweatherapp.data.dto

import com.example.myweatherapp.domain.model.CityWeather

data class CityWeatherDto(
    val current: Current,
    val location: Location
)

fun CityWeatherDto.toCityWeather(): CityWeather {
    return CityWeather(
        current = current,
        location = location
    )
}