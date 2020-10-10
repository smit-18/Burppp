package com.smit.finalproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourites")
data class FavouritesEntity(

    @PrimaryKey val restaurant_id: String,
    @ColumnInfo val resName:String,
    @ColumnInfo val resRating:String,
    @ColumnInfo val resCost:String,
    @ColumnInfo val resImage:String

)
