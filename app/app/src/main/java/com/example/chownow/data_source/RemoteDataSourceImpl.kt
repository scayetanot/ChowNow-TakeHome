package com.example.chownow.data_source

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.chownow.api.ApiService
import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.*

class RemoteDataSourceImpl(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getRestaurantLocations(
        id: Int): ResultLocations<Locations> =
        withContext(ioDispatcher) {
            val request =
                api.getRestaurantLocations(id)

            ResultLocations.Success(Locations(
                request.id,
                request.address,
                request.deliveryOnly,
                request.hasApplePayEnabled,
                request.isMultiConcept,
                request.locations,
                request.name,
                request.phone
            ))
        }

}