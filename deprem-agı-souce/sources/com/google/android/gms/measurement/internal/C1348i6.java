package com.google.android.gms.measurement.internal;

import N.C0722p;
import f0.w;
import j$.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.i6  reason: case insensitive filesystem */
final class C1348i6 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6494a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ q6 f6495b;

    C1348i6(q6 q6Var, B6 b6) {
        this.f6494a = b6;
        Objects.requireNonNull(q6Var);
        this.f6495b = q6Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        B6 b6 = this.f6494a;
        q6 q6Var = this.f6495b;
        E3 g5 = q6Var.g((String) C0722p.k(b6.f5765a));
        w wVar = w.ANALYTICS_STORAGE;
        if (g5.o(wVar) && E3.f(b6.f5783s, 100).o(wVar)) {
            return q6Var.o0(b6).p0();
        }
        q6Var.a().w().a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
