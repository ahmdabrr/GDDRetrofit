package com.example.gdd_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        vp_landing.adapter = LandingAdapter(supportFragmentManager)
        tabDots.setupWithViewPager(vp_landing, true)
    }
}