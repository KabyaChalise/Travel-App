package com.example.places
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var image : ImageView
    var places = arrayOf("Stormy Thunder","Beauty Bath","Desert Deep","Beauty Bath Too","Lake Land")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val next = findViewById<ImageButton>(R.id.btnNext)
        val previous = findViewById<ImageButton>(R.id.btnPrevious)
        val placeName = findViewById<TextView>(R.id.tvName)
        next.setOnClickListener{
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f
            currentImage = (5+currentImage+1)%5
            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f
            placeName.text = places[currentImage]
        }
        previous.setOnClickListener {
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage = (5+currentImage-1)%5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f
        }
    }
}