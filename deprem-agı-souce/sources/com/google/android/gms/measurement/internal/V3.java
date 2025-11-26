package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

final class V3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f6115a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6116b;

    V3(C1452x4 x4Var, long j5) {
        this.f6115a = j5;
        Objects.requireNonNull(x4Var);
        this.f6116b = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6116b;
        x4Var.h();
        x4Var.j();
        X2 x22 = x4Var.f5730a;
        x22.a().v().a("Resetting analytics data (FE)");
        X2 x23 = x4Var.f5730a;
        N5 z4 = x23.z();
        z4.h();
        z4.f5999f.c();
        x23.L().p();
        boolean z5 = !x4Var.f5730a.g();
        E2 x4 = x22.x();
        x4.f5836f.b(this.f6115a);
        X2 x24 = x4.f5730a;
        if (!TextUtils.isEmpty(x24.x().f5853w.a())) {
            x4.f5853w.b((String) null);
        }
        x4.f5847q.b(0);
        x4.f5848r.b(0);
        if (!x24.w().L()) {
            x4.y(z5);
        }
        x4.f5854x.b((String) null);
        x4.f5855y.b(0);
        x4.f5856z.b((Bundle) null);
        x23.J().p();
        x23.z().f5998e.a();
        x4Var.f6884s = z5;
        x23.J().q(new AtomicReference());
    }
}
