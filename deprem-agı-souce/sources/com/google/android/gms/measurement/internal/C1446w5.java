package com.google.android.gms.measurement.internal;

import K.C0665l;
import N.C0722p;
import R.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.measurement.C1270z0;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.C1646a;
import f0.C1650e;
import f0.N;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.w5  reason: case insensitive filesystem */
public final class C1446w5 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    private final C1405q5 f6848c;

    /* renamed from: d  reason: collision with root package name */
    private C1650e f6849d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f6850e;

    /* renamed from: f  reason: collision with root package name */
    private final C1447x f6851f;

    /* renamed from: g  reason: collision with root package name */
    private ScheduledExecutorService f6852g;

    /* renamed from: h  reason: collision with root package name */
    private final R5 f6853h;

    /* renamed from: i  reason: collision with root package name */
    private final List f6854i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final C1447x f6855j;

    protected C1446w5(X2 x22) {
        super(x22);
        this.f6853h = new R5(x22.f());
        this.f6848c = new C1405q5(this);
        this.f6851f = new W4(this, x22);
        this.f6855j = new C1283a5(this, x22);
    }

    private final boolean R() {
        this.f5730a.c();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public final void J() {
        h();
        this.f6853h.a();
        this.f5730a.w();
        this.f6851f.b(((Long) C1304d2.f6310Z.b((Object) null)).longValue());
    }

    private final void T(Runnable runnable) {
        h();
        if (W()) {
            runnable.run();
            return;
        }
        List list = this.f6854i;
        X2 x22 = this.f5730a;
        x22.w();
        if (((long) list.size()) >= 1000) {
            x22.a().o().a("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.f6855j.b(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        w();
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public final void L() {
        h();
        C1388o2 w4 = this.f5730a.a().w();
        List<Runnable> list = this.f6854i;
        w4.b("Processing queued up service tasks", Integer.valueOf(list.size()));
        for (Runnable run : list) {
            try {
                run.run();
            } catch (RuntimeException e5) {
                this.f5730a.a().o().b("Task exception while flushing queue", e5);
            }
        }
        this.f6854i.clear();
        this.f6855j.d();
    }

    private final B6 V(boolean z4) {
        Pair b5;
        X2 x22 = this.f5730a;
        x22.c();
        C1328g2 L4 = this.f5730a.L();
        String str = null;
        if (z4) {
            X2 x23 = x22.a().f5730a;
            if (!(x23.x().f5835e == null || (b5 = x23.x().f5835e.b()) == null || b5 == E2.f5832A)) {
                String valueOf = String.valueOf(b5.second);
                String str2 = (String) b5.first;
                StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(":");
                sb.append(str2);
                str = sb.toString();
            }
        }
        return L4.o(str);
    }

    public final void A() {
        h();
        j();
        C1405q5 q5Var = this.f6848c;
        q5Var.b();
        try {
            b.b().c(this.f5730a.e(), q5Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f6849d = null;
    }

    public final void B(C1270z0 z0Var, G g5, String str) {
        h();
        j();
        X2 x22 = this.f5730a;
        if (x22.C().X(C0665l.f2721a) != 0) {
            x22.a().r().a("Not bundling data. Service unavailable or out of date");
            x22.C().d0(z0Var, new byte[0]);
            return;
        }
        T(new Z4(this, g5, str, z0Var));
    }

    /* access modifiers changed from: package-private */
    public final boolean C() {
        h();
        j();
        if (!y() || this.f5730a.C().W() >= ((Integer) C1304d2.f6281K0.b((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean D() {
        h();
        j();
        if (!y() || this.f5730a.C().W() >= 241200) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void E() {
        C1650e eVar = this.f6849d;
        if (eVar == null) {
            this.f5730a.a().o().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            B6 V4 = V(false);
            C0722p.k(V4);
            eVar.F(V4);
            J();
        } catch (RemoteException e5) {
            this.f5730a.a().o().b("Failed to send storage consent settings to the service", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void F() {
        C1650e eVar = this.f6849d;
        if (eVar == null) {
            this.f5730a.a().o().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            B6 V4 = V(false);
            C0722p.k(V4);
            eVar.K(V4);
            J();
        } catch (RemoteException e5) {
            this.f5730a.a().o().b("Failed to send Dma consent settings to the service", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void G(AtomicReference atomicReference, B6 b6, Bundle bundle) {
        synchronized (atomicReference) {
            try {
                C1650e eVar = this.f6849d;
                if (eVar == null) {
                    this.f5730a.a().o().a("Failed to request trigger URIs; not connected to service");
                    return;
                }
                C0722p.k(b6);
                eVar.X(b6, bundle, new O4(this, atomicReference));
                J();
            } catch (RemoteException e5) {
                this.f5730a.a().o().b("Failed to request trigger URIs; remote exception", e5);
                atomicReference.notifyAll();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void H(AtomicReference atomicReference, B6 b6, N n5) {
        synchronized (atomicReference) {
            try {
                C1650e eVar = this.f6849d;
                if (eVar == null) {
                    this.f5730a.a().o().a("[sgtm] Failed to get upload batches; not connected to service");
                    return;
                }
                C0722p.k(b6);
                eVar.V(b6, n5, new P4(this, atomicReference));
                J();
            } catch (RemoteException e5) {
                this.f5730a.a().o().b("[sgtm] Failed to get upload batches; remote exception", e5);
                atomicReference.notifyAll();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void I(B6 b6, C1325g gVar) {
        C1650e eVar = this.f6849d;
        if (eVar == null) {
            this.f5730a.a().o().a("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            eVar.N(b6, gVar);
            J();
        } catch (RemoteException e5) {
            this.f5730a.a().o().c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(gVar.f6420a), e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void K(ComponentName componentName) {
        h();
        if (this.f6849d != null) {
            this.f6849d = null;
            this.f5730a.a().w().b("Disconnected from device MeasurementService", componentName);
            h();
            w();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1405q5 M() {
        return this.f6848c;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1650e N() {
        return this.f6849d;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(C1650e eVar) {
        this.f6849d = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ScheduledExecutorService P() {
        return this.f6852g;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Q(ScheduledExecutorService scheduledExecutorService) {
        this.f6852g = scheduledExecutorService;
    }

    public final boolean W() {
        h();
        j();
        if (this.f6849d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void X() {
        h();
        j();
        T(new C1291b5(this, V(true)));
    }

    /* access modifiers changed from: protected */
    public final void Y(boolean z4) {
        h();
        j();
        if (C()) {
            T(new C1299c5(this, V(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final void Z(boolean z4) {
        h();
        j();
        T(new C1439v5(this));
    }

    /* access modifiers changed from: protected */
    public final void a0() {
        h();
        j();
        T(new C1411r5(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b0(f0.C1650e r59, O.C0732a r60, com.google.android.gms.measurement.internal.B6 r61) {
        /*
            r58 = this;
            r1 = r58
            r2 = r59
            r3 = r60
            r1.h()
            r1.j()
            r1.R()
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a
            r4.w()
            r6 = 100
            r0 = r61
            r8 = r6
            r7 = 0
        L_0x001a:
            r9 = 1001(0x3e9, float:1.403E-42)
            if (r7 >= r9) goto L_0x0226
            if (r8 != r6) goto L_0x0226
            com.google.android.gms.measurement.internal.X2 r8 = r1.f5730a
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.google.android.gms.measurement.internal.i2 r8 = r8.E()
            java.util.List r8 = r8.t(r6)
            if (r8 == 0) goto L_0x0039
            r9.addAll(r8)
            int r8 = r8.size()
            goto L_0x003a
        L_0x0039:
            r8 = 0
        L_0x003a:
            if (r3 == 0) goto L_0x004a
            if (r8 >= r6) goto L_0x004a
            java.lang.String r10 = r0.f5767c
            long r11 = r0.f5774j
            f0.l r13 = new f0.l
            r13.<init>(r3, r10, r11)
            r9.add(r13)
        L_0x004a:
            com.google.android.gms.measurement.internal.m r10 = r4.w()
            com.google.android.gms.measurement.internal.c2 r11 = com.google.android.gms.measurement.internal.C1304d2.f6291P0
            r12 = 0
            boolean r10 = r10.H(r12, r11)
            int r11 = r9.size()
            r13 = 0
        L_0x005a:
            if (r13 >= r11) goto L_0x021c
            java.lang.Object r14 = r9.get(r13)
            f0.l r14 = (f0.C1657l) r14
            O.a r15 = r14.f15316a
            com.google.android.gms.measurement.internal.m r5 = r4.w()
            com.google.android.gms.measurement.internal.c2 r6 = com.google.android.gms.measurement.internal.C1304d2.f6320c1
            boolean r5 = r5.H(r12, r6)
            if (r5 == 0) goto L_0x00fe
            java.lang.String r5 = r14.f15317b
            boolean r16 = android.text.TextUtils.isEmpty(r5)
            if (r16 != 0) goto L_0x00fe
            r56 = r13
            long r12 = r14.f15318c
            java.lang.String r14 = r0.f5765a
            java.lang.String r3 = r0.f5766b
            r18 = r3
            java.lang.String r3 = r0.f5768d
            r22 = r3
            r57 = r4
            long r3 = r0.f5769e
            r23 = r3
            long r3 = r0.f5770f
            r25 = r3
            java.lang.String r3 = r0.f5771g
            boolean r4 = r0.f5772h
            r27 = r3
            boolean r3 = r0.f5773i
            r29 = r3
            java.lang.String r3 = r0.f5775k
            r30 = r3
            r28 = r4
            long r3 = r0.f5776l
            r31 = r3
            int r3 = r0.f5777m
            boolean r4 = r0.f5778n
            r33 = r3
            boolean r3 = r0.f5779o
            r35 = r3
            java.lang.Boolean r3 = r0.f5780p
            r36 = r3
            r34 = r4
            long r3 = r0.f5781q
            r37 = r3
            java.util.List r3 = r0.f5782r
            java.lang.String r4 = r0.f5783s
            r39 = r3
            java.lang.String r3 = r0.f5784t
            r41 = r3
            java.lang.String r3 = r0.f5785u
            r42 = r3
            boolean r3 = r0.f5786v
            r43 = r3
            r40 = r4
            long r3 = r0.f5787w
            r44 = r3
            int r3 = r0.f5788x
            java.lang.String r4 = r0.f5789y
            r46 = r3
            int r3 = r0.f5790z
            r48 = r3
            r47 = r4
            long r3 = r0.f5760A
            r49 = r3
            java.lang.String r3 = r0.f5761B
            java.lang.String r4 = r0.f5762C
            r51 = r3
            r52 = r4
            long r3 = r0.f5763D
            int r0 = r0.f5764E
            com.google.android.gms.measurement.internal.B6 r16 = new com.google.android.gms.measurement.internal.B6
            r55 = r0
            r53 = r3
            r19 = r5
            r20 = r12
            r17 = r14
            r16.<init>((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (long) r20, (java.lang.String) r22, (long) r23, (long) r25, (java.lang.String) r27, (boolean) r28, (boolean) r29, (java.lang.String) r30, (long) r31, (int) r33, (boolean) r34, (boolean) r35, (java.lang.Boolean) r36, (long) r37, (java.util.List) r39, (java.lang.String) r40, (java.lang.String) r41, (java.lang.String) r42, (boolean) r43, (long) r44, (int) r46, (java.lang.String) r47, (int) r48, (long) r49, (java.lang.String) r51, (java.lang.String) r52, (long) r53, (int) r55)
            r3 = r16
            goto L_0x0103
        L_0x00fe:
            r57 = r4
            r56 = r13
            r3 = r0
        L_0x0103:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.G
            if (r0 == 0) goto L_0x01a1
            r4 = 0
            if (r10 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ RemoteException -> 0x0127 }
            com.google.android.gms.common.util.d r6 = r0.f()     // Catch:{ RemoteException -> 0x0127 }
            long r12 = r6.currentTimeMillis()     // Catch:{ RemoteException -> 0x0127 }
            com.google.android.gms.common.util.d r0 = r0.f()     // Catch:{ RemoteException -> 0x0122 }
            long r16 = r0.elapsedRealtime()     // Catch:{ RemoteException -> 0x0122 }
            r19 = r12
            r12 = r16
            goto L_0x012f
        L_0x0122:
            r0 = move-exception
            r19 = r12
            r12 = r4
            goto L_0x0169
        L_0x0127:
            r0 = move-exception
            r12 = r4
            r19 = r12
            goto L_0x0169
        L_0x012c:
            r12 = r4
            r19 = r12
        L_0x012f:
            com.google.android.gms.measurement.internal.G r15 = (com.google.android.gms.measurement.internal.G) r15     // Catch:{ RemoteException -> 0x0168 }
            r2.I(r15, r3)     // Catch:{ RemoteException -> 0x0168 }
            if (r10 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.q2 r0 = r57.a()     // Catch:{ RemoteException -> 0x0168 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ RemoteException -> 0x0168 }
            java.lang.String r6 = "Logging telemetry for logEvent from database"
            r0.a(r6)     // Catch:{ RemoteException -> 0x0168 }
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ RemoteException -> 0x0168 }
            com.google.android.gms.measurement.internal.m2 r16 = com.google.android.gms.measurement.internal.C1374m2.a(r0)     // Catch:{ RemoteException -> 0x0168 }
            com.google.android.gms.common.util.d r6 = r0.f()     // Catch:{ RemoteException -> 0x0168 }
            long r21 = r6.currentTimeMillis()     // Catch:{ RemoteException -> 0x0168 }
            com.google.android.gms.common.util.d r0 = r0.f()     // Catch:{ RemoteException -> 0x0168 }
            long r14 = r0.elapsedRealtime()     // Catch:{ RemoteException -> 0x0168 }
            long r14 = r14 - r12
            int r0 = (int) r14     // Catch:{ RemoteException -> 0x0168 }
            r17 = 36301(0x8dcd, float:5.0869E-41)
            r18 = 0
            r23 = r0
            r16.b(r17, r18, r19, r21, r23)     // Catch:{ RemoteException -> 0x0168 }
        L_0x0165:
            r5 = 0
            goto L_0x0210
        L_0x0168:
            r0 = move-exception
        L_0x0169:
            com.google.android.gms.measurement.internal.X2 r6 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()
            java.lang.String r14 = "Failed to send event to the service"
            r6.b(r14, r0)
            if (r10 == 0) goto L_0x0165
            int r0 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.m2 r16 = com.google.android.gms.measurement.internal.C1374m2.a(r0)
            com.google.android.gms.common.util.d r4 = r0.f()
            long r21 = r4.currentTimeMillis()
            com.google.android.gms.common.util.d r0 = r0.f()
            long r4 = r0.elapsedRealtime()
            long r4 = r4 - r12
            int r0 = (int) r4
            r17 = 36301(0x8dcd, float:5.0869E-41)
            r18 = 13
            r23 = r0
            r16.b(r17, r18, r19, r21, r23)
            goto L_0x0165
        L_0x01a1:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.v6
            if (r0 == 0) goto L_0x01bc
            com.google.android.gms.measurement.internal.v6 r15 = (com.google.android.gms.measurement.internal.v6) r15     // Catch:{ RemoteException -> 0x01ab }
            r2.S(r15, r3)     // Catch:{ RemoteException -> 0x01ab }
            goto L_0x0165
        L_0x01ab:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.String r5 = "Failed to send user property to the service"
            r4.b(r5, r0)
            goto L_0x0165
        L_0x01bc:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.C1341i
            if (r0 == 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.i r15 = (com.google.android.gms.measurement.internal.C1341i) r15     // Catch:{ RemoteException -> 0x01c6 }
            r2.p(r15, r3)     // Catch:{ RemoteException -> 0x01c6 }
            goto L_0x0165
        L_0x01c6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.String r5 = "Failed to send conditional user property to the service"
            r4.b(r5, r0)
            goto L_0x0165
        L_0x01d7:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.m r4 = r0.w()
            r5 = 0
            boolean r4 = r4.H(r5, r6)
            if (r4 == 0) goto L_0x0203
            boolean r4 = r15 instanceof com.google.android.gms.measurement.internal.E
            if (r4 == 0) goto L_0x0203
            com.google.android.gms.measurement.internal.E r15 = (com.google.android.gms.measurement.internal.E) r15     // Catch:{ RemoteException -> 0x01f2 }
            android.os.Bundle r0 = r15.j()     // Catch:{ RemoteException -> 0x01f2 }
            r2.U(r0, r3)     // Catch:{ RemoteException -> 0x01f2 }
            goto L_0x0210
        L_0x01f2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.String r6 = "Failed to send default event parameters to the service"
            r4.b(r6, r0)
            goto L_0x0210
        L_0x0203:
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r4 = "Discarding data. Unrecognized parcel type."
            r0.a(r4)
        L_0x0210:
            int r13 = r56 + 1
            r0 = r3
            r12 = r5
            r4 = r57
            r6 = 100
            r3 = r60
            goto L_0x005a
        L_0x021c:
            r57 = r4
            int r7 = r7 + 1
            r3 = r60
            r6 = 100
            goto L_0x001a
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1446w5.b0(f0.e, O.a, com.google.android.gms.measurement.internal.B6):void");
    }

    /* access modifiers changed from: protected */
    public final void c0(G g5, String str) {
        C0722p.k(g5);
        h();
        j();
        R();
        T(new C1307d5(this, true, V(true), this.f5730a.E().p(g5), g5, str));
    }

    /* access modifiers changed from: protected */
    public final void d0(C1341i iVar) {
        C0722p.k(iVar);
        h();
        j();
        this.f5730a.c();
        T(new C1315e5(this, true, V(true), this.f5730a.E().r(iVar), new C1341i(iVar), iVar));
    }

    /* access modifiers changed from: protected */
    public final void e0(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        j();
        T(new C1323f5(this, atomicReference, (String) null, str2, str3, V(false)));
    }

    /* access modifiers changed from: protected */
    public final void f0(C1270z0 z0Var, String str, String str2) {
        h();
        j();
        T(new C1331g5(this, str, str2, V(false), z0Var));
    }

    /* access modifiers changed from: protected */
    public final void g0(AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        h();
        j();
        T(new C1339h5(this, atomicReference, (String) null, str2, str3, V(false), z4));
    }

    /* access modifiers changed from: protected */
    public final void h0(C1270z0 z0Var, String str, String str2, boolean z4) {
        h();
        j();
        T(new N4(this, str, str2, V(false), z4, z0Var));
    }

    /* access modifiers changed from: protected */
    public final void i0(AtomicReference atomicReference, Bundle bundle) {
        h();
        j();
        T(new C1418s5(this, atomicReference, V(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void j0(AtomicReference atomicReference, N n5) {
        h();
        j();
        T(new C1425t5(this, atomicReference, V(false), n5));
    }

    /* access modifiers changed from: protected */
    public final void k0(C1325g gVar) {
        h();
        j();
        B6 V4 = V(true);
        C0722p.k(V4);
        T(new C1432u5(this, V4, gVar));
    }

    /* access modifiers changed from: protected */
    public final C1646a l0() {
        h();
        j();
        C1650e eVar = this.f6849d;
        if (eVar == null) {
            w();
            this.f5730a.a().v().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        B6 V4 = V(false);
        C0722p.k(V4);
        try {
            C1646a T4 = eVar.T(V4);
            J();
            return T4;
        } catch (RemoteException e5) {
            this.f5730a.a().o().b("Failed to get consents; remote exception", e5);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void o(v6 v6Var) {
        h();
        j();
        R();
        T(new Q4(this, V(true), this.f5730a.E().q(v6Var), v6Var));
    }

    /* access modifiers changed from: protected */
    public final void p() {
        h();
        j();
        B6 V4 = V(false);
        R();
        this.f5730a.E().o();
        T(new R4(this, V4));
    }

    public final void q(AtomicReference atomicReference) {
        h();
        j();
        T(new S4(this, atomicReference, V(false)));
    }

    public final void r(C1270z0 z0Var) {
        h();
        j();
        T(new T4(this, V(false), z0Var));
    }

    /* access modifiers changed from: protected */
    public final void s() {
        h();
        j();
        B6 V4 = V(true);
        R();
        this.f5730a.w().H((String) null, C1304d2.f6320c1);
        this.f5730a.E().u();
        T(new U4(this, V4, true));
    }

    /* access modifiers changed from: protected */
    public final void t() {
        h();
        j();
        T(new V4(this, V(true)));
    }

    /* access modifiers changed from: protected */
    public final void u(E4 e42) {
        h();
        j();
        T(new X4(this, e42));
    }

    public final void v(Bundle bundle) {
        boolean z4;
        h();
        j();
        E e5 = new E(bundle);
        R();
        if (!this.f5730a.w().H((String) null, C1304d2.f6320c1) || !this.f5730a.E().s(e5)) {
            z4 = false;
        } else {
            z4 = true;
        }
        T(new Y4(this, true, V(false), z4, e5, bundle));
    }

    /* access modifiers changed from: package-private */
    public final void w() {
        h();
        j();
        if (!W()) {
            if (!y()) {
                X2 x22 = this.f5730a;
                if (!x22.w().m()) {
                    x22.c();
                    List<ResolveInfo> queryIntentServices = x22.e().getPackageManager().queryIntentServices(new Intent().setClassName(x22.e(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        x22.a().o().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                        return;
                    }
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context e5 = x22.e();
                    x22.c();
                    intent.setComponent(new ComponentName(e5, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.f6848c.a(intent);
                    return;
                }
                return;
            }
            this.f6848c.c();
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean x() {
        return this.f6850e;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean y() {
        /*
            r8 = this;
            r8.h()
            r8.j()
            java.lang.Boolean r0 = r8.f6850e
            if (r0 != 0) goto L_0x0130
            r8.h()
            r8.j()
            com.google.android.gms.measurement.internal.X2 r0 = r8.f5730a
            com.google.android.gms.measurement.internal.E2 r1 = r0.x()
            r1.h()
            android.content.SharedPreferences r2 = r1.p()
            java.lang.String r3 = "use_service"
            boolean r2 = r2.contains(r3)
            r4 = 0
            if (r2 != 0) goto L_0x0028
            r1 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r1 = r1.p()
            boolean r1 = r1.getBoolean(r3, r4)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0034:
            r2 = 1
            if (r1 == 0) goto L_0x003f
            boolean r5 = r1.booleanValue()
            if (r5 == 0) goto L_0x003f
            goto L_0x012a
        L_0x003f:
            r0.c()
            com.google.android.gms.measurement.internal.X2 r5 = r8.f5730a
            com.google.android.gms.measurement.internal.g2 r5 = r5.L()
            int r5 = r5.v()
            if (r5 != r2) goto L_0x0051
        L_0x004e:
            r4 = r2
            goto L_0x00f8
        L_0x0051:
            com.google.android.gms.measurement.internal.q2 r5 = r0.a()
            com.google.android.gms.measurement.internal.o2 r5 = r5.w()
            java.lang.String r6 = "Checking service availability"
            r5.a(r6)
            com.google.android.gms.measurement.internal.z6 r5 = r0.C()
            r6 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r5 = r5.X(r6)
            if (r5 == 0) goto L_0x00e9
            if (r5 == r2) goto L_0x00db
            r6 = 2
            if (r5 == r6) goto L_0x00b9
            r1 = 3
            if (r5 == r1) goto L_0x00ab
            r1 = 9
            if (r5 == r1) goto L_0x009d
            r1 = 18
            if (r5 == r1) goto L_0x008f
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = "Unexpected service status"
            r1.b(r5, r2)
        L_0x008c:
            r2 = r4
            goto L_0x00f8
        L_0x008f:
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()
            java.lang.String r4 = "Service updating"
            r1.a(r4)
            goto L_0x004e
        L_0x009d:
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()
            java.lang.String r2 = "Service invalid"
            r1.a(r2)
            goto L_0x008c
        L_0x00ab:
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()
            java.lang.String r2 = "Service disabled"
            r1.a(r2)
            goto L_0x008c
        L_0x00b9:
            com.google.android.gms.measurement.internal.q2 r5 = r0.a()
            com.google.android.gms.measurement.internal.o2 r5 = r5.v()
            java.lang.String r6 = "Service container out of date"
            r5.a(r6)
            com.google.android.gms.measurement.internal.z6 r5 = r0.C()
            int r5 = r5.W()
            r6 = 17443(0x4423, float:2.4443E-41)
            if (r5 >= r6) goto L_0x00d3
            goto L_0x00f8
        L_0x00d3:
            if (r1 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            r7 = r4
            r4 = r2
            r2 = r7
            goto L_0x00f8
        L_0x00db:
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            java.lang.String r5 = "Service missing"
            r1.a(r5)
            goto L_0x00f8
        L_0x00e9:
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            java.lang.String r4 = "Service available"
            r1.a(r4)
            goto L_0x004e
        L_0x00f8:
            if (r4 != 0) goto L_0x0112
            com.google.android.gms.measurement.internal.m r1 = r0.w()
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x0112
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r1)
            goto L_0x0129
        L_0x0112:
            if (r2 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.E2 r0 = r0.x()
            r0.h()
            android.content.SharedPreferences r0 = r0.p()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r3, r4)
            r0.apply()
        L_0x0129:
            r2 = r4
        L_0x012a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r8.f6850e = r0
        L_0x0130:
            java.lang.Boolean r0 = r8.f6850e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1446w5.y():boolean");
    }

    /* access modifiers changed from: protected */
    public final void z(C1650e eVar) {
        h();
        C0722p.k(eVar);
        this.f6849d = eVar;
        J();
        L();
    }
}
