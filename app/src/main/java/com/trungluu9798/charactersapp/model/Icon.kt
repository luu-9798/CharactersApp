package com.trungluu9798.charactersapp.model

import com.google.gson.annotations.SerializedName

data class Icon (
    @SerializedName("Height") var height : String,
    @SerializedName("URL") var url : String,
    @SerializedName("Width") var width : String
)