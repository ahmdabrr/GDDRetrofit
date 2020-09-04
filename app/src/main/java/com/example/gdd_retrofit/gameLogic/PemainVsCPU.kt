package com.example.gdd_retrofit.gameLogic

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.databinding.ActivityPemainVsCPUBinding
import com.example.gdd_retrofit.db.DatabaseHistoryBattle
import com.example.gdd_retrofit.login.LoginActivity

class PemainVsCPU : AppCompatActivity(), PemainVsCPUPresenter.Listener {
    private lateinit var binding: ActivityPemainVsCPUBinding
    private lateinit var presenter: PemainVsCPUPresenter
    private var nama: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPemainVsCPUBinding.inflate(layoutInflater)
        DatabaseHistoryBattle.getInstance(this)?.let {
            presenter = PemainVsCPUPresenter(it, this)
        }

        val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)

        nama = sharedPreferences.getString(LoginActivity.FIELD_USERNAME, " ")

        binding.tvPemain.text = nama

        val view = binding.root

        binding.ivBatuPemain.setOnClickListener {
            presenter.batuClick()
        }

        binding.ivGuntingPemain.setOnClickListener {
            presenter.guntingClick()
        }

        binding.ivKertasPemain.setOnClickListener {
            presenter.kertasClick()
        }

        binding.ivRestart.setOnClickListener {
            binding.ivBatuPemain.isClickable = true
            binding.ivGuntingPemain.isClickable = true
            binding.ivKertasPemain.isClickable = true
            binding.ivKertasCom.setBackgroundResource(0)
            binding.ivBatuCom.setBackgroundResource(0)
            binding.ivGuntingCom.setBackgroundResource(0)

            binding.ivKertasPemain.setBackgroundResource(0)
            binding.ivBatuPemain.setBackgroundResource(0)
            binding.ivGuntingPemain.setBackgroundResource(0)

            binding.ivHasilPertandingan.setImageResource(R.drawable.vs)
        }

        binding.ivArrowBack.setOnClickListener {
            finish()
        }

        setContentView(view)
    }

    override fun tampilHasilMenang() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun tampilHasilKalah() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun tampilHasilDraw() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun batuOnCLick() {
        presenter.setPilihanPemainSatu("batu")
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun guntingOnClick() {
        presenter.setPilihanPemainSatu("gunting")
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun kertasOnClick() {
        presenter.setPilihanPemainSatu("kertas")
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun batuCom() {
        binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun kertasCom() {
        binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun guntingCom() {
        binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
    }

    override fun loveOnClick() {
        binding.ivSave.setImageResource(R.drawable.ic_save_active)
        binding.ivSave.isClickable = false
    }

    override fun showSaveSuccess() {
        runOnUiThread {
            Toast.makeText(this, "History data disimpan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showSaveFailed() {
        runOnUiThread {
            Toast.makeText(this, "Gagal disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}