package com.example.dogbreeds.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogbreeds.databinding.ActivityMainBinding
import com.example.dogbreeds.ui.DogBreed.DogBreedFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
        .replace(binding.fragmentContainer.id, DogBreedFragment())
        .commit()


    }
}


