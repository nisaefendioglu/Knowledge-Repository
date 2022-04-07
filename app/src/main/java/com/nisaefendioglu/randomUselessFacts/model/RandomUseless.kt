package com.nisaefendioglu.randomUselessFacts.model


import com.google.gson.annotations.SerializedName

data class RandomUseless(
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("source_url")
    val sourceUrl: String,
    @SerializedName("text")
    val text: String
)