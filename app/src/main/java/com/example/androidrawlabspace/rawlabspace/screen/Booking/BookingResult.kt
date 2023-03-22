package com.example.androidrawlabspace.rawlabspace.screen.Booking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.BookingPaymentBinding
import com.example.androidrawlabspace.databinding.BookingResultBinding

class BookingResult : AppCompatActivity() {

    private lateinit var binding: BookingResultBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_result)
        binding = BookingResultBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }
}