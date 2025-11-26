package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1270z0;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.a4  reason: case insensitive filesystem */
final class C1282a4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1270z0 f6212a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6213b;

    C1282a4(C1452x4 x4Var, C1270z0 z0Var) {
        this.f6212a = z0Var;
        Objects.requireNonNull(x4Var);
        this.f6213b = x4Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006d A[SYNTHETIC, Splitter:B:12:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.x4 r0 = r8.f6213b
            com.google.android.gms.measurement.internal.X2 r1 = r0.f5730a
            com.google.android.gms.measurement.internal.N5 r1 = r1.z()
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a
            com.google.android.gms.measurement.internal.E2 r2 = r1.x()
            com.google.android.gms.measurement.internal.E3 r2 = r2.w()
            f0.w r3 = f0.w.ANALYTICS_STORAGE
            boolean r2 = r2.o(r3)
            r3 = 0
            if (r2 != 0) goto L_0x002a
            com.google.android.gms.measurement.internal.q2 r1 = r1.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.t()
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            r1.a(r2)
        L_0x0028:
            r1 = r3
            goto L_0x005b
        L_0x002a:
            com.google.android.gms.measurement.internal.E2 r2 = r1.x()
            com.google.android.gms.common.util.d r4 = r1.f()
            long r4 = r4.currentTimeMillis()
            boolean r2 = r2.A(r4)
            if (r2 != 0) goto L_0x0028
            com.google.android.gms.measurement.internal.E2 r2 = r1.x()
            com.google.android.gms.measurement.internal.B2 r2 = r2.f5848r
            long r4 = r2.a()
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x004d
            goto L_0x0028
        L_0x004d:
            com.google.android.gms.measurement.internal.E2 r1 = r1.x()
            com.google.android.gms.measurement.internal.B2 r1 = r1.f5848r
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L_0x005b:
            if (r1 == 0) goto L_0x006d
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.internal.measurement.z0 r2 = r8.f6212a
            com.google.android.gms.measurement.internal.z6 r0 = r0.C()
            long r3 = r1.longValue()
            r0.b0(r2, r3)
            return
        L_0x006d:
            com.google.android.gms.internal.measurement.z0 r0 = r8.f6212a     // Catch:{ RemoteException -> 0x0073 }
            r0.W(r3)     // Catch:{ RemoteException -> 0x0073 }
            return
        L_0x0073:
            r0 = move-exception
            com.google.android.gms.measurement.internal.x4 r1 = r8.f6213b
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r1 = r1.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1282a4.run():void");
    }
}
