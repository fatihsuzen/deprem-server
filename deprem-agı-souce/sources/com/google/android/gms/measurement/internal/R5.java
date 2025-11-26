package com.google.android.gms.measurement.internal;

import N.C0722p;
import com.google.android.gms.common.util.d;

final class R5 {

    /* renamed from: a  reason: collision with root package name */
    private final d f6064a;

    /* renamed from: b  reason: collision with root package name */
    private long f6065b;

    public R5(d dVar) {
        C0722p.k(dVar);
        this.f6064a = dVar;
    }

    public final void a() {
        this.f6065b = this.f6064a.elapsedRealtime();
    }

    public final void b() {
        this.f6065b = 0;
    }

    public final boolean c(long j5) {
        if (this.f6065b != 0 && this.f6064a.elapsedRealtime() - this.f6065b < 3600000) {
            return false;
        }
        return true;
    }
}
