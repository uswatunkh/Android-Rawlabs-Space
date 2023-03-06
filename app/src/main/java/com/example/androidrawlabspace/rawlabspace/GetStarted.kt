package com.example.androidrawlabspace.rawlabspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidrawlabspace.databinding.ActivityGetStartedBinding

class GetStarted : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}