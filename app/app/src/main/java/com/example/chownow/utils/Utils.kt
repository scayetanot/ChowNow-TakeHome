package com.example.chownow.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID
import com.example.chownow.ui.main.MainActivity.Companion.RESTAURANT_ID


fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int, restaurantId: String, locationId: String) {
    val className = fragment.javaClass.name

    val bundle = Bundle()
    bundle.putString(RESTAURANT_ID, restaurantId)
    bundle.putString(LOCATION_ID, locationId)
    fragment.arguments = bundle

    supportFragmentManager
        .beginTransaction()
        .add(container, fragment, className)
        .addToBackStack(className.javaClass.name)
        .commit()
}

