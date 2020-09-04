package com.example.gdd_retrofit.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ItemHistoryBattleDao {
    @Query("SELECT * FROM ItemHistoryBattle")
    fun getAllItem() : List<ItemHistoryBattle>

    @Insert(onConflict = REPLACE)
    fun insertItem(item : ItemHistoryBattle):Long

    @Delete
    fun deleteItem(item : ItemHistoryBattle):Int
}
