package com.google.android.gms.internal.measurement;

import j$.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.measurement.g1  reason: case insensitive filesystem */
final class C1103g1 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f5356a = Executors.defaultThreadFactory();

    C1103g1(C1237v1 v1Var) {
        Objects.requireNonNull(v1Var);
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f5356a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
