package com.example.gdd_retrofit.landingpage

class FragmentLanding3Presenter(val listener: Listener) {

    fun goToLoginActivity(){
        listener.goToLoginActivity()
    }


    interface Listener{
        fun goToLoginActivity()
    }
}