package com.example.chownow.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chownow.data.model.Locations

@Dao
interface LocalDataSourceRoomDb {

  //As we are only pulling one restaurant, there is no need to use id
  //In a global system, id will need to be passed and use to pull the proper
  //restaurant from the Db
  //  @Query("SELECT * FROM Locations WHERE id = :id")
    @Query("SELECT * FROM Locations")
    suspend fun getLocations(/*id: String?*/): Locations

    @Query("SELECT * FROM Locations WHERE id IS :id")
    suspend fun getLocationsById(id: String): Locations

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setLocations(locations: Locations?)

    @Query("DELETE FROM Locations")
    suspend fun deleteAll()
}