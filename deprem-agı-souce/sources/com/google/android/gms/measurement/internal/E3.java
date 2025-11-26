package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import f0.v;
import f0.w;
import java.util.EnumMap;
import java.util.Map;

public final class E3 {

    /* renamed from: c  reason: collision with root package name */
    public static final E3 f5857c = new E3((Boolean) null, (Boolean) null, 100);

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f5858a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5859b;

    public E3(Boolean bool, Boolean bool2, int i5) {
        EnumMap enumMap = new EnumMap(w.class);
        this.f5858a = enumMap;
        enumMap.put(w.AD_STORAGE, h((Boolean) null));
        enumMap.put(w.ANALYTICS_STORAGE, h((Boolean) null));
        this.f5859b = i5;
    }

    public static E3 a(v vVar, v vVar2, int i5) {
        EnumMap enumMap = new EnumMap(w.class);
        enumMap.put(w.AD_STORAGE, vVar);
        enumMap.put(w.ANALYTICS_STORAGE, vVar2);
        return new E3(enumMap, -10);
    }

    static String d(int i5) {
        if (i5 == -30) {
            return "TCF";
        }
        if (i5 == -20) {
            return "API";
        }
        if (i5 == -10) {
            return "MANIFEST";
        }
        if (i5 == 0) {
            return "1P_API";
        }
        if (i5 == 30) {
            return "1P_INIT";
        }
        if (i5 != 90) {
            return i5 != 100 ? "OTHER" : "UNKNOWN";
        }
        return "REMOTE_CONFIG";
    }

    public static E3 e(Bundle bundle, int i5) {
        if (bundle == null) {
            return new E3((Boolean) null, (Boolean) null, i5);
        }
        EnumMap enumMap = new EnumMap(w.class);
        for (w wVar : D3.STORAGE.b()) {
            enumMap.put(wVar, g(bundle.getString(wVar.f15331a)));
        }
        return new E3(enumMap, i5);
    }

    public static E3 f(String str, int i5) {
        String str2;
        EnumMap enumMap = new EnumMap(w.class);
        w[] a5 = D3.STORAGE.a();
        for (int i6 = 0; i6 < a5.length; i6++) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            w wVar = a5[i6];
            int i7 = i6 + 2;
            if (i7 < str2.length()) {
                enumMap.put(wVar, j(str2.charAt(i7)));
            } else {
                enumMap.put(wVar, v.UNINITIALIZED);
            }
        }
        return new E3(enumMap, i5);
    }

    static v g(String str) {
        if (str == null) {
            return v.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return v.GRANTED;
        }
        if (str.equals("denied")) {
            return v.DENIED;
        }
        return v.UNINITIALIZED;
    }

    static v h(Boolean bool) {
        if (bool == null) {
            return v.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return v.GRANTED;
        }
        return v.DENIED;
    }

    static String i(v vVar) {
        int ordinal = vVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    static v j(char c5) {
        if (c5 == '+') {
            return v.POLICY;
        }
        if (c5 == '0') {
            return v.DENIED;
        }
        if (c5 != '1') {
            return v.UNINITIALIZED;
        }
        return v.GRANTED;
    }

    static char m(v vVar) {
        if (vVar == null) {
            return '-';
        }
        int ordinal = vVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal == 2) {
            return '0';
        }
        if (ordinal != 3) {
            return '-';
        }
        return '1';
    }

    public static boolean u(int i5, int i6) {
        int i7 = -30;
        if (i5 == -20) {
            if (i6 == -30) {
                return true;
            }
            i5 = -20;
        }
        if (i5 != -30) {
            i7 = i5;
        } else if (i6 == -20) {
            return true;
        }
        return i7 == i6 || i5 < i6;
    }

    public final int b() {
        return this.f5859b;
    }

    public final boolean c() {
        for (v vVar : this.f5858a.values()) {
            if (vVar != v.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof E3)) {
            return false;
        }
        E3 e32 = (E3) obj;
        for (w wVar : D3.STORAGE.b()) {
            if (this.f5858a.get(wVar) != e32.f5858a.get(wVar)) {
                return false;
            }
        }
        if (this.f5859b == e32.f5859b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.f5859b * 17;
        for (v hashCode : this.f5858a.values()) {
            i5 = (i5 * 31) + hashCode.hashCode();
        }
        return i5;
    }

    public final String k() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (w wVar : D3.STORAGE.a()) {
            v vVar = (v) this.f5858a.get(wVar);
            char c5 = '-';
            if (!(vVar == null || (ordinal = vVar.ordinal()) == 0)) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c5 = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c5 = '1';
            }
            sb.append(c5);
        }
        return sb.toString();
    }

    public final String l() {
        StringBuilder sb = new StringBuilder("G1");
        for (w wVar : D3.STORAGE.a()) {
            sb.append(m((v) this.f5858a.get(wVar)));
        }
        return sb.toString();
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f5858a.entrySet()) {
            String i5 = i((v) entry.getValue());
            if (i5 != null) {
                bundle.putString(((w) entry.getKey()).f15331a, i5);
            }
        }
        return bundle;
    }

    public final boolean o(w wVar) {
        if (((v) this.f5858a.get(wVar)) == v.DENIED) {
            return false;
        }
        return true;
    }

    public final v p() {
        v vVar = (v) this.f5858a.get(w.AD_STORAGE);
        if (vVar == null) {
            return v.UNINITIALIZED;
        }
        return vVar;
    }

    public final v q() {
        v vVar = (v) this.f5858a.get(w.ANALYTICS_STORAGE);
        if (vVar == null) {
            return v.UNINITIALIZED;
        }
        return vVar;
    }

    public final boolean r(E3 e32) {
        EnumMap enumMap = this.f5858a;
        for (w wVar : (w[]) enumMap.keySet().toArray(new w[0])) {
            v vVar = (v) enumMap.get(wVar);
            v vVar2 = (v) e32.f5858a.get(wVar);
            v vVar3 = v.DENIED;
            if (vVar == vVar3 && vVar2 != vVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.E3 s(com.google.android.gms.measurement.internal.E3 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<f0.w> r1 = f0.w.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.D3 r1 = com.google.android.gms.measurement.internal.D3.STORAGE
            f0.w[] r1 = r1.b()
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x004a
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f5858a
            java.lang.Object r5 = r5.get(r4)
            f0.v r5 = (f0.v) r5
            java.util.EnumMap r6 = r9.f5858a
            java.lang.Object r6 = r6.get(r4)
            f0.v r6 = (f0.v) r6
            if (r5 != 0) goto L_0x0026
            goto L_0x0033
        L_0x0026:
            if (r6 == 0) goto L_0x0042
            f0.v r7 = f0.v.UNINITIALIZED
            if (r5 != r7) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            if (r6 == r7) goto L_0x0042
            f0.v r7 = f0.v.POLICY
            if (r5 != r7) goto L_0x0035
        L_0x0033:
            r5 = r6
            goto L_0x0042
        L_0x0035:
            if (r6 == r7) goto L_0x0042
            f0.v r7 = f0.v.DENIED
            if (r5 == r7) goto L_0x0041
            if (r6 != r7) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            f0.v r5 = f0.v.GRANTED
            goto L_0x0042
        L_0x0041:
            r5 = r7
        L_0x0042:
            if (r5 == 0) goto L_0x0047
            r0.put(r4, r5)
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004a:
            com.google.android.gms.measurement.internal.E3 r9 = new com.google.android.gms.measurement.internal.E3
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.E3.s(com.google.android.gms.measurement.internal.E3):com.google.android.gms.measurement.internal.E3");
    }

    public final E3 t(E3 e32) {
        EnumMap enumMap = new EnumMap(w.class);
        for (w wVar : D3.STORAGE.b()) {
            v vVar = (v) this.f5858a.get(wVar);
            if (vVar == v.UNINITIALIZED) {
                vVar = (v) e32.f5858a.get(wVar);
            }
            if (vVar != null) {
                enumMap.put(wVar, vVar);
            }
        }
        return new E3(enumMap, this.f5859b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(d(this.f5859b));
        for (w wVar : D3.STORAGE.b()) {
            sb.append(",");
            sb.append(wVar.f15331a);
            sb.append("=");
            v vVar = (v) this.f5858a.get(wVar);
            if (vVar == null) {
                vVar = v.UNINITIALIZED;
            }
            sb.append(vVar);
        }
        return sb.toString();
    }

    private E3(EnumMap enumMap, int i5) {
        EnumMap enumMap2 = new EnumMap(w.class);
        this.f5858a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f5859b = i5;
    }
}
