package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;

final class HideBottomViewOnScrollDelegate extends HideViewOnScrollDelegate {
    HideBottomViewOnScrollDelegate() {
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int getSize(@NonNull V v5, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v5.getMeasuredHeight() + marginLayoutParams.bottomMargin;
    }

    /* access modifiers changed from: package-private */
    public int getTargetTranslation() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getViewEdge() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public <V extends View> ViewPropertyAnimator getViewTranslationAnimator(@NonNull V v5, int i5) {
        return v5.animate().translationY((float) i5);
    }

    /* access modifiers changed from: package-private */
    public <V extends View> void setAdditionalHiddenOffset(@NonNull V v5, int i5, int i6) {
        v5.setTranslationY((float) (i5 + i6));
    }

    /* access modifiers changed from: package-private */
    public <V extends View> void setViewTranslation(@NonNull V v5, int i5) {
        v5.setTranslationY((float) i5);
    }
}
