package com.mhl.meditation.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mhl.meditation.R

class StateRecycler (val context: Context, val quotes: quotes) : RecyclerView.Adapter<StateRecycler.MyVH>() {
    class MyVH(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.state_title)
        val subtitle : TextView = itemView.findViewById(R.id.state_subtitle)
        val image : ImageView = itemView.findViewById(R.id.state_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.state_adapter, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: StateRecycler.MyVH, position: Int) {
        Glide.with(context).load(quotes.data[position].image).into(holder.image)
        holder.title.setText(quotes.data[position].title)
        holder.subtitle.setText(quotes.data[position].description)
    }

    override fun getItemCount(): Int {
        return quotes.data.size
    }
}