package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Objects;

final class L5 {

    /* renamed from: a  reason: collision with root package name */
    protected long f5964a;

    /* renamed from: b  reason: collision with root package name */
    protected long f5965b;

    /* renamed from: c  reason: collision with root package name */
    private final C1447x f5966c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ N5 f5967d;

    public L5(N5 n5) {
        Objects.requireNonNull(n5);
        this.f5967d = n5;
        this.f5966c = new J5(this, n5.f5730a);
        long elapsedRealtime = n5.f5730a.f().elapsedRealtime();
        this.f5964a = elapsedRealtime;
        this.f5965b = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j5) {
        this.f5967d.h();
        this.f5966c.d();
        this.f5964a = j5;
        this.f5965b = j5;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j5) {
        this.f5966c.d();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f5966c.d();
        long elapsedRealtime = this.f5967d.f5730a.f().elapsedRealtime();
        this.f5964a = elapsedRealtime;
        this.f5965b = elapsedRealtime;
    }

    public final boolean d(boolean z4, boolean z5, long j5) {
        N5 n5 = this.f5967d;
        n5.h();
        n5.j();
        if (n5.f5730a.g()) {
            X2 x22 = n5.f5730a;
            x22.x().f5847q.b(x22.f().currentTimeMillis());
        }
        long j6 = j5 - this.f5964a;
        if (z4 || j6 >= 1000) {
            if (!z5) {
                j6 = j5 - this.f5965b;
                this.f5965b = j5;
            }
            X2 x23 = n5.f5730a;
            x23.a().w().b("Recording user engagement, ms", Long.valueOf(j6));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j6);
            X2 x24 = n5.f5730a;
            z6.k0(x24.I().q(!x23.w().N()), bundle, true);
            if (!z5) {
                x24.B().t("auto", "_e", bundle);
            }
            this.f5964a = j5;
            C1447x xVar = this.f5966c;
            xVar.d();
            xVar.b(((Long) C1304d2.f6359r0.b((Object) null)).longValue());
            return true;
        }
        n5.f5730a.a().w().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j6));
        return false;
    }
}
