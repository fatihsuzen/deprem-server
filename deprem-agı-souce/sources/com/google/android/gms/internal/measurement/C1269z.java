package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.z  reason: case insensitive filesystem */
public final class C1269z {

    /* renamed from: a  reason: collision with root package name */
    final Map f5706a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final M f5707b = new M();

    public C1269z() {
        a(new C1253x());
        a(new A());
        a(new B());
        a(new F());
        a(new K());
        a(new L());
        a(new N());
    }

    /* access modifiers changed from: package-private */
    public final void a(C1261y yVar) {
        for (O b5 : yVar.f5629a) {
            this.f5706a.put(b5.b().toString(), yVar);
        }
    }

    public final r b(U1 u12, r rVar) {
        C1261y yVar;
        C1238v2.l(u12);
        if (!(rVar instanceof C1208s)) {
            return rVar;
        }
        C1208s sVar = (C1208s) rVar;
        ArrayList e5 = sVar.e();
        String a5 = sVar.a();
        Map map = this.f5706a;
        if (map.containsKey(a5)) {
            yVar = (C1261y) map.get(a5);
        } else {
            yVar = this.f5707b;
        }
        return yVar.a(a5, u12, e5);
    }
}
