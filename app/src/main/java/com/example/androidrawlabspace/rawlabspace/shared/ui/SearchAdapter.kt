package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R

class SearchAdapter ( private val searchlist:ArrayList<SearchItem>)

    : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ruang : TextView = itemView.findViewById(R.id.ruang)
        val jalan : TextView = itemView.findViewById(R.id.jalan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_list,parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchlist.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val food = searchlist[position]
        holder.ruang.text = food.ruang
        holder.jalan.text = food.jalan
    }
}