package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

public final /* synthetic */ class i implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f7125a;

    public /* synthetic */ i(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f7125a = dropdownMenuEndIconDelegate;
    }

    public final void onDismiss() {
        DropdownMenuEndIconDelegate.f(this.f7125a);
    }
}
