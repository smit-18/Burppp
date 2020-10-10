package com.smit.finalproject.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smit.finalproject.R
import com.smit.finalproject.activity.RestaurantMenuActivity
import com.smit.finalproject.database.FavouritesEntity
import com.smit.finalproject.fragment.HomeFragment
import com.smit.finalproject.model.Restaurant
import com.squareup.picasso.Picasso

class FavouritesRecyclerAdapter(val context: Context, val favouritesList:List<FavouritesEntity>):
    RecyclerView.Adapter<FavouritesRecyclerAdapter.FavouritesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouritesViewHolder {
        
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favourites_single_row, parent, false)
        return FavouritesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favouritesList.size
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {

        val restaurant = favouritesList[position]
        holder.txtResName.text = restaurant.resName
        val cost="Rs.${restaurant.resCost}/person"
        holder.txtResCPP.text = cost
        holder.txtResRating.text = restaurant.resRating
        Picasso.get().load(restaurant.resImage).into(holder.imgResImg)

        holder.rlContent.setOnClickListener {

            val fragment=HomeFragment()
            val intent = Intent(context, RestaurantMenuActivity::class.java)
            val args=Bundle()
            args.putInt("id",restaurant.restaurant_id.toInt())
            args.putString("name",restaurant.resName)
            fragment.arguments=args
            intent.putExtra("resInfo",args)
            context.startActivity(intent)
        }

    }
    class FavouritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtResName: TextView = view.findViewById(R.id.txtResName)
        val txtResCPP: TextView = view.findViewById(R.id.txtResCPP)
        val txtResRating: TextView = view.findViewById(R.id.txtResRating)
        val imgResImg: ImageView = view.findViewById(R.id.imgResImg)
        val rlContent: RelativeLayout = view.findViewById(R.id.rlContent)


    }

}
