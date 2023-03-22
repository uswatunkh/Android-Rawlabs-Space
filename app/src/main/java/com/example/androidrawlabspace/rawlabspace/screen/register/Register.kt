package com.example.androidrawlabspace.rawlabspace.screen.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.LoginBinding
import com.example.androidrawlabspace.databinding.RegisterBinding
import com.example.androidrawlabspace.rawlabspace.screen.login.LoginActivity
import com.example.androidrawlabspace.rawlabspace.shared.ui.DialogBottomsheet

class Register : AppCompatActivity() {

    private lateinit var binding : RegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        binding = RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()


    }

    fun initView(){
        binding.editUsername.setUsername()
        binding.editUsername.setPlaceholder("Gloria Grace Tanama")
        binding.editUsername.setClickEdit()
        binding.editEmail.setEmail()
        binding.editEmail.setPlaceholder("Enter Email")
        // binding.editEmail.setTypePassword()
        binding.editEmail.setClickEdit()
        binding.editPassword.setPassword()
        binding.editPassword.setPlaceholder("Enter Password")
        //binding.editPassword.setTypePassword(true)
        binding.editPassword.setClickEdit()
//        binding.masuk.setOnClickListener{
//            presenter.login(binding.editUsername.getEditText().text.toString(), binding.editPassword.getEditText().text.toString())
//        }
        binding.signIn.setOnClickListener{
            startActivity(Intent(this , LoginActivity::class.java))
        }


//        showDialog("Selamat! Akun Anda telah berhasil \n" +
//                "terdaftar di akun Sephora Banking. \n" +
//                "Silakan menikmati semua fitur Sephora Banking.")
    }
}