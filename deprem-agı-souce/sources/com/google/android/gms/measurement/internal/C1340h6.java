package com.google.android.gms.measurement.internal;

import android.content.Intent;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.h6  reason: case insensitive filesystem */
final class C1340h6 extends C1447x {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ q6 f6469e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1340h6(q6 q6Var, C3 c32) {
        super(c32);
        Objects.requireNonNull(q6Var);
        this.f6469e = q6Var;
    }

    public final void a() {
        q6 q6Var = this.f6469e;
        q6Var.b().h();
        String str = (String) q6Var.y0().pollFirst();
        if (str != null) {
            q6Var.z0(q6Var.f().elapsedRealtime());
            q6Var.a().w().b("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            q6.W(q6Var.e(), intent);
        }
        q6Var.v0();
    }
}
