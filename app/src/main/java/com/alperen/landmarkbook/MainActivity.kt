package com.alperen.landmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

//var selectedGlobalBitmap : Bitmap? = null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data
        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colloseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        //Image

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colleseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kolezyum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eyfel)
        val london = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.london)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colleseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(london)
/*
        //Image-Efficient
        val pisaId = R.drawable.pisa
        val colleseumId = R.drawable.kolezyum
        val eiffelId = R.drawable.eyfel
        val londonId = R.drawable.london

        val landmarkImagesId = ArrayList<Int>()
        landmarkImagesId.add(pisaId)
        landmarkImagesId.add(colleseumId)
        landmarkImagesId.add(eiffelId)
        landmarkImagesId.add(londonId)

 */


        //Adapter:Layout & Data
        //val adapter = ArrayAdapter(this,R.layout.list_row,R.id.textView2,landmarkNames)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("name",landmarkNames[position])

            //intent.putExtra("image",landmarkImagesId[position])
            val singleton = Singleton.Selected
            singleton.selectedImage = landmarkImages[position]
            startActivity(intent)

        }

    }
}