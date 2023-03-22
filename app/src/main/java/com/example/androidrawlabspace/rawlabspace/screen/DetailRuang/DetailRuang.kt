package com.example.androidrawlabspace.rawlabspace.screen.DetailRuang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.DetailRuangBinding
import com.example.androidrawlabspace.databinding.RegisterBinding
import com.example.androidrawlabspace.rawlabspace.screen.Booking.Booking
import com.example.androidrawlabspace.rawlabspace.screen.PeopleAlsoView.PeopleAlsoView
import com.example.androidrawlabspace.rawlabspace.screen.fragment.FragmentMain
import com.example.androidrawlabspace.rawlabspace.screen.login.LoginActivity
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangHomeItem
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangItem

class DetailRuang : AppCompatActivity() {

    private lateinit var binding: DetailRuangBinding
    private lateinit var ruanglist : ArrayList<RuangItem>
    private lateinit var ruangAdapter: RuangAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_ruang)
        binding = DetailRuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail_ruang = intent.getParcelableExtra<RuangHomeItem>("ruanghome")
        if(detail_ruang !=null){

            binding.card.setImageResource(detail_ruang.image)
            binding.ruang.text=detail_ruang.ruang
            binding.harga.text=detail_ruang.harga
            binding.jalan.text=detail_ruang.jalan
            binding.hour.text=detail_ruang.day
        }

        binding.submitBooking.setOnClickListener{
            val intent = Intent(this, Booking::class.java)
            startActivity(intent)
        }
        binding.seepeople.setOnClickListener{
            val intent = Intent(this, PeopleAlsoView::class.java)
            startActivity(intent)
        }

        binding.recyclerBottom.setHasFixedSize(true)
        binding.recyclerBottom.layoutManager = LinearLayoutManager(this)

        ruanglist = ArrayList()

        ruanglist.add(RuangItem(R.drawable.pic ,"Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        ruangAdapter = RuangAdapter(ruanglist)
        binding.recyclerBottom.adapter = ruangAdapter
    }
}