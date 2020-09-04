package com.example.gdd_retrofit.menuBattle


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.history.HistoryFragment
import com.example.gdd_retrofit.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//                getFragmentPage(HistoryFragment())

//        bottomNavigation.setOnNavigationItemSelectedListener { item ->
//            var fragment: Fragment? = null
//            when (item.itemId) {
//                R.id.menu_fragment -> {
//                    Log.d("BNR", "test")
//                    getFragmentPage(MenuFragment.getInstance())}
//                R.id.history_fragment -> {getFragmentPage(HistoryFragment.getInstance())
//                    Log.d("BNR", "test2")}
//                R.id.profile_fragment -> {getFragmentPage(ProfileFragment.getInstance())
//                    Log.d("BNR", "test3")}
//            }
//            getFragmentPage(fragment)
//        }
        var menu: Menu = bottomNavigation.menu
        selectedMenu(menu.getItem(0))
        bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            selectedMenu(item)
            Log.d("BNR", "${item}")
            false
        }
    }

    fun selectedMenu(item: MenuItem) {
        item.isChecked = true
        when (item.itemId) {
            R.id.itemNavigationMenu -> {
                Log.d("BNR", "test")
                selectedFragment(MenuFragment.getInstance())
            }
            R.id.itemNavigationHistory -> {
                selectedFragment(HistoryFragment.getInstance())
                Log.d("BNR", "test2")
            }
            R.id.itemNavigationProfile -> {
                selectedFragment(ProfileFragment.getInstance())
                Log.d("BNR", "test3")
            }
        }
//        R.id.homeMenu -> selectedFragment(HomeFragment.getInstance())
//        R.id.historyMenu -> selectedFragment(HistoryFragment.getInstance())
//        R.id.newestMenu -> selectedFragment(NewestFragment.getInstance())
    }

    private fun getFragmentPage(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit()
            return true
        }
        return false
    }

    fun selectedFragment(fragment: Fragment) {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit()
        }
    }
}



