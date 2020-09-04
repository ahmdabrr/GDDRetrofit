package com.example.gdd_retrofit.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize

data class ItemHistoryBattle(
    @PrimaryKey (autoGenerate = true) var tanggal : String,
    @ColumnInfo (name = "hasil") var hasil : String
) : Parcelable