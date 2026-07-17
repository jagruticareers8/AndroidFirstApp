package com.jagruti.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val  name = intent.getStringExtra(SignInActivity.KEY_NAME).toString()
        val  email = intent.getStringExtra(SignInActivity.KEY_EMAIL)
        val  uid = intent.getStringExtra(SignInActivity.KEY_UID)

        val welcomeText = findViewById<TextView>(R.id.tv_welcome)
        welcomeText.text = "Welcome $name \n $email \n $uid"

    }
}