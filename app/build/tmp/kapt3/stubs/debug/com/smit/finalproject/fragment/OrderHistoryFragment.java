package com.smit.finalproject.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/smit/finalproject/fragment/OrderHistoryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "noOrders", "Landroid/widget/LinearLayout;", "getNoOrders", "()Landroid/widget/LinearLayout;", "setNoOrders", "(Landroid/widget/LinearLayout;)V", "orderHistoryAdapter", "Lcom/smit/finalproject/adapter/OrderHistoryAdapter;", "getOrderHistoryAdapter", "()Lcom/smit/finalproject/adapter/OrderHistoryAdapter;", "setOrderHistoryAdapter", "(Lcom/smit/finalproject/adapter/OrderHistoryAdapter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressLayout", "Landroid/widget/RelativeLayout;", "getProgressLayout", "()Landroid/widget/RelativeLayout;", "setProgressLayout", "(Landroid/widget/RelativeLayout;)V", "recyclerOrderHistory", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerOrderHistory", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerOrderHistory", "(Landroidx/recyclerview/widget/RecyclerView;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class OrderHistoryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.smit.finalproject.adapter.OrderHistoryAdapter orderHistoryAdapter;
    private android.content.SharedPreferences sharedPreferences;
    @org.jetbrains.annotations.NotNull()
    public androidx.recyclerview.widget.RecyclerView recyclerOrderHistory;
    @org.jetbrains.annotations.NotNull()
    public android.widget.RelativeLayout progressLayout;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ProgressBar progressBar;
    @org.jetbrains.annotations.NotNull()
    public android.widget.LinearLayout noOrders;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.smit.finalproject.adapter.OrderHistoryAdapter getOrderHistoryAdapter() {
        return null;
    }
    
    public final void setOrderHistoryAdapter(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.OrderHistoryAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerOrderHistory() {
        return null;
    }
    
    public final void setRecyclerOrderHistory(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getProgressLayout() {
        return null;
    }
    
    public final void setProgressLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ProgressBar getProgressBar() {
        return null;
    }
    
    public final void setProgressBar(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.LinearLayout getNoOrders() {
        return null;
    }
    
    public final void setNoOrders(@org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public OrderHistoryFragment() {
        super();
    }
}