package com.smit.finalproject.database;

import java.lang.System;

@androidx.room.Database(entities = {com.smit.finalproject.database.FavouritesEntity.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/smit/finalproject/database/FavouritesDatabase;", "Landroidx/room/RoomDatabase;", "()V", "favouritesDao", "Lcom/smit/finalproject/database/FavouritesDao;", "app_debug"})
public abstract class FavouritesDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.smit.finalproject.database.FavouritesDao favouritesDao();
    
    public FavouritesDatabase() {
        super();
    }
}