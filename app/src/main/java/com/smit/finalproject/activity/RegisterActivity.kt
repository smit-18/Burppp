package com.smit.finalproject.activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.EditText
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

class RegisterActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etRegisterEmailId: EditText
    lateinit var etRegisterMobileNumber: EditText
    lateinit var etRegisterAddress: EditText
    lateinit var etRegisterPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnRegister: Button

    lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        etName = findViewById(R.id.etName)
        etRegisterEmailId = findViewById(R.id.etRegisterEmailId)
        etRegisterMobileNumber = findViewById(R.id.etRegisterMobileNumber)
        etRegisterAddress = findViewById(R.id.etRegisterAddress)
        etRegisterPassword = findViewById(R.id.etRegisterPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

            if (etRegisterPassword.text.toString() == etConfirmPassword.text.toString()) {

                val queue = Volley.newRequestQueue(this@RegisterActivity)
                val url = "http://13.235.250.119/v2/register/fetch_result"

                val name=etName.text.toString()
                val phone=etRegisterMobileNumber.text.toString()
                val password=etRegisterPassword.text.toString()
                val address=etRegisterAddress.text.toString()
                val email=etRegisterEmailId.text.toString()

                val jsonParams = JSONObject()
                jsonParams.put("name", name)
                jsonParams.put("mobile_number", phone)
                jsonParams.put("password", password)
                jsonParams.put("address", address)
                jsonParams.put("email", email)

                if(ConnectionManager().checkConnectivity(this@RegisterActivity)) {

                    val jsonRequest = object :
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
                                    sharedPreferences.edit().putString(
                                        "user_mobile_number",
                                        response.getString("mobile_number")
                                    ).apply()
                                    sharedPreferences.edit()
                                        .putString("user_address", response.getString("address"))
                                        .apply()
                                    sharedPreferences.edit()
                                        .putString("user_email", response.getString("email"))
                                        .apply()

                                    if (isLoggedIn) {
                                        val intent =
                                            Intent(this@RegisterActivity, MainActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        val intent =
                                            Intent(this@RegisterActivity, LoginActivity::class.java)
                                        startActivity(intent)
                                    }
                                } else {
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "User already registered",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent =
                                        Intent(this@RegisterActivity, LoginActivity::class.java)
                                    startActivity(intent)
                                }
                            }catch (e: JSONException){
                                Toast.makeText(this@RegisterActivity,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                            }

                        }, Response.ErrorListener {

                            Toast.makeText(
                                this@RegisterActivity,
                                "Some Error Occurred",
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
                    val dialog= AlertDialog.Builder(this@RegisterActivity)
                    dialog.setTitle("Error")
                    dialog.setMessage("Internet Connection is not Found")
                    dialog.setPositiveButton("Open Settings"){text, listener ->
                        val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                        startActivity(settingsIntent)
                        this@RegisterActivity?.finish()
                    }
                    dialog.setNegativeButton("Exit"){text, listener ->
                        ActivityCompat.finishAffinity(this@RegisterActivity)
                    }
                    dialog.create()
                    dialog.show()
                }
            }else{
                Toast.makeText(this@RegisterActivity,"Passwords don't match",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onBackPressed() {
        when(applicationContext) {
            !is LoginActivity -> startActivity(
                Intent(
                    this@RegisterActivity,
                    LoginActivity::class.java
                )
            )
            else -> super.onBackPressed()
        }
    }

    override fun onPause() {
        finish()
        super.onPause()
    }

}



