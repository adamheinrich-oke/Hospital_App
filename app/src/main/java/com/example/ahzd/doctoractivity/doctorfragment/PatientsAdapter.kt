package com.example.ahzd.doctoractivity.doctorfragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ahzd.R
import com.example.ahzd.model.PatientApiResponse

class PatientsAdapter(private val listener: OnPatientClicked) :
    RecyclerView.Adapter<PatientsViewHolder>() {

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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: PatientsViewHolder,
        position: Int,
    ) {
        val patient = patients[position]
        holder.name.text = patient.patient.name + " " + patient.patient.surname
        Glide.with(holder.itemView.context).load(patient.patient.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.photo)

        holder.itemView.setOnClickListener {
            listener.onClick(patient)
        }
    }

    override fun getItemCount(): Int = patients.size
}