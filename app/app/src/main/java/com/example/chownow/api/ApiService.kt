package com.example.chownow.api

import com.example.chownow.data.response.ChowNowRestaurantResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("company/{id}")
    suspend fun getRestaurantLocations(@Path("id") id: Int): ChowNowRestaurantResponse
}