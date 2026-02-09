package com.genesys.core.ui.epoxy;

import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.EpoxyBuildScope;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import java.lang.CharSequence;
import java.lang.Number;
import java.util.List;

@EpoxyBuildScope
public interface CarouselNoSnapModelBuilder {
  CarouselNoSnapModelBuilder onBind(
      OnModelBoundListener<CarouselNoSnapModel_, CarouselNoSnap> listener);

  CarouselNoSnapModelBuilder onUnbind(
      OnModelUnboundListener<CarouselNoSnapModel_, CarouselNoSnap> listener);

  CarouselNoSnapModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<CarouselNoSnapModel_, CarouselNoSnap> listener);

  CarouselNoSnapModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<CarouselNoSnapModel_, CarouselNoSnap> listener);

  CarouselNoSnapModelBuilder hasFixedSize(boolean hasFixedSize);

  CarouselNoSnapModelBuilder numViewsToShowOnScreen(float numViewsToShowOnScreen);

  CarouselNoSnapModelBuilder initialPrefetchItemCount(int initialPrefetchItemCount);

  CarouselNoSnapModelBuilder paddingRes(@DimenRes int paddingRes);

  CarouselNoSnapModelBuilder paddingDp(@Dimension(unit = 0) int paddingDp);

  CarouselNoSnapModelBuilder padding(@Nullable Carousel.Padding padding);

  CarouselNoSnapModelBuilder models(@NonNull List<? extends EpoxyModel<?>> models);

  CarouselNoSnapModelBuilder id(long id);

  CarouselNoSnapModelBuilder id(@Nullable Number... ids);

  CarouselNoSnapModelBuilder id(long id1, long id2);

  CarouselNoSnapModelBuilder id(@Nullable CharSequence key);

  CarouselNoSnapModelBuilder id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys);

  CarouselNoSnapModelBuilder id(@Nullable CharSequence key, long id);

  CarouselNoSnapModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
