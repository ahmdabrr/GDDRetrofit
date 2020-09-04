package com.example.gdd_retrofit.profile.edituser

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.gdd_retrofit.login.DataLoginUser
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.PutUserBody
import com.example.gdd_retrofit.pojo.PutUserResponse
import kotlinx.android.synthetic.main.fragment_edit_email.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditEmailFragmentPresenter(val listener: Listener) {
    fun getEmail(sp: SharedPreferences): String {
        val email = sp.getString(DataLoginUser.FIELD_EMAIL, "")
        return email.toString()
    }

    fun getId(sp: SharedPreferences): String {
        val id = sp.getString(DataLoginUser.FIELD_ID, "").toString()
        return id
    }

    fun dismissDialog() {
        listener.dismissDialog()
    }


    fun editUser(objectEdit: PutUserBody, context: Context, sp: SharedPreferences, email: String){
        ApiClient.apiService.updateUser(objectEdit, getId(sp)).enqueue(object :
            Callback<PutUserResponse> {
            override fun onResponse(
                call: Call<PutUserResponse>,
                response: Response<PutUserResponse>
            ) {
                val editor = sp.edit()
                editor?.putString(DataLoginUser.FIELD_EMAIL, email)
                editor?.apply()
                Log.d("BNR", email)
                Log.d("BNR", sp.getString(DataLoginUser.FIELD_USERNAME, "").toString())
                Toast.makeText(context, "Update Email success", Toast.LENGTH_SHORT).show()
                listener.dismissDialog()
            }

            override fun onFailure(call: Call<PutUserResponse>, t: Throwable) {
                Log.d("BNR", t.message.toString())
            }
        })
    }



    interface Listener{
        fun dismissDialog()
    }
}