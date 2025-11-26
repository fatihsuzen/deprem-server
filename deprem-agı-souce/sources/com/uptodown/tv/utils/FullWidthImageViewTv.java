package com.uptodown.tv.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.t;

@SuppressLint({"AppCompatCustomView"})
public final class FullWidthImageViewTv extends ImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullWidthImageViewTv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (getDrawable() != null) {
            int size = View.MeasureSpec.getSize(i5);
            setMeasuredDimension(size, (int) Math.ceil((double) ((((float) size) * ((float) getDrawable().getIntrinsicHeight())) / ((float) getDrawable().getIntrinsicWidth()))));
            return;
        }
        super.onMeasure(i5, i6);
    }
}
