package com.google.android.material.bottomappbar;

import android.view.View;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f6956a;

    public /* synthetic */ c(View view) {
        this.f6956a = view;
    }

    public final void run() {
        this.f6956a.requestLayout();
    }
}
