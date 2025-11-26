package com.google.android.gms.internal.measurement;

import j$.util.Objects;

/* renamed from: com.google.android.gms.internal.measurement.k1  reason: case insensitive filesystem */
abstract class C1139k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final long f5407a;

    /* renamed from: b  reason: collision with root package name */
    final long f5408b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f5409c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1237v1 f5410d;

    C1139k1(C1237v1 v1Var, boolean z4) {
        Objects.requireNonNull(v1Var);
        this.f5410d = v1Var;
        this.f5407a = v1Var.f5600b.currentTimeMillis();
        this.f5408b = v1Var.f5600b.elapsedRealtime();
        this.f5409c = z4;
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void run() {
        if (this.f5410d.i()) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e5) {
            this.f5410d.g(e5, false, this.f5409c);
            b();
        }
    }
}
