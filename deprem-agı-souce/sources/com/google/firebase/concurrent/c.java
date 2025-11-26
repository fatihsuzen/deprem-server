package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class c implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f7183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f7184d;

    public /* synthetic */ c(o oVar, Runnable runnable, long j5, TimeUnit timeUnit) {
        this.f7181a = oVar;
        this.f7182b = runnable;
        this.f7183c = j5;
        this.f7184d = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return this.f7181a.f7220b.schedule(new j(this.f7181a, this.f7182b, bVar), this.f7183c, this.f7184d);
    }
}
