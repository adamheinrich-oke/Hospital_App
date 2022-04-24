package com.example.ahzd.doctoractivity.patientsdata

import com.example.ahzd.model.PatientApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PatientApi {

    companion object {
        const val BASE_URL = "http://192.168.0.206:3000/"
    }

    @GET("adamapi/get")
    suspend fun getPatients(
        @Query("q") query: String
    ): List<PatientApiResponse>
}