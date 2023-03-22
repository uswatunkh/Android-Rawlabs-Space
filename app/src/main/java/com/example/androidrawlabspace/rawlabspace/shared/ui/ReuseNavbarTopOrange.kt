package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ReuseHeaderDialogBinding
import com.example.androidrawlabspace.databinding.ReuseNavbarTopOrangeBinding

class ReuseNavbarTopOrange : ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ReuseNavbarTopOrangeBinding

    var isHiddenPass = false

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

        binding = ReuseNavbarTopOrangeBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.reuse_navbar_top_orange , this, true))
    }


}
