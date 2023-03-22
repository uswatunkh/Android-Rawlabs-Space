package com.example.androidrawlabspace.rawlabspace.screen.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.FragmentMainBinding

class FragmentMain : AppCompatActivity() {

    private lateinit var binding : FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FragmentHome())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(FragmentHome())
                R.id.search -> replaceFragment(FragmentSearch())
                R.id.booking -> replaceFragment(FragmentBooking())
                R.id.profile -> replaceFragment(FragmentProfile())

                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}