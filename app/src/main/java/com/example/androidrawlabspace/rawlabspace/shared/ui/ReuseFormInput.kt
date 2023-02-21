package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.content.Context
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ReuseForminputBinding


class ReuseFormInput: ConstraintLayout {
    private lateinit var mContext: Context
    private lateinit var binding: ReuseForminputBinding

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

        binding = ReuseForminputBinding.bind(LayoutInflater.from(mContext).inflate(R.layout.reuse_forminput , this, true))
    }

    fun setUsername() {
        binding.idedit.setText("Username")
        binding.idimage.setVisibility(GONE);
    }

    fun setPassword() {
        binding.idedit.setText("Password")
        binding.idimage.setVisibility(VISIBLE);
    }


    fun setPlaceholder(text:String){
        binding.idedit.hint = text
    }

    fun setTypePassword(isPassword: Boolean = false ){
        if (isPassword){
            binding.idedit.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)

            //binding.editText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            binding.idimage.setOnClickListener{
                if (isHiddenPass) {
                    binding.idedit.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    isHiddenPass = false
                    binding.idimage.setImageDrawable(resources.getDrawable(R.drawable.eyeclose))
                }else {
                    binding.idedit.transformationMethod = PasswordTransformationMethod.getInstance()
                    isHiddenPass = true
                    binding.idimage.setImageDrawable(resources.getDrawable(R.drawable.eyeclose))
                }
            }
        }else{
            binding.idimage.visibility = GONE
        }
    }

    fun getEditText() : EditText {
        return binding.idedit
    }
}
