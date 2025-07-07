package com.example.skillroute

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import nl.dionsegijn.konfetti.xml.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.Angle
import java.util.concurrent.TimeUnit

class activity_feedback : AppCompatActivity() {

    private lateinit var emojis: Array<ImageView>
    private lateinit var reactionText: TextView
    private lateinit var konfettiView: KonfettiView
    private var selectedEmoji = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        // Initialize views
        reactionText = findViewById(R.id.reactionText)
        konfettiView = findViewById(R.id.konfettiView)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        emojis = arrayOf(
            findViewById(R.id.emoji1),
            findViewById(R.id.emoji2),
            findViewById(R.id.emoji3),
            findViewById(R.id.emoji4),
            findViewById(R.id.emoji5)
        )

        for (i in emojis.indices) {
            emojis[i].setOnClickListener {
                playBounce(emojis[i])
                vibratePhone(vibrator)
                resetOthers(i)
                highlightSelected(i)
                selectedEmoji = i

                // Set reaction text
                reactionText.text = when (i) {
                    0 -> "Oh no! 😢"
                    1 -> "Could be better."
                    2 -> "Okay."
                    3 -> "Great!"
                    4 -> "Awesome! 😄"
                    else -> ""
                }

                // Show confetti only for "Very Good" emoji
                if (i == 4) {
                    konfettiView.visibility = View.VISIBLE
                    konfettiView.start(
                        Party(
                            speed = 0f,
                            maxSpeed = 30f,
                            damping = 0.9f,
                            spread = 360,
                            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).perSecond(100),
                            position = Position.Relative(0.5, 0.3),
                            angle = Angle.BOTTOM
                        )
                    )
                } else {
                    konfettiView.visibility = View.GONE
                }
            }
        }
    }

    private fun playBounce(imageView: ImageView) {
        val bounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        imageView.startAnimation(bounce)
    }

    private fun resetOthers(selected: Int) {
        for (i in emojis.indices) {
            if (i != selected) {
                emojis[i].clearAnimation()
                emojis[i].scaleX = 1f
                emojis[i].scaleY = 1f
            }
        }
    }

    private fun highlightSelected(selectedIndex: Int) {
        for (i in emojis.indices) {
            if (i == selectedIndex) {
                emojis[i].setBackgroundResource(R.drawable.glow_background)
            } else {
                emojis[i].setBackgroundResource(0)
            }
        }
    }

    private fun vibratePhone(vibrator: Vibrator) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(80, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            @Suppress("DEPRECATION")
            vibrator.vibrate(80)
        }
    }
}
