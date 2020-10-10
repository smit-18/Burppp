package com.smit.finalproject.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouritesDao {

    @Insert
     fun insertItem(favouritesEntity: FavouritesEntity)

    @Delete
    fun removeItem(favouritesEntity: FavouritesEntity)

    @Query("SELECT * FROM favourites")
    fun getAllItems(): List<FavouritesEntity>

    @Query("SELECT * FROM favourites WHERE restaurant_id= :resId")
    fun getResById(resId:String): FavouritesEntity

}

