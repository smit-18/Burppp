package com.smit.finalproject.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.util.ConnectionManager
import org.json.JSONException
import org.json.JSONObject

class ForgotPassActivity : AppCompatActivity() {

    lateinit var etForgotMobileNumber: EditText
    lateinit var etEmailId: EditText
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        etForgotMobileNumber = findViewById(R.id.etForgotMobileNumber)
        etEmailId = findViewById(R.id.etEmailId)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            val number = etForgotMobileNumber.text.toString()
            val email = etEmailId.text.toString()

            val queue = Volley.newRequestQueue(this@ForgotPassActivity)
            val url = "http://13.235.250.119/v2/forgot_password/fetch_result"

            val jsonParams = JSONObject()
            jsonParams.put("mobile_number", number)
            jsonParams.put("email", email)

            if(ConnectionManager().checkConnectivity(this@ForgotPassActivity)) {

                val jsonRequest = object :
                    JsonObjectRequest(Request.Method.POST, url, jsonParams, Response.Listener {

                        try {

                            val data = it.getJSONObject("data")
                            val success = data.getBoolean("success")

                            if (success) {
                                val firstTry = data.getBoolean("first_try")
                                Toast.makeText(
                                    this@ForgotPassActivity,
                                    "OTP sent successfully",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(
                                    this@ForgotPassActivity,
                                    OtpActivity::class.java
                                )
                                intent.putExtra("number", number)
                                startActivity(intent)
                            } else {

                                Toast.makeText(
                                    this@ForgotPassActivity,
                                    "Incorrect mobile number or password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }catch (e: JSONException){
                            Toast.makeText(this@ForgotPassActivity,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                        }
                    }, Response.ErrorListener {

                        Toast.makeText(
                            this@ForgotPassActivity,
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
            }else{
                    val dialog= AlertDialog.Builder(this@ForgotPassActivity)
                    dialog.setTitle("Error")
                    dialog.setMessage("Internet Connection is not Found")
                    dialog.setPositiveButton("Open Settings"){text, listener ->
                        val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                        startActivity(settingsIntent)
                        this@ForgotPassActivity?.finish()
                    }
                    dialog.setNegativeButton("Exit"){text, listener ->
                        ActivityCompat.finishAffinity(this@ForgotPassActivity)
                    }
                    dialog.create()
                    dialog.show()
            }
        }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

    override fun onBackPressed() {
        when(applicationContext) {
            !is LoginActivity -> startActivity(
                Intent(
                    this@ForgotPassActivity,
                    LoginActivity::class.java
                )
            )
           else -> super.onBackPressed()
        }
    }
}