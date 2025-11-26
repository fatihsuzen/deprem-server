package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.z4  reason: case insensitive filesystem */
public final class C1274z4 extends C1173o {

    /* renamed from: b  reason: collision with root package name */
    private final C1065c f5708b;

    public C1274z4(C1065c cVar) {
        this.f5708b = cVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.r k(java.lang.String r17, com.google.android.gms.internal.measurement.U1 r18, java.util.List r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            int r4 = r1.hashCode()
            java.lang.String r5 = "getEventName"
            r6 = 3
            java.lang.String r7 = "getTimestamp"
            java.lang.String r8 = "getParamValue"
            java.lang.String r9 = "getParams"
            java.lang.String r11 = "setParamValue"
            r12 = 4
            java.lang.String r13 = "setEventName"
            r14 = 2
            r15 = 1
            r10 = 0
            switch(r4) {
                case 21624207: goto L_0x0049;
                case 45521504: goto L_0x0041;
                case 146575578: goto L_0x0039;
                case 700587132: goto L_0x0031;
                case 920706790: goto L_0x0029;
                case 1570616835: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0051
        L_0x0021:
            boolean r4 = r1.equals(r13)
            if (r4 == 0) goto L_0x0051
            r4 = r12
            goto L_0x0052
        L_0x0029:
            boolean r4 = r1.equals(r11)
            if (r4 == 0) goto L_0x0051
            r4 = 5
            goto L_0x0052
        L_0x0031:
            boolean r4 = r1.equals(r9)
            if (r4 == 0) goto L_0x0051
            r4 = r14
            goto L_0x0052
        L_0x0039:
            boolean r4 = r1.equals(r8)
            if (r4 == 0) goto L_0x0051
            r4 = r15
            goto L_0x0052
        L_0x0041:
            boolean r4 = r1.equals(r7)
            if (r4 == 0) goto L_0x0051
            r4 = r6
            goto L_0x0052
        L_0x0049:
            boolean r4 = r1.equals(r5)
            if (r4 == 0) goto L_0x0051
            r4 = r10
            goto L_0x0052
        L_0x0051:
            r4 = -1
        L_0x0052:
            if (r4 == 0) goto L_0x0134
            if (r4 == r15) goto L_0x0114
            if (r4 == r14) goto L_0x00e1
            if (r4 == r6) goto L_0x00c9
            if (r4 == r12) goto L_0x008d
            r5 = 5
            if (r4 == r5) goto L_0x0064
            com.google.android.gms.internal.measurement.r r1 = super.k(r17, r18, r19)
            return r1
        L_0x0064:
            com.google.android.gms.internal.measurement.C1238v2.a(r11, r14, r3)
            java.lang.Object r1 = r3.get(r10)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r2.a(r1)
            java.lang.String r1 = r1.b()
            java.lang.Object r3 = r3.get(r15)
            com.google.android.gms.internal.measurement.r r3 = (com.google.android.gms.internal.measurement.r) r3
            com.google.android.gms.internal.measurement.r r2 = r2.a(r3)
            com.google.android.gms.internal.measurement.c r3 = r0.f5708b
            com.google.android.gms.internal.measurement.b r3 = r3.c()
            java.lang.Object r4 = com.google.android.gms.internal.measurement.C1238v2.j(r2)
            r3.d(r1, r4)
            return r2
        L_0x008d:
            com.google.android.gms.internal.measurement.C1238v2.a(r13, r15, r3)
            java.lang.Object r1 = r3.get(r10)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r2.a(r1)
            com.google.android.gms.internal.measurement.r r2 = com.google.android.gms.internal.measurement.r.f5553b0
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00c1
            com.google.android.gms.internal.measurement.r r2 = com.google.android.gms.internal.measurement.r.f5554c0
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00c1
            com.google.android.gms.internal.measurement.c r2 = r0.f5708b
            com.google.android.gms.internal.measurement.b r2 = r2.c()
            java.lang.String r3 = r1.b()
            r2.c(r3)
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            java.lang.String r1 = r1.b()
            r2.<init>(r1)
            return r2
        L_0x00c1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Illegal event name"
            r1.<init>(r2)
            throw r1
        L_0x00c9:
            com.google.android.gms.internal.measurement.C1238v2.a(r7, r10, r3)
            com.google.android.gms.internal.measurement.c r1 = r0.f5708b
            com.google.android.gms.internal.measurement.b r1 = r1.c()
            com.google.android.gms.internal.measurement.j r2 = new com.google.android.gms.internal.measurement.j
            long r3 = r1.a()
            double r3 = (double) r3
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            return r2
        L_0x00e1:
            com.google.android.gms.internal.measurement.C1238v2.a(r9, r10, r3)
            com.google.android.gms.internal.measurement.c r1 = r0.f5708b
            com.google.android.gms.internal.measurement.b r1 = r1.c()
            java.util.Map r1 = r1.f()
            com.google.android.gms.internal.measurement.o r2 = new com.google.android.gms.internal.measurement.o
            r2.<init>()
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x00fb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0113
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.measurement.r r5 = com.google.android.gms.internal.measurement.W2.a(r5)
            r2.g(r4, r5)
            goto L_0x00fb
        L_0x0113:
            return r2
        L_0x0114:
            com.google.android.gms.internal.measurement.C1238v2.a(r8, r15, r3)
            java.lang.Object r1 = r3.get(r10)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r2.a(r1)
            java.lang.String r1 = r1.b()
            com.google.android.gms.internal.measurement.c r2 = r0.f5708b
            com.google.android.gms.internal.measurement.b r2 = r2.c()
            java.lang.Object r1 = r2.e(r1)
            com.google.android.gms.internal.measurement.r r1 = com.google.android.gms.internal.measurement.W2.a(r1)
            return r1
        L_0x0134:
            com.google.android.gms.internal.measurement.C1238v2.a(r5, r10, r3)
            com.google.android.gms.internal.measurement.c r1 = r0.f5708b
            com.google.android.gms.internal.measurement.b r1 = r1.c()
            com.google.android.gms.internal.measurement.v r2 = new com.google.android.gms.internal.measurement.v
            java.lang.String r1 = r1.b()
            r2.<init>(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1274z4.k(java.lang.String, com.google.android.gms.internal.measurement.U1, java.util.List):com.google.android.gms.internal.measurement.r");
    }
}
