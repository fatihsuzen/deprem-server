package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private final float appBarElevation;
    @ColorInt
    private int backgroundOriginalColor;
    private Behavior behavior;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private boolean haveChildWithInterpolator;
    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    @Nullable
    private ColorStateList liftOnScrollColor;
    @Nullable
    private ValueAnimator liftOnScrollColorAnimator;
    private final long liftOnScrollColorDuration;
    private final TimeInterpolator liftOnScrollColorInterpolator;
    @Nullable
    private ValueAnimator.AnimatorUpdateListener liftOnScrollColorUpdateListener;
    private final List<LiftOnScrollListener> liftOnScrollListeners;
    @Nullable
    private WeakReference<View> liftOnScrollTargetView;
    @IdRes
    private int liftOnScrollTargetViewId;
    private final LinkedHashSet<LiftOnScrollProgressListener> liftProgressListeners;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;
    @Nullable
    private Drawable statusBarForeground;
    @Nullable
    private Integer statusBarForegroundOriginalColor;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        /* access modifiers changed from: private */
        public int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean canDrag(@NonNull T t5);
        }

        public BaseBehavior() {
        }

        private void addAccessibilityDelegateIfNeeded(final CoordinatorLayout coordinatorLayout, @NonNull final T t5) {
            if (!ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, new AccessibilityDelegateCompat() {
                    public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        View access$000;
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                        if (t5.getTotalScrollRange() != 0 && (access$000 = BaseBehavior.this.getChildWithScrollingBehavior(coordinatorLayout)) != null && BaseBehavior.this.childrenHaveScrollFlags(t5)) {
                            if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() != (-t5.getTotalScrollRange())) {
                                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                accessibilityNodeInfoCompat.setScrollable(true);
                            }
                            if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() == 0) {
                                return;
                            }
                            if (!access$000.canScrollVertically(-1)) {
                                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                accessibilityNodeInfoCompat.setScrollable(true);
                            } else if ((-t5.getDownNestedPreScrollRange()) != 0) {
                                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                accessibilityNodeInfoCompat.setScrollable(true);
                            }
                        }
                    }

                    public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
                        if (i5 == 4096) {
                            t5.setExpanded(false);
                            return true;
                        } else if (i5 != 8192) {
                            return super.performAccessibilityAction(view, i5, bundle);
                        } else {
                            if (BaseBehavior.this.getTopBottomOffsetForScrollingSibling() != 0) {
                                View access$000 = BaseBehavior.this.getChildWithScrollingBehavior(coordinatorLayout);
                                if (access$000.canScrollVertically(-1)) {
                                    int i6 = -t5.getDownNestedPreScrollRange();
                                    if (i6 != 0) {
                                        BaseBehavior.this.onNestedPreScroll(coordinatorLayout, t5, access$000, 0, i6, new int[]{0, 0}, 1);
                                        return true;
                                    }
                                } else {
                                    t5.setExpanded(true);
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                });
            }
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t5, int i5, float f5) {
            int i6;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i5);
            float abs2 = Math.abs(f5);
            if (abs2 > 0.0f) {
                i6 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i6 = (int) (((((float) abs) / ((float) t5.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, t5, i5, i6);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final T t5, int i5, int i6) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i5) {
                ValueAnimator valueAnimator = this.offsetAnimator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.offsetAnimator.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.offsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.offsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        BaseBehavior.this.setHeaderTopBottomOffset(coordinatorLayout, t5, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.offsetAnimator.setDuration((long) Math.min(i6, 600));
            this.offsetAnimator.setIntValues(new int[]{topBottomOffsetForScrollingSibling, i5});
            this.offsetAnimator.start();
        }

        private int calculateSnapOffset(int i5, int i6, int i7) {
            if (i5 < (i6 + i7) / 2) {
                return i6;
            }
            return i7;
        }

        private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, @NonNull View view) {
            if (!t5.hasScrollableChildren() || coordinatorLayout.getHeight() - view.getHeight() > t5.getHeight()) {
                return false;
            }
            return true;
        }

        private static boolean checkFlag(int i5, int i6) {
            return (i5 & i6) == i6;
        }

        /* access modifiers changed from: private */
        public boolean childrenHaveScrollFlags(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (((LayoutParams) appBarLayout.getChildAt(i5).getLayoutParams()).scrollFlags != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i5) {
            int abs = Math.abs(i5);
            int childCount = appBarLayout.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = appBarLayout.getChildAt(i6);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int getChildIndexOnOffset(@NonNull T t5, int i5) {
            int childCount = t5.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = t5.getChildAt(i6);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.getScrollFlags(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i7 = -i5;
                if (top <= i7 && bottom >= i7) {
                    return i6;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        @Nullable
        public View getChildWithScrollingBehavior(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = coordinatorLayout.getChildAt(i5);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int interpolateOffset(@NonNull T t5, int i5) {
            int abs = Math.abs(i5);
            int childCount = t5.getChildCount();
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= childCount) {
                    break;
                }
                View childAt = t5.getChildAt(i7);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i7++;
                } else if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        i6 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((scrollFlags & 2) != 0) {
                            i6 -= childAt.getMinimumHeight();
                        }
                    }
                    if (childAt.getFitsSystemWindows()) {
                        i6 -= t5.getTopInset();
                    }
                    if (i6 > 0) {
                        float f5 = (float) i6;
                        return Integer.signum(i5) * (childAt.getTop() + Math.round(f5 * scrollInterpolator.getInterpolation(((float) (abs - childAt.getTop())) / f5)));
                    }
                }
            }
            return i5;
        }

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            List<View> dependents = coordinatorLayout.getDependents(t5);
            int size = dependents.size();
            int i5 = 0;
            while (i5 < size) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i5).getLayoutParams()).getBehavior();
                if (!(behavior instanceof ScrollingViewBehavior)) {
                    i5++;
                } else if (((ScrollingViewBehavior) behavior).getOverlayTop() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            int topInset = t5.getTopInset() + t5.getPaddingTop();
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling() - topInset;
            int childIndexOnOffset = getChildIndexOnOffset(t5, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = t5.getChildAt(childIndexOnOffset);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i5 = -childAt.getTop();
                    int i6 = -childAt.getBottom();
                    if (childIndexOnOffset == 0 && t5.getFitsSystemWindows() && childAt.getFitsSystemWindows()) {
                        i5 -= t5.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i6 += childAt.getMinimumHeight();
                    } else if (checkFlag(scrollFlags, 5)) {
                        int minimumHeight = childAt.getMinimumHeight() + i6;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i5 = minimumHeight;
                        } else {
                            i6 = minimumHeight;
                        }
                    }
                    if (checkFlag(scrollFlags, 32)) {
                        i5 += layoutParams.topMargin;
                        i6 -= layoutParams.bottomMargin;
                    }
                    animateOffsetTo(coordinatorLayout, t5, MathUtils.clamp(calculateSnapOffset(topBottomOffsetForScrollingSibling, i6, i5) + topInset, -t5.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i5, int i6, boolean z4) {
            View appBarChildOnOffset = getAppBarChildOnOffset(t5, i5);
            boolean z5 = false;
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = appBarChildOnOffset.getMinimumHeight();
                    if (i6 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i5) < (appBarChildOnOffset.getBottom() - minimumHeight) - t5.getTopInset()) : (-i5) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t5.getTopInset()) {
                        z5 = true;
                    }
                }
            }
            if (t5.isLiftOnScroll()) {
                z5 = t5.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t5.setLiftedState(z5);
            if (z4 || (liftedState && shouldJumpElevationState(coordinatorLayout, t5))) {
                if (t5.getBackground() != null) {
                    t5.getBackground().jumpToCurrentState();
                }
                if (t5.getForeground() != null) {
                    t5.getForeground().jumpToCurrentState();
                }
                if (t5.getStateListAnimator() != null) {
                    t5.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.offsetAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void restoreScrollState(@Nullable SavedState savedState2, boolean z4) {
            if (this.savedState == null || z4) {
                this.savedState = savedState2;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public SavedState saveScrollState(@Nullable Parcelable parcelable, @NonNull T t5) {
            boolean z4;
            boolean z5;
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t5.getChildCount();
            boolean z6 = false;
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = t5.getChildAt(i5);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i5++;
                } else {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState2 = new SavedState(parcelable);
                    if (topAndBottomOffset == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    savedState2.fullyExpanded = z4;
                    if (z4 || (-topAndBottomOffset) < t5.getTotalScrollRange()) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    savedState2.fullyScrolled = z5;
                    savedState2.firstVisibleChildIndex = i5;
                    if (bottom == childAt.getMinimumHeight() + t5.getTopInset()) {
                        z6 = true;
                    }
                    savedState2.firstVisibleChildAtMinimumHeight = z6;
                    savedState2.firstVisibleChildPercentageShown = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState2;
                }
            }
            return null;
        }

        public void setDragCallback(@Nullable BaseDragCallback baseDragCallback) {
            this.onDragCallback = baseDragCallback;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public boolean canDragView(T t5) {
            BaseDragCallback baseDragCallback = this.onDragCallback;
            if (baseDragCallback != null) {
                return baseDragCallback.canDrag(t5);
            }
            WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public int getMaxDragOffset(@NonNull T t5) {
            return (-t5.getDownNestedScrollRange()) + t5.getTopInset();
        }

        /* access modifiers changed from: package-private */
        public int getScrollRangeForDragFling(@NonNull T t5) {
            return t5.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            snapToChildIfNeeded(coordinatorLayout, t5);
            if (t5.isLiftOnScroll()) {
                t5.setLiftedState(t5.shouldLift(findFirstScrollingChild(coordinatorLayout)));
            }
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i5) {
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t5, i5);
            int pendingAction = t5.getPendingAction();
            SavedState savedState2 = this.savedState;
            if (savedState2 == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z4 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i6 = -t5.getUpNestedPreScrollRange();
                        if (z4) {
                            animateOffsetTo(coordinatorLayout, t5, i6, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t5, i6);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z4) {
                            animateOffsetTo(coordinatorLayout, t5, 0, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(coordinatorLayout, t5, 0);
                        }
                    }
                }
            } else if (savedState2.fullyScrolled) {
                setHeaderTopBottomOffset(coordinatorLayout, t5, -t5.getTotalScrollRange());
            } else if (savedState2.fullyExpanded) {
                setHeaderTopBottomOffset(coordinatorLayout, t5, 0);
            } else {
                View childAt = t5.getChildAt(savedState2.firstVisibleChildIndex);
                int i7 = -childAt.getBottom();
                if (this.savedState.firstVisibleChildAtMinimumHeight) {
                    round = childAt.getMinimumHeight() + t5.getTopInset();
                } else {
                    round = Math.round(((float) childAt.getHeight()) * this.savedState.firstVisibleChildPercentageShown);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t5, i7 + round);
            }
            t5.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t5.getTotalScrollRange(), 0));
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            T t6 = t5;
            updateAppBarLayoutDrawableState(coordinatorLayout2, t6, getTopAndBottomOffset(), 0, true);
            t6.onOffsetChanged(getTopAndBottomOffset());
            addAccessibilityDelegateIfNeeded(coordinatorLayout2, t6);
            return onLayoutChild;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i5, int i6, int i7, int i8) {
            if (((CoordinatorLayout.LayoutParams) t5.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t5, i5, i6, i7, i8);
            }
            coordinatorLayout.onMeasureChild(t5, i5, i6, View.MeasureSpec.makeMeasureSpec(0, 0), i8);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r7, @androidx.annotation.NonNull T r8, android.view.View r9, int r10, int r11, int[] r12, int r13) {
            /*
                r6 = this;
                if (r11 == 0) goto L_0x0026
                if (r11 >= 0) goto L_0x0011
                int r10 = r8.getTotalScrollRange()
                int r10 = -r10
                int r13 = r8.getDownNestedPreScrollRange()
                int r13 = r13 + r10
            L_0x000e:
                r4 = r10
                r5 = r13
                goto L_0x0018
            L_0x0011:
                int r10 = r8.getUpNestedPreScrollRange()
                int r10 = -r10
                r13 = 0
                goto L_0x000e
            L_0x0018:
                if (r4 == r5) goto L_0x0026
                r10 = 1
                r0 = r6
                r1 = r7
                r2 = r8
                r3 = r11
                int r7 = r0.scroll(r1, r2, r3, r4, r5)
                r12[r10] = r7
                goto L_0x0027
            L_0x0026:
                r2 = r8
            L_0x0027:
                boolean r7 = r2.isLiftOnScroll()
                if (r7 == 0) goto L_0x0034
                boolean r7 = r2.shouldLift(r9)
                r2.setLiftedState(r7)
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.onNestedPreScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int, int[], int):void");
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            int i10;
            T t6;
            CoordinatorLayout coordinatorLayout2;
            if (i8 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i10 = i8;
                iArr[1] = scroll(coordinatorLayout2, t6, i10, -t5.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                i10 = i8;
            }
            if (i10 == 0) {
                addAccessibilityDelegateIfNeeded(coordinatorLayout2, t6);
            }
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                restoreScrollState((SavedState) parcelable, true);
                super.onRestoreInstanceState(coordinatorLayout, t5, this.savedState.getSuperState());
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t5, parcelable);
            this.savedState = null;
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t5);
            SavedState saveScrollState = saveScrollState(onSaveInstanceState, t5);
            return saveScrollState == null ? onSaveInstanceState : saveScrollState;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, @NonNull View view, View view2, int i5, int i6) {
            ValueAnimator valueAnimator;
            boolean z4 = (i5 & 2) != 0 && (t5.isLiftOnScroll() || t5.isLifted() || canScrollChildren(coordinatorLayout, t5, view));
            if (z4 && (valueAnimator = this.offsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.lastNestedScrollingChildRef = null;
            this.lastStartedType = i6;
            return z4;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t5, View view, int i5) {
            if (this.lastStartedType == 0 || i5 == 1) {
                snapToChildIfNeeded(coordinatorLayout, t5);
                if (t5.isLiftOnScroll()) {
                    t5.setLiftedState(t5.shouldLift(view));
                }
            }
            this.lastNestedScrollingChildRef = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t5, int i5, int i6, int i7) {
            T t6;
            CoordinatorLayout coordinatorLayout2;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i8 = 0;
            if (i6 == 0 || topBottomOffsetForScrollingSibling < i6 || topBottomOffsetForScrollingSibling > i7) {
                coordinatorLayout2 = coordinatorLayout;
                t6 = t5;
                this.offsetDelta = 0;
            } else {
                int clamp = MathUtils.clamp(i5, i6, i7);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    int interpolateOffset = t5.hasChildWithInterpolator() ? interpolateOffset(t5, clamp) : clamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                    int i9 = topBottomOffsetForScrollingSibling - clamp;
                    this.offsetDelta = clamp - interpolateOffset;
                    int i10 = 1;
                    if (topAndBottomOffset) {
                        while (i8 < t5.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t5.getChildAt(i8).getLayoutParams();
                            ChildScrollEffect scrollEffect = layoutParams.getScrollEffect();
                            if (!(scrollEffect == null || (layoutParams.getScrollFlags() & 1) == 0)) {
                                scrollEffect.onOffsetChanged(t5, t5.getChildAt(i8), (float) getTopAndBottomOffset());
                            }
                            i8++;
                        }
                    }
                    if (!topAndBottomOffset && t5.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t5);
                    }
                    t5.onOffsetChanged(getTopAndBottomOffset());
                    if (clamp < topBottomOffsetForScrollingSibling) {
                        i10 = -1;
                    }
                    coordinatorLayout2 = coordinatorLayout;
                    t6 = t5;
                    updateAppBarLayoutDrawableState(coordinatorLayout2, t6, clamp, i10, false);
                    i8 = i9;
                } else {
                    coordinatorLayout2 = coordinatorLayout;
                    t6 = t5;
                }
            }
            addAccessibilityDelegateIfNeeded(coordinatorLayout2, t6);
            return i8;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                @NonNull
                public SavedState[] newArray(int i5) {
                    return new SavedState[i5];
                }

                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Nullable
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, (ClassLoader) null);
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                boolean z4 = false;
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0 ? true : z4;
            }

            public void writeToParcel(@NonNull Parcel parcel, int i5) {
                super.writeToParcel(parcel, i5);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T t5, int i5);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i5) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i5);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i5, int i6, int i7, int i8) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i5, i6, i7, i8);
        }

        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i5, int i6, int[] iArr, int i7) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i5, i6, iArr, i7);
        }

        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i5, i6, i7, i8, i9, iArr);
        }

        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i5, int i6) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i5, i6);
        }

        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i5) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i5);
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.setDragCallback(baseDragCallback);
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z4) {
            super.setHorizontalOffsetEnabled(z4);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i5) {
            return super.setLeftAndRightOffset(i5);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i5) {
            return super.setTopAndBottomOffset(i5);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z4) {
            super.setVerticalOffsetEnabled(z4);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f5);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect = new Rect();
        private final Rect relativeRect = new Rect();

        private static void updateRelativeRect(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void onOffsetChanged(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f5) {
            updateRelativeRect(this.relativeRect, appBarLayout, view);
            float abs = ((float) this.relativeRect.top) - Math.abs(f5);
            if (abs <= 0.0f) {
                float clamp = 1.0f - MathUtils.clamp(Math.abs(abs / ((float) this.relativeRect.height())), 0.0f, 1.0f);
                float height = (-abs) - ((((float) this.relativeRect.height()) * COMPRESS_DISTANCE_FACTOR) * (1.0f - (clamp * clamp)));
                view.setTranslationY(height);
                view.getDrawingRect(this.ghostRect);
                this.ghostRect.offset(0, (int) (-height));
                if (height >= ((float) this.ghostRect.height())) {
                    view.setAlpha(0.0f);
                } else {
                    view.setAlpha(1.0f);
                }
                view.setClipBounds(this.ghostRect);
                return;
            }
            view.setClipBounds((Rect) null);
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags = 1;
        Interpolator scrollInterpolator;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i5 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (obtainStyledAttributes.hasValue(i5)) {
                this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i5, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int i5) {
            if (i5 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        /* access modifiers changed from: package-private */
        public boolean isCollapsible() {
            int i5 = this.scrollFlags;
            if ((i5 & 1) != 1 || (i5 & 10) == 0) {
                return false;
            }
            return true;
        }

        public void setScrollEffect(@Nullable ChildScrollEffect childScrollEffect) {
            this.scrollEffect = childScrollEffect;
        }

        public void setScrollFlags(int i5) {
            this.scrollFlags = i5;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.scrollInterpolator = interpolator;
        }

        public void setScrollEffect(int i5) {
            this.scrollEffect = createScrollEffectFromInt(i5);
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(int i5, int i6, float f5) {
            super(i5, i6, f5);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.scrollFlags = layoutParams.scrollFlags;
            this.scrollEffect = layoutParams.scrollEffect;
            this.scrollInterpolator = layoutParams.scrollInterpolator;
        }
    }

    @Deprecated
    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float f5, @ColorInt int i5);
    }

    public static abstract class LiftOnScrollProgressListener {
        public abstract void onUpdate(@Dimension float f5, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f6);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        void onOffsetChanged(AppBarLayout appBarLayout, int i5);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).offsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        /* access modifiers changed from: package-private */
        public float getOverlapRatioForOffset(View view) {
            int i5;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i5 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) appBarLayoutOffset) / ((float) i5)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        public int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.setAccessibilityDelegate(coordinatorLayout, (AccessibilityDelegateCompat) null);
            }
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i5) {
            return super.onLayoutChild(coordinatorLayout, view, i5);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i5, int i6, int i7, int i8) {
            return super.onMeasureChild(coordinatorLayout, view, i5, i6, i7, i8);
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z4) {
            AppBarLayout findFirstDependency = findFirstDependency((List) coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    findFirstDependency.setExpanded(false, !z4);
                    return true;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z4) {
            super.setHorizontalOffsetEnabled(z4);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i5) {
            return super.setLeftAndRightOffset(i5);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i5) {
            return super.setTopAndBottomOffset(i5);
        }

        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z4) {
            super.setVerticalOffsetEnabled(z4);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public AppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = list.get(i5);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        appBarLayout.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setElevation(floatValue);
        Drawable drawable = appBarLayout.statusBarForeground;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(floatValue);
        }
        for (LiftOnScrollListener onUpdate : appBarLayout.liftOnScrollListeners) {
            onUpdate.onUpdate(floatValue, materialShapeDrawable.getResolvedTintColor());
        }
        Iterator<LiftOnScrollProgressListener> it = appBarLayout.liftProgressListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(floatValue, materialShapeDrawable.getResolvedTintColor(), floatValue / appBarLayout.appBarElevation);
        }
    }

    public static /* synthetic */ void b(AppBarLayout appBarLayout, ColorStateList colorStateList, MaterialShapeDrawable materialShapeDrawable, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        appBarLayout.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int layer = MaterialColors.layer(appBarLayout.backgroundOriginalColor, colorStateList.getDefaultColor(), floatValue);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(layer));
        if (!(appBarLayout.statusBarForeground == null || (num2 = appBarLayout.statusBarForegroundOriginalColor) == null || !num2.equals(num))) {
            appBarLayout.statusBarForeground.setTint(layer);
        }
        if (!appBarLayout.liftOnScrollListeners.isEmpty()) {
            for (LiftOnScrollListener next : appBarLayout.liftOnScrollListeners) {
                if (materialShapeDrawable.getFillColor() != null) {
                    next.onUpdate(0.0f, layer);
                }
            }
        }
        if (!appBarLayout.liftProgressListeners.isEmpty()) {
            Iterator<LiftOnScrollProgressListener> it = appBarLayout.liftProgressListeners.iterator();
            while (it.hasNext()) {
                it.next().onUpdate(0.0f, layer, floatValue);
            }
        }
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private Integer extractStatusBarForegroundColor() {
        Drawable drawable = this.statusBarForeground;
        if (drawable instanceof MaterialShapeDrawable) {
            return Integer.valueOf(((MaterialShapeDrawable) drawable).getResolvedTintColor());
        }
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(drawable);
        if (colorStateListOrNull != null) {
            return Integer.valueOf(colorStateListOrNull.getDefaultColor());
        }
        return null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View view) {
        int i5;
        View view2;
        if (this.liftOnScrollTargetView == null && (i5 = this.liftOnScrollTargetViewId) != -1) {
            if (view != null) {
                view2 = view.findViewById(i5);
            } else {
                view2 = null;
            }
            if (view2 == null && (getParent() instanceof ViewGroup)) {
                view2 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (view2 != null) {
                this.liftOnScrollTargetView = new WeakReference<>(view2);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).isCollapsible()) {
                return true;
            }
        }
        return false;
    }

    private void initializeLiftOnScrollWithColor(MaterialShapeDrawable materialShapeDrawable, @NonNull ColorStateList colorStateList) {
        this.liftOnScrollColorUpdateListener = new b(this, colorStateList, materialShapeDrawable, MaterialColors.getColorOrNull(getContext(), R.attr.colorSurface));
    }

    private void initializeLiftOnScrollWithElevation(Context context, MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.initializeElevationOverlay(context);
        this.liftOnScrollColorUpdateListener = new c(this, materialShapeDrawable);
    }

    private void invalidateScrollRanges() {
        BaseBehavior.SavedState savedState;
        Behavior behavior2 = this.behavior;
        if (behavior2 == null || this.totalScrollRange == -1 || this.pendingAction != 0) {
            savedState = null;
        } else {
            savedState = behavior2.saveScrollState(AbsSavedState.EMPTY_STATE, this);
        }
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        if (savedState != null) {
            this.behavior.restoreScrollState(savedState, false);
        }
    }

    private boolean isLiftOnScrollCompatibleBackground() {
        return getBackground() instanceof MaterialShapeDrawable;
    }

    @Nullable
    private MaterialShapeDrawable maybeConvertToMaterialShapeDrawable(Drawable drawable) {
        if (drawable instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) drawable;
        }
        ColorStateList colorStateListOrNull = DrawableUtils.getColorStateListOrNull(drawable);
        if (colorStateListOrNull == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.setFillColor(colorStateListOrNull);
        return materialShapeDrawable;
    }

    private Drawable maybeCreateLiftOnScrollBackground(@NonNull Context context, @NonNull Drawable drawable) {
        MaterialShapeDrawable maybeConvertToMaterialShapeDrawable = maybeConvertToMaterialShapeDrawable(drawable);
        if (maybeConvertToMaterialShapeDrawable == null || maybeConvertToMaterialShapeDrawable.getFillColor() == null) {
            return drawable;
        }
        this.backgroundOriginalColor = maybeConvertToMaterialShapeDrawable.getFillColor().getDefaultColor();
        ColorStateList colorStateList = this.liftOnScrollColor;
        if (colorStateList != null) {
            initializeLiftOnScrollWithColor(maybeConvertToMaterialShapeDrawable, colorStateList);
            return maybeConvertToMaterialShapeDrawable;
        }
        initializeLiftOnScrollWithElevation(context, maybeConvertToMaterialShapeDrawable);
        return maybeConvertToMaterialShapeDrawable;
    }

    private boolean setLiftableState(boolean z4) {
        if (this.liftable == z4) {
            return false;
        }
        this.liftable = z4;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        if (this.statusBarForeground == null || getTopInset() <= 0) {
            return false;
        }
        return true;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() == 8 || childAt.getFitsSystemWindows()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void startLiftOnScrollColorAnimation(float f5, float f6) {
        ValueAnimator valueAnimator = this.liftOnScrollColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f5, f6});
        this.liftOnScrollColorAnimator = ofFloat;
        ofFloat.setDuration(this.liftOnScrollColorDuration);
        this.liftOnScrollColorAnimator.setInterpolator(this.liftOnScrollColorInterpolator);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.liftOnScrollColorUpdateListener;
        if (animatorUpdateListener != null) {
            this.liftOnScrollColorAnimator.addUpdateListener(animatorUpdateListener);
        }
        this.liftOnScrollColorAnimator.start();
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    @Deprecated
    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.liftOnScrollListeners.add(liftOnScrollListener);
    }

    public void addLiftOnScrollProgressListener(@NonNull LiftOnScrollProgressListener liftOnScrollProgressListener) {
        this.liftProgressListeners.add(liftOnScrollProgressListener);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.listeners.contains(baseOnOffsetChangedListener)) {
            this.listeners.add(baseOnOffsetChangedListener);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Deprecated
    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    public void clearLiftOnScrollProgressListener() {
        this.liftProgressListeners.clear();
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.currentOffset));
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior2 = new Behavior();
        this.behavior = behavior2;
        return behavior2;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i5;
        int minimumHeight;
        int i6 = this.downPreScrollRange;
        if (i6 != -1) {
            return i6;
        }
        int i7 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = layoutParams.scrollFlags;
                if ((i8 & 5) == 5) {
                    int i9 = layoutParams.topMargin + layoutParams.bottomMargin;
                    if ((i8 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i8 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        i5 = i9 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            i5 = Math.min(i5, measuredHeight - getTopInset());
                        }
                        i7 += i5;
                    }
                    i5 = i9 + minimumHeight;
                    i5 = Math.min(i5, measuredHeight - getTopInset());
                    i7 += i5;
                } else if (i7 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, i7);
        this.downPreScrollRange = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i5 = this.downScrollRange;
        if (i5 != -1) {
            return i5;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int i8 = layoutParams.scrollFlags;
                if ((i8 & 1) == 0) {
                    break;
                }
                i7 += measuredHeight;
                if ((i8 & 2) != 0) {
                    i7 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int max = Math.max(0, i7);
        this.downScrollRange = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int i5;
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i6 = (minimumHeight * 2) + topInset;
            if (i6 < getHeight()) {
                return i6;
            }
            return minimumHeight + topInset;
        }
        int childCount = getChildCount();
        if (childCount >= 1) {
            i5 = getChildAt(childCount - 1).getMinimumHeight();
        } else {
            i5 = 0;
        }
        if (i5 == 0) {
            return getHeight() / 3;
        }
        int i7 = (i5 * 2) + topInset;
        if (i7 < getHeight()) {
            return i7;
        }
        return i5 + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i5 = this.totalScrollRange;
        if (i5 != -1) {
            return i5;
        }
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = layoutParams.scrollFlags;
                if ((i8 & 1) == 0) {
                    break;
                }
                i7 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
                if (i6 == 0 && childAt.getFitsSystemWindows()) {
                    i7 -= getTopInset();
                }
                if ((i8 & 2) != 0) {
                    i7 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i6++;
        }
        int max = Math.max(0, i7);
        this.totalScrollRange = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    /* access modifiers changed from: package-private */
    public boolean hasScrollableChildren() {
        if (getTotalScrollRange() != 0) {
            return true;
        }
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i5) {
        int i6;
        int i7;
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(i5 + iArr.length);
        boolean z4 = this.liftable;
        int i8 = R.attr.state_liftable;
        if (!z4) {
            i8 = -i8;
        }
        iArr[0] = i8;
        if (!z4 || !this.lifted) {
            i6 = -R.attr.state_lifted;
        } else {
            i6 = R.attr.state_lifted;
        }
        iArr[1] = i6;
        int i9 = R.attr.state_collapsible;
        if (!z4) {
            i9 = -i9;
        }
        iArr[2] = i9;
        if (!z4 || !this.lifted) {
            i7 = -R.attr.state_collapsed;
        } else {
            i7 = R.attr.state_collapsed;
        }
        iArr[3] = i7;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        boolean z5 = true;
        if (getFitsSystemWindows() && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i9 = 0;
        while (true) {
            if (i9 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i9).getLayoutParams()).getScrollInterpolator() != null) {
                this.haveChildWithInterpolator = true;
                break;
            } else {
                i9++;
            }
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.liftableOverride) {
            if (!this.liftOnScroll && !hasCollapsibleChild()) {
                z5 = false;
            }
            setLiftableState(z5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 1073741824 && getFitsSystemWindows() && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i6));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    /* access modifiers changed from: package-private */
    public void onOffsetChanged(int i5) {
        this.currentOffset = i5;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners.get(i6);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.onOffsetChanged(this, i5);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (getFitsSystemWindows()) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            updateWillNotDraw();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.liftOnScrollListeners.remove(liftOnScrollListener);
    }

    public boolean removeLiftOnScrollProgressListener(@NonNull LiftOnScrollProgressListener liftOnScrollProgressListener) {
        return this.liftProgressListeners.remove(liftOnScrollProgressListener);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void setBackground(Drawable drawable) {
        super.setBackground(maybeCreateLiftOnScrollBackground(getContext(), drawable));
    }

    public void setElevation(float f5) {
        super.setElevation(f5);
        MaterialShapeUtils.setElevation(this, f5);
    }

    public void setExpanded(boolean z4) {
        setExpanded(z4, isLaidOut());
    }

    public void setLiftOnScroll(boolean z4) {
        this.liftOnScroll = z4;
    }

    public void setLiftOnScrollColor(@Nullable ColorStateList colorStateList) {
        if (this.liftOnScrollColor != colorStateList) {
            this.liftOnScrollColor = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.liftOnScrollTargetViewId = -1;
        if (view == null) {
            clearLiftOnScrollTargetView();
        } else {
            this.liftOnScrollTargetView = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i5) {
        this.liftOnScrollTargetViewId = i5;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean z4) {
        this.liftableOverride = true;
        return setLiftableState(z4);
    }

    public void setLiftableOverrideEnabled(boolean z4) {
        this.liftableOverride = z4;
    }

    public boolean setLifted(boolean z4) {
        return setLiftedState(z4, true);
    }

    /* access modifiers changed from: package-private */
    public boolean setLiftedState(boolean z4) {
        return setLiftedState(z4, !this.liftableOverride);
    }

    public void setOrientation(int i5) {
        if (i5 == 1) {
            super.setOrientation(i5);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* access modifiers changed from: package-private */
    public void setPendingAction(int i5) {
        this.pendingAction = i5;
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        boolean z4;
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.statusBarForeground = drawable3;
            this.statusBarForegroundOriginalColor = extractStatusBarForegroundColor();
            Drawable drawable4 = this.statusBarForeground;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarForeground, getLayoutDirection());
                Drawable drawable5 = this.statusBarForeground;
                if (getVisibility() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                drawable5.setVisible(z4, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i5) {
        setStatusBarForeground(new ColorDrawable(i5));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i5) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i5));
    }

    @Deprecated
    public void setTargetElevation(float f5) {
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f5);
    }

    public void setVisibility(int i5) {
        boolean z4;
        super.setVisibility(i5);
        if (i5 == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z4, false);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldLift(@Nullable View view) {
        View findLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (findLiftOnScrollTargetView != null) {
            view = findLiftOnScrollTargetView;
        }
        if (view == null) {
            return false;
        }
        if (view.canScrollVertically(-1) || view.getScrollY() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.statusBarForeground) {
            return true;
        }
        return false;
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z4, boolean z5) {
        setExpanded(z4, z5, true);
    }

    /* access modifiers changed from: package-private */
    public boolean setLiftedState(boolean z4, boolean z5) {
        float f5;
        if (!z5 || this.lifted == z4) {
            return false;
        }
        this.lifted = z4;
        refreshDrawableState();
        if (!isLiftOnScrollCompatibleBackground()) {
            return true;
        }
        float f6 = 0.0f;
        if (this.liftOnScrollColor != null) {
            float f7 = z4 ? 0.0f : 1.0f;
            if (z4) {
                f6 = 1.0f;
            }
            startLiftOnScrollColorAnimation(f7, f6);
            return true;
        } else if (!this.liftOnScroll) {
            return true;
        } else {
            if (z4) {
                f5 = 0.0f;
            } else {
                f5 = this.appBarElevation;
            }
            if (z4) {
                f6 = this.appBarElevation;
            }
            startLiftOnScrollColorAnimation(f5, f6);
            return true;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            r8 = -1
            r7.totalScrollRange = r8
            r7.downPreScrollRange = r8
            r7.downScrollRange = r8
            r6 = 0
            r7.pendingAction = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.liftOnScrollListeners = r0
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r7.liftProgressListeners = r0
            android.content.Context r0 = r7.getContext()
            r1 = 1
            r7.setOrientation(r1)
            android.view.ViewOutlineProvider r1 = r7.getOutlineProvider()
            android.view.ViewOutlineProvider r2 = android.view.ViewOutlineProvider.BACKGROUND
            if (r1 != r2) goto L_0x0034
            com.google.android.material.appbar.ViewUtilsLollipop.setBoundsViewOutlineProvider(r7)
        L_0x0034:
            com.google.android.material.appbar.ViewUtilsLollipop.setStateListAnimatorFromAttrs(r7, r9, r10, r4)
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollColor
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r0, (android.content.res.TypedArray) r9, (int) r10)
            r7.liftOnScrollColor = r10
            int r10 = com.google.android.material.R.attr.motionDurationMedium2
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R.integer.app_bar_elevation_anim_duration
            int r1 = r1.getInteger(r2)
            int r10 = com.google.android.material.motion.MotionUtils.resolveThemeDuration(r0, r10, r1)
            long r1 = (long) r10
            r7.liftOnScrollColorDuration = r1
            int r10 = com.google.android.material.R.attr.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r1 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            android.animation.TimeInterpolator r10 = com.google.android.material.motion.MotionUtils.resolveThemeInterpolator(r0, r10, r1)
            r7.liftOnScrollColorInterpolator = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x0075
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setExpanded(r10, r6, r6)
        L_0x0075:
            int r10 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x0085
            int r10 = r9.getDimensionPixelSize(r10, r6)
            float r10 = (float) r10
            com.google.android.material.appbar.ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(r7, r10)
        L_0x0085:
            int r10 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r10 = r9.getDrawable(r10)
            r7.setBackground(r10)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r10 < r0) goto L_0x00b2
            int r10 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x00a3
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setKeyboardNavigationCluster(r10)
        L_0x00a3:
            int r10 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L_0x00b2
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setTouchscreenBlocksFocus(r10)
        L_0x00b2:
            android.content.res.Resources r10 = r7.getResources()
            int r0 = com.google.android.material.R.dimen.design_appbar_elevation
            float r10 = r10.getDimension(r0)
            r7.appBarElevation = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r10 = r9.getBoolean(r10, r6)
            r7.liftOnScroll = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r8 = r9.getResourceId(r10, r8)
            r7.liftOnScrollTargetViewId = r8
            int r8 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r8 = r9.getDrawable(r8)
            r7.setStatusBarForeground(r8)
            r9.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r8 = new com.google.android.material.appbar.AppBarLayout$1
            r8.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void setExpanded(boolean z4, boolean z5, boolean z6) {
        int i5 = 0;
        int i6 = (z4 ? 1 : 2) | (z5 ? 4 : 0);
        if (z6) {
            i5 = 8;
        }
        this.pendingAction = i6 | i5;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        removeOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        addOnOffsetChangedListener((BaseOnOffsetChangedListener) onOffsetChangedListener);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
