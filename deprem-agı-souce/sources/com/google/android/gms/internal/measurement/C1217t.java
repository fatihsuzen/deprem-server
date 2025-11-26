package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.t  reason: case insensitive filesystem */
final class C1217t implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f5576a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1235v f5577b;

    C1217t(C1235v vVar) {
        Objects.requireNonNull(vVar);
        this.f5577b = vVar;
    }

    public final boolean hasNext() {
        return this.f5576a < this.f5577b.f().length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        String f5 = this.f5577b.f();
        int i5 = this.f5576a;
        if (i5 < f5.length()) {
            this.f5576a = i5 + 1;
            return new C1235v(String.valueOf(i5));
        }
        throw new NoSuchElementException();
    }
}
