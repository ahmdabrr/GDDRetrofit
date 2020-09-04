package com.example.gdd_retrofit.profile.edituser

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.gdd_retrofit.login.DataLoginUser
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.PutUserBody
import com.example.gdd_retrofit.pojo.PutUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditUsernameFragmentPresenter(val listener: Listener) {

    fun getName(sp: SharedPreferences): String {
        val name = sp.getString(DataLoginUser.FIELD_USERNAME, "")
        return name.toString()
    }

    fun getId(sp: SharedPreferences): String {
        val id = sp.getString(DataLoginUser.FIELD_ID, "").toString()
        return id
    }

    fun dismissDialog() {
        listener.dismissDialog()
    }


    fun editUser(objectEdit: PutUserBody, context: Context, sp: SharedPreferences, nama: String) {
        ApiClient.apiService.updateUser(objectEdit, getId(sp)).enqueue(object :
            Callback<PutUserResponse> {
            override fun onResponse(
                call: Call<PutUserResponse>,
                response: Response<PutUserResponse>
            ) {
                val editor = sp.edit()
                editor?.putString(DataLoginUser.FIELD_USERNAME, nama)
                editor?.apply()
                Log.d("BNR", nama)
                Log.d(
                    "BNR",
                    sp.getString(DataLoginUser.FIELD_USERNAME, "").toString()
                )
                Toast.makeText(context, "Update Username success", Toast.LENGTH_SHORT).show()
                dismissDialog()
            }

            override fun onFailure(call: Call<PutUserResponse>, t: Throwable) {
                Log.d("BNR", t.message.toString())
            }
        })

    }


    interface Listener {
        fun dismissDialog()
    }
}