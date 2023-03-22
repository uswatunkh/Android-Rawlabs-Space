package com.example.androidrawlabspace.rawlabspace.screen.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.LoginBinding
import com.example.androidrawlabspace.rawlabspace.screen.fragment.FragmentHome
import com.example.androidrawlabspace.rawlabspace.screen.fragment.FragmentMain
import com.example.androidrawlabspace.rawlabspace.screen.register.Register

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()


    }

    fun initView(){
        binding.editEmail.setEmail()
        binding.editEmail.setPlaceholder("Enter Email")
        binding.editEmail.setClickEdit()
       // binding.editEmail.setTypePassword()
        binding.editPassword.setPassword()
        binding.editPassword.setPlaceholder("Enter Password")
        binding.editPassword.setClickEdit()
        //binding.editPassword.setTypePassword(true)
//        binding.masuk.setOnClickListener{
//            presenter.login(binding.editUsername.getEditText().text.toString(), binding.editPassword.getEditText().text.toString())
//        }

        binding.buttonLogin.setOnClickListener{
            val intent = Intent(this, FragmentMain::class.java)
            startActivity(intent)
        }
        binding.createAkun.setOnClickListener{
            startActivity(Intent(this , Register::class.java))
        }


//        showDialog("Selamat! Akun Anda telah berhasil \n" +
//                "terdaftar di akun Sephora Banking. \n" +
//                "Silakan menikmati semua fitur Sephora Banking.")
    }
}