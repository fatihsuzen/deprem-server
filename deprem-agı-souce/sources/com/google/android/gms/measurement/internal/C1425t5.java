package com.google.android.gms.measurement.internal;

import f0.N;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.t5  reason: case insensitive filesystem */
final /* synthetic */ class C1425t5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1446w5 f6736a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6737b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ B6 f6738c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ N f6739d;

    /* synthetic */ C1425t5(C1446w5 w5Var, AtomicReference atomicReference, B6 b6, N n5) {
        this.f6736a = w5Var;
        this.f6737b = atomicReference;
        this.f6738c = b6;
        this.f6739d = n5;
    }

    public final /* synthetic */ void run() {
        this.f6736a.H(this.f6737b, this.f6738c, this.f6739d);
    }
}
