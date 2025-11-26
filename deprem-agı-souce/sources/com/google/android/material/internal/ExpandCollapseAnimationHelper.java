package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ExpandCollapseAnimationHelper {
    @Nullable
    private ValueAnimator.AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final List<View> endAnchoredViews = new ArrayList();
    /* access modifiers changed from: private */
    public final View expandedView;
    private int expandedViewOffsetY;
    private final List<AnimatorListenerAdapter> listeners = new ArrayList();

    public ExpandCollapseAnimationHelper(@NonNull View view, @NonNull View view2) {
        this.collapsedView = view;
        this.expandedView = view2;
    }

    private void addListeners(Animator animator, List<AnimatorListenerAdapter> list) {
        for (AnimatorListenerAdapter addListener : list) {
            animator.addListener(addListener);
        }
    }

    private AnimatorSet getAnimatorSet(boolean z4) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{getExpandCollapseAnimator(z4), getExpandedViewChildrenAlphaAnimator(z4), getEndAnchoredViewsTranslateAnimator(z4)});
        return animatorSet;
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean z4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((this.expandedView.getLeft() - this.collapsedView.getLeft()) + (this.collapsedView.getRight() - this.expandedView.getRight())), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener((Collection<View>) this.endAnchoredViews));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ofFloat;
    }

    private Animator getExpandCollapseAnimator(boolean z4) {
        Rect calculateRectFromBounds = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect calculateRectFromBounds2 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        Rect rect = new Rect(calculateRectFromBounds);
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), new Object[]{calculateRectFromBounds, calculateRectFromBounds2});
        ofObject.addUpdateListener(new a(this, rect));
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.additionalUpdateListener;
        if (animatorUpdateListener != null) {
            ofObject.addUpdateListener(animatorUpdateListener);
        }
        ofObject.setDuration(this.duration);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ofObject;
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean z4) {
        List<View> children = ViewUtils.getChildren(this.expandedView);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener((Collection<View>) children));
        ofFloat.setDuration(this.duration);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z4, AnimationUtils.LINEAR_INTERPOLATOR));
        return ofFloat;
    }

    @NonNull
    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull View... viewArr) {
        Collections.addAll(this.endAnchoredViews, viewArr);
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper addListener(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.listeners.add(animatorListenerAdapter);
        return this;
    }

    @NonNull
    public Animator getCollapseAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(false);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(8);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    @NonNull
    public Animator getExpandAnimator() {
        AnimatorSet animatorSet = getAnimatorSet(true);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(0);
            }
        });
        addListeners(animatorSet, this.listeners);
        return animatorSet;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(@Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.additionalUpdateListener = animatorUpdateListener;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int i5) {
        this.collapsedViewOffsetY = i5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setDuration(long j5) {
        this.duration = j5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int i5) {
        this.expandedViewOffsetY = i5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull Collection<View> collection) {
        this.endAnchoredViews.addAll(collection);
        return this;
    }
}
