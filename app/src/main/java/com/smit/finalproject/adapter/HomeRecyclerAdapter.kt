package com.smit.finalproject.adapter

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.activity.RestaurantMenuActivity
import com.smit.finalproject.database.FavouritesDatabase
import com.smit.finalproject.database.FavouritesEntity
import com.smit.finalproject.fragment.HomeFragment
import com.smit.finalproject.model.Restaurant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.nio.file.Paths.get


class HomeRecyclerAdapter(val context: Context, val itemList:ArrayList<Restaurant>)
    :RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyclerAdapter.HomeViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_home_single_row, parent, false)
        return HomeViewHolder(view)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HomeRecyclerAdapter.HomeViewHolder, position: Int) {

        val restaurant = itemList[position]
        holder.txtResName.text = restaurant.resName
        val costForTwo="Rs.${restaurant.resCostForOne.toString()}/person"
        holder.txtResCPP.text = costForTwo
        holder.txtResRating.text = restaurant.resRating
        Picasso.get().load(restaurant.resImage).into(holder.imgResImg)


        holder.rlContent.setOnClickListener {

            val fragment = HomeFragment()
            val args=Bundle()
            args.putInt("id",restaurant.resId)
            args.putString("name",restaurant.resName)
            fragment.arguments=args
            val intent = Intent(context, RestaurantMenuActivity::class.java)
            intent.putExtra("resInfo",args)
            context.startActivity(intent)

        }

        val listOfFavourites=GetAllFavAsyncTask(context).execute().get()

        if(listOfFavourites.isNotEmpty() && listOfFavourites.contains(restaurant.resId.toString())){
            holder.imgHeart.setImageResource(R.drawable.ic_heart_filled)
        }
        else{
            holder.imgHeart.setImageResource(R.drawable.ic_heart)
        }

        holder.imgHeart.setOnClickListener {

            val restaurantEntity=FavouritesEntity(
                restaurant.resId.toString(),
                restaurant.resName,
                restaurant.resRating,
                restaurant.resCostForOne,
                restaurant.resImage
            )

            if(!DBAsyncTask(context,restaurantEntity,1).execute().get()) {

                val async = DBAsyncTask(context, restaurantEntity, 2).execute()
                val result = async.get()

                if (result) {
                    holder.imgHeart.setImageResource(R.drawable.ic_heart_filled)
                }
            }
                else{
                    val async=DBAsyncTask(context,restaurantEntity,3).execute()
                    val result=async.get()

                    if(result){
                        holder.imgHeart.setImageResource(R.drawable.ic_heart)
                    }
                }
        }
    }


    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtResName: TextView = view.findViewById(R.id.txtResName)
        val txtResCPP: TextView = view.findViewById(R.id.txtResCPP)
        val txtResRating: TextView = view.findViewById(R.id.txtResRating)
        val imgResImg: ImageView = view.findViewById(R.id.imgResImg)
        val rlContent: RelativeLayout = view.findViewById(R.id.rlContent)
        val imgHeart: ImageView = view.findViewById(R.id.imgHeart)

    }

    class DBAsyncTask(val context: Context, val favouritesEntity: FavouritesEntity, val mode: Int) :
        AsyncTask<Void, Void, Boolean>() {


        val db = Room.databaseBuilder(context, FavouritesDatabase::class.java, "fav-db").build()

        override fun doInBackground(vararg params: Void?): Boolean {

            when (mode) {

                1 -> {

                    val restaurant: FavouritesEntity? =
                        db.favouritesDao().getResById(favouritesEntity.restaurant_id.toString())
                    db.close()
                    return restaurant != null

                }

                2 -> {

                    db.favouritesDao().insertItem(favouritesEntity)
                    db.close()
                    return true

                }

                3 -> {

                    db.favouritesDao().removeItem(favouritesEntity)
                    db.close()
                    return true

                }
            }

            return false

        }

    }
    class GetAllFavAsyncTask(context: Context):AsyncTask<Void,Void,List<String>>(){

        val db = Room.databaseBuilder(context, FavouritesDatabase::class.java, "fav-db").build()

        override fun doInBackground(vararg params: Void?): List<String> {

            val list=db.favouritesDao().getAllItems()
            val listOfIds= arrayListOf<String>()
            for(i in list){
                listOfIds.add(i.restaurant_id.toString())
            }
            return listOfIds
        }
    }
}


