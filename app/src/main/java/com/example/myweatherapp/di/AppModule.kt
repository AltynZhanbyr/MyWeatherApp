package com.example.myweatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.myweatherapp.data.local.db.MainDB
import com.example.myweatherapp.data.remote.WeatherApi
import com.example.myweatherapp.data.repository.WeatherAppRepositoryImpl
import com.example.myweatherapp.domain.repository.WeatherAppRepository
import com.example.myweatherapp.domain.use_case.DeleteAllCityUseCase
import com.example.myweatherapp.domain.use_case.GetCityWeatherUseCase
import com.example.myweatherapp.domain.use_case.GetLocalCityByNameUseCase
import com.example.myweatherapp.domain.use_case.SaveCityToDBUseCase
import com.example.myweatherapp.utlis.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRepository(weatherApi: WeatherApi,db:MainDB):WeatherAppRepository{
        return WeatherAppRepositoryImpl(weatherApi,db)
    }

    @Provides
    @Singleton
    fun providesGetCityWeatherUseCase(repository: WeatherAppRepository):GetCityWeatherUseCase{
        return GetCityWeatherUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesGetLocalCityByNameUseCase(repository: WeatherAppRepository): GetLocalCityByNameUseCase {
        return GetLocalCityByNameUseCase(repository)
    }

    @Provides
    @Singleton
    fun providesSaveCityToDBUseCase(repository: WeatherAppRepository): SaveCityToDBUseCase {
        return SaveCityToDBUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteAllCityUseCase(repository: WeatherAppRepository):DeleteAllCityUseCase{
        return DeleteAllCityUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMainDB(@ApplicationContext context: Context): MainDB {
        return Room.databaseBuilder(
            context = context.applicationContext,
            MainDB::class.java,
            "main_db"
        ).build()
    }
}