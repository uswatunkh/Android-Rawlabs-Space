package com.example.androidrawlabspace.rawlabspace.submitreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityMainSubmitReviewBinding

class MainSubmitReview : AppCompatActivity() {
    private lateinit var binding: ActivityMainSubmitReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSubmitReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}