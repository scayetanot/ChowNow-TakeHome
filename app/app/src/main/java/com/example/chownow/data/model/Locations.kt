package com.example.chownow.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Locations", primaryKeys = ["id"])
data class Locations(
    @SerializedName("id")
    var id: String,
    @SerializedName("address")
    var address: RestaurantAddress,
    @SerializedName("delivery_only")
    var deliveryOnly: Boolean,
    @SerializedName("has_apple_pay_enabled")
    var hasApplePayEnabled: Boolean,
    @SerializedName("is_multi_concept")
    var isMultiConcept: Boolean,
    @SerializedName("locations")
    var locations: List<RestaurantLocation>,
    @SerializedName("name")
    var name: String,
    @SerializedName("phone")
    var phone: String
)