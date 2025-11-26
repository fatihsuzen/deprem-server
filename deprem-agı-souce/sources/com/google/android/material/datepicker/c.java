package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText[] f7036a;

    public /* synthetic */ c(EditText[] editTextArr) {
        this.f7036a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z4) {
        e.b(this.f7036a, view, z4);
    }
}
