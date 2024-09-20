package com.dzaki_aryavega.rv_detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detail_buah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_buah)

        //terima data dari intent
        val namaBuah = intent.getStringExtra("namaBuah")
        val gambarBuah = intent.getIntExtra("gambarBuah",0)

        //referensu ke textview dan imageview di layout
        val tvNamaBuah = findViewById<TextView>(R.id.tvNamaBuah)
        val ivGambarBuah = findViewById<ImageView>(R.id.ivGambarBuah)

        //Tampilan nama dan gambar buah
        tvNamaBuah.text = namaBuah
        ivGambarBuah.setImageResource(gambarBuah)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }
    }
}