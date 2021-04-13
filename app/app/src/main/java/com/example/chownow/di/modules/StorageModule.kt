package com.example.chownow.di.modules

import android.app.Application
import androidx.room.Room
import com.example.chownow.data_source.LocalDataSourceDataObject
import com.example.chownow.data_source.LocalDataSourceRoomDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule(private val application: Application) {

    private var dataSource: LocalDataSourceDataObject =
        Room.databaseBuilder(application, LocalDataSourceDataObject::class.java, "db").build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): LocalDataSourceDataObject {
        return dataSource
    }

    @Singleton
    @Provides
    fun providesAppDao(demoDatabase: LocalDataSourceDataObject): LocalDataSourceRoomDb {
        return demoDatabase.localDataObject()
    }
}