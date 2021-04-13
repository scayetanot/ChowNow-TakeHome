package com.example.chownow.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.chownow.data.RoomDataConverter
import com.example.chownow.data.model.Locations

@Database(entities = [Locations::class], version = 1)
@TypeConverters(RoomDataConverter::class)
abstract class LocalDataSourceDataObject : RoomDatabase() {

    abstract fun localDataObject(): LocalDataSourceRoomDb

    companion object {
        @Volatile
        private var INSTANCE: LocalDataSourceDataObject? = null

        fun getDatabase(context: Context): LocalDataSourceDataObject {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,
                    LocalDataSourceDataObject::class.java, "locations_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}