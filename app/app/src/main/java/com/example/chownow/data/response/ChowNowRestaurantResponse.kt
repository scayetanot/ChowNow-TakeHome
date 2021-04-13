package com.example.chownow.data.response

import com.example.chownow.data.model.RestaurantAddress
import com.example.chownow.data.model.RestaurantLocation
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ChowNowRestaurantResponse(
        @SerializedName("id")
        var id: String,
        @SerializedName("address")
        var address: RestaurantAddress,
        @SerializedName("android_app_url")
        var androidAppUrl: String,
        @SerializedName("delivery_only")
        var deliveryOnly: Boolean,
        @SerializedName("has_apple_pay_enabled")
        var hasApplePayEnabled: Boolean,
        @SerializedName("ios_app_store_id")
        var iosAppStoreId: String,
        @SerializedName("is_multi_concept")
        var isMultiConcept: Boolean,
        @SerializedName("locations")
        var locations: List<RestaurantLocation>,
        @SerializedName("name")
        var name: String,
        @SerializedName("phone")
        var phone: String,
        @SerializedName("processor_key")
        var processorKey: String
) : Serializable