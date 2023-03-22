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
        binding.text.setText("Username")
        //binding.idedit.setText("Username")
        binding.idimage.setVisibility(GONE);
    }

    fun setEmail() {
        binding.text.setText("Email")
        //binding.idedit.setText("Username")
        binding.idimage.setVisibility(GONE);
    }

    fun setPassword() {
        binding.text.setText("Password")
        //binding.idedit.setText("Password")
        binding.idimage.setVisibility(VISIBLE);
    }


    fun setPlaceholder(text:String){
        binding.idedit.hint = text


    }

    fun setClickEdit(){

        binding.idedit.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
//                binding.idedit.setBackgroundColor(if (s.isEmpty()) originalColor else haveTextColor)
                binding.idedit.setBackgroundResource(if (s.isEmpty())R.drawable.rectangle_form else R.drawable.bgrndpolos)
            }

        })
        //binding.idedit.afterTextChanged { doSomethingWithText(it) }

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

    fun getBookingFullName(){
        binding.text.setText("FullName :")
        binding.idimage.setVisibility(GONE);
    }
    fun getBookingPhoneNumber(){
        binding.text.setText("Phone Number :")
        binding.idimage.setVisibility(GONE);
    }
    fun typeNumber(){
        binding.idedit.setInputType(InputType.TYPE_CLASS_PHONE)
    }
    fun getBookingEmail(){
        binding.text.setText("Email :")
        binding.idimage.setVisibility(GONE);
    }
    fun getBookingDate(){
        binding.text.setText("Date :")
        binding.idimage.setVisibility(GONE);
    }
    fun getBookingFrom(){
        binding.text.setText("From :")
        binding.idimage.setVisibility(GONE);
    }
    fun getBookingTo(){
        binding.text.setText("To :")
        binding.idimage.setVisibility(GONE);
    }



}
