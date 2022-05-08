package com.example.ahzd.data

import com.example.ahzd.model.BedsPostResponse
import com.example.ahzd.model.Patient
import com.example.ahzd.model.PatientApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientsRepository @Inject constructor(
    private val api: PatientsApi,
) {

    suspend fun getApiResponse(): List<PatientApiResponse> = api.searchPatients()
    suspend fun  getPostApiResponse(query:String,patient: Patient): BedsPostResponse = api.insertPatient(query, patient)
}
