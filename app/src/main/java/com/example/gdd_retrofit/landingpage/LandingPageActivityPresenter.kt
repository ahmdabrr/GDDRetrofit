package com.example.gdd_retrofit.landingpage

import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivityPresenter(val listener:Listener) {


    fun showFragment(vp: ViewPager, fm:FragmentManager){
        vp.adapter = LandingAdapter(fm)
    }

    fun setupTabLayout(tl: TabLayout, vp: ViewPager){
        tl.setupWithViewPager(vp, true)
    }

    interface Listener{

    }
}