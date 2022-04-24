package com.example.ahzd.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PatientResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String?,
    @SerializedName("surname") val surname: String?,
    @SerializedName("bad") val bad: Int?,
    @SerializedName("age") val age: Int?,
    @SerializedName("doctor") val doctor: Int?,
) : Serializable
