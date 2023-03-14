package com.ns.weather.domain.repository

import com.ns.weather.domain.util.Resource
import com.ns.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}