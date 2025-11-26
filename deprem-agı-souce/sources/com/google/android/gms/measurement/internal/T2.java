package com.google.android.gms.measurement.internal;

import N.C0722p;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class T2 extends B3 {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicLong f6087k = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c  reason: collision with root package name */
    private S2 f6088c;

    /* renamed from: d  reason: collision with root package name */
    private S2 f6089d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue f6090e = new PriorityBlockingQueue();

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f6091f = new LinkedBlockingQueue();

    /* renamed from: g  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6092g = new Q2(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f6093h = new Q2(this, "Thread death: Uncaught exception on network thread");

    /* renamed from: i  reason: collision with root package name */
    private final Object f6094i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private final Semaphore f6095j = new Semaphore(2);

    T2(X2 x22) {
        super(x22);
    }

    private final void F(R2 r22) {
        synchronized (this.f6094i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f6090e;
                priorityBlockingQueue.add(r22);
                S2 s22 = this.f6088c;
                if (s22 == null) {
                    S2 s23 = new S2(this, "Measurement Worker", priorityBlockingQueue);
                    this.f6088c = s23;
                    s23.setUncaughtExceptionHandler(this.f6092g);
                    this.f6088c.start();
                } else {
                    s22.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void A(S2 s22) {
        this.f6089d = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object B() {
        return this.f6094i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Semaphore C() {
        return this.f6095j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean D() {
        return false;
    }

    public final void g() {
        if (Thread.currentThread() != this.f6089d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void h() {
        if (Thread.currentThread() != this.f6088c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        return false;
    }

    public final void o() {
        if (Thread.currentThread() == this.f6088c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean p() {
        if (Thread.currentThread() == this.f6088c) {
            return true;
        }
        return false;
    }

    public final boolean q() {
        if (Thread.currentThread() == this.f6089d) {
            return true;
        }
        return false;
    }

    public final Future r(Callable callable) {
        l();
        C0722p.k(callable);
        R2 r22 = new R2(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6088c) {
            if (!this.f6090e.isEmpty()) {
                this.f5730a.a().r().a("Callable skipped the worker queue.");
            }
            r22.run();
            return r22;
        }
        F(r22);
        return r22;
    }

    public final Future s(Callable callable) {
        l();
        C0722p.k(callable);
        R2 r22 = new R2(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6088c) {
            r22.run();
            return r22;
        }
        F(r22);
        return r22;
    }

    public final void t(Runnable runnable) {
        l();
        C0722p.k(runnable);
        F(new R2(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2.f5730a.a().r().a("Timed out waiting for ".concat(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = r2.f5730a.a().r();
        r7 = new java.lang.StringBuilder(r6.length() + 24);
        r7.append("Interrupted waiting for ");
        r7.append(r6);
        r4.a(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r3 = r3.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r3 != null) goto L_0x0029;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(java.util.concurrent.atomic.AtomicReference r3, long r4, java.lang.String r6, java.lang.Runnable r7) {
        /*
            r2 = this;
            java.lang.String r0 = "Interrupted waiting for "
            monitor-enter(r3)
            com.google.android.gms.measurement.internal.X2 r1 = r2.f5730a     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.T2 r1 = r1.b()     // Catch:{ all -> 0x002a }
            r1.t(r7)     // Catch:{ all -> 0x002a }
            r3.wait(r4)     // Catch:{ InterruptedException -> 0x002c }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r3.get()
            if (r3 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.X2 r4 = r2.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.r()
            java.lang.String r5 = "Timed out waiting for "
            java.lang.String r5 = r5.concat(r6)
            r4.a(r5)
        L_0x0029:
            return r3
        L_0x002a:
            r4 = move-exception
            goto L_0x0051
        L_0x002c:
            com.google.android.gms.measurement.internal.X2 r4 = r2.f5730a     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.o2 r4 = r4.r()     // Catch:{ all -> 0x002a }
            int r5 = r6.length()     // Catch:{ all -> 0x002a }
            int r5 = r5 + 24
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r7.<init>(r5)     // Catch:{ all -> 0x002a }
            r7.append(r0)     // Catch:{ all -> 0x002a }
            r7.append(r6)     // Catch:{ all -> 0x002a }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x002a }
            r4.a(r5)     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            r3 = 0
            return r3
        L_0x0051:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.T2.u(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final void v(Runnable runnable) {
        l();
        C0722p.k(runnable);
        F(new R2(this, runnable, true, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) {
        l();
        C0722p.k(runnable);
        R2 r22 = new R2(this, runnable, false, "Task exception on network thread");
        synchronized (this.f6094i) {
            try {
                BlockingQueue blockingQueue = this.f6091f;
                blockingQueue.add(r22);
                S2 s22 = this.f6089d;
                if (s22 == null) {
                    S2 s23 = new S2(this, "Measurement Network", blockingQueue);
                    this.f6089d = s23;
                    s23.setUncaughtExceptionHandler(this.f6093h);
                    this.f6089d.start();
                } else {
                    s22.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ S2 x() {
        return this.f6088c;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void y(S2 s22) {
        this.f6088c = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ S2 z() {
        return this.f6089d;
    }
}
