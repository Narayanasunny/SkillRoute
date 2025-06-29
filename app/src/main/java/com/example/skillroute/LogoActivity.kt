package com.example.skillroute

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.imageview.ShapeableImageView

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        // 1. Find views
        val logoIcon = findViewById<ShapeableImageView>(R.id.logoIcon)
        val appName = findViewById<TextView>(R.id.appName)
        val tagline = findViewById<TextView>(R.id.tagline)

        // 2. Load animations
        val zoomIn = AnimationUtils.loadAnimation(this, R.anim.logo_zoom)
        val appFadeUp = AnimationUtils.loadAnimation(this, R.anim.fade_up)
        val taglineFade = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // 3. Start logo zoom animation
        logoIcon.startAnimation(zoomIn)

        // 4. Animate app name after a short delay
        logoIcon.postDelayed({
            appName.startAnimation(appFadeUp)
        }, 800)

        // 5. Animate tagline after app name
        logoIcon.postDelayed({
            tagline.startAnimation(taglineFade)
        }, 1500)

        // 6. Go to onboarding screen after 10 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
