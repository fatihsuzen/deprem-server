package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f7187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f7188b;

    public /* synthetic */ e(Runnable runnable, p.b bVar) {
        this.f7187a = runnable;
        this.f7188b = bVar;
    }

    public final void run() {
        o.h(this.f7187a, this.f7188b);
    }
}
