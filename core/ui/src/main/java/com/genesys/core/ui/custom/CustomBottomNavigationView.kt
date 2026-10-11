package com.genesys.core.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.genesys.core.ui.R
import java.util.LinkedHashMap

/**
 * Custom bottom navigation view supporting tabs and a center action button space.
 */
class CustomBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    /**
     * Callback triggered when a navigation item is selected.
     */
    var onItemClickListener: ((ItemId) -> Unit)? = null

    /**
     * Callback triggered when an already selected item is reselected.
     */
    var onItemReselectedListener: ((ItemId) -> Unit)? = null

    /**
     * Destination item identifiers for the navigation bar.
     */
    enum class ItemId {
        TEMPLATES, COMPONENT, INBOX, SETTINGS
    }

    private val items = LinkedHashMap<ItemId, NavigationItemView>()
    private val itemImages = LinkedHashMap<ItemId, ImageView>()
    private val itemTexts = LinkedHashMap<ItemId, TextView>()

    private var currentSelectedId: ItemId = ItemId.TEMPLATES

    var isDrawCustomBackground: Boolean = false

    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.color_bg_container)
        style = Paint.Style.FILL
    }

    private val dividerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.color_neo_border)
        strokeWidth = 1.dp.toFloat()
        style = Paint.Style.STROKE
    }

    private val path = Path()

    private val Int.dp: Int
        get() = (this * resources.displayMetrics.density).toInt()

    private val Float.dp: Float
        get() = this * resources.displayMetrics.density

    private val shadowHeight: Int
        get() = SHADOW_HEIGHT_DP.dp

    init {
        setWillNotDraw(false)

        bgPaint.setShadowLayer(
            SHADOW_SIZE_DP.dp,
            SHADOW_OFFSET_X_DP.dp,
            SHADOW_OFFSET_Y_DP.dp,
            SHADOW_COLOR
        )
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)

        addItem(ItemId.TEMPLATES, R.drawable.ic_nav_templates, R.string.nav_pokedex)
        addItem(ItemId.COMPONENT, R.drawable.ic_nav_components, R.string.nav_feature1)
        addItem(ItemId.INBOX, R.drawable.ic_nav_inbox, R.string.nav_feature2)
        addItem(ItemId.SETTINGS, R.drawable.ic_nav_settings, R.string.nav_feature3)

        selectItem(ItemId.TEMPLATES)
    }

    private fun addItem(
        itemId: ItemId,
        @DrawableRes iconRes: Int,
        @StringRes textRes: Int
    ) {
        val imageView = ImageView(context).apply {
            val size = ICON_SIZE_DP.dp
            layoutParams = LayoutParams(size, size)
            setImageResource(iconRes)
            imageTintList = ContextCompat.getColorStateList(context, R.color.selector_nav_item_tint)
            isDuplicateParentStateEnabled = true
        }

        val textView = TextView(context).apply {
            gravity = Gravity.CENTER
            setText(textRes)
            textSize = TEXT_SIZE_SP
            setTextColor(ContextCompat.getColorStateList(context, R.color.selector_nav_item_tint))
            isDuplicateParentStateEnabled = true
        }

        val itemView = NavigationItemView(context, itemId, imageView, textView).apply {
            setOnClickListener {
                if (currentSelectedId == itemId) {
                    onItemReselectedListener?.invoke(itemId)
                } else {
                    selectItem(itemId)
                    onItemClickListener?.invoke(itemId)
                }
            }
        }

        addView(itemView)

        items[itemId] = itemView
        itemImages[itemId] = imageView
        itemTexts[itemId] = textView
    }

    /**
     * Selects a tab and synchronizes state across child items.
     */
    fun selectItem(itemId: ItemId) {
        currentSelectedId = itemId
        items.forEach { (id, view) ->
            view.isSelected = (id == itemId)
        }
    }

    /**
     * Returns the currently selected item.
     */
    fun getSelectedItem(): ItemId = currentSelectedId

    private fun getSlotIndex(itemId: ItemId): Int {
        return when (itemId) {
            ItemId.TEMPLATES -> 0
            ItemId.COMPONENT -> 1
            ItemId.INBOX -> 3
            ItemId.SETTINGS -> 4
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (isDrawCustomBackground) {
            path.reset()
            path.addRect(
                0f,
                shadowHeight.toFloat(),
                w.toFloat(),
                h.toFloat(),
                Path.Direction.CW
            )
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (isDrawCustomBackground) {
            canvas.drawPath(path, bgPaint)
            val topY = (paddingTop + shadowHeight).toFloat()
            canvas.drawLine(0f, topY, width.toFloat(), topY, dividerPaint)
        }
        super.onDraw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val extraShadow = if (isDrawCustomBackground) shadowHeight else 0
        val targetChildHeight = if (heightMode == MeasureSpec.EXACTLY) {
            maxOf(0, heightSize - paddingTop - paddingBottom - extraShadow)
        } else {
            0
        }

        val slotCount = 5
        var maxChildHeight = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child.visibility != GONE && child is NavigationItemView) {
                val slotIndex = getSlotIndex(child.itemId)
                val left = (slotIndex * widthSize) / slotCount
                val right = ((slotIndex + 1) * widthSize) / slotCount
                val childWidth = right - left
                val childWidthSpec = MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY)
                val childHeightSpec = if (heightMode == MeasureSpec.EXACTLY) {
                    MeasureSpec.makeMeasureSpec(targetChildHeight, MeasureSpec.EXACTLY)
                } else {
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
                }
                child.measure(childWidthSpec, childHeightSpec)
                maxChildHeight = maxOf(maxChildHeight, child.measuredHeight)
            }
        }

        val totalHeight = if (heightMode == MeasureSpec.EXACTLY) {
            heightSize
        } else {
            maxChildHeight + paddingTop + paddingBottom + extraShadow
        }

        setMeasuredDimension(
            resolveSizeAndState(widthSize, widthMeasureSpec, 0),
            resolveSizeAndState(totalHeight, heightMeasureSpec, 0)
        )
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val parentWidth = r - l
        val parentHeight = b - t
        val extraShadow = if (isDrawCustomBackground) shadowHeight else 0
        val childTop = paddingTop + extraShadow
        val childBottom = parentHeight - paddingBottom
        val slotCount = 5

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child.visibility != GONE && child is NavigationItemView) {
                val slotIndex = getSlotIndex(child.itemId)
                val left = (slotIndex * parentWidth) / slotCount
                val right = ((slotIndex + 1) * parentWidth) / slotCount
                child.layout(left, childTop, right, childBottom)
            }
        }
    }

    private class NavigationItemView(
        context: Context,
        val itemId: ItemId,
        val imageView: ImageView,
        val textView: TextView
    ) : FrameLayout(context) {

        private val Int.dp: Int
            get() = (this * resources.displayMetrics.density).toInt()

        val indicatorView = View(context).apply {
            val drawable = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = INDICATOR_RADIUS_DP * resources.displayMetrics.density
                setColor(ContextCompat.getColor(context, R.color.color_neo_selected_orange))
            }
            background = drawable
            visibility = View.INVISIBLE
        }

        init {
            addView(indicatorView)
            addView(imageView)
            addView(textView)

            val outValue = TypedValue()
            context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true)
            setBackgroundResource(outValue.resourceId)

            isClickable = true
            isFocusable = true
        }

        override fun setSelected(selected: Boolean) {
            super.setSelected(selected)
            indicatorView.visibility = if (selected) View.VISIBLE else View.INVISIBLE
        }

        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            val totalWidth = MeasureSpec.getSize(widthMeasureSpec)

            val indicatorWidth = minOf(INDICATOR_WIDTH_DP.dp, totalWidth)
            val indicatorHeight = INDICATOR_HEIGHT_DP.dp
            indicatorView.measure(
                MeasureSpec.makeMeasureSpec(indicatorWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(indicatorHeight, MeasureSpec.EXACTLY)
            )

            val imageSize = ICON_SIZE_DP.dp
            val imageWidthSpec = MeasureSpec.makeMeasureSpec(imageSize, MeasureSpec.EXACTLY)
            val imageHeightSpec = MeasureSpec.makeMeasureSpec(imageSize, MeasureSpec.EXACTLY)
            imageView.measure(imageWidthSpec, imageHeightSpec)

            val textWidthSpec = if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.UNSPECIFIED) {
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            } else {
                MeasureSpec.makeMeasureSpec(totalWidth, MeasureSpec.AT_MOST)
            }
            val textHeightSpec = if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.UNSPECIFIED) {
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            } else {
                MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.AT_MOST)
            }
            textView.measure(textWidthSpec, textHeightSpec)

            val totalHeight = if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
                MeasureSpec.getSize(heightMeasureSpec)
            } else {
                val paddingTop = ITEM_PADDING_TOP_DP.dp
                val paddingBottom = ITEM_PADDING_BOTTOM_DP.dp
                val textTopMargin = ITEM_TEXT_TOP_MARGIN_DP.dp
                paddingTop + imageSize + textTopMargin + textView.measuredHeight + paddingBottom + indicatorHeight
            }

            setMeasuredDimension(
                resolveSizeAndState(totalWidth, widthMeasureSpec, 0),
                resolveSizeAndState(totalHeight, heightMeasureSpec, 0)
            )
        }

        override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
            val width = r - l
            val height = b - t

            val indicatorWidth = indicatorView.measuredWidth
            val indicatorHeight = indicatorView.measuredHeight
            val indicatorLeft = (width - indicatorWidth) / 2
            indicatorView.layout(indicatorLeft, 0, indicatorLeft + indicatorWidth, indicatorHeight)

            val textMarginTop = ITEM_TEXT_TOP_MARGIN_DP.dp
            val contentHeight = imageView.measuredHeight + textMarginTop + textView.measuredHeight
            val availableHeight = height - indicatorHeight
            val contentTop = indicatorHeight + maxOf(0, (availableHeight - contentHeight) / 2)

            val imageLeft = (width - imageView.measuredWidth) / 2
            val imageTop = contentTop
            val imageRight = imageLeft + imageView.measuredWidth
            val imageBottom = imageTop + imageView.measuredHeight
            imageView.layout(imageLeft, imageTop, imageRight, imageBottom)

            val textLeft = (width - textView.measuredWidth) / 2
            val textTop = imageBottom + textMarginTop
            val textRight = textLeft + textView.measuredWidth
            val textBottom = textTop + textView.measuredHeight
            textView.layout(textLeft, textTop, textRight, textBottom)
        }
    }

    companion object {
        private const val SHADOW_COLOR = 0x1A000000
        private const val SHADOW_OFFSET_X_DP = 0f
        private const val SHADOW_OFFSET_Y_DP = -2f
        private const val SHADOW_SIZE_DP = 4f
        private const val SHADOW_HEIGHT_DP = 6

        private const val INDICATOR_WIDTH_DP = 32
        private const val INDICATOR_HEIGHT_DP = 3
        private const val INDICATOR_RADIUS_DP = 2f

        private const val ICON_SIZE_DP = 24
        private const val TEXT_SIZE_SP = 11f

        private const val ITEM_PADDING_TOP_DP = 6
        private const val ITEM_PADDING_BOTTOM_DP = 6
        private const val ITEM_TEXT_TOP_MARGIN_DP = 2
    }
}
