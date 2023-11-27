package com.example.gamecenter

import android.content.Intent
import android.media.browse.MediaBrowser.ItemCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListGameAdapter(private val listGames: ArrayList<Games>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_game, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() : Int = listGames.size


    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, genre, price, photo) = listGames[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvGenre.text = genre
        holder.tvPrice.text = price
        holder.btnBuyGame.setOnClickListener {
            onItemClickCallback.onItemClicked(listGames[holder.adapterPosition])
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        val tvGenre : TextView = itemView.findViewById(R.id.tv_item_genre)
        val tvPrice : TextView = itemView.findViewById(R.id.tv_item_price)
        val btnBuyGame : Button = itemView.findViewById(R.id.btn_buy_game)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Games)
    }
}