package com.example.ahzd.doctoractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ahzd.R

class DoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_doctor)
    }
}