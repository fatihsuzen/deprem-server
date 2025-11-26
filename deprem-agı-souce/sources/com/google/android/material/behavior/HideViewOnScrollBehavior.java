package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    public static final int EDGE_BOTTOM = 1;
    public static final int EDGE_LEFT = 2;
    public static final int EDGE_RIGHT = 0;
    private static final int ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
    public static final int STATE_SCROLLED_IN = 2;
    public static final int STATE_SCROLLED_OUT = 1;
    /* access modifiers changed from: private */
    public AccessibilityManager accessibilityManager;
    private int additionalHiddenOffset;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator currentAnimator;
    private int currentState;
    private boolean disableOnTouchExploration;
    private int enterAnimDuration;
    @Nullable
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    @Nullable
    private TimeInterpolator exitAnimInterpolator;
    private HideViewOnScrollDelegate hideOnScrollViewDelegate;
    @NonNull
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners;
    private int size;
    /* access modifiers changed from: private */
    public AccessibilityManager.TouchExplorationStateChangeListener touchExplorationListener;
    private boolean viewEdgeOverride;

    public interface OnScrollStateChangedListener {
        void onStateChanged(@NonNull View view, int i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public HideViewOnScrollBehavior() {
        this.disableOnTouchExploration = true;
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.size = 0;
        this.currentState = 2;
        this.additionalHiddenOffset = 0;
        this.viewEdgeOverride = false;
    }

    public static /* synthetic */ void a(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view, boolean z4) {
        if (hideViewOnScrollBehavior.disableOnTouchExploration && z4 && hideViewOnScrollBehavior.isScrolledOut()) {
            hideViewOnScrollBehavior.slideIn(view);
        }
    }

    private void animateChildTo(@NonNull V v5, int i5, long j5, @NonNull TimeInterpolator timeInterpolator) {
        this.currentAnimator = this.hideOnScrollViewDelegate.getViewTranslationAnimator(v5, i5).setInterpolator(timeInterpolator).setDuration(j5).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }

    private void disableIfTouchExplorationEnabled(V v5) {
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(v5.getContext(), AccessibilityManager.class);
        }
        if (this.accessibilityManager != null && this.touchExplorationListener == null) {
            b bVar = new b(this, v5);
            this.touchExplorationListener = bVar;
            this.accessibilityManager.addTouchExplorationStateChangeListener(bVar);
            v5.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(@NonNull View view) {
                }

                public void onViewDetachedFromWindow(@NonNull View view) {
                    if (HideViewOnScrollBehavior.this.touchExplorationListener != null && HideViewOnScrollBehavior.this.accessibilityManager != null) {
                        HideViewOnScrollBehavior.this.accessibilityManager.removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.this.touchExplorationListener);
                        AccessibilityManager.TouchExplorationStateChangeListener unused = HideViewOnScrollBehavior.this.touchExplorationListener = null;
                    }
                }
            });
        }
    }

    @NonNull
    public static <V extends View> HideViewOnScrollBehavior<V> from(@NonNull V v5) {
        ViewGroup.LayoutParams layoutParams = v5.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof HideViewOnScrollBehavior) {
                return (HideViewOnScrollBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with HideViewOnScrollBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private boolean isGravityBottom(int i5) {
        return i5 == 80 || i5 == 81;
    }

    private boolean isGravityLeft(int i5) {
        return i5 == 3 || i5 == 19;
    }

    private void setViewEdge(@NonNull V v5, int i5) {
        if (!this.viewEdgeOverride) {
            int i6 = ((CoordinatorLayout.LayoutParams) v5.getLayoutParams()).gravity;
            if (isGravityBottom(i6)) {
                setViewEdgeInternal(1);
            } else {
                setViewEdgeInternal(isGravityLeft(Gravity.getAbsoluteGravity(i6, i5)) ? 2 : 0);
            }
        }
    }

    private void setViewEdgeInternal(int i5) {
        HideViewOnScrollDelegate hideViewOnScrollDelegate = this.hideOnScrollViewDelegate;
        if (hideViewOnScrollDelegate != null && hideViewOnScrollDelegate.getViewEdge() == i5) {
            return;
        }
        if (i5 == 0) {
            this.hideOnScrollViewDelegate = new HideRightViewOnScrollDelegate();
        } else if (i5 == 1) {
            this.hideOnScrollViewDelegate = new HideBottomViewOnScrollDelegate();
        } else if (i5 == 2) {
            this.hideOnScrollViewDelegate = new HideLeftViewOnScrollDelegate();
        } else {
            throw new IllegalArgumentException("Invalid view edge position value: " + i5 + ". Must be " + 0 + ", " + 1 + " or " + 2 + ".");
        }
    }

    private void updateCurrentState(@NonNull V v5, int i5) {
        this.currentState = i5;
        Iterator<OnScrollStateChangedListener> it = this.onScrollStateChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v5, this.currentState);
        }
    }

    public void addOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.add(onScrollStateChangedListener);
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }

    public void disableOnTouchExploration(boolean z4) {
        this.disableOnTouchExploration = z4;
    }

    public boolean isDisabledOnTouchExploration() {
        return this.disableOnTouchExploration;
    }

    public boolean isScrolledIn() {
        if (this.currentState == 2) {
            return true;
        }
        return false;
    }

    public boolean isScrolledOut() {
        if (this.currentState == 1) {
            return true;
        }
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        disableIfTouchExplorationEnabled(v5);
        setViewEdge(v5, i5);
        this.size = this.hideOnScrollViewDelegate.getSize(v5, (ViewGroup.MarginLayoutParams) v5.getLayoutParams());
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(v5.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(v5.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        Context context = v5.getContext();
        int i6 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(context, i6, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(v5.getContext(), i6, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(coordinatorLayout, v5, i5);
    }

    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
        if (i6 > 0) {
            slideOut(v5);
        } else if (i6 < 0) {
            slideIn(v5);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5, int i6) {
        return i5 == 2;
    }

    public void removeOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.remove(onScrollStateChangedListener);
    }

    public void setAdditionalHiddenOffset(@NonNull V v5, @Dimension int i5) {
        this.additionalHiddenOffset = i5;
        if (this.currentState == 1) {
            this.hideOnScrollViewDelegate.setAdditionalHiddenOffset(v5, this.size, i5);
        }
    }

    public void slideIn(@NonNull V v5) {
        slideIn(v5, true);
    }

    public void slideOut(@NonNull V v5) {
        slideOut(v5, true);
    }

    public void slideIn(@NonNull V v5, boolean z4) {
        if (!isScrolledIn()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v5.clearAnimation();
            }
            updateCurrentState(v5, 2);
            int targetTranslation = this.hideOnScrollViewDelegate.getTargetTranslation();
            if (z4) {
                animateChildTo(v5, targetTranslation, (long) this.enterAnimDuration, this.enterAnimInterpolator);
                return;
            }
            this.hideOnScrollViewDelegate.setViewTranslation(v5, targetTranslation);
        }
    }

    public void slideOut(@NonNull V v5, boolean z4) {
        AccessibilityManager accessibilityManager2;
        if (!isScrolledOut()) {
            if (!this.disableOnTouchExploration || (accessibilityManager2 = this.accessibilityManager) == null || !accessibilityManager2.isTouchExplorationEnabled()) {
                ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    v5.clearAnimation();
                }
                updateCurrentState(v5, 1);
                int i5 = this.size + this.additionalHiddenOffset;
                if (z4) {
                    animateChildTo(v5, i5, (long) this.exitAnimDuration, this.exitAnimInterpolator);
                    return;
                }
                this.hideOnScrollViewDelegate.setViewTranslation(v5, i5);
            }
        }
    }

    public HideViewOnScrollBehavior(int i5) {
        this();
        setViewEdge(i5);
    }

    public void setViewEdge(int i5) {
        this.viewEdgeOverride = true;
        setViewEdgeInternal(i5);
    }

    public HideViewOnScrollBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.disableOnTouchExploration = true;
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.size = 0;
        this.currentState = 2;
        this.additionalHiddenOffset = 0;
        this.viewEdgeOverride = false;
    }
}
