package com.smit.finalproject.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/smit/finalproject/adapter/HomeRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smit/finalproject/adapter/HomeRecyclerAdapter$HomeViewHolder;", "context", "Landroid/content/Context;", "itemList", "Ljava/util/ArrayList;", "Lcom/smit/finalproject/model/Restaurant;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "getItemList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DBAsyncTask", "GetAllFavAsyncTask", "HomeViewHolder", "app_debug"})
public final class HomeRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smit.finalproject.adapter.HomeRecyclerAdapter.HomeViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.smit.finalproject.model.Restaurant> itemList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smit.finalproject.adapter.HomeRecyclerAdapter.HomeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.HomeRecyclerAdapter.HomeViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.smit.finalproject.model.Restaurant> getItemList() {
        return null;
    }
    
    public HomeRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.smit.finalproject.model.Restaurant> itemList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/smit/finalproject/adapter/HomeRecyclerAdapter$HomeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imgHeart", "Landroid/widget/ImageView;", "getImgHeart", "()Landroid/widget/ImageView;", "imgResImg", "getImgResImg", "rlContent", "Landroid/widget/RelativeLayout;", "getRlContent", "()Landroid/widget/RelativeLayout;", "txtResCPP", "Landroid/widget/TextView;", "getTxtResCPP", "()Landroid/widget/TextView;", "txtResName", "getTxtResName", "txtResRating", "getTxtResRating", "app_debug"})
    public static final class HomeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtResName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtResCPP = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtResRating = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgResImg = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RelativeLayout rlContent = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgHeart = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtResName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtResCPP() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtResRating() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgResImg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RelativeLayout getRlContent() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgHeart() {
            return null;
        }
        
        public HomeViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ%\u0010\u0015\u001a\u00020\u00032\u0016\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0017\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/smit/finalproject/adapter/HomeRecyclerAdapter$DBAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "context", "Landroid/content/Context;", "favouritesEntity", "Lcom/smit/finalproject/database/FavouritesEntity;", "mode", "", "(Landroid/content/Context;Lcom/smit/finalproject/database/FavouritesEntity;I)V", "getContext", "()Landroid/content/Context;", "db", "Lcom/smit/finalproject/database/FavouritesDatabase;", "getDb", "()Lcom/smit/finalproject/database/FavouritesDatabase;", "getFavouritesEntity", "()Lcom/smit/finalproject/database/FavouritesEntity;", "getMode", "()I", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/lang/Boolean;", "app_debug"})
    public static final class DBAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {
        @org.jetbrains.annotations.NotNull()
        private final com.smit.finalproject.database.FavouritesDatabase db = null;
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        @org.jetbrains.annotations.NotNull()
        private final com.smit.finalproject.database.FavouritesEntity favouritesEntity = null;
        private final int mode = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final com.smit.finalproject.database.FavouritesDatabase getDb() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.smit.finalproject.database.FavouritesEntity getFavouritesEntity() {
            return null;
        }
        
        public final int getMode() {
            return 0;
        }
        
        public DBAsyncTask(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.smit.finalproject.database.FavouritesEntity favouritesEntity, int mode) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J+\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000e\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/smit/finalproject/adapter/HomeRecyclerAdapter$GetAllFavAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lcom/smit/finalproject/database/FavouritesDatabase;", "getDb", "()Lcom/smit/finalproject/database/FavouritesDatabase;", "doInBackground", "params", "", "([Ljava/lang/Void;)Ljava/util/List;", "app_debug"})
    public static final class GetAllFavAsyncTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.util.List<? extends java.lang.String>> {
        @org.jetbrains.annotations.NotNull()
        private final com.smit.finalproject.database.FavouritesDatabase db = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.smit.finalproject.database.FavouritesDatabase getDb() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected java.util.List<java.lang.String> doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.Void... params) {
            return null;
        }
        
        public GetAllFavAsyncTask(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            super();
        }
    }
}