package com.example.skillroute

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.GridLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        /*// Main YouTube Dropdown
        val youtubeHeader = findViewById<LinearLayout>(R.id.youtubeHeader)
        val youtubeContent = findViewById<LinearLayout>(R.id.youtubeContent)
        val youtubeArrow = findViewById<ImageView>(R.id.youtubeArrow)

        youtubeHeader.setOnClickListener {
            if (youtubeContent.visibility == View.GONE) {
                youtubeContent.visibility = View.VISIBLE
                youtubeArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                youtubeContent.visibility = View.GONE
                youtubeArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        // Hindi Dropdown
        val hindiHeader = findViewById<LinearLayout>(R.id.hindiHeader)
        val hindiContent = findViewById<LinearLayout>(R.id.hindiContent)
        val hindiArrow = findViewById<ImageView>(R.id.hindiArrow)

        hindiHeader.setOnClickListener {
            if (hindiContent.visibility == View.GONE) {
                hindiContent.visibility = View.VISIBLE
                hindiArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                hindiContent.visibility = View.GONE
                hindiArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        // English Dropdown
        val englishHeader = findViewById<LinearLayout>(R.id.englishHeader)
        val englishContent = findViewById<LinearLayout>(R.id.englishContent)
        val englishArrow = findViewById<ImageView>(R.id.englishArrow)

        englishHeader.setOnClickListener {
            if (englishContent.visibility == View.GONE) {
                englishContent.visibility = View.VISIBLE
                englishArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                englishContent.visibility = View.GONE
                englishArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        // Telugu Dropdown
        val teluguHeader = findViewById<LinearLayout>(R.id.teluguHeader)
        val teluguContent = findViewById<LinearLayout>(R.id.teluguContent)
        val teluguArrow = findViewById<ImageView>(R.id.teluguArrow)

        teluguHeader.setOnClickListener {
            if (teluguContent.visibility == View.GONE) {
                teluguContent.visibility = View.VISIBLE
                teluguArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                teluguContent.visibility = View.GONE
                teluguArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }

        // Hindi Channel Buttons
        findViewById<Button>(R.id.openHarry).setOnClickListener {
            openUrl("https://www.youtube.com/c/CodeWithHarry")
        }
        findViewById<Button>(R.id.openApna).setOnClickListener {
            openUrl("https://www.youtube.com/c/ApnaCollegeOfficial")
        }
        findViewById<Button>(R.id.openSnippets).setOnClickListener {
            openUrl("https://www.youtube.com/c/SimpleSnippets")
        }

        // English Channel Buttons
        findViewById<Button>(R.id.openFCC).setOnClickListener {
            openUrl("https://www.youtube.com/c/Freecodecamp")
        }
        findViewById<Button>(R.id.openTraversy).setOnClickListener {
            openUrl("https://www.youtube.com/c/TraversyMedia")
        }

        // Telugu Channel Button
        findViewById<Button>(R.id.openTelugu).setOnClickListener {
            openUrl("https://www.youtube.com/@TeluguSkillChannel")
        }*/







        // YouTube main dropdown
        var isYoutubeExpanded = false
        val youtubeContent = findViewById<LinearLayout>(R.id.youtubeContent)
        val youtubeArrow = findViewById<ImageView>(R.id.youtubeArrow)
        val youtubeHeader = findViewById<LinearLayout>(R.id.youtubeHeader)

        youtubeHeader.setOnClickListener {
            isYoutubeExpanded = !isYoutubeExpanded
            youtubeContent.visibility = if (isYoutubeExpanded) View.VISIBLE else View.GONE
            youtubeArrow.setImageResource(
                if (isYoutubeExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
            )
        }

        //hindi Section
        var isHindiExpanded = false
        val hindiScrollView = findViewById<HorizontalScrollView>(R.id.hindiScrollView)
        val hindiArrow = findViewById<ImageView>(R.id.hindiArrow)
        val hindiHeader = findViewById<LinearLayout>(R.id.hindiHeader)

        hindiHeader.setOnClickListener {
            isHindiExpanded = !isHindiExpanded

            // Show or hide the scroll view, which contains the grid
            hindiScrollView.visibility = if (isHindiExpanded) View.VISIBLE else View.GONE

            // Toggle the arrow icon
            hindiArrow.setImageResource(
                if (isHindiExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
            )
        }

        var isEnglishExpanded = false

        val englishHeader = findViewById<LinearLayout>(R.id.englishHeader)
        val englishArrow = findViewById<ImageView>(R.id.englishArrow)
        val englishScrollView = findViewById<HorizontalScrollView>(R.id.englishScrollView)

        englishHeader.setOnClickListener {
            isEnglishExpanded = !isEnglishExpanded

            englishScrollView.visibility = if (isEnglishExpanded) View.VISIBLE else View.GONE

            englishArrow.setImageResource(
                if (isEnglishExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
            )
        }

        //Telugu section
        var isTeluguExpanded = false

        val teluguHeader = findViewById<LinearLayout>(R.id.teluguHeader)
        val teluguArrow = findViewById<ImageView>(R.id.teluguArrow)
        val teluguScrollView = findViewById<HorizontalScrollView>(R.id.teluguScrollView)

        teluguHeader.setOnClickListener {
            isTeluguExpanded = !isTeluguExpanded

            teluguScrollView.visibility = if (isTeluguExpanded) View.VISIBLE else View.GONE

            teluguArrow.setImageResource(
                if (isTeluguExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
            )

            if (isTeluguExpanded) {
                teluguScrollView.post {
                    teluguScrollView.fullScroll(View.FOCUS_DOWN)
                }
            }
        }


        // Hindi Cards
        findViewById<CardView>(R.id.cardHarry).setOnClickListener {
            openUrl("https://www.youtube.com/c/CodeWithHarry")
        }

        findViewById<CardView>(R.id.cardApna).setOnClickListener {
            openUrl("https://www.youtube.com/c/ApnaCollegeOfficial")
        }

        // English Cards
        findViewById<CardView>(R.id.cardFCC).setOnClickListener {
            openUrl("https://www.youtube.com/c/Freecodecamp")
        }

        findViewById<CardView>(R.id.cardTraversy).setOnClickListener {
            openUrl("https://www.youtube.com/c/TraversyMedia")
        }

        // Telugu Cards
        findViewById<CardView>(R.id.cardTelugu).setOnClickListener {
            openUrl("https://www.youtube.com/c/TeluguTechLearning")
        }




        //for websites

        val arrow = findViewById<ImageView>(R.id.websiteArrow)
        val dropdown = findViewById<LinearLayout>(R.id.websiteDropdownLayout)
        val header = findViewById<LinearLayout>(R.id.websiteHeader)

        var isExpanded = false
        header.setOnClickListener {
            isExpanded = !isExpanded
            dropdown.visibility = if (isExpanded) View.VISIBLE else View.GONE
            arrow.setImageResource(if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down)
        }

        // Open website links
        findViewById<TextView>(R.id.openGeeks).setOnClickListener {
            val url = "https://www.geeksforgeeks.org"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        findViewById<TextView>(R.id.openW3).setOnClickListener {
            val url = "https://www.w3schools.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


        lateinit var dropdownContent: LinearLayout
        lateinit var dropdownIcon: ImageView
        var isExpanded2 = false // ✅ single variable

        dropdownContent = findViewById(R.id.dropdownContent)
        dropdownIcon = findViewById(R.id.dropdownIcon)

        dropdownIcon.setOnClickListener {
            if (isExpanded2) {
                dropdownContent.visibility = View.GONE
                dropdownIcon.setImageResource(R.drawable.ic_arrow_down)
            } else {
                dropdownContent.visibility = View.VISIBLE
                dropdownIcon.setImageResource(R.drawable.ic_arrow_up)
            }
            isExpanded2 = !isExpanded2 // ✅ update the same variable
        }


        //for heading text for start your learning journy
        val textView = findViewById<TextView>(R.id.title)

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

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
