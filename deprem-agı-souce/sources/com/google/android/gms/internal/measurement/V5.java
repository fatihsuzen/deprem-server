package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Map;

final class V5 implements Map.Entry, Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final Comparable f5191a;

    /* renamed from: b  reason: collision with root package name */
    private Object f5192b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Y5 f5193c;

    V5(Y5 y5, Comparable comparable, Object obj) {
        Objects.requireNonNull(y5);
        this.f5193c = y5;
        this.f5191a = comparable;
        this.f5192b = obj;
    }

    private static final boolean b(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 != null) {
            return false;
        }
        return true;
    }

    public final Comparable a() {
        return this.f5191a;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f5191a.compareTo(((V5) obj).f5191a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!b(this.f5191a, entry.getKey()) || !b(this.f5192b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.f5191a;
    }

    public final Object getValue() {
        return this.f5192b;
    }

    public final int hashCode() {
        int i5;
        Comparable comparable = this.f5191a;
        int i6 = 0;
        if (comparable == null) {
            i5 = 0;
        } else {
            i5 = comparable.hashCode();
        }
        Object obj = this.f5192b;
        if (obj != null) {
            i6 = obj.hashCode();
        }
        return i5 ^ i6;
    }

    public final Object setValue(Object obj) {
        this.f5193c.i();
        Object obj2 = this.f5192b;
        this.f5192b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5191a);
        String valueOf2 = String.valueOf(this.f5192b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
