package com.example.chownow.repository

import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantLocation

interface AppRepository {
    suspend fun getLocations(id: String?): ResultLocations<Locations>
    suspend fun getLocationsFromApi(id: String?): ResultLocations<Locations>
    suspend fun getLocationsFromDb(id: String?): ResultLocations<Locations>

  //  suspend fun getLocationDetails(id: String): ResultLocations<RestaurantLocation>
}