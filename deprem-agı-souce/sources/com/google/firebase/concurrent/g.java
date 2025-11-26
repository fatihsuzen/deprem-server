package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class g implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7194a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f7196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7197d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f7198e;

    public /* synthetic */ g(o oVar, Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        this.f7194a = oVar;
        this.f7195b = runnable;
        this.f7196c = j5;
        this.f7197d = j6;
        this.f7198e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.b(this.f7194a, this.f7195b, this.f7196c, this.f7197d, this.f7198e, bVar);
    }
}
