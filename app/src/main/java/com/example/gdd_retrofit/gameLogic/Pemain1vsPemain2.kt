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

class Pemain1vsPemain2 : AppCompatActivity(), Pemain1vsPemain2Presenter.Listener {
    private lateinit var binding: ActivityPemainVsCPUBinding
    private lateinit var presenter: Pemain1vsPemain2Presenter
    private var nama: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPemainVsCPUBinding.inflate(layoutInflater)

        val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)

        DatabaseHistoryBattle.getInstance(this)?.let {
            presenter = Pemain1vsPemain2Presenter(it, this)
        }
        val view = binding.root

        nama = sharedPreferences.getString("username", "")
        binding.tvPemain.text = nama
        binding.tvComputer.text = "Pemain 2"

        binding.ivBatuPemain.setOnClickListener {
            presenter.batuP1()
        }

        binding.ivGuntingPemain.setOnClickListener {
            presenter.guntingP1()
        }

        binding.ivKertasPemain.setOnClickListener {
            presenter.kertasP1()
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

    override fun batuP1onClick() {
        presenter.setPilihanPemainSatu("batu")

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_transparan)

        binding.ivBatuCom.setOnClickListener {
            presenter.batuP2()
        }

        binding.ivGuntingCom.setOnClickListener {
            presenter.guntingP2()
        }

        binding.ivKertasCom.setOnClickListener {
            presenter.kertasP2()
        }
    }

    override fun guntingP1onClick() {
        presenter.setPilihanPemainSatu("gunting")

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)

        binding.ivBatuCom.setOnClickListener {
            presenter.batuP2()
        }

        binding.ivGuntingCom.setOnClickListener {
            presenter.guntingP2()
        }

        binding.ivKertasCom.setOnClickListener {
            presenter.kertasP2()
        }
    }

    override fun kertasP1onClick() {
        presenter.setPilihanPemainSatu("kertas")

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_transparan)

        binding.ivBatuCom.setOnClickListener {
            presenter.batuP2()
        }

        binding.ivGuntingCom.setOnClickListener {
            presenter.guntingP2()
        }

        binding.ivKertasCom.setOnClickListener {
            presenter.kertasP2()
        }
    }

    override fun batuP2onCLick() {
        presenter.setPilihanPemainDua("batu")

        binding.ivBatuCom.isClickable = false
        binding.ivGuntingCom.isClickable = false
        binding.ivKertasCom.isClickable = false

        binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)

        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }
    }

    override fun guntingP2onCLick() {
        presenter.setPilihanPemainDua("gunting")

        binding.ivBatuCom.isClickable = false
        binding.ivGuntingCom.isClickable = false
        binding.ivKertasCom.isClickable = false

        binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)

        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }
    }

    override fun kertasP2onClick() {
        presenter.setPilihanPemainDua("kertas")

        binding.ivBatuCom.isClickable = false
        binding.ivGuntingCom.isClickable = false
        binding.ivKertasCom.isClickable = false

        binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)

        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.ivSave.setOnClickListener {
            val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val pemainId = sharedPreferences.getInt(LoginActivity.FIELD_ID, 0)
            presenter.loveClick(pemainId)
        }
    }

    override fun loveOnClick() {
        binding.ivSave.setImageResource(R.drawable.ic_save_active)
        binding.ivSave.isClickable = false
    }

    override fun showSaveSuccess() {
        runOnUiThread {
            Toast.makeText(this, "Data telah disimpan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showSaveFailed() {
        runOnUiThread {
            Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}