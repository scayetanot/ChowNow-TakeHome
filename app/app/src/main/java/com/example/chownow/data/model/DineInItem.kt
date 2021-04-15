package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName

data class DineInItem (
    @SerializedName("is_available_now")
    var isAvailableNow: Boolean,
    @SerializedName("next_closed_time")
    var nextClosedTime: String //,
//    @SerializedName("display_hours")
//    var displayHours: List<OpeningHours>
)