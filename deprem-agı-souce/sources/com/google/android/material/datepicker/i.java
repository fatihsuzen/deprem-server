package com.google.android.material.datepicker;

import android.view.View;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDatePicker f7040a;

    public /* synthetic */ i(MaterialDatePicker materialDatePicker) {
        this.f7040a = materialDatePicker;
    }

    public final void onClick(View view) {
        this.f7040a.onNegativeButtonClick(view);
    }
}
