package com.example.myweatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class Current(
    val cloud: Int,
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelsLikeCel: Double,
    @SerializedName("feelslike_f")
    val feelsLikeFar: Double,
    val gust_kph: Double,
    val gust_mph: Double,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val last_updated_epoch: Int,
    @SerializedName("precip_in")
    val precipIn: Double,
    @SerializedName("precip_mm")
    val precipMm: Double,
    val pressure_in: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val temp_f: Double,
    val uv: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_kph: Double,
    val wind_mph: Double
)