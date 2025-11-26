package com.google.android.material.button;

import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class a implements MaterialShapeDrawable.OnCornerSizeChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f6958a;

    public /* synthetic */ a(MaterialButton materialButton) {
        this.f6958a = materialButton;
    }

    public final void onCornerSizeChange(float f5) {
        MaterialButton.b(this.f6958a, f5);
    }
}
