package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.m5  reason: case insensitive filesystem */
final class C1377m5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1405q5 f6554a;

    C1377m5(C1405q5 q5Var) {
        Objects.requireNonNull(q5Var);
        this.f6554a = q5Var;
    }

    public final void run() {
        C1446w5 w5Var = this.f6554a.f6645c;
        X2 x22 = w5Var.f5730a;
        Context e5 = x22.e();
        x22.c();
        w5Var.K(new ComponentName(e5, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
