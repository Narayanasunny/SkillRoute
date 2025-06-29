package com.example.skillroute

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.skillroute.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var onboardingAdapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.navigationBarColor = getColor(android.R.color.white)

        onboardingAdapter = OnboardingAdapter(this)
        binding.viewPager.adapter = onboardingAdapter

        // Connect tab indicators
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        // Skip button logic: jump to last page
        binding.btnSkip.setOnClickListener {
            binding.viewPager.currentItem = 2
        }

        // Next button logic: go to next page
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem < 2) {
                binding.viewPager.currentItem += 1
            }
        }

        // Hide Skip/Next on last page
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    binding.btnSkip.visibility = ViewPager2.GONE
                    binding.btnNext.visibility = ViewPager2.GONE
                } else {
                    binding.btnSkip.visibility = ViewPager2.VISIBLE
                    binding.btnNext.visibility = ViewPager2.VISIBLE
                }
            }
        })
    }
}
