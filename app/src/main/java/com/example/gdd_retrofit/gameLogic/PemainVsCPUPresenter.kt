package com.example.gdd_retrofit.gameLogic

import android.util.Log
import com.example.gdd_retrofit.db.DatabaseHistoryBattle
import com.example.gdd_retrofit.db.ItemHistoryBattle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class PemainVsCPUPresenter (private val db: DatabaseHistoryBattle, private val listener: Listener) {
    private lateinit var pilihan: String
    private lateinit var pilihanPemain2: String
    private lateinit var hasil: String
    private lateinit var tanggal: String

    private val gbk = listOf("batu", "gunting", "kertas")

    interface Listener{
        fun tampilHasilMenang()
        fun tampilHasilKalah()
        fun tampilHasilDraw()
        fun batuOnCLick()
        fun guntingOnClick()
        fun kertasOnClick()
        fun batuCom()
        fun kertasCom()
        fun guntingCom()

        fun loveOnClick()

        fun showSaveSuccess()
        fun showSaveFailed()
    }

    fun batuClick(){
        listener.batuOnCLick()
    }

    fun guntingClick(){
        listener.guntingOnClick()
    }

    fun kertasClick(){
        listener.kertasOnClick()
    }

    fun menampilkanHasil(nama: String){
        when(hasil){
            "$nama menang" -> listener.tampilHasilMenang()
            "$nama kalah" -> listener.tampilHasilKalah()
            "$nama draw" -> listener.tampilHasilDraw()
        }
    }

    fun setPilihanPemainSatu(input: String) {
        pilihan = input

        setPilihanPemainDua()

        Log.d("Pilihan Pemain", "Pilihan : $pilihan")
    }

    private fun setPilihanPemainDua() {
        pilihanPemain2 = gbk.random()

        when(pilihanPemain2){
            "batu" -> listener.batuCom()
            "kertas" -> listener.kertasCom()
            "gunting" -> listener.guntingCom()
        }

        Log.d("Pilihan Pemain 2", "Pilihan : $pilihanPemain2")
    }

    fun logicGame(nama: String){
        when (pilihan){
            "batu" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama draw"
                "gunting" -> hasil = "$nama menang"
                "kertas" -> hasil = "$nama kalah"
            }
            "gunting" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama kalah"
                "gunting" -> hasil = "$nama draw"
                "kertas" -> hasil = "$nama menang"
            }
            "kertas" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama menang"
                "gunting" -> hasil = "$nama kalah"
                "kertas" -> hasil = "$nama draw"
            }
        }
    }

    private fun getTanggal(){
        tanggal = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date())
    }

    fun loveClick(pemainId:Int) {
        getTanggal()

        val item = ItemHistoryBattle(null, pemainId, tanggal, hasil)
        saveHistory(item)

        listener.loveOnClick()
    }
    private fun saveHistory(item: ItemHistoryBattle){
        GlobalScope.launch {
            val totalSaved = db.ItemHistoryBattleDao().insertHistory(item)

            Log.d("Hasil", "${item.hasil}, ${item.tanggal}")
            if (totalSaved > 0) {
                listener.showSaveSuccess()
            } else {
                listener.showSaveFailed()
            }
        }
    }



}