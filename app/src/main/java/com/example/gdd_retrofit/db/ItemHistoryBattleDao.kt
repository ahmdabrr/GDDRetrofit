package com.example.gdd_retrofit.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ItemHistoryBattleDao {
    @Query("SELECT * FROM ItemHistoryBattle")
    fun getAllHistory() : List<ItemHistoryBattle>

    @Insert(onConflict = REPLACE)
    fun insertHistory(item : ItemHistoryBattle):Long

    @Delete
    fun deleteHistory(item : ItemHistoryBattle):Int
}
