package com.genesys.core.ui.recyclerview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/genesys/core/ui/recyclerview/SingleScrollDirectionEnforcer;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "()V", "dx", "", "dy", "initialTouchX", "initialTouchY", "scrollPointerId", "scrollState", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onScrollStateChanged", "recyclerView", "newState", "onTouchEvent", "ui_debug"})
final class SingleScrollDirectionEnforcer extends androidx.recyclerview.widget.RecyclerView.OnScrollListener implements androidx.recyclerview.widget.RecyclerView.OnItemTouchListener {
    private int scrollState = androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;
    private int scrollPointerId = -1;
    private int initialTouchX = 0;
    private int initialTouchY = 0;
    private int dx = 0;
    private int dy = 0;
    
    public SingleScrollDirectionEnforcer() {
        super();
    }
    
    @java.lang.Override()
    public boolean onInterceptTouchEvent(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView rv, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent e) {
        return false;
    }
    
    @java.lang.Override()
    public void onTouchEvent(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView rv, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent e) {
    }
    
    @java.lang.Override()
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
    
    @java.lang.Override()
    public void onScrollStateChanged(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, int newState) {
    }
}