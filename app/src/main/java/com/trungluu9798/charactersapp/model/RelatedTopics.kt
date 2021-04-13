package com.trungluu9798.charactersapp.model

import com.google.gson.annotations.SerializedName


data class RelatedTopics (
    @SerializedName("FirstURL") var firstURL : String,
    @SerializedName("Icon") var icon : Icon,
    @SerializedName("Result") var result : String,
    @SerializedName("Text") var text : String,
    var title: String = "",
    var description: String = ""
) {
    fun getTitleAndDescription() {
        title = text.substringBefore("-")
        description = text.substringAfter("- ")
    }
}