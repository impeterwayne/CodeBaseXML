package com.genesys.core.common.extension;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007\u00a8\u0006\u000e"}, d2 = {"observe", "", "T", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "Landroidx/lifecycle/LiveData;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "Lkotlinx/coroutines/CoroutineScope;", "flow", "Lkotlinx/coroutines/flow/Flow;", "common_debug"})
public final class ArchComponentExtKt {
    
    public static final <T extends java.lang.Object>void observe(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner $this$observe, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<T> liveData, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
    }
    
    public static final <T extends java.lang.Object>void observe(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope $this$observe, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends T> flow, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
    }
}