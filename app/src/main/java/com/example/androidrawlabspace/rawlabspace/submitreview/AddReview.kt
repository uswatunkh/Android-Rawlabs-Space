package com.example.androidrawlabspace.rawlabspace.submitreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidrawlabspace.databinding.ActivityAddReviewBinding

class AddReview : AppCompatActivity() {
    private lateinit var binding: ActivityAddReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init ()
    }

    fun init(){
        binding.header.setTitle("Rate & Review")
    }
}