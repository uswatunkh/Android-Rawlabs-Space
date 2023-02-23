package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityMenuSectionBinding
import com.example.androidrawlabspace.databinding.ActivityNavigasiBinding

class Navigasi : ConstraintLayout{
    private lateinit var mContext: Context
    private lateinit var binding: ActivityNavigasiBinding

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        mContext = context
        binding = ActivityNavigasiBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.activity_navigasi , this, true))
    }

    fun Icon (icon: Int){
        val nomor = icon
        when (nomor){
            1 -> {
                binding.iconHome.setImageResource(R.drawable.homebtn)
            }
            2 -> {
                binding.iconSearch.setImageResource(R.drawable.searchbtn)
            }
            3 -> {
                binding.iconMssg.setImageResource(R.drawable.chatbtn)
            }
            4 -> {
                binding.iconProfil.setImageResource(R.drawable.iconprofilwarna)
            }
            else -> {
                Log.d("[PESAN]", "GAGAL MEMANGGIL")
            }
        }
    }
}