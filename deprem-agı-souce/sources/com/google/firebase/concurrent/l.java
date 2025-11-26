package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7212a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f7214c;

    public /* synthetic */ l(o oVar, Runnable runnable, p.b bVar) {
        this.f7212a = oVar;
        this.f7213b = runnable;
        this.f7214c = bVar;
    }

    public final void run() {
        this.f7212a.f7219a.execute(new e(this.f7213b, this.f7214c));
    }
}
