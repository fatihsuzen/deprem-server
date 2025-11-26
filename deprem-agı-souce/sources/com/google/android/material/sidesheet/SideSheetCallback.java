package com.google.android.material.sidesheet;

import android.view.View;
import androidx.annotation.NonNull;

public abstract class SideSheetCallback implements SheetCallback {
    /* access modifiers changed from: package-private */
    public void onLayout(@NonNull View view) {
    }

    public abstract void onSlide(@NonNull View view, float f5);

    public abstract void onStateChanged(@NonNull View view, int i5);
}
