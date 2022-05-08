package com.example.ahzd.doctoractivity.doctorfragment

import com.example.ahzd.model.PatientApiResponse

interface OnPatientClicked {
    fun onClick(patient:PatientApiResponse)
}