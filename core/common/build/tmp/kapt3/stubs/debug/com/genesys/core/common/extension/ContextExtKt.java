package com.genesys.core.common.extension;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0001\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\u001e\u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0001\u00a8\u0006\u0013"}, d2 = {"heightScreen", "", "widthScreen", "dpToPx", "", "Landroid/content/Context;", "dp", "drawable", "Landroid/graphics/drawable/Drawable;", "isNetwork", "", "openWebBrowser", "", "url", "", "showToast", "messageRes", "length", "message", "common_debug"})
public final class ContextExtKt {
    
    public static final void showToast(@org.jetbrains.annotations.Nullable()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int length) {
    }
    
    public static final void showToast(@org.jetbrains.annotations.Nullable()
    android.content.Context $this$showToast, int messageRes, int length) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable drawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$drawable, @androidx.annotation.DrawableRes()
    int drawable) {
        return null;
    }
    
    public static final void openWebBrowser(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$openWebBrowser, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    public static final float dpToPx(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$dpToPx, int dp) {
        return 0.0F;
    }
    
    public static final int heightScreen() {
        return 0;
    }
    
    public static final int widthScreen() {
        return 0;
    }
    
    public static final boolean isNetwork(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isNetwork) {
        return false;
    }
}