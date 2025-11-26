package com.mbridge.msdk.dycreator.baseview.cusview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class MBridgeTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f8508a;

    public MBridgeTextView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f8508a;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f8508a;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f8508a = objectAnimator;
    }

    public MBridgeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeTextView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
