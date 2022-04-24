package com.example.ahzd.data

import com.example.ahzd.model.PatientApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PatientsApi {

    companion object {
        const val BASE_URL = "http://192.168.0.206:3000/"
    }

    @GET("adamapi/get/4")
    suspend fun searchPatients(
        //@Query("/") query: String
    ): List<PatientApiResponse>
}