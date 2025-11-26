package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class f implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f7137a;

    public /* synthetic */ f(TimePickerView timePickerView) {
        this.f7137a = timePickerView;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i5, boolean z4) {
        TimePickerView.a(this.f7137a, materialButtonToggleGroup, i5, z4);
    }
}
