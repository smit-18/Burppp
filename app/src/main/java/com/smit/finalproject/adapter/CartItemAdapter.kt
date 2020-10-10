package com.smit.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smit.finalproject.R
import com.smit.finalproject.model.Menu

class CartItemAdapter(private val cartList: ArrayList<Menu>, val context: Context) :
    RecyclerView.Adapter<CartItemAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CartViewHolder {
        val itemView =
            LayoutInflater.from(p0.context).inflate(R.layout.recycler_cart_single_row, p0, false)
        return CartViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class CartViewHolder(view: View):RecyclerView.ViewHolder(view){

        val txtItemName: TextView =view.findViewById(R.id.txtItemName)
        val txtItemPrice: TextView =view.findViewById(R.id.txtItemPrice)
        val llContent: LinearLayout =view.findViewById(R.id.llContent)
    }

    override fun onBindViewHolder(p0: CartViewHolder, p1: Int) {
        val cartObject = cartList[p1]
        p0.txtItemName.text = cartObject.name
        val cost = "Rs. ${cartObject.cpp}"
        p0.txtItemPrice.text = cost
    }
}