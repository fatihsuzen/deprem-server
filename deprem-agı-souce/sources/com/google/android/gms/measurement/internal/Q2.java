package com.google.android.gms.measurement.internal;

import N.C0722p;
import j$.util.Objects;
import java.lang.Thread;

final class Q2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f6039a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ T2 f6040b;

    public Q2(T2 t22, String str) {
        Objects.requireNonNull(t22);
        this.f6040b = t22;
        C0722p.k(str);
        this.f6039a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f6040b.f5730a.a().o().b(this.f6039a, th);
    }
}
