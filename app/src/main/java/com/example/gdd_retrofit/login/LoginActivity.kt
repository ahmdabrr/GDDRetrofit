package com.example.gdd_retrofit.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.gdd_retrofit.menuBattle.MainActivity
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.adduser.DaftarActivity
import com.example.gdd_retrofit.pojo.LoginUserBody
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginActivityPresenter.Listener {


    companion object {
        const val SP_NAME = "login_data"
        const val FIELD_ID = "iD"
        const val FIELD_USERNAME = "username"
        const val FIELD_EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val presenter = LoginActivityPresenter(this)

        et_email_login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.clearErrorText()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        et_password_login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.clearErrorText()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        btn_login.setOnClickListener {
            presenter.showProgressDialog(this)
            var email = et_email_login.text.isNullOrEmpty()
            var password = et_password_login.text.isNullOrEmpty()
            val boolean = email || password

            val emailLogin = et_email_login.text.toString()
            val passwordLogin = et_password_login.text.toString()
            val user = LoginUserBody(emailLogin, passwordLogin)

            val editor = getSharedPreferences(
                DataLoginUser.SP_NAME,
                Context.MODE_PRIVATE
            ).edit()

            presenter.checkFieldEmpty(boolean, it, this@LoginActivity, user, editor)

        }


        tv_daftar.setOnClickListener {
            presenter.goToDaftarActivity()
        }
    }

    override fun goToMainACtivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun goToDaftarActivity() {
        startActivity(Intent(this, DaftarActivity::class.java))
    }

    override fun clearErrorText() {
        til_email_login.error = null
        til_password_login.error = null
    }

    override fun showErrorBorder() {
        til_email_login.error = " "
        til_password_login.error = " "
    }

}