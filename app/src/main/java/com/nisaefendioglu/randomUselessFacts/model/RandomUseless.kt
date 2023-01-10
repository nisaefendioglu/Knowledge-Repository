package com.nisaefendioglu.randomUselessFacts.model

import com.google.gson.annotations.SerializedName

data class RandomUseless(
    @SerializedName("source")
    val source: String,
    @SerializedName("text")
    val text: String
)
