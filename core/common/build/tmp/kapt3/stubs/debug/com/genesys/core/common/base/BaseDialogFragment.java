package com.genesys.core.common.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B1\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH&J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010\'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0018H\u0014R\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00028\u00008DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006-"}, d2 = {"Lcom/genesys/core/common/base/BaseDialogFragment;", "VB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/DialogFragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Lcom/genesys/core/common/base/Inflater;", "(Lkotlin/jvm/functions/Function3;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_viewBinding", "Landroidx/databinding/ViewDataBinding;", "<set-?>", "isCreated", "()Z", "viewBinding", "getViewBinding", "()Landroidx/databinding/ViewDataBinding;", "dimAmount", "", "initListeners", "", "initObservers", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStart", "onViewCreated", "view", "setDialogCancelable", "isCancelable", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "width", "common_debug"})
public abstract class BaseDialogFragment<VB extends androidx.databinding.ViewDataBinding> extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, VB> inflate = null;
    @org.jetbrains.annotations.Nullable()
    private VB _viewBinding;
    private boolean isCreated = false;
    
    public BaseDialogFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, ? extends VB> inflate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getViewBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTAG();
    
    public final boolean isCreated() {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract void initViews();
    
    protected void initObservers() {
    }
    
    protected void initListeners() {
    }
    
    protected float dimAmount() {
        return 0.0F;
    }
    
    protected float width() {
        return 0.0F;
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager) {
    }
    
    public final void setDialogCancelable(boolean isCancelable) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
}