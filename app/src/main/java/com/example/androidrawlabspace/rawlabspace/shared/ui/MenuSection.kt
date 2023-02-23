package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityHeaderBinding
import com.example.androidrawlabspace.databinding.ActivityMenuSectionBinding

class MenuSection : ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ActivityMenuSectionBinding
    private val imageView: ImageView = binding.icon

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
        binding = ActivityMenuSectionBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.activity_menu_section , this, true))
    }

    fun setJuduldanIcon (judul: String, idGmbr: Int){
        binding.judulIcon.text = judul
        imageView.setImageResource(idGmbr)
    }
}