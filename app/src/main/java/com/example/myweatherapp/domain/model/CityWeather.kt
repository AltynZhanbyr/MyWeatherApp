package com.example.myweatherapp.domain.model

import com.example.myweatherapp.data.dto.Current
import com.example.myweatherapp.data.dto.Location
import com.example.myweatherapp.data.local.entity.LocalCityWeather

data class CityWeather(
    val current: Current,
    val location: Location
)

fun CityWeather.toLocalCityWeather():LocalCityWeather{
    return LocalCityWeather(
        cityName = this.location.name,
        degreeInCel = this.current.temp_c,
        windDirection = this.current.wind_dir,
        cloudCover = this.current.cloud,
        windSpeed = this.current.wind_kph,
        feelsLikeDegreeInCel = this.current.feelsLikeCel
    )
}