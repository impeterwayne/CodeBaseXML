package com.genesys.core.ui.epoxy;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/genesys/core/ui/epoxy/CarouselNoSnap;", "Lcom/airbnb/epoxy/Carousel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSnapHelperFactory", "", "ui_debug"})
@com.airbnb.epoxy.ModelView(saveViewState = true, autoLayout = com.airbnb.epoxy.ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
public final class CarouselNoSnap extends com.airbnb.epoxy.Carousel {
    
    public CarouselNoSnap(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    protected java.lang.Void getSnapHelperFactory() {
        return null;
    }
}