package com.google.android.gms.measurement.internal;

import N.C0722p;
import j$.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class R2 extends FutureTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final long f6049a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f6050b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6051c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ T2 f6052d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    R2(T2 t22, Runnable runnable, boolean z4, String str) {
        super(runnable, (Object) null);
        Objects.requireNonNull(t22);
        this.f6052d = t22;
        C0722p.k(str);
        long andIncrement = T2.f6087k.getAndIncrement();
        this.f6049a = andIncrement;
        this.f6051c = str;
        this.f6050b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            t22.f5730a.a().o().a("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        R2 r22 = (R2) obj;
        boolean z4 = r22.f6050b;
        boolean z5 = this.f6050b;
        if (z5 == z4) {
            long j5 = this.f6049a;
            int i5 = (j5 > r22.f6049a ? 1 : (j5 == r22.f6049a ? 0 : -1));
            if (i5 < 0) {
                return -1;
            }
            if (i5 > 0) {
                return 1;
            }
            this.f6052d.f5730a.a().p().b("Two tasks share the same index. index", Long.valueOf(j5));
            return 0;
        } else if (!z5) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.f6052d.f5730a.a().o().b(this.f6051c, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    R2(T2 t22, Callable callable, boolean z4, String str) {
        super(callable);
        Objects.requireNonNull(t22);
        this.f6052d = t22;
        C0722p.k("Task exception on worker thread");
        long andIncrement = T2.f6087k.getAndIncrement();
        this.f6049a = andIncrement;
        this.f6051c = "Task exception on worker thread";
        this.f6050b = z4;
        if (andIncrement == Long.MAX_VALUE) {
            t22.f5730a.a().o().a("Tasks index overflow");
        }
    }
}
