package com.example.gdd_retrofit


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gdd_retrofit.login.DataLoginUser
import kotlinx.android.synthetic.main.fragment_menu.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //nambahin hasil dari login untuk nama pemain
        val preferences = this.activity!!
            .getSharedPreferences(DataLoginUser.FIELD_ID, Context.MODE_PRIVATE)

        val bundle = this.activity!!
            .intent.extras

        val nama = preferences.getString(DataLoginUser.FIELD_USERNAME, "Belum ada data")

        tvVsPemain.setText("$nama VS Pemain 2")
        tvVsCom.setText("$nama VS CPU")


        //klik menu permainan : Pemain 1 vs Pemain 2
        ivVsPemain.setOnClickListener{
            val i = Intent (context, Pemain1vsPemain2::class.java)
            startActivity(i)
        }

        //klik pemain vs komputer
        ivVsCom.setOnClickListener{
            val i = Intent (context, PemainVsCPU::class.java)
            startActivity(i)
        }

        //klik menu close
        iv_close.setOnClickListener{
            val getActivity = this.activity!!
            getActivity.onBackPressed()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance(): MenuFragment = MenuFragment()
    }
}