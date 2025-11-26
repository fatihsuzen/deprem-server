package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f7185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f7186b;

    public /* synthetic */ d(Runnable runnable, p.b bVar) {
        this.f7185a = runnable;
        this.f7186b = bVar;
    }

    public final void run() {
        o.e(this.f7185a, this.f7186b);
    }
}
