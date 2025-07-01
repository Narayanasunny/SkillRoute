package com.example.skillroute

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat

class HomeActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var menuIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        menuIcon = findViewById(R.id.menu_icon)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_skills -> {
                    Toast.makeText(this, "Skills clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }

        val card = findViewById<LinearLayout>(R.id.cardDevelopment)
        val card2 = findViewById<LinearLayout>(R.id.cardPrograming)
        val card3 = findViewById<LinearLayout>(R.id.cardtechdomain)

        card.setOnClickListener {
            startActivity(Intent(this, devp_skill::class.java))
        }

        card2.setOnClickListener {
            startActivity(Intent(this, programingskills::class.java))
        }

        card3.setOnClickListener {
            startActivity(Intent(this, tech_domain_skill::class.java))
        }



        val titleCard = findViewById<LinearLayout>(R.id.cardPrograming)
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_slide_in)
        titleCard.startAnimation(animation)

        val homeContent = findViewById<View>(R.id.home_content)
        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                homeContent.translationX = drawerView.width * slideOffset
            }

            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {}
            override fun onDrawerStateChanged(newState: Int) {}
        })
    }
}
