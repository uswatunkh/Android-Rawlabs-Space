package com.example.androidrawlabspace.rawlabspace.screen.Booking

import android.app.Dialog
import android.content.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.BookingPaymentDetailBinding
import com.example.androidrawlabspace.databinding.LoadingDialogBinding


class BookingPaymentDetail : AppCompatActivity() {

    private lateinit var binding: BookingPaymentDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.booking_payment_detail)
        binding = BookingPaymentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.copyPaste.setOnClickListener{
            val textToCopy = binding.textCopy.text
            val clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData = ClipData.newPlainText("label", textToCopy)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()

            showDialog()
        }



    }

    fun showDialog() {
        // custom dialog
        val dialog = Dialog(this)
        val binding = LoadingDialogBinding.bind(layoutInflater.inflate(R.layout.loading_dialog, null))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1000);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(binding.root)


        dialog.show()

        val handler = Handler()
        val runnable = Runnable {
            if (dialog.isShowing()) {
                dialog.dismiss()
                val intent = Intent(this, BookingResult ::class.java)
                // start your next activity
                startActivity(intent)
            }
        }

        dialog.setOnDismissListener(DialogInterface.OnDismissListener {
            handler.removeCallbacks(
                runnable
            )
        })

        handler.postDelayed(runnable, 10000)



    }
}