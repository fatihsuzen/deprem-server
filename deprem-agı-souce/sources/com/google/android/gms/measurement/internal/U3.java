package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import j$.util.Objects;

final class U3 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6106e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    U3(C1452x4 x4Var, C3 c32) {
        super(c32);
        Objects.requireNonNull(x4Var);
        this.f6106e = x4Var;
    }

    public final void a() {
        C1452x4 x4Var = this.f6106e;
        if (x4Var.f5730a.n()) {
            x4Var.c0().b(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }
}
