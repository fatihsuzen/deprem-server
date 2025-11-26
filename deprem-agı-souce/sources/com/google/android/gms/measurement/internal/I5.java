package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import j$.util.Objects;

final class I5 {

    /* renamed from: a  reason: collision with root package name */
    private H5 f5921a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ N5 f5922b;

    I5(N5 n5) {
        Objects.requireNonNull(n5);
        this.f5922b = n5;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        N5 n5 = this.f5922b;
        n5.h();
        H5 h5 = this.f5921a;
        if (h5 != null) {
            n5.t().removeCallbacks(h5);
        }
        X2 x22 = n5.f5730a;
        x22.x().f5850t.b(false);
        n5.o(false);
        if (x22.w().H((String) null, C1304d2.f6301U0)) {
            X2 x23 = n5.f5730a;
            if (x23.B().v0()) {
                x22.a().w().a("Retrying trigger URI registration in foreground");
                x23.B().x0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j5) {
        N5 n5 = this.f5922b;
        this.f5921a = new H5(this, n5.f5730a.f().currentTimeMillis(), j5);
        n5.t().postDelayed(this.f5921a, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }
}
