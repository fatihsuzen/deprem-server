package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.d  reason: case insensitive filesystem */
final class C1074d implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator f5326a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Iterator f5327b;

    C1074d(C1092f fVar, Iterator it, Iterator it2) {
        this.f5326a = it;
        this.f5327b = it2;
        Objects.requireNonNull(fVar);
    }

    public final boolean hasNext() {
        if (this.f5326a.hasNext()) {
            return true;
        }
        return this.f5327b.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f5326a;
        if (it.hasNext()) {
            return new C1235v(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f5327b;
        if (it2.hasNext()) {
            return new C1235v((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
