package com.example.chownow.data_source

import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations

interface RemoteDataSource {
    suspend fun getRestaurantLocations(id: String?): ResultLocations<Locations>
}