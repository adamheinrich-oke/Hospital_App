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

    private val _patientsLiveData = MutableLiveData<List<PatientApiResponse>>()
    val patientsLiveData = _patientsLiveData as LiveData<List<PatientApiResponse>>

    fun getPatients() {
        viewModelScope.launch {
            val response = api.getApiResponse()
            _patientsLiveData.postValue(response)
        }
    }
}
