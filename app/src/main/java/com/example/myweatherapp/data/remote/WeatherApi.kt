package com.example.myweatherapp.data.remote

import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.data.dto.Movie
import com.example.myweatherapp.utlis.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/current.json")
    suspend fun getCityWeather(
        @Query("key") apiKey: String,
        @Query("q") cityName: String,
        @Query("aqi") aqi: Boolean
    ): CityWeatherDto

    @GET("movie/{id}")
    suspend fun getMovie(@Path("id") id: Int, @Query("api_key") apiKey: String): Movie
}