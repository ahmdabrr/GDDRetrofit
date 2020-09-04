package com.example.gdd_retrofit

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.PostUserBody
import com.example.gdd_retrofit.pojo.PostUserErrorResponse
import com.example.gdd_retrofit.pojo.PostUserResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_daftar.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        iv_back_daftar.setOnClickListener {
            finish()
        }

        btn_daftar.setOnClickListener {
            if (et_email_daftar.text.isNullOrEmpty() || et_password_daftar.text.isNullOrEmpty() || et_username_daftar.text.isNullOrEmpty()) {
//                Snackbar.make(it, "Cek kembali, data tidak boleh kosong")
                Toast.makeText(this, "Cek kembali, data tidak boleh kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val daftarUser = PostUserBody(
                    et_email_daftar.text.toString(),
                    et_password_daftar.text.toString(),
                    et_username_daftar.text.toString()
                )


                ApiClient.apiService.addUser(daftarUser).enqueue(object :
                    Callback<PostUserResponse> {
                    override fun onResponse(
                        call: Call<PostUserResponse>,
                        response: Response<PostUserResponse>
                    ) {
                        val status = response.code()

                        Log.d("BNR", status.toString())

                        if (status == 201) {
                            finish()
                        } else {


                            val jobError = Gson().fromJson(response.errorBody()?.charStream(), PostUserErrorResponse::class.java)

                            Log.d("BNR", jobError.message.toString())

                            Toast.makeText(
                                this@DaftarActivity,
                                jobError.message.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
                        Toast.makeText(this@DaftarActivity, "Connection Error", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
            }
        }

    }
}