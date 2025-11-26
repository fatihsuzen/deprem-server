package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import m0.k;

/* renamed from: com.google.android.gms.internal.measurement.b  reason: case insensitive filesystem */
public final class C1056b {

    /* renamed from: d  reason: collision with root package name */
    private static final k f5302d = k.r("_syn", "_err", "_el");

    /* renamed from: a  reason: collision with root package name */
    private String f5303a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5304b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f5305c;

    public C1056b(String str, long j5, Map map) {
        this.f5303a = str;
        this.f5304b = j5;
        HashMap hashMap = new HashMap();
        this.f5305c = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public static Object h(String str, Object obj, Object obj2) {
        if (f5302d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final long a() {
        return this.f5304b;
    }

    public final String b() {
        return this.f5303a;
    }

    public final void c(String str) {
        this.f5303a = str;
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            this.f5305c.remove(str);
            return;
        }
        Map map = this.f5305c;
        map.put(str, h(str, map.get(str), obj));
    }

    public final Object e(String str) {
        Map map = this.f5305c;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1056b)) {
            return false;
        }
        C1056b bVar = (C1056b) obj;
        if (this.f5304b == bVar.f5304b && this.f5303a.equals(bVar.f5303a)) {
            return this.f5305c.equals(bVar.f5305c);
        }
        return false;
    }

    public final Map f() {
        return this.f5305c;
    }

    /* renamed from: g */
    public final C1056b clone() {
        return new C1056b(this.f5303a, this.f5304b, new HashMap(this.f5305c));
    }

    public final int hashCode() {
        long j5 = this.f5304b;
        return (((this.f5303a.hashCode() * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f5305c.hashCode();
    }

    public final String toString() {
        String str = this.f5303a;
        String obj = this.f5305c.toString();
        int length = String.valueOf(str).length();
        long j5 = this.f5304b;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(j5).length() + 9 + obj.length() + 1);
        sb.append("Event{name='");
        sb.append(str);
        sb.append("', timestamp=");
        sb.append(j5);
        sb.append(", params=");
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
