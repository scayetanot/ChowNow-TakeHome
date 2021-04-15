package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName

data class RangeItem (
        @SerializedName("from")
        var from: String?,
        @SerializedName("to")
        var to: String?
)