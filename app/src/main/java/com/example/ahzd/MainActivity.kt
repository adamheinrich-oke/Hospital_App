package com.example.ahzd

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ahzd.nurseactivity.NurseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        load()

    }

    private fun load() {
        val user = auth.currentUser
        val userReference = databaseReference?.child(user?.uid!!)
        userReference?.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val occupancy = snapshot.child("occupancy").value.toString()
                    if (occupancy == "Nurse") {
                        val intent = Intent(applicationContext, NurseActivity::class.java)
                        startActivity(intent)
                    } else {
                        //
                        val intent = Intent(applicationContext, NurseActivity::class.java)
                        startActivity(intent)
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )

    }
}