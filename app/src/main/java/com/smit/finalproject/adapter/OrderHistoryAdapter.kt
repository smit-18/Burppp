package com.smit.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smit.finalproject.R
import com.smit.finalproject.model.Menu
import com.smit.finalproject.model.OrderDetails
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class OrderHistoryAdapter(val context: Context, private val orderHistoryList:ArrayList<OrderDetails>)
    :RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder>() {

    class OrderHistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtResName: TextView = view.findViewById(R.id.txtResHistoryResName)
        val txtDate: TextView = view.findViewById(R.id.txtDate)
        val recyclerResHistory: RecyclerView = view.findViewById(R.id.recyclerResHistoryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycler_order_history_single_row,parent,false)
        return OrderHistoryViewHolder(view)
    }
    override fun getItemCount(): Int {
        return orderHistoryList.size
    }

    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {

        val orderHistoryObject = orderHistoryList[position]
        holder.txtResName.text = orderHistoryObject.resName
        holder.txtDate.text = formatDate(orderHistoryObject.orderDate)
        setUpRecycler(holder.recyclerResHistory, orderHistoryObject)
    }

    private fun setUpRecycler(recyclerResHistory: RecyclerView, orderHistoryList: OrderDetails) {
        val foodItemsList = ArrayList<Menu>()
        for (i in 0 until orderHistoryList.foodItems.length()) {
            val foodJson = orderHistoryList.foodItems.getJSONObject(i)
            foodItemsList.add(
                Menu(
                    foodJson.getString("food_item_id").toInt() ,
                    foodJson.getString("name"),
                    foodJson.getString("cost")
                )
            )
        }
        val cartItemAdapter = CartItemAdapter(foodItemsList, context)
        val mLayoutManager = LinearLayoutManager(context)
        recyclerResHistory.layoutManager = mLayoutManager
        recyclerResHistory.itemAnimator = DefaultItemAnimator()
        recyclerResHistory.adapter = cartItemAdapter
    }

    private fun formatDate(dateString: String): String? {
        val inputFormatter = SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale.ENGLISH)
        val date: Date = inputFormatter.parse(dateString) as Date

        val outputFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        return outputFormatter.format(date)
    }
}