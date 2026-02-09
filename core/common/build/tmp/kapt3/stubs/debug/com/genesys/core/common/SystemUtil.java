package com.genesys.core.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000eH\u0007J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/genesys/core/common/SystemUtil;", "", "()V", "languageApp", "", "", "getLanguageApp", "()Ljava/util/List;", "myLocale", "Ljava/util/Locale;", "changeLang", "", "lang", "context", "Landroid/content/Context;", "getPreLanguage", "mContext", "saveLocale", "setLocale", "setPreLanguage", "language", "common_debug"})
public final class SystemUtil {
    @org.jetbrains.annotations.Nullable()
    private static java.util.Locale myLocale;
    @org.jetbrains.annotations.NotNull()
    public static final com.genesys.core.common.SystemUtil INSTANCE = null;
    
    private SystemUtil() {
        super();
    }
    
    private final void changeLang(java.lang.String lang, android.content.Context context) {
    }
    
    public final void setLocale(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getLanguageApp() {
        return null;
    }
    
    private final void saveLocale(android.content.Context context, java.lang.String lang) {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPreLanguage(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        return null;
    }
    
    public final void setPreLanguage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String language) {
    }
}