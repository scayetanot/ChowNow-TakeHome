package com.example.chownow.data

import androidx.room.TypeConverter
import com.example.chownow.data.model.Locations
import com.example.chownow.data.model.RestaurantAddress
import com.example.chownow.data.model.RestaurantLocation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type

class RoomDataConverter : Serializable {

    @TypeConverter
    fun stringFromObject(list: RestaurantAddress?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getObjectFromString(jsonString: String?): RestaurantAddress? {
        val listType: Type = object : TypeToken<Locations?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }

    @TypeConverter
    fun stringFromListObject(list: List<RestaurantLocation?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun getListObjectFromString(jsonString: String?): List<RestaurantLocation?>? {
        val listType: Type = object : TypeToken<ArrayList<RestaurantLocation?>?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }
}