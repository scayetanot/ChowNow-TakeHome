package com.example.chownow.data.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantLocation (
    @SerializedName("id")
    var id: String,
    @SerializedName("address")
    var address: RestaurantAddress,
    @SerializedName("name")
    var name: String
) : Serializable
