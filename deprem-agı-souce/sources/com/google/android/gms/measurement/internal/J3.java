package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.Executor;

final class J3 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1452x4 f5935a;

    J3(C1452x4 x4Var) {
        Objects.requireNonNull(x4Var);
        this.f5935a = x4Var;
    }

    public final void execute(Runnable runnable) {
        this.f5935a.f5730a.b().t(runnable);
    }
}
