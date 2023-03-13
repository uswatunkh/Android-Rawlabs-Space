package com.example.androidrawlabspace.rawlabspace.submitreview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ItemRatingBinding

class AdapterReview (private val reviewList: ArrayList<ReviewItem>)
    : RecyclerView.Adapter<AdapterReview.ReviewViewHolder>(){

        class ReviewViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
            val gamabar: ImageView = itemView.findViewById(R.id.fotoProfile)
            val nama: TextView = itemView.findViewById(R.id.namaReviewer)
            val hari: TextView = itemView.findViewById(R.id.tanggalRiviewer)
            val isiReview: TextView = itemView.findViewById(R.id.isiReview)
            val star: ImageView = itemView.findViewById(R.id.bintang)

//            private lateinit var binding: ItemRatingBinding
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rating, parent, false)
        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int{
        return reviewList.size
    }

    override fun onBindViewHolder (holder: ReviewViewHolder, position: Int){
        val food = reviewList[position]
        holder.gamabar.setImageResource(food.image)
        holder.nama.text = food.nama
        holder.hari.text = food.waktu
        holder.isiReview.text = food.waktu
        holder.star.setImageResource(food.bintang)

//        holder.binding.fotoProfil.setImageResource(food.image)
//        holder.binding.namaReviewer.text = food.nama
//        holder.binding.tanggalRiviewer.text = food.waktu
//        holder.binding.isiReview.text = food.waktu
//        holder.binding.bintang.setImageResource(food.bintang)
    }
    }