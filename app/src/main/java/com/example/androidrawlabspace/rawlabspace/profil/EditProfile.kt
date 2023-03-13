package com.example.androidrawlabspace.rawlabspace.profil

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityEditProfileBinding
import com.example.androidrawlabspace.databinding.ChangeProfilBtnSheetBinding

class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        binding.iconKamera.setOnClickListener { showDialog() }
    }

    fun init(){
        binding.fullName.setTitle("Full Name")
        binding.fullName.setHint("Gloria Grace Tanama")
        binding.fullName.setTypePassword()

        binding.phoneNumber.setTitle("Phone Number")
        binding.phoneNumber.setHint("082230913782")
        binding.phoneNumber.setTypePassword()

        binding.Email.setTitle("Email")
        binding.Email.setHint("gloriatanama@gmail.com")
        binding.Email.setTypePassword()
    }

    fun showDialog(){
        val dialog = Dialog(this)
        val binding2 = ChangeProfilBtnSheetBinding.bind(layoutInflater.inflate(R.layout.change_profil_btn_sheet, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()

        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

        binding2.uploadImage.setOnClickListener { dialog.dismiss() }
    }
}