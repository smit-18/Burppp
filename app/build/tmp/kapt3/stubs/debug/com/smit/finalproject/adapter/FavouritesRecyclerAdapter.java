package com.smit.finalproject.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/smit/finalproject/adapter/FavouritesRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smit/finalproject/adapter/FavouritesRecyclerAdapter$FavouritesViewHolder;", "context", "Landroid/content/Context;", "favouritesList", "", "Lcom/smit/finalproject/database/FavouritesEntity;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getFavouritesList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FavouritesViewHolder", "app_debug"})
public final class FavouritesRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smit.finalproject.adapter.FavouritesRecyclerAdapter.FavouritesViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.smit.finalproject.database.FavouritesEntity> favouritesList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smit.finalproject.adapter.FavouritesRecyclerAdapter.FavouritesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.FavouritesRecyclerAdapter.FavouritesViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.smit.finalproject.database.FavouritesEntity> getFavouritesList() {
        return null;
    }
    
    public FavouritesRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.smit.finalproject.database.FavouritesEntity> favouritesList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/smit/finalproject/adapter/FavouritesRecyclerAdapter$FavouritesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imgResImg", "Landroid/widget/ImageView;", "getImgResImg", "()Landroid/widget/ImageView;", "rlContent", "Landroid/widget/RelativeLayout;", "getRlContent", "()Landroid/widget/RelativeLayout;", "txtResCPP", "Landroid/widget/TextView;", "getTxtResCPP", "()Landroid/widget/TextView;", "txtResName", "getTxtResName", "txtResRating", "getTxtResRating", "app_debug"})
    public static final class FavouritesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
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
        
        public FavouritesViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}