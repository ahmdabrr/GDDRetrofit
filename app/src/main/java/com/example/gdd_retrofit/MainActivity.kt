package com.example.gdd_retrofit

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gdd_retrofit.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val gbk = listOf("batu", "gunting", "kertas")

        val view = binding.root
        var pilihan: String
        var pilihanCom: String

        binding.ivBatuPemain.setOnClickListener{
            pilihan = "batu"
            Log.d("pilihan user", pilihan)
            pilihanCom = gbk.random()

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_transparan)

            when (pilihanCom) {
                "batu" -> {
                    binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                    Log.d("hasil pertandingan", "Seimbang")
                }
                "gunting" -> {
                    binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                    Log.d("hasil pertandingan", "Pemain Menang")
                }
                "kertas" -> {
                    binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                    Log.d("hasil pertandingan", "Computer Menang")
                }
            }
        }

        binding.ivGuntingPemain.setOnClickListener {
            pilihan = "gunting"
            Log.d("pilihan user", pilihan)

            pilihanCom = gbk.random()

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)

            when (pilihanCom) {
                "batu" -> {
                    binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                    Log.d("hasil pertandingan", "Computer Menang")
                }
                "gunting" -> {
                    binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                    Log.d("hasil pertandingan", "Seimbang")
                }
                "kertas" -> {
                    binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                    Log.d("hasil pertandingan", "Pemain Menang")
                }
            }
        }

        binding.ivKertasPemain.setOnClickListener {
            pilihan = "kertas"
            Log.d("pilihan user", pilihan)

            pilihanCom = gbk.random()

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_transparan)

            when (pilihanCom) {
                "batu" -> {
                    binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                    Log.d("hasil pertandingan", "Pemain Menang")
                }
                "gunting" -> {
                    binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                    Log.d("hasil pertandingan", "Computer Menang")
                }
                "kertas" -> {
                    binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                    binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                    Log.d("hasil pertandingan", "Seimbang")
                }
            }
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

        binding.ivSave.setOnClickListener {
            binding.ivSave.background = resources.getDrawable(R.drawable.ic_save_active)
        }

        binding.ivArrowBack.setOnClickListener {
            moveTaskToBack(true)
        }

        setContentView(view)
    }
}