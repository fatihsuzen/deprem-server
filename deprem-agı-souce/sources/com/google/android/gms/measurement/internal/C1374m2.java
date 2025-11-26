package com.google.android.gms.measurement.internal;

import N.C0719m;
import N.C0725t;
import N.C0726u;
import N.C0727v;
import N.C0728w;
import android.content.Context;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.measurement.internal.m2  reason: case insensitive filesystem */
public final class C1374m2 {

    /* renamed from: d  reason: collision with root package name */
    private static C1374m2 f6544d;

    /* renamed from: a  reason: collision with root package name */
    private final X2 f6545a;

    /* renamed from: b  reason: collision with root package name */
    private final C0727v f6546b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f6547c = new AtomicLong(-1);

    private C1374m2(Context context, X2 x22) {
        this.f6546b = C0726u.b(context, C0728w.a().b("measurement:api").a());
        this.f6545a = x22;
    }

    static C1374m2 a(X2 x22) {
        if (f6544d == null) {
            f6544d = new C1374m2(x22.e(), x22);
        }
        return f6544d;
    }

    public final synchronized void b(int i5, int i6, long j5, long j6, int i7) {
        synchronized (this) {
            long elapsedRealtime = this.f6545a.f().elapsedRealtime();
            AtomicLong atomicLong = this.f6547c;
            if (atomicLong.get() != -1) {
                if (elapsedRealtime - atomicLong.get() <= 1800000) {
                    return;
                }
            }
            this.f6546b.a(new C0725t(0, Arrays.asList(new C0719m[]{new C0719m(36301, i6, 0, j5, j6, (String) null, (String) null, 0, i7)}))).e(new C1367l2(this, elapsedRealtime));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(long j5, Exception exc) {
        this.f6547c.set(j5);
    }
}
