package com.example.ahzd.data

import com.example.ahzd.model.BedsPostResponse
import com.example.ahzd.model.Patient
import com.example.ahzd.model.PatientApiResponse
import retrofit2.http.*

interface PatientsApi {

    companion object {
        const val BASE_URL = "http://192.168.0.206:3000/"
    }

    @GET("adamapi/get/4")
    suspend fun searchPatients(
        //@Query("/") query: String
    ): List<PatientApiResponse>

    @POST("adamapi/post/{id}")
    suspend fun insertPatient(
        @Path("id") query: String, @Body patient:Patient
    ): BedsPostResponse
}