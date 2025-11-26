package com.google.android.material.button;

import com.google.android.material.button.MaterialButton;

public final /* synthetic */ class e implements MaterialButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialSplitButton f6961a;

    public /* synthetic */ e(MaterialSplitButton materialSplitButton) {
        this.f6961a = materialSplitButton;
    }

    public final void onCheckedChanged(MaterialButton materialButton, boolean z4) {
        MaterialSplitButton.b(this.f6961a, materialButton, z4);
    }
}
