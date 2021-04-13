package com.example.chownow.repository

import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations

interface AppRepository {
    suspend fun getLocations(id: Int): ResultLocations<Locations>
    suspend fun getLocationsFromApi(id: Int): ResultLocations<Locations>
    suspend fun getLocationsFromDb(id: Int): ResultLocations<Locations>
}