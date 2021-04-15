package com.example.chownow.data.model

import com.google.gson.annotations.SerializedName

data class PropertiesItem (
        @SerializedName("menu_disclaimer")
        var disclaimer: String,
        @SerializedName("enable_special_instructions")
        var enableInstructions: Boolean,
        @SerializedName("special_instructions_text")
        var instructions: String
)