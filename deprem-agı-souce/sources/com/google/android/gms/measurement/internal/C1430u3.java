package com.google.android.gms.measurement.internal;

import f0.C1656k;
import f0.N;

/* renamed from: com.google.android.gms.measurement.internal.u3  reason: case insensitive filesystem */
final /* synthetic */ class C1430u3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1465z3 f6770a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6771b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ N f6772c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C1656k f6773d;

    /* synthetic */ C1430u3(C1465z3 z3Var, String str, N n5, C1656k kVar) {
        this.f6770a = z3Var;
        this.f6771b = str;
        this.f6772c = n5;
        this.f6773d = kVar;
    }

    public final /* synthetic */ void run() {
        this.f6770a.s0(this.f6771b, this.f6772c, this.f6773d);
    }
}
