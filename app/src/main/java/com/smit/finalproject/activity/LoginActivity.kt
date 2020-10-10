package com.smit.finalproject.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.se.omapi.Session
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.fragment.HomeFragment
import com.smit.finalproject.util.ConnectionManager
import org.json.JSONException
import org.json.JSONObject

class LoginActivity() : AppCompatActivity() {

    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var txtForgotPassword: TextView
    private lateinit var txtRegister: TextView

    lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        if(isLoggedIn){
            val intent=Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)


        btnLogin.setOnClickListener {

            val queue = Volley.newRequestQueue(this@LoginActivity)
            val url = "http://13.235.250.119/v2/login/fetch_result"

            val jsonParams = JSONObject()
            jsonParams.put("mobile_number", etMobileNumber.text.toString())
            jsonParams.put("password", etPassword.text.toString())

            if (ConnectionManager().checkConnectivity(this@LoginActivity)) {

                val jsonRequest =
                    object :
                        JsonObjectRequest(Request.Method.POST, url, jsonParams, Response.Listener {

                            try {

                                val data = it.getJSONObject("data")
                                val success = data.getBoolean("success")
                                if (success) {
                                    val response = data.getJSONObject("data")
                                    sharedPreferences.edit()
                                        .putString("user_id", response.getString("user_id")).apply()
                                    sharedPreferences.edit()
                                        .putString("user_name", response.getString("name")).apply()
                                    sharedPreferences.edit()
                                        .putString(
                                            "user_mobile_number",
                                            response.getString("mobile_number")
                                        )
                                        .apply()
                                    sharedPreferences.edit()
                                        .putString("user_address", response.getString("address"))
                                        .apply()
                                    sharedPreferences.edit()
                                        .putString("user_email", response.getString("email"))
                                        .apply()

                                    val intent =
                                        Intent(this@LoginActivity, MainActivity::class.java)
                                    savePreferences()
                                    startActivity(intent)

                                }
                            }catch (e: JSONException){
                                Toast.makeText(this@LoginActivity,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                            }

                        }, Response.ErrorListener {

                            Toast.makeText(
                                this@LoginActivity,
                                "Invalid Login credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            override fun getHeaders(): MutableMap<String, String> {

                                val headers = HashMap<String, String>()
                                headers["Content-type"] = "application/json"
                                headers["token"] = "326a253b6b58cc"
                                return headers
                            }
                    }
                queue.add(jsonRequest)
            }
                else{
                    val dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("Error")
                    dialog.setMessage("INTERNET CONNECTION IS NOT FOUND")
                    dialog.setPositiveButton("Open Settings"){text,listner ->
                        val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                        startActivity(settingsIntent)
                        finish()
                    }
                    dialog.setNegativeButton("Exit"){text,listener->
                        ActivityCompat.finishAffinity(this@LoginActivity)
                    }
                    dialog.create()
                    dialog.show()
                }
            }
            txtRegister.setOnClickListener {

                val intent = Intent(
                    this@LoginActivity,
                    RegisterActivity::class.java
                )
                startActivity(intent)
            }
            txtForgotPassword.setOnClickListener {

                val intent = Intent(
                    this@LoginActivity,
                    ForgotPassActivity::class.java
                )
                startActivity(intent)
            }
     }
    override fun onPause() {
        finish()
        super.onPause()
    }

    fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }
}
