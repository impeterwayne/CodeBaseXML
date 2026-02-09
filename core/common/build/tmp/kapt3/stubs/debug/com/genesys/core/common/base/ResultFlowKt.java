package com.genesys.core.common.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aC\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032%\b\u0004\u0010\u0004\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u001aA\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032#\b\u0004\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u001aA\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032#\b\u0004\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000e"}, d2 = {"doOnError", "", "T", "Lcom/genesys/core/common/base/ResultFlow;", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msg", "doOnLoading", "info", "doOnSuccess", "data", "common_debug"})
public final class ResultFlowKt {
    
    public static final <T extends java.lang.Object>void doOnSuccess(@org.jetbrains.annotations.NotNull()
    com.genesys.core.common.base.ResultFlow<T> $this$doOnSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
    }
    
    public static final <T extends java.lang.Object>void doOnLoading(@org.jetbrains.annotations.NotNull()
    com.genesys.core.common.base.ResultFlow<T> $this$doOnLoading, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> action) {
    }
    
    public static final <T extends java.lang.Object>void doOnError(@org.jetbrains.annotations.NotNull()
    com.genesys.core.common.base.ResultFlow<T> $this$doOnError, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> action) {
    }
}