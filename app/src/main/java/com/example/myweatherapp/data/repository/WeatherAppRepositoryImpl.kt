package com.example.myweatherapp.data.repository

import android.util.Log
import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.data.dto.Movie
import com.example.myweatherapp.data.remote.WeatherApi
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import com.example.myweatherapp.utlis.Constants
import javax.inject.Inject

class WeatherAppRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
    ):WeatherAppRepository {
    override suspend fun getCityWeather(cityName: String): CityWeatherDto {
        Log.d("LoggigError", cityName)
        return weatherApi.getCityWeather(
//            Constants.API_KEY,
//            cityName
        )
    }

    override suspend fun getMovieById(id: Int): Movie {
        return weatherApi.getMovie(id,Constants.API_KEY)
    }
}