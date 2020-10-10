package com.smit.finalproject.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/smit/finalproject/adapter/CartRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/smit/finalproject/adapter/CartRecyclerAdapter$CartViewHolder;", "context", "Landroid/content/Context;", "cartList", "", "Lcom/smit/finalproject/database/CartEntity;", "(Landroid/content/Context;Ljava/util/List;)V", "getCartList", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CartViewHolder", "app_debug"})
public final class CartRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.smit.finalproject.adapter.CartRecyclerAdapter.CartViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.smit.finalproject.database.CartEntity> cartList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.smit.finalproject.adapter.CartRecyclerAdapter.CartViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.smit.finalproject.adapter.CartRecyclerAdapter.CartViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.smit.finalproject.database.CartEntity> getCartList() {
        return null;
    }
    
    public CartRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.smit.finalproject.database.CartEntity> cartList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/smit/finalproject/adapter/CartRecyclerAdapter$CartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "llContent", "Landroid/widget/LinearLayout;", "getLlContent", "()Landroid/widget/LinearLayout;", "txtItemName", "Landroid/widget/TextView;", "getTxtItemName", "()Landroid/widget/TextView;", "txtItemPrice", "getTxtItemPrice", "app_debug"})
    public static final class CartViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtItemName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtItemPrice = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout llContent = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtItemName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtItemPrice() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getLlContent() {
            return null;
        }
        
        public CartViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}