package com.smit.finalproject.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.smit.finalproject.R
import com.smit.finalproject.adapter.FavouritesRecyclerAdapter
import com.smit.finalproject.database.FavouritesDatabase
import com.smit.finalproject.database.FavouritesEntity

class FavouritesFragment : Fragment() {

    private lateinit var recyclerFavourites: RecyclerView
    lateinit var progressLayout: RelativeLayout
    lateinit var progressBar: ProgressBar
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: FavouritesRecyclerAdapter
    var dbFavList = listOf<FavouritesEntity>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)

        recyclerFavourites = view.findViewById(R.id.recyclerFavourites)
        progressBar = view.findViewById(R.id.progressBar)
        progressLayout = view.findViewById(R.id.progressLayout)

        layoutManager = LinearLayoutManager(activity as Context)

        dbFavList = FavouritesFragment.RetrieveFavourites(activity as Context).execute().get()

        if (activity != null) {

            progressLayout.visibility = View.GONE
            recyclerAdapter = FavouritesRecyclerAdapter(activity as Context, dbFavList)
            recyclerFavourites.adapter = recyclerAdapter
            recyclerFavourites.layoutManager = layoutManager
        }

        return view
    }


    class RetrieveFavourites(val context: Context) :
        AsyncTask<Void, Void, List<FavouritesEntity>>() {

        override fun doInBackground(vararg params: Void?): List<FavouritesEntity> {

            val db = Room.databaseBuilder(context, FavouritesDatabase::class.java, "fav-db").build()

            return db.favouritesDao().getAllItems()
        }
    }
}





