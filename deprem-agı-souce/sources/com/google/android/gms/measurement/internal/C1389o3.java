package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.C1051a3;
import com.google.android.gms.internal.measurement.C1060b3;
import com.google.android.gms.internal.measurement.C1078d3;
import com.google.android.gms.internal.measurement.C1195q3;
import com.google.android.gms.internal.measurement.C1203r3;
import com.google.android.gms.internal.measurement.N2;
import com.google.android.gms.internal.measurement.O2;
import com.google.android.gms.internal.measurement.P2;
import com.google.android.gms.internal.measurement.Q2;
import com.google.android.gms.internal.measurement.R2;
import com.google.android.gms.internal.measurement.S2;
import com.google.android.gms.internal.measurement.V2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.Z2;
import com.google.android.gms.internal.measurement.x7;
import f0.w;
import j$.util.Objects;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.o3  reason: case insensitive filesystem */
final class C1389o3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ G f6595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6596b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1465z3 f6597c;

    C1389o3(C1465z3 z3Var, G g5, String str) {
        this.f6595a = g5;
        this.f6596b = str;
        Objects.requireNonNull(z3Var);
        this.f6597c = z3Var;
    }

    public final /* bridge */ /* synthetic */ Object call() {
        C4 c42;
        byte[] bArr;
        q6 q6Var;
        x6 x6Var;
        q6 q6Var2;
        C1443w2 w2Var;
        X2 x22;
        Z2 z22;
        Bundle bundle;
        String str;
        boolean z4;
        Object obj;
        V2 v22;
        C a5;
        long j5;
        C c5;
        String str2;
        X2 x23;
        long j6;
        C4 c43;
        String str3;
        boolean z5;
        C1443w2 w2Var2;
        Z2 z23;
        q6 q6Var3;
        q6 q6Var4;
        byte[] bArr2;
        C1465z3 z3Var = this.f6597c;
        z3Var.v0().E();
        C4 J02 = z3Var.v0().J0();
        J02.h();
        X2 x24 = J02.f5730a;
        X2.q();
        G g5 = this.f6595a;
        C0722p.k(g5);
        String str4 = this.f6596b;
        C0722p.e(str4);
        String str5 = g5.f5883a;
        if ("_iap".equals(str5) || "_iapx".equals(str5)) {
            q6 q6Var5 = J02.f6129b;
            V2 M4 = Y2.M();
            q6Var5.F0().r0();
            C1443w2 J03 = q6Var5.F0().J0(str4);
            if (J03 == null) {
                J02.f5730a.a().v().b("Log and bundle not available. package_name", str4);
                bArr2 = new byte[0];
            } else if (!J03.d()) {
                J02.f5730a.a().v().b("Log and bundle disabled. package_name", str4);
                bArr2 = new byte[0];
            } else {
                Z2 k02 = C1051a3.k0();
                k02.T(1);
                k02.t("android");
                if (!TextUtils.isEmpty(J03.o0())) {
                    k02.E(J03.o0());
                }
                if (!TextUtils.isEmpty(J03.H0())) {
                    k02.C((String) C0722p.k(J03.H0()));
                }
                if (!TextUtils.isEmpty(J03.D0())) {
                    k02.F((String) C0722p.k(J03.D0()));
                }
                if (J03.F0() != -2147483648L) {
                    k02.u0((int) J03.F0());
                }
                k02.G(J03.J0());
                k02.C0(J03.b());
                String r02 = J03.r0();
                if (!TextUtils.isEmpty(r02)) {
                    k02.o0(r02);
                }
                k02.J0(J03.X());
                E3 g6 = J02.f6129b.g(str4);
                k02.R(J03.L0());
                if (x24.g() && J02.f5730a.w().k(k02.D()) && g6.o(w.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    k02.x0((String) null);
                }
                k02.E0(g6.k());
                if (g6.o(w.AD_STORAGE) && J03.P()) {
                    Pair m5 = q6Var5.L0().m(J03.o0(), g6);
                    if (J03.P() && !TextUtils.isEmpty((CharSequence) m5.first)) {
                        try {
                            k02.J(C4.m((String) m5.first, Long.toString(g5.f5886d)));
                            Object obj2 = m5.second;
                            if (obj2 != null) {
                                k02.M(((Boolean) obj2).booleanValue());
                            }
                        } catch (SecurityException e5) {
                            J02.f5730a.a().v().b("Resettable device id encryption failed", e5.getMessage());
                            bArr = new byte[0];
                            q6Var = J02.f6129b;
                            q6Var.F0().t0();
                            return bArr;
                        } catch (Throwable th) {
                            th = th;
                            c42 = J02;
                            c42.f6129b.F0().t0();
                            throw th;
                        }
                    }
                }
                X2 x25 = J02.f5730a;
                x25.K().l();
                k02.y(Build.MODEL);
                x25.K().l();
                k02.x(Build.VERSION.RELEASE);
                k02.B((int) x25.K().o());
                k02.A(x25.K().p());
                try {
                    if (g6.o(w.ANALYTICS_STORAGE) && J03.p0() != null) {
                        k02.P(C4.m((String) C0722p.k(J03.p0()), Long.toString(g5.f5886d)));
                    }
                    if (!TextUtils.isEmpty(J03.x0())) {
                        k02.s0((String) C0722p.k(J03.x0()));
                    }
                    String o02 = J03.o0();
                    q6 q6Var6 = J02.f6129b;
                    List C02 = q6Var6.F0().C0(o02);
                    Iterator it = C02.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            x6Var = null;
                            break;
                        }
                        x6Var = (x6) it.next();
                        if ("_lte".equals(x6Var.f6894c)) {
                            break;
                        }
                    }
                    if (x6Var == null || x6Var.f6896e == null) {
                        x6 x6Var2 = new x6(o02, "auto", "_lte", J02.f5730a.f().currentTimeMillis(), 0L);
                        C02.add(x6Var2);
                        q6Var6.F0().A0(x6Var2);
                    }
                    C1203r3[] r3VarArr = new C1203r3[C02.size()];
                    for (int i5 = 0; i5 < C02.size(); i5++) {
                        C1195q3 Q4 = C1203r3.Q();
                        Q4.s(((x6) C02.get(i5)).f6894c);
                        Q4.r(((x6) C02.get(i5)).f6895d);
                        q6Var6.K0().G(Q4, ((x6) C02.get(i5)).f6896e);
                        r3VarArr[i5] = (C1203r3) Q4.o();
                    }
                    k02.a1(Arrays.asList(r3VarArr));
                    q6 q6Var7 = J02.f6129b;
                    q6Var7.n(J03, k02);
                    q6Var7.o(J03, k02);
                    C1408r2 a6 = C1408r2.a(g5);
                    X2 x26 = J02.f5730a;
                    z6 C4 = x26.C();
                    Bundle bundle2 = a6.f6692d;
                    C4.w(bundle2, q6Var6.F0().G(str4));
                    x26.C().u(a6, x26.w().w(str4));
                    bundle2.putLong("_c", 1);
                    x26.a().v().a("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    String str6 = g5.f5885c;
                    bundle2.putString("_o", str6);
                    if (x26.C().P(k02.D(), J03.l0())) {
                        x26.C().A(bundle2, "_dbg", 1L);
                        x26.C().A(bundle2, "_r", 1L);
                    }
                    C1426u F02 = q6Var6.F0();
                    V2 v23 = M4;
                    String str7 = g5.f5883a;
                    C v02 = F02.v0(str4, str7);
                    if (v02 == null) {
                        w2Var = J03;
                        x22 = x26;
                        z22 = k02;
                        q6Var2 = q6Var7;
                        obj = null;
                        bundle = bundle2;
                        str = str6;
                        a5 = new C(str4, str7, 0, 0, 0, g5.f5886d, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        z4 = true;
                        j5 = 0;
                        v22 = v23;
                    } else {
                        q6Var2 = q6Var7;
                        w2Var = J03;
                        x22 = x26;
                        z22 = k02;
                        bundle = bundle2;
                        str = str6;
                        z4 = true;
                        obj = null;
                        v22 = v23;
                        long j7 = v02.f5796f;
                        a5 = v02.a(g5.f5886d);
                        j5 = j7;
                    }
                    c5 = a5;
                    q6Var6.F0().w0(c5);
                    str2 = str4;
                    x23 = J02.f5730a;
                    j6 = g5.f5886d;
                    c43 = J02;
                    str3 = str7;
                    z5 = z4;
                    w2Var2 = w2Var;
                    z23 = z22;
                    q6Var3 = q6Var6;
                    q6Var4 = q6Var2;
                } catch (SecurityException e6) {
                    c42 = J02;
                    c42.f5730a.a().v().b("app instance id encryption failed", e6.getMessage());
                    bArr = new byte[0];
                    q6Var = c42.f6129b;
                } catch (Throwable th2) {
                    th = th2;
                    c42.f6129b.F0().t0();
                    throw th;
                }
                try {
                    B b5 = new B(x23, str, str2, str3, j6, j5, bundle);
                    String str8 = str2;
                    String str9 = str3;
                    N2 P4 = O2.P();
                    P4.H(b5.f5747d);
                    P4.E(b5.f5745b);
                    P4.J(b5.f5748e);
                    E e7 = b5.f5749f;
                    D d5 = new D(e7);
                    while (d5.hasNext()) {
                        String a7 = d5.next();
                        R2 R4 = S2.R();
                        R4.s(a7);
                        Object c6 = e7.c(a7);
                        if (c6 != null) {
                            q6Var3.K0().H(R4, c6);
                            P4.z(R4);
                        }
                    }
                    z23.Q0(P4);
                    C1060b3 F4 = C1078d3.F();
                    P2 F5 = Q2.F();
                    F5.s(c5.f5793c);
                    F5.r(str9);
                    F4.r(F5);
                    z23.A0(F4);
                    z23.q0(q6Var3.I0().m(w2Var2.o0(), Collections.EMPTY_LIST, z23.U0(), Long.valueOf(P4.G()), Long.valueOf(P4.G()), false));
                    if (P4.F()) {
                        z23.f1(P4.G());
                        z23.h1(P4.G());
                    }
                    long B02 = w2Var2.B0();
                    int i6 = (B02 > 0 ? 1 : (B02 == 0 ? 0 : -1));
                    if (i6 != 0) {
                        z23.r(B02);
                    }
                    long z02 = w2Var2.z0();
                    if (z02 != 0) {
                        z23.i1(z02);
                    } else if (i6 != 0) {
                        z23.i1(B02);
                    }
                    String t02 = w2Var2.t0();
                    x7.a();
                    if (x22.w().H(str8, C1304d2.f6287N0) && t02 != null) {
                        z23.F0(t02);
                    }
                    w2Var2.l();
                    z23.S((int) w2Var2.g());
                    x22.w().A();
                    z23.H(133005);
                    z23.c1(x22.f().currentTimeMillis());
                    z23.p0(z5);
                    q6Var4.x(z23.D(), z23);
                    v22.x(z23);
                    w2Var2.A0(z23.e1());
                    w2Var2.C0(z23.g1());
                    q6Var3.F0().K0(w2Var2, false, false);
                    q6Var3.F0().s0();
                    q6Var3.F0().t0();
                    try {
                        return q6Var3.K0().V(((Y2) v22.o()).e());
                    } catch (IOException e8) {
                        c43.f5730a.a().o().c("Data loss. Failed to bundle and serialize. appId", C1402q2.x(str8), e8);
                        return obj;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c42 = c43;
                    c42.f6129b.F0().t0();
                    throw th;
                }
            }
            q6Var5.F0().t0();
            return bArr2;
        }
        J02.f5730a.a().v().c("Generating a payload for this event is not available. package_name, event_name", str4, str5);
        return null;
    }
}
