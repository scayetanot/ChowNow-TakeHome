package com.example.chownow.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantLocation
import com.example.chownow.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationDetailsFragmentViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {

    private var _resultLocations = MutableLiveData<Locations>()
    var resultLocations: LiveData<Locations> = _resultLocations

    fun getLocationDetails(id: String){
        viewModelScope.launch {

        }
    }
}
