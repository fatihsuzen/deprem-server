package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class M4 extends C1266y4 {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f5022b = Logger.getLogger(M4.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5023c = C1126i6.f();

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f5024d = 0;

    /* renamed from: a  reason: collision with root package name */
    N4 f5025a;

    /* synthetic */ M4(byte[] bArr) {
    }

    public static int E(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int a(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int b(String str) {
        int i5;
        try {
            i5 = C1153l6.b(str);
        } catch (C1144k6 unused) {
            i5 = str.getBytes(C1152l5.f5433a).length;
        }
        return E(i5) + i5;
    }

    public static int c(F5 f5) {
        int a5 = f5.a();
        return E(a5) + a5;
    }

    static int d(F5 f5, Q5 q5) {
        int f6 = ((C1213s4) f5).f(q5);
        return E(f6) + f6;
    }

    static int g(int i5, F5 f5, Q5 q5) {
        int E4 = E(i5 << 3);
        return E4 + E4 + ((C1213s4) f5).f(q5);
    }

    public abstract void A(long j5);

    public abstract void B(byte[] bArr, int i5, int i6);

    public abstract void C(String str);

    public abstract int D();

    public final void e() {
        if (D() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(String str, C1144k6 k6Var) {
        f5022b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", k6Var);
        byte[] bytes = str.getBytes(C1152l5.f5433a);
        try {
            int length = bytes.length;
            x(length);
            B(bytes, 0, length);
        } catch (IndexOutOfBoundsException e5) {
            throw new L4(e5);
        }
    }

    public abstract void i(int i5, int i6);

    public abstract void j(int i5, int i6);

    public abstract void k(int i5, int i6);

    public abstract void l(int i5, int i6);

    public abstract void m(int i5, long j5);

    public abstract void n(int i5, long j5);

    public abstract void o(int i5, boolean z4);

    public abstract void p(int i5, String str);

    public abstract void q(int i5, H4 h42);

    public abstract void r(H4 h42);

    /* access modifiers changed from: package-private */
    public abstract void s(byte[] bArr, int i5, int i6);

    /* access modifiers changed from: package-private */
    public abstract void t(int i5, F5 f5, Q5 q5);

    public abstract void u(F5 f5);

    public abstract void v(byte b5);

    public abstract void w(int i5);

    public abstract void x(int i5);

    public abstract void y(int i5);

    public abstract void z(long j5);
}
