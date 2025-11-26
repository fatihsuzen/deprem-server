package com.google.android.gms.measurement.internal;

import K.C0655b;
import N.C0709c;
import N.C0722p;
import R.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import f0.C1650e;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.q5  reason: case insensitive filesystem */
public final class C1405q5 implements ServiceConnection, C0709c.a, C0709c.b {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f6643a;

    /* renamed from: b  reason: collision with root package name */
    private volatile C1360k2 f6644b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6645c;

    protected C1405q5(C1446w5 w5Var) {
        Objects.requireNonNull(w5Var);
        this.f6645c = w5Var;
    }

    public final void a(Intent intent) {
        C1446w5 w5Var = this.f6645c;
        w5Var.h();
        Context e5 = w5Var.f5730a.e();
        b b5 = b.b();
        synchronized (this) {
            try {
                if (this.f6643a) {
                    this.f6645c.f5730a.a().w().a("Connection attempt already in progress");
                    return;
                }
                C1446w5 w5Var2 = this.f6645c;
                w5Var2.f5730a.a().w().a("Using local app measurement service");
                this.f6643a = true;
                b5.a(e5, intent, w5Var2.M(), TsExtractor.TS_STREAM_TYPE_AC3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        if (this.f6644b != null && (this.f6644b.h() || this.f6644b.f())) {
            this.f6644b.b();
        }
        this.f6644b = null;
    }

    public final void c() {
        C1446w5 w5Var = this.f6645c;
        w5Var.h();
        Context e5 = w5Var.f5730a.e();
        synchronized (this) {
            try {
                if (this.f6643a) {
                    this.f6645c.f5730a.a().w().a("Connection attempt already in progress");
                } else if (this.f6644b == null || (!this.f6644b.f() && !this.f6644b.h())) {
                    this.f6644b = new C1360k2(e5, Looper.getMainLooper(), this, this);
                    this.f6645c.f5730a.a().w().a("Connecting to remote service");
                    this.f6643a = true;
                    C0722p.k(this.f6644b);
                    this.f6644b.q();
                } else {
                    this.f6645c.f5730a.a().w().a("Already awaiting connection attempt");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(boolean z4) {
        this.f6643a = false;
    }

    public final void i(int i5) {
        X2 x22 = this.f6645c.f5730a;
        x22.b().o();
        x22.a().v().a("Service connection suspended");
        x22.b().t(new C1377m5(this));
    }

    public final void j(C0655b bVar) {
        C1446w5 w5Var = this.f6645c;
        w5Var.f5730a.b().o();
        C1402q2 y4 = w5Var.f5730a.y();
        if (y4 != null) {
            y4.w().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.f6643a = false;
            this.f6644b = null;
        }
        this.f6645c.f5730a.b().t(new C1398p5(this, bVar));
    }

    public final void k(Bundle bundle) {
        this.f6645c.f5730a.b().o();
        synchronized (this) {
            try {
                C0722p.k(this.f6644b);
                this.f6645c.f5730a.b().t(new C1370l5(this, (C1650e) this.f6644b.D()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f6644b = null;
                this.f6643a = false;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.f6645c.f5730a.a().o().a("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.w5 r4 = r3.f6645c
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a
            com.google.android.gms.measurement.internal.T2 r4 = r4.b()
            r4.o()
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x0027
            r3.f6643a = r4     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.w5 r4 = r3.f6645c     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = "Service connected with null binder"
            r4.a(r5)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x00a7
        L_0x0027:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x006c }
            if (r2 == 0) goto L_0x005a
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x006c }
            boolean r2 = r1 instanceof f0.C1650e     // Catch:{ RemoteException -> 0x006c }
            if (r2 == 0) goto L_0x0042
            f0.e r1 = (f0.C1650e) r1     // Catch:{ RemoteException -> 0x006c }
        L_0x0040:
            r0 = r1
            goto L_0x0048
        L_0x0042:
            com.google.android.gms.measurement.internal.e2 r1 = new com.google.android.gms.measurement.internal.e2     // Catch:{ RemoteException -> 0x006c }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x0040
        L_0x0048:
            com.google.android.gms.measurement.internal.w5 r5 = r3.f6645c     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.X2 r5 = r5.f5730a     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.o2 r5 = r5.w()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.a(r1)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x007d
        L_0x005a:
            com.google.android.gms.measurement.internal.w5 r5 = r3.f6645c     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.X2 r5 = r5.f5730a     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.b(r2, r1)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x007d
        L_0x006c:
            com.google.android.gms.measurement.internal.w5 r5 = r3.f6645c     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.X2 r5 = r5.f5730a     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.a(r1)     // Catch:{ all -> 0x0024 }
        L_0x007d:
            if (r0 != 0) goto L_0x0095
            r3.f6643a = r4     // Catch:{ all -> 0x0024 }
            R.b r4 = R.b.b()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.w5 r5 = r3.f6645c     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.X2 r0 = r5.f5730a     // Catch:{ IllegalArgumentException -> 0x00a5 }
            android.content.Context r0 = r0.e()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.q5 r5 = r5.M()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            r4.c(r0, r5)     // Catch:{ IllegalArgumentException -> 0x00a5 }
            goto L_0x00a5
        L_0x0095:
            com.google.android.gms.measurement.internal.w5 r4 = r3.f6645c     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.T2 r4 = r4.b()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.i5 r5 = new com.google.android.gms.measurement.internal.i5     // Catch:{ all -> 0x0024 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0024 }
            r4.t(r5)     // Catch:{ all -> 0x0024 }
        L_0x00a5:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x00a7:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1405q5.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        X2 x22 = this.f6645c.f5730a;
        x22.b().o();
        x22.a().v().a("Service disconnected");
        x22.b().t(new C1355j5(this, componentName));
    }
}
