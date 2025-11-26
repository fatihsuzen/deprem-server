package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class h implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f7200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f7201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f7202d;

    public /* synthetic */ h(o oVar, Callable callable, long j5, TimeUnit timeUnit) {
        this.f7199a = oVar;
        this.f7200b = callable;
        this.f7201c = j5;
        this.f7202d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f7199a.f7220b.schedule(new k(this.f7199a, this.f7200b, bVar), this.f7201c, this.f7202d);
    }
}
