package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
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

@Deprecated
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    private static final int ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    /* access modifiers changed from: private */
    public AccessibilityManager accessibilityManager;
    private int additionalHiddenOffsetY = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private boolean disableOnTouchExploration = true;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height = 0;
    @NonNull
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners = new LinkedHashSet<>();
    /* access modifiers changed from: private */
    public AccessibilityManager.TouchExplorationStateChangeListener touchExplorationListener;

    public interface OnScrollStateChangedListener {
        void onStateChanged(@NonNull View view, int i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public static /* synthetic */ void a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view, boolean z4) {
        if (!z4) {
            hideBottomViewOnScrollBehavior.getClass();
        } else if (hideBottomViewOnScrollBehavior.isScrolledDown()) {
            hideBottomViewOnScrollBehavior.slideUp(view);
        }
    }

    private void animateChildTo(@NonNull V v5, int i5, long j5, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v5.animate().translationY((float) i5).setInterpolator(timeInterpolator).setDuration(j5).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }

    private void disableIfTouchExplorationEnabled(V v5) {
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(v5.getContext(), AccessibilityManager.class);
        }
        if (this.accessibilityManager != null && this.touchExplorationListener == null) {
            a aVar = new a(this, v5);
            this.touchExplorationListener = aVar;
            this.accessibilityManager.addTouchExplorationStateChangeListener(aVar);
            v5.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(@NonNull View view) {
                }

                public void onViewDetachedFromWindow(@NonNull View view) {
                    if (HideBottomViewOnScrollBehavior.this.touchExplorationListener != null && HideBottomViewOnScrollBehavior.this.accessibilityManager != null) {
                        HideBottomViewOnScrollBehavior.this.accessibilityManager.removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.this.touchExplorationListener);
                        AccessibilityManager.TouchExplorationStateChangeListener unused = HideBottomViewOnScrollBehavior.this.touchExplorationListener = null;
                    }
                }
            });
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

    public boolean isScrolledDown() {
        if (this.currentState == 1) {
            return true;
        }
        return false;
    }

    public boolean isScrolledUp() {
        if (this.currentState == 2) {
            return true;
        }
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, int i5) {
        this.height = v5.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v5.getLayoutParams()).bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(v5.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(v5.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        Context context = v5.getContext();
        int i6 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(context, i6, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(v5.getContext(), i6, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        disableIfTouchExplorationEnabled(v5);
        return super.onLayoutChild(coordinatorLayout, v5, i5);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i5, int i6, int i7, int i8, int i9, @NonNull int[] iArr) {
        if (i6 > 0) {
            slideDown(v5);
        } else if (i6 < 0) {
            slideUp(v5);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i5, int i6) {
        return i5 == 2;
    }

    public void removeOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.remove(onScrollStateChangedListener);
    }

    public void setAdditionalHiddenOffsetY(@NonNull V v5, @Dimension int i5) {
        this.additionalHiddenOffsetY = i5;
        if (this.currentState == 1) {
            v5.setTranslationY((float) (this.height + i5));
        }
    }

    public void slideDown(@NonNull V v5) {
        slideDown(v5, true);
    }

    public void slideUp(@NonNull V v5) {
        slideUp(v5, true);
    }

    public void slideDown(@NonNull V v5, boolean z4) {
        AccessibilityManager accessibilityManager2;
        if (!isScrolledDown()) {
            if (!this.disableOnTouchExploration || (accessibilityManager2 = this.accessibilityManager) == null || !accessibilityManager2.isTouchExplorationEnabled()) {
                ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    v5.clearAnimation();
                }
                updateCurrentState(v5, 1);
                int i5 = this.height + this.additionalHiddenOffsetY;
                if (z4) {
                    animateChildTo(v5, i5, (long) this.exitAnimDuration, this.exitAnimInterpolator);
                    return;
                }
                v5.setTranslationY((float) i5);
            }
        }
    }

    public void slideUp(@NonNull V v5, boolean z4) {
        if (!isScrolledUp()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v5.clearAnimation();
            }
            updateCurrentState(v5, 2);
            if (z4) {
                animateChildTo(v5, 0, (long) this.enterAnimDuration, this.enterAnimInterpolator);
                return;
            }
            v5.setTranslationY((float) 0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
