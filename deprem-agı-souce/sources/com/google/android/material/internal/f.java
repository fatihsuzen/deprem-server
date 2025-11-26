package com.google.android.material.internal;

import android.view.View;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7052a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f7053b;

    public /* synthetic */ f(View view, boolean z4) {
        this.f7052a = view;
        this.f7053b = z4;
    }

    public final void run() {
        ViewUtils.showKeyboard(this.f7052a, this.f7053b);
    }
}
