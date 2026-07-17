package com.jagruti.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference

    companion object {
        const val KEY_EMAIL = "com.jagruti.myfirstapp.SignInActivity.KEY_EMAIL"
        const val KEY_NAME = "com.jagruti.myfirstapp.SignInActivity.KEY_NAME"
        const val KEY_UID = "com.jagruti.myfirstapp.SignInActivity.KEY_UID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signInButton = findViewById<Button>(R.id.btnSignIn)
        val userId = findViewById<TextInputEditText>(R.id.tv_userid)

        signInButton.setOnClickListener {
            val userName = userId.text.toString()
            if (userName.isNotEmpty()) {
                readData(userName)
            } else {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun readData(userName: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {
            if (it.exists()) {
                val email = it.child("email").value.toString()
                val name = it.child("name").value.toString()
                val uid = it.child("uid").value.toString()
                val user = User(name, email, "", uid)

                val intentWelcome = Intent(this, HomeActivity::class.java)
                intentWelcome.putExtra(KEY_NAME, name)
                intentWelcome.putExtra(KEY_UID, uid)
                intentWelcome.putExtra(KEY_EMAIL, email)
                startActivity(intentWelcome)

            } else {
                Toast.makeText(this, "User does not exits, please first singup", Toast.LENGTH_LONG)
                    .show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}