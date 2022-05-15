package com.example.ahzd.doctoractivity.doctorfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ahzd.R

class PatientDetailsFragment : Fragment(R.layout.patientdetails) {

    private val args by navArgs<PatientDetailsFragmentArgs>()
    private lateinit var photo: ImageView
    private lateinit var namePatient: TextView
    private lateinit var age: TextView
    private lateinit var bed: TextView
    private lateinit var summary: TextView

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().apply {
            this@PatientDetailsFragment.photo = findViewById(R.id.patientImageView)
            this@PatientDetailsFragment.age = findViewById(R.id.patientAgeTextView)
            this@PatientDetailsFragment.namePatient = findViewById(R.id.patientNameTextView)
            this@PatientDetailsFragment.bed = findViewById(R.id.patientBedTextView)
            this@PatientDetailsFragment.summary = findViewById(R.id.patientSummaryTextView)
        }

        Glide.with(this@PatientDetailsFragment)
            .load(args.dane.patient.image).apply(RequestOptions.circleCropTransform())
            .into(this.photo)

        namePatient.text = args.dane.patient.name + " " + args.dane.patient.surname
        age.text = "Age:  " + (countAge(args.dane.patient.age ?: 0)).toString()
        bed.text = "Bed:  " + args.dane.patient.bed.toString() 
        summary.text = resources.getText(R.string.lorem_patient)
    }

    fun countAge(age: Int): Int {
        var ageInt = age
        return 2022 - ageInt
    }
}