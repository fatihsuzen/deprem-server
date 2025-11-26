package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f7215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f7216b;

    public /* synthetic */ m(Runnable runnable, p.b bVar) {
        this.f7215a = runnable;
        this.f7216b = bVar;
    }

    public final void run() {
        o.j(this.f7215a, this.f7216b);
    }
}
