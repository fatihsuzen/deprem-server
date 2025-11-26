package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class e implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerTextInputPresenter f7136a;

    public /* synthetic */ e(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.f7136a = timePickerTextInputPresenter;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i5, boolean z4) {
        TimePickerTextInputPresenter.a(this.f7136a, materialButtonToggleGroup, i5, z4);
    }
}
