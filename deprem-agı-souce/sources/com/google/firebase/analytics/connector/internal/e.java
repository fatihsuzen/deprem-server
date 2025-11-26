package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import e0.C1626a;
import j$.util.Objects;

final class e implements C1626a.C0148a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7166a;

    public e(f fVar) {
        Objects.requireNonNull(fVar);
        this.f7166a = fVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j5) {
        if (str != null && b.c(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(RewardPlus.NAME, str2);
            bundle2.putLong("timestampInMillis", j5);
            bundle2.putBundle("params", bundle);
            this.f7166a.a().a(3, bundle2);
        }
    }
}
