package com.smit.finalproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart")
data class CartEntity(

    @PrimaryKey val itemId: String,
    @ColumnInfo val itemName: String,
    @ColumnInfo val itemCost: String
)