package com.example.gdd_retrofit.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gdd_retrofit.landingpage.LandingPageActivity
import com.example.gdd_retrofit.R

class SplashScreen : AppCompatActivity(), SplashScreenPresenter.Listener {
    private lateinit var presenter: SplashScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        presenter = SplashScreenPresenter(this)

        presenter.showSplashScreen()
    }

    override fun goToLandingActivity() {
        startActivity(Intent(this, LandingPageActivity::class.java))
    }
}