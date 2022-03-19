package com.example.ahzd

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var signUpButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var occupancyEditText: EditText

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("profile")
        signUpButton = findViewById(R.id.submitButton)
        emailEditText = findViewById(R.id.userNameTextField)
        passwordEditText = findViewById(R.id.passwordTextField)
        occupancyEditText = findViewById(R.id.occupancyEditText)

        signUpButton.setOnClickListener {
            when {
                TextUtils.isEmpty(emailEditText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(passwordEditText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = emailEditText.text.toString().trim { it < ' ' }
                    val password: String = passwordEditText.text.toString().trim { it < ' ' }
                    val occupancy : String = occupancyEditText.text.toString().trim { it < ' ' }
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val currentUser = auth.currentUser
                            val currentUserDb = databaseReference?.child((currentUser?.uid!!))
                            currentUserDb?.child("occupancy")?.setValue(occupancy)
                            Toast.makeText(
                                this@RegisterActivity,
                                "Registration complete!",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()

                        } else {
                            Toast.makeText(
                                this@RegisterActivity,
                                "Registration failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                }

            }

        }
    }
}