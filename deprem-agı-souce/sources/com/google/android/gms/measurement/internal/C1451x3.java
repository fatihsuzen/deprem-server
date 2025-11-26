package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.x3  reason: case insensitive filesystem */
final /* synthetic */ class C1451x3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1465z3 f6864a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Bundle f6865b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f6866c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ B6 f6867d;

    /* synthetic */ C1451x3(C1465z3 z3Var, Bundle bundle, String str, B6 b6) {
        this.f6864a = z3Var;
        this.f6865b = bundle;
        this.f6866c = str;
        this.f6867d = b6;
    }

    public final /* synthetic */ void run() {
        this.f6864a.u0(this.f6865b, this.f6866c, this.f6867d);
    }
}
