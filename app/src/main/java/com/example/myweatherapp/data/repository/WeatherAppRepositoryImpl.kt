package com.example.myweatherapp.data.repository

import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.data.remote.WeatherApi
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import javax.inject.Inject

class WeatherAppRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi):WeatherAppRepository {
    override suspend fun getCityWeather(cityName: String): CityWeatherDto {
        return weatherApi.getCityWeather(cityName)
    }
}