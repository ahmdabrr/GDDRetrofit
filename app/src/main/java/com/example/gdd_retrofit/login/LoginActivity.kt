package com.example.gdd_retrofit.login

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.gdd_retrofit.DaftarActivity
import com.example.gdd_retrofit.MainActivity
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.LoginUserBody
import com.example.gdd_retrofit.pojo.LoginUserResponse
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_email_login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                til_email_login.error = null
                til_password_login.error = null
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        et_password_login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                til_email_login.error = null
                til_password_login.error = null
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        btn_login.setOnClickListener {
            progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Loading")
            progressDialog.show()



            if (et_email_login.text.isNullOrEmpty() || et_password_login.text.isNullOrEmpty()) {
                Snackbar.make(it, "Email atau Password tidak boleh kosong", Snackbar.LENGTH_LONG)
                    .show()
                progressDialog.dismiss()
                if (et_email_login.text.isNullOrEmpty() && et_password_login.text.isNullOrEmpty()) {
                    til_email_login.error = " "
                    til_password_login.error = " "
                } else if (et_password_login.text.isNullOrEmpty()) {
                    til_password_login.error = " "
                } else {
                    til_email_login.error = " "
                }

            } else {
                val email = et_email_login.text.toString()
                val password = et_password_login.text.toString()
                val user = LoginUserBody(email, password)

                ApiClient.apiService.loginUser(user).enqueue(object : Callback<LoginUserResponse> {
                    override fun onResponse(
                        call: Call<LoginUserResponse>,
                        response: Response<LoginUserResponse>
                    ) {
                        val message = response.body()?.message
                        Log.d("BNR", "${response.body()?.message}")
                        Log.d("BNR", "${response.body()}")
                        if (message == "Login Success") {

                            val editor = getSharedPreferences(
                                DataLoginUser.SP_NAME,
                                Context.MODE_PRIVATE
                            ).edit()

                            editor.putString(
                                DataLoginUser.FIELD_EMAIL,
                                response.body()?.data?.email.toString()
                            )
                            editor.putString(
                                DataLoginUser.FIELD_USERNAME,
                                response.body()?.data?.username.toString()
                            )
                            editor.putString(
                                DataLoginUser.FIELD_ID,
                                response.body()?.data?.id.toString()
                            )
                            editor.commit()
                            goToMainACtivity()
                            progressDialog.dismiss()
                            Log.d("BNR", "${response.body()?.data?.username}")

                            Log.d("BNR", "${response.body()?.data?.email.toString()}")
                            Log.d("BNR", "${response.body()?.data?.username.toString()}")
                            Log.d("BNR", "${response.body()?.data?.id.toString()}")
                        } else {
                            progressDialog.dismiss()
                            Toast.makeText(
                                this@LoginActivity,
                                "Email atau Password salah",
                                Toast.LENGTH_SHORT
                            ).show()
                            til_email_login.error = " "
                            til_password_login.error = " "
                            Log.d("BNR", "${response.toString()} ${response.body()?.data?.email.toString()}")

                        }

                    }

                    override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Connection Failed", Toast.LENGTH_SHORT)
                            .show()
                        progressDialog.dismiss()
                    }

                })
            }
        }


        tv_daftar.setOnClickListener {
            startActivity(Intent(this, DaftarActivity::class.java))
        }
    }

    fun goToMainACtivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}