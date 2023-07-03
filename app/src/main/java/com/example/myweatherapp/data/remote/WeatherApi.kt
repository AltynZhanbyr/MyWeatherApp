package com.example.myweatherapp.data.remote

import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.utlis.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("v1/current.json?key=${Constants.API_KEY}&q={city_name}")
    suspend fun getCityWeather(@Path("city_name") cityName:String):CityWeatherDto
}