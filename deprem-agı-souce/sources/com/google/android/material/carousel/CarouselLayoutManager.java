package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_START = 0;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    private int carouselAlignment;
    @NonNull
    private CarouselStrategy carouselStrategy;
    private int currentEstimatedPosition;
    private int currentFillStartPosition;
    @Nullable
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public KeylineStateList keylineStateList;
    @Nullable
    private Map<Integer, KeylineState> keylineStatePositionMap;
    private int lastItemCount;
    @VisibleForTesting
    int maxScroll;
    @VisibleForTesting
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    private final View.OnLayoutChangeListener recyclerViewSizeChangeListener;
    @VisibleForTesting
    int scrollOffset;

    private static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        ChildCalculations(View view, float f5, float f6, KeylineRange keylineRange) {
            this.child = view;
            this.center = f5;
            this.offsetCenter = f6;
            this.range = keylineRange;
        }
    }

    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines = DesugarCollections.unmodifiableList(new ArrayList());
        private final Paint linePaint;

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.linePaint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline next : this.keylines) {
                this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, next.mask));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    canvas.drawLine(next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentTop(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentBottom(), this.linePaint);
                } else {
                    canvas.drawLine((float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentLeft(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentRight(), next.locOffset, this.linePaint);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setKeylines(List<KeylineState.Keyline> list) {
            this.keylines = DesugarCollections.unmodifiableList(list);
        }
    }

    private static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            boolean z4;
            if (keyline.loc <= keyline2.loc) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            this.leftOrTop = keyline;
            this.rightOrBottom = keyline2;
        }
    }

    private static class LayoutDirection {
        private static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;

        private LayoutDirection() {
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    private void addAndLayoutView(View view, int i5, ChildCalculations childCalculations) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(view, i5);
        measureChildWithMargins(view, 0, 0);
        float f5 = childCalculations.offsetCenter;
        this.orientationHelper.layoutDecoratedWithMargins(view, (int) (f5 - itemSize), (int) (f5 + itemSize));
        updateChildMaskForLocation(view, childCalculations.center, childCalculations.range);
    }

    private float addEnd(float f5, float f6) {
        if (isLayoutRtl()) {
            return f5 - f6;
        }
        return f5 + f6;
    }

    private float addStart(float f5, float f6) {
        if (isLayoutRtl()) {
            return f5 + f6;
        }
        return f5 - f6;
    }

    private void addViewAtPosition(@NonNull RecyclerView.Recycler recycler, int i5, int i6) {
        if (i5 >= 0 && i5 < getItemCount()) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill(i5), i5);
            addAndLayoutView(makeChildCalculations.child, i6, makeChildCalculations);
        }
    }

    private void addViewsEnd(RecyclerView.Recycler recycler, RecyclerView.State state, int i5) {
        float calculateChildStartForFill = calculateChildStartForFill(i5);
        while (i5 < state.getItemCount()) {
            float addEnd = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize() / 2.0f);
            KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(addEnd, surroundingKeylineRange);
            if (!isLocOffsetOutOfFillBoundsEnd(calculateChildOffsetCenterForLocation, surroundingKeylineRange)) {
                calculateChildStartForFill = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsStart(calculateChildOffsetCenterForLocation, surroundingKeylineRange)) {
                    View viewForPosition = recycler.getViewForPosition(i5);
                    addAndLayoutView(viewForPosition, -1, new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation, surroundingKeylineRange));
                }
                i5++;
            } else {
                return;
            }
        }
    }

    private void addViewsStart(RecyclerView.Recycler recycler, int i5) {
        float calculateChildStartForFill = calculateChildStartForFill(i5);
        while (i5 >= 0) {
            float addEnd = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize() / 2.0f);
            KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(addEnd, surroundingKeylineRange);
            if (!isLocOffsetOutOfFillBoundsStart(calculateChildOffsetCenterForLocation, surroundingKeylineRange)) {
                calculateChildStartForFill = addStart(calculateChildStartForFill, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsEnd(calculateChildOffsetCenterForLocation, surroundingKeylineRange)) {
                    View viewForPosition = recycler.getViewForPosition(i5);
                    addAndLayoutView(viewForPosition, 0, new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation, surroundingKeylineRange));
                }
                i5--;
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void b(CarouselLayoutManager carouselLayoutManager, View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        carouselLayoutManager.getClass();
        if (i7 - i5 != i11 - i9 || i8 - i6 != i12 - i10) {
            view.post(new a(carouselLayoutManager));
        }
    }

    private float calculateChildOffsetCenterForLocation(float f5, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f6 = keyline.locOffset;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        float lerp = AnimationUtils.lerp(f6, keyline2.locOffset, keyline.loc, keyline2.loc, f5);
        if (keylineRange.rightOrBottom != this.currentKeylineState.getFirstKeyline() && keylineRange.leftOrTop != this.currentKeylineState.getLastKeyline()) {
            return lerp;
        }
        KeylineState.Keyline keyline3 = keylineRange.rightOrBottom;
        return lerp + ((f5 - keyline3.loc) * (1.0f - keyline3.mask));
    }

    private float calculateChildStartForFill(int i5) {
        return addEnd((float) (getParentStart() - this.scrollOffset), this.currentKeylineState.getItemSize() * ((float) i5));
    }

    private int calculateEndScroll(RecyclerView.State state, KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        float f5;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getStartState();
        } else {
            keylineState = keylineStateList2.getEndState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getFirstFocalKeyline();
        } else {
            keyline = keylineState.getLastFocalKeyline();
        }
        int i5 = 1;
        float itemCount = ((float) (state.getItemCount() - 1)) * keylineState.getItemSize();
        if (isLayoutRtl) {
            f5 = -1.0f;
        } else {
            f5 = 1.0f;
        }
        float parentStart = (itemCount * f5) - (keyline.loc - ((float) getParentStart()));
        if (isLayoutRtl) {
            i5 = -1;
        }
        int i6 = (int) (parentStart + ((((float) i5) * keyline.maskedItemSize) / 2.0f));
        if (isLayoutRtl) {
            return Math.min(0, i6);
        }
        return Math.max(0, i6);
    }

    private static int calculateShouldScrollBy(int i5, int i6, int i7, int i8) {
        int i9 = i6 + i5;
        return i9 < i7 ? i7 - i6 : i9 > i8 ? i8 - i6 : i5;
    }

    private int calculateStartScroll(@NonNull KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getEndState();
        } else {
            keylineState = keylineStateList2.getStartState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getLastFocalKeyline();
        } else {
            keyline = keylineState.getFirstFocalKeyline();
        }
        return (int) (((float) getParentStart()) - addStart(keyline.loc, keylineState.getItemSize() / 2.0f));
    }

    private int convertFocusDirectionToLayoutDirection(int i5) {
        int orientation = getOrientation();
        if (i5 == 1) {
            return -1;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        Log.d(TAG, "Unknown focus request:" + i5);
                        return Integer.MIN_VALUE;
                    } else if (orientation == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (orientation != 0) {
                    return Integer.MIN_VALUE;
                } else {
                    if (isLayoutRtl()) {
                        return -1;
                    }
                    return 1;
                }
            } else if (orientation == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (orientation != 0) {
            return Integer.MIN_VALUE;
        } else {
            if (isLayoutRtl()) {
                return 1;
            }
            return -1;
        }
    }

    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        removeAndRecycleOutOfBoundsViews(recycler);
        if (getChildCount() == 0) {
            addViewsStart(recycler, this.currentFillStartPosition - 1);
            addViewsEnd(recycler, state, this.currentFillStartPosition);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(recycler, position - 1);
            addViewsEnd(recycler, state, position2 + 1);
        }
        validateChildOrderIfDebugging();
    }

    private View getChildClosestToEnd() {
        int i5;
        if (isLayoutRtl()) {
            i5 = 0;
        } else {
            i5 = getChildCount() - 1;
        }
        return getChildAt(i5);
    }

    private View getChildClosestToStart() {
        int i5;
        if (isLayoutRtl()) {
            i5 = getChildCount() - 1;
        } else {
            i5 = 0;
        }
        return getChildAt(i5);
    }

    private int getContainerSize() {
        if (isHorizontal()) {
            return getContainerWidth();
        }
        return getContainerHeight();
    }

    private float getDecoratedCenterWithMargins(View view) {
        int centerY;
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        if (isHorizontal()) {
            centerY = rect.centerX();
        } else {
            centerY = rect.centerY();
        }
        return (float) centerY;
    }

    private int getItemMargins() {
        int i5;
        int i6;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.orientationHelper.orientation == 0) {
            i5 = layoutParams.leftMargin;
            i6 = layoutParams.rightMargin;
        } else {
            i5 = layoutParams.topMargin;
            i6 = layoutParams.bottomMargin;
        }
        return i5 + i6;
    }

    private KeylineState getKeylineStartingState(KeylineStateList keylineStateList2) {
        if (isLayoutRtl()) {
            return keylineStateList2.getEndState();
        }
        return keylineStateList2.getStartState();
    }

    private KeylineState getKeylineStateForPosition(int i5) {
        KeylineState keylineState;
        Map<Integer, KeylineState> map = this.keylineStatePositionMap;
        if (map == null || (keylineState = map.get(Integer.valueOf(MathUtils.clamp(i5, 0, Math.max(0, getItemCount() - 1))))) == null) {
            return this.keylineStateList.getDefaultState();
        }
        return keylineState;
    }

    private int getLeftOrTopPaddingForKeylineShift() {
        if (getClipToPadding()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingTop();
        }
        return getPaddingLeft();
    }

    private float getMaskedItemSizeForLocOffset(float f5, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f6 = keyline.maskedItemSize;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        return AnimationUtils.lerp(f6, keyline2.maskedItemSize, keyline.locOffset, keyline2.locOffset, f5);
    }

    /* access modifiers changed from: private */
    public int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    /* access modifiers changed from: private */
    public int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    /* access modifiers changed from: private */
    public int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    /* access modifiers changed from: private */
    public int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private int getRightOrBottomPaddingForKeylineShift() {
        if (getClipToPadding()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingBottom();
        }
        return getPaddingRight();
    }

    private int getScrollOffsetForPosition(int i5, KeylineState keylineState) {
        if (isLayoutRtl()) {
            return (int) (((((float) getContainerSize()) - keylineState.getLastFocalKeyline().loc) - (((float) i5) * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) (((((float) i5) * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc) + (keylineState.getItemSize() / 2.0f));
    }

    private int getSmallestScrollOffsetToFocalKeyline(int i5, @NonNull KeylineState keylineState) {
        int i6;
        int i7 = Integer.MAX_VALUE;
        for (KeylineState.Keyline next : keylineState.getFocalKeylines()) {
            float itemSize = (((float) i5) * keylineState.getItemSize()) + (keylineState.getItemSize() / 2.0f);
            if (isLayoutRtl()) {
                i6 = (int) ((((float) getContainerSize()) - next.loc) - itemSize);
            } else {
                i6 = (int) (itemSize - next.loc);
            }
            int i8 = i6 - this.scrollOffset;
            if (Math.abs(i7) > Math.abs(i8)) {
                i7 = i8;
            }
        }
        return i7;
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> list, float f5, boolean z4) {
        float f6;
        float f7 = Float.MAX_VALUE;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        float f8 = -3.4028235E38f;
        float f9 = Float.MAX_VALUE;
        float f10 = Float.MAX_VALUE;
        for (int i9 = 0; i9 < list.size(); i9++) {
            KeylineState.Keyline keyline = list.get(i9);
            if (z4) {
                f6 = keyline.locOffset;
            } else {
                f6 = keyline.loc;
            }
            float abs = Math.abs(f6 - f5);
            if (f6 <= f5 && abs <= f7) {
                i5 = i9;
                f7 = abs;
            }
            if (f6 > f5 && abs <= f9) {
                i7 = i9;
                f9 = abs;
            }
            if (f6 <= f10) {
                i6 = i9;
                f10 = f6;
            }
            if (f6 > f8) {
                i8 = i9;
                f8 = f6;
            }
        }
        if (i5 == -1) {
            i5 = i6;
        }
        if (i7 == -1) {
            i7 = i8;
        }
        return new KeylineRange(list.get(i5), list.get(i7));
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float f5, KeylineRange keylineRange) {
        float addStart = addStart(f5, getMaskedItemSizeForLocOffset(f5, keylineRange) / 2.0f);
        if (isLayoutRtl()) {
            if (addStart < 0.0f) {
                return true;
            }
            return false;
        } else if (addStart > ((float) getContainerSize())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float f5, KeylineRange keylineRange) {
        float addEnd = addEnd(f5, getMaskedItemSizeForLocOffset(f5, keylineRange) / 2.0f);
        if (isLayoutRtl()) {
            if (addEnd > ((float) getContainerSize())) {
                return true;
            }
            return false;
        } else if (addEnd < 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "internal representation of views on the screen");
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                float decoratedCenterWithMargins = getDecoratedCenterWithMargins(childAt);
                Log.d(TAG, "item position " + getPosition(childAt) + ", center:" + decoratedCenterWithMargins + ", child index:" + i5);
            }
            Log.d(TAG, "==============");
        }
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler recycler, float f5, int i5) {
        View viewForPosition = recycler.getViewForPosition(i5);
        measureChildWithMargins(viewForPosition, 0, 0);
        float addEnd = addEnd(f5, this.currentKeylineState.getItemSize() / 2.0f);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        return new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation(addEnd, surroundingKeylineRange), surroundingKeylineRange);
    }

    private float offsetChild(View view, float f5, float f6, Rect rect) {
        float addEnd = addEnd(f5, f6);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(addEnd, surroundingKeylineRange);
        super.getDecoratedBoundsWithMargins(view, rect);
        updateChildMaskForLocation(view, addEnd, surroundingKeylineRange);
        this.orientationHelper.offsetChild(view, rect, f6, calculateChildOffsetCenterForLocation);
        return calculateChildOffsetCenterForLocation;
    }

    private void recalculateKeylineStateList(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        KeylineState onFirstChildMeasuredWithMargins = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, viewForPosition);
        if (isLayoutRtl()) {
            onFirstChildMeasuredWithMargins = KeylineState.reverse(onFirstChildMeasuredWithMargins, getContainerSize());
        }
        this.keylineStateList = KeylineStateList.from(this, onFirstChildMeasuredWithMargins, (float) getItemMargins(), (float) getLeftOrTopPaddingForKeylineShift(), (float) getRightOrBottomPaddingForKeylineShift(), this.carouselStrategy.getStrategyType());
    }

    /* access modifiers changed from: private */
    public void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float decoratedCenterWithMargins = getDecoratedCenterWithMargins(childAt);
            if (!isLocOffsetOutOfFillBoundsStart(decoratedCenterWithMargins, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterWithMargins, true))) {
                break;
            }
            removeAndRecycleView(childAt, recycler);
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float decoratedCenterWithMargins2 = getDecoratedCenterWithMargins(childAt2);
            if (isLocOffsetOutOfFillBoundsEnd(decoratedCenterWithMargins2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterWithMargins2, true))) {
                removeAndRecycleView(childAt2, recycler);
            } else {
                return;
            }
        }
    }

    private void scrollBy(RecyclerView recyclerView, int i5) {
        if (isHorizontal()) {
            recyclerView.scrollBy(i5, 0);
        } else {
            recyclerView.scrollBy(0, i5);
        }
    }

    private void setCarouselAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            setCarouselAlignment(obtainStyledAttributes.getInt(R.styleable.Carousel_carousel_alignment, 0));
            setOrientation(obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            obtainStyledAttributes.recycle();
        }
    }

    private void updateChildMaskForLocation(View view, float f5, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.leftOrTop;
            float f6 = keyline.mask;
            KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
            float lerp = AnimationUtils.lerp(f6, keyline2.mask, keyline.loc, keyline2.loc, f5);
            float height = (float) view.getHeight();
            float width = (float) view.getWidth();
            float lerp2 = AnimationUtils.lerp(0.0f, width / 2.0f, 0.0f, 1.0f, lerp);
            RectF maskRect = this.orientationHelper.getMaskRect(height, width, AnimationUtils.lerp(0.0f, height / 2.0f, 0.0f, 1.0f, lerp), lerp2);
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(f5, keylineRange);
            float height2 = (maskRect.height() / 2.0f) + calculateChildOffsetCenterForLocation;
            RectF rectF = new RectF(calculateChildOffsetCenterForLocation - (maskRect.width() / 2.0f), calculateChildOffsetCenterForLocation - (maskRect.height() / 2.0f), calculateChildOffsetCenterForLocation + (maskRect.width() / 2.0f), height2);
            RectF rectF2 = new RectF((float) getParentLeft(), (float) getParentTop(), (float) getParentRight(), (float) getParentBottom());
            if (this.carouselStrategy.getStrategyType() == CarouselStrategy.StrategyType.CONTAINED) {
                this.orientationHelper.containMaskWithinBounds(maskRect, rectF, rectF2);
            }
            this.orientationHelper.moveMaskOnEdgeOutsideBounds(maskRect, rectF, rectF2);
            ((Maskable) view).setMaskRectF(maskRect);
        }
    }

    private void updateCurrentKeylineStateForScrollOffset(@NonNull KeylineStateList keylineStateList2) {
        int i5 = this.maxScroll;
        int i6 = this.minScroll;
        if (i5 <= i6) {
            this.currentKeylineState = getKeylineStartingState(keylineStateList2);
        } else {
            this.currentKeylineState = keylineStateList2.getShiftedState((float) this.scrollOffset, (float) i6, (float) i5);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private void updateItemCount() {
        int itemCount = getItemCount();
        int i5 = this.lastItemCount;
        if (itemCount != i5 && this.keylineStateList != null) {
            if (this.carouselStrategy.shouldRefreshKeylineState(this, i5)) {
                refreshKeylineState();
            }
            this.lastItemCount = itemCount;
        }
    }

    private void validateChildOrderIfDebugging() {
        if (this.isDebuggingEnabled && getChildCount() >= 1) {
            int i5 = 0;
            while (i5 < getChildCount() - 1) {
                int position = getPosition(getChildAt(i5));
                int i6 = i5 + 1;
                int position2 = getPosition(getChildAt(i6));
                if (position <= position2) {
                    i5 = i6;
                } else {
                    logChildrenIfDebugging();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i5 + "] had adapter position [" + position + "] and child at index [" + i6 + "] had adapter position [" + position2 + "].");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int calculateScrollDeltaToMakePositionVisible(int i5) {
        return (int) (((float) this.scrollOffset) - ((float) getScrollOffsetForPosition(i5, getKeylineStateForPosition(i5))));
    }

    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getWidth()) * (this.keylineStateList.getDefaultState().getItemSize() / ((float) computeHorizontalScrollRange(state))));
    }

    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Nullable
    public PointF computeScrollVectorForPosition(int i5) {
        if (this.keylineStateList == null) {
            return null;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i5, getKeylineStateForPosition(i5));
        if (isHorizontal()) {
            return new PointF((float) offsetToScrollToPosition, 0.0f);
        }
        return new PointF(0.0f, (float) offsetToScrollToPosition);
    }

    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getHeight()) * (this.keylineStateList.getDefaultState().getItemSize() / ((float) computeVerticalScrollRange(state))));
    }

    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getCarouselAlignment() {
        return this.carouselAlignment;
    }

    public int getContainerHeight() {
        return getHeight();
    }

    public int getContainerWidth() {
        return getWidth();
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        float f5;
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = (float) rect.centerY();
        if (isHorizontal()) {
            centerY = (float) rect.centerX();
        }
        float maskedItemSizeForLocOffset = getMaskedItemSizeForLocOffset(centerY, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), centerY, true));
        float f6 = 0.0f;
        if (isHorizontal()) {
            f5 = (((float) rect.width()) - maskedItemSizeForLocOffset) / 2.0f;
        } else {
            f5 = 0.0f;
        }
        if (!isHorizontal()) {
            f6 = (((float) rect.height()) - maskedItemSizeForLocOffset) / 2.0f;
        }
        rect.set((int) (((float) rect.left) + f5), (int) (((float) rect.top) + f6), (int) (((float) rect.right) - f5), (int) (((float) rect.bottom) - f6));
    }

    /* access modifiers changed from: package-private */
    public int getOffsetToScrollToPosition(int i5, @NonNull KeylineState keylineState) {
        return getScrollOffsetForPosition(i5, keylineState) - this.scrollOffset;
    }

    /* access modifiers changed from: package-private */
    public int getOffsetToScrollToPositionForSnap(int i5, boolean z4) {
        int i6;
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i5, this.keylineStateList.getShiftedState((float) this.scrollOffset, (float) this.minScroll, (float) this.maxScroll, true));
        if (this.keylineStatePositionMap != null) {
            i6 = getOffsetToScrollToPosition(i5, getKeylineStateForPosition(i5));
        } else {
            i6 = offsetToScrollToPosition;
        }
        if (!z4 || Math.abs(i6) >= Math.abs(offsetToScrollToPosition)) {
            return offsetToScrollToPosition;
        }
        return i6;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isHorizontal() {
        if (this.orientationHelper.orientation == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRtl() {
        if (!isHorizontal() || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void measureChildWithMargins(@NonNull View view, int i5, int i6) {
        float f5;
        float f6;
        if (view instanceof Maskable) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            calculateItemDecorationsForChild(view, rect);
            int i7 = i5 + rect.left + rect.right;
            int i8 = i6 + rect.top + rect.bottom;
            KeylineStateList keylineStateList2 = this.keylineStateList;
            if (keylineStateList2 == null || this.orientationHelper.orientation != 0) {
                f5 = (float) layoutParams.width;
            } else {
                f5 = keylineStateList2.getDefaultState().getItemSize();
            }
            KeylineStateList keylineStateList3 = this.keylineStateList;
            if (keylineStateList3 == null || this.orientationHelper.orientation != 1) {
                f6 = (float) layoutParams.height;
            } else {
                f6 = keylineStateList3.getDefaultState().getItemSize();
            }
            view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i7, (int) f5, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i8, (int) f6, canScrollVertically()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public void notifyItemSizeChanged() {
        refreshKeylineState();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.carouselStrategy.initialize(recyclerView.getContext());
        refreshKeylineState();
        recyclerView.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Nullable
    public View onFocusSearchFailed(@NonNull View view, int i5, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i5)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            addViewAtPosition(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        } else if (getPosition(view) == getItemCount() - 1) {
            return null;
        } else {
            addViewAtPosition(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
            return getChildClosestToEnd();
        }
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i5, int i6) {
        super.onItemsAdded(recyclerView, i5, i6);
        updateItemCount();
    }

    public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        updateItemCount();
    }

    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i5, int i6) {
        super.onItemsRemoved(recyclerView, i5, i6);
        updateItemCount();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z4;
        int i5;
        if (state.getItemCount() <= 0 || ((float) getContainerSize()) <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean isLayoutRtl = isLayoutRtl();
        KeylineStateList keylineStateList2 = this.keylineStateList;
        if (keylineStateList2 == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 || keylineStateList2.getDefaultState().getCarouselSize() != getContainerSize()) {
            recalculateKeylineStateList(recycler);
        }
        int calculateStartScroll = calculateStartScroll(this.keylineStateList);
        int calculateEndScroll = calculateEndScroll(state, this.keylineStateList);
        if (isLayoutRtl) {
            i5 = calculateEndScroll;
        } else {
            i5 = calculateStartScroll;
        }
        this.minScroll = i5;
        if (isLayoutRtl) {
            calculateEndScroll = calculateStartScroll;
        }
        this.maxScroll = calculateEndScroll;
        if (z4) {
            this.scrollOffset = calculateStartScroll;
            this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
            int i6 = this.currentEstimatedPosition;
            if (i6 != -1) {
                this.scrollOffset = getScrollOffsetForPosition(i6, getKeylineStateForPosition(i6));
            }
        }
        int i7 = this.scrollOffset;
        this.scrollOffset = i7 + calculateShouldScrollBy(0, i7, this.minScroll, this.maxScroll);
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, state.getItemCount());
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        detachAndScrapAttachedViews(recycler);
        fill(recycler, state);
        this.lastItemCount = getItemCount();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z4, boolean z5) {
        int smallestScrollOffsetToFocalKeyline;
        if (this.keylineStateList == null || (smallestScrollOffsetToFocalKeyline = getSmallestScrollOffsetToFocalKeyline(getPosition(view), getKeylineStateForPosition(getPosition(view)))) == 0) {
            return false;
        }
        scrollBy(recyclerView, getSmallestScrollOffsetToFocalKeyline(getPosition(view), this.keylineStateList.getShiftedState((float) (this.scrollOffset + calculateShouldScrollBy(smallestScrollOffsetToFocalKeyline, this.scrollOffset, this.minScroll, this.maxScroll)), (float) this.minScroll, (float) this.maxScroll)));
        return true;
    }

    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i5, recycler, state);
        }
        return 0;
    }

    public void scrollToPosition(int i5) {
        this.currentEstimatedPosition = i5;
        if (this.keylineStateList != null) {
            this.scrollOffset = getScrollOffsetForPosition(i5, getKeylineStateForPosition(i5));
            this.currentFillStartPosition = MathUtils.clamp(i5, 0, Math.max(0, getItemCount() - 1));
            updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
            requestLayout();
        }
    }

    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i5, recycler, state);
        }
        return 0;
    }

    public void setCarouselAlignment(int i5) {
        this.carouselAlignment = i5;
        refreshKeylineState();
    }

    public void setCarouselStrategy(@NonNull CarouselStrategy carouselStrategy2) {
        this.carouselStrategy = carouselStrategy2;
        refreshKeylineState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDebuggingEnabled(@NonNull RecyclerView recyclerView, boolean z4) {
        this.isDebuggingEnabled = z4;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (z4) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    public void setOrientation(int i5) {
        if (i5 == 0 || i5 == 1) {
            assertNotInLayoutOrScroll((String) null);
            CarouselOrientationHelper carouselOrientationHelper = this.orientationHelper;
            if (carouselOrientationHelper == null || i5 != carouselOrientationHelper.orientation) {
                this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, i5);
                refreshKeylineState();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i5);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        AnonymousClass1 r22 = new LinearSmoothScroller(recyclerView.getContext()) {
            public int calculateDxToMakeVisible(View view, int i5) {
                if (CarouselLayoutManager.this.keylineStateList == null || !CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            public int calculateDyToMakeVisible(View view, int i5) {
                if (CarouselLayoutManager.this.keylineStateList == null || CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Nullable
            public PointF computeScrollVectorForPosition(int i5) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(i5);
            }
        };
        r22.setTargetPosition(i5);
        startSmoothScroll(r22);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2) {
        this(carouselStrategy2, 0);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2, int i5) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new b(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(carouselStrategy2);
        setOrientation(i5);
    }

    private int scrollBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f5;
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        if (this.keylineStateList == null) {
            recalculateKeylineStateList(recycler);
        }
        if (getItemCount() <= getKeylineStartingState(this.keylineStateList).getTotalVisibleFocalItems()) {
            return 0;
        }
        int calculateShouldScrollBy = calculateShouldScrollBy(i5, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += calculateShouldScrollBy;
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        float calculateChildStartForFill = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        if (isLayoutRtl()) {
            f5 = this.currentKeylineState.getLastFocalKeyline().locOffset;
        } else {
            f5 = this.currentKeylineState.getFirstFocalKeyline().locOffset;
        }
        float f6 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            float abs = Math.abs(f5 - offsetChild(childAt, calculateChildStartForFill, itemSize, rect));
            if (childAt != null && abs < f6) {
                this.currentEstimatedPosition = getPosition(childAt);
                f6 = abs;
            }
            calculateChildStartForFill = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize());
        }
        fill(recycler, state);
        return calculateShouldScrollBy;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new b(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
        setCarouselAttributes(context, attributeSet);
    }
}
