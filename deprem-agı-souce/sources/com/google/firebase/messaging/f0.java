package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C1698l;
import k0.C1701o;

class f0 {

    /* renamed from: i  reason: collision with root package name */
    private static final long f7413i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f7414a;

    /* renamed from: b  reason: collision with root package name */
    private final I f7415b;

    /* renamed from: c  reason: collision with root package name */
    private final D f7416c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f7417d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f7418e = new ArrayMap();

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f7419f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7420g = false;

    /* renamed from: h  reason: collision with root package name */
    private final d0 f7421h;

    private f0(FirebaseMessaging firebaseMessaging, I i5, d0 d0Var, D d5, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f7417d = firebaseMessaging;
        this.f7415b = i5;
        this.f7421h = d0Var;
        this.f7416c = d5;
        this.f7414a = context;
        this.f7419f = scheduledExecutorService;
    }

    public static /* synthetic */ f0 a(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, I i5, D d5) {
        return new f0(firebaseMessaging, i5, d0.a(context, scheduledExecutorService), d5, context, scheduledExecutorService);
    }

    private static void b(C1698l lVar) {
        try {
            C1701o.b(lVar, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e5) {
            Throwable cause = e5.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e5);
            }
        } catch (InterruptedException | TimeoutException e6) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e6);
        }
    }

    private void c(String str) {
        b(this.f7416c.l(this.f7417d.k(), str));
    }

    private void d(String str) {
        b(this.f7416c.m(this.f7417d.k(), str));
    }

    static C1698l e(FirebaseMessaging firebaseMessaging, I i5, D d5, Context context, ScheduledExecutorService scheduledExecutorService) {
        ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
        return C1701o.c(scheduledExecutorService2, new e0(context, scheduledExecutorService2, firebaseMessaging, i5, d5));
    }

    static boolean g() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(com.google.firebase.messaging.c0 r5) {
        /*
            r4 = this;
            java.util.Map r0 = r4.f7418e
            monitor-enter(r0)
            java.lang.String r5 = r5.e()     // Catch:{ all -> 0x0011 }
            java.util.Map r1 = r4.f7418e     // Catch:{ all -> 0x0011 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r5 = move-exception
            goto L_0x0034
        L_0x0013:
            java.util.Map r1 = r4.f7418e     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0011 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0011 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0011 }
            k0.m r2 = (k0.C1699m) r2     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0027
            r3 = 0
            r2.c(r3)     // Catch:{ all -> 0x0011 }
        L_0x0027:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0032
            java.util.Map r1 = r4.f7418e     // Catch:{ all -> 0x0011 }
            r1.remove(r5)     // Catch:{ all -> 0x0011 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.f0.i(com.google.firebase.messaging.c0):void");
    }

    private void m() {
        if (!h()) {
            p(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.f7421h.b() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean h() {
        return this.f7420g;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[Catch:{ IOException -> 0x001f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j(com.google.firebase.messaging.c0 r7) {
        /*
            r6 = this;
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 0
            java.lang.String r2 = r7.b()     // Catch:{ IOException -> 0x001f }
            int r3 = r2.hashCode()     // Catch:{ IOException -> 0x001f }
            r4 = 83
            r5 = 1
            if (r3 == r4) goto L_0x0022
            r4 = 85
            if (r3 == r4) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            java.lang.String r3 = "U"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = r5
            goto L_0x002d
        L_0x001f:
            r7 = move-exception
            goto L_0x00a5
        L_0x0022:
            java.lang.String r3 = "S"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = r1
            goto L_0x002d
        L_0x002c:
            r2 = -1
        L_0x002d:
            java.lang.String r3 = " succeeded."
            if (r2 == 0) goto L_0x007c
            if (r2 == r5) goto L_0x0053
            boolean r2 = g()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = "Unknown topic operation"
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = "."
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
            goto L_0x00a4
        L_0x0053:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.d(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = g()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Unsubscribe from topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
            goto L_0x00a4
        L_0x007c:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.c(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = g()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x00a4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Subscribe to topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
        L_0x00a4:
            return r5
        L_0x00a5:
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00d7
            java.lang.String r2 = "TOO_MANY_SUBSCRIBERS"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ca
            goto L_0x00d7
        L_0x00ca:
            java.lang.String r2 = r7.getMessage()
            if (r2 != 0) goto L_0x00d6
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r7)
            return r1
        L_0x00d6:
            throw r7
        L_0x00d7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.f0.j(com.google.firebase.messaging.c0):boolean");
    }

    /* access modifiers changed from: package-private */
    public void k(Runnable runnable, long j5) {
        this.f7419f.schedule(runnable, j5, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public synchronized void l(boolean z4) {
        this.f7420g = z4;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (f()) {
            m();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (j(r0) != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean o() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.d0 r0 = r2.f7421h     // Catch:{ all -> 0x0017 }
            com.google.firebase.messaging.c0 r0 = r0.b()     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001c
            boolean r0 = g()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r0 = move-exception
            goto L_0x002e
        L_0x0019:
            r0 = 1
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r0
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            boolean r1 = r2.j(r0)
            if (r1 != 0) goto L_0x0025
            r0 = 0
            return r0
        L_0x0025:
            com.google.firebase.messaging.d0 r1 = r2.f7421h
            r1.d(r0)
            r2.i(r0)
            goto L_0x0000
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.f0.o():boolean");
    }

    /* access modifiers changed from: package-private */
    public void p(long j5) {
        k(new g0(this, this.f7414a, this.f7415b, Math.min(Math.max(30, 2 * j5), f7413i)), j5);
        l(true);
    }
}
