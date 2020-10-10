package com.smit.finalproject.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/smit/finalproject/activity/RestaurantMenuActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnProceedToCart", "Landroid/widget/Button;", "getBtnProceedToCart", "()Landroid/widget/Button;", "setBtnProceedToCart", "(Landroid/widget/Button;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "menuInfoList", "Ljava/util/ArrayList;", "Lcom/smit/finalproject/model/Menu;", "getMenuInfoList", "()Ljava/util/ArrayList;", "menuLayout", "Landroid/widget/RelativeLayout;", "getMenuLayout", "()Landroid/widget/RelativeLayout;", "setMenuLayout", "(Landroid/widget/RelativeLayout;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressLayout", "getProgressLayout", "setProgressLayout", "recyclerAdapter", "Lcom/smit/finalproject/adapter/MenuRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/smit/finalproject/adapter/MenuRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/smit/finalproject/adapter/MenuRecyclerAdapter;)V", "recyclerMenu", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerMenu", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerMenu", "(Landroidx/recyclerview/widget/RecyclerView;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class RestaurantMenuActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView recyclerMenu;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.NotNull()
    public android.widget.RelativeLayout progressLayout;
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button btnProceedToCart;
    @org.jetbrains.annotations.NotNull()
    public android.widget.RelativeLayout menuLayout;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.smit.finalproject.model.Menu> menuInfoList = null;
    @org.jetbrains.annotations.NotNull()
    public com.smit.finalproject.adapter.MenuRecyclerAdapter recyclerAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerMenu() {
        return null;
    }
    
    public final void setRecyclerMenu(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getProgressLayout() {
        return null;
    }
    
    public final void setProgressLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }
    
    public final void setLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnProceedToCart() {
        return null;
    }
    
    public final void setBtnProceedToCart(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getMenuLayout() {
        return null;
    }
    
    public final void setMenuLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.smit.finalproject.model.Menu> getMenuInfoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smit.finalproject.adapter.MenuRecyclerAdapter getRecyclerAdapter() {
        return null;
    }
    
    public final void setRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.MenuRecyclerAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public RestaurantMenuActivity() {
        super();
    }
}