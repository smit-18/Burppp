package com.smit.finalproject.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\'J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\'\u00a8\u0006\f"}, d2 = {"Lcom/smit/finalproject/database/CartDao;", "", "getAllItems", "", "Lcom/smit/finalproject/database/CartEntity;", "getItemById", "itemId", "", "insertItem", "", "cartEntity", "removeItem", "app_debug"})
public abstract interface CartDao {
    
    @androidx.room.Insert()
    public abstract void insertItem(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.database.CartEntity cartEntity);
    
    @androidx.room.Delete()
    public abstract void removeItem(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.database.CartEntity cartEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM cart")
    public abstract java.util.List<com.smit.finalproject.database.CartEntity> getAllItems();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM cart WHERE itemId= :itemId")
    public abstract com.smit.finalproject.database.CartEntity getItemById(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId);
}