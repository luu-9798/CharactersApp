package com.trungluu9798.charactersapp.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("Abstract") var abstract : String,
    @SerializedName("AbstractSource") var abstractSource : String,
    @SerializedName("AbstractText") var abstractText : String,
    @SerializedName("AbstractURL") var abstractURL : String,
    @SerializedName("Answer") var answer : String,
    @SerializedName("AnswerType") var answerType : String,
    @SerializedName("Definition") var definition : String,
    @SerializedName("DefinitionSource") var definitionSource : String,
    @SerializedName("DefinitionURL") var definitionURL : String,
    @SerializedName("Entity") var entity : String,
    @SerializedName("Heading") var heading : String,
    @SerializedName("Image") var image : String,
    @SerializedName("ImageHeight") var imageHeight : Int,
    @SerializedName("ImageIsLogo") var imageIsLogo : Int,
    @SerializedName("ImageWidth") var imageWidth : Int,
    @SerializedName("Infobox") var infobox : String,
    @SerializedName("Redirect") var redirect : String,
    @SerializedName("RelatedTopics") var relatedTopics : List<RelatedTopics>,
    @SerializedName("Results") var results : List<String>,
    @SerializedName("Type") var Type : String
)