package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.h4  reason: case insensitive filesystem */
final class C1338h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1454y f6461a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6462b;

    C1338h4(C1452x4 x4Var, C1454y yVar) {
        this.f6461a = yVar;
        Objects.requireNonNull(x4Var);
        this.f6462b = x4Var;
    }

    public final void run() {
        C1452x4 x4Var = this.f6462b;
        X2 x22 = x4Var.f5730a;
        E2 x4 = x22.x();
        X2 x23 = x4.f5730a;
        x4.h();
        C1454y u5 = x4.u();
        C1454y yVar = this.f6461a;
        if (E3.u(yVar.b(), u5.b())) {
            SharedPreferences.Editor edit = x4.p().edit();
            edit.putString("dma_consent_settings", yVar.e());
            edit.apply();
            x22.a().w().b("Setting DMA consent(FE)", yVar);
            X2 x24 = x4Var.f5730a;
            if (x24.J().D()) {
                x24.J().a0();
            } else {
                x24.J().Y(false);
            }
        } else {
            x22.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(yVar.b()));
        }
    }
}
