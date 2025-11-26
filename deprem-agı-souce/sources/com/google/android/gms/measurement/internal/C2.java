package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.SharedPreferences;
import android.util.Pair;
import j$.util.Objects;

public final class C2 {

    /* renamed from: a  reason: collision with root package name */
    final String f5806a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5807b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5808c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5809d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ E2 f5810e;

    /* synthetic */ C2(E2 e22, String str, long j5, byte[] bArr) {
        boolean z4;
        Objects.requireNonNull(e22);
        this.f5810e = e22;
        C0722p.e("health_monitor");
        if (j5 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.a(z4);
        this.f5806a = "health_monitor:start";
        this.f5807b = "health_monitor:count";
        this.f5808c = "health_monitor:value";
        this.f5809d = j5;
    }

    private final void c() {
        E2 e22 = this.f5810e;
        e22.h();
        long currentTimeMillis = e22.f5730a.f().currentTimeMillis();
        SharedPreferences.Editor edit = e22.p().edit();
        edit.remove(this.f5807b);
        edit.remove(this.f5808c);
        edit.putLong(this.f5806a, currentTimeMillis);
        edit.apply();
    }

    private final long d() {
        return this.f5810e.p().getLong(this.f5806a, 0);
    }

    public final void a(String str, long j5) {
        E2 e22 = this.f5810e;
        e22.h();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences p5 = e22.p();
        String str2 = this.f5807b;
        long j6 = p5.getLong(str2, 0);
        if (j6 <= 0) {
            SharedPreferences.Editor edit = e22.p().edit();
            edit.putString(this.f5808c, str);
            edit.putLong(str2, 1);
            edit.apply();
            return;
        }
        long j7 = j6 + 1;
        SharedPreferences.Editor edit2 = e22.p().edit();
        if ((e22.f5730a.C().q0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j7) {
            edit2.putString(this.f5808c, str);
        }
        edit2.putLong(str2, j7);
        edit2.apply();
    }

    public final Pair b() {
        long j5;
        E2 e22 = this.f5810e;
        e22.h();
        e22.h();
        long d5 = d();
        if (d5 == 0) {
            c();
            j5 = 0;
        } else {
            j5 = Math.abs(d5 - e22.f5730a.f().currentTimeMillis());
        }
        long j6 = this.f5809d;
        if (j5 < j6) {
            return null;
        }
        if (j5 > j6 + j6) {
            c();
            return null;
        }
        String string = e22.p().getString(this.f5808c, (String) null);
        long j7 = e22.p().getLong(this.f5807b, 0);
        c();
        if (string == null || j7 <= 0) {
            return E2.f5832A;
        }
        return new Pair(string, Long.valueOf(j7));
    }
}
