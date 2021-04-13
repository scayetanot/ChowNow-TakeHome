package com.example.chownow.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chownow.ui.details.LocationDetailsFragment
import com.example.chownow.ui.details.LocationDetailsFragmentViewModel
import com.example.chownow.ui.list.ListLocationsFragmentViewModel
import com.example.chownow.ui.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityVM(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListLocationsFragmentViewModel::class)
    abstract fun bindListLocationsFragmentVM(listLocationsFragmentViewModel: ListLocationsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationDetailsFragmentViewModel::class)
    abstract fun bindLocationDetailsFragmentVM(locationDetailsFragmentViewModel: LocationDetailsFragmentViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

}