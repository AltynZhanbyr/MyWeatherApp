package com.example.myweatherapp.data.repository

import android.util.Log
import com.example.myweatherapp.data.dto.CityWeatherDto
import com.example.myweatherapp.data.dto.Movie
import com.example.myweatherapp.data.local.db.MainDB
import com.example.myweatherapp.data.local.entity.LocalCityWeather
import com.example.myweatherapp.data.remote.WeatherApi
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import com.example.myweatherapp.utlis.Constants
import javax.inject.Inject

class WeatherAppRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val db: MainDB
    ):WeatherAppRepository {
    override suspend fun getCityWeather(cityName: String): CityWeatherDto {
        return weatherApi.getCityWeather(
            Constants.API_KEY,cityName,false
        )
    }

    override suspend fun getMovieById(id: Int): Movie {
        return weatherApi.getMovie(id,Constants.API_KEY)
    }

    override suspend fun getMovieFromDBByName(name: String): LocalCityWeather {
        val dao = db.getDao()
        return dao.getCityByName(name)
    }

    override suspend fun saveMoveToDB(localCityWeather: LocalCityWeather) {
        val dao = db.getDao()
        dao.insertCity(localCityWeather)
    }

    override suspend fun deleteAllCity() {
        val dao = db.getDao()
        dao.deleteAll()
    }
}