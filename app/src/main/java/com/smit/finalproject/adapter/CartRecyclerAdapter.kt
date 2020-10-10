package com.smit.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smit.finalproject.R
import com.smit.finalproject.database.CartEntity

class CartRecyclerAdapter(val context: Context, val cartList:List<CartEntity>):RecyclerView.Adapter<CartRecyclerAdapter.CartViewHolder>() {

    class CartViewHolder(view: View):RecyclerView.ViewHolder(view){

        val txtItemName: TextView=view.findViewById(R.id.txtItemName)
        val txtItemPrice: TextView=view.findViewById(R.id.txtItemPrice)
        val llContent: LinearLayout=view.findViewById(R.id.llContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_cart_single_row,parent,false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val cart=cartList[position]

        holder.txtItemName.text=cart.itemName
        val cost="Rs.${cart.itemCost}"
        holder.txtItemPrice.text=cost
    }
}