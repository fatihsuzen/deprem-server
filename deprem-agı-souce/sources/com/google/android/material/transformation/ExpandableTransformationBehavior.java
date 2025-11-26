package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    @Nullable
    public AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z4, boolean z5);

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean onExpandedStateChange(View view, View view2, boolean z4, boolean z5) {
        boolean z6;
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            animatorSet.cancel();
        }
        AnimatorSet onCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z4, z6);
        this.currentAnimation = onCreateExpandedStateChangeAnimation;
        onCreateExpandedStateChangeAnimation.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                AnimatorSet unused = ExpandableTransformationBehavior.this.currentAnimation = null;
            }
        });
        this.currentAnimation.start();
        if (!z5) {
            this.currentAnimation.end();
        }
        return true;
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
