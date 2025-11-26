package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.u  reason: case insensitive filesystem */
final class C1226u implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f5592a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1235v f5593b;

    C1226u(C1235v vVar) {
        Objects.requireNonNull(vVar);
        this.f5593b = vVar;
    }

    public final boolean hasNext() {
        return this.f5592a < this.f5593b.f().length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        C1235v vVar = this.f5593b;
        String f5 = vVar.f();
        int i5 = this.f5592a;
        if (i5 < f5.length()) {
            this.f5592a = i5 + 1;
            return new C1235v(String.valueOf(vVar.f().charAt(i5)));
        }
        throw new NoSuchElementException();
    }
}
