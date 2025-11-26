package com.google.android.material.chip;

import android.widget.CompoundButton;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f6966a;

    public /* synthetic */ b(Chip chip) {
        this.f6966a = chip;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        Chip.a(this.f6966a, compoundButton, z4);
    }
}
