package com.example.evilinsult.models


import com.google.gson.annotations.SerializedName

data class Insulto(
    @SerializedName("active")
    var active: String = "",
    @SerializedName("comment")
    var comment: String = "",
    @SerializedName("created")
    var created: String = "",
    @SerializedName("createdby")
    var createdby: String = "",
    @SerializedName("insult")
    var insult: String = "",
    @SerializedName("language")
    var language: String = "",
    @SerializedName("number")
    var id: String = "",
    @SerializedName("shown")
    var shown: String = "",

)