package com.example.chownow.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantLocation

@Dao
interface LocalDataSourceRoomDb {

    @Query("SELECT * FROM Locations WHERE id = :id")
    suspend fun getLocations(id: String?): Locations

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setLocations(locations: Locations?)
}