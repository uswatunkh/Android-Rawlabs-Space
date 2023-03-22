package com.example.androidrawlabspace.rawlabspace.screen.Booking

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.BookingBinding
import com.example.androidrawlabspace.databinding.ErrorStateBinding
import com.example.androidrawlabspace.databinding.RuangBinding
import com.example.androidrawlabspace.databinding.SelectAddressBinding
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangItem
import com.example.androidrawlabspace.rawlabspace.shared.ui.SearchAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.SearchItem
import java.util.*
import kotlin.collections.ArrayList

class Booking : AppCompatActivity() {

    private lateinit var binding : BookingBinding

    var fullname :String =""
    var phoneNumber :String =""
    var email :String =""

    private lateinit var ruanglist : ArrayList<RuangItem>
    private lateinit var ruangAdapter: RuangAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking)
        binding = BookingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()


        binding.date.setOnClickListener{
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                //textView.setText("" + dayOfMonth + " " + month + ", " + year)
            }, year, month, day)
            dpd.show()

        }
        binding.submitBooking.setOnClickListener{
            val intent = Intent(this, BookingPayment ::class.java)
            // start your next activity
            fullname=binding.fullName.getEditText().text.toString()
            intent.putExtra("fullname", fullname)

            phoneNumber=binding.phoneNumber.getEditText().text.toString()
            intent.putExtra("phonenumber", phoneNumber)
            startActivity(intent)

            email=binding.email.getEditText().text.toString()
            intent.putExtra("email", email)
            startActivity(intent)





        }



    }

    fun showDialogDate() {

        val dialog = Dialog(this)
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in TextView
            //textView.setText("" + dayOfMonth + " " + month + ", " + year)
        }, year, month, day)
        dpd.show()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()



        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1200);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);

    }

    fun initView(){
        binding.fullName.getBookingFullName()
        binding.fullName.setPlaceholder("Enter Full Name")
        binding.phoneNumber.getBookingPhoneNumber()
        binding.phoneNumber.setPlaceholder("Enter Phone Number")
        binding.phoneNumber.typeNumber()
        binding.email.getBookingEmail()
        binding.email.setPlaceholder("Enter Email")
        binding.date.getBookingDate()
        binding.date.setPlaceholder("Select Date")
        binding.from.getBookingFrom()
        binding.from.setPlaceholder("Select Time")
        binding.to.getBookingTo()
        binding.to.setPlaceholder("Select Time")
    }



}