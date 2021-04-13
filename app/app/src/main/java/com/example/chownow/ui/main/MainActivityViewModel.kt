package com.example.chownow.ui.main

import androidx.lifecycle.ViewModel
import com.example.chownow.repository.AppRepositoryImpl
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {}
