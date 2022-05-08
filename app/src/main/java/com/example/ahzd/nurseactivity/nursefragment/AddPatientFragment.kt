package com.example.ahzd.nurseactivity.nursefragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.App
import com.example.ahzd.R
import com.example.ahzd.di.DaggerGetPatientComponent
import com.example.ahzd.doctoractivity.viewmodel.GetPatientsViewModel
import com.example.ahzd.model.Patient
import com.example.ahzd.utils.daggerViewModels
import com.google.gson.annotations.SerializedName

class AddPatientFragment : Fragment(R.layout.addpatient) {

    val viewModel: GetPatientsViewModel by daggerViewModels { requireActivity() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerGetPatientComponent.builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        viewModel.message.observe(viewLifecycleOwner) {
            Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
        }

        val patientInfo = Patient(
            id = 101,
            name = "Adamek",
            surname = "Sopot",
            bed= 6,
            age =  25,
            doctor= 2222,
           image= "WWWW"
        )

        viewModel.insertPatient(patientInfo.id.toString(),patientInfo)
    }


}