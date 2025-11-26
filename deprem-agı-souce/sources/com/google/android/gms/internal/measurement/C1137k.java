package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.k  reason: case insensitive filesystem */
public abstract class C1137k implements r, C1164n {

    /* renamed from: a  reason: collision with root package name */
    protected final String f5405a;

    /* renamed from: b  reason: collision with root package name */
    protected final Map f5406b = new HashMap();

    public C1137k(String str) {
        this.f5405a = str;
    }

    public final Double C() {
        return Double.valueOf(Double.NaN);
    }

    public abstract r a(U1 u12, List list);

    public final String b() {
        return this.f5405a;
    }

    public final Iterator c() {
        return C1155m.b(this.f5406b);
    }

    public final Boolean d() {
        return Boolean.TRUE;
    }

    public final String e() {
        return this.f5405a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1137k)) {
            return false;
        }
        C1137k kVar = (C1137k) obj;
        String str = this.f5405a;
        if (str != null) {
            return str.equals(kVar.f5405a);
        }
        return false;
    }

    public final r f(String str) {
        Map map = this.f5406b;
        if (map.containsKey(str)) {
            return (r) map.get(str);
        }
        return r.f5553b0;
    }

    public final void g(String str, r rVar) {
        if (rVar == null) {
            this.f5406b.remove(str);
        } else {
            this.f5406b.put(str, rVar);
        }
    }

    public final int hashCode() {
        String str = this.f5405a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean i(String str) {
        return this.f5406b.containsKey(str);
    }

    public r j() {
        return this;
    }

    public final r k(String str, U1 u12, List list) {
        if ("toString".equals(str)) {
            return new C1235v(this.f5405a);
        }
        return C1155m.a(this, new C1235v(str), u12, list);
    }
}
