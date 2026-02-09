package com.genesys.feature.template.main;

/**
 * @author : CuongNK
 * @created : 9/1/2025
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/genesys/feature/template/main/MainViewModel;", "Lcom/genesys/core/common/base/BaseViewModel;", "Lcom/genesys/feature/template/main/MainViewModel$MainEvent;", "()V", "onEvent", "", "state", "MainEvent", "template_debug"})
public final class MainViewModel extends com.genesys.core.common.base.BaseViewModel<com.genesys.feature.template.main.MainViewModel.MainEvent> {
    
    public MainViewModel() {
        super();
    }
    
    @java.lang.Override()
    public void onEvent(@org.jetbrains.annotations.NotNull()
    com.genesys.feature.template.main.MainViewModel.MainEvent state) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/genesys/feature/template/main/MainViewModel$MainEvent;", "Lcom/genesys/core/common/base/BaseViewModel$IEvent;", "()V", "Init", "Lcom/genesys/feature/template/main/MainViewModel$MainEvent$Init;", "template_debug"})
    public static abstract class MainEvent implements com.genesys.core.common.base.BaseViewModel.IEvent {
        
        private MainEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/genesys/feature/template/main/MainViewModel$MainEvent$Init;", "Lcom/genesys/feature/template/main/MainViewModel$MainEvent;", "()V", "template_debug"})
        public static final class Init extends com.genesys.feature.template.main.MainViewModel.MainEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.genesys.feature.template.main.MainViewModel.MainEvent.Init INSTANCE = null;
            
            private Init() {
            }
        }
    }
}