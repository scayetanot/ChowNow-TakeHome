package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName

data class FullfillmentItem(
        @SerializedName("dine_in")
        var dineIn: DineInItem
)