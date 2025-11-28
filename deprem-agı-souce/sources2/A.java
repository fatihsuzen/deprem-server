package com.finazzi.distquake;

import android.widget.EditText;

public final /* synthetic */ class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f12488a;

    public /* synthetic */ A(EditText editText) {
        this.f12488a = editText;
    }

    public final void run() {
        this.f12488a.setSelection(this.f12488a.getText().toString().length());
    }
}
