package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.j5  reason: case insensitive filesystem */
final class C1355j5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ComponentName f6508a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1405q5 f6509b;

    C1355j5(C1405q5 q5Var, ComponentName componentName) {
        this.f6508a = componentName;
        Objects.requireNonNull(q5Var);
        this.f6509b = q5Var;
    }

    public final void run() {
        this.f6509b.f6645c.K(this.f6508a);
    }
}
