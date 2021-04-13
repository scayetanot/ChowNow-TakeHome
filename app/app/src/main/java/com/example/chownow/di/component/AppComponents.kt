package com.example.chownow.di.component

import android.content.Context
import com.example.chownow.data_source.LocalDataSourceDataObject
import com.example.chownow.data_source.LocalDataSourceRoomDb
import com.example.chownow.di.modules.*
import com.example.chownow.ui.details.LocationDetailsFragment
import com.example.chownow.ui.list.ListLocationsFragment
import com.example.chownow.ui.main.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class,
        StorageModule::class
    ]
)

interface AppComponents {
    fun context(): Context

    fun retrofit(): Retrofit

    fun appDataObject(): LocalDataSourceRoomDb
    fun appDataBase(): LocalDataSourceDataObject

    fun inject(mainActivity: MainActivity)
    fun inject(listLocationsFragment: ListLocationsFragment)
    fun inject(locationDetailsFragment: LocationDetailsFragment)
}