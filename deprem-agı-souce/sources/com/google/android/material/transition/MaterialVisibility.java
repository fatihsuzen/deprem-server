package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final List<VisibilityAnimatorProvider> additionalAnimatorProviders = new ArrayList();
    private final P primaryAnimatorProvider;
    @Nullable
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected MaterialVisibility(P p5, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p5;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    private static void addAnimatorIfNeeded(List<Animator> list, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z4) {
        Animator animator;
        if (visibilityAnimatorProvider != null) {
            if (z4) {
                animator = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                animator = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (animator != null) {
                list.add(animator);
            }
        }
    }

    private Animator createAnimator(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        addAnimatorIfNeeded(arrayList, this.primaryAnimatorProvider, viewGroup, view, z4);
        addAnimatorIfNeeded(arrayList, this.secondaryAnimatorProvider, viewGroup, view, z4);
        for (VisibilityAnimatorProvider addAnimatorIfNeeded : this.additionalAnimatorProviders) {
            addAnimatorIfNeeded(arrayList, addAnimatorIfNeeded, viewGroup, view, z4);
        }
        maybeApplyThemeValues(viewGroup.getContext(), z4);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private void maybeApplyThemeValues(@NonNull Context context, boolean z4) {
        TransitionUtils.maybeApplyThemeDuration(this, context, getDurationThemeAttrResId(z4));
        TransitionUtils.maybeApplyThemeInterpolator(this, context, getEasingThemeAttrResId(z4), getDefaultEasingInterpolator(z4));
    }

    public void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.additionalAnimatorProviders.add(visibilityAnimatorProvider);
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TimeInterpolator getDefaultEasingInterpolator(boolean z4) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getDurationThemeAttrResId(boolean z4) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getEasingThemeAttrResId(boolean z4) {
        return 0;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.additionalAnimatorProviders.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }
}
