package com.example.ahzd.doctoractivity.doctorfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.App
import com.example.ahzd.R
import com.example.ahzd.di.DaggerGetPatientComponent
import com.example.ahzd.doctoractivity.viewmodel.GetPatientsViewModel
import com.example.ahzd.utils.daggerViewModels

class DoctorFragment:Fragment(R.layout.doctorfragment) {

    val viewModel: GetPatientsViewModel by daggerViewModels { requireActivity() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerGetPatientComponent.builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        viewModel.patientsLiveData.observe(viewLifecycleOwner) {
            Log.d("Response",it.toString())
        }
         viewModel.getPatients()

    }


}