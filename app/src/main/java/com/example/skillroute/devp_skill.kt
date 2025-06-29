package com.example.skillroute

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.GridLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class devp_skill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_devp_skill)

        //this for animation for every card view
        val gridLayout = findViewById<GridLayout>(R.id.gridLayout)
        gridLayout.layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_fall_down)
        gridLayout.scheduleLayoutAnimation()

        val javaCard = findViewById<CardView>(R.id.cardJava)
        javaCard.setOnClickListener {
            Toast.makeText(this, "Java clicked!", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, JavaDetailActivity::class.java))
        }



    }
}