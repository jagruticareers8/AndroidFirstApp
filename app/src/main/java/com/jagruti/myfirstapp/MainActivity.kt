package com.jagruti.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSend = findViewById<Button>(R.id.btnSend)
        val etMail = findViewById<EditText>(R.id.etMail)
        val etName = findViewById<EditText>(R.id.etName)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etUserName = findViewById<EditText>(R.id.etUserName)
        val tvSignIn = findViewById<TextView>(R.id.tvSignIn)

        btnSend.setOnClickListener {
            val name = etName.text.toString()
            val mail =etMail.text.toString()
            val uid= etUserName.text.toString()
            val  pwd = etPassword.text.toString()

            val  user = User(name,mail,pwd,uid)

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uid).setValue(user).addOnSuccessListener {
                etName.text.clear()
                etMail.text.clear()
                etPassword.text.clear()
                etUserName.text.clear()

                Toast.makeText(this, "User Registered", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()

            }
        }
        tvSignIn.setOnClickListener {
            val intentSignIn = Intent(this, SignInActivity::class.java)
            startActivity(intentSignIn)
        }


    }
}