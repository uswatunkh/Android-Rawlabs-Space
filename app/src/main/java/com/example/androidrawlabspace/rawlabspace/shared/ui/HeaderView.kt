package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityHeaderBinding
import com.example.androidrawlabspace.databinding.ReuseForminputBinding

class HeaderView : ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ActivityHeaderBinding

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
        binding = ActivityHeaderBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.activity_header , this, true))
    }

    fun setTitle (title: String){
        binding.titleHeader.text = title
    }
}