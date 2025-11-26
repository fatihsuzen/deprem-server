package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import e0.C1626a;
import f0.x;
import j$.util.Objects;

final class c implements C1626a.C0148a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f7161a;

    public c(d dVar) {
        Objects.requireNonNull(dVar);
        this.f7161a = dVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j5) {
        d dVar = this.f7161a;
        if (dVar.f7162a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            int i5 = b.f7160g;
            String a5 = x.a(str2);
            if (a5 != null) {
                str2 = a5;
            }
            bundle2.putString("events", str2);
            dVar.a().a(2, bundle2);
        }
    }
}
