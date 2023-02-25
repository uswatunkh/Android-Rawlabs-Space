package com.example.androidrawlabspace.rawlabspace.profil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidrawlabspace.MainActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityMainProfileBinding

class MainProfile : AppCompatActivity() {
    private lateinit var binding: ActivityMainProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_profile)
        initView()
//        binding.editIcon.setOnClickListener{startActivity(Intent(this, MainActivity::class.java))}
    }

    fun initView(){
//        binding.editIcon.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//        if(::binding.isInitialized){
//            binding.editIcon.setOnClickListener {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//        } else {
//            Log.d("[EROR]", "[Belum diinstal]")
//        }
    }
}