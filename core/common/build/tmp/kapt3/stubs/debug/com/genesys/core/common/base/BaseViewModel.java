package com.genesys.core.common.base;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0004JJ\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\'\u0010\u001e\u001a#\b\u0001\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010#0\u001f\u00a2\u0006\u0002\b$H\u0004\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\"H\u0014J\u0015\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006-"}, d2 = {"Lcom/genesys/core/common/base/BaseViewModel;", "Event", "Lcom/genesys/core/common/base/BaseViewModel$IEvent;", "Landroidx/lifecycle/ViewModel;", "()V", "_networkState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_purchaseState", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "networkState", "Lkotlinx/coroutines/flow/StateFlow;", "getNetworkState$common_debug", "()Lkotlinx/coroutines/flow/StateFlow;", "networkStateValue", "getNetworkStateValue$common_debug", "()Z", "purchaseState", "getPurchaseState$common_debug", "setPurchaseState$common_debug", "(Lkotlinx/coroutines/flow/StateFlow;)V", "purchaseStateValue", "getPurchaseStateValue$common_debug", "launchBlock", "Lkotlinx/coroutines/Job;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onCleared", "onEvent", "state", "(Lcom/genesys/core/common/base/BaseViewModel$IEvent;)V", "setNetworkState", "isConnected", "IEvent", "common_debug"})
public abstract class BaseViewModel<Event extends com.genesys.core.common.base.BaseViewModel.IEvent> extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineExceptionHandler coroutineExceptionHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _purchaseState = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> purchaseState;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _networkState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> networkState = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getPurchaseState$common_debug() {
        return null;
    }
    
    public final void setPurchaseState$common_debug(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> p0) {
    }
    
    public final boolean getPurchaseStateValue$common_debug() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNetworkState$common_debug() {
        return null;
    }
    
    public final boolean getNetworkStateValue$common_debug() {
        return false;
    }
    
    public final void setNetworkState(boolean isConnected) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.Job launchBlock(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineStart start, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
        return null;
    }
    
    public abstract void onEvent(@org.jetbrains.annotations.NotNull()
    Event state);
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/genesys/core/common/base/BaseViewModel$IEvent;", "", "common_debug"})
    public static abstract interface IEvent {
    }
}