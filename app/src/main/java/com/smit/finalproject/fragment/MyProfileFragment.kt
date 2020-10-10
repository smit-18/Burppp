package com.smit.finalproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.smit.finalproject.R


lateinit var txtName: TextView
lateinit var txtAddress: TextView
lateinit var txtEmail: TextView
lateinit var txtMobile: TextView
lateinit var sharedPreferences: SharedPreferences


class MyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_my_profile, container, false)

        txtName=view.findViewById(R.id.txtName)
        txtAddress=view.findViewById(R.id.txtAddress)
        txtEmail=view.findViewById(R.id.txtEmail)
        txtMobile=view.findViewById(R.id.txtMobile)

        sharedPreferences=activity!!.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        txtName.text= sharedPreferences.getString("user_name","")
        txtEmail.text= sharedPreferences.getString("user_email","")
        txtAddress.text= sharedPreferences.getString("user_address","")
        txtMobile.text= sharedPreferences.getString("user_mobile_number","")

        return view
    }
}
