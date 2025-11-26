package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;

abstract class HideViewOnScrollDelegate {
    HideViewOnScrollDelegate() {
    }

    /* access modifiers changed from: package-private */
    public abstract <V extends View> int getSize(@NonNull V v5, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract int getTargetTranslation();

    /* access modifiers changed from: package-private */
    public abstract int getViewEdge();

    /* access modifiers changed from: package-private */
    public abstract <V extends View> ViewPropertyAnimator getViewTranslationAnimator(@NonNull V v5, int i5);

    /* access modifiers changed from: package-private */
    public abstract <V extends View> void setAdditionalHiddenOffset(@NonNull V v5, int i5, int i6);

    /* access modifiers changed from: package-private */
    public abstract <V extends View> void setViewTranslation(@NonNull V v5, int i5);
}
