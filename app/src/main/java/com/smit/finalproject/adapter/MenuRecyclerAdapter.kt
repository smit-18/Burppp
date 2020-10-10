package com.smit.finalproject.adapter

import android.content.Context
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.smit.finalproject.R
import com.smit.finalproject.database.CartDatabase
import com.smit.finalproject.database.CartEntity
import com.smit.finalproject.database.FavouritesDatabase
import com.smit.finalproject.fragment.CartFragment
import com.smit.finalproject.model.Menu

class MenuRecyclerAdapter(val context:Context, val itemList:ArrayList<Menu>):RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_menu_single_row, parent, false)

        return MenuRecyclerAdapter.MenuViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        val menu= itemList[position]
        holder.txtResMenuName.text=menu.name
        val cost="Rs.${menu.cpp}"
        holder.txtResMenuCPP.text=cost

        val listOfItems=GetAllItemsAsyncTask(context).execute().get()

        if(listOfItems.isNotEmpty() && listOfItems.contains(menu.id.toString())){
            holder.btnAdd.text="Remove"
            val favColor= ContextCompat.getColor(context,R.color.themeBlue)
            holder.btnAdd.setBackgroundColor(favColor)
        }
        else{
            holder.btnAdd.text="Add"
            val noFavColor= ContextCompat.getColor(context,R.color.turquoise)
            holder.btnAdd.setBackgroundColor(noFavColor)
        }

        holder.btnAdd.setOnClickListener {

            val cartEntity=CartEntity(
                menu.id.toString(),
                menu.name,
                menu.cpp
            )

            if (!DBAsyncTask(context, cartEntity, 3).execute().get()) {

                val async = DBAsyncTask(context, cartEntity, 1).execute()
                val result = async.get()

                if (result) {
                    Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show()

                    holder.btnAdd.text="Remove"
                    val favColor= ContextCompat.getColor(context,R.color.themeBlue)
                    holder.btnAdd.setBackgroundColor(favColor)

                } else {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show()
                }
            } else {

                val async = DBAsyncTask(context, cartEntity, 2).execute()
                val result = async.get()

                if (result) {
                    Toast.makeText(context, "Removed from cart", Toast.LENGTH_SHORT).show()

                    holder.btnAdd.text="Add"
                    val noFavColor= ContextCompat.getColor(context,R.color.turquoise)
                    holder.btnAdd.setBackgroundColor(noFavColor)

                } else {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    class MenuViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val txtResMenuName: TextView= view.findViewById(R.id.txtResMenuName)
        val txtResMenuCPP: TextView= view.findViewById(R.id.txtResMenuCPP)
        val btnAdd: Button= view.findViewById(R.id.btnAdd)
    }

    class DBAsyncTask(val context: Context, private val cartEntity: CartEntity, private val mode: Int): AsyncTask<Void, Void, Boolean>(){

        private val db= Room.databaseBuilder(context, CartDatabase::class.java, "cart-db").build()

        override fun doInBackground(vararg params: Void?): Boolean {

            when(mode){

                1 -> {

                    db.cartDao().insertItem(cartEntity)
                    db.close()
                    return true

                }

                2 -> {

                    db.cartDao().removeItem(cartEntity)
                    db.close()
                    return true

                }

                3 -> {

                    val cart: CartEntity?=db.cartDao().getItemById(cartEntity.itemId)
                    db.close()
                    return cart != null
                }
            }
            return false
        }
    }

    class GetAllItemsAsyncTask(context: Context):AsyncTask<Void,Void,List<String>>(){

        val db = Room.databaseBuilder(context, CartDatabase::class.java, "cart-db").build()

        override fun doInBackground(vararg params: Void?): List<String> {

            val list=db.cartDao().getAllItems()
            val listOfIds= arrayListOf<String>()
            for(i in list){
                listOfIds.add(i.itemId.toString())
            }
            return listOfIds
        }
    }
}