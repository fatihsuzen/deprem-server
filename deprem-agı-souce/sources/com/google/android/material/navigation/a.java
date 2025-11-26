package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f7056a;

    public /* synthetic */ a(DrawerLayout drawerLayout) {
        this.f7056a = drawerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7056a.setScrimColor(ColorUtils.setAlphaComponent(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR, AnimationUtils.lerp(DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, 0, valueAnimator.getAnimatedFraction())));
    }
}
