package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.f6  reason: case insensitive filesystem */
final class C1324f6 implements C1415s2 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6417a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ List f6418b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ q6 f6419c;

    C1324f6(q6 q6Var, String str, List list) {
        this.f6417a = str;
        this.f6418b = list;
        Objects.requireNonNull(q6Var);
        this.f6419c = q6Var;
    }

    public final void a(String str, int i5, Throwable th, byte[] bArr, Map map) {
        this.f6419c.A(true, i5, th, bArr, this.f6417a, this.f6418b);
    }
}
