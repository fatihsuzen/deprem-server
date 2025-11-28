package com.finazzi.distquake;

import android.widget.EditText;

/* renamed from: com.finazzi.distquake.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1069b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f13689a;

    public /* synthetic */ C1069b(EditText editText) {
        this.f13689a = editText;
    }

    public final void run() {
        this.f13689a.setSelection(this.f13689a.getText().toString().length());
    }
}
