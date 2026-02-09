package com.genesys.core.common.extension;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000eR\u0013\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/genesys/core/common/extension/DataBindingViewHolder;", "T", "", "VB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "getDataBinding", "()Landroidx/databinding/ViewDataBinding;", "Landroidx/databinding/ViewDataBinding;", "onBind", "", "item", "(Ljava/lang/Object;)V", "common_debug"})
public abstract class DataBindingViewHolder<T extends java.lang.Object, VB extends androidx.databinding.ViewDataBinding> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final VB dataBinding = null;
    
    public DataBindingViewHolder(@org.jetbrains.annotations.NotNull()
    VB dataBinding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VB getDataBinding() {
        return null;
    }
    
    public abstract void onBind(@org.jetbrains.annotations.NotNull()
    T item);
}