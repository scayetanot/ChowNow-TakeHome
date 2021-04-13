package com.example.chownow

import android.app.Application
import com.example.chownow.di.component.AppComponents
import com.example.chownow.di.component.DaggerAppComponents
import com.example.chownow.di.modules.AppModule
import com.example.chownow.di.modules.StorageModule

open class MainApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponents
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger(this)
       // InternetUtil.init(this)
    }

    private fun initDagger(app: MainApplication): AppComponents =
        DaggerAppComponents.builder()
            .appModule(AppModule(app))
            .storageModule(StorageModule(app))
            .build()
}