package com.example.ahzd.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PatientApiResponse(
    @SerializedName("patient") val patient: Patient,
) : Serializable

