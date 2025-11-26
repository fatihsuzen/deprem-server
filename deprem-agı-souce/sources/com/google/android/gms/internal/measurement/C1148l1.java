package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import f0.C1634B;

/* renamed from: com.google.android.gms.internal.measurement.l1  reason: case insensitive filesystem */
final class C1148l1 extends E0 {

    /* renamed from: a  reason: collision with root package name */
    private final C1634B f5430a;

    C1148l1(C1634B b5) {
        this.f5430a = b5;
    }

    public final int c() {
        return System.identityHashCode(this.f5430a);
    }

    public final void n(String str, String str2, Bundle bundle, long j5) {
        this.f5430a.a(str, str2, bundle, j5);
    }
}
