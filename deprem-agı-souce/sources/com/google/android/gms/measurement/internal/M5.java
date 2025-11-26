package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import j$.util.Objects;

final class M5 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ N5 f5984a;

    M5(N5 n5) {
        Objects.requireNonNull(n5);
        this.f5984a = n5;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        N5 n5 = this.f5984a;
        n5.h();
        X2 x22 = n5.f5730a;
        if (x22.x().A(x22.f().currentTimeMillis())) {
            x22.x().f5843m.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                x22.a().w().a("Detected application was in foreground");
                c(x22.f().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j5, boolean z4) {
        N5 n5 = this.f5984a;
        n5.h();
        n5.q();
        X2 x22 = n5.f5730a;
        if (x22.x().A(j5)) {
            x22.x().f5843m.b(true);
            n5.f5730a.L().p();
        }
        x22.x().f5847q.b(j5);
        if (x22.x().f5843m.a()) {
            c(j5, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(long j5, boolean z4) {
        N5 n5 = this.f5984a;
        n5.h();
        if (n5.f5730a.g()) {
            X2 x22 = n5.f5730a;
            x22.x().f5847q.b(j5);
            x22.a().w().b("Session started, time", Long.valueOf(x22.f().elapsedRealtime()));
            long j6 = j5 / 1000;
            X2 x23 = n5.f5730a;
            x23.B().B("auto", "_sid", Long.valueOf(j6), j5);
            x22.x().f5848r.b(j6);
            x22.x().f5843m.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j6);
            x23.B().u("auto", "_s", j5, bundle);
            String a5 = x22.x().f5853w.a();
            if (!TextUtils.isEmpty(a5)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a5);
                x23.B().u("auto", "_ssr", j5, bundle2);
            }
        }
    }
}
