package com.example.ahzd.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BedsPostResponse(
    @SerializedName("message") val message: String,
) : Serializable

