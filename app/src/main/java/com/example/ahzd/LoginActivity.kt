package com.example.ahzd

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ahzd.doctoractivity.DoctorActivity
import com.example.ahzd.nurseactivity.NurseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    private lateinit var loginButton: Button
    private lateinit var userNameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")

        loginButton = findViewById(R.id.submitButton)
        userNameEditText = findViewById(R.id.userNameTextField)
        passwordEditText = findViewById(R.id.passwordTextField)
        signUpButton = findViewById(R.id.SignUpButton)

        login()

    }

    private fun login() {
        loginButton.setOnClickListener {
            when {
                TextUtils.isEmpty(userNameEditText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(passwordEditText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = userNameEditText.text.toString().trim { it < ' ' }
                    val password: String = passwordEditText.text.toString().trim { it < ' ' }

                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {

                                val user = auth.currentUser
                                val userReference = databaseReference?.child(user?.uid!!)
                                userReference?.addValueEventListener(
                                    object : ValueEventListener {
                                        override fun onDataChange(snapshot: DataSnapshot) {
                                            val occupancy =
                                                snapshot.child("occupancy").value.toString()
                                            if (occupancy == "Nurse") {
                                                val intent = Intent(
                                                    applicationContext,
                                                    NurseActivity::class.java
                                                )
                                                finish()

                                                startActivity(intent)
                                            } else {
                                                //
                                                val intent = Intent(
                                                    applicationContext,
                                                    DoctorActivity::class.java
                                                )
                                                finish()

                                                startActivity(intent)
                                            }

                                        }

                                        override fun onCancelled(error: DatabaseError) {
                                            TODO("Not yet implemented")
                                        }
                                    }
                                )
                               // finish()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Something went wrong",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
        signUpButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))

        }
    }
}