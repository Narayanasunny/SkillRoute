package com.example.skillroute

import android.content.Intent
import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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

        //this for menu
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
                R.id.nav_feedback -> {
                    startActivity(Intent(this, activity_feedback::class.java))
                }

            }
            drawerLayout.closeDrawers()
            true
        }

        val card = findViewById<LinearLayout>(R.id.cardDevelopment)
        val card2 = findViewById<LinearLayout>(R.id.cardPrograming)
        val card3 = findViewById<LinearLayout>(R.id.cardtechdomain)
        val card4 = findViewById<LinearLayout>(R.id.cardcommunicationskills)
        val card5 = findViewById<LinearLayout>(R.id.cardapptitude)

        card.setOnClickListener {
            startActivity(Intent(this, devp_skill::class.java))
        }

        card2.setOnClickListener {
            startActivity(Intent(this, programingskills::class.java))
        }

        card3.setOnClickListener {
            startActivity(Intent(this, tech_domain_skill::class.java))
        }

        card4.setOnClickListener {
            startActivity(Intent(this, communication_Skills::class.java))
        }

        card5.setOnClickListener {
            startActivity(Intent(this, apptitude_skills::class.java))
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


        //for heading text for start your learning journy
        val textView = findViewById<TextView>(R.id.home_title)

        val shader = LinearGradient(
            0f, 0f,
            textView.paint.measureText(textView.text.toString()), textView.textSize,
            intArrayOf(
                Color.parseColor("#00C9FF"), // Sky Blue
                Color.parseColor("#92FE9D")  // Light Green
            ),


            null,
            Shader.TileMode.CLAMP
        )
        textView.paint.shader = shader


        val animation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        textView.startAnimation(animation1)


        textView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)






    }
}
