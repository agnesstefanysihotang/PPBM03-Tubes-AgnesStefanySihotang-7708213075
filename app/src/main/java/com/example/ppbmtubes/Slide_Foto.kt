package com.example.ppbmtubes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class Slide_Foto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable)
// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel("https://domf5oio6qrcr.cloudfront.net/medialibrary/11537/4a78f148-d427-4209-8173-f33d04c44106.jpg", "Improve Your Cooking Skills"))
        imageList.add(SlideModel("https://media.istockphoto.com/id/1164904657/photo/a-meal-cooked-by-the-whole-family-tastes-better.jpg?s=612x612&w=0&k=20&c=kUwoqUbzDyLounHZXGCtRo6pELIplbJD5CWhFHKE0ng=", "Makes Your Beloved Happy"))
        imageList.add(SlideModel("https://bansaloilandfoods.com/wp-content/uploads/2022/12/scale.jpg", "Create Your Own Recipe With us!"))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
    }
}