package com.example.androidrawlabspace.rawlabspace.submitreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivityMainSubmitReviewBinding
import com.example.androidrawlabspace.rawlabspace.shared.ui.SearchItem

class MainSubmitReview : AppCompatActivity() {
    private lateinit var binding: ActivityMainSubmitReviewBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var reviewList: ArrayList<ReviewItem>
    private lateinit var reviewAdapter: AdapterReview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSubmitReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init(){
        binding.seeAll.setOnClickListener { startActivity(Intent(this, SeeAllReview::class.java))}
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        reviewList = ArrayList()

        reviewList.add(ReviewItem(R.drawable.sulistyo, "Sulistyo Budi", "2h Ago", "The menu varies from tea to coffee, there is already a rice and dessert menu too.", R.drawable.bintangisi))
        reviewList.add(ReviewItem(R.drawable.pj, "Paulus Jeharu", "3h Ago", "The seat at the window is a favorite plus a large selection of books to read.", R.drawable.bintangisi))
        reviewList.add(ReviewItem(R.drawable.anastasya, "Anastasya", "2h Ago", "There are wifi facilities, meeting rooms, lounges, prayer rooms (in front), toilets.", R.drawable.bintangisi))


        reviewAdapter = AdapterReview(reviewList)
        binding.recyclerView.adapter = reviewAdapter
    }
}