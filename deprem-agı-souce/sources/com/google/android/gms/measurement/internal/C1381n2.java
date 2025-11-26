package com.google.android.gms.measurement.internal;

import android.util.Log;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.n2  reason: case insensitive filesystem */
final class C1381n2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f6574a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6575b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f6576c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f6577d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Object f6578e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C1402q2 f6579f;

    C1381n2(C1402q2 q2Var, int i5, String str, Object obj, Object obj2, Object obj3) {
        this.f6574a = i5;
        this.f6575b = str;
        this.f6576c = obj;
        this.f6577d = obj2;
        this.f6578e = obj3;
        Objects.requireNonNull(q2Var);
        this.f6579f = q2Var;
    }

    public final void run() {
        C1402q2 q2Var = this.f6579f;
        E2 x4 = q2Var.f5730a.x();
        if (x4.k()) {
            if (q2Var.D() == 0) {
                X2 x22 = q2Var.f5730a;
                if (x22.w().B()) {
                    x22.c();
                    q2Var.E('C');
                } else {
                    x22.c();
                    q2Var.E('c');
                }
            }
            if (q2Var.F() < 0) {
                q2Var.f5730a.w().A();
                q2Var.G(133005);
            }
            int i5 = this.f6574a;
            char D4 = q2Var.D();
            long F4 = q2Var.F();
            String str = this.f6575b;
            Object obj = this.f6576c;
            Object obj2 = this.f6577d;
            Object obj3 = this.f6578e;
            char charAt = "01VDIWEA?".charAt(i5);
            String A4 = C1402q2.A(true, str, obj, obj2, obj3);
            int length = String.valueOf(charAt).length();
            StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(D4).length() + String.valueOf(F4).length() + 1 + A4.length());
            sb.append("2");
            sb.append(charAt);
            sb.append(D4);
            sb.append(F4);
            sb.append(":");
            sb.append(A4);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = str.substring(0, 1024);
            }
            C2 c22 = x4.f5835e;
            if (c22 != null) {
                c22.a(sb2, 1);
                return;
            }
            return;
        }
        Log.println(6, q2Var.z(), "Persisted config not initialized. Not logging error/warn");
    }
}
