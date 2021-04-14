package com.example.chownow.repository

import com.example.chownow.data.RemoteDataNotFoundException
import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.data_source.LocalDataSourceRoomDb
import com.example.chownow.data_source.RemoteDataSource
import com.example.chownow.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSourceRoomDb,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AppRepository {

   // private val isInternetOn = InternetUtil.isInternetOn()

    override suspend fun getLocationsFromApi(id: String?): ResultLocations<Locations> {
        return when (val result = remoteDataSource.getRestaurantLocations(id)) {
            is ResultLocations.Success -> {
                val response = result.data
                withContext(ioDispatcher) {
                    localDataSource.setLocations(response)
                }
                ResultLocations.Success(response)
            }
            is ResultLocations.Error -> {
                ResultLocations.Error(RemoteDataNotFoundException())
            }
        }
    }

    override suspend fun getLocationsFromDb(id: String?): ResultLocations<Locations> =
        withContext(ioDispatcher) {
            ResultLocations.Success(localDataSource.getLocations(id))
        }

    override suspend fun getLocations(id: String?): ResultLocations<Locations> {
        return if (true) {
            getLocationsFromApi(id)
        } else {
            getLocationsFromDb(id)
        }
    }

    override suspend fun getLocationDetails(id: String): ResultLocations<List<RestaurantLocation>> =
        withContext(ioDispatcher){
            ResultLocations.Success(localDataSource.getLocations(id).locations)
        }

}