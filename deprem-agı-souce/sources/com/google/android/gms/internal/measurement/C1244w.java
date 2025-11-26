package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.w  reason: case insensitive filesystem */
public final class C1244w implements r {
    public final Double C() {
        return Double.valueOf(Double.NaN);
    }

    public final String b() {
        return "undefined";
    }

    public final Iterator c() {
        return null;
    }

    public final Boolean d() {
        return Boolean.FALSE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C1244w;
    }

    public final r j() {
        return r.f5553b0;
    }

    public final r k(String str, U1 u12, List list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }
}
