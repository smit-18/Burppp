package com.smit.finalproject.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u00107\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006D"}, d2 = {"Lcom/smit/finalproject/fragment/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "priceComparator", "Ljava/util/Comparator;", "Lcom/smit/finalproject/model/Restaurant;", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressLayout", "Landroid/widget/RelativeLayout;", "getProgressLayout", "()Landroid/widget/RelativeLayout;", "setProgressLayout", "(Landroid/widget/RelativeLayout;)V", "ratingComparator", "getRatingComparator", "()Ljava/util/Comparator;", "setRatingComparator", "(Ljava/util/Comparator;)V", "recyclerAdapter", "Lcom/smit/finalproject/adapter/HomeRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/smit/finalproject/adapter/HomeRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/smit/finalproject/adapter/HomeRecyclerAdapter;)V", "recyclerHome", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerHome", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerHome", "(Landroidx/recyclerview/widget/RecyclerView;)V", "resInfoList", "Ljava/util/ArrayList;", "getResInfoList", "()Ljava/util/ArrayList;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView recyclerHome;
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.NotNull()
    public android.widget.RelativeLayout progressLayout;
    @org.jetbrains.annotations.NotNull()
    public android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.smit.finalproject.model.Restaurant> resInfoList = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.Comparator<com.smit.finalproject.model.Restaurant> ratingComparator;
    private java.util.Comparator<com.smit.finalproject.model.Restaurant> priceComparator;
    @org.jetbrains.annotations.NotNull()
    public com.smit.finalproject.adapter.HomeRecyclerAdapter recyclerAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerHome() {
        return null;
    }
    
    public final void setRecyclerHome(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }
    
    public final void setLayoutManager(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.LayoutManager p0) {
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
    public final android.content.SharedPreferences getSharedPreferences() {
        return null;
    }
    
    public final void setSharedPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.smit.finalproject.model.Restaurant> getResInfoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Comparator<com.smit.finalproject.model.Restaurant> getRatingComparator() {
        return null;
    }
    
    public final void setRatingComparator(@org.jetbrains.annotations.NotNull()
    java.util.Comparator<com.smit.finalproject.model.Restaurant> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.smit.finalproject.adapter.HomeRecyclerAdapter getRecyclerAdapter() {
        return null;
    }
    
    public final void setRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.HomeRecyclerAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public HomeFragment() {
        super();
    }
}