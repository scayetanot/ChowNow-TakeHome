package com.example.chownow.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chownow.R
import com.example.chownow.ui.details.LocationDetailsFragment
import com.example.chownow.ui.list.LocationsListFragment
import com.example.chownow.ui.list.OnLocationSelectedListener
import com.example.chownow.utils.replaceFragment

class MainActivity : AppCompatActivity(), OnLocationSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.listcontainer, LocationsListFragment())
                .commitAllowingStateLoss()
        }
    }

    override fun onLocationSelected(restaurantId: String, locationId: String) {
        replaceFragment(LocationDetailsFragment(), R.id.listcontainer, restaurantId, locationId)
    }

    companion object {
        val RESTAURANT_ID: String = "restaurant_id"
        val LOCATION_ID: String = "location_id"
    }
}