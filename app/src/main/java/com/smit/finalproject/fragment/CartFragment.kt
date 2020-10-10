package com.smit.finalproject.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.smit.finalproject.R
import com.smit.finalproject.activity.OrderPlacedActivity
import com.smit.finalproject.adapter.CartRecyclerAdapter
import com.smit.finalproject.adapter.MenuRecyclerAdapter
import com.smit.finalproject.database.CartDatabase
import com.smit.finalproject.database.CartEntity
import com.smit.finalproject.model.Menu
import com.smit.finalproject.util.ConnectionManager
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class CartFragment : Fragment() {

    private lateinit var recyclerCart: RecyclerView
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar: ProgressBar
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: CartRecyclerAdapter
    var dbCartList= listOf<CartEntity>()
    lateinit var btnPlaceOrder: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var txtCartResName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_cart, container, false)

        recyclerCart=view.findViewById(R.id.recyclerCart)
        progressBar=view.findViewById(R.id.progressBar)
        progressLayout=view.findViewById(R.id.progressLayout)
        btnPlaceOrder=view.findViewById(R.id.btnPlaceOrder)
        txtCartResName=view.findViewById(R.id.txtCartResName)

        sharedPreferences=context!!.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val userId=sharedPreferences.getString("user_id","")
        val resId=arguments?.getInt("resId")
        val resName=arguments?.getString("resName")

        txtCartResName.text=resName

        layoutManager=LinearLayoutManager(activity as Context)
        dbCartList=RetrieveCart(activity as Context).execute().get()

        if(activity != null){
            progressLayout.visibility=View.GONE
            recyclerAdapter=CartRecyclerAdapter(activity as Context,dbCartList)
            recyclerCart.adapter=recyclerAdapter
            recyclerCart.layoutManager=layoutManager
        }
        var sum=0
        for(element in dbCartList){
            sum+= element.itemCost.toInt()
        }
        val total="Place Order(Total: Rs.${sum})"
        btnPlaceOrder.text=total

        btnPlaceOrder.setOnClickListener {

            val queue = Volley.newRequestQueue(context)
            val url = "http://13.235.250.119/v2/place_order/fetch_result/"

            val jsonParams = JSONObject()
            jsonParams.put("user_id", userId)
            jsonParams.put("restaurant_id", resId)
            jsonParams.put("total_cost", sum.toString())
            val foodArray = JSONArray()
            for (i in dbCartList.indices) {
                val foodId = JSONObject()
                foodId.put("food_item_id", dbCartList[i].itemId)
                foodArray.put(i, foodId)
            }
            jsonParams.put("food", foodArray)

            if (ConnectionManager().checkConnectivity(activity as Context)) {

                val jsonObjectRequest =
                    object : JsonObjectRequest(Method.POST, url, jsonParams, Response.Listener {

                        try {

                            val data = it.getJSONObject("data")
                            val success = data.getBoolean("success")

                            if (success) {
                                val intent = Intent(context, OrderPlacedActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    context,
                                    "Some unexpected error occurred",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }catch (e:JSONException){
                            Toast.makeText(activity as Context,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                        }
                    }, Response.ErrorListener {
                        Toast.makeText(context, "Some volley error occurred ", Toast.LENGTH_SHORT)
                            .show()
                    }) {
                        override fun getHeaders(): MutableMap<String, String> {
                            val headers = HashMap<String, String>()
                            headers["Content-type"] = "application/json"
                            headers["token"] = "326a253b6b58cc"
                            return headers
                        }
                    }
                queue.add(jsonObjectRequest)
            }
            else{

                val dialog= AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet Connection is not Found")
                dialog.setPositiveButton("Open Settings"){text, listener ->
                    val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(settingsIntent)
                    activity?.finish()
                }
                dialog.setNegativeButton("Exit"){text, listener ->
                    ActivityCompat.finishAffinity(activity as Activity)
                }
                dialog.create()
                dialog.show()

            }
        }
        return view
    }
    class RetrieveCart(val context: Context):AsyncTask<Void, Void, List<CartEntity>>(){
        override fun doInBackground(vararg params: Void?): List<CartEntity> {

            val db= Room.databaseBuilder(context, CartDatabase::class.java,"cart-db").build()
            return db.cartDao().getAllItems()
        }
    }
}



