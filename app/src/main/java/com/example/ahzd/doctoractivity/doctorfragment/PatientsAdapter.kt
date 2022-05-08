package com.example.ahzd.doctoractivity.doctorfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ahzd.R
import com.example.ahzd.model.PatientApiResponse

class PatientsAdapter(private val listener: OnPatientClicked) : RecyclerView.Adapter<PatientsViewHolder>() {

    var patients = mutableListOf<PatientApiResponse>()

    fun setPatientList(patients: List<PatientApiResponse>) {
        this.patients = patients.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PatientsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.patient_item, parent, false)
        return PatientsViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PatientsViewHolder,
        position: Int,
    ) {
        val patient = patients[position]
        holder.name.text = patient.patient.name
        holder.age.text = patient.patient.age.toString()
        Glide.with(holder.itemView.context).load(patient.patient.image)
            .into(holder.photo)


        //   holder.itemView.setOnClickListener {
        //listener.onClick(patient) }
        // }
    }
    override fun getItemCount(): Int = patients.size
}