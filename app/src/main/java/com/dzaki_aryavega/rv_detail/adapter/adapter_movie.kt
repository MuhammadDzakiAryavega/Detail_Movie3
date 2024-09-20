package com.dzaki_aryavega.rv_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dzaki_aryavega.rv_detail.R
import com.dzaki_aryavega.rv_detail.model.model_movie
import com.dzaki_aryavega.rv_detail.rv_movie


class adapter_movie(
    private val getActivity: rv_movie,
    private val movieList: List<model_movie>,
    private val onItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<adapter_movie.MyViewHolder>() {

    class MyViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        //deklarasi widget dari item layout
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_movie, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = movieList[position].title
        holder.imgMovie.setImageResource(movieList[position].image)

        //ini ketika item di klik
        holder.cardView.setOnClickListener() {
            onItemClick(position)
            Toast.makeText(
                getActivity, movieList[position].title,
                Toast.LENGTH_SHORT
            ).show()
            }
        }
}