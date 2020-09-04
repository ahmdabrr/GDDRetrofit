package com.example.gdd_retrofit.splashscreen

import android.os.Handler
import android.os.Looper

class SplashScreenPresenter(val listener: Listener) {

    fun showSplashScreen(){
        Handler(Looper.getMainLooper()).postDelayed({
            listener.goToLandingActivity()
        }, 3000)
    }

    interface Listener{
        fun goToLandingActivity()
    }
}