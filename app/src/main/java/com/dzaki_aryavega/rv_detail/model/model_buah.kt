package com.dzaki_aryavega.rv_detail.model

import com.dzaki_aryavega.rv_detail.R

class model_buah (
    val image : Int,
    val nama : String
)

//kita bikin array data

object Mocklist{

    fun getModel() : List<model_buah> {
        val itemModel1 = model_buah(
            R.drawable.pear,
            nama = "Pir"
        )
        val itemModel2 = model_buah(
            R.drawable.stroberry,
            nama = "Stroberi"
        )
        val itemModel3 = model_buah(
            R.drawable.jeruk,
            nama = "Jeruk"
        )
        val itemModel4 = model_buah(
            R.drawable.apel,
            nama = "Apel"
        )
        val itemList : ArrayList<model_buah> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)

        return itemList
        }
}