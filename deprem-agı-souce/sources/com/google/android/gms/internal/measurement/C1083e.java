package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.e  reason: case insensitive filesystem */
final class C1083e implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f5331a = 0;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1092f f5332b;

    C1083e(C1092f fVar) {
        Objects.requireNonNull(fVar);
        this.f5332b = fVar;
    }

    public final boolean hasNext() {
        if (this.f5331a < this.f5332b.o()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        C1092f fVar = this.f5332b;
        if (this.f5331a < fVar.o()) {
            int i5 = this.f5331a;
            this.f5331a = i5 + 1;
            return fVar.q(i5);
        }
        int i6 = this.f5331a;
        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i6);
        throw new NoSuchElementException(sb.toString());
    }
}
