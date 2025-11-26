package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.g6  reason: case insensitive filesystem */
final class C1332g6 implements C1415s2 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6451a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t6 f6452b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ q6 f6453c;

    C1332g6(q6 q6Var, String str, t6 t6Var) {
        this.f6451a = str;
        this.f6452b = t6Var;
        Objects.requireNonNull(q6Var);
        this.f6453c = q6Var;
    }

    public final void a(String str, int i5, Throwable th, byte[] bArr, Map map) {
        this.f6453c.v(this.f6451a, i5, th, bArr, this.f6452b);
    }
}
