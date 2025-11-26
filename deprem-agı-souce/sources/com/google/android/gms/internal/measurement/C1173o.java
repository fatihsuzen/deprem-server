package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.o  reason: case insensitive filesystem */
public class C1173o implements r, C1164n {

    /* renamed from: a  reason: collision with root package name */
    final Map f5497a = new HashMap();

    public final Double C() {
        return Double.valueOf(Double.NaN);
    }

    public final List a() {
        return new ArrayList(this.f5497a.keySet());
    }

    public final String b() {
        return "[object Object]";
    }

    public final Iterator c() {
        return C1155m.b(this.f5497a);
    }

    public final Boolean d() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1173o)) {
            return false;
        }
        return this.f5497a.equals(((C1173o) obj).f5497a);
    }

    public final r f(String str) {
        Map map = this.f5497a;
        if (map.containsKey(str)) {
            return (r) map.get(str);
        }
        return r.f5553b0;
    }

    public final void g(String str, r rVar) {
        if (rVar == null) {
            this.f5497a.remove(str);
        } else {
            this.f5497a.put(str, rVar);
        }
    }

    public final int hashCode() {
        return this.f5497a.hashCode();
    }

    public final boolean i(String str) {
        return this.f5497a.containsKey(str);
    }

    public final r j() {
        C1173o oVar = new C1173o();
        for (Map.Entry entry : this.f5497a.entrySet()) {
            if (entry.getValue() instanceof C1164n) {
                oVar.f5497a.put((String) entry.getKey(), (r) entry.getValue());
            } else {
                oVar.f5497a.put((String) entry.getKey(), ((r) entry.getValue()).j());
            }
        }
        return oVar;
    }

    public r k(String str, U1 u12, List list) {
        if ("toString".equals(str)) {
            return new C1235v(toString());
        }
        return C1155m.a(this, new C1235v(str), u12, list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        Map map = this.f5497a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", new Object[]{str, map.get(str)}));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
