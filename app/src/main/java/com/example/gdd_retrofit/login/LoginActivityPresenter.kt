package com.example.gdd_retrofit.login

import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Toast
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.LoginUserBody
import com.example.gdd_retrofit.pojo.LoginUserResponse
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(val listener: Listener) {

    fun clearErrorText() {
        listener.clearErrorText()
    }

    fun showErrorBorder() {
        listener.showErrorBorder()
    }

    fun showProgressDialog(context: Context) {
        val pd = ProgressDialog(context)
        pd.setMessage("Loading")
        pd.show()
    }

    fun dismissProgressDialog(context: Context) {
        val pd = ProgressDialog(context)
        pd.dismiss()
    }

    fun makeSnackBar(view: View, string: String) {
        Snackbar.make(view, string, Snackbar.LENGTH_LONG).show()
    }

    fun goToMainACtivity() {
        listener.goToMainACtivity()
    }

    fun goToDaftarActivity() {
        listener.goToDaftarActivity()
    }


    fun checkLogin(user: LoginUserBody, editor: SharedPreferences.Editor, context: Context) {
        ApiClient.apiService.loginUser(user).enqueue(object : Callback<LoginUserResponse> {
            override fun onResponse(
                call: Call<LoginUserResponse>,
                response: Response<LoginUserResponse>
            ) {
                val message = response.body()?.message
//                        Log.d("BNR", "${response.body()?.message}")
//                        Log.d("BNR", "${response.body()}")
                if (message == "Login Success") {

//                    val editor = getSharedPreference(
//                        DataLoginUser.SP_NAME,
//                        Context.MODE_PRIVATE
//                    ).edit()

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
                    editor.apply()
                    goToMainACtivity()
                    dismissProgressDialog(context)

                } else {
                    dismissProgressDialog(context)
                    Toast.makeText(
                        context,
                        "Email atau Password salah",
                        Toast.LENGTH_SHORT
                    ).show()
                    showErrorBorder()

                }

            }

            override fun onFailure(call: Call<LoginUserResponse>, t: Throwable) {
                Toast.makeText(context, "Connection Failed", Toast.LENGTH_SHORT)
                    .show()
                dismissProgressDialog(context)
            }

        })
    }


    fun checkFieldEmpty(
        boolean: Boolean,
        view: View,
        context: Context,
        user: LoginUserBody,
        editor: SharedPreferences.Editor
    ) {
        if (boolean) {
            makeSnackBar(view, "Email atau Password tidak boleh kosong")
            dismissProgressDialog(context)
            showErrorBorder()
        } else {
            checkLogin(user, editor, context)
        }
    }


    interface Listener {
        fun clearErrorText()
        fun showErrorBorder()
        fun goToMainACtivity()
        fun goToDaftarActivity()
    }
}