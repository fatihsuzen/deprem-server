package com.google.android.gms.measurement.internal;

import f0.C1655j;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class P4 extends C1655j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6029a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6030b;

    P4(C1446w5 w5Var, AtomicReference atomicReference) {
        this.f6029a = atomicReference;
        Objects.requireNonNull(w5Var);
        this.f6030b = w5Var;
    }

    public final void b0(Z5 z5) {
        AtomicReference atomicReference = this.f6029a;
        synchronized (atomicReference) {
            this.f6030b.f5730a.a().w().b("[sgtm] Got upload batches from service. count", Integer.valueOf(z5.f6203a.size()));
            atomicReference.set(z5);
            atomicReference.notifyAll();
        }
    }
}
