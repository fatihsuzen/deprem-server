package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.R;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = {16843130};
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    @VisibleForTesting
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    @VisibleForTesting
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EdgeEffect mEdgeGlowBottom;
    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    /* access modifiers changed from: private */
    public OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z4;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            accessibilityEvent.setScrollable(z4);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
            }
        }

        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i5 != 4096) {
                if (i5 == 8192 || i5 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max, true);
                    return true;
                } else if (i5 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollTo(0, min, true);
            return true;
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        DifferentialMotionFlingTargetImpl() {
        }

        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        public boolean startDifferentialMotionFling(float f5) {
            if (f5 == 0.0f) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f5);
            return true;
        }

        public void stopDifferentialMotionFling() {
            NestedScrollView.this.mScroller.abortAnimation();
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(@NonNull NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        };
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.scrollPosition);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }
    }

    public NestedScrollView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canOverScroll() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
            return true;
        }
        return false;
    }

    private boolean canScroll() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    private static int clamp(int i5, int i6, int i7) {
        if (i6 >= i7 || i5 < 0) {
            return 0;
        }
        return i6 + i5 > i7 ? i7 - i6 : i5;
    }

    private void doScrollY(int i5) {
        if (i5 == 0) {
            return;
        }
        if (this.mSmoothScrollingEnabled) {
            smoothScrollBy(0, i5);
        } else {
            scrollBy(0, i5);
        }
    }

    private boolean edgeEffectFling(int i5) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            if (shouldAbsorb(this.mEdgeGlowTop, i5)) {
                this.mEdgeGlowTop.onAbsorb(i5);
                return true;
            }
            fling(-i5);
            return true;
        } else if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return false;
        } else {
            int i6 = -i5;
            if (shouldAbsorb(this.mEdgeGlowBottom, i6)) {
                this.mEdgeGlowBottom.onAbsorb(i6);
                return true;
            }
            fling(i6);
            return true;
        }
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean z4, int i5, int i6) {
        boolean z5;
        boolean z6;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = focusables.get(i7);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i5 < bottom && top < i6) {
                if (i5 >= top || bottom >= i6) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (view == null) {
                    view = view2;
                    z7 = z5;
                } else {
                    if ((!z4 || top >= view.getTop()) && (z4 || bottom <= view.getBottom())) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (z7) {
                        if (z5) {
                            if (!z6) {
                            }
                        }
                    } else if (z5) {
                        view = view2;
                        z7 = true;
                    } else if (!z6) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private float getSplineFlingDistance(int i5) {
        double log = Math.log((double) ((((float) Math.abs(i5)) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION)));
        float f5 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoeff * SCROLL_FRICTION)) * Math.exp((((double) f5) / (((double) f5) - 1.0d)) * log));
    }

    private boolean inChild(int i5, int i6) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i6 < childAt.getTop() - scrollY || i6 >= childAt.getBottom() - scrollY || i5 < childAt.getLeft() || i5 >= childAt.getRight()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int i5, int i6) {
        this.mLastMotionY = i5;
        this.mActivePointerId = i6;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !isViewDescendantOf((View) parent, view2)) {
            return false;
        }
        return true;
    }

    private boolean isWithinDeltaOfScreen(View view, int i5, int i6) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.bottom + i5 < getScrollY() || this.mTempRect.top - i5 > getScrollY() + i6) {
            return false;
        }
        return true;
    }

    private void onNestedScrollInternal(int i5, int i6, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i5 - scrollY2, (int[]) null, i6, iArr);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i5;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            this.mLastMotionY = (int) motionEvent.getY(i5);
            this.mActivePointerId = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int releaseVerticalGlow(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            android.widget.EdgeEffect r0 = r3.mEdgeGlowTop
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowTop
            r5.onRelease()
        L_0x002f:
            r1 = r4
            goto L_0x0054
        L_0x0031:
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            float r0 = androidx.core.widget.EdgeEffectCompat.getDistance(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0054
            android.widget.EdgeEffect r0 = r3.mEdgeGlowBottom
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.onPullDistance(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x002f
            android.widget.EdgeEffect r5 = r3.mEdgeGlowBottom
            r5.onRelease()
            goto L_0x002f
        L_0x0054:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L_0x0063
            r3.invalidate()
        L_0x0063:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.releaseVerticalGlow(int, float):int");
    }

    private void runAnimatedScroll(boolean z4) {
        if (z4) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int i5, int i6, int i7) {
        boolean z4;
        int i8;
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = height + scrollY;
        boolean z5 = false;
        if (i5 == 33) {
            z4 = true;
        } else {
            z4 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z4, i6, i7);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i6 < scrollY || i7 > i9) {
            if (z4) {
                i8 = i6 - scrollY;
            } else {
                i8 = i7 - i9;
            }
            scrollBy(i8, 0, 1, true);
            z5 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i5);
        }
        return z5;
    }

    private int scrollBy(int i5, int i6, int i7, boolean z4) {
        int i8;
        int i9;
        boolean z5;
        boolean z6;
        VelocityTracker velocityTracker;
        int i10 = i6;
        int i11 = i7;
        if (i11 == 1) {
            startNestedScroll(2, i11);
        }
        int i12 = i11;
        boolean z7 = false;
        if (dispatchNestedPreScroll(0, i5, this.mScrollConsumed, this.mScrollOffset, i11)) {
            i8 = this.mScrollOffset[1];
            i9 = i5 - this.mScrollConsumed[1];
        } else {
            i9 = i5;
            i8 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        if (!canOverScroll() || z4) {
            z5 = false;
        } else {
            z5 = true;
        }
        int i13 = i9;
        int i14 = scrollY;
        if (!overScrollByCompat(0, i9, 0, scrollY, 0, scrollRange, 0, 0, true) || hasNestedScrollingParent(i12)) {
            z6 = false;
        } else {
            z6 = true;
        }
        int scrollY2 = getScrollY() - i14;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        int i15 = i12;
        int i16 = scrollRange;
        int i17 = i15;
        dispatchNestedScroll(0, scrollY2, 0, i13 - scrollY2, this.mScrollOffset, i17, iArr);
        int i18 = i17;
        int i19 = i8 + this.mScrollOffset[1];
        int i20 = i13 - this.mScrollConsumed[1];
        int i21 = i14 + i20;
        if (i21 < 0) {
            if (z5) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((float) (-i20)) / ((float) getHeight()), ((float) i10) / ((float) getWidth()));
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i21 > i16 && z5) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, ((float) i20) / ((float) getHeight()), 1.0f - (((float) i10) / ((float) getWidth())));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (!this.mEdgeGlowTop.isFinished() || !this.mEdgeGlowBottom.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            z7 = z6;
        }
        if (z7 && i18 == 0 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
        }
        if (i18 == 1) {
            stopNestedScroll(i18);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i19;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z4) {
        boolean z5;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (z4) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
                return z5;
            }
            smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
        return z5;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i5) {
        if (i5 > 0) {
            return true;
        }
        if (getSplineFlingDistance(-i5) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) getHeight())) {
            return true;
        }
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z4;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z4 = true;
        } else {
            z4 = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return z4;
        }
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int i5) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i5);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            if (i5 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i5 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i5 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            findNextFocus.requestFocus(i5);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        int i5;
        if (!this.mScroller.isFinished()) {
            this.mScroller.computeScrollOffset();
            int currY = this.mScroller.getCurrY();
            int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.mLastScrollerY);
            this.mLastScrollerY = currY;
            int[] iArr = this.mScrollConsumed;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, iArr, (int[]) null, 1);
            int i6 = consumeFlingInVerticalStretch - this.mScrollConsumed[1];
            int scrollRange = getScrollRange();
            if (i6 != 0) {
                int scrollY = getScrollY();
                overScrollByCompat(0, i6, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                i5 = scrollRange;
                int scrollY2 = getScrollY() - scrollY;
                int i7 = i6 - scrollY2;
                int[] iArr2 = this.mScrollConsumed;
                iArr2[1] = 0;
                dispatchNestedScroll(0, scrollY2, 0, i7, this.mScrollOffset, 1, iArr2);
                i6 = i7 - this.mScrollConsumed[1];
            } else {
                i5 = scrollRange;
            }
            if (i6 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && i5 > 0)) {
                    if (i6 < 0) {
                        if (this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                        }
                    } else if (this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
                abortAnimatedScroll();
            }
            if (!this.mScroller.isFinished()) {
                postInvalidateOnAnimation();
            } else {
                stopNestedScroll(1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i5;
        int i6;
        int i7;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i5 = i8 - verticalFadingEdgeLength;
        } else {
            i5 = i8;
        }
        int i9 = rect.bottom;
        if (i9 > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i7 = rect.top - scrollY;
            } else {
                i7 = rect.bottom - i5;
            }
            return Math.min(i7, (childAt.getBottom() + layoutParams.bottomMargin) - i8);
        } else if (rect.top >= scrollY || i9 >= i5) {
            return 0;
        } else {
            if (rect.height() > height) {
                i6 = 0 - (i5 - rect.bottom);
            } else {
                i6 = 0 - (scrollY - rect.top);
            }
            return Math.max(i6, -getScrollY());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInVerticalStretch(int i5) {
        int height = getHeight();
        if (i5 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != 0.0f) {
            int round = Math.round((((float) (-height)) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (((float) (-i5)) * FLING_DESTRETCH_FACTOR) / ((float) height), 0.5f));
            if (round != i5) {
                this.mEdgeGlowTop.finish();
            }
            return i5 - round;
        } else if (i5 >= 0 || EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == 0.0f) {
            return i5;
        } else {
            float f5 = (float) height;
            int round2 = Math.round((f5 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (((float) i5) * FLING_DESTRETCH_FACTOR) / f5, 0.5f));
            if (round2 != i5) {
                this.mEdgeGlowBottom.finish();
            }
            return i5 - round2;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return this.mChildHelper.dispatchNestedFling(f5, f6, z4);
    }

    public boolean dispatchNestedPreFling(float f5, float f6) {
        return this.mChildHelper.dispatchNestedPreFling(f5, f6);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2, int i7) {
        return this.mChildHelper.dispatchNestedPreScroll(i5, i6, iArr, iArr2, i7);
    }

    public void dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9, @NonNull int[] iArr2) {
        this.mChildHelper.dispatchNestedScroll(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public void draw(@NonNull Canvas canvas) {
        int i5;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i6 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i5 = getPaddingLeft();
            } else {
                i5 = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate((float) i5, (float) min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (!this.mEdgeGlowBottom.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (Api21Impl.getClipToPadding(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i6 = getPaddingLeft();
            }
            if (Api21Impl.getClipToPadding(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i6 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public boolean executeKeyEvent(@NonNull KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean canScroll = canScroll();
        int i5 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        if (!canScroll) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View findFocus = findFocus();
                if (findFocus == this) {
                    findFocus = null;
                }
                View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(TsExtractor.TS_STREAM_TYPE_HDMV_DTS)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode == 62) {
                        if (keyEvent.isShiftPressed()) {
                            i5 = 33;
                        }
                        pageScroll(i5);
                        return false;
                    } else if (keyCode == 92) {
                        return fullScroll(33);
                    } else {
                        if (keyCode == 93) {
                            return fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                        }
                        if (keyCode == 122) {
                            pageScroll(33);
                            return false;
                        } else if (keyCode == 123) {
                            pageScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                            return false;
                        }
                    }
                } else if (keyEvent.isAltPressed()) {
                    return fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                } else {
                    return arrowScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
                }
            } else if (keyEvent.isAltPressed()) {
                return fullScroll(33);
            } else {
                return arrowScroll(33);
            }
        }
        return false;
    }

    public void fling(int i5) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
        }
    }

    public boolean fullScroll(int i5) {
        boolean z4;
        int childCount;
        if (i5 == 130) {
            z4 = true;
        } else {
            z4 = false;
        }
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i5, rect3.top, rect3.bottom);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    public boolean hasNestedScrollingParent(int i5) {
        return this.mChildHelper.hasNestedScrollingParent(i5);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    /* access modifiers changed from: protected */
    public void measureChild(@NonNull View view, int i5, int i6) {
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        int i5;
        float f5;
        int i6;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i6 = 9;
                f5 = motionEvent.getAxisValue(9);
                i5 = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                float axisValue = motionEvent.getAxisValue(26);
                i5 = getWidth() / 2;
                i6 = 26;
                f5 = axisValue;
            } else {
                i6 = 0;
                i5 = 0;
                f5 = 0.0f;
            }
            if (f5 != 0.0f) {
                scrollBy(-((int) (f5 * getVerticalScrollFactorCompat())), i5, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (i6 != 0) {
                    this.mDifferentialMotionFlingController.onMotionEvent(motionEvent, i6);
                }
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i5 = action & 255;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = this.mActivePointerId;
                    if (i6 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i6);
                        if (findPointerIndex == -1) {
                            Log.e(TAG, "Invalid pointerId=" + i6 + " in onInterceptTouchEvent");
                        } else {
                            int y4 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y4 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y4;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i5 != 3) {
                    if (i5 == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else {
            int y5 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y5)) {
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z4 = false;
                }
                this.mIsBeingDragged = z4;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y5;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z4 = false;
                }
                this.mIsBeingDragged = z4;
                startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        int i9 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i9 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, i9);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.mFillViewport && View.MeasureSpec.getMode(i6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(@NonNull View view, float f5, float f6, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f6, true);
        fling((int) f6);
        return true;
    }

    public boolean onNestedPreFling(@NonNull View view, float f5, float f6) {
        return dispatchNestedPreFling(f5, f6);
    }

    public void onNestedPreScroll(@NonNull View view, int i5, int i6, @NonNull int[] iArr, int i7) {
        dispatchNestedPreScroll(i5, i6, iArr, (int[]) null, i7);
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
        onNestedScrollInternal(i8, i9, iArr);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5, int i6) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i5, i6);
        startNestedScroll(2, i6);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i5, int i6, boolean z4, boolean z5) {
        super.scrollTo(i5, i6);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i5, Rect rect) {
        View view;
        if (i5 == 2) {
            i5 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        } else if (i5 == 1) {
            i5 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i5);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i5);
        }
        if (view != null && !isOffScreen(view)) {
            return view.requestFocus(i5, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i5, i6, i7, i8);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i8)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5, int i6) {
        return (i5 & 2) != 0;
    }

    public void onStopNestedScroll(@NonNull View view, int i5) {
        this.mParentHelper.onStopNestedScroll(view, i5);
        stopNestedScroll(i5);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (!edgeEffectFling(yVelocity)) {
                        int i5 = -yVelocity;
                        float f5 = (float) i5;
                        if (!dispatchNestedPreFling(0.0f, f5)) {
                            dispatchNestedFling(0.0f, f5, true);
                            fling(i5);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                endTouchDrag();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                } else {
                    int y4 = (int) motionEvent.getY(findPointerIndex);
                    int i6 = this.mLastMotionY - y4;
                    int releaseVerticalGlow = i6 - releaseVerticalGlow(i6, motionEvent.getX(findPointerIndex));
                    if (!this.mIsBeingDragged && Math.abs(releaseVerticalGlow) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        releaseVerticalGlow = releaseVerticalGlow > 0 ? releaseVerticalGlow - this.mTouchSlop : releaseVerticalGlow + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        int scrollBy = scrollBy(releaseVerticalGlow, (int) motionEvent.getX(findPointerIndex), 0, false);
                        this.mLastMotionY = y4 - scrollBy;
                        this.mNestedYOffset += scrollBy;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                endTouchDrag();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            initializeTouchDrag((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean overScrollByCompat(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i13;
        int i14;
        boolean z9;
        boolean z10;
        int i15;
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (overScrollMode == 0 || (overScrollMode == 1 && z5)) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (overScrollMode == 0 || (overScrollMode == 1 && z6)) {
            z8 = true;
        } else {
            z8 = false;
        }
        int i16 = i7 + i5;
        if (!z7) {
            i13 = 0;
        } else {
            i13 = i11;
        }
        int i17 = i8 + i6;
        if (!z8) {
            i14 = 0;
        } else {
            i14 = i12;
        }
        int i18 = -i13;
        int i19 = i13 + i9;
        int i20 = -i14;
        int i21 = i14 + i10;
        if (i16 > i19) {
            i16 = i19;
            z9 = true;
        } else if (i16 < i18) {
            z9 = true;
            i16 = i18;
        } else {
            z9 = false;
        }
        if (i17 > i21) {
            i17 = i21;
            z10 = true;
        } else if (i17 < i20) {
            z10 = true;
            i17 = i20;
        } else {
            z10 = false;
        }
        if (!z10 || hasNestedScrollingParent(1)) {
            i15 = i16;
        } else {
            int i22 = i16;
            this.mScroller.springBack(i22, i17, 0, 0, 0, getScrollRange());
            i15 = i22;
        }
        onOverScrolled(i15, i17, z9, z10);
        if (z9 || z10) {
            return true;
        }
        return false;
    }

    public boolean pageScroll(int i5) {
        boolean z4;
        if (i5 == 130) {
            z4 = true;
        } else {
            z4 = false;
        }
        int height = getHeight();
        if (z4) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.mTempRect;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i6 = rect3.top;
        int i7 = height + i6;
        rect3.bottom = i7;
        return scrollAndFocus(i5, i6, i7);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z4);
    }

    public void requestDisallowInterceptTouchEvent(boolean z4) {
        if (z4) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int i5, int i6) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int clamp = clamp(i5, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int clamp2 = clamp(i6, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.mFillViewport) {
            this.mFillViewport = z4;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z4) {
        this.mChildHelper.setNestedScrollingEnabled(z4);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.mSmoothScrollingEnabled = z4;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i5, int i6) {
        smoothScrollBy(i5, i6, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int i5, int i6) {
        smoothScrollTo(i5, i6, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public boolean startNestedScroll(int i5, int i6) {
        return this.mChildHelper.startNestedScroll(i5, i6);
    }

    public void stopNestedScroll(int i5) {
        this.mChildHelper.stopNestedScroll(i5);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nestedScrollViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i5, i6, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr, int i9) {
        return this.mChildHelper.dispatchNestedScroll(i5, i6, i7, i8, iArr, i9);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public void onNestedPreScroll(@NonNull View view, int i5, int i6, @NonNull int[] iArr) {
        onNestedPreScroll(view, i5, i6, iArr, 0);
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8, int i9) {
        onNestedScrollInternal(i8, i9, (int[]) null);
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5) {
        return onStartNestedScroll(view, view2, i5, 0);
    }

    public final void smoothScrollBy(int i5, int i6, int i7) {
        smoothScrollBy(i5, i6, i7, false);
    }

    public final void smoothScrollTo(int i5, int i6, int i7) {
        smoothScrollTo(i5, i6, i7, false);
    }

    public boolean startNestedScroll(int i5) {
        return startNestedScroll(i5, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.mDifferentialMotionFlingTarget = differentialMotionFlingTargetImpl;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i5, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int i5, int i6, int i7, boolean z4) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.mScroller;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i6 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i7);
                runAnimatedScroll(z4);
            } else {
                if (!this.mScroller.isFinished()) {
                    abortAnimatedScroll();
                }
                scrollBy(i5, i6);
            }
            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, @Nullable int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i5, i6, i7, i8, iArr);
    }

    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8) {
        onNestedScrollInternal(i8, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5) {
        onNestedScrollAccepted(view, view2, i5, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i5, int i6, boolean z4) {
        smoothScrollTo(i5, i6, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, z4);
    }

    public void addView(View view, int i5) {
        if (getChildCount() <= 0) {
            super.addView(view, i5);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i5, int i6, int i7, boolean z4) {
        smoothScrollBy(i5 - getScrollX(), i6 - getScrollY(), i7, z4);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
