package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.s5  reason: case insensitive filesystem */
final /* synthetic */ class C1418s5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1446w5 f6707a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6708b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ B6 f6709c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f6710d;

    /* synthetic */ C1418s5(C1446w5 w5Var, AtomicReference atomicReference, B6 b6, Bundle bundle) {
        this.f6707a = w5Var;
        this.f6708b = atomicReference;
        this.f6709c = b6;
        this.f6710d = bundle;
    }

    public final /* synthetic */ void run() {
        this.f6707a.G(this.f6708b, this.f6709c, this.f6710d);
    }
}
