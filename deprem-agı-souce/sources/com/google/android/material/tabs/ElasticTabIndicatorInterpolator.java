package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator extends TabIndicatorInterpolator {
    ElasticTabIndicatorInterpolator() {
    }

    private static float accInterp(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return (float) (1.0d - Math.cos((((double) f5) * 3.141592653589793d) / 2.0d));
    }

    private static float decInterp(@FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return (float) Math.sin((((double) f5) * 3.141592653589793d) / 2.0d);
    }

    /* access modifiers changed from: package-private */
    public void updateIndicatorForOffset(TabLayout tabLayout, View view, View view2, float f5, @NonNull Drawable drawable) {
        float f6;
        float f7;
        RectF calculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        RectF calculateIndicatorWidthForTab2 = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view2);
        if (calculateIndicatorWidthForTab.left < calculateIndicatorWidthForTab2.left) {
            f7 = accInterp(f5);
            f6 = decInterp(f5);
        } else {
            f7 = decInterp(f5);
            f6 = accInterp(f5);
        }
        drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab.left, (int) calculateIndicatorWidthForTab2.left, f7), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab.right, (int) calculateIndicatorWidthForTab2.right, f6), drawable.getBounds().bottom);
    }
}
