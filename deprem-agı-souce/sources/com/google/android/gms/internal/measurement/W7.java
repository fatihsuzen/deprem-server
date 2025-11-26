package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.TreeMap;

public final class W7 {

    /* renamed from: a  reason: collision with root package name */
    final TreeMap f5207a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    final TreeMap f5208b = new TreeMap();

    private static final int c(U1 u12, C1191q qVar, r rVar) {
        r a5 = qVar.a(u12, Collections.singletonList(rVar));
        if (a5 instanceof C1128j) {
            return C1238v2.g(a5.C().doubleValue());
        }
        return -1;
    }

    public final void a(String str, int i5, C1191q qVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f5208b;
        } else if ("edit".equals(str2)) {
            treeMap = this.f5207a;
        } else {
            throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
        }
        if (treeMap.containsKey(Integer.valueOf(i5))) {
            i5 = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i5), qVar);
    }

    public final void b(U1 u12, C1065c cVar) {
        C1274z4 z4Var = new C1274z4(cVar);
        TreeMap treeMap = this.f5207a;
        for (Integer num : treeMap.keySet()) {
            C1056b g5 = cVar.c().clone();
            int c5 = c(u12, (C1191q) treeMap.get(num), z4Var);
            if (c5 == 2 || c5 == -1) {
                cVar.d(g5);
            }
        }
        TreeMap treeMap2 = this.f5208b;
        for (Integer num2 : treeMap2.keySet()) {
            c(u12, (C1191q) treeMap2.get(num2), z4Var);
        }
    }
}
