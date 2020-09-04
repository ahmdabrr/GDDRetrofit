package com.example.gdd_retrofit.history

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.db.ItemHistoryBattle
import com.example.gdd_retrofit.login.LoginActivity
import kotlinx.android.synthetic.main.recycleview_history.view.*

class HistoryFragmentAdapter(val listHistory: List<ItemHistoryBattle>, val presenter: HistoryFragmentPresenter, val sharedPreference: SharedPreferences): RecyclerView.Adapter<HistoryFragmentAdapter.ViewHolder>() {
    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pemainId = sharedPreference.getInt(LoginActivity.FIELD_ID, 0)
        if (pemainId == listHistory[position].pemainId) {
            holder.itemView.tv_tanggalSekarang.text = listHistory[position].hasil
            holder.itemView.tv_hasilKeterangan.text = listHistory[position].tanggal

            holder.itemView.iv_delete_history.setOnClickListener{
                presenter.delete(listHistory[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }
}