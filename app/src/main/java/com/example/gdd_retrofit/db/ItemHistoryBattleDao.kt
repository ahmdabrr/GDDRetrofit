package com.example.gdd_retrofit.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface ItemHistoryBattleDao {
    @Query("SELECT * FROM ItemHistoryBattle")
    fun getAllHistory() : List<ItemHistoryBattle>

    @Insert(onConflict = REPLACE)
    fun insertHistory(item : ItemHistoryBattle):Long

    @Delete
    fun deleteHistory(item: ItemHistoryBattle):Int

    @Update
    fun updateHistory (item : ItemHistoryBattle) : Int
}
