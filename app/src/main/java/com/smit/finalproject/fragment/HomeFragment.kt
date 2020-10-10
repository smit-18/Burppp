package com.smit.finalproject.fragment

import android.app.Activity
import android.app.AlertDialog
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Insets.add
import android.os.AsyncTask
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.smit.finalproject.R
import com.smit.finalproject.adapter.HomeRecyclerAdapter
import com.smit.finalproject.database.FavouritesDatabase
import com.smit.finalproject.database.FavouritesEntity
import com.smit.finalproject.model.Restaurant
import com.smit.finalproject.util.ConnectionManager
import kotlinx.android.synthetic.main.recycler_home_single_row.*
import kotlinx.android.synthetic.main.recycler_menu_single_row.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap

class HomeFragment : Fragment() {

    lateinit var recyclerHome: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var progressBar: ProgressBar
    lateinit var progressLayout: RelativeLayout


    lateinit var sharedPreferences: SharedPreferences

    val resInfoList = arrayListOf<Restaurant>()

    var ratingComparator=Comparator<Restaurant>{ res1, res2 ->
        if(res1.resRating.compareTo(res2.resRating,true)==0){
            res1.resName.compareTo(res2.resName, true)
        }else{
            res1.resRating.compareTo(res2.resRating,true)
        }
    }

    private var priceComparator= Comparator<Restaurant>{ res1, res2 ->
        if(res1.resCostForOne.compareTo(res2.resCostForOne,true)==0){
            res1.resName.compareTo(res2.resName,true)
        }else{
            res1.resCostForOne.compareTo(res2.resCostForOne,true)
        }
    }

    lateinit var recyclerAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        sharedPreferences=activity!!.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setHasOptionsMenu(true)

        recyclerHome = view.findViewById(R.id.recyclerHome)
        layoutManager = LinearLayoutManager(activity)
        progressBar = view.findViewById(R.id.progressBar)
        progressLayout = view.findViewById(R.id.progressLayout)
        progressLayout.visibility = View.VISIBLE

        val queue = Volley.newRequestQueue(activity as Context)
        val url = "http://13.235.250.119/v2/restaurants/fetch_result/"

        if (ConnectionManager().checkConnectivity(activity as Context)) {

                val jsonObjectRequest =
                    object : JsonObjectRequest(Request.Method.GET, url, null, Response.Listener {

                        try {

                            val data = it.getJSONObject("data")
                            val success = data.getBoolean("success")

                            if (success) {
                                progressLayout.visibility = View.GONE
                                val response = data.getJSONArray("data")
                                for (i in 0 until response.length()) {

                                    val resJsonObject = response.getJSONObject(i)
                                    val resObject = Restaurant(
                                        resJsonObject.getString("id").toInt(),
                                        resJsonObject.getString("name"),
                                        resJsonObject.getString("rating"),
                                        resJsonObject.getString("cost_for_one"),
                                        resJsonObject.getString("image_url")
                                    )
                                    resInfoList.add(resObject)
                                    recyclerAdapter =
                                        HomeRecyclerAdapter(activity as Context, resInfoList)

                                    recyclerHome.adapter = recyclerAdapter
                                    recyclerHome.layoutManager = layoutManager

                                }
                            } else {
                                Toast.makeText(
                                    activity as Context,
                                    "Some Error Occurred!!!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }catch (e:JSONException){
                            Toast.makeText(activity as Context,"Some unexpected error occurred",Toast.LENGTH_SHORT).show()
                        }

                    }, Response.ErrorListener {

                        Toast.makeText(activity as Context,"Volley error occurred",Toast.LENGTH_SHORT).show()

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

            return view
        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_sort,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id= item.itemId
        if(id==R.id.rating){

            Collections.sort(resInfoList, ratingComparator)
            resInfoList.reverse()
        }
        if(id==R.id.costLTH){

            Collections.sort(resInfoList,priceComparator)
        }
        if(id==R.id.costHTL){

            Collections.sort(resInfoList,priceComparator)
            resInfoList.reverse()
        }

        recyclerAdapter.notifyDataSetChanged()
        return super.onOptionsItemSelected(item)
    }
}
