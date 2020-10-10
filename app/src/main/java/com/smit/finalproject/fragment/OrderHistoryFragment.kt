package com.smit.finalproject.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.adapter.CartRecyclerAdapter
import com.smit.finalproject.adapter.OrderHistoryAdapter
import com.smit.finalproject.model.OrderDetails
import com.smit.finalproject.util.ConnectionManager
import kotlinx.android.synthetic.main.fragment_order_history.*

class OrderHistoryFragment : Fragment() {

    lateinit var orderHistoryAdapter:OrderHistoryAdapter
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerOrderHistory: RecyclerView
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar: ProgressBar
    lateinit var noOrders: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_order_history, container, false)

        progressLayout=view.findViewById(R.id.progressLayout)
        progressBar=view.findViewById(R.id.progressBar)
        noOrders=view.findViewById(R.id.noOrders)
        recyclerOrderHistory=view.findViewById(R.id.recyclerOrderHistory)

        sharedPreferences=context!!.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val userId=sharedPreferences.getString("user_id","")

        val orderHistoryList= arrayListOf<OrderDetails>()
        val queue = Volley.newRequestQueue(activity as Context)
        val url="http://13.235.250.119/v2/orders/fetch_result/$userId"

        if(ConnectionManager().checkConnectivity(activity as Context)) {

            val jsonObjectRequest = object :
                JsonObjectRequest(Method.GET, url, null, Response.Listener {

                    progressLayout.visibility = View.GONE
                    noOrders.visibility = View.GONE
                    try {
                        val data = it.getJSONObject("data")
                        val success = data.getBoolean("success")
                        if (success) {
                            val resArray = data.getJSONArray("data")

                            for (i in 0 until resArray.length()) {
                                val orderObject = resArray.getJSONObject(i)
                                val foodItems = orderObject.getJSONArray("food_items")
                                val orderDetails = OrderDetails(
                                    orderObject.getInt("order_id"),
                                    orderObject.getString("restaurant_name"),
                                    orderObject.getString("order_placed_at"),
                                    foodItems
                                )
                                orderHistoryList.add(orderDetails)
                                if (orderHistoryList.isEmpty()) {
                                    noOrders.visibility = View.VISIBLE
                                } else {
                                    noOrders.visibility = View.GONE
                                    if (activity != null) {
                                        orderHistoryAdapter = OrderHistoryAdapter(
                                            activity as Context,
                                            orderHistoryList
                                        )
                                        val mLayoutManager =
                                            LinearLayoutManager(activity as Context)
                                        recyclerOrderHistory.layoutManager = mLayoutManager
                                        recyclerOrderHistory.itemAnimator = DefaultItemAnimator()
                                        recyclerOrderHistory.adapter = orderHistoryAdapter
                                    }
                                }
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {
                    Toast.makeText(activity as Context, it.message, Toast.LENGTH_SHORT).show()
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
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("INTERNET CONNECTION IS NOT FOUND")
            dialog.setPositiveButton("Open Settings"){text,listner ->
                val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                activity?.finish()
            }
            dialog.setNegativeButton("Exit"){text,listener->
                ActivityCompat.finishAffinity(activity as Activity)
            }
            dialog.create()
            dialog.show()
        }
        return view
    }
}
