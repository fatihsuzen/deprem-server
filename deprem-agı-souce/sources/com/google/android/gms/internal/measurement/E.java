package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public abstract class E {
    /* JADX WARNING: type inference failed for: r1v90, types: [com.google.android.gms.internal.measurement.r] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.r a(java.lang.String r25, com.google.android.gms.internal.measurement.C1092f r26, com.google.android.gms.internal.measurement.U1 r27, java.util.List r28) {
        /*
            r0 = r25
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            int r5 = r0.hashCode()
            java.lang.String r7 = "toString"
            java.lang.String r8 = "filter"
            java.lang.String r9 = "forEach"
            java.lang.String r10 = "lastIndexOf"
            java.lang.String r11 = "map"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "join"
            java.lang.String r14 = "some"
            java.lang.String r15 = "sort"
            java.lang.String r6 = "every"
            r16 = r5
            java.lang.String r5 = "shift"
            r17 = r4
            java.lang.String r4 = "slice"
            java.lang.String r3 = "reverse"
            java.lang.String r1 = "indexOf"
            r18 = -1
            switch(r16) {
                case -1776922004: goto L_0x00ec;
                case -1354795244: goto L_0x00e2;
                case -1274492040: goto L_0x00da;
                case -934873754: goto L_0x00cf;
                case -895859076: goto L_0x00c4;
                case -678635926: goto L_0x00bc;
                case -467511597: goto L_0x00b4;
                case -277637751: goto L_0x00a9;
                case 107868: goto L_0x00a1;
                case 111185: goto L_0x0098;
                case 3267882: goto L_0x008f;
                case 3452698: goto L_0x0083;
                case 3536116: goto L_0x0079;
                case 3536286: goto L_0x006f;
                case 96891675: goto L_0x0066;
                case 109407362: goto L_0x005c;
                case 109526418: goto L_0x0052;
                case 965561430: goto L_0x0046;
                case 1099846370: goto L_0x003c;
                case 1943291465: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x00f5
        L_0x0033:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00f5
            r0 = 4
            goto L_0x00f7
        L_0x003c:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00f5
            r0 = 12
            goto L_0x00f7
        L_0x0046:
            java.lang.String r2 = "reduceRight"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 11
            goto L_0x00f7
        L_0x0052:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00f5
            r0 = 14
            goto L_0x00f7
        L_0x005c:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x00f5
            r0 = 13
            goto L_0x00f7
        L_0x0066:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00f5
            r0 = 1
            goto L_0x00f7
        L_0x006f:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00f5
            r0 = 16
            goto L_0x00f7
        L_0x0079:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00f5
            r0 = 15
            goto L_0x00f7
        L_0x0083:
            java.lang.String r2 = "push"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 9
            goto L_0x00f7
        L_0x008f:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00f5
            r0 = 5
            goto L_0x00f7
        L_0x0098:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00f5
            r0 = 8
            goto L_0x00f7
        L_0x00a1:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00f5
            r0 = 7
            goto L_0x00f7
        L_0x00a9:
            java.lang.String r2 = "unshift"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 19
            goto L_0x00f7
        L_0x00b4:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00f5
            r0 = 6
            goto L_0x00f7
        L_0x00bc:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00f5
            r0 = 3
            goto L_0x00f7
        L_0x00c4:
            java.lang.String r2 = "splice"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 17
            goto L_0x00f7
        L_0x00cf:
            java.lang.String r2 = "reduce"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 10
            goto L_0x00f7
        L_0x00da:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00f5
            r0 = 2
            goto L_0x00f7
        L_0x00e2:
            java.lang.String r2 = "concat"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x00f5
            r0 = 0
            goto L_0x00f7
        L_0x00ec:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00f5
            r0 = 18
            goto L_0x00f7
        L_0x00f5:
            r0 = r18
        L_0x00f7:
            java.lang.String r2 = ","
            r25 = r0
            java.lang.String r0 = "Callback should be a method"
            r21 = r8
            r22 = r9
            r23 = 0
            r8 = 0
            switch(r25) {
                case 0: goto L_0x070b;
                case 1: goto L_0x06c9;
                case 2: goto L_0x0668;
                case 3: goto L_0x0636;
                case 4: goto L_0x05a7;
                case 5: goto L_0x0569;
                case 6: goto L_0x04c4;
                case 7: goto L_0x0492;
                case 8: goto L_0x0477;
                case 9: goto L_0x0440;
                case 10: goto L_0x0434;
                case 11: goto L_0x0428;
                case 12: goto L_0x03f1;
                case 13: goto L_0x03d8;
                case 14: goto L_0x034f;
                case 15: goto L_0x02d6;
                case 16: goto L_0x027d;
                case 17: goto L_0x01b3;
                case 18: goto L_0x01a1;
                case 19: goto L_0x010f;
                default: goto L_0x0107;
            }
        L_0x0107:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x010f:
            boolean r0 = r28.isEmpty()
            if (r0 != 0) goto L_0x0190
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>()
            java.util.Iterator r1 = r28.iterator()
        L_0x011e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0144
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.r r2 = (com.google.android.gms.internal.measurement.r) r2
            r3 = r27
            com.google.android.gms.internal.measurement.r r2 = r3.a(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.C1110h
            if (r4 != 0) goto L_0x013c
            int r4 = r0.o()
            r0.r(r4, r2)
            goto L_0x011e
        L_0x013c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r1 = r0.o()
            java.util.Iterator r2 = r26.n()
        L_0x014c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x016b
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r9 = r26
            com.google.android.gms.internal.measurement.r r3 = r9.q(r3)
            r0.r(r4, r3)
            goto L_0x014c
        L_0x016b:
            r9 = r26
            r9.t()
            java.util.Iterator r1 = r0.n()
        L_0x0174:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0192
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.r r2 = r0.q(r2)
            r9.r(r3, r2)
            goto L_0x0174
        L_0x0190:
            r9 = r26
        L_0x0192:
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            int r1 = r9.o()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x01a1:
            r9 = r26
            r6 = r28
            r0 = 0
            com.google.android.gms.internal.measurement.C1238v2.a(r7, r0, r6)
            com.google.android.gms.internal.measurement.v r0 = new com.google.android.gms.internal.measurement.v
            java.lang.String r1 = r9.w(r2)
            r0.<init>(r1)
            return r0
        L_0x01b3:
            r9 = r26
            r3 = r27
            r6 = r28
            r0 = 0
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x01c6
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>()
            return r0
        L_0x01c6:
            java.lang.Object r1 = r6.get(r0)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
            int r1 = (int) r1
            if (r1 >= 0) goto L_0x01e9
            int r2 = r9.o()
            int r1 = r1 + r2
            int r1 = java.lang.Math.max(r0, r1)
            goto L_0x01f3
        L_0x01e9:
            int r0 = r9.o()
            if (r1 <= r0) goto L_0x01f3
            int r1 = r9.o()
        L_0x01f3:
            int r0 = r9.o()
            com.google.android.gms.internal.measurement.f r2 = new com.google.android.gms.internal.measurement.f
            r2.<init>()
            int r4 = r6.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0269
            java.lang.Object r4 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r4 = (com.google.android.gms.internal.measurement.r) r4
            com.google.android.gms.internal.measurement.r r4 = r3.a(r4)
            java.lang.Double r4 = r4.C()
            double r4 = r4.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.C1238v2.i(r4)
            int r4 = (int) r4
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            if (r4 <= 0) goto L_0x023b
            r5 = r1
        L_0x0222:
            int r7 = r1 + r4
            int r7 = java.lang.Math.min(r0, r7)
            if (r5 >= r7) goto L_0x023b
            com.google.android.gms.internal.measurement.r r7 = r9.q(r1)
            int r8 = r2.o()
            r2.r(r8, r7)
            r9.v(r1)
            int r5 = r5 + 1
            goto L_0x0222
        L_0x023b:
            int r0 = r6.size()
            r4 = 2
            if (r0 <= r4) goto L_0x027c
            r0 = 2
        L_0x0243:
            int r4 = r6.size()
            if (r0 >= r4) goto L_0x027c
            java.lang.Object r4 = r6.get(r0)
            com.google.android.gms.internal.measurement.r r4 = (com.google.android.gms.internal.measurement.r) r4
            com.google.android.gms.internal.measurement.r r4 = r3.a(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.C1110h
            if (r5 != 0) goto L_0x0261
            int r5 = r1 + r0
            int r5 = r5 + -2
            r9.u(r5, r4)
            int r0 = r0 + 1
            goto L_0x0243
        L_0x0261:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0269:
            if (r1 >= r0) goto L_0x027c
            com.google.android.gms.internal.measurement.r r3 = r9.q(r1)
            int r4 = r2.o()
            r2.r(r4, r3)
            r9.r(r1, r8)
            int r1 = r1 + 1
            goto L_0x0269
        L_0x027c:
            return r2
        L_0x027d:
            r9 = r26
            r3 = r27
            r6 = r28
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.c(r15, r5, r6)
            int r0 = r9.o()
            r4 = 2
            if (r0 < r4) goto L_0x0427
            java.util.List r0 = r9.l()
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x02b3
            r5 = 0
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1137k
            if (r2 == 0) goto L_0x02ab
            r8 = r1
            com.google.android.gms.internal.measurement.k r8 = (com.google.android.gms.internal.measurement.C1137k) r8
            goto L_0x02b3
        L_0x02ab:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02b3:
            com.google.android.gms.internal.measurement.C r1 = new com.google.android.gms.internal.measurement.C
            r1.<init>(r8, r3)
            java.util.Collections.sort(r0, r1)
            r9.t()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x02c3:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0427
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            int r3 = r2 + 1
            r9.r(r2, r1)
            r2 = r3
            goto L_0x02c3
        L_0x02d6:
            r9 = r26
            r3 = r27
            r6 = r28
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.a(r14, r5, r6)
            r5 = 0
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1137k
            if (r2 == 0) goto L_0x0349
            int r0 = r9.o()
            if (r0 != 0) goto L_0x02f8
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5559h0
            return r0
        L_0x02f8:
            com.google.android.gms.internal.measurement.k r1 = (com.google.android.gms.internal.measurement.C1137k) r1
            java.util.Iterator r0 = r9.n()
        L_0x02fe:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0346
            java.lang.Object r2 = r0.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r9.s(r2)
            if (r4 == 0) goto L_0x02fe
            com.google.android.gms.internal.measurement.r r4 = r9.q(r2)
            double r5 = (double) r2
            com.google.android.gms.internal.measurement.j r2 = new com.google.android.gms.internal.measurement.j
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r2.<init>(r5)
            r5 = 3
            com.google.android.gms.internal.measurement.r[] r6 = new com.google.android.gms.internal.measurement.r[r5]
            r16 = 0
            r6[r16] = r4
            r20 = 1
            r6[r20] = r2
            r19 = 2
            r6[r19] = r9
            java.util.List r2 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.r r2 = r1.a(r3, r2)
            java.lang.Boolean r2 = r2.d()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x02fe
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5558g0
            return r0
        L_0x0346:
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5559h0
            return r0
        L_0x0349:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x034f:
            r9 = r26
            r3 = r27
            r6 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r4, r0, r6)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0364
            com.google.android.gms.internal.measurement.r r0 = r9.j()
            return r0
        L_0x0364:
            int r0 = r9.o()
            double r0 = (double) r0
            r5 = 0
            java.lang.Object r2 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r2 = (com.google.android.gms.internal.measurement.r) r2
            com.google.android.gms.internal.measurement.r r2 = r3.a(r2)
            java.lang.Double r2 = r2.C()
            double r4 = r2.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.C1238v2.i(r4)
            int r2 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r2 >= 0) goto L_0x038c
            double r4 = r4 + r0
            r7 = r23
            double r4 = java.lang.Math.max(r4, r7)
            goto L_0x0390
        L_0x038c:
            double r4 = java.lang.Math.min(r4, r0)
        L_0x0390:
            int r2 = r6.size()
            r7 = 2
            if (r2 != r7) goto L_0x03be
            r2 = 1
            java.lang.Object r2 = r6.get(r2)
            com.google.android.gms.internal.measurement.r r2 = (com.google.android.gms.internal.measurement.r) r2
            com.google.android.gms.internal.measurement.r r2 = r3.a(r2)
            java.lang.Double r2 = r2.C()
            double r2 = r2.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.C1238v2.i(r2)
            r7 = 0
            int r6 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x03ba
            double r0 = r0 + r2
            double r0 = java.lang.Math.max(r0, r7)
            goto L_0x03be
        L_0x03ba:
            double r0 = java.lang.Math.min(r0, r2)
        L_0x03be:
            com.google.android.gms.internal.measurement.f r2 = new com.google.android.gms.internal.measurement.f
            r2.<init>()
            int r3 = (int) r4
        L_0x03c4:
            double r4 = (double) r3
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.r r4 = r9.q(r3)
            int r5 = r2.o()
            r2.r(r5, r4)
            int r3 = r3 + 1
            goto L_0x03c4
        L_0x03d7:
            return r2
        L_0x03d8:
            r9 = r26
            r6 = r28
            r0 = 0
            com.google.android.gms.internal.measurement.C1238v2.a(r5, r0, r6)
            int r1 = r9.o()
            if (r1 != 0) goto L_0x03e9
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            return r0
        L_0x03e9:
            com.google.android.gms.internal.measurement.r r1 = r9.q(r0)
            r9.v(r0)
            return r1
        L_0x03f1:
            r9 = r26
            r6 = r28
            r0 = 0
            com.google.android.gms.internal.measurement.C1238v2.a(r3, r0, r6)
            int r0 = r9.o()
            if (r0 == 0) goto L_0x0427
            r2 = 0
        L_0x0400:
            int r1 = r0 / 2
            if (r2 >= r1) goto L_0x0427
            boolean r1 = r9.s(r2)
            if (r1 == 0) goto L_0x0424
            com.google.android.gms.internal.measurement.r r1 = r9.q(r2)
            r9.r(r2, r8)
            int r3 = r0 + -1
            int r3 = r3 - r2
            boolean r4 = r9.s(r3)
            if (r4 == 0) goto L_0x0421
            com.google.android.gms.internal.measurement.r r4 = r9.q(r3)
            r9.r(r2, r4)
        L_0x0421:
            r9.r(r3, r1)
        L_0x0424:
            int r2 = r2 + 1
            goto L_0x0400
        L_0x0427:
            return r9
        L_0x0428:
            r9 = r26
            r3 = r27
            r6 = r28
            r5 = 0
            com.google.android.gms.internal.measurement.r r0 = b(r9, r3, r6, r5)
            return r0
        L_0x0434:
            r9 = r26
            r3 = r27
            r6 = r28
            r5 = 1
            com.google.android.gms.internal.measurement.r r0 = b(r9, r3, r6, r5)
            return r0
        L_0x0440:
            r9 = r26
            r3 = r27
            r6 = r28
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0468
            java.util.Iterator r0 = r6.iterator()
        L_0x0450:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0468
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            int r2 = r9.o()
            r9.r(r2, r1)
            goto L_0x0450
        L_0x0468:
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            int r1 = r9.o()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0477:
            r9 = r26
            r6 = r28
            r5 = 0
            com.google.android.gms.internal.measurement.C1238v2.a(r12, r5, r6)
            int r0 = r9.o()
            if (r0 != 0) goto L_0x0488
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            return r0
        L_0x0488:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.r r1 = r9.q(r0)
            r9.v(r0)
            return r1
        L_0x0492:
            r9 = r26
            r3 = r27
            r6 = r28
            r2 = 1
            r5 = 0
            com.google.android.gms.internal.measurement.C1238v2.a(r11, r2, r6)
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1191q
            if (r2 == 0) goto L_0x04be
            int r0 = r9.o()
            if (r0 != 0) goto L_0x04b7
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>()
            return r0
        L_0x04b7:
            com.google.android.gms.internal.measurement.q r1 = (com.google.android.gms.internal.measurement.C1191q) r1
            com.google.android.gms.internal.measurement.f r0 = c(r9, r3, r1, r8, r8)
            return r0
        L_0x04be:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x04c4:
            r9 = r26
            r3 = r27
            r6 = r28
            r4 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r10, r4, r6)
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x04e1
            r5 = 0
            java.lang.Object r0 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r0 = (com.google.android.gms.internal.measurement.r) r0
            com.google.android.gms.internal.measurement.r r0 = r3.a(r0)
        L_0x04e1:
            int r1 = r9.o()
            int r1 = r1 + -1
            int r2 = r6.size()
            r5 = 1
            if (r2 <= r5) goto L_0x0528
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            java.lang.Double r2 = r1.C()
            double r2 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 == 0) goto L_0x0510
            int r1 = r9.o()
            int r1 = r1 + -1
            double r1 = (double) r1
        L_0x050d:
            r23 = 0
            goto L_0x051d
        L_0x0510:
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
            goto L_0x050d
        L_0x051d:
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 >= 0) goto L_0x052b
            int r3 = r9.o()
            double r3 = (double) r3
            double r1 = r1 + r3
            goto L_0x052b
        L_0x0528:
            r23 = 0
            double r1 = (double) r1
        L_0x052b:
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 >= 0) goto L_0x0537
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            r4 = r17
            r0.<init>(r4)
            return r0
        L_0x0537:
            r4 = r17
            int r3 = r9.o()
            double r5 = (double) r3
            double r1 = java.lang.Math.min(r5, r1)
            int r1 = (int) r1
        L_0x0543:
            if (r1 < 0) goto L_0x0563
            boolean r2 = r9.s(r1)
            if (r2 == 0) goto L_0x0560
            com.google.android.gms.internal.measurement.r r2 = r9.q(r1)
            boolean r2 = com.google.android.gms.internal.measurement.C1238v2.f(r2, r0)
            if (r2 == 0) goto L_0x0560
            double r0 = (double) r1
            com.google.android.gms.internal.measurement.j r2 = new com.google.android.gms.internal.measurement.j
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            return r2
        L_0x0560:
            int r1 = r1 + -1
            goto L_0x0543
        L_0x0563:
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            r0.<init>(r4)
            return r0
        L_0x0569:
            r9 = r26
            r3 = r27
            r6 = r28
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.c(r13, r5, r6)
            int r0 = r9.o()
            if (r0 != 0) goto L_0x057c
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5560i0
            return r0
        L_0x057c:
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x059d
            r5 = 0
            java.lang.Object r0 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r0 = (com.google.android.gms.internal.measurement.r) r0
            com.google.android.gms.internal.measurement.r r0 = r3.a(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C1182p
            if (r1 != 0) goto L_0x059b
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C1244w
            if (r1 == 0) goto L_0x0596
            goto L_0x059b
        L_0x0596:
            java.lang.String r2 = r0.b()
            goto L_0x059d
        L_0x059b:
            java.lang.String r2 = ""
        L_0x059d:
            com.google.android.gms.internal.measurement.v r0 = new com.google.android.gms.internal.measurement.v
            java.lang.String r1 = r9.w(r2)
            r0.<init>(r1)
            return r0
        L_0x05a7:
            r9 = r26
            r3 = r27
            r6 = r28
            r4 = r17
            r0 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r1, r0, r6)
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x05c6
            r5 = 0
            java.lang.Object r0 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r0 = (com.google.android.gms.internal.measurement.r) r0
            com.google.android.gms.internal.measurement.r r0 = r3.a(r0)
        L_0x05c6:
            int r1 = r6.size()
            r5 = 1
            if (r1 <= r5) goto L_0x05ff
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            java.lang.Double r1 = r1.C()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.C1238v2.i(r1)
            int r3 = r9.o()
            double r5 = (double) r3
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x05f2
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            r0.<init>(r4)
            return r0
        L_0x05f2:
            r23 = 0
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 >= 0) goto L_0x0603
            int r3 = r9.o()
            double r5 = (double) r3
            double r1 = r1 + r5
            goto L_0x0603
        L_0x05ff:
            r23 = 0
            r1 = r23
        L_0x0603:
            java.util.Iterator r3 = r9.n()
        L_0x0607:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0630
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            double r6 = (double) r5
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 < 0) goto L_0x0607
            com.google.android.gms.internal.measurement.r r5 = r9.q(r5)
            boolean r5 = com.google.android.gms.internal.measurement.C1238v2.f(r5, r0)
            if (r5 == 0) goto L_0x0607
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            java.lang.Double r1 = java.lang.Double.valueOf(r6)
            r0.<init>(r1)
            return r0
        L_0x0630:
            com.google.android.gms.internal.measurement.j r0 = new com.google.android.gms.internal.measurement.j
            r0.<init>(r4)
            return r0
        L_0x0636:
            r9 = r26
            r3 = r27
            r6 = r28
            r1 = r22
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.a(r1, r5, r6)
            r5 = 0
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1191q
            if (r2 == 0) goto L_0x0662
            int r0 = r9.p()
            if (r0 != 0) goto L_0x065a
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            return r0
        L_0x065a:
            com.google.android.gms.internal.measurement.q r1 = (com.google.android.gms.internal.measurement.C1191q) r1
            c(r9, r3, r1, r8, r8)
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5553b0
            return r0
        L_0x0662:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0668:
            r9 = r26
            r3 = r27
            r6 = r28
            r1 = r21
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.a(r1, r5, r6)
            r5 = 0
            java.lang.Object r1 = r6.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1191q
            if (r2 == 0) goto L_0x06c3
            int r0 = r9.p()
            if (r0 != 0) goto L_0x068f
            com.google.android.gms.internal.measurement.f r0 = new com.google.android.gms.internal.measurement.f
            r0.<init>()
            return r0
        L_0x068f:
            com.google.android.gms.internal.measurement.r r0 = r9.j()
            com.google.android.gms.internal.measurement.f r0 = (com.google.android.gms.internal.measurement.C1092f) r0
            com.google.android.gms.internal.measurement.q r1 = (com.google.android.gms.internal.measurement.C1191q) r1
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.f r1 = c(r9, r3, r1, r8, r2)
            com.google.android.gms.internal.measurement.f r2 = new com.google.android.gms.internal.measurement.f
            r2.<init>()
            java.util.Iterator r1 = r1.n()
        L_0x06a6:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x06c2
            java.lang.Object r3 = r1.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.r r3 = r0.q(r3)
            int r4 = r2.o()
            r2.r(r4, r3)
            goto L_0x06a6
        L_0x06c2:
            return r2
        L_0x06c3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x06c9:
            r9 = r26
            r3 = r27
            r1 = r28
            r5 = 1
            com.google.android.gms.internal.measurement.C1238v2.a(r6, r5, r1)
            r5 = 0
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.r r1 = (com.google.android.gms.internal.measurement.r) r1
            com.google.android.gms.internal.measurement.r r1 = r3.a(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.C1191q
            if (r2 == 0) goto L_0x0705
            int r0 = r9.o()
            if (r0 != 0) goto L_0x06eb
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5558g0
            return r0
        L_0x06eb:
            com.google.android.gms.internal.measurement.q r1 = (com.google.android.gms.internal.measurement.C1191q) r1
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.f r0 = c(r9, r3, r1, r0, r2)
            int r0 = r0.o()
            int r1 = r9.o()
            if (r0 == r1) goto L_0x0702
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5559h0
            return r0
        L_0x0702:
            com.google.android.gms.internal.measurement.r r0 = com.google.android.gms.internal.measurement.r.f5558g0
            return r0
        L_0x0705:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x070b:
            r9 = r26
            r3 = r27
            r1 = r28
            com.google.android.gms.internal.measurement.r r0 = r9.j()
            com.google.android.gms.internal.measurement.f r0 = (com.google.android.gms.internal.measurement.C1092f) r0
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x076c
            java.util.Iterator r1 = r1.iterator()
        L_0x0721:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x076c
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.r r2 = (com.google.android.gms.internal.measurement.r) r2
            com.google.android.gms.internal.measurement.r r2 = r3.a(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.C1110h
            if (r4 != 0) goto L_0x0764
            int r4 = r0.o()
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.C1092f
            if (r5 == 0) goto L_0x0760
            com.google.android.gms.internal.measurement.f r2 = (com.google.android.gms.internal.measurement.C1092f) r2
            java.util.Iterator r5 = r2.n()
        L_0x0743:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0721
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r4
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.r r6 = r2.q(r6)
            r0.r(r7, r6)
            goto L_0x0743
        L_0x0760:
            r0.r(r4, r2)
            goto L_0x0721
        L_0x0764:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x076c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.E.a(java.lang.String, com.google.android.gms.internal.measurement.f, com.google.android.gms.internal.measurement.U1, java.util.List):com.google.android.gms.internal.measurement.r");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.r b(com.google.android.gms.internal.measurement.C1092f r10, com.google.android.gms.internal.measurement.U1 r11, java.util.List r12, boolean r13) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.C1238v2.b(r0, r1, r12)
            r2 = 2
            com.google.android.gms.internal.measurement.C1238v2.c(r0, r2, r12)
            r0 = 0
            java.lang.Object r3 = r12.get(r0)
            com.google.android.gms.internal.measurement.r r3 = (com.google.android.gms.internal.measurement.r) r3
            com.google.android.gms.internal.measurement.r r3 = r11.a(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1137k
            if (r4 == 0) goto L_0x009d
            int r4 = r12.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r12 = r12.get(r1)
            com.google.android.gms.internal.measurement.r r12 = (com.google.android.gms.internal.measurement.r) r12
            com.google.android.gms.internal.measurement.r r12 = r11.a(r12)
            boolean r4 = r12 instanceof com.google.android.gms.internal.measurement.C1110h
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed to parse initial value"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            int r12 = r10.o()
            if (r12 == 0) goto L_0x0095
            r12 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.k r3 = (com.google.android.gms.internal.measurement.C1137k) r3
            int r4 = r10.o()
            if (r13 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            r6 = -1
            if (r13 == 0) goto L_0x004e
            int r4 = r4 + r6
            goto L_0x004f
        L_0x004e:
            r4 = r0
        L_0x004f:
            if (r1 == r13) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r6 = r1
        L_0x0053:
            if (r12 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.r r12 = r10.q(r5)
        L_0x0059:
            int r5 = r5 + r6
        L_0x005a:
            int r13 = r4 - r5
            int r13 = r13 * r6
            if (r13 < 0) goto L_0x0094
            boolean r13 = r10.s(r5)
            if (r13 == 0) goto L_0x0059
            com.google.android.gms.internal.measurement.r r13 = r10.q(r5)
            double r7 = (double) r5
            com.google.android.gms.internal.measurement.j r9 = new com.google.android.gms.internal.measurement.j
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r9.<init>(r7)
            r7 = 4
            com.google.android.gms.internal.measurement.r[] r7 = new com.google.android.gms.internal.measurement.r[r7]
            r7[r0] = r12
            r7[r1] = r13
            r7[r2] = r9
            r12 = 3
            r7[r12] = r10
            java.util.List r12 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.r r12 = r3.a(r11, r12)
            boolean r13 = r12 instanceof com.google.android.gms.internal.measurement.C1110h
            if (r13 != 0) goto L_0x008c
            goto L_0x0059
        L_0x008c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Reduce operation failed"
            r10.<init>(r11)
            throw r10
        L_0x0094:
            return r12
        L_0x0095:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Empty array with no initial value error"
            r10.<init>(r11)
            throw r10
        L_0x009d:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Callback should be a method"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.E.b(com.google.android.gms.internal.measurement.f, com.google.android.gms.internal.measurement.U1, java.util.List, boolean):com.google.android.gms.internal.measurement.r");
    }

    private static C1092f c(C1092f fVar, U1 u12, C1137k kVar, Boolean bool, Boolean bool2) {
        C1092f fVar2 = new C1092f();
        Iterator n5 = fVar.n();
        while (n5.hasNext()) {
            int intValue = ((Integer) n5.next()).intValue();
            if (fVar.s(intValue)) {
                r a5 = kVar.a(u12, Arrays.asList(new r[]{fVar.q(intValue), new C1128j(Double.valueOf((double) intValue)), fVar}));
                if (a5.d().equals(bool)) {
                    break;
                } else if (bool2 == null || a5.d().equals(bool2)) {
                    fVar2.r(intValue, a5);
                }
            }
        }
        return fVar2;
    }
}
