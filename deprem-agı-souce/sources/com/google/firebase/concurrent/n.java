package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f7217a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f7218b;

    public /* synthetic */ n(Callable callable, p.b bVar) {
        this.f7217a = callable;
        this.f7218b = bVar;
    }

    public final void run() {
        o.d(this.f7217a, this.f7218b);
    }
}
