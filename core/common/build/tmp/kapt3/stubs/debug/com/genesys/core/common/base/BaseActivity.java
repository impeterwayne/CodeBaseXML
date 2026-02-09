package com.genesys.core.common.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0010\u001a\u00020\t2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012\"\u00020\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H&J\b\u0010\u0017\u001a\u00020\tH\u0014J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0014J\b\u0010\u001a\u001a\u00020\tH\u0014J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010!\u001a\u00020\u001fH\u0014J\u0012\u0010\"\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010#\u001a\u00020\tH\u0014J \u0010$\u001a\u00020\u001f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0015J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010\'\u001a\u00020\tH\u0014J\b\u0010(\u001a\u00020\tH\u0002J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130*H\u0014J!\u0010+\u001a\u00020\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0-\u00a2\u0006\u0002\b.H\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00028\u00008DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006/"}, d2 = {"Lcom/genesys/core/common/base/BaseActivity;", "VB", "Landroidx/databinding/ViewDataBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onPerformBackPressed", "Lkotlin/Function0;", "", "Lcom/genesys/core/common/base/OnPerformBackPressed;", "viewBinding", "getViewBinding", "()Landroidx/databinding/ViewDataBinding;", "viewBinding$delegate", "Lkotlin/Lazy;", "applyStatusBarPadding", "views", "", "Landroid/view/View;", "([Landroid/view/View;)V", "getLazyViewBinding", "Lkotlin/Lazy;", "initAds", "initImmersiveBar", "initListeners", "initObservers", "initViews", "savedInstanceState", "Landroid/os/Bundle;", "isFitsSystemWindows", "", "isForceDarkMode", "isHideSystemBars", "onCreate", "onDestroy", "onHandleBackPressed", "onBackPressed", "registerBackPressedDispatcher", "setupInit", "setupWindowInsets", "statusBarInsetTargets", "", "withViewBindings", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "common_debug"})
public abstract class BaseActivity<VB extends androidx.databinding.ViewDataBinding> extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewBinding$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> onPerformBackPressed;
    @org.jetbrains.annotations.NotNull()
    private androidx.activity.OnBackPressedCallback onBackPressedCallback;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getViewBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.Lazy<VB> getLazyViewBinding();
    
    @org.jetbrains.annotations.NotNull()
    protected java.util.List<android.view.View> statusBarInsetTargets() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected boolean isForceDarkMode() {
        return false;
    }
    
    protected boolean isFitsSystemWindows() {
        return false;
    }
    
    protected boolean isHideSystemBars() {
        return false;
    }
    
    private final void initImmersiveBar() {
    }
    
    private final void registerBackPressedDispatcher() {
    }
    
    @androidx.annotation.CallSuper()
    protected boolean onHandleBackPressed(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackPressed) {
        return false;
    }
    
    protected void setupInit() {
    }
    
    public abstract void initViews(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState);
    
    protected void initAds() {
    }
    
    protected void initObservers() {
    }
    
    protected void initListeners() {
    }
    
    protected final void withViewBindings(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super VB, kotlin.Unit> block) {
    }
    
    private final void setupWindowInsets() {
    }
    
    private final void applyStatusBarPadding(android.view.View... views) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}