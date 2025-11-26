package com.google.android.gms.measurement.internal;

import T.d;
import T.e;

public final class H2 {

    /* renamed from: a  reason: collision with root package name */
    final X2 f5907a;

    H2(q6 q6Var) {
        this.f5907a = q6Var.g0();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        try {
            X2 x22 = this.f5907a;
            d a5 = e.a(x22.e());
            if (a5 == null) {
                x22.a().w().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (a5.e("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e5) {
            this.f5907a.a().w().b("Failed to retrieve Play Store version for Install Referrer", e5);
            return false;
        }
    }
}
