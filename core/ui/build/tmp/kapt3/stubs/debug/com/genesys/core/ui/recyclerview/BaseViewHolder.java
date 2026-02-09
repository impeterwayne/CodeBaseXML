package com.genesys.core.ui.recyclerview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/genesys/core/ui/recyclerview/BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBinding", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "bindData", "", "obj", "(Ljava/lang/Object;)V", "onClickViews", "onResizeViews", "ui_debug"})
public abstract class BaseViewHolder<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    
    public BaseViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.databinding.ViewDataBinding mBinding) {
        super(null);
    }
    
    public abstract void bindData(T obj);
    
    public void onResizeViews() {
    }
    
    public void onClickViews(T obj) {
    }
}