package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R

class RuangAdapter ( private val ruanglist:ArrayList<RuangItem>)

    : RecyclerView.Adapter<RuangAdapter.RuangViewHolder>(){

    class RuangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1 : ImageView = itemView.findViewById(R.id.image1)
        val ruang : TextView = itemView.findViewById(R.id.ruang)
        val jalan : TextView = itemView.findViewById(R.id.jalan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ruang_list,parent, false)
        return RuangViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ruanglist.size
    }

    override fun onBindViewHolder(holder: RuangViewHolder, position: Int) {
        val food = ruanglist[position]
        holder.imageView1.setImageResource(food.image)
        holder.ruang.text = food.ruang
        holder.jalan.text = food.jalan
    }
}