package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.w2  reason: case insensitive filesystem */
final class C1443w2 {

    /* renamed from: A  reason: collision with root package name */
    private Long f6798A;

    /* renamed from: B  reason: collision with root package name */
    private long f6799B;

    /* renamed from: C  reason: collision with root package name */
    private String f6800C;

    /* renamed from: D  reason: collision with root package name */
    private int f6801D;

    /* renamed from: E  reason: collision with root package name */
    private int f6802E;

    /* renamed from: F  reason: collision with root package name */
    private long f6803F;

    /* renamed from: G  reason: collision with root package name */
    private String f6804G;

    /* renamed from: H  reason: collision with root package name */
    private byte[] f6805H;

    /* renamed from: I  reason: collision with root package name */
    private int f6806I;

    /* renamed from: J  reason: collision with root package name */
    private long f6807J;

    /* renamed from: K  reason: collision with root package name */
    private long f6808K;

    /* renamed from: L  reason: collision with root package name */
    private long f6809L;

    /* renamed from: M  reason: collision with root package name */
    private long f6810M;

    /* renamed from: N  reason: collision with root package name */
    private long f6811N;

    /* renamed from: O  reason: collision with root package name */
    private long f6812O;

    /* renamed from: P  reason: collision with root package name */
    private String f6813P;

    /* renamed from: Q  reason: collision with root package name */
    private boolean f6814Q;

    /* renamed from: R  reason: collision with root package name */
    private long f6815R;

    /* renamed from: S  reason: collision with root package name */
    private long f6816S;

    /* renamed from: a  reason: collision with root package name */
    private final X2 f6817a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6818b;

    /* renamed from: c  reason: collision with root package name */
    private String f6819c;

    /* renamed from: d  reason: collision with root package name */
    private String f6820d;

    /* renamed from: e  reason: collision with root package name */
    private String f6821e;

    /* renamed from: f  reason: collision with root package name */
    private String f6822f;

    /* renamed from: g  reason: collision with root package name */
    private long f6823g;

    /* renamed from: h  reason: collision with root package name */
    private long f6824h;

    /* renamed from: i  reason: collision with root package name */
    private long f6825i;

    /* renamed from: j  reason: collision with root package name */
    private String f6826j;

    /* renamed from: k  reason: collision with root package name */
    private long f6827k;

    /* renamed from: l  reason: collision with root package name */
    private String f6828l;

    /* renamed from: m  reason: collision with root package name */
    private long f6829m;

    /* renamed from: n  reason: collision with root package name */
    private long f6830n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6831o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f6832p;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f6833q;

    /* renamed from: r  reason: collision with root package name */
    private long f6834r;

    /* renamed from: s  reason: collision with root package name */
    private List f6835s;

    /* renamed from: t  reason: collision with root package name */
    private String f6836t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6837u;

    /* renamed from: v  reason: collision with root package name */
    private long f6838v;

    /* renamed from: w  reason: collision with root package name */
    private long f6839w;

    /* renamed from: x  reason: collision with root package name */
    private int f6840x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f6841y;

    /* renamed from: z  reason: collision with root package name */
    private Long f6842z;

    C1443w2(X2 x22, String str) {
        C0722p.k(x22);
        C0722p.e(str);
        this.f6817a = x22;
        this.f6818b = str;
        x22.b().h();
    }

    public final boolean A() {
        this.f6817a.b().h();
        return this.f6814Q;
    }

    public final void A0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6824h != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6824h = j5;
    }

    public final int B() {
        this.f6817a.b().h();
        return this.f6801D;
    }

    public final long B0() {
        this.f6817a.b().h();
        return this.f6825i;
    }

    public final void C(int i5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6801D != i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6801D = i5;
    }

    public final void C0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6825i != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6825i = j5;
    }

    public final int D() {
        this.f6817a.b().h();
        return this.f6802E;
    }

    public final String D0() {
        this.f6817a.b().h();
        return this.f6826j;
    }

    public final void E(int i5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6802E != i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6802E = i5;
    }

    public final void E0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6826j, str);
        this.f6826j = str;
    }

    public final void F(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6803F != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6803F = j5;
    }

    public final long F0() {
        this.f6817a.b().h();
        return this.f6827k;
    }

    public final long G() {
        this.f6817a.b().h();
        return this.f6803F;
    }

    public final void G0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6827k != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6827k = j5;
    }

    public final void H(String str) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6804G != str) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6804G = str;
    }

    public final String H0() {
        this.f6817a.b().h();
        return this.f6828l;
    }

    public final String I() {
        this.f6817a.b().h();
        return this.f6804G;
    }

    public final void I0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6828l, str);
        this.f6828l = str;
    }

    public final void J(byte[] bArr) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6805H != bArr) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6805H = bArr;
    }

    public final long J0() {
        this.f6817a.b().h();
        return this.f6829m;
    }

    public final byte[] K() {
        this.f6817a.b().h();
        return this.f6805H;
    }

    public final void K0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6829m != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6829m = j5;
    }

    public final void L(int i5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6806I != i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6806I = i5;
    }

    public final long L0() {
        this.f6817a.b().h();
        return this.f6830n;
    }

    public final int M() {
        this.f6817a.b().h();
        return this.f6806I;
    }

    public final String N() {
        this.f6817a.b().h();
        String str = this.f6813P;
        O((String) null);
        return str;
    }

    public final void O(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6813P, str);
        this.f6813P = str;
    }

    public final boolean P() {
        this.f6817a.b().h();
        return this.f6832p;
    }

    public final void Q(boolean z4) {
        boolean z5;
        this.f6817a.b().h();
        boolean z6 = this.f6814Q;
        if (this.f6832p != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f6814Q = z6 | z5;
        this.f6832p = z4;
    }

    public final Boolean R() {
        this.f6817a.b().h();
        return this.f6833q;
    }

    public final void S(Boolean bool) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6833q, bool);
        this.f6833q = bool;
    }

    public final List T() {
        this.f6817a.b().h();
        return this.f6835s;
    }

    public final void U(List list) {
        ArrayList arrayList;
        this.f6817a.b().h();
        if (!Objects.equals(this.f6835s, list)) {
            this.f6814Q = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f6835s = arrayList;
        }
    }

    public final boolean V() {
        this.f6817a.b().h();
        return this.f6837u;
    }

    public final void W(boolean z4) {
        boolean z5;
        this.f6817a.b().h();
        boolean z6 = this.f6814Q;
        if (this.f6837u != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f6814Q = z6 | z5;
        this.f6837u = z4;
    }

    public final long X() {
        this.f6817a.b().h();
        return this.f6838v;
    }

    public final void Y(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6838v != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6838v = j5;
    }

    public final long Z() {
        this.f6817a.b().h();
        return this.f6839w;
    }

    public final void a(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6830n != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6830n = j5;
    }

    public final void a0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6839w != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6839w = j5;
    }

    public final long b() {
        this.f6817a.b().h();
        return this.f6834r;
    }

    public final int b0() {
        this.f6817a.b().h();
        return this.f6840x;
    }

    public final void c(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6834r != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6834r = j5;
    }

    public final void c0(int i5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6840x != i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6840x = i5;
    }

    public final boolean d() {
        this.f6817a.b().h();
        return this.f6831o;
    }

    public final boolean d0() {
        this.f6817a.b().h();
        return this.f6841y;
    }

    public final void e(boolean z4) {
        boolean z5;
        this.f6817a.b().h();
        boolean z6 = this.f6814Q;
        if (this.f6831o != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f6814Q = z6 | z5;
        this.f6831o = z4;
    }

    public final void e0(boolean z4) {
        boolean z5;
        this.f6817a.b().h();
        boolean z6 = this.f6814Q;
        if (this.f6841y != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f6814Q = z6 | z5;
        this.f6841y = z4;
    }

    public final void f(long j5) {
        boolean z4;
        boolean z5 = false;
        if (j5 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.a(z4);
        this.f6817a.b().h();
        boolean z6 = this.f6814Q;
        if (this.f6823g != j5) {
            z5 = true;
        }
        this.f6814Q = z6 | z5;
        this.f6823g = j5;
    }

    public final Long f0() {
        this.f6817a.b().h();
        return this.f6842z;
    }

    public final long g() {
        this.f6817a.b().h();
        return this.f6823g;
    }

    public final void g0(Long l5) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6842z, l5);
        this.f6842z = l5;
    }

    public final long h() {
        this.f6817a.b().h();
        return this.f6815R;
    }

    public final Long h0() {
        this.f6817a.b().h();
        return this.f6798A;
    }

    public final void i(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6815R != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6815R = j5;
    }

    public final void i0(Long l5) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6798A, l5);
        this.f6798A = l5;
    }

    public final long j() {
        this.f6817a.b().h();
        return this.f6816S;
    }

    public final long j0() {
        this.f6817a.b().h();
        return this.f6799B;
    }

    public final void k(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6816S != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6816S = j5;
    }

    public final void k0(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6799B != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6799B = j5;
    }

    public final void l() {
        X2 x22 = this.f6817a;
        x22.b().h();
        long j5 = this.f6823g + 1;
        if (j5 > 2147483647L) {
            x22.a().r().b("Bundle index overflow. appId", C1402q2.x(this.f6818b));
            j5 = 0;
        }
        this.f6814Q = true;
        this.f6823g = j5;
    }

    public final String l0() {
        this.f6817a.b().h();
        return this.f6800C;
    }

    public final void m(long j5) {
        X2 x22 = this.f6817a;
        x22.b().h();
        long j6 = this.f6823g + j5;
        if (j6 > 2147483647L) {
            x22.a().r().b("Bundle index overflow. appId", C1402q2.x(this.f6818b));
            j6 = -1 + j5;
        }
        long j7 = this.f6803F + 1;
        if (j7 > 2147483647L) {
            x22.a().r().b("Delivery index overflow. appId", C1402q2.x(this.f6818b));
            j7 = 0;
        }
        this.f6814Q = true;
        this.f6823g = j6;
        this.f6803F = j7;
    }

    public final void m0(String str) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6800C != str) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6800C = str;
    }

    public final long n() {
        this.f6817a.b().h();
        return this.f6807J;
    }

    public final void n0() {
        this.f6817a.b().h();
        this.f6814Q = false;
    }

    public final void o(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6807J != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6807J = j5;
    }

    public final String o0() {
        this.f6817a.b().h();
        return this.f6818b;
    }

    public final long p() {
        this.f6817a.b().h();
        return this.f6808K;
    }

    public final String p0() {
        this.f6817a.b().h();
        return this.f6819c;
    }

    public final void q(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6808K != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6808K = j5;
    }

    public final void q0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6819c, str);
        this.f6819c = str;
    }

    public final long r() {
        this.f6817a.b().h();
        return this.f6809L;
    }

    public final String r0() {
        this.f6817a.b().h();
        return this.f6820d;
    }

    public final void s(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6809L != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6809L = j5;
    }

    public final void s0(String str) {
        this.f6817a.b().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f6814Q |= true ^ Objects.equals(this.f6820d, str);
        this.f6820d = str;
    }

    public final long t() {
        this.f6817a.b().h();
        return this.f6810M;
    }

    public final String t0() {
        this.f6817a.b().h();
        return this.f6836t;
    }

    public final void u(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6810M != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6810M = j5;
    }

    public final void u0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6836t, str);
        this.f6836t = str;
    }

    public final long v() {
        this.f6817a.b().h();
        return this.f6812O;
    }

    public final String v0() {
        this.f6817a.b().h();
        return this.f6821e;
    }

    public final void w(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6812O != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6812O = j5;
    }

    public final void w0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6821e, str);
        this.f6821e = str;
    }

    public final long x() {
        this.f6817a.b().h();
        return this.f6811N;
    }

    public final String x0() {
        this.f6817a.b().h();
        return this.f6822f;
    }

    public final void y(long j5) {
        boolean z4;
        this.f6817a.b().h();
        boolean z5 = this.f6814Q;
        if (this.f6811N != j5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f6814Q = z5 | z4;
        this.f6811N = j5;
    }

    public final void y0(String str) {
        this.f6817a.b().h();
        this.f6814Q |= !Objects.equals(this.f6822f, str);
        this.f6822f = str;
    }

    public final String z() {
        this.f6817a.b().h();
        return this.f6813P;
    }

    public final long z0() {
        this.f6817a.b().h();
        return this.f6824h;
    }
}
