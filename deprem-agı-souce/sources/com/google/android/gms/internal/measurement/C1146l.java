package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.l  reason: case insensitive filesystem */
final class C1146l implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Iterator f5428a;

    C1146l(Iterator it) {
        this.f5428a = it;
    }

    public final boolean hasNext() {
        return this.f5428a.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return new C1235v((String) this.f5428a.next());
    }
}
