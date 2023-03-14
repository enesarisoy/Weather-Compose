package com.ns.weather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.ns.weather.data.mappers.toWeatherInfo
import com.ns.weather.data.remote.WeatherApi
import com.ns.weather.domain.repository.WeatherRepository
import com.ns.weather.domain.util.Resource
import com.ns.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}