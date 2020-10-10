package com.smit.finalproject.database

import androidx.room.*

@Dao
interface CartDao {

    @Insert
    fun insertItem(cartEntity: CartEntity)

    @Delete
    fun removeItem(cartEntity: CartEntity)

    @Query("SELECT * FROM cart")
    fun getAllItems(): List<CartEntity>

    @Query("SELECT * FROM cart WHERE itemId= :itemId")
    fun getItemById(itemId: String): CartEntity

}