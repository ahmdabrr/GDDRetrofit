package com.example.gdd_retrofit.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.profile.edituser.EditEmailFragment
import com.example.gdd_retrofit.profile.edituser.EditUsernameFragment
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
class ProfileFragment : Fragment(), ProfileFragmentPresenter.Listener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var presenter: ProfileFragmentPresenter? = null
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

        presenter = ProfileFragmentPresenter(this)

        et_profile_username.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> presenter!!.showEditUsernameDialog(it1) }
        }

        et_profile_email.setOnClickListener {
            activity?.supportFragmentManager?.let { it1 -> presenter!!.showEditEmailDialog(it1) }
        }

    }

    override fun onResume() {
        super.onResume()
//        presenter = ProfileFragmentPresenter(this)
        val sharedPreference =
            activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)
//        Log.d("BNR", "${sharedPreference}")

        val name = sharedPreference?.let { presenter?.getName(it) }
        val email = sharedPreference?.let { presenter?.getEmail(it) }
//        Log.d("BNR", "${name} ${email}")
        et_profile_username.setText(name)
        et_profile_email.setText(email)
    }

    companion object {
        fun getInstance(): ProfileFragment = ProfileFragment()
    }
}