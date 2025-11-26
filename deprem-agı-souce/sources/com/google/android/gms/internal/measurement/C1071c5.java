package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.c5  reason: case insensitive filesystem */
public abstract class C1071c5 extends C1204r4 {

    /* renamed from: a  reason: collision with root package name */
    private final C1089e5 f5318a;

    /* renamed from: b  reason: collision with root package name */
    protected C1089e5 f5319b;

    protected C1071c5(C1089e5 e5Var) {
        this.f5318a = e5Var;
        if (!e5Var.j()) {
            this.f5319b = e5Var.m();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void i(Object obj, Object obj2) {
        N5.a().b(obj.getClass()).b(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ C1204r4 f(byte[] bArr, int i5, int i6) {
        R4 r42 = R4.f5163c;
        int i7 = N5.f5036d;
        q(bArr, 0, i6, R4.f5163c);
        return this;
    }

    public final /* bridge */ /* synthetic */ C1204r4 g(byte[] bArr, int i5, int i6, R4 r42) {
        q(bArr, 0, i6, r42);
        return this;
    }

    /* access modifiers changed from: protected */
    public final void j() {
        if (!this.f5319b.j()) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        C1089e5 m5 = this.f5318a.m();
        i(m5, this.f5319b);
        this.f5319b = m5;
    }

    /* renamed from: m */
    public final C1071c5 clone() {
        C1071c5 c5Var = (C1071c5) this.f5318a.E(5, (Object) null, (Object) null);
        c5Var.f5319b = u();
        return c5Var;
    }

    /* renamed from: n */
    public C1089e5 u() {
        if (!this.f5319b.j()) {
            return this.f5319b;
        }
        this.f5319b.o();
        return this.f5319b;
    }

    public final C1089e5 o() {
        C1089e5 n5 = u();
        if (n5.i()) {
            return n5;
        }
        throw new C1054a6(n5);
    }

    public final C1071c5 p(C1089e5 e5Var) {
        if (!this.f5318a.equals(e5Var)) {
            if (!this.f5319b.j()) {
                k();
            }
            i(this.f5319b, e5Var);
        }
        return this;
    }

    public final C1071c5 q(byte[] bArr, int i5, int i6, R4 r42) {
        if (!this.f5319b.j()) {
            k();
        }
        try {
            N5.a().b(this.f5319b.getClass()).f(this.f5319b, bArr, 0, i6, new C1240v4(r42));
            return this;
        } catch (C1170n5 e5) {
            throw e5;
        } catch (IndexOutOfBoundsException unused) {
            throw new C1170n5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (IOException e6) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
        }
    }
}
