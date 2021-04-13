package com.example.chownow.di.modules

import com.example.chownow.api.ApiService
import com.example.chownow.data_source.LocalDataSourceDataObject
import com.example.chownow.data_source.LocalDataSourceRoomDb
import com.example.chownow.data_source.RemoteDataSourceImpl
import com.example.chownow.di.IoDispatcher
import com.example.chownow.repository.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: ApiService,
        localData: LocalDataSourceRoomDb
    ): AppRepositoryImpl {
        val userDataSource = RemoteDataSourceImpl(api, ioDispatcher)
        return AppRepositoryImpl(userDataSource, localData, ioDispatcher)
    }
}