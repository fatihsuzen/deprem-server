package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import f0.v;

/* renamed from: com.google.android.gms.measurement.internal.d1  reason: case insensitive filesystem */
final class C1303d1 {

    /* renamed from: a  reason: collision with root package name */
    private final v f6259a;

    C1303d1(v vVar) {
        this.f6259a = vVar;
    }

    static C1303d1 c(String str) {
        v vVar;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            vVar = v.UNINITIALIZED;
        } else {
            vVar = E3.j(str.charAt(0));
        }
        return new C1303d1(vVar);
    }

    /* access modifiers changed from: package-private */
    public final v a() {
        return this.f6259a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return String.valueOf(E3.m(this.f6259a));
    }
}
