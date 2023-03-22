package com.example.androidrawlabspace.rawlabspace.screen.PeopleAlsoView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.RuangBinding
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangAdapter
import com.example.androidrawlabspace.rawlabspace.shared.ui.RuangItem

class PeopleAlsoView : AppCompatActivity() {

    private lateinit var binding : RuangBinding

    private lateinit var ruanglist : ArrayList<RuangItem>
    private lateinit var ruangAdapter: RuangAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ruang)
        binding = RuangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(this)

        ruanglist = ArrayList()

        ruanglist.add(RuangItem(R.drawable.pic ,"Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        ruangAdapter = RuangAdapter(ruanglist)
        binding.recycler.adapter = ruangAdapter


    }
}