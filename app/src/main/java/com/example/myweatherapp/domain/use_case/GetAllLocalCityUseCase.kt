package com.example.myweatherapp.domain.use_case

import com.example.myweatherapp.data.local.entity.LocalCityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllLocalCityUseCase @Inject constructor(
    private val repository: WeatherAppRepository
) {
    operator fun invoke():Flow<LocalCityWeather?>{
        return repository.getAllLocalCity()
    }
}