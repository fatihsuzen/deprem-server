package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.b4  reason: case insensitive filesystem */
final class C1290b4 implements y6 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6226a;

    C1290b4(C1452x4 x4Var) {
        Objects.requireNonNull(x4Var);
        this.f6226a = x4Var;
    }

    public final void b(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f6226a.w("auto", "_err", bundle, str);
        } else {
            this.f6226a.p("auto", "_err", bundle);
        }
    }
}
