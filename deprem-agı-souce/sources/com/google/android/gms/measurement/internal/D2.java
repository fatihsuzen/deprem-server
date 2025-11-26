package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.SharedPreferences;
import j$.util.Objects;

public final class D2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f5819a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5820b;

    /* renamed from: c  reason: collision with root package name */
    private String f5821c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ E2 f5822d;

    public D2(E2 e22, String str, String str2) {
        Objects.requireNonNull(e22);
        this.f5822d = e22;
        C0722p.e(str);
        this.f5819a = str;
    }

    public final String a() {
        if (!this.f5820b) {
            this.f5820b = true;
            E2 e22 = this.f5822d;
            this.f5821c = e22.p().getString(this.f5819a, (String) null);
        }
        return this.f5821c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f5822d.p().edit();
        edit.putString(this.f5819a, str);
        edit.apply();
        this.f5821c = str;
    }
}
