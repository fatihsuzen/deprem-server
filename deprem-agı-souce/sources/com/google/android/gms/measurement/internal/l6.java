package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import j$.util.Objects;

final class l6 implements y6 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q6 f6537a;

    l6(q6 q6Var) {
        Objects.requireNonNull(q6Var);
        this.f6537a = q6Var;
    }

    public final void b(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            q6 q6Var = this.f6537a;
            if (q6Var.x0() != null) {
                q6Var.x0().a().o().b("AppId not known when logging event", str2);
                return;
            }
            return;
        }
        this.f6537a.b().t(new k6(this, str, str2, bundle));
    }
}
