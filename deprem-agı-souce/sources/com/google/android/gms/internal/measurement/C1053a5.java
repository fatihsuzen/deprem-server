package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.a5  reason: case insensitive filesystem */
final class C1053a5 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ T5 f5300c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1053a5(C1214s5 s5Var, String str, T5 t5) {
        super("getValue");
        this.f5300c = t5;
        Objects.requireNonNull(s5Var);
    }

    public final r a(U1 u12, List list) {
        C1238v2.a("getValue", 2, list);
        r a5 = u12.a((r) list.get(0));
        r a6 = u12.a((r) list.get(1));
        String a7 = this.f5300c.a(a5.b());
        if (a7 != null) {
            return new C1235v(a7);
        }
        return a6;
    }
}
