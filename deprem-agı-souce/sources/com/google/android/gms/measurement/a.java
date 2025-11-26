package com.google.android.gms.measurement;

import N.C0722p;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.C1452x4;
import com.google.android.gms.measurement.internal.X2;
import java.util.List;
import java.util.Map;

final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final X2 f5719a;

    /* renamed from: b  reason: collision with root package name */
    private final C1452x4 f5720b;

    public a(X2 x22) {
        super((byte[]) null);
        C0722p.k(x22);
        this.f5719a = x22;
        this.f5720b = x22.B();
    }

    public final String a() {
        return this.f5720b.Q();
    }

    public final void b(String str, String str2, Bundle bundle) {
        this.f5720b.p(str, str2, bundle);
    }

    public final void c(Bundle bundle) {
        this.f5720b.M(bundle);
    }

    public final void d(String str) {
        X2 x22 = this.f5719a;
        x22.M().j(str, x22.f().elapsedRealtime());
    }

    public final String e() {
        return this.f5720b.R();
    }

    public final void f(String str) {
        X2 x22 = this.f5719a;
        x22.M().i(str, x22.f().elapsedRealtime());
    }

    public final long g() {
        return this.f5719a.C().p0();
    }

    public final String h() {
        return this.f5720b.D();
    }

    public final String i() {
        return this.f5720b.S();
    }

    public final void j(String str, String str2, Bundle bundle) {
        this.f5719a.B().O(str, str2, bundle);
    }

    public final List k(String str, String str2) {
        return this.f5720b.P(str, str2);
    }

    public final int l(String str) {
        this.f5720b.L(str);
        return 25;
    }

    public final Map m(String str, String str2, boolean z4) {
        return this.f5720b.C(str, str2, z4);
    }
}
