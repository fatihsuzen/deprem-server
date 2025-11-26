package com.google.android.material.textfield;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f7121a;

    public /* synthetic */ d(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f7121a = clearTextEndIconDelegate;
    }

    public final void run() {
        this.f7121a.animateIcon(true);
    }
}
