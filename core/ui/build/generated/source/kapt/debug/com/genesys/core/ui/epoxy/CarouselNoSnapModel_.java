package com.genesys.core.ui.epoxy;

import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import java.lang.CharSequence;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Number;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.UnsupportedOperationException;
import java.util.BitSet;
import java.util.List;

/**
 * Generated file. Do not modify!
 */
public class CarouselNoSnapModel_ extends EpoxyModel<CarouselNoSnap> implements GeneratedModel<CarouselNoSnap>, CarouselNoSnapModelBuilder {
  private final BitSet assignedAttributes_epoxyGeneratedModel = new BitSet(7);

  private OnModelBoundListener<CarouselNoSnapModel_, CarouselNoSnap> onModelBoundListener_epoxyGeneratedModel;

  private OnModelUnboundListener<CarouselNoSnapModel_, CarouselNoSnap> onModelUnboundListener_epoxyGeneratedModel;

  private OnModelVisibilityStateChangedListener<CarouselNoSnapModel_, CarouselNoSnap> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

  private OnModelVisibilityChangedListener<CarouselNoSnapModel_, CarouselNoSnap> onModelVisibilityChangedListener_epoxyGeneratedModel;

  private boolean hasFixedSize_Boolean = false;

  /**
   * Bitset index: 1
   */
  private float numViewsToShowOnScreen_Float = 0.0f;

  /**
   * Bitset index: 2
   */
  private int initialPrefetchItemCount_Int = 0;

  /**
   * Bitset index: 3
   */
  @DimenRes
  private int paddingRes_Int = 0;

  /**
   * Bitset index: 4
   */
  @Dimension(
      unit = 0
  )
  private int paddingDp_Int = Carousel.NO_VALUE_SET;

  /**
   * Bitset index: 5
   */
  @Nullable
  private Carousel.Padding padding_Padding = (Carousel.Padding) null;

  /**
   * Bitset index: 6
   */
  @NonNull
  private List<? extends EpoxyModel<?>> models_List;

  @Override
  public void addTo(EpoxyController controller) {
    super.addTo(controller);
    addWithDebugValidation(controller);
    if (!assignedAttributes_epoxyGeneratedModel.get(6)) {
    	throw new IllegalStateException("A value is required for setModels");
    }
  }

  @Override
  protected int getViewType() {
    return 0;
  }

  @Override
  public CarouselNoSnap buildView(ViewGroup parent) {
    CarouselNoSnap v = new CarouselNoSnap(parent.getContext());
    v.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.MATCH_PARENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT));
    return v;
  }

  @Override
  public void handlePreBind(final EpoxyViewHolder holder, final CarouselNoSnap object,
      final int position) {
    validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", position);
  }

  @Override
  public void bind(final CarouselNoSnap object) {
    super.bind(object);
    if (assignedAttributes_epoxyGeneratedModel.get(3)) {
      object.setPaddingRes(paddingRes_Int);
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(4)) {
      object.setPaddingDp(paddingDp_Int);
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(5)) {
      object.setPadding(padding_Padding);
    }
    else {
      object.setPaddingDp(paddingDp_Int);
    }
    object.setHasFixedSize(hasFixedSize_Boolean);
    if (assignedAttributes_epoxyGeneratedModel.get(1)) {
      object.setNumViewsToShowOnScreen(numViewsToShowOnScreen_Float);
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(2)) {
      object.setInitialPrefetchItemCount(initialPrefetchItemCount_Int);
    }
    else {
      object.setNumViewsToShowOnScreen(numViewsToShowOnScreen_Float);
    }
    object.setModels(models_List);
  }

  @Override
  public void bind(final CarouselNoSnap object, EpoxyModel previousModel) {
    if (!(previousModel instanceof CarouselNoSnapModel_)) {
      bind(object);
      return;
    }
    CarouselNoSnapModel_ that = (CarouselNoSnapModel_) previousModel;
    super.bind(object);

    if (assignedAttributes_epoxyGeneratedModel.get(3)) {
      if ((paddingRes_Int != that.paddingRes_Int)) {
        object.setPaddingRes(paddingRes_Int);
      }
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(4)) {
      if ((paddingDp_Int != that.paddingDp_Int)) {
        object.setPaddingDp(paddingDp_Int);
      }
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(5)) {
      if (!that.assignedAttributes_epoxyGeneratedModel.get(5) || (padding_Padding != null ? !padding_Padding.equals(that.padding_Padding) : that.padding_Padding != null)) {
        object.setPadding(padding_Padding);
      }
    }
    // A value was not set so we should use the default value, but we only need to set it if the previous model had a custom value set.
    else if (that.assignedAttributes_epoxyGeneratedModel.get(3) || that.assignedAttributes_epoxyGeneratedModel.get(4) || that.assignedAttributes_epoxyGeneratedModel.get(5)) {
      object.setPaddingDp(paddingDp_Int);
    }

    if ((hasFixedSize_Boolean != that.hasFixedSize_Boolean)) {
      object.setHasFixedSize(hasFixedSize_Boolean);
    }

    if (assignedAttributes_epoxyGeneratedModel.get(1)) {
      if ((Float.compare(that.numViewsToShowOnScreen_Float, numViewsToShowOnScreen_Float) != 0)) {
        object.setNumViewsToShowOnScreen(numViewsToShowOnScreen_Float);
      }
    }
    else if (assignedAttributes_epoxyGeneratedModel.get(2)) {
      if ((initialPrefetchItemCount_Int != that.initialPrefetchItemCount_Int)) {
        object.setInitialPrefetchItemCount(initialPrefetchItemCount_Int);
      }
    }
    // A value was not set so we should use the default value, but we only need to set it if the previous model had a custom value set.
    else if (that.assignedAttributes_epoxyGeneratedModel.get(1) || that.assignedAttributes_epoxyGeneratedModel.get(2)) {
      object.setNumViewsToShowOnScreen(numViewsToShowOnScreen_Float);
    }

    if ((models_List != null ? !models_List.equals(that.models_List) : that.models_List != null)) {
      object.setModels(models_List);
    }
  }

  @Override
  public void handlePostBind(final CarouselNoSnap object, int position) {
    if (onModelBoundListener_epoxyGeneratedModel != null) {
      onModelBoundListener_epoxyGeneratedModel.onModelBound(this, object, position);
    }
    validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", position);
  }

  /**
   * Register a listener that will be called when this model is bound to a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()}
   */
  public CarouselNoSnapModel_ onBind(
      OnModelBoundListener<CarouselNoSnapModel_, CarouselNoSnap> listener) {
    onMutation();
    this.onModelBoundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void unbind(CarouselNoSnap object) {
    super.unbind(object);
    if (onModelUnboundListener_epoxyGeneratedModel != null) {
      onModelUnboundListener_epoxyGeneratedModel.onModelUnbound(this, object);
    }
    object.clear();
  }

  /**
   * Register a listener that will be called when this model is unbound from a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()}
   */
  public CarouselNoSnapModel_ onUnbind(
      OnModelUnboundListener<CarouselNoSnapModel_, CarouselNoSnap> listener) {
    onMutation();
    this.onModelUnboundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityStateChanged(int visibilityState, final CarouselNoSnap object) {
    if (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityStateChangedListener_epoxyGeneratedModel.onVisibilityStateChanged(this, object, visibilityState);
    }
    super.onVisibilityStateChanged(visibilityState, object);
  }

  /**
   * Register a listener that will be called when this model visibility state has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public CarouselNoSnapModel_ onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<CarouselNoSnapModel_, CarouselNoSnap> listener) {
    onMutation();
    this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth,
      int visibleHeight, int visibleWidth, final CarouselNoSnap object) {
    if (onModelVisibilityChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityChangedListener_epoxyGeneratedModel.onVisibilityChanged(this, object, percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth);
    }
    super.onVisibilityChanged(percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth, object);
  }

  /**
   * Register a listener that will be called when this model visibility has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public CarouselNoSnapModel_ onVisibilityChanged(
      OnModelVisibilityChangedListener<CarouselNoSnapModel_, CarouselNoSnap> listener) {
    onMutation();
    this.onModelVisibilityChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  /**
   * <i>Optional</i>: Default value is false
   *
   * @see Carousel#setHasFixedSize(boolean)
   */
  public CarouselNoSnapModel_ hasFixedSize(boolean hasFixedSize) {
    onMutation();
    this.hasFixedSize_Boolean = hasFixedSize;
    return this;
  }

  public boolean hasFixedSize() {
    return hasFixedSize_Boolean;
  }

  /**
   * <i>Optional</i>: Default value is 0.0f
   *
   * @see Carousel#setNumViewsToShowOnScreen(float)
   */
  public CarouselNoSnapModel_ numViewsToShowOnScreen(float numViewsToShowOnScreen) {
    assignedAttributes_epoxyGeneratedModel.set(1);
    assignedAttributes_epoxyGeneratedModel.clear(2);
    this.initialPrefetchItemCount_Int = 0;
    onMutation();
    this.numViewsToShowOnScreen_Float = numViewsToShowOnScreen;
    return this;
  }

  public float numViewsToShowOnScreenFloat() {
    return numViewsToShowOnScreen_Float;
  }

  /**
   * <i>Optional</i>: Default value is 0
   *
   * @see Carousel#setInitialPrefetchItemCount(int)
   */
  public CarouselNoSnapModel_ initialPrefetchItemCount(int initialPrefetchItemCount) {
    assignedAttributes_epoxyGeneratedModel.set(2);
    assignedAttributes_epoxyGeneratedModel.clear(1);
    this.numViewsToShowOnScreen_Float = 0.0f;
    onMutation();
    this.initialPrefetchItemCount_Int = initialPrefetchItemCount;
    return this;
  }

  public int initialPrefetchItemCountInt() {
    return initialPrefetchItemCount_Int;
  }

  /**
   * <i>Optional</i>: Default value is 0
   *
   * @see Carousel#setPaddingRes(int)
   */
  public CarouselNoSnapModel_ paddingRes(@DimenRes int paddingRes) {
    assignedAttributes_epoxyGeneratedModel.set(3);
    assignedAttributes_epoxyGeneratedModel.clear(4);
    this.paddingDp_Int = Carousel.NO_VALUE_SET;
    assignedAttributes_epoxyGeneratedModel.clear(5);
    this.padding_Padding = (Carousel.Padding) null;
    onMutation();
    this.paddingRes_Int = paddingRes;
    return this;
  }

  @DimenRes
  public int paddingResInt() {
    return paddingRes_Int;
  }

  /**
   * <i>Optional</i>: Default value is <b>{@value Carousel#NO_VALUE_SET}</b>
   *
   * @see Carousel#setPaddingDp(int)
   */
  public CarouselNoSnapModel_ paddingDp(@Dimension(unit = 0) int paddingDp) {
    assignedAttributes_epoxyGeneratedModel.set(4);
    assignedAttributes_epoxyGeneratedModel.clear(3);
    this.paddingRes_Int = 0;
    assignedAttributes_epoxyGeneratedModel.clear(5);
    this.padding_Padding = (Carousel.Padding) null;
    onMutation();
    this.paddingDp_Int = paddingDp;
    return this;
  }

  @Dimension(
      unit = 0
  )
  public int paddingDpInt() {
    return paddingDp_Int;
  }

  /**
   * <i>Optional</i>: Default value is (Carousel.Padding) null
   *
   * @see Carousel#setPadding(Carousel.Padding)
   */
  public CarouselNoSnapModel_ padding(@Nullable Carousel.Padding padding) {
    assignedAttributes_epoxyGeneratedModel.set(5);
    assignedAttributes_epoxyGeneratedModel.clear(3);
    this.paddingRes_Int = 0;
    assignedAttributes_epoxyGeneratedModel.clear(4);
    this.paddingDp_Int = Carousel.NO_VALUE_SET;
    onMutation();
    this.padding_Padding = padding;
    return this;
  }

  @Nullable
  public Carousel.Padding paddingPadding() {
    return padding_Padding;
  }

  /**
   * <i>Required.</i>
   *
   * @see Carousel#setModels(List<? extends EpoxyModel<?>>)
   */
  public CarouselNoSnapModel_ models(@NonNull List<? extends EpoxyModel<?>> models) {
    if (models == null) {
      throw new IllegalArgumentException("models cannot be null");
    }
    assignedAttributes_epoxyGeneratedModel.set(6);
    onMutation();
    this.models_List = models;
    return this;
  }

  @NonNull
  public List<? extends EpoxyModel<?>> models() {
    return models_List;
  }

  @Override
  public CarouselNoSnapModel_ id(long id) {
    super.id(id);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ id(@Nullable Number... ids) {
    super.id(ids);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ id(long id1, long id2) {
    super.id(id1, id2);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ id(@Nullable CharSequence key) {
    super.id(key);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys) {
    super.id(key, otherKeys);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ id(@Nullable CharSequence key, long id) {
    super.id(key, id);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ layout(@LayoutRes int layoutRes) {
    throw new UnsupportedOperationException("Layout resources are unsupported with programmatic views.");
  }

  @Override
  public CarouselNoSnapModel_ spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback) {
    super.spanSizeOverride(spanSizeCallback);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ show() {
    super.show();
    return this;
  }

  @Override
  public CarouselNoSnapModel_ show(boolean show) {
    super.show(show);
    return this;
  }

  @Override
  public CarouselNoSnapModel_ hide() {
    super.hide();
    return this;
  }

  @Override
  @LayoutRes
  protected int getDefaultLayout() {
    throw new UnsupportedOperationException("Layout resources are unsupported for views created programmatically.");
  }

  @Override
  public CarouselNoSnapModel_ reset() {
    onModelBoundListener_epoxyGeneratedModel = null;
    onModelUnboundListener_epoxyGeneratedModel = null;
    onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
    onModelVisibilityChangedListener_epoxyGeneratedModel = null;
    assignedAttributes_epoxyGeneratedModel.clear();
    this.hasFixedSize_Boolean = false;
    this.numViewsToShowOnScreen_Float = 0.0f;
    this.initialPrefetchItemCount_Int = 0;
    this.paddingRes_Int = 0;
    this.paddingDp_Int = Carousel.NO_VALUE_SET;
    this.padding_Padding = (Carousel.Padding) null;
    this.models_List = null;
    super.reset();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CarouselNoSnapModel_)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    CarouselNoSnapModel_ that = (CarouselNoSnapModel_) o;
    if (((onModelBoundListener_epoxyGeneratedModel == null) != (that.onModelBoundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelUnboundListener_epoxyGeneratedModel == null) != (that.onModelUnboundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if ((hasFixedSize_Boolean != that.hasFixedSize_Boolean)) {
      return false;
    }
    if ((Float.compare(that.numViewsToShowOnScreen_Float, numViewsToShowOnScreen_Float) != 0)) {
      return false;
    }
    if ((initialPrefetchItemCount_Int != that.initialPrefetchItemCount_Int)) {
      return false;
    }
    if ((paddingRes_Int != that.paddingRes_Int)) {
      return false;
    }
    if ((paddingDp_Int != that.paddingDp_Int)) {
      return false;
    }
    if ((padding_Padding != null ? !padding_Padding.equals(that.padding_Padding) : that.padding_Padding != null)) {
      return false;
    }
    if ((models_List != null ? !models_List.equals(that.models_List) : that.models_List != null)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int _result = super.hashCode();
    _result = 31 * _result + (onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    _result = 31 * _result + (hasFixedSize_Boolean ? 1 : 0);
    _result = 31 * _result + (numViewsToShowOnScreen_Float != +0.0f ? Float.floatToIntBits(numViewsToShowOnScreen_Float) : 0);
    _result = 31 * _result + initialPrefetchItemCount_Int;
    _result = 31 * _result + paddingRes_Int;
    _result = 31 * _result + paddingDp_Int;
    _result = 31 * _result + (padding_Padding != null ? padding_Padding.hashCode() : 0);
    _result = 31 * _result + (models_List != null ? models_List.hashCode() : 0);
    return _result;
  }

  @Override
  public String toString() {
    return "CarouselNoSnapModel_{" +
        "hasFixedSize_Boolean=" + hasFixedSize_Boolean +
        ", numViewsToShowOnScreen_Float=" + numViewsToShowOnScreen_Float +
        ", initialPrefetchItemCount_Int=" + initialPrefetchItemCount_Int +
        ", paddingRes_Int=" + paddingRes_Int +
        ", paddingDp_Int=" + paddingDp_Int +
        ", padding_Padding=" + padding_Padding +
        ", models_List=" + models_List +
        "}" + super.toString();
  }

  @Override
  public boolean shouldSaveViewState() {
    return true;
  }

  @Override
  public int getSpanSize(int totalSpanCount, int position, int itemCount) {
    return totalSpanCount;
  }
}
