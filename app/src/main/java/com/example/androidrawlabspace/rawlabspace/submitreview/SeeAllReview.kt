package com.example.androidrawlabspace.rawlabspace.submitreview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.SeeAllReviewBinding

class SeeAllReview : AppCompatActivity() {
    private lateinit var binding: SeeAllReviewBinding
//    private lateinit var recyclerView: recyclerView
    private lateinit var reviewList: ArrayList<ReviewItem>
    private lateinit var reviewAdapter: AdapterReview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SeeAllReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        binding.header.setTitle("Rate & Review")
    }

    fun init(){
        binding.recyclerView2.setHasFixedSize(true)
        binding.recyclerView2.layoutManager = LinearLayoutManager(this)

        reviewList = ArrayList()

        reviewList.add(ReviewItem(R.drawable.anastasya, "Anastasya", "2h Ago","There are wifi facilities, meeting rooms, lounges, prayer rooms (in front), toilets.", R.drawable.bintangisi))
        reviewList.add(ReviewItem(R.drawable.pj, "Paulus Jeharu", "3h Ago", "The seat at the window is a favorite plus a large selection of books to read.", R.drawable.bintangisi))
        reviewList.add(ReviewItem(R.drawable.anastasya, "Anastasya", "2h Ago", "There are wifi facilities, meeting rooms, lounges, prayer rooms (in front), toilets.", R.drawable.bintangisi))


        reviewAdapter = AdapterReview(reviewList)
        binding.recyclerView2.adapter = reviewAdapter
        binding.btnAddReview.setOnClickListener { startActivity(Intent(this, AddReview::class.java)) }
    }
}