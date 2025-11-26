package com.mbridge.msdk.dycreator.baseview.cusview;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MBridgeFramLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private AnimatorSet f8476a;

    public MBridgeFramLayout(@NonNull Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f8476a;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f8476a;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f8476a = animatorSet;
    }

    public MBridgeFramLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeFramLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
