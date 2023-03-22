package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ReuseHeaderDialogBinding
import com.example.androidrawlabspace.databinding.ReuseNavbarTopOrangeBinding

class ReuseHeaderDialog : ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ReuseHeaderDialogBinding

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

        binding = ReuseHeaderDialogBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.reuse_header_dialog , this, true))
    }


}
