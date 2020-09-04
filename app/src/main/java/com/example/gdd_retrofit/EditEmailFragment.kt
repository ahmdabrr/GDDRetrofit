package com.example.gdd_retrofit

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.gdd_retrofit.login.DataLoginUser
import com.example.gdd_retrofit.network.ApiClient
import com.example.gdd_retrofit.pojo.PutUserBody
import com.example.gdd_retrofit.pojo.PutUserResponse
import kotlinx.android.synthetic.main.fragment_edit_email.*
import kotlinx.android.synthetic.main.fragment_edit_username.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditEmailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEmailFragment : DialogFragment() {
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
        return inflater.inflate(R.layout.fragment_edit_email, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreference =
            activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)

        var email = sharedPreference?.getString(DataLoginUser.FIELD_EMAIL, "")
        val id = sharedPreference?.getString(DataLoginUser.FIELD_ID, "0")
        et_edit_email.setText(email)

        tv_cancel_edit_email.setOnClickListener {
            dismiss()
        }

        tv_update_email.setOnClickListener {

            Log.d("BNR", email.toString())
            val objectEdit =
                PutUserBody(
                    "",
                    et_edit_email.text.toString()
                )

            ApiClient.apiService.updateUser(objectEdit, id.toString()).enqueue(object :
                Callback<PutUserResponse> {
                override fun onResponse(
                    call: Call<PutUserResponse>,
                    response: Response<PutUserResponse>
                ) {
                    val sharedPreference1 =
                        activity?.getSharedPreferences(DataLoginUser.SP_NAME, Context.MODE_PRIVATE)
                    val editor = sharedPreference1?.edit()
                    val email = et_edit_email.text.toString()
                    editor?.putString(DataLoginUser.FIELD_EMAIL, email)
                    editor?.apply()
                    Log.d("BNR", email)
                    Log.d("BNR", sharedPreference1?.getString(DataLoginUser.FIELD_USERNAME, "").toString())
                    Toast.makeText(context, "Update Email success", Toast.LENGTH_SHORT).show()
                    dismiss()
                }

                override fun onFailure(call: Call<PutUserResponse>, t: Throwable) {
                    Log.d("BNR", t.message.toString())
                }

            })

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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditEmailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance():EditEmailFragment{
            return EditEmailFragment()
        }
    }
}