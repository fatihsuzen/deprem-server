package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.s  reason: case insensitive filesystem */
public final class C1208s implements r {

    /* renamed from: a  reason: collision with root package name */
    private final String f5569a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f5570b;

    public C1208s(String str, List list) {
        this.f5569a = str;
        ArrayList arrayList = new ArrayList();
        this.f5570b = arrayList;
        arrayList.addAll(list);
    }

    public final Double C() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final String a() {
        return this.f5569a;
    }

    public final String b() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final Iterator c() {
        return null;
    }

    public final Boolean d() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final ArrayList e() {
        return this.f5570b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1208s)) {
            return false;
        }
        C1208s sVar = (C1208s) obj;
        String str = this.f5569a;
        if (str == null ? sVar.f5569a == null : str.equals(sVar.f5569a)) {
            return this.f5570b.equals(sVar.f5570b);
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        String str = this.f5569a;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        return (i5 * 31) + this.f5570b.hashCode();
    }

    public final r j() {
        return this;
    }

    public final r k(String str, U1 u12, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }
}
