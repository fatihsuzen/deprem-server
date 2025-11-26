package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public abstract class BaseGridView extends RecyclerView {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ALIGNED = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_ITEM = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int FOCUS_SCROLL_PAGE = 2;
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private static final int PFLAG_RETAIN_FOCUS_FOR_CHILD = 1;
    public static final int SAVE_ALL_CHILD = 3;
    public static final int SAVE_LIMITED_CHILD = 2;
    public static final int SAVE_NO_CHILD = 0;
    public static final int SAVE_ON_SCREEN_CHILD = 1;
    public static final int WINDOW_ALIGN_BOTH_EDGE = 3;
    public static final int WINDOW_ALIGN_HIGH_EDGE = 2;
    public static final int WINDOW_ALIGN_LOW_EDGE = 1;
    public static final int WINDOW_ALIGN_NO_EDGE = 0;
    public static final float WINDOW_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private boolean mAnimateChildLayout = true;
    private boolean mHasOverlappingRendering = true;
    int mInitialPrefetchItemCount = 4;
    GridLayoutManager mLayoutManager;
    private OnKeyInterceptListener mOnKeyInterceptListener;
    private OnMotionInterceptListener mOnMotionInterceptListener;
    private OnTouchInterceptListener mOnTouchInterceptListener;
    private OnUnhandledKeyListener mOnUnhandledKeyListener;
    private int mPrivateFlag;
    private RecyclerView.ItemAnimator mSavedItemAnimator;
    private SmoothScrollByBehavior mSmoothScrollByBehavior;

    public interface OnKeyInterceptListener {
        boolean onInterceptKeyEvent(KeyEvent keyEvent);
    }

    public interface OnLayoutCompletedListener {
        void onLayoutCompleted(RecyclerView.State state);
    }

    public interface OnMotionInterceptListener {
        boolean onInterceptMotionEvent(MotionEvent motionEvent);
    }

    public interface OnTouchInterceptListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(KeyEvent keyEvent);
    }

    public interface SmoothScrollByBehavior {
        int configSmoothScrollByDuration(int i5, int i6);

        Interpolator configSmoothScrollByInterpolator(int i5, int i6);
    }

    BaseGridView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        this.mLayoutManager = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((SimpleItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
        super.addRecyclerListener(new RecyclerView.RecyclerListener() {
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                BaseGridView.this.mLayoutManager.onChildRecycled(viewHolder);
            }
        });
    }

    public void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.addOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public final void addOnLayoutCompletedListener(OnLayoutCompletedListener onLayoutCompletedListener) {
        this.mLayoutManager.addOnLayoutCompletedListener(onLayoutCompletedListener);
    }

    public void animateIn() {
        this.mLayoutManager.slideIn();
    }

    public void animateOut() {
        this.mLayoutManager.slideOut();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        OnMotionInterceptListener onMotionInterceptListener = this.mOnMotionInterceptListener;
        if (onMotionInterceptListener == null || !onMotionInterceptListener.onInterceptMotionEvent(motionEvent)) {
            return super.dispatchGenericFocusedEvent(motionEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnKeyInterceptListener onKeyInterceptListener = this.mOnKeyInterceptListener;
        if ((onKeyInterceptListener != null && onKeyInterceptListener.onInterceptKeyEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnUnhandledKeyListener onUnhandledKeyListener = this.mOnUnhandledKeyListener;
        if (onUnhandledKeyListener == null || !onUnhandledKeyListener.onUnhandledKey(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnTouchInterceptListener onTouchInterceptListener = this.mOnTouchInterceptListener;
        if (onTouchInterceptListener == null || !onTouchInterceptListener.onInterceptTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public View focusSearch(int i5) {
        if (isFocused()) {
            GridLayoutManager gridLayoutManager = this.mLayoutManager;
            View findViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.getSelection());
            if (findViewByPosition != null) {
                return focusSearch(findViewByPosition, i5);
            }
        }
        return super.focusSearch(i5);
    }

    public int getChildDrawingOrder(int i5, int i6) {
        return this.mLayoutManager.getChildDrawingOrder(this, i5, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getExtraLayoutSpace() {
        return this.mLayoutManager.getExtraLayoutSpace();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getFocusScrollStrategy() {
        return this.mLayoutManager.getFocusScrollStrategy();
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getHorizontalSpacing() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getItemAlignmentOffset() {
        return this.mLayoutManager.getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.mLayoutManager.getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.mLayoutManager.getItemAlignmentViewId();
    }

    public OnUnhandledKeyListener getOnUnhandledKeyListener() {
        return this.mOnUnhandledKeyListener;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.mLayoutManager.mChildrenStates.getLimitNumber();
    }

    public final int getSaveChildrenPolicy() {
        return this.mLayoutManager.mChildrenStates.getSavePolicy();
    }

    public int getSelectedPosition() {
        return this.mLayoutManager.getSelection();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getSelectedSubPosition() {
        return this.mLayoutManager.getSubSelection();
    }

    public SmoothScrollByBehavior getSmoothScrollByBehavior() {
        return this.mSmoothScrollByBehavior;
    }

    public final int getSmoothScrollMaxPendingMoves() {
        return this.mLayoutManager.mMaxPendingMoves;
    }

    public final float getSmoothScrollSpeedFactor() {
        return this.mLayoutManager.mSmoothScrollSpeedFactor;
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public int getVerticalSpacing() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public void getViewSelectedOffsets(View view, int[] iArr) {
        this.mLayoutManager.getViewSelectedOffsets(view, iArr);
    }

    public int getWindowAlignment() {
        return this.mLayoutManager.getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.mLayoutManager.getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.mLayoutManager.getWindowAlignmentOffsetPercent();
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    public boolean hasPreviousViewInSameRow(int i5) {
        return this.mLayoutManager.hasPreviousViewInSameRow(i5);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"CustomViewStyleable"})
    public void initBaseGridViewAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseGridView);
        this.mLayoutManager.setFocusOutAllowed(obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutFront, false), obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutEnd, false));
        this.mLayoutManager.setFocusOutSideAllowed(obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideStart, true), obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideEnd, true));
        this.mLayoutManager.setVerticalSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_verticalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_verticalMargin, 0)));
        this.mLayoutManager.setHorizontalSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_horizontalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_horizontalMargin, 0)));
        int i5 = R.styleable.lbBaseGridView_android_gravity;
        if (obtainStyledAttributes.hasValue(i5)) {
            setGravity(obtainStyledAttributes.getInt(i5, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public boolean isChildLayoutAnimated() {
        return this.mAnimateChildLayout;
    }

    /* access modifiers changed from: package-private */
    public final boolean isChildrenDrawingOrderEnabledInternal() {
        return isChildrenDrawingOrderEnabled();
    }

    public boolean isFocusDrawingOrderEnabled() {
        return super.isChildrenDrawingOrderEnabled();
    }

    public final boolean isFocusSearchDisabled() {
        return this.mLayoutManager.isFocusSearchDisabled();
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return this.mLayoutManager.isItemAlignmentOffsetWithPadding();
    }

    public boolean isScrollEnabled() {
        return this.mLayoutManager.isScrollEnabled();
    }

    public boolean isWindowAlignmentPreferKeyLineOverHighEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverHighEdge();
    }

    public boolean isWindowAlignmentPreferKeyLineOverLowEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverLowEdge();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        this.mLayoutManager.onFocusChanged(z4, i5, rect);
    }

    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if ((this.mPrivateFlag & 1) == 1) {
            return false;
        }
        return this.mLayoutManager.gridOnRequestFocusInDescendants(this, i5, rect);
    }

    public void onRtlPropertiesChanged(int i5) {
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.onRtlPropertiesChanged(i5);
        }
    }

    public void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.removeOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public final void removeOnLayoutCompletedListener(OnLayoutCompletedListener onLayoutCompletedListener) {
        this.mLayoutManager.removeOnLayoutCompletedListener(onLayoutCompletedListener);
    }

    public void removeView(View view) {
        boolean z4;
        if (!view.hasFocus() || !isFocusable()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            this.mPrivateFlag = 1 | this.mPrivateFlag;
            requestFocus();
        }
        super.removeView(view);
        if (z4) {
            this.mPrivateFlag ^= -2;
        }
    }

    public void removeViewAt(int i5) {
        boolean hasFocus = getChildAt(i5).hasFocus();
        if (hasFocus) {
            this.mPrivateFlag |= 1;
            requestFocus();
        }
        super.removeViewAt(i5);
        if (hasFocus) {
            this.mPrivateFlag ^= -2;
        }
    }

    public void scrollToPosition(int i5) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i5, 0, 0);
        } else {
            super.scrollToPosition(i5);
        }
    }

    public void setAnimateChildLayout(boolean z4) {
        if (this.mAnimateChildLayout != z4) {
            this.mAnimateChildLayout = z4;
            if (!z4) {
                this.mSavedItemAnimator = getItemAnimator();
                super.setItemAnimator((RecyclerView.ItemAnimator) null);
                return;
            }
            super.setItemAnimator(this.mSavedItemAnimator);
        }
    }

    public void setChildrenVisibility(int i5) {
        this.mLayoutManager.setChildrenVisibility(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExtraLayoutSpace(int i5) {
        this.mLayoutManager.setExtraLayoutSpace(i5);
    }

    public void setFocusDrawingOrderEnabled(boolean z4) {
        super.setChildrenDrawingOrderEnabled(z4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setFocusScrollStrategy(int i5) {
        if (i5 == 0 || i5 == 1 || i5 == 2) {
            this.mLayoutManager.setFocusScrollStrategy(i5);
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid scrollStrategy");
    }

    public final void setFocusSearchDisabled(boolean z4) {
        int i5;
        if (z4) {
            i5 = 393216;
        } else {
            i5 = 262144;
        }
        setDescendantFocusability(i5);
        this.mLayoutManager.setFocusSearchDisabled(z4);
    }

    public void setGravity(int i5) {
        this.mLayoutManager.setGravity(i5);
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z4) {
        this.mHasOverlappingRendering = z4;
    }

    @Deprecated
    public void setHorizontalMargin(int i5) {
        setHorizontalSpacing(i5);
    }

    public void setHorizontalSpacing(int i5) {
        this.mLayoutManager.setHorizontalSpacing(i5);
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i5) {
        this.mInitialPrefetchItemCount = i5;
    }

    public void setItemAlignmentOffset(int i5) {
        this.mLayoutManager.setItemAlignmentOffset(i5);
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f5) {
        this.mLayoutManager.setItemAlignmentOffsetPercent(f5);
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z4) {
        this.mLayoutManager.setItemAlignmentOffsetWithPadding(z4);
        requestLayout();
    }

    public void setItemAlignmentViewId(int i5) {
        this.mLayoutManager.setItemAlignmentViewId(i5);
    }

    @Deprecated
    public void setItemMargin(int i5) {
        setItemSpacing(i5);
    }

    public void setItemSpacing(int i5) {
        this.mLayoutManager.setItemSpacing(i5);
        requestLayout();
    }

    public void setLayoutEnabled(boolean z4) {
        this.mLayoutManager.setLayoutEnabled(z4);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager == null) {
            super.setLayoutManager((RecyclerView.LayoutManager) null);
            GridLayoutManager gridLayoutManager = this.mLayoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.setGridView((BaseGridView) null);
            }
            this.mLayoutManager = null;
            return;
        }
        GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager;
        this.mLayoutManager = gridLayoutManager2;
        gridLayoutManager2.setGridView(this);
        super.setLayoutManager(layoutManager);
    }

    public void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mLayoutManager.setOnChildLaidOutListener(onChildLaidOutListener);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mLayoutManager.setOnChildSelectedListener(onChildSelectedListener);
    }

    public void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.setOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public void setOnKeyInterceptListener(OnKeyInterceptListener onKeyInterceptListener) {
        this.mOnKeyInterceptListener = onKeyInterceptListener;
    }

    public void setOnMotionInterceptListener(OnMotionInterceptListener onMotionInterceptListener) {
        this.mOnMotionInterceptListener = onMotionInterceptListener;
    }

    public void setOnTouchInterceptListener(OnTouchInterceptListener onTouchInterceptListener) {
        this.mOnTouchInterceptListener = onTouchInterceptListener;
    }

    public void setOnUnhandledKeyListener(OnUnhandledKeyListener onUnhandledKeyListener) {
        this.mOnUnhandledKeyListener = onUnhandledKeyListener;
    }

    public void setPruneChild(boolean z4) {
        this.mLayoutManager.setPruneChild(z4);
    }

    public final void setSaveChildrenLimitNumber(int i5) {
        this.mLayoutManager.mChildrenStates.setLimitNumber(i5);
    }

    public final void setSaveChildrenPolicy(int i5) {
        this.mLayoutManager.mChildrenStates.setSavePolicy(i5);
    }

    public void setScrollEnabled(boolean z4) {
        this.mLayoutManager.setScrollEnabled(z4);
    }

    public void setSelectedPosition(int i5) {
        this.mLayoutManager.setSelection(i5, 0);
    }

    public void setSelectedPositionSmooth(int i5) {
        this.mLayoutManager.setSelectionSmooth(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionSmoothWithSub(int i5, int i6) {
        this.mLayoutManager.setSelectionSmoothWithSub(i5, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i5, int i6) {
        this.mLayoutManager.setSelectionWithSub(i5, i6, 0);
    }

    public final void setSmoothScrollByBehavior(SmoothScrollByBehavior smoothScrollByBehavior) {
        this.mSmoothScrollByBehavior = smoothScrollByBehavior;
    }

    public final void setSmoothScrollMaxPendingMoves(int i5) {
        this.mLayoutManager.mMaxPendingMoves = i5;
    }

    public final void setSmoothScrollSpeedFactor(float f5) {
        this.mLayoutManager.mSmoothScrollSpeedFactor = f5;
    }

    @Deprecated
    public void setVerticalMargin(int i5) {
        setVerticalSpacing(i5);
    }

    public void setVerticalSpacing(int i5) {
        this.mLayoutManager.setVerticalSpacing(i5);
        requestLayout();
    }

    public void setWindowAlignment(int i5) {
        this.mLayoutManager.setWindowAlignment(i5);
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i5) {
        this.mLayoutManager.setWindowAlignmentOffset(i5);
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f5) {
        this.mLayoutManager.setWindowAlignmentOffsetPercent(f5);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z4) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverHighEdge(z4);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z4) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverLowEdge(z4);
        requestLayout();
    }

    public void smoothScrollBy(int i5, int i6) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.mSmoothScrollByBehavior;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i5, i6, smoothScrollByBehavior.configSmoothScrollByInterpolator(i5, i6), this.mSmoothScrollByBehavior.configSmoothScrollByDuration(i5, i6));
        } else {
            smoothScrollBy(i5, i6, (Interpolator) null, Integer.MIN_VALUE);
        }
    }

    public void smoothScrollToPosition(int i5) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i5, 0, 0);
        } else {
            super.smoothScrollToPosition(i5);
        }
    }

    public void setSelectedPosition(int i5, int i6) {
        this.mLayoutManager.setSelection(i5, i6);
    }

    public void setSelectedPositionSmooth(final int i5, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i5);
            if (findViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
                    public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
                        if (i5 == i5) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(findViewHolderForPosition);
            }
        }
        setSelectedPositionSmooth(i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSelectedPositionWithSub(int i5, int i6, int i7) {
        this.mLayoutManager.setSelectionWithSub(i5, i6, i7);
    }

    public void setSelectedPosition(final int i5, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i5);
            if (findViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
                    public void onChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i5, int i6) {
                        if (i5 == i5) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(findViewHolderForPosition);
            }
        }
        setSelectedPosition(i5);
    }

    public void smoothScrollBy(int i5, int i6, Interpolator interpolator) {
        SmoothScrollByBehavior smoothScrollByBehavior = this.mSmoothScrollByBehavior;
        if (smoothScrollByBehavior != null) {
            smoothScrollBy(i5, i6, interpolator, smoothScrollByBehavior.configSmoothScrollByDuration(i5, i6));
        } else {
            smoothScrollBy(i5, i6, interpolator, Integer.MIN_VALUE);
        }
    }
}
