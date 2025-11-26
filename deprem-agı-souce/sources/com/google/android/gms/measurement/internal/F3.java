package com.google.android.gms.measurement.internal;

import android.util.Log;
import f0.C1658m;
import j$.util.Objects;

final class F3 implements C1658m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ X2 f5874a;

    F3(G3 g32, X2 x22) {
        this.f5874a = x22;
        Objects.requireNonNull(g32);
    }

    public final boolean A() {
        return Log.isLoggable(this.f5874a.a().z(), 3);
    }
}
