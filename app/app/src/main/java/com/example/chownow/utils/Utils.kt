package com.example.chownow.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID


fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int, id: String) {
    val className = fragment.javaClass.name

    val bundle = Bundle()
    bundle.putString(LOCATION_ID, id)
    fragment.arguments = bundle

    supportFragmentManager
        .beginTransaction()
        .replace(container, fragment, className)
        .addToBackStack(className)
        .commit()
}

