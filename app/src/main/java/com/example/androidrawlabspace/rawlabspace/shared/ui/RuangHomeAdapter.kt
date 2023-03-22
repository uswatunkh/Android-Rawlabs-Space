package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R

class RuangHomeAdapter ( private val ruanglist:ArrayList<RuangHomeItem>)

    : RecyclerView.Adapter<RuangHomeAdapter.RuangViewHolder>(){

    var onItemClick : ((RuangHomeItem) ->Unit)? = null
    class RuangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView1 : ImageView = itemView.findViewById(R.id.imageViewHome)
        val ruang : TextView = itemView.findViewById(R.id.namaRuang)
        val harga : TextView = itemView.findViewById(R.id.harga)
        val jalan : TextView = itemView.findViewById(R.id.jlnRuang)
        val day : TextView = itemView.findViewById(R.id.day)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ruang_home_list,parent, false)
        return RuangViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ruanglist.size
    }

    override fun onBindViewHolder(holder: RuangViewHolder, position: Int) {
        val food = ruanglist[position]
        holder.imageView1.setImageResource(food.image)
        holder.ruang.text = food.ruang
        holder.harga.text = food.harga
        holder.jalan.text = food.jalan
        holder.day.text = food.day

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(food)
        }
    }
}