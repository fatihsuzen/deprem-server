package com.uptodown.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.t;

public final class FullHeightImageView extends AppCompatImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullHeightImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (getDrawable() != null) {
            int size = View.MeasureSpec.getSize(i6);
            setMeasuredDimension((int) Math.ceil((double) ((((float) size) * ((float) getDrawable().getIntrinsicWidth())) / ((float) getDrawable().getIntrinsicHeight()))), size);
            return;
        }
        super.onMeasure(i5, i6);
    }
}
