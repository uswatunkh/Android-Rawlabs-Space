package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityHeaderBinding
import com.example.androidrawlabspace.databinding.ActivityHeaderTempatBinding

class HeaderTempat : ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ActivityHeaderTempatBinding

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
        binding = ActivityHeaderTempatBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.activity_header_tempat , this, true))
    }
}