package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.NoSuchElementException;

final class A4 extends B4 {

    /* renamed from: a  reason: collision with root package name */
    private int f4921a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f4922b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ H4 f4923c;

    A4(H4 h42) {
        Objects.requireNonNull(h42);
        this.f4923c = h42;
        this.f4922b = h42.f();
    }

    public final byte A() {
        int i5 = this.f4921a;
        if (i5 < this.f4922b) {
            this.f4921a = i5 + 1;
            return this.f4923c.d(i5);
        }
        throw new NoSuchElementException();
    }

    public final boolean hasNext() {
        return this.f4921a < this.f4922b;
    }
}
