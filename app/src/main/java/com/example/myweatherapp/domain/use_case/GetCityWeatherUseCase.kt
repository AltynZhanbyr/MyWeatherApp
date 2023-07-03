package com.example.myweatherapp.domain.use_case

import com.example.myweatherapp.data.dto.Movie
import com.example.myweatherapp.data.dto.toCityWeather
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import com.example.myweatherapp.presentation.main_screen.CityState
import com.example.myweatherapp.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCityWeatherUseCase @Inject constructor(
    private val repository: WeatherAppRepository
){
    operator fun invoke(name:String): Flow<Resource<CityWeather>> = flow{
        try{
            emit(Resource.Loading())
            val city = repository.getCityWeather(name).toCityWeather()
            emit(Resource.Success(city))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Unexpected error") )
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}
