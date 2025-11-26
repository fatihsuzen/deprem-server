package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class T7 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    private final C1257x3 f5180c;

    /* renamed from: d  reason: collision with root package name */
    final Map f5181d = new HashMap();

    public T7(C1257x3 x3Var) {
        super("require");
        this.f5180c = x3Var;
    }

    public final r a(U1 u12, List list) {
        r rVar;
        C1238v2.a("require", 1, list);
        String b5 = u12.a((r) list.get(0)).b();
        Map map = this.f5181d;
        if (map.containsKey(b5)) {
            return (r) map.get(b5);
        }
        Map map2 = this.f5180c.f5622a;
        if (map2.containsKey(b5)) {
            try {
                rVar = (r) ((Callable) map2.get(b5)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(b5)));
            }
        } else {
            rVar = r.f5553b0;
        }
        if (rVar instanceof C1137k) {
            this.f5181d.put(b5, (C1137k) rVar);
        }
        return rVar;
    }
}
