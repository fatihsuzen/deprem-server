package com.google.android.gms.measurement.internal;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class S4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6078a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ B6 f6079b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6080c;

    S4(C1446w5 w5Var, AtomicReference atomicReference, B6 b6) {
        this.f6078a = atomicReference;
        this.f6079b = b6;
        Objects.requireNonNull(w5Var);
        this.f6080c = w5Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r5.f6078a
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.w5 r1 = r5.f6080c     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.E2 r3 = r2.x()     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.E3 r3 = r3.w()     // Catch:{ RemoteException -> 0x0043 }
            f0.w r4 = f0.w.ANALYTICS_STORAGE     // Catch:{ RemoteException -> 0x0043 }
            boolean r3 = r3.o(r4)     // Catch:{ RemoteException -> 0x0043 }
            if (r3 != 0) goto L_0x0045
            com.google.android.gms.measurement.internal.q2 r3 = r2.a()     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.t()     // Catch:{ RemoteException -> 0x0043 }
            java.lang.String r4 = "Analytics storage consent denied; will not get app instance id"
            r3.a(r4)     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.x4 r1 = r1.B()     // Catch:{ RemoteException -> 0x0043 }
            r3 = 0
            r1.E(r3)     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.E2 r1 = r2.x()     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.D2 r1 = r1.f5838h     // Catch:{ RemoteException -> 0x0043 }
            r1.b(r3)     // Catch:{ RemoteException -> 0x0043 }
            r0.set(r3)     // Catch:{ RemoteException -> 0x0043 }
            r0.notify()     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            goto L_0x00a7
        L_0x0041:
            r1 = move-exception
            goto L_0x00a1
        L_0x0043:
            r1 = move-exception
            goto L_0x008b
        L_0x0045:
            f0.e r3 = r1.N()     // Catch:{ RemoteException -> 0x0043 }
            if (r3 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.q2 r1 = r2.a()     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()     // Catch:{ RemoteException -> 0x0043 }
            java.lang.String r2 = "Failed to get app instance id"
            r1.a(r2)     // Catch:{ RemoteException -> 0x0043 }
            r0.notify()     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x005c:
            com.google.android.gms.measurement.internal.B6 r4 = r5.f6079b     // Catch:{ RemoteException -> 0x0043 }
            N.C0722p.k(r4)     // Catch:{ RemoteException -> 0x0043 }
            java.lang.String r3 = r3.j0(r4)     // Catch:{ RemoteException -> 0x0043 }
            r0.set(r3)     // Catch:{ RemoteException -> 0x0043 }
            java.lang.Object r3 = r0.get()     // Catch:{ RemoteException -> 0x0043 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ RemoteException -> 0x0043 }
            if (r3 == 0) goto L_0x0082
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.x4 r4 = r4.B()     // Catch:{ RemoteException -> 0x0043 }
            r4.E(r3)     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.E2 r2 = r2.x()     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.measurement.internal.D2 r2 = r2.f5838h     // Catch:{ RemoteException -> 0x0043 }
            r2.b(r3)     // Catch:{ RemoteException -> 0x0043 }
        L_0x0082:
            r1.J()     // Catch:{ RemoteException -> 0x0043 }
            java.util.concurrent.atomic.AtomicReference r1 = r5.f6078a     // Catch:{ all -> 0x003f }
        L_0x0087:
            r1.notify()     // Catch:{ all -> 0x003f }
            goto L_0x009f
        L_0x008b:
            com.google.android.gms.measurement.internal.w5 r2 = r5.f6080c     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "Failed to get app instance id"
            r2.b(r3, r1)     // Catch:{ all -> 0x0041 }
            java.util.concurrent.atomic.AtomicReference r1 = r5.f6078a     // Catch:{ all -> 0x003f }
            goto L_0x0087
        L_0x009f:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x00a1:
            java.util.concurrent.atomic.AtomicReference r2 = r5.f6078a     // Catch:{ all -> 0x003f }
            r2.notify()     // Catch:{ all -> 0x003f }
            throw r1     // Catch:{ all -> 0x003f }
        L_0x00a7:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.S4.run():void");
    }
}
