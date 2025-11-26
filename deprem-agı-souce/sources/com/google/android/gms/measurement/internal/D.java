package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.Iterator;

final class D implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final Iterator f5815a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E f5816b;

    D(E e5) {
        Objects.requireNonNull(e5);
        this.f5816b = e5;
        this.f5815a = e5.k().keySet().iterator();
    }

    /* renamed from: a */
    public final String next() {
        return (String) this.f5815a.next();
    }

    public final boolean hasNext() {
        return this.f5815a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
