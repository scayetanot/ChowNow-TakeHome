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
    var name: String?,
    @SerializedName("allows_order_for_now")
    var allowsOrderForNow: String,
    @SerializedName("display_properties")
    var displayProperties: PropertiesItem,
    @SerializedName("fulfillment")
    var fulfillment: FullfillmentItem, //todo
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("cuisines")
    var cuisines: List<String>

) : Serializable
