package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class k implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f7127a;

    public /* synthetic */ k(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f7127a = dropdownMenuEndIconDelegate;
    }

    public final void onFocusChange(View view, boolean z4) {
        DropdownMenuEndIconDelegate.d(this.f7127a, view, z4);
    }
}
