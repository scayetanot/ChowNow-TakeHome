package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName

data class OpeningHours(
        @SerializedName("day_id")
        var dayId: Int,
        @SerializedName("dow")
        var dow: String,
        @SerializedName("ranges")
        var ranges: List<RangeItem>
)