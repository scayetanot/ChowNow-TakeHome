package com.example.chownow.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chownow.R
import com.example.chownow.ui.list.LocationsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.listcontainer, LocationsListFragment())
                .commitAllowingStateLoss()
        }
    }
}