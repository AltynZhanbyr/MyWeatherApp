package com.example.myweatherapp.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myweatherapp.data.local.entity.LocalCityWeather
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert
    suspend fun insertCity(localCityWeather: LocalCityWeather)

    @Query("delete from city_table")
    suspend fun deleteAll()

    @Query("select * from city_table where :name like cityName")
    suspend fun getCityByName(name: String): LocalCityWeather
}