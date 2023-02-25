package com.example.androidrawlabspace.rawlabspace.profil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }
}