package com.example.chownow.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chownow.data.ResultLocations
import com.example.chownow.data.model.Locations
import com.example.chownow.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsListFragmentViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {
    private var _resultLocations = MutableLiveData<Locations>()
    var resultLocations: LiveData<Locations> = _resultLocations

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    private var _selectedItem = MutableLiveData<Int>()
    var selectItem: LiveData<Int> = _selectedItem

    fun getLocationsForRestaurant(id: String?){
        viewModelScope.launch {
            try{
                when(val response = repositoryImpl.getLocations(id)){
                    is ResultLocations.Success -> {
                        _resultLocations.postValue(response.data)
                    }
                    is ResultLocations.Error -> {
                        _errorMessage.postValue(response.exception.toString())
                    }
                }

            } catch (e: java.lang.Exception) {
                _errorMessage.postValue(e.message)
            }
        }
    }

    fun onItemClick(index: Int){
        viewModelScope.launch {
            _selectedItem.postValue(index)
        }
    }
}
