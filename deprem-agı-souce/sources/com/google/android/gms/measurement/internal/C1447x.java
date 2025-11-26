package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Handler;
import com.google.android.gms.internal.measurement.C1209s0;

/* renamed from: com.google.android.gms.measurement.internal.x  reason: case insensitive filesystem */
abstract class C1447x {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f6856d;

    /* renamed from: a  reason: collision with root package name */
    private final C3 f6857a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f6858b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f6859c;

    C1447x(C3 c32) {
        C0722p.k(c32);
        this.f6857a = c32;
        this.f6858b = new C1440w(this, c32);
    }

    private final Handler f() {
        Handler handler;
        if (f6856d != null) {
            return f6856d;
        }
        synchronized (C1447x.class) {
            try {
                if (f6856d == null) {
                    f6856d = new C1209s0(this.f6857a.e().getMainLooper());
                }
                handler = f6856d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public abstract void a();

    public final void b(long j5) {
        d();
        if (j5 >= 0) {
            C3 c32 = this.f6857a;
            this.f6859c = c32.f().currentTimeMillis();
            if (!f().postDelayed(this.f6858b, j5)) {
                c32.a().o().b("Failed to schedule delayed post. time", Long.valueOf(j5));
            }
        }
    }

    public final boolean c() {
        return this.f6859c != 0;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        this.f6859c = 0;
        f().removeCallbacks(this.f6858b);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void e(long j5) {
        this.f6859c = 0;
    }
}
