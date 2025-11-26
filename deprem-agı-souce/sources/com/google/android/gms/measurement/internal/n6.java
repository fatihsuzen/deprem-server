package com.google.android.gms.measurement.internal;

import j$.util.Objects;

final class n6 {

    /* renamed from: a  reason: collision with root package name */
    final String f6586a;

    /* renamed from: b  reason: collision with root package name */
    long f6587b;

    /* synthetic */ n6(q6 q6Var, String str, byte[] bArr) {
        this(q6Var, str);
    }

    private n6(q6 q6Var, String str) {
        Objects.requireNonNull(q6Var);
        this.f6586a = str;
        this.f6587b = q6Var.f().elapsedRealtime();
    }

    /* synthetic */ n6(q6 q6Var, byte[] bArr) {
        this(q6Var, q6Var.N0().l0());
    }
}
