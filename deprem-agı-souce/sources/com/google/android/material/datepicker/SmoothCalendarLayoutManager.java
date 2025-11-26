package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    SmoothCalendarLayoutManager(Context context, int i5, boolean z4) {
        super(context, i5, z4);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        AnonymousClass1 r22 = new LinearSmoothScroller(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return SmoothCalendarLayoutManager.MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
            }
        };
        r22.setTargetPosition(i5);
        startSmoothScroll(r22);
    }
}
