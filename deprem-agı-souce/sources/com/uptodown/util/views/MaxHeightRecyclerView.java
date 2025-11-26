package com.uptodown.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class MaxHeightRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private int f21328a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.e(context, "context");
        this.f21328a = (int) context.getResources().getDimension(R.dimen.remote_install_devices_rv_max_height);
    }

    public final int getMaxHeightPx() {
        return this.f21328a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int i7 = this.f21328a;
        if (i7 > 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
        }
        super.onMeasure(i5, i6);
    }

    public final void setMaxHeightPx(int i5) {
        this.f21328a = i5;
    }
}
