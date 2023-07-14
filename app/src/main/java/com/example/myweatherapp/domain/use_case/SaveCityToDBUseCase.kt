package com.example.myweatherapp.domain.use_case

import com.example.myweatherapp.data.local.entity.LocalCityWeather
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.model.toLocalCityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import javax.inject.Inject

class SaveCityToDBUseCase @Inject constructor(
    private val repository: WeatherAppRepository
){
    suspend operator fun invoke(cityWeather: CityWeather?){
        if(cityWeather!=null) {
            repository.saveMoveToDB(cityWeather.toLocalCityWeather())
        }
        else
            throw NullPointerException("Nullable value error")
    }
}