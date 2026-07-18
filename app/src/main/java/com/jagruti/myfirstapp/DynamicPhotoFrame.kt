package com.jagruti.myfirstapp

import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jagruti.myfirstapp.databinding.ActivityDynamicPhotoFrameBinding
import kotlin.math.log

class DynamicPhotoFrame : AppCompatActivity() {
    lateinit var binding: ActivityDynamicPhotoFrameBinding

    var currentImage =0
    // Add/remove images here — that's the ONLY place you manage the image list
    private val images = listOf(
        R.drawable.virat,
        R.drawable.pic0,
        R.drawable.sachin,
        R.drawable.myimage
    )
    private val names = listOf(
       "Virat",
        "Dhoni",
       "Sachin",
        "Jagruti"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDynamicPhotoFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Show first image on screen load
        updateImage()

        binding.btnNext.setOnClickListener {
            currentImage = (currentImage + 1) % images.size
            Log.d("Current Image","btnNext $currentImage")
            updateImage()
        }

        binding.btnPrev.setOnClickListener {
            currentImage = (currentImage - 1 + images.size) % images.size
            Log.d("Current Image","btnPrev $currentImage")
            updateImage()
        }
    }
    private fun updateImage() {
        binding.ivPhoto.setImageResource(images[currentImage])
        binding.tvName.text = names[currentImage]
        Log.d("currentImage", "currentImage = $currentImage")
    }
}