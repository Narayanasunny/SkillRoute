package com.example.skillroute

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //All cards
        val card = findViewById<LinearLayout>(R.id.cardDevelopment)
        val card2 = findViewById<LinearLayout>(R.id.cardPrograming)
        val card3 = findViewById<LinearLayout>(R.id.cardtechdomain)

        //card1
        card.setOnClickListener {
            // Handle card click
            // You can start a new activity or perform any other action here
            startActivity(Intent(this, devp_skill::class.java))
        }

        //card2
        card2.setOnClickListener {
            // Handle card click
            // You can start a new activity or perform any other action here
            startActivity(Intent(this, programingskills::class.java))

        }


        //card3
        card3.setOnClickListener {
            // Handle card click
            // You can start a new activity or perform any other action here
            startActivity(Intent(this, tech_domain_skill::class.java))

        }

        //for tool bar
        val searchIcon: ImageView = findViewById(R.id.search_bar)
        val notifIcon: ImageView = findViewById(R.id.icon_notification)
        val settingsIcon: ImageView = findViewById(R.id.icon_settings)
        val profileIcon: ImageView = findViewById(R.id.icon_profile)

        searchIcon.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, SearchActivity::class.java))
        }

        //this for animation effect for every card
        val titleCard = findViewById<LinearLayout>(R.id.cardPrograming)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_slide_in)
        titleCard.startAnimation(animation)


    }
}
