package com.google.android.material.navigationrail;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

class LabelMoveTransition extends Transition {
    private static final float HORIZONTAL_DISTANCE = -30.0f;
    private static final String LABEL_VISIBILITY = "NavigationRailLabelVisibility";

    LabelMoveTransition() {
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || transitionValues.values.get(LABEL_VISIBILITY) == null || transitionValues2.values.get(LABEL_VISIBILITY) == null) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        if (((Integer) transitionValues.values.get(LABEL_VISIBILITY)).intValue() != 8 || ((Integer) transitionValues2.values.get(LABEL_VISIBILITY)).intValue() != 0) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        View view = transitionValues2.view;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(view));
        return ofFloat;
    }
}
