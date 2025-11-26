package com.google.android.gms.measurement.internal;

import f0.C1652g;
import j$.util.Objects;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class O4 extends C1652g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6011a;

    O4(C1446w5 w5Var, AtomicReference atomicReference) {
        this.f6011a = atomicReference;
        Objects.requireNonNull(w5Var);
    }

    public final void g0(List list) {
        AtomicReference atomicReference = this.f6011a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
