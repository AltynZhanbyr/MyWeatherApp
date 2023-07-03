package com.example.myweatherapp.domain.repository

import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.domain.model.CityWeather

interface WeatherAppRepository {
    suspend fun getCityWeather(cityName:String): CityWeatherDto
}