package com.example.gdd_retrofit.adduser

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.PostUserBody
import com.example.gdd_retrofit.pojo.PostUserErrorResponse
import com.example.gdd_retrofit.pojo.PostUserResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarActivityPresenter(val listener: Listener) {

    fun goToBack() {
        listener.goToBack()
    }


    fun addUser(daftarUser: PostUserBody, context: Context) {
        ApiClient.apiService.addUser(daftarUser).enqueue(object :
            Callback<PostUserResponse> {
            override fun onResponse(
                call: Call<PostUserResponse>,
                response: Response<PostUserResponse>
            ) {
                val status = response.code()

                Log.d("BNR", status.toString())

                if (status == 201) {
                    goToBack()
                } else {


                    val jobError = Gson().fromJson(
                        response.errorBody()?.charStream(),
                        PostUserErrorResponse::class.java
                    )

                    Log.d("BNR", jobError.message.toString())

                    Toast.makeText(
                        context,
                        jobError.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
                Toast.makeText(context, "Connection Error", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }


    fun checkFieldEmpty(boolean: Boolean, daftarUser: PostUserBody, context: Context) {
        if (boolean) {
            Toast.makeText(context, "Cek kembali, data tidak boleh kosong", Toast.LENGTH_SHORT)
                .show()
        } else {
            addUser(daftarUser, context)
        }
    }


    interface Listener {
        fun goToBack()
    }
}