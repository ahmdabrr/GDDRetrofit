package com.example.gdd_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gdd_retrofit.databinding.ActivityPemainVsCPUBinding
import kotlin.system.exitProcess

class Pemain1vsPemain2 : AppCompatActivity() {
    lateinit var binding: ActivityPemainVsCPUBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPemainVsCPUBinding.inflate(layoutInflater)

        val view = binding.root
        var pilihan = ""
        var pilihanCom = ""

        binding.tvComputer.setText("Pemain 2")

        binding.tvComputer.setText("Pemain 2")

        binding.ivBatuPemain.setOnClickListener{
            pilihan = "batu"
            Log.d("pilihan user", pilihan)

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_transparan)

            binding.ivBatuCom.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
            }

            binding.ivGuntingCom.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }

            binding.ivKertasCom.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }
        }

        binding.ivGuntingPemain.setOnClickListener {
            pilihan = "gunting"
            Log.d("pilihan user", pilihan)

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_transparan)

            binding.ivBatuCom.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }

            binding.ivGuntingCom.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
            }

            binding.ivKertasCom.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }
        }

        binding.ivKertasPemain.setOnClickListener {
            pilihan = "kertas"
            Log.d("pilihan user", pilihan)

            binding.ivBatuPemain.isClickable = false
            binding.ivGuntingPemain.isClickable = false
            binding.ivKertasPemain.isClickable = false

            binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_transparan)

            binding.ivBatuCom.setOnClickListener{
                pilihanCom = "batu"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
                Log.d("hasil pertandingan", "Pemain Menang")
            }

            binding.ivGuntingCom.setOnClickListener {
                pilihanCom = "gunting"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.komputer_menang)
                Log.d("hasil pertandingan", "Computer Menang")
            }

            binding.ivKertasCom.setOnClickListener {
                pilihanCom = "kertas"
                Log.d("pilihan user 2", pilihanCom)

                binding.ivBatuCom.isClickable = false
                binding.ivGuntingCom.isClickable = false
                binding.ivKertasCom.isClickable = false

                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_transparan)
                binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
                Log.d("hasil pertandingan", "Seimbang")
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