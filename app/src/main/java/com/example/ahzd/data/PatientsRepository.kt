package com.example.ahzd.data

import com.example.ahzd.model.PatientApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientsRepository @Inject constructor(
    private val api: PatientsApi,
) {

    suspend fun getApiResponse(query: String): PatientApiResponse = api.searchPatients(query)
}
