package com.example.tutorial_implicit_intents_youtube

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.tutorial_implicit_intents_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val imgPhoto = binding.imgPhoto
        val btnChoosePhoto = binding.btnChoosePhoto

        val selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()) {
            imgPhoto.setImageURI(it)
        }

        btnChoosePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also{
                it.type = "image/*"
                selectImageFromGalleryResult.launch("image/*")

            }
        }

    }
}