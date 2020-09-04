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
import kotlinx.android.synthetic.main.fragment_edit_email.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditEmailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEmailFragment : DialogFragment(), EditEmailFragmentPresenter.Listener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val presenter: EditEmailFragmentPresenter? = null

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
        return inflater.inflate(R.layout.fragment_edit_email, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = EditEmailFragmentPresenter(this)

        val sharedPreference =
            activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)

        var email = sharedPreference?.let { presenter.getEmail(it) }
        et_edit_email.setText(email)

        tv_cancel_edit_email.setOnClickListener {
            presenter.dismissDialog()
        }

        tv_update_email.setOnClickListener {
            val email = et_edit_email.text.toString()
            Log.d("BNR", email.toString())
            val objectEdit =
                PutUserBody(
                    "",
                    email
                )

            if (sharedPreference != null) {
                presenter.editUser(objectEdit,it.context,sharedPreference,email)
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
        fun newInstance(): EditEmailFragment {
            return EditEmailFragment()
        }
    }

    override fun dismissDialog() {
        dismiss()
    }
}