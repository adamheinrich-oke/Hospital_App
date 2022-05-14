package com.example.ahzd.doctoractivity.doctorfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.App
import com.example.ahzd.R
import com.example.ahzd.di.DaggerGetPatientComponent
import com.example.ahzd.doctoractivity.viewmodel.GetPatientsViewModel
import com.example.ahzd.model.PatientApiResponse
import com.example.ahzd.utils.daggerViewModels

class DoctorFragment : Fragment(R.layout.doctorfragment), OnPatientClicked {

    val viewModel: GetPatientsViewModel by daggerViewModels { requireActivity() }
    private val adapterPatients: PatientsAdapter = PatientsAdapter(this)
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        DaggerGetPatientComponent.builder()
            .appComponent((requireActivity().application as App).getAppComponent())
            .build()
            .inject(this)

        recyclerView = requireView().findViewById(R.id.recycler_view)
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = adapterPatients
        }

        viewModel.patientsLiveData.observe(viewLifecycleOwner) {
            adapterPatients.setPatientList(it)
        }

        viewModel.getPatients()

    }

    override fun onClick(patient: PatientApiResponse) {

    }
}