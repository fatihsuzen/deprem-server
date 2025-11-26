package com.google.android.material.textfield;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f7131a;

    public /* synthetic */ v(TextInputLayout textInputLayout) {
        this.f7131a = textInputLayout;
    }

    public final void run() {
        this.f7131a.editText.requestLayout();
    }
}
