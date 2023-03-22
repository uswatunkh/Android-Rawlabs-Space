package com.example.androidrawlabspace.rawlabspace.screen.onboarding

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ErrorStateBinding
import com.example.androidrawlabspace.databinding.OnboardBinding
import com.example.androidrawlabspace.rawlabspace.screen.login.LoginActivity

class Onboard : AppCompatActivity() {

    private lateinit var binding : OnboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ruang)
        binding = OnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getstarted.setOnClickListener{
            startActivity(Intent(this , LoginActivity::class.java))

        }
        if (checkForInternet(this)) {
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show()
            showDialogErrorState()
        }


    }

    private fun checkForInternet(context: Context): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // if the android version is equal to M
        // or greater we need to use the
        // NetworkCapabilities to check what type of
        // network has the internet connection
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            // Returns a Network object corresponding to
            // the currently active default data network.
            val network = connectivityManager.activeNetwork ?: return false

            // Representation of the capabilities of an active network.
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                // Indicates this network uses a Wi-Fi transport,
                // or WiFi has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

                // Indicates this network uses a Cellular transport. or
                // Cellular has network connectivity
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                // else return false
                else -> false
            }
        } else {
            // if the android version is below M
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION")
            return networkInfo.isConnected
        }
    }

    fun showDialogErrorState() {

        val dialog = Dialog(this)
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()



        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1200);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);

        binding2.btnError.setOnClickListener{
            val wifi = getSystemService(WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = true
        }
    }
}