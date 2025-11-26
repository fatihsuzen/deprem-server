package com.google.android.gms.measurement.internal;

import N.C0722p;
import androidx.collection.LruCache;
import j$.util.Objects;

final class I2 extends LruCache {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ P2 f5917a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    I2(P2 p22, int i5) {
        super(20);
        Objects.requireNonNull(p22);
        this.f5917a = p22;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        C0722p.e(str);
        return this.f5917a.o(str);
    }
}
