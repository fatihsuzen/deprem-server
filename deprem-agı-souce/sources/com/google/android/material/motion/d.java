package com.google.android.material.motion;

import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClippableRoundedCornerLayout f7055a;

    public /* synthetic */ d(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.f7055a = clippableRoundedCornerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7055a.updateCornerRadii((float[]) valueAnimator.getAnimatedValue());
    }
}
