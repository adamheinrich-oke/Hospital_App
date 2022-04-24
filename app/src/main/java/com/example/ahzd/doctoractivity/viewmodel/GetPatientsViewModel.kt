package com.example.ahzd.doctoractivity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ahzd.data.PatientsRepository
import com.example.ahzd.model.PatientApiResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetPatientsViewModel @Inject constructor(
    private val api: PatientsRepository,
) : ViewModel() {

    private val _patientsLiveData = MutableLiveData<PatientApiResponse>()
    val patientsLiveData = _patientsLiveData as LiveData<PatientApiResponse>

    fun getPatients(query: String) {
        viewModelScope.launch {
            val response = api.getApiResponse(query)
            _patientsLiveData.postValue(response)
        }
    }
}
