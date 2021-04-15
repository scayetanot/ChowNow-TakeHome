package com.example.chownow.utils

import android.os.Bundle
import android.text.format.DateFormat
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chownow.ui.main.MainActivity.Companion.LOCATION_ID
import com.example.chownow.ui.main.MainActivity.Companion.RESTAURANT_ID
import com.google.i18n.phonenumbers.PhoneNumberUtil
import java.util.*


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

fun remainingTime(timestamp: String): String {
    val cal = Calendar.getInstance(Locale.ENGLISH)
    cal.timeInMillis = (timestamp.toLong() * 1000) - System.currentTimeMillis()

    return DateFormat.format("hh:mm:ss a", cal).toString()
}

fun formatPhoneNumber(number: String?, format: String = Locale.getDefault().country): String {
    val pnu = PhoneNumberUtil.getInstance()
    val pn = pnu.parse(number, format)
    return pnu.format(pn, PhoneNumberUtil.PhoneNumberFormat.E164)
}

