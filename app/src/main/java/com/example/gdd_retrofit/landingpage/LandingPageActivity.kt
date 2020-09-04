package com.example.gdd_retrofit.landingpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.databinding.ActivityLandingPageBinding
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivity : AppCompatActivity(),LandingPageActivityPresenter.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val presenter = LandingPageActivityPresenter(this)

        presenter.showFragment(vp_landing, supportFragmentManager)
        presenter.setupTabLayout(tabDots, vp_landing)
    }
}