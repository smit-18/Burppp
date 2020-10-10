package com.smit.finalproject.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.util.ConnectionManager
import org.json.JSONException
import org.json.JSONObject

class OtpActivity : AppCompatActivity() {

    private lateinit var btnSubmit: Button
    private lateinit var etNewPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var etOtp: EditText

    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        btnSubmit = findViewById(R.id.btnSubmit)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etNewPassword = findViewById(R.id.etNewPassword)
        etOtp = findViewById(R.id.etOTP)

        btnSubmit.setOnClickListener {

            if(ConnectionManager().checkConnectivity(this@OtpActivity)){

            if (etNewPassword.text.toString() == etConfirmPassword.text.toString()) {

                val queue = Volley.newRequestQueue(this@OtpActivity)
                val url = "http://13.235.250.119/v2/reset_password/fetch_result"

                val number = intent.getStringExtra("number")

                val jsonParams = JSONObject()
                jsonParams.put("mobile_number", number)
                jsonParams.put("password", etNewPassword.text.toString())
                jsonParams.put("otp", etOtp.text.toString())

                val jsonRequest = object :
                    JsonObjectRequest(Request.Method.POST, url, jsonParams, Response.Listener {

                        try {

                            val data = it.getJSONObject("data")
                            val success = data.getBoolean("success")

                            if (success) {

                                val response = data.getString("successMessage")

                                Toast.makeText(this@OtpActivity, response, Toast.LENGTH_SHORT)
                                    .show()

                                sharedPreferences.edit().clear().apply()
                                val intent = Intent(this@OtpActivity, LoginActivity::class.java)
                                startActivity(intent)

                            } else {
                                Toast.makeText(
                                    this@OtpActivity,
                                    "Some Error Occurred",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }catch (e: JSONException){
                            Toast.makeText(this@OtpActivity,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                        }
                    }
                        , Response.ErrorListener {

                            Toast.makeText(
                                this@OtpActivity,
                                "Volley Error Occurred",
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
                Toast.makeText(this@OtpActivity,"The passwords don't match",Toast.LENGTH_SHORT).show()
                }
            }else{
                val dialog= AlertDialog.Builder(this@OtpActivity)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection is not Found")
                dialog.setPositiveButton("Open Settings"){text, listener ->
                    val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(settingsIntent)
                    this@OtpActivity?.finish()
                }
                dialog.setNegativeButton("Exit"){text, listener ->
                    ActivityCompat.finishAffinity(this@OtpActivity)
                }
                dialog.create()
                dialog.show()
            }
        }
    }
}

