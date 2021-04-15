package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantAddress(
        @SerializedName("id")
        var id: Int,
        @SerializedName("street_address1")
        var streetAddress1: String?,
        @SerializedName("street_address2")
        var streetAddress2: String,
        @SerializedName("city")
        var city: String,
        @SerializedName("state")
        var state: String,
        @SerializedName("zip")
        var zip: String,
        @SerializedName("country")
        var country: String,
        @SerializedName("country_alpha2")
        var countryAlpha2: String,
        @SerializedName("geo")
        var geo: String,
        @SerializedName("latitude")
        var latitude: Double,
        @SerializedName("longitude")
        var longitude: Double,
        @SerializedName("name")
        var name: String,
        @SerializedName("address_string")
        var addressString: String,
        @SerializedName("formatted_address")
        var formattedAddress: String,
        @SerializedName("place_formatted_address")
        var placeFormattedAddress: String?,
        @SerializedName("is_google_place")
        var isGooglePlace: Boolean
) : Serializable