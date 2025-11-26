package com.google.android.gms.measurement.internal;

import f0.w;
import java.util.EnumMap;

/* renamed from: com.google.android.gms.measurement.internal.o  reason: case insensitive filesystem */
final class C1385o {

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f6588a;

    C1385o() {
        this.f6588a = new EnumMap(w.class);
    }

    public static C1385o d(String str) {
        EnumMap enumMap = new EnumMap(w.class);
        if (str.length() >= w.values().length) {
            int i5 = 0;
            if (str.charAt(0) == '1') {
                w[] values = w.values();
                int length = values.length;
                int i6 = 1;
                while (i5 < length) {
                    enumMap.put(values[i5], C1378n.a(str.charAt(i6)));
                    i5++;
                    i6++;
                }
                return new C1385o(enumMap);
            }
        }
        return new C1385o();
    }

    public final C1378n a(w wVar) {
        C1378n nVar = (C1378n) this.f6588a.get(wVar);
        if (nVar == null) {
            return C1378n.UNSET;
        }
        return nVar;
    }

    public final void b(w wVar, int i5) {
        C1378n nVar = C1378n.UNSET;
        if (i5 != -30) {
            if (i5 != -20) {
                if (i5 == -10) {
                    nVar = C1378n.MANIFEST;
                } else if (i5 != 0) {
                    if (i5 == 30) {
                        nVar = C1378n.INITIALIZATION;
                    }
                }
            }
            nVar = C1378n.API;
        } else {
            nVar = C1378n.TCF;
        }
        this.f6588a.put(wVar, nVar);
    }

    public final void c(w wVar, C1378n nVar) {
        this.f6588a.put(wVar, nVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (w wVar : w.values()) {
            C1378n nVar = (C1378n) this.f6588a.get(wVar);
            if (nVar == null) {
                nVar = C1378n.UNSET;
            }
            sb.append(nVar.b());
        }
        return sb.toString();
    }

    private C1385o(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(w.class);
        this.f6588a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
