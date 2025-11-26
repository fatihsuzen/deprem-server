package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.SharedPreferences;
import j$.util.Objects;

public final class B2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f5752a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5753b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5754c;

    /* renamed from: d  reason: collision with root package name */
    private long f5755d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ E2 f5756e;

    public B2(E2 e22, String str, long j5) {
        Objects.requireNonNull(e22);
        this.f5756e = e22;
        C0722p.e(str);
        this.f5752a = str;
        this.f5753b = j5;
    }

    public final long a() {
        if (!this.f5754c) {
            this.f5754c = true;
            E2 e22 = this.f5756e;
            this.f5755d = e22.p().getLong(this.f5752a, this.f5753b);
        }
        return this.f5755d;
    }

    public final void b(long j5) {
        SharedPreferences.Editor edit = this.f5756e.p().edit();
        edit.putLong(this.f5752a, j5);
        edit.apply();
        this.f5755d = j5;
    }
}
