package com.jagruti.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jagruti.myfirstapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val  name = intent.getStringExtra(SignInActivity.KEY_NAME).toString()
        val  email = intent.getStringExtra(SignInActivity.KEY_EMAIL)
        val  uid = intent.getStringExtra(SignInActivity.KEY_UID)

        binding.tvWelcome.text = "Welcome $name \n $email \n $uid"

    }
}