package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.g  reason: case insensitive filesystem */
public final class C1101g implements r {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5353a;

    public C1101g(Boolean bool) {
        boolean booleanValue;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.f5353a = booleanValue;
    }

    public final Double C() {
        double d5;
        if (true != this.f5353a) {
            d5 = 0.0d;
        } else {
            d5 = 1.0d;
        }
        return Double.valueOf(d5);
    }

    public final String b() {
        return Boolean.toString(this.f5353a);
    }

    public final Iterator c() {
        return null;
    }

    public final Boolean d() {
        return Boolean.valueOf(this.f5353a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C1101g) && this.f5353a == ((C1101g) obj).f5353a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f5353a).hashCode();
    }

    public final r j() {
        return new C1101g(Boolean.valueOf(this.f5353a));
    }

    public final r k(String str, U1 u12, List list) {
        if ("toString".equals(str)) {
            return new C1235v(Boolean.toString(this.f5353a));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{Boolean.toString(this.f5353a), str}));
    }

    public final String toString() {
        return String.valueOf(this.f5353a);
    }
}
