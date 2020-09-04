package com.example.gdd_retrofit.history

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gdd_retrofit.menuBattle.MainActivity
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.db.DatabaseHistoryBattle
import com.example.gdd_retrofit.db.ItemHistoryBattle
import com.example.gdd_retrofit.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment(), HistoryFragmentPresenter.Listener {

    private lateinit var presenter: HistoryFragmentPresenter
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DatabaseHistoryBattle.getInstance((activity as MainActivity))?.let {
            presenter = HistoryFragmentPresenter(it, this)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance(): HistoryFragment = HistoryFragment()
    }

    override fun showHistoryList(item: List<ItemHistoryBattle>) {
        activity?.runOnUiThread{
            val sharedPreference = activity?.getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val adapter = sharedPreference?.let { HistoryFragmentAdapter(item, presenter, it) }
            rv_history.layoutManager = LinearLayoutManager ((activity as MainActivity), LinearLayoutManager.VERTICAL, false)
            rv_history.adapter = adapter
        }
    }

    override fun showDeletedSuccess() {
        activity?.runOnUiThread{
            Toast.makeText((activity as MainActivity), "History game terhapus", Toast.LENGTH_LONG).show()
            presenter.fetchData()
        }
    }

    override fun showDeletedFailed() {
        activity?.runOnUiThread{
            Toast.makeText((activity as MainActivity), "History game gagal dihapus", Toast.LENGTH_LONG).show()
        }
    }
}