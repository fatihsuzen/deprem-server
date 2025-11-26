package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class h implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f7124a;

    public /* synthetic */ h(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f7124a = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DropdownMenuEndIconDelegate.e(this.f7124a, view, motionEvent);
    }
}
