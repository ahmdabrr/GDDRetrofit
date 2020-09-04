package com.example.gdd_retrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [ItemHistoryBattle::class], version = 1)
abstract class DatabaseHistoryBattle : RoomDatabase() {
    abstract fun itemHistoryBattleDao() : ItemHistoryBattleDao

    companion object {
        private var INSTANCE: DatabaseHistoryBattle? = null

        fun getInstance(context: Context) :DatabaseHistoryBattle? {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder (
                            context,
                            DatabaseHistoryBattle::class.java,
                            "item_db"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}