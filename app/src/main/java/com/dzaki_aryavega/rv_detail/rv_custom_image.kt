package com.dzaki_aryavega.rv_detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzaki_aryavega.rv_detail.adapter.adapter_buah
import com.dzaki_aryavega.rv_detail.model.Mocklist
import com.dzaki_aryavega.rv_detail.model.model_buah

class rv_custom_image : AppCompatActivity() {

    private lateinit var rv_buah: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rv_custom_image)
        rv_buah = findViewById(R.id.rv_data)

        rv_buah.layoutManager = GridLayoutManager(this,1,
            GridLayoutManager.VERTICAL,false)

        //menambah item click listener
        val adapter = adapter_buah(Mocklist.getModel() as ArrayList<model_buah>){ buah ->
            val intent = Intent(this, detail_buah::class.java)
            intent.putExtra("namaBuah",buah.nama)
            intent.putExtra("gambarBuah",buah.image)
            startActivity(intent)
        }
        rv_buah.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }
        }
}