package com.example.ahzd.doctoractivity.doctorfragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R

class PatientsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name = itemView.findViewById(R.id.patientNameTextView) as TextView
    val photo = itemView.findViewById(R.id.patientImageView) as ImageView
}