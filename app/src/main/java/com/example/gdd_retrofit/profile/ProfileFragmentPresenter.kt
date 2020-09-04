package com.example.gdd_retrofit.profile

import android.content.SharedPreferences
import androidx.fragment.app.FragmentManager
import com.example.gdd_retrofit.login.DataLoginUser
import com.example.gdd_retrofit.profile.edituser.EditEmailFragment
import com.example.gdd_retrofit.profile.edituser.EditUsernameFragment

class ProfileFragmentPresenter(val listener: Listener) {

    fun getName(sp : SharedPreferences): String{
        val name = sp.getString(DataLoginUser.FIELD_USERNAME, "")
        return name.toString()
    }

    fun getEmail(sp : SharedPreferences): String{
        val email = sp.getString(DataLoginUser.FIELD_EMAIL, "").toString()
        return email
    }

    fun showEditUsernameDialog(fm: FragmentManager){
        EditUsernameFragment.newInstance().show(fm, null)
    }

    fun showEditEmailDialog(fm: FragmentManager){
        EditEmailFragment.newInstance().show(fm, null)
    }


    interface Listener{

    }
}