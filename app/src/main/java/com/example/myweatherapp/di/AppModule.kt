package com.example.myweatherapp.di

import com.example.myweatherapp.data.remote.WeatherApi
import com.example.myweatherapp.data.repository.WeatherAppRepositoryImpl
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import com.example.myweatherapp.domain.use_case.GetCityWeatherUseCase
import com.example.myweatherapp.utlis.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi():WeatherApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(weatherApi: WeatherApi):WeatherAppRepository{
        return WeatherAppRepositoryImpl(weatherApi)
    }

    @Provides
    @Singleton
    fun providesGetCityWeatherUseCase(repository: WeatherAppRepository):GetCityWeatherUseCase{
        return GetCityWeatherUseCase(repository)
    }
}