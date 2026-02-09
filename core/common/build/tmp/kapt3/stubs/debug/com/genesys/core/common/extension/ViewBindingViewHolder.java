package com.genesys.core.common.extension;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000eR\u0013\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/genesys/core/common/extension/ViewBindingViewHolder;", "T", "", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "(Landroidx/viewbinding/ViewBinding;)V", "getViewBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "onBind", "", "item", "(Ljava/lang/Object;)V", "common_debug"})
public abstract class ViewBindingViewHolder<T extends java.lang.Object, VB extends androidx.viewbinding.ViewBinding> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final VB viewBinding = null;
    
    public ViewBindingViewHolder(@org.jetbrains.annotations.NotNull()
    VB viewBinding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VB getViewBinding() {
        return null;
    }
    
    public abstract void onBind(@org.jetbrains.annotations.NotNull()
    T item);
}