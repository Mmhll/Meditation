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

class FeelRecycler (val context: Context, val feel: feel):RecyclerView.Adapter<FeelRecycler.MyVH>(){
    class MyVH(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.img_feel)
        val title : TextView = itemView.findViewById(R.id.text_feel)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.feel_adapter, parent, false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        Glide.with(context).load(feel.data[position].image).into(holder.image)
        holder.title.setText(feel.data[position].title)
    }

    override fun getItemCount(): Int {
        return feel.data.size
    }
}