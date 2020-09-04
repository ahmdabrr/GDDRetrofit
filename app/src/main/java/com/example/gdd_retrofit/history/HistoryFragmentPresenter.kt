package com.example.gdd_retrofit.history

import com.example.gdd_retrofit.db.DatabaseHistoryBattle
import com.example.gdd_retrofit.db.ItemHistoryBattle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryFragmentPresenter (val db:DatabaseHistoryBattle, val listener : Listener) {
    interface Listener {
        fun showHistoryList(item : List <ItemHistoryBattle>)
        fun showDeletedSuccess()
        fun showDeletedFailed()
    }

    fun delete (item: ItemHistoryBattle) {
        GlobalScope.launch {
            val rowDelete = db.ItemHistoryBattleDao().deleteHistory(item)
            if (rowDelete > 0 ) {
                listener.showDeletedSuccess()
            } else {
                listener.showDeletedFailed()
            }
        }
    }

    fun fetchData() {
        GlobalScope.launch {
            val listHistory = db.ItemHistoryBattleDao().getAllHistory()
            listener.showHistoryList(listHistory)
        }
    }
}