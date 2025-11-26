package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

public final class R7 extends C1137k {

    /* renamed from: c  reason: collision with root package name */
    private final Callable f5167c;

    public R7(String str, Callable callable) {
        super("internal.appMetadata");
        this.f5167c = callable;
    }

    public final r a(U1 u12, List list) {
        try {
            return W2.a(this.f5167c.call());
        } catch (Exception unused) {
            return r.f5553b0;
        }
    }
}
