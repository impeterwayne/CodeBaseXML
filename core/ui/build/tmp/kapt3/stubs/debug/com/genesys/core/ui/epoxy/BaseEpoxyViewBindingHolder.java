package com.genesys.core.ui.epoxy;

/**
 * @author : CuongNK
 * @created : 10/4/2024
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0011\u0010\u0006\u001a\u00020\u0007*\u00028\u0000H&\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\f\u001a\u00020\u0007*\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/genesys/core/ui/epoxy/BaseEpoxyViewBindingHolder;", "T", "Landroidx/viewbinding/ViewBinding;", "Lcom/airbnb/epoxy/EpoxyModelWithHolder;", "Lcom/genesys/core/ui/epoxy/ViewBindingHolder;", "()V", "bind", "", "holder", "createNewHolder", "parent", "Landroid/view/ViewParent;", "unbind", "(Landroidx/viewbinding/ViewBinding;)V", "ui_debug"})
public abstract class BaseEpoxyViewBindingHolder<T extends androidx.viewbinding.ViewBinding> extends com.airbnb.epoxy.EpoxyModelWithHolder<com.genesys.core.ui.epoxy.ViewBindingHolder> {
    
    public BaseEpoxyViewBindingHolder() {
        super();
    }
    
    @java.lang.Override()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public void bind(@org.jetbrains.annotations.NotNull()
    com.genesys.core.ui.epoxy.ViewBindingHolder holder) {
    }
    
    public abstract void bind(@org.jetbrains.annotations.NotNull()
    T p0);
    
    @java.lang.Override()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public void unbind(@org.jetbrains.annotations.NotNull()
    com.genesys.core.ui.epoxy.ViewBindingHolder holder) {
    }
    
    public void unbind(@org.jetbrains.annotations.NotNull()
    T $this$unbind) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.genesys.core.ui.epoxy.ViewBindingHolder createNewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewParent parent) {
        return null;
    }
}