package com.smit.finalproject.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0007H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/smit/finalproject/adapter/OrderHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smit/finalproject/adapter/OrderHistoryAdapter$OrderHistoryViewHolder;", "context", "Landroid/content/Context;", "orderHistoryList", "Ljava/util/ArrayList;", "Lcom/smit/finalproject/model/OrderDetails;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "formatDate", "", "dateString", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setUpRecycler", "recyclerResHistory", "Landroidx/recyclerview/widget/RecyclerView;", "OrderHistoryViewHolder", "app_debug"})
public final class OrderHistoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smit.finalproject.adapter.OrderHistoryAdapter.OrderHistoryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.smit.finalproject.model.OrderDetails> orderHistoryList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smit.finalproject.adapter.OrderHistoryAdapter.OrderHistoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.OrderHistoryAdapter.OrderHistoryViewHolder holder, int position) {
    }
    
    private final void setUpRecycler(androidx.recyclerview.widget.RecyclerView recyclerResHistory, com.smit.finalproject.model.OrderDetails orderHistoryList) {
    }
    
    private final java.lang.String formatDate(java.lang.String dateString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public OrderHistoryAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.smit.finalproject.model.OrderDetails> orderHistoryList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/smit/finalproject/adapter/OrderHistoryAdapter$OrderHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "recyclerResHistory", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerResHistory", "()Landroidx/recyclerview/widget/RecyclerView;", "txtDate", "Landroid/widget/TextView;", "getTxtDate", "()Landroid/widget/TextView;", "txtResName", "getTxtResName", "app_debug"})
    public static final class OrderHistoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtResName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtDate = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.recyclerview.widget.RecyclerView recyclerResHistory = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtResName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRecyclerResHistory() {
            return null;
        }
        
        public OrderHistoryViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}