package com.genesys.core.ui.recyclerview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0004\u0012\u0002H\u0001\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002:\u0001\u001aB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\"\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\r\u001a\u00020\bH\u0016J%\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010\u0013J\"\u0010\u0014\u001a\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J%\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\bH&\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/genesys/core/ui/recyclerview/BaseListAdapter;", "T", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/genesys/core/ui/recyclerview/BaseListAdapter$ViewHolder;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "getItemLayout", "", "viewType", "onBindViewHolder", "", "holder", "position", "onClickViews", "binding", "Landroidx/databinding/ViewDataBinding;", "obj", "layoutPosition", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onResizeViews", "setData", "item", "ViewHolder", "ui_debug"})
public abstract class BaseListAdapter<T extends java.lang.Object> extends androidx.recyclerview.widget.ListAdapter<T, com.genesys.core.ui.recyclerview.BaseListAdapter<T>.ViewHolder> {
    
    public BaseListAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.DiffUtil.ItemCallback<T> diffCallback) {
        super(null);
    }
    
    public abstract int getItemLayout(int viewType);
    
    public abstract void setData(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ViewDataBinding binding, T item, int layoutPosition);
    
    public void onResizeViews(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ViewDataBinding binding) {
    }
    
    public void onClickViews(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ViewDataBinding binding, T obj, int layoutPosition) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.genesys.core.ui.recyclerview.BaseListAdapter<T>.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.genesys.core.ui.recyclerview.BaseListAdapter<T>.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/genesys/core/ui/recyclerview/BaseListAdapter$ViewHolder;", "Lcom/genesys/core/ui/recyclerview/BaseViewHolder;", "binding", "Landroidx/databinding/ViewDataBinding;", "(Lcom/genesys/core/ui/recyclerview/BaseListAdapter;Landroidx/databinding/ViewDataBinding;)V", "bindData", "", "obj", "(Ljava/lang/Object;)V", "onClickViews", "onResizeViews", "ui_debug"})
    public final class ViewHolder extends com.genesys.core.ui.recyclerview.BaseViewHolder<T> {
        @org.jetbrains.annotations.NotNull()
        private final androidx.databinding.ViewDataBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        androidx.databinding.ViewDataBinding binding) {
            super(null);
        }
        
        @java.lang.Override()
        public void bindData(T obj) {
        }
        
        @java.lang.Override()
        public void onResizeViews() {
        }
        
        @java.lang.Override()
        public void onClickViews(T obj) {
        }
    }
}