package com.example.chownow.ui.details

import androidx.lifecycle.ViewModel
import com.example.chownow.repository.AppRepositoryImpl
import javax.inject.Inject

class LocationDetailsFragmentViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {}
