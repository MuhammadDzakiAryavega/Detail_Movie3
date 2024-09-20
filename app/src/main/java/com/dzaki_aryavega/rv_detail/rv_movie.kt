package com.dzaki_aryavega.rv_detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzaki_aryavega.rv_detail.adapter.adapter_movie
import com.dzaki_aryavega.rv_detail.model.model_movie
import java.util.ArrayList

class rv_movie : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null
    private var movieAdapter : adapter_movie? = null
    private var movieList = mutableListOf<model_movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rv_movie)

        movieList = ArrayList()
        recyclerView = findViewById(R.id.rvMovieList) as RecyclerView
        movieAdapter = adapter_movie(this,movieList){ position ->
            showDetailDialog(position as Int)
        }
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = movieAdapter

        prepareMovielist()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    private fun prepareMovielist() {
        var movie = model_movie("Avatar", R.drawable.inception)
        movieList.add(movie)
        movie = model_movie("Inception", R.drawable.venom)
        movieList.add(movie)
        movie = model_movie("Jumanji", R.drawable.jumanji)
        movieList.add(movie)
        movie = model_movie("Spider Man", R.drawable.spiderman)
        movieList.add(movie)
        movieAdapter!!.notifyDataSetChanged()
    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this,detail_movie::class.java)
        intent.putExtra("imageResId",movieList[position].image)
        startActivity(intent)
        }

}
