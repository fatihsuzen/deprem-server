package com.google.android.gms.measurement.internal;

import N.C0722p;
import f0.C1650e;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.d5  reason: case insensitive filesystem */
final class C1307d5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B6 f6380a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f6381b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G f6382c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1446w5 f6383d;

    C1307d5(C1446w5 w5Var, boolean z4, B6 b6, boolean z5, G g5, String str) {
        this.f6380a = b6;
        this.f6381b = z5;
        this.f6382c = g5;
        Objects.requireNonNull(w5Var);
        this.f6383d = w5Var;
    }

    public final void run() {
        G g5;
        C1446w5 w5Var = this.f6383d;
        C1650e N4 = w5Var.N();
        if (N4 == null) {
            w5Var.f5730a.a().o().a("Discarding data. Failed to send event to service");
            return;
        }
        B6 b6 = this.f6380a;
        C0722p.k(b6);
        if (this.f6381b) {
            g5 = null;
        } else {
            g5 = this.f6382c;
        }
        w5Var.b0(N4, g5, b6);
        w5Var.J();
    }
}
