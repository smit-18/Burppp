package com.smit.finalproject.activity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils.isEmpty
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.adapter.MenuRecyclerAdapter
import com.smit.finalproject.model.Menu
import com.smit.finalproject.util.ConnectionManager
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import com.smit.finalproject.adapter.CartRecyclerAdapter
import com.smit.finalproject.database.CartDatabase
import com.smit.finalproject.database.CartEntity
import com.smit.finalproject.fragment.CartFragment
import org.json.JSONException

class RestaurantMenuActivity : AppCompatActivity() {

    lateinit var recyclerMenu: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var progressLayout: RelativeLayout
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnProceedToCart : Button
    lateinit var menuLayout: RelativeLayout

    val menuInfoList= arrayListOf<Menu>()

    lateinit var recyclerAdapter: MenuRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_menu)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        recyclerMenu = findViewById(R.id.recyclerMenu)
        progressBar = findViewById(R.id.progressBar)
        progressLayout = findViewById(R.id.progressLayout)
        layoutManager = LinearLayoutManager(this@RestaurantMenuActivity)
        btnProceedToCart = findViewById(R.id.btnProceedToCart)
        menuLayout = findViewById(R.id.menuLayout)

        progressLayout.visibility = View.VISIBLE

        val resInfo = intent.getBundleExtra("resInfo")
        val resId = resInfo.getInt("id")
        val resName = resInfo.getString("name")


        val queue = Volley.newRequestQueue(this@RestaurantMenuActivity)

        if (ConnectionManager().checkConnectivity(this@RestaurantMenuActivity)) {

            val jsonObjectRequest =
                object : JsonObjectRequest(Request.Method.GET,
                    "http://13.235.250.119/v2/restaurants/fetch_result/$resId",
                    null,
                    Response.Listener {

                        try {

                            val data = it.getJSONObject("data")
                            val success = data.getBoolean("success")

                            if (success) {

                                progressLayout.visibility = View.GONE
                                val response = data.getJSONArray("data")

                                for (i in 0 until response.length()) {

                                    val menuJsonObject = response.getJSONObject(i)
                                    val menuObject = Menu(
                                        menuJsonObject.getString("id").toInt(),
                                        menuJsonObject.getString("name"),
                                        menuJsonObject.getString("cost_for_one")
                                    )
                                    menuInfoList.add(menuObject)

                                    recyclerAdapter =
                                        MenuRecyclerAdapter(
                                            this@RestaurantMenuActivity,
                                            menuInfoList
                                        )
                                    recyclerMenu.adapter = recyclerAdapter
                                    recyclerMenu.itemAnimator = DefaultItemAnimator()
                                    recyclerMenu.layoutManager = layoutManager
                                }
                            }
                        }catch (e: JSONException){
                            Toast.makeText(this@RestaurantMenuActivity,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener {

                        Toast.makeText(this@RestaurantMenuActivity,"Volley Error Occurred",Toast.LENGTH_SHORT).show()
                    }) {
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers = HashMap<String, String>()
                        headers["Content-type"] = "application/json"
                        headers["token"] = "326a253b6b58cc"
                        return headers
                    }
                }
            queue.add(jsonObjectRequest)
        }else{
            val dialog= AlertDialog.Builder(this@RestaurantMenuActivity)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection is not Found")
            dialog.setPositiveButton("Open Settings"){text, listener ->
                val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                this@RestaurantMenuActivity?.finish()
            }
            dialog.setNegativeButton("Exit"){text, listener ->
                ActivityCompat.finishAffinity(this@RestaurantMenuActivity)
            }
            dialog.create()
            dialog.show()

        }

        btnProceedToCart.setOnClickListener {

            btnProceedToCart.visibility = View.GONE

            val fragment = CartFragment()
            val args = Bundle()
            args.putInt("resId", resId)
            args.putString("resName", resName)
            fragment.arguments = args
            val transaction = supportFragmentManager.beginTransaction()
            transaction.addToBackStack("menu")
            transaction.replace(R.id.menuLayout, fragment)
            transaction.commit()
        }
    }
}

