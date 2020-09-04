package com.example.gdd_retrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gdd_retrofit.databinding.FragmentProfileBinding
import com.example.gdd_retrofit.login.DataLoginUser
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_profile_username.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 ->
                EditUsernameFragment.newInstance().show(
                    it1, null)
            }
        }

        et_profile_email.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 ->
                EditEmailFragment.newInstance().show(
                    it1, null)
            }
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedPreference =
            activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)
        Log.d("BNR", "${sharedPreference}")
        val name = sharedPreference?.getString(DataLoginUser.FIELD_USERNAME, "")
        val email = sharedPreference?.getString(DataLoginUser.FIELD_EMAIL, "")
        Log.d("BNR", "${name} ${email}")
        et_profile_username.setText(name)
        et_profile_email.setText(email)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance(): ProfileFragment = ProfileFragment()
    }
}