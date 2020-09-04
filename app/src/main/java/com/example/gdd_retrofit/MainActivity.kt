package com.example.gdd_retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.example.gdd_retrofit.databinding.ActivityPemainVsCPUBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var menuPermainan: MenuFragment
    lateinit var historyPermainan: HistoryFragment
    lateinit var profilePermaiann: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.itemNavigationMenu -> {
                    menuPermainan = MenuFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, menuPermainan)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }
                R.id.itemNavigationMenu -> {
                    historyPermainan = HistoryFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, historyPermainan)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }
                R.id.itemNavigationMenu -> {
                    profilePermaiann = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, profilePermaiann)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                else -> false

            }
        }
    }
}