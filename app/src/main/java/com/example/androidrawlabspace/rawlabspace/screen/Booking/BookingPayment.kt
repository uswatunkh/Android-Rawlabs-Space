package com.example.androidrawlabspace.rawlabspace.screen.Booking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.BookingBinding
import com.example.androidrawlabspace.databinding.BookingPaymentBinding
import com.example.androidrawlabspace.rawlabspace.screen.PeopleAlsoView.PeopleAlsoView
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangItem

class BookingPayment : AppCompatActivity() {

    private lateinit var binding: BookingPaymentBinding

    var fullname :String =""
    var phone :String =""
    var email :String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_payment)
        binding = BookingPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)



        fullname=intent.getStringExtra("fullname").toString()
        binding.fullName.setText(fullname)

        phone=intent.getStringExtra("phonenumber").toString()
        binding.phoneNumber.setText(phone)

        email=intent.getStringExtra("email").toString()
        binding.email.setText(email)


        binding.procesPayment.setOnClickListener{

            val intent = Intent(this, BookingPaymentDetail ::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
}