package com.example.chownow.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationDetailsFragmentViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {

    private var _resultLocations = MutableLiveData<RestaurantLocation>()
    var resultLocations: LiveData<RestaurantLocation> = _resultLocations

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    fun getLocationDetails(restaurantId: String?, locationId: String?){
        viewModelScope.launch {
            try{
                Log.d("SCA", "-----------------------------------------------------------")
                when(val response = repositoryImpl.getLocationDetails(restaurantId!!)){
                    is ResultLocations.Success -> {
                        Log.d("SCA", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
                        _resultLocations.postValue(
                            response.data.first { it.id == locationId}
                        )
                    }
                    is ResultLocations.Error -> {
                        Log.d("SCA", ">>>>>+++++++++++++++++++++++++++++++++++>>>>>>>>")
                        _errorMessage.postValue(response.exception.toString())
                    }
                }
                Log.d("SCA", "-----------------------------------------------------------")

            } catch (e: java.lang.Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }
}
