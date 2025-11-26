package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.H1;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.d  reason: case insensitive filesystem */
final class C1301d extends C1293c {

    /* renamed from: g  reason: collision with root package name */
    private final H1 f6256g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C1309e f6257h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1301d(C1309e eVar, String str, int i5, H1 h12) {
        super(str, i5);
        Objects.requireNonNull(eVar);
        this.f6257h = eVar;
        this.f6256g = h12;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f6256g.G();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v16, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r13, java.lang.Long r14, com.google.android.gms.internal.measurement.C1203r3 r15, boolean r16) {
        /*
            r12 = this;
            com.google.android.gms.internal.measurement.O6.a()
            com.google.android.gms.measurement.internal.e r0 = r12.f6257h
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            com.google.android.gms.measurement.internal.m r1 = r0.w()
            java.lang.String r2 = r12.f6230a
            com.google.android.gms.measurement.internal.c2 r3 = com.google.android.gms.measurement.internal.C1304d2.f6269E0
            boolean r1 = r1.H(r2, r3)
            com.google.android.gms.internal.measurement.H1 r2 = r12.f6256g
            boolean r3 = r2.J()
            boolean r4 = r2.K()
            boolean r5 = r2.M()
            r6 = 0
            r7 = 1
            if (r3 != 0) goto L_0x0029
            if (r4 != 0) goto L_0x0029
            if (r5 == 0) goto L_0x002b
        L_0x0029:
            r3 = r7
            goto L_0x002c
        L_0x002b:
            r3 = r6
        L_0x002c:
            r4 = 0
            if (r16 == 0) goto L_0x0053
            if (r3 != 0) goto L_0x0053
            com.google.android.gms.measurement.internal.q2 r13 = r0.a()
            com.google.android.gms.measurement.internal.o2 r13 = r13.w()
            int r14 = r12.f6231b
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            boolean r15 = r2.F()
            if (r15 == 0) goto L_0x004d
            int r15 = r2.G()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
        L_0x004d:
            java.lang.String r15 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r13.c(r15, r14, r4)
            return r7
        L_0x0053:
            com.google.android.gms.internal.measurement.B1 r8 = r2.I()
            boolean r9 = r8.K()
            boolean r10 = r15.K()
            if (r10 == 0) goto L_0x0094
            boolean r10 = r8.H()
            if (r10 != 0) goto L_0x0082
            com.google.android.gms.measurement.internal.q2 r8 = r0.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()
            com.google.android.gms.measurement.internal.j2 r9 = r0.D()
            java.lang.String r10 = r15.H()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No number filter for long property. property"
            r8.b(r10, r9)
            goto L_0x0160
        L_0x0082:
            long r10 = r15.L()
            com.google.android.gms.internal.measurement.F1 r4 = r8.I()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.g(r10, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.e(r4, r9)
            goto L_0x0160
        L_0x0094:
            boolean r10 = r15.O()
            if (r10 == 0) goto L_0x00cd
            boolean r10 = r8.H()
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.q2 r8 = r0.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()
            com.google.android.gms.measurement.internal.j2 r9 = r0.D()
            java.lang.String r10 = r15.H()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No number filter for double property. property"
            r8.b(r10, r9)
            goto L_0x0160
        L_0x00bb:
            double r10 = r15.P()
            com.google.android.gms.internal.measurement.F1 r4 = r8.I()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.h(r10, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.e(r4, r9)
            goto L_0x0160
        L_0x00cd:
            boolean r10 = r15.I()
            if (r10 == 0) goto L_0x0147
            boolean r10 = r8.F()
            if (r10 != 0) goto L_0x0132
            boolean r10 = r8.H()
            if (r10 != 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.q2 r8 = r0.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()
            com.google.android.gms.measurement.internal.j2 r9 = r0.D()
            java.lang.String r10 = r15.H()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "No string or number filter defined. property"
            r8.b(r10, r9)
            goto L_0x0160
        L_0x00f9:
            java.lang.String r10 = r15.J()
            boolean r10 = com.google.android.gms.measurement.internal.u6.O(r10)
            if (r10 == 0) goto L_0x0114
            java.lang.String r4 = r15.J()
            com.google.android.gms.internal.measurement.F1 r8 = r8.I()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.i(r4, r8)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.e(r4, r9)
            goto L_0x0160
        L_0x0114:
            com.google.android.gms.measurement.internal.q2 r8 = r0.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()
            com.google.android.gms.measurement.internal.j2 r9 = r0.D()
            java.lang.String r10 = r15.H()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = r15.J()
            java.lang.String r11 = "Invalid user property value for Numeric number filter. property, value"
            r8.c(r11, r9, r10)
            goto L_0x0160
        L_0x0132:
            java.lang.String r4 = r15.J()
            com.google.android.gms.internal.measurement.L1 r8 = r8.G()
            com.google.android.gms.measurement.internal.q2 r10 = r0.a()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.f(r4, r8, r10)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C1293c.e(r4, r9)
            goto L_0x0160
        L_0x0147:
            com.google.android.gms.measurement.internal.q2 r8 = r0.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()
            com.google.android.gms.measurement.internal.j2 r9 = r0.D()
            java.lang.String r10 = r15.H()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "User property has no value, property"
            r8.b(r10, r9)
        L_0x0160:
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            if (r4 != 0) goto L_0x016d
            java.lang.String r8 = "null"
            goto L_0x016e
        L_0x016d:
            r8 = r4
        L_0x016e:
            java.lang.String r9 = "Property filter result"
            r0.b(r9, r8)
            if (r4 != 0) goto L_0x0176
            return r6
        L_0x0176:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.f6232c = r0
            if (r5 == 0) goto L_0x0184
            boolean r0 = r4.booleanValue()
            if (r0 == 0) goto L_0x0183
            goto L_0x0184
        L_0x0183:
            return r7
        L_0x0184:
            if (r16 == 0) goto L_0x018c
            boolean r0 = r2.J()
            if (r0 == 0) goto L_0x018e
        L_0x018c:
            r12.f6233d = r4
        L_0x018e:
            boolean r0 = r4.booleanValue()
            if (r0 == 0) goto L_0x01cd
            if (r3 == 0) goto L_0x01cd
            boolean r0 = r15.F()
            if (r0 == 0) goto L_0x01cd
            long r3 = r15.G()
            if (r13 == 0) goto L_0x01a6
            long r3 = r13.longValue()
        L_0x01a6:
            if (r1 == 0) goto L_0x01ba
            boolean r13 = r2.J()
            if (r13 == 0) goto L_0x01ba
            boolean r13 = r2.K()
            if (r13 != 0) goto L_0x01ba
            if (r14 == 0) goto L_0x01ba
            long r3 = r14.longValue()
        L_0x01ba:
            boolean r13 = r2.K()
            if (r13 == 0) goto L_0x01c7
            java.lang.Long r13 = java.lang.Long.valueOf(r3)
            r12.f6235f = r13
            goto L_0x01cd
        L_0x01c7:
            java.lang.Long r13 = java.lang.Long.valueOf(r3)
            r12.f6234e = r13
        L_0x01cd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1301d.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.r3, boolean):boolean");
    }
}
