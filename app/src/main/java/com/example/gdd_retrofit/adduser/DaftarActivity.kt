package com.example.gdd_retrofit.adduser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.pojo.PostUserBody
import kotlinx.android.synthetic.main.activity_daftar.*


class DaftarActivity : AppCompatActivity(), DaftarActivityPresenter.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val presenter = DaftarActivityPresenter(this)

        iv_back_daftar.setOnClickListener {
            presenter.goToBack()
        }

        btn_daftar.setOnClickListener {
            val boolean = et_email_daftar.text.isNullOrEmpty() || et_password_daftar.text.isNullOrEmpty() || et_username_daftar.text.isNullOrEmpty()
            val daftarUser = PostUserBody(
                    et_email_daftar.text.toString(),
                    et_password_daftar.text.toString(),
                    et_username_daftar.text.toString()
                )

            presenter.checkFieldEmpty(boolean, daftarUser, this@DaftarActivity)

        }

    }

    override fun goToBack() {
        finish()
    }
}