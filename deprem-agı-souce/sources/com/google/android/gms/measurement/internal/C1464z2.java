package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.SharedPreferences;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.z2  reason: case insensitive filesystem */
public final class C1464z2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f6922a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6923b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6924c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6925d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ E2 f6926e;

    public C1464z2(E2 e22, String str, boolean z4) {
        Objects.requireNonNull(e22);
        this.f6926e = e22;
        C0722p.e(str);
        this.f6922a = str;
        this.f6923b = z4;
    }

    public final boolean a() {
        if (!this.f6924c) {
            this.f6924c = true;
            E2 e22 = this.f6926e;
            this.f6925d = e22.p().getBoolean(this.f6922a, this.f6923b);
        }
        return this.f6925d;
    }

    public final void b(boolean z4) {
        SharedPreferences.Editor edit = this.f6926e.p().edit();
        edit.putBoolean(this.f6922a, z4);
        edit.apply();
        this.f6925d = z4;
    }
}
