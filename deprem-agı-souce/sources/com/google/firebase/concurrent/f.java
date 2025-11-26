package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class f implements p.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f7189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f7190b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f7191c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7192d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TimeUnit f7193e;

    public /* synthetic */ f(o oVar, Runnable runnable, long j5, long j6, TimeUnit timeUnit) {
        this.f7189a = oVar;
        this.f7190b = runnable;
        this.f7191c = j5;
        this.f7192d = j6;
        this.f7193e = timeUnit;
    }

    public final ScheduledFuture a(p.b bVar) {
        return o.c(this.f7189a, this.f7190b, this.f7191c, this.f7192d, this.f7193e, bVar);
    }
}
