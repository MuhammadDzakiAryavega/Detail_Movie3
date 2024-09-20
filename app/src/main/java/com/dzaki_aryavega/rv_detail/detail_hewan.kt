package com.dzaki_aryavega.rv_detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail_hewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_hewan)

        //ambil data dari intent
        val namaHewan = intent.getStringExtra("namaHewan")
        val gambarHewan = intent.getIntExtra("gambarHewan",0)

        //tampilan nama hewan di textview
        val textViewNamaHewan = findViewById<TextView>(R.id.tvNamaHewan)
        textViewNamaHewan.text = namaHewan

        //tampilan gambar hewan di ImageView
        val imageViewGambarHewan = findViewById<ImageView>(R.id.ivGambarHewan)
        imageViewGambarHewan.setImageResource(gambarHewan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}