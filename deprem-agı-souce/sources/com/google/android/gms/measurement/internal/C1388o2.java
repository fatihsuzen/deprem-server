package com.google.android.gms.measurement.internal;

import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.o2  reason: case insensitive filesystem */
public final class C1388o2 {

    /* renamed from: a  reason: collision with root package name */
    private final int f6591a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6592b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6593c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1402q2 f6594d;

    C1388o2(C1402q2 q2Var, int i5, boolean z4, boolean z5) {
        Objects.requireNonNull(q2Var);
        this.f6594d = q2Var;
        this.f6591a = i5;
        this.f6592b = z4;
        this.f6593c = z5;
    }

    public final void a(String str) {
        this.f6594d.y(this.f6591a, this.f6592b, this.f6593c, str, (Object) null, (Object) null, (Object) null);
    }

    public final void b(String str, Object obj) {
        this.f6594d.y(this.f6591a, this.f6592b, this.f6593c, str, obj, (Object) null, (Object) null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f6594d.y(this.f6591a, this.f6592b, this.f6593c, str, obj, obj2, (Object) null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f6594d.y(this.f6591a, this.f6592b, this.f6593c, str, obj, obj2, obj3);
    }
}
