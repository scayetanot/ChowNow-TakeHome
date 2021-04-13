package com.example.chownow.ui.list

import androidx.lifecycle.ViewModel
import com.example.chownow.repository.AppRepositoryImpl
import javax.inject.Inject

class ListLocationsFragmentViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {}
