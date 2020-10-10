package com.smit.finalproject.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.smit.finalproject.*
import com.smit.finalproject.database.CartEntity
import com.smit.finalproject.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    private lateinit var txtMobileInfo: TextView
    private lateinit var txtNameInfo: TextView

    lateinit var sharedPreferences:SharedPreferences

    var previousMenuItem:MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        drawerLayout = findViewById(R.id.drawerLayout)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        setUpToolbar()
        openHome()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )



        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        val headerView= navigationView.getHeaderView(0)
        txtNameInfo=headerView.findViewById(R.id.txtNameDrawer)
        txtNameInfo.setText(sharedPreferences.getString("user_name",""))
        txtMobileInfo=headerView.findViewById(R.id.txtMobileDrawer)
        txtMobileInfo.setText(sharedPreferences.getString("user_mobile_number",""))


        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem != null){
                previousMenuItem?.isChecked=false
            }

            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

           when(it.itemId){

                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            HomeFragment()
                        )
                        .commit()

                    supportActionBar?.title="Restaurants"

                    drawerLayout.closeDrawers()
                }
                R.id.favRestaurants -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            FavouritesFragment()
                        )
                        .commit()

                    supportActionBar?.title="Favourite Restaurants"

                    drawerLayout.closeDrawers()
                }
                R.id.myProfile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            MyProfileFragment()
                        )
                        .commit()

                    supportActionBar?.title="My Profile"

                    drawerLayout.closeDrawers()
                }
                R.id.orderHistory -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            OrderHistoryFragment()
                        )
                        .commit()

                    supportActionBar?.title="Order History"

                    drawerLayout.closeDrawers()
                }
               R.id.faq -> {
                   supportFragmentManager.beginTransaction()
                       .replace(
                           R.id.frameLayout,
                           FAQFragment()
                       )
                       .commit()

                   supportActionBar?.title="FAQs"

                   drawerLayout.closeDrawers()
               }
               R.id.logOut -> {

                   val dialog= AlertDialog.Builder(this@MainActivity)
                   dialog.setTitle("Confirmation")
                   dialog.setMessage("Are you sure you want to log out?")
                   dialog.setPositiveButton("Log Out"){ text, listener  ->
                       sharedPreferences.edit().clear().apply()
                       val intent= Intent(this@MainActivity,LoginActivity::class.java)
                       startActivity(intent)
                       finish()
                   }
                   dialog.setNegativeButton("Cancel"){text, listener ->

                   }
                   dialog.create()
                   dialog.show()
               }
            }
            return@setNavigationItemSelectedListener true
        }
    }

        private fun setUpToolbar() {

            setSupportActionBar(toolbar)
            supportActionBar?.title = "Toolbar Title"
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {

            val id = item.itemId

            if (id == android.R.id.home) {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            return super.onOptionsItemSelected(item)
        }

        private fun openHome() {

            val fragment = HomeFragment()
            val transaction = supportFragmentManager.beginTransaction()

            sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
            val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

            transaction.replace(R.id.frameLayout, fragment)
            transaction.commit()
            supportActionBar?.title = "Restaurants"

            navigationView.setCheckedItem(R.id.home)
        }

        override fun onBackPressed() {

            when (supportFragmentManager.findFragmentById(R.id.frameLayout)) {
                !is HomeFragment -> openHome()

                else -> super.onBackPressed()
            }
        }
}


