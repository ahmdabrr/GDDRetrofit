package com.example.gdd_retrofit.profile.edituser

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.gdd_retrofit.R
import com.example.gdd_retrofit.login.DataLoginUser
import com.example.gdd_retrofit.pojo.PutUserBody
import kotlinx.android.synthetic.main.fragment_edit_username.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditUsernameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditUsernameFragment : DialogFragment(), EditUsernameFragmentPresenter.Listener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var presenter:EditUsernameFragmentPresenter? = null

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
        return inflater.inflate(R.layout.fragment_edit_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = EditUsernameFragmentPresenter(this)
        val sharedPreference =
            activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)
        var name = sharedPreference?.let { presenter.getName(it) }

        et_edit_username.setText(name)

        tv_cancel_edit.setOnClickListener {
            presenter.dismissDialog()
        }

        tv_update.setOnClickListener {
            val nama = et_edit_username.text.toString()
            Log.d("BNR", name.toString())
            val objectEdit =
                PutUserBody(
                    nama,
                    ""
                )
            if (sharedPreference != null) {
                presenter.editUser(objectEdit,it.context,sharedPreference,nama)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(): EditUsernameFragment {
            return EditUsernameFragment()
        }
    }

    override fun dismissDialog() {
        dismiss()
    }
}