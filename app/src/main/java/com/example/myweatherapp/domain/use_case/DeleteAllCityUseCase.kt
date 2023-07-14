package com.example.myweatherapp.domain.use_case

import com.example.myweatherapp.domain.repository.WeatherAppRepository
import javax.inject.Inject

class DeleteAllCityUseCase @Inject constructor(
    private val repository: WeatherAppRepository
) {
    suspend operator fun invoke(){
        repository.deleteAllCity()
    }
}