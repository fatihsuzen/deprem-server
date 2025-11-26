package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.h  reason: case insensitive filesystem */
public final class C1110h implements r {

    /* renamed from: a  reason: collision with root package name */
    private final r f5363a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5364b;

    public C1110h(String str) {
        this.f5363a = r.f5553b0;
        this.f5364b = str;
    }

    public final Double C() {
        throw new IllegalStateException("Control is not a double");
    }

    public final r a() {
        return this.f5363a;
    }

    public final String b() {
        throw new IllegalStateException("Control is not a String");
    }

    public final Iterator c() {
        return null;
    }

    public final Boolean d() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final String e() {
        return this.f5364b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1110h)) {
            return false;
        }
        C1110h hVar = (C1110h) obj;
        if (!this.f5364b.equals(hVar.f5364b) || !this.f5363a.equals(hVar.f5363a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f5364b.hashCode() * 31) + this.f5363a.hashCode();
    }

    public final r j() {
        return new C1110h(this.f5364b, this.f5363a.j());
    }

    public final r k(String str, U1 u12, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public C1110h(String str, r rVar) {
        this.f5363a = rVar;
        this.f5364b = str;
    }
}
