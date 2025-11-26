package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class I5 implements Q5 {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f4967l = new int[0];

    /* renamed from: m  reason: collision with root package name */
    private static final Unsafe f4968m = C1126i6.v();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f4969a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f4970b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4971c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4972d;

    /* renamed from: e  reason: collision with root package name */
    private final F5 f4973e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4974f = false;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f4975g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4976h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4977i;

    /* renamed from: j  reason: collision with root package name */
    private final C1063b6 f4978j;

    /* renamed from: k  reason: collision with root package name */
    private final S4 f4979k;

    private I5(int[] iArr, Object[] objArr, int i5, int i6, F5 f5, boolean z4, int[] iArr2, int i7, int i8, K5 k5, C1197q5 q5Var, C1063b6 b6Var, S4 s42, A5 a5) {
        this.f4969a = iArr;
        this.f4970b = objArr;
        this.f4971c = i5;
        this.f4972d = i6;
        this.f4975g = iArr2;
        this.f4976h = i7;
        this.f4977i = i8;
        this.f4978j = b6Var;
        this.f4979k = s42;
        this.f4973e = f5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.I5 B(java.lang.Class r32, com.google.android.gms.internal.measurement.C5 r33, com.google.android.gms.internal.measurement.K5 r34, com.google.android.gms.internal.measurement.C1197q5 r35, com.google.android.gms.internal.measurement.C1063b6 r36, com.google.android.gms.internal.measurement.S4 r37, com.google.android.gms.internal.measurement.A5 r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.P5
            if (r1 == 0) goto L_0x0412
            com.google.android.gms.internal.measurement.P5 r0 = (com.google.android.gms.internal.measurement.P5) r0
            java.lang.String r1 = r0.a()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0056
            int[] r7 = f4967l
            r9 = r3
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r17 = r13
            r16 = r7
            r7 = r17
            goto L_0x016a
        L_0x0056:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0062:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0072
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0062
        L_0x0072:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0075:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0094
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0081:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0091
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0081
        L_0x0091:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0094:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b0
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a0
        L_0x00b0:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b3:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r13 = r12
            r12 = r9
            r9 = r13
            r13 = r10
            r17 = r14
            r10 = r16
            r16 = r7
            r7 = r4
            r4 = r15
        L_0x016a:
            sun.misc.Unsafe r14 = f4968m
            java.lang.Object[] r15 = r0.c()
            com.google.android.gms.internal.measurement.F5 r18 = r0.B()
            java.lang.Class r3 = r18.getClass()
            int r18 = r17 + r9
            int r9 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r9 = new java.lang.Object[r9]
            r21 = r17
            r22 = r18
            r19 = 0
            r20 = 0
        L_0x018a:
            if (r4 >= r2) goto L_0x03f8
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01b2
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = r23
            r23 = 13
        L_0x019a:
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01ac
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r23
            r4 = r4 | r8
            int r23 = r23 + 13
            r8 = r24
            goto L_0x019a
        L_0x01ac:
            int r8 = r8 << r23
            r4 = r4 | r8
            r8 = r24
            goto L_0x01b4
        L_0x01b2:
            r8 = r23
        L_0x01b4:
            int r23 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01da
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r6 = r23
            r23 = 13
        L_0x01c2:
            int r25 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r5) goto L_0x01d4
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r23
            r8 = r8 | r6
            int r23 = r23 + 13
            r6 = r25
            goto L_0x01c2
        L_0x01d4:
            int r6 = r6 << r23
            r8 = r8 | r6
            r6 = r25
            goto L_0x01dc
        L_0x01da:
            r6 = r23
        L_0x01dc:
            r5 = r8 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x01e6
            int r5 = r19 + 1
            r16[r19] = r20
            r19 = r5
        L_0x01e6:
            r5 = r8 & 255(0xff, float:3.57E-43)
            r25 = r0
            r0 = r8 & 2048(0x800, float:2.87E-42)
            r26 = r0
            r0 = 51
            if (r5 < r0) goto L_0x02a9
            int r0 = r6 + 1
            char r6 = r1.charAt(r6)
            r27 = r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r0) goto L_0x0226
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r30 = r27
            r27 = r6
            r6 = r30
            r30 = 13
        L_0x0209:
            int r31 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r0) goto L_0x021f
            r0 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r30
            r27 = r27 | r0
            int r30 = r30 + 13
            r6 = r31
            r0 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0209
        L_0x021f:
            int r0 = r6 << r30
            r6 = r27 | r0
            r0 = r31
            goto L_0x0228
        L_0x0226:
            r0 = r27
        L_0x0228:
            r27 = r0
            int r0 = r5 + -51
            r30 = r2
            r2 = 9
            if (r0 == r2) goto L_0x0236
            r2 = 17
            if (r0 != r2) goto L_0x0238
        L_0x0236:
            r2 = 1
            goto L_0x0258
        L_0x0238:
            r2 = 12
            if (r0 != r2) goto L_0x0255
            int r0 = r25.b()
            r2 = 1
            if (r0 == r2) goto L_0x0248
            if (r26 == 0) goto L_0x0246
            goto L_0x0248
        L_0x0246:
            r0 = 0
            goto L_0x0265
        L_0x0248:
            int r0 = r10 + 1
            int r24 = r20 / 3
            int r24 = r24 + r24
            int r24 = r24 + 1
            r10 = r15[r10]
            r9[r24] = r10
        L_0x0254:
            r10 = r0
        L_0x0255:
            r0 = r26
            goto L_0x0265
        L_0x0258:
            int r0 = r10 + 1
            int r24 = r20 / 3
            int r24 = r24 + r24
            int r28 = r24 + 1
            r2 = r15[r10]
            r9[r28] = r2
            goto L_0x0254
        L_0x0265:
            int r6 = r6 + r6
            r2 = r15[r6]
            r26 = r0
            boolean r0 = r2 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0274
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
        L_0x0270:
            r28 = r6
            r0 = r7
            goto L_0x027d
        L_0x0274:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = C(r3, r2)
            r15[r6] = r2
            goto L_0x0270
        L_0x027d:
            long r6 = r14.objectFieldOffset(r2)
            int r2 = (int) r6
            int r6 = r28 + 1
            r7 = r15[r6]
            r31 = r0
            boolean r0 = r7 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x028f
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0297
        L_0x028f:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = C(r3, r7)
            r15[r6] = r7
        L_0x0297:
            long r6 = r14.objectFieldOffset(r7)
            int r0 = (int) r6
            r28 = r0
            r7 = r1
            r0 = r26
            r6 = r27
            r1 = 0
            r23 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03bc
        L_0x02a9:
            r30 = r2
            r31 = r7
            int r0 = r10 + 1
            r2 = r15[r10]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = C(r3, r2)
            r7 = 9
            if (r5 == r7) goto L_0x02bf
            r7 = 17
            if (r5 != r7) goto L_0x02c4
        L_0x02bf:
            r28 = r0
            r0 = 1
            goto L_0x0337
        L_0x02c4:
            r7 = 27
            if (r5 == r7) goto L_0x0329
            r7 = 49
            if (r5 != r7) goto L_0x02d3
            int r10 = r10 + 2
            r28 = r0
            r0 = 1
            goto L_0x032e
        L_0x02d3:
            r7 = 12
            if (r5 == r7) goto L_0x030c
            r7 = 30
            if (r5 == r7) goto L_0x030c
            r7 = 44
            if (r5 != r7) goto L_0x02e0
            goto L_0x030c
        L_0x02e0:
            r7 = 50
            if (r5 != r7) goto L_0x0308
            int r7 = r10 + 2
            int r28 = r21 + 1
            r16[r21] = r20
            int r21 = r20 / 3
            r0 = r15[r0]
            int r21 = r21 + r21
            r9[r21] = r0
            if (r26 == 0) goto L_0x0301
            int r21 = r21 + 1
            int r0 = r10 + 3
            r7 = r15[r7]
            r9[r21] = r7
            r10 = r0
            r7 = r1
            r21 = r28
            goto L_0x0344
        L_0x0301:
            r10 = r7
            r21 = r28
            r26 = 0
        L_0x0306:
            r7 = r1
            goto L_0x0344
        L_0x0308:
            r28 = r0
            r0 = 1
            goto L_0x0341
        L_0x030c:
            int r7 = r25.b()
            r28 = r0
            r0 = 1
            if (r7 == r0) goto L_0x031e
            if (r26 == 0) goto L_0x0318
            goto L_0x031e
        L_0x0318:
            r7 = r1
            r10 = r28
            r26 = 0
            goto L_0x0344
        L_0x031e:
            int r10 = r10 + 2
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            r24 = r15[r28]
            r9[r7] = r24
            goto L_0x0306
        L_0x0329:
            r28 = r0
            r0 = 1
            int r10 = r10 + 2
        L_0x032e:
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            r24 = r15[r28]
            r9[r7] = r24
            goto L_0x0306
        L_0x0337:
            int r7 = r20 / 3
            int r7 = r7 + r7
            int r7 = r7 + r0
            java.lang.Class r10 = r2.getType()
            r9[r7] = r10
        L_0x0341:
            r7 = r1
            r10 = r28
        L_0x0344:
            long r0 = r14.objectFieldOffset(r2)
            int r2 = (int) r0
            r0 = r8 & 4096(0x1000, float:5.74E-42)
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 == 0) goto L_0x03a6
            r0 = 17
            if (r5 > r0) goto L_0x03a6
            int r0 = r6 + 1
            char r1 = r7.charAt(r6)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r6) goto L_0x0379
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r23 = 13
        L_0x0363:
            int r28 = r0 + 1
            char r0 = r7.charAt(r0)
            if (r0 < r6) goto L_0x0375
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r23
            r1 = r1 | r0
            int r23 = r23 + 13
            r0 = r28
            goto L_0x0363
        L_0x0375:
            int r0 = r0 << r23
            r1 = r1 | r0
            goto L_0x037b
        L_0x0379:
            r28 = r0
        L_0x037b:
            int r0 = r31 + r31
            int r23 = r1 / 32
            int r0 = r0 + r23
            r6 = r15[r0]
            r29 = r0
            boolean r0 = r6 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x038e
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
        L_0x038b:
            r29 = r1
            goto L_0x0397
        L_0x038e:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = C(r3, r6)
            r15[r29] = r6
            goto L_0x038b
        L_0x0397:
            long r0 = r14.objectFieldOffset(r6)
            int r0 = (int) r0
            int r1 = r29 % 32
            r6 = r28
            r23 = 55296(0xd800, float:7.7486E-41)
            r28 = r0
            goto L_0x03ac
        L_0x03a6:
            r23 = 55296(0xd800, float:7.7486E-41)
            r28 = r1
            r1 = 0
        L_0x03ac:
            r0 = 18
            if (r5 < r0) goto L_0x03ba
            r0 = 49
            if (r5 > r0) goto L_0x03ba
            int r0 = r22 + 1
            r16[r22] = r2
            r22 = r0
        L_0x03ba:
            r0 = r26
        L_0x03bc:
            int r26 = r20 + 1
            r11[r20] = r4
            int r4 = r20 + 2
            r27 = r0
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03cb
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03cc
        L_0x03cb:
            r0 = 0
        L_0x03cc:
            r8 = r8 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x03d3
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03d4
        L_0x03d3:
            r8 = 0
        L_0x03d4:
            if (r27 == 0) goto L_0x03d9
            r27 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03db
        L_0x03d9:
            r27 = 0
        L_0x03db:
            int r5 = r5 << 20
            r0 = r0 | r8
            r0 = r0 | r27
            r0 = r0 | r5
            r0 = r0 | r2
            r11[r26] = r0
            int r20 = r20 + 3
            int r0 = r1 << 20
            r0 = r0 | r28
            r11[r4] = r0
            r4 = r6
            r1 = r7
            r5 = r23
            r0 = r25
            r2 = r30
            r7 = r31
            goto L_0x018a
        L_0x03f8:
            r25 = r0
            com.google.android.gms.internal.measurement.I5 r0 = new com.google.android.gms.internal.measurement.I5
            com.google.android.gms.internal.measurement.F5 r14 = r25.B()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r10 = r11
            r11 = r9
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r9
        L_0x0412:
            android.support.v4.media.a.a(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.I5.B(java.lang.Class, com.google.android.gms.internal.measurement.C5, com.google.android.gms.internal.measurement.K5, com.google.android.gms.internal.measurement.q5, com.google.android.gms.internal.measurement.b6, com.google.android.gms.internal.measurement.S4, com.google.android.gms.internal.measurement.A5):com.google.android.gms.internal.measurement.I5");
    }

    private static Field C(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e5) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + name.length() + 29 + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString(), e5);
        }
    }

    private final void D(Object obj, Object obj2, int i5) {
        if (r(obj2, i5)) {
            Unsafe unsafe = f4968m;
            long N4 = (long) (N(i5) & 1048575);
            Object object = unsafe.getObject(obj2, N4);
            if (object != null) {
                Q5 F4 = F(i5);
                if (!r(obj, i5)) {
                    if (!i(object)) {
                        unsafe.putObject(obj, N4, object);
                    } else {
                        Object A4 = F4.A();
                        F4.b(A4, object);
                        unsafe.putObject(obj, N4, A4);
                    }
                    s(obj, i5);
                    return;
                }
                Object object2 = unsafe.getObject(obj, N4);
                if (!i(object2)) {
                    Object A5 = F4.A();
                    F4.b(A5, object2);
                    unsafe.putObject(obj, N4, A5);
                    object2 = A5;
                }
                F4.b(object2, object);
                return;
            }
            int i6 = this.f4969a[i5];
            String obj3 = obj2.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 38 + obj3.length());
            sb.append("Source subfield ");
            sb.append(i6);
            sb.append(" is present but null: ");
            sb.append(obj3);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final void E(Object obj, Object obj2, int i5) {
        int[] iArr = this.f4969a;
        int i6 = iArr[i5];
        if (t(obj2, i6, i5)) {
            Unsafe unsafe = f4968m;
            long N4 = (long) (N(i5) & 1048575);
            Object object = unsafe.getObject(obj2, N4);
            if (object != null) {
                Q5 F4 = F(i5);
                if (!t(obj, i6, i5)) {
                    if (!i(object)) {
                        unsafe.putObject(obj, N4, object);
                    } else {
                        Object A4 = F4.A();
                        F4.b(A4, object);
                        unsafe.putObject(obj, N4, A4);
                    }
                    u(obj, i6, i5);
                    return;
                }
                Object object2 = unsafe.getObject(obj, N4);
                if (!i(object2)) {
                    Object A5 = F4.A();
                    F4.b(A5, object2);
                    unsafe.putObject(obj, N4, A5);
                    object2 = A5;
                }
                F4.b(object2, object);
                return;
            }
            int i7 = iArr[i5];
            String obj3 = obj2.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 38 + obj3.length());
            sb.append("Source subfield ");
            sb.append(i7);
            sb.append(" is present but null: ");
            sb.append(obj3);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final Q5 F(int i5) {
        Object[] objArr = this.f4970b;
        int i6 = i5 / 3;
        int i7 = i6 + i6;
        Q5 q5 = (Q5) objArr[i7];
        if (q5 != null) {
            return q5;
        }
        Q5 b5 = N5.a().b((Class) objArr[i7 + 1]);
        objArr[i7] = b5;
        return b5;
    }

    private final Object G(int i5) {
        int i6 = i5 / 3;
        return this.f4970b[i6 + i6];
    }

    private final C1116h5 H(int i5) {
        int i6 = i5 / 3;
        return (C1116h5) this.f4970b[i6 + i6 + 1];
    }

    private final Object I(Object obj, int i5) {
        Q5 F4 = F(i5);
        int N4 = N(i5) & 1048575;
        if (!r(obj, i5)) {
            return F4.A();
        }
        Object object = f4968m.getObject(obj, (long) N4);
        if (i(object)) {
            return object;
        }
        Object A4 = F4.A();
        if (object != null) {
            F4.b(A4, object);
        }
        return A4;
    }

    private final void J(Object obj, int i5, Object obj2) {
        f4968m.putObject(obj, (long) (N(i5) & 1048575), obj2);
        s(obj, i5);
    }

    private final Object K(Object obj, int i5, int i6) {
        Q5 F4 = F(i6);
        if (!t(obj, i5, i6)) {
            return F4.A();
        }
        Object object = f4968m.getObject(obj, (long) (N(i6) & 1048575));
        if (i(object)) {
            return object;
        }
        Object A4 = F4.A();
        if (object != null) {
            F4.b(A4, object);
        }
        return A4;
    }

    private final void L(Object obj, int i5, int i6, Object obj2) {
        f4968m.putObject(obj, (long) (N(i6) & 1048575), obj2);
        u(obj, i5, i6);
    }

    private static boolean M(Object obj, int i5, Q5 q5) {
        return q5.d(C1126i6.s(obj, (long) (i5 & 1048575)));
    }

    private final int N(int i5) {
        return this.f4969a[i5 + 1];
    }

    private final int O(int i5) {
        return this.f4969a[i5 + 2];
    }

    private static int P(int i5) {
        return (i5 >>> 20) & 255;
    }

    private static boolean i(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof C1089e5) {
            return ((C1089e5) obj).j();
        }
        return true;
    }

    private static void j(Object obj) {
        if (!i(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private static double k(Object obj, long j5) {
        return ((Double) C1126i6.s(obj, j5)).doubleValue();
    }

    private static float l(Object obj, long j5) {
        return ((Float) C1126i6.s(obj, j5)).floatValue();
    }

    private static int m(Object obj, long j5) {
        return ((Integer) C1126i6.s(obj, j5)).intValue();
    }

    private static long n(Object obj, long j5) {
        return ((Long) C1126i6.s(obj, j5)).longValue();
    }

    private static boolean o(Object obj, long j5) {
        return ((Boolean) C1126i6.s(obj, j5)).booleanValue();
    }

    private final boolean p(Object obj, Object obj2, int i5) {
        if (r(obj, i5) == r(obj2, i5)) {
            return true;
        }
        return false;
    }

    private final boolean q(Object obj, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return r(obj, i5);
        }
        if ((i7 & i8) != 0) {
            return true;
        }
        return false;
    }

    private final boolean r(Object obj, int i5) {
        int O4 = O(i5);
        long j5 = (long) (O4 & 1048575);
        if (j5 == 1048575) {
            int N4 = N(i5);
            long j6 = (long) (N4 & 1048575);
            switch (P(N4)) {
                case 0:
                    if (Double.doubleToRawLongBits(C1126i6.q(obj, j6)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(C1126i6.o(obj, j6)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (C1126i6.k(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (C1126i6.k(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (C1126i6.k(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return C1126i6.m(obj, j6);
                case 8:
                    Object s5 = C1126i6.s(obj, j6);
                    if (s5 instanceof String) {
                        if (!((String) s5).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(s5 instanceof H4)) {
                        throw new IllegalArgumentException();
                    } else if (!H4.f4958b.equals(s5)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (C1126i6.s(obj, j6) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!H4.f4958b.equals(C1126i6.s(obj, j6))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (C1126i6.k(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (C1126i6.i(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (C1126i6.k(obj, j6) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (C1126i6.s(obj, j6) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((C1126i6.i(obj, j5) & (1 << (O4 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final void s(Object obj, int i5) {
        int O4 = O(i5);
        long j5 = (long) (1048575 & O4);
        if (j5 != 1048575) {
            C1126i6.j(obj, j5, (1 << (O4 >>> 20)) | C1126i6.i(obj, j5));
        }
    }

    private final boolean t(Object obj, int i5, int i6) {
        if (C1126i6.i(obj, (long) (O(i6) & 1048575)) == i5) {
            return true;
        }
        return false;
    }

    private final void u(Object obj, int i5, int i6) {
        C1126i6.j(obj, (long) (O(i6) & 1048575), i5);
    }

    private final int v(int i5, int i6) {
        int[] iArr = this.f4969a;
        int length = (iArr.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int i9 = iArr[i8];
            if (i5 == i9) {
                return i8;
            }
            if (i5 < i9) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private static final int w(byte[] bArr, int i5, int i6, C1162m6 m6Var, Class cls, C1240v4 v4Var) {
        boolean z4;
        C1162m6 m6Var2 = C1162m6.DOUBLE;
        switch (m6Var.ordinal()) {
            case 0:
                int i7 = i5 + 8;
                v4Var.f5610c = Double.valueOf(Double.longBitsToDouble(C1249w4.e(bArr, i5)));
                return i7;
            case 1:
                int i8 = i5 + 4;
                v4Var.f5610c = Float.valueOf(Float.intBitsToFloat(C1249w4.d(bArr, i5)));
                return i8;
            case 2:
            case 3:
                int c5 = C1249w4.c(bArr, i5, v4Var);
                v4Var.f5610c = Long.valueOf(v4Var.f5609b);
                return c5;
            case 4:
            case 12:
            case 13:
                int a5 = C1249w4.a(bArr, i5, v4Var);
                v4Var.f5610c = Integer.valueOf(v4Var.f5608a);
                return a5;
            case 5:
            case 15:
                int i9 = i5 + 8;
                v4Var.f5610c = Long.valueOf(C1249w4.e(bArr, i5));
                return i9;
            case 6:
            case 14:
                int i10 = i5 + 4;
                v4Var.f5610c = Integer.valueOf(C1249w4.d(bArr, i5));
                return i10;
            case 7:
                int c6 = C1249w4.c(bArr, i5, v4Var);
                if (v4Var.f5609b != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                v4Var.f5610c = Boolean.valueOf(z4);
                return c6;
            case 8:
                return C1249w4.f(bArr, i5, v4Var);
            case 10:
                return C1249w4.h(N5.a().b(cls), bArr, i5, i6, v4Var);
            case 11:
                return C1249w4.g(bArr, i5, v4Var);
            case 16:
                int a6 = C1249w4.a(bArr, i5, v4Var);
                v4Var.f5610c = Integer.valueOf(J4.a(v4Var.f5608a));
                return a6;
            case 17:
                int c7 = C1249w4.c(bArr, i5, v4Var);
                v4Var.f5610c = Long.valueOf(J4.b(v4Var.f5609b));
                return c7;
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static final void x(int i5, Object obj, C1180o6 o6Var) {
        if (obj instanceof String) {
            o6Var.u(i5, (String) obj);
        } else {
            o6Var.a(i5, (H4) obj);
        }
    }

    static C1072c6 y(Object obj) {
        C1089e5 e5Var = (C1089e5) obj;
        C1072c6 c6Var = e5Var.zzc;
        if (c6Var != C1072c6.a()) {
            return c6Var;
        }
        C1072c6 b5 = C1072c6.b();
        e5Var.zzc = b5;
        return b5;
    }

    public final Object A() {
        return ((C1089e5) this.f4973e).m();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x039b, code lost:
        r10 = r10 * r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0599, code lost:
        r0 = r0 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x059a, code lost:
        r9 = r9 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x059b, code lost:
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x05c5, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x05d4, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x061c, code lost:
        r0 = r0 + (r10 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r5 = r5 + r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a9, code lost:
        r5 = r5 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b8, code lost:
        r5 = r5 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0100, code lost:
        r5 = r5 + (r11 + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01df, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0204, code lost:
        r9 = r9 + r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0246, code lost:
        r10 = (r10 + r11) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0248, code lost:
        r9 = r9 + r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r6 = f4968m
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r4 = r2
            r9 = r4
            r3 = r8
        L_0x000e:
            int[] r5 = r0.f4969a
            int r10 = r5.length
            if (r2 >= r10) goto L_0x06f0
            int r10 = r0.N(r2)
            int r11 = P(r10)
            r12 = r5[r2]
            int r13 = r2 + 2
            r5 = r5[r13]
            r13 = r5 & r8
            r14 = 17
            r15 = 1
            if (r11 > r14) goto L_0x003a
            if (r13 == r3) goto L_0x0035
            if (r13 != r8) goto L_0x002e
            r4 = r7
            goto L_0x0034
        L_0x002e:
            long r3 = (long) r13
            int r3 = r6.getInt(r1, r3)
            r4 = r3
        L_0x0034:
            r3 = r13
        L_0x0035:
            int r5 = r5 >>> 20
            int r5 = r15 << r5
            goto L_0x003b
        L_0x003a:
            r5 = r7
        L_0x003b:
            r10 = r10 & r8
            com.google.android.gms.internal.measurement.X4 r13 = com.google.android.gms.internal.measurement.X4.DOUBLE_LIST_PACKED
            int r13 = r13.A()
            if (r11 < r13) goto L_0x0049
            com.google.android.gms.internal.measurement.X4 r13 = com.google.android.gms.internal.measurement.X4.SINT64_LIST_PACKED
            r13.A()
        L_0x0049:
            long r13 = (long) r10
            r10 = 63
            switch(r11) {
                case 0: goto L_0x06db;
                case 1: goto L_0x06cd;
                case 2: goto L_0x06b7;
                case 3: goto L_0x06a1;
                case 4: goto L_0x068a;
                case 5: goto L_0x067c;
                case 6: goto L_0x066e;
                case 7: goto L_0x065f;
                case 8: goto L_0x0634;
                case 9: goto L_0x0620;
                case 10: goto L_0x0602;
                case 11: goto L_0x05ed;
                case 12: goto L_0x05d7;
                case 13: goto L_0x05c8;
                case 14: goto L_0x05b9;
                case 15: goto L_0x059f;
                case 16: goto L_0x0580;
                case 17: goto L_0x056a;
                case 18: goto L_0x055e;
                case 19: goto L_0x0552;
                case 20: goto L_0x0530;
                case 21: goto L_0x0514;
                case 22: goto L_0x04f8;
                case 23: goto L_0x04ec;
                case 24: goto L_0x04e0;
                case 25: goto L_0x04c6;
                case 26: goto L_0x0465;
                case 27: goto L_0x0436;
                case 28: goto L_0x0404;
                case 29: goto L_0x03ea;
                case 30: goto L_0x03d0;
                case 31: goto L_0x03c4;
                case 32: goto L_0x03b8;
                case 33: goto L_0x039e;
                case 34: goto L_0x0380;
                case 35: goto L_0x0368;
                case 36: goto L_0x0350;
                case 37: goto L_0x0338;
                case 38: goto L_0x0320;
                case 39: goto L_0x0308;
                case 40: goto L_0x02f0;
                case 41: goto L_0x02d8;
                case 42: goto L_0x02be;
                case 43: goto L_0x02a7;
                case 44: goto L_0x0290;
                case 45: goto L_0x0279;
                case 46: goto L_0x0262;
                case 47: goto L_0x024b;
                case 48: goto L_0x0230;
                case 49: goto L_0x0207;
                case 50: goto L_0x01cd;
                case 51: goto L_0x01bf;
                case 52: goto L_0x01b1;
                case 53: goto L_0x019b;
                case 54: goto L_0x0185;
                case 55: goto L_0x016e;
                case 56: goto L_0x0160;
                case 57: goto L_0x0152;
                case 58: goto L_0x0143;
                case 59: goto L_0x0118;
                case 60: goto L_0x0104;
                case 61: goto L_0x00e6;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00bb;
                case 64: goto L_0x00ac;
                case 65: goto L_0x009d;
                case 66: goto L_0x0083;
                case 67: goto L_0x0068;
                case 68: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            goto L_0x06ea
        L_0x0051:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.F5 r5 = (com.google.android.gms.internal.measurement.F5) r5
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r5 = com.google.android.gms.internal.measurement.M4.g(r12, r5, r10)
        L_0x0065:
            int r9 = r9 + r5
            goto L_0x06ea
        L_0x0068:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            long r11 = n(r1, r13)
            long r13 = r11 + r11
            long r10 = r11 >> r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            long r10 = r10 ^ r13
            int r10 = com.google.android.gms.internal.measurement.M4.a(r10)
        L_0x0081:
            int r5 = r5 + r10
            goto L_0x0065
        L_0x0083:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r10 = m(r1, r13)
            int r11 = r10 + r10
            int r10 = r10 >> 31
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            r10 = r10 ^ r11
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            goto L_0x0081
        L_0x009d:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
        L_0x00a9:
            int r5 = r5 + 8
            goto L_0x0065
        L_0x00ac:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
        L_0x00b8:
            int r5 = r5 + 4
            goto L_0x0065
        L_0x00bb:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r10 = m(r1, r13)
            long r10 = (long) r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0081
        L_0x00d1:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r10 = m(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            goto L_0x0081
        L_0x00e6:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            java.lang.Object r10 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.H4 r10 = (com.google.android.gms.internal.measurement.H4) r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = r10.f()
            int r11 = com.google.android.gms.internal.measurement.M4.E(r10)
        L_0x0100:
            int r11 = r11 + r10
            int r5 = r5 + r11
            goto L_0x0065
        L_0x0104:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r5 = com.google.android.gms.internal.measurement.S5.E(r12, r5, r10)
            goto L_0x0065
        L_0x0118:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            java.lang.Object r10 = r6.getObject(r1, r13)
            boolean r11 = r10 instanceof com.google.android.gms.internal.measurement.H4
            if (r11 == 0) goto L_0x0137
            com.google.android.gms.internal.measurement.H4 r10 = (com.google.android.gms.internal.measurement.H4) r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = r10.f()
            int r11 = com.google.android.gms.internal.measurement.M4.E(r10)
            goto L_0x0100
        L_0x0137:
            java.lang.String r10 = (java.lang.String) r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.b(r10)
            goto L_0x0081
        L_0x0143:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r5 = r5 + r15
            goto L_0x0065
        L_0x0152:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x00b8
        L_0x0160:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x00a9
        L_0x016e:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r10 = m(r1, r13)
            long r10 = (long) r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0081
        L_0x0185:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            long r10 = n(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0081
        L_0x019b:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            long r10 = n(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            int r10 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0081
        L_0x01b1:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x00b8
        L_0x01bf:
            boolean r5 = r0.t(r1, r12, r2)
            if (r5 == 0) goto L_0x06ea
            int r5 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x00a9
        L_0x01cd:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.lang.Object r10 = r0.G(r2)
            com.google.android.gms.internal.measurement.z5 r5 = (com.google.android.gms.internal.measurement.C1275z5) r5
            com.google.android.gms.internal.measurement.y5 r10 = (com.google.android.gms.internal.measurement.C1267y5) r10
            boolean r11 = r5.isEmpty()
            if (r11 == 0) goto L_0x01e1
        L_0x01df:
            r11 = r7
            goto L_0x0204
        L_0x01e1:
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
            r11 = r7
        L_0x01ea:
            boolean r13 = r5.hasNext()
            if (r13 == 0) goto L_0x0204
            java.lang.Object r13 = r5.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.Object r13 = r13.getValue()
            int r13 = r10.d(r12, r14, r13)
            int r11 = r11 + r13
            goto L_0x01ea
        L_0x0204:
            int r9 = r9 + r11
            goto L_0x06ea
        L_0x0207:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r11 = com.google.android.gms.internal.measurement.S5.f5173b
            int r11 = r5.size()
            if (r11 != 0) goto L_0x021b
            r14 = r7
            goto L_0x022d
        L_0x021b:
            r13 = r7
            r14 = r13
        L_0x021d:
            if (r13 >= r11) goto L_0x022d
            java.lang.Object r15 = r5.get(r13)
            com.google.android.gms.internal.measurement.F5 r15 = (com.google.android.gms.internal.measurement.F5) r15
            int r15 = com.google.android.gms.internal.measurement.M4.g(r12, r15, r10)
            int r14 = r14 + r15
            int r13 = r13 + 1
            goto L_0x021d
        L_0x022d:
            int r9 = r9 + r14
            goto L_0x06ea
        L_0x0230:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.v(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
        L_0x0246:
            int r10 = r10 + r11
            int r10 = r10 + r5
        L_0x0248:
            int r9 = r9 + r10
            goto L_0x06ea
        L_0x024b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.z(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0262:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.C(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0279:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.A(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0290:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.w(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x02a7:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.y(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x02be:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x02d8:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.A(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x02f0:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.C(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0308:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.x(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0320:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.u(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0338:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.t(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0350:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.A(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0368:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.C(r5)
            if (r5 <= 0) goto L_0x06ea
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0246
        L_0x0380:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0391
        L_0x038e:
            r5 = r7
            goto L_0x0065
        L_0x0391:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.v(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
        L_0x039b:
            int r10 = r10 * r11
            goto L_0x0081
        L_0x039e:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x03ad
            goto L_0x038e
        L_0x03ad:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.z(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            goto L_0x039b
        L_0x03b8:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.D(r12, r5, r7)
            goto L_0x0065
        L_0x03c4:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.B(r12, r5, r7)
            goto L_0x0065
        L_0x03d0:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x03df
            goto L_0x038e
        L_0x03df:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.w(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            goto L_0x039b
        L_0x03ea:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x03f9
            goto L_0x038e
        L_0x03f9:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.y(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            goto L_0x039b
        L_0x0404:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0415
            r10 = r7
            goto L_0x0248
        L_0x0415:
            int r11 = r12 << 3
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            int r10 = r10 * r11
            r11 = r7
        L_0x041d:
            int r12 = r5.size()
            if (r11 >= r12) goto L_0x0248
            java.lang.Object r12 = r5.get(r11)
            com.google.android.gms.internal.measurement.H4 r12 = (com.google.android.gms.internal.measurement.H4) r12
            int r12 = r12.f()
            int r13 = com.google.android.gms.internal.measurement.M4.E(r12)
            int r13 = r13 + r12
            int r10 = r10 + r13
            int r11 = r11 + 1
            goto L_0x041d
        L_0x0436:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r11 = com.google.android.gms.internal.measurement.S5.f5173b
            int r11 = r5.size()
            if (r11 != 0) goto L_0x044a
            r12 = r7
            goto L_0x0462
        L_0x044a:
            int r12 = r12 << 3
            int r12 = com.google.android.gms.internal.measurement.M4.E(r12)
            int r12 = r12 * r11
            r13 = r7
        L_0x0452:
            if (r13 >= r11) goto L_0x0462
            java.lang.Object r14 = r5.get(r13)
            com.google.android.gms.internal.measurement.F5 r14 = (com.google.android.gms.internal.measurement.F5) r14
            int r14 = com.google.android.gms.internal.measurement.M4.d(r14, r10)
            int r12 = r12 + r14
            int r13 = r13 + 1
            goto L_0x0452
        L_0x0462:
            int r9 = r9 + r12
            goto L_0x06ea
        L_0x0465:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0475
            goto L_0x01df
        L_0x0475:
            int r11 = r12 << 3
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            int r11 = r11 * r10
            boolean r12 = r5 instanceof com.google.android.gms.internal.measurement.C1188p5
            if (r12 == 0) goto L_0x04a4
            com.google.android.gms.internal.measurement.p5 r5 = (com.google.android.gms.internal.measurement.C1188p5) r5
            r12 = r7
        L_0x0483:
            if (r12 >= r10) goto L_0x0204
            java.lang.Object r13 = r5.b()
            boolean r14 = r13 instanceof com.google.android.gms.internal.measurement.H4
            if (r14 == 0) goto L_0x049a
            com.google.android.gms.internal.measurement.H4 r13 = (com.google.android.gms.internal.measurement.H4) r13
            int r13 = r13.f()
            int r14 = com.google.android.gms.internal.measurement.M4.E(r13)
            int r14 = r14 + r13
            int r11 = r11 + r14
            goto L_0x04a1
        L_0x049a:
            java.lang.String r13 = (java.lang.String) r13
            int r13 = com.google.android.gms.internal.measurement.M4.b(r13)
            int r11 = r11 + r13
        L_0x04a1:
            int r12 = r12 + 1
            goto L_0x0483
        L_0x04a4:
            r12 = r7
        L_0x04a5:
            if (r12 >= r10) goto L_0x0204
            java.lang.Object r13 = r5.get(r12)
            boolean r14 = r13 instanceof com.google.android.gms.internal.measurement.H4
            if (r14 == 0) goto L_0x04bc
            com.google.android.gms.internal.measurement.H4 r13 = (com.google.android.gms.internal.measurement.H4) r13
            int r13 = r13.f()
            int r14 = com.google.android.gms.internal.measurement.M4.E(r13)
            int r14 = r14 + r13
            int r11 = r11 + r14
            goto L_0x04c3
        L_0x04bc:
            java.lang.String r13 = (java.lang.String) r13
            int r13 = com.google.android.gms.internal.measurement.M4.b(r13)
            int r11 = r11 + r13
        L_0x04c3:
            int r12 = r12 + 1
            goto L_0x04a5
        L_0x04c6:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r5 = r5.size()
            if (r5 != 0) goto L_0x04d6
            goto L_0x038e
        L_0x04d6:
            int r10 = r12 << 3
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r10 = r10 + r15
            int r5 = r5 * r10
            goto L_0x0065
        L_0x04e0:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.B(r12, r5, r7)
            goto L_0x0065
        L_0x04ec:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.D(r12, r5, r7)
            goto L_0x0065
        L_0x04f8:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0508
            goto L_0x038e
        L_0x0508:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.x(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            goto L_0x039b
        L_0x0514:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0524
            goto L_0x038e
        L_0x0524:
            int r11 = r12 << 3
            int r5 = com.google.android.gms.internal.measurement.S5.u(r5)
            int r11 = com.google.android.gms.internal.measurement.M4.E(r11)
            goto L_0x039b
        L_0x0530:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r10 = com.google.android.gms.internal.measurement.S5.f5173b
            int r10 = r5.size()
            if (r10 != 0) goto L_0x0540
            goto L_0x01df
        L_0x0540:
            int r10 = r12 << 3
            int r11 = com.google.android.gms.internal.measurement.S5.t(r5)
            int r5 = r5.size()
            int r10 = com.google.android.gms.internal.measurement.M4.E(r10)
            int r5 = r5 * r10
            int r11 = r11 + r5
            goto L_0x0204
        L_0x0552:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.B(r12, r5, r7)
            goto L_0x0065
        L_0x055e:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.S5.D(r12, r5, r7)
            goto L_0x0065
        L_0x056a:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06ea
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.F5 r5 = (com.google.android.gms.internal.measurement.F5) r5
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r5 = com.google.android.gms.internal.measurement.M4.g(r12, r5, r10)
            goto L_0x0065
        L_0x0580:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            long r11 = r6.getLong(r1, r13)
            long r13 = r11 + r11
            long r10 = r11 >> r10
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            long r10 = r10 ^ r13
            int r5 = com.google.android.gms.internal.measurement.M4.a(r10)
        L_0x0599:
            int r0 = r0 + r5
        L_0x059a:
            int r9 = r9 + r0
        L_0x059b:
            r0 = r16
            goto L_0x06ea
        L_0x059f:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r5 = r6.getInt(r1, r13)
            int r10 = r5 + r5
            int r5 = r5 >> 31
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            r5 = r5 ^ r10
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0599
        L_0x05b9:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
        L_0x05c5:
            int r0 = r0 + 8
            goto L_0x059a
        L_0x05c8:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
        L_0x05d4:
            int r0 = r0 + 4
            goto L_0x059a
        L_0x05d7:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r5 = r6.getInt(r1, r13)
            long r10 = (long) r5
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0599
        L_0x05ed:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r5 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x0599
        L_0x0602:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.H4 r5 = (com.google.android.gms.internal.measurement.H4) r5
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = r5.f()
            int r10 = com.google.android.gms.internal.measurement.M4.E(r5)
        L_0x061c:
            int r10 = r10 + r5
            int r0 = r0 + r10
            goto L_0x059a
        L_0x0620:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06ea
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.Q5 r10 = r0.F(r2)
            int r5 = com.google.android.gms.internal.measurement.S5.E(r12, r5, r10)
            goto L_0x0065
        L_0x0634:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            java.lang.Object r5 = r6.getObject(r1, r13)
            boolean r10 = r5 instanceof com.google.android.gms.internal.measurement.H4
            if (r10 == 0) goto L_0x0653
            com.google.android.gms.internal.measurement.H4 r5 = (com.google.android.gms.internal.measurement.H4) r5
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = r5.f()
            int r10 = com.google.android.gms.internal.measurement.M4.E(r5)
            goto L_0x061c
        L_0x0653:
            java.lang.String r5 = (java.lang.String) r5
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.b(r5)
            goto L_0x0599
        L_0x065f:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r0 = r0 + r15
            goto L_0x059a
        L_0x066e:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            goto L_0x05d4
        L_0x067c:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            goto L_0x05c5
        L_0x068a:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r5 = r6.getInt(r1, r13)
            long r10 = (long) r5
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0599
        L_0x06a1:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            long r10 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0599
        L_0x06b7:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            long r10 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            int r5 = com.google.android.gms.internal.measurement.M4.a(r10)
            goto L_0x0599
        L_0x06cd:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x059b
            int r0 = r12 << 3
            int r0 = com.google.android.gms.internal.measurement.M4.E(r0)
            goto L_0x05d4
        L_0x06db:
            boolean r5 = r0.q(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x06ea
            int r1 = r12 << 3
            int r1 = com.google.android.gms.internal.measurement.M4.E(r1)
            int r1 = r1 + 8
            int r9 = r9 + r1
        L_0x06ea:
            int r2 = r2 + 3
            r1 = r17
            goto L_0x000e
        L_0x06f0:
            r1 = r17
            com.google.android.gms.internal.measurement.e5 r1 = (com.google.android.gms.internal.measurement.C1089e5) r1
            com.google.android.gms.internal.measurement.c6 r1 = r1.zzc
            int r1 = r1.h()
            int r9 = r9 + r1
            boolean r1 = r0.f4974f
            if (r1 != 0) goto L_0x0700
            return r9
        L_0x0700:
            android.support.v4.media.a.a(r17)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.I5.a(java.lang.Object):int");
    }

    public final void b(Object obj, Object obj2) {
        j(obj);
        obj2.getClass();
        int i5 = 0;
        while (true) {
            int[] iArr = this.f4969a;
            if (i5 < iArr.length) {
                int N4 = N(i5);
                int i6 = 1048575 & N4;
                int P4 = P(N4);
                int i7 = iArr[i5];
                long j5 = (long) i6;
                switch (P4) {
                    case 0:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.r(obj, j5, C1126i6.q(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 1:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.p(obj, j5, C1126i6.o(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 2:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.l(obj, j5, C1126i6.k(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 3:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.l(obj, j5, C1126i6.k(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 4:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 5:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.l(obj, j5, C1126i6.k(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 6:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 7:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.n(obj, j5, C1126i6.m(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 8:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.t(obj, j5, C1126i6.s(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 9:
                        D(obj, obj2, i5);
                        break;
                    case 10:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.t(obj, j5, C1126i6.s(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 11:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 12:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 13:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 14:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.l(obj, j5, C1126i6.k(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 15:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.j(obj, j5, C1126i6.i(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 16:
                        if (!r(obj2, i5)) {
                            break;
                        } else {
                            C1126i6.l(obj, j5, C1126i6.k(obj2, j5));
                            s(obj, i5);
                            break;
                        }
                    case 17:
                        D(obj, obj2, i5);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        C1143k5 k5Var = (C1143k5) C1126i6.s(obj, j5);
                        C1143k5 k5Var2 = (C1143k5) C1126i6.s(obj2, j5);
                        int size = k5Var.size();
                        int size2 = k5Var2.size();
                        if (size > 0 && size2 > 0) {
                            if (!k5Var.A()) {
                                k5Var = k5Var.m(size2 + size);
                            }
                            k5Var.addAll(k5Var2);
                        }
                        if (size > 0) {
                            k5Var2 = k5Var;
                        }
                        C1126i6.t(obj, j5, k5Var2);
                        break;
                    case 50:
                        int i8 = S5.f5173b;
                        C1126i6.t(obj, j5, A5.a(C1126i6.s(obj, j5), C1126i6.s(obj2, j5)));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!t(obj2, i7, i5)) {
                            break;
                        } else {
                            C1126i6.t(obj, j5, C1126i6.s(obj2, j5));
                            u(obj, i7, i5);
                            break;
                        }
                    case 60:
                        E(obj, obj2, i5);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!t(obj2, i7, i5)) {
                            break;
                        } else {
                            C1126i6.t(obj, j5, C1126i6.s(obj2, j5));
                            u(obj, i7, i5);
                            break;
                        }
                    case 68:
                        E(obj, obj2, i5);
                        break;
                }
                i5 += 3;
            } else {
                S5.d(this.f4978j, obj, obj2);
                if (this.f4974f) {
                    S5.c(this.f4979k, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r2 = (int) (r2 ^ (r2 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0166, code lost:
        r1 = r1 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r1 = r1 + r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int c(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            int[] r2 = r8.f4969a
            int r3 = r2.length
            if (r0 >= r3) goto L_0x021c
            int r3 = r8.N(r0)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            int r3 = P(r3)
            r2 = r2[r0]
            long r4 = (long) r4
            r6 = 37
            r7 = 32
            switch(r3) {
                case 0: goto L_0x020a;
                case 1: goto L_0x01fe;
                case 2: goto L_0x01f4;
                case 3: goto L_0x01ea;
                case 4: goto L_0x01e2;
                case 5: goto L_0x01d8;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01c4;
                case 8: goto L_0x01b6;
                case 9: goto L_0x01a9;
                case 10: goto L_0x019d;
                case 11: goto L_0x0195;
                case 12: goto L_0x018d;
                case 13: goto L_0x0185;
                case 14: goto L_0x017b;
                case 15: goto L_0x0173;
                case 16: goto L_0x0169;
                case 17: goto L_0x015a;
                case 18: goto L_0x014e;
                case 19: goto L_0x014e;
                case 20: goto L_0x014e;
                case 21: goto L_0x014e;
                case 22: goto L_0x014e;
                case 23: goto L_0x014e;
                case 24: goto L_0x014e;
                case 25: goto L_0x014e;
                case 26: goto L_0x014e;
                case 27: goto L_0x014e;
                case 28: goto L_0x014e;
                case 29: goto L_0x014e;
                case 30: goto L_0x014e;
                case 31: goto L_0x014e;
                case 32: goto L_0x014e;
                case 33: goto L_0x014e;
                case 34: goto L_0x014e;
                case 35: goto L_0x014e;
                case 36: goto L_0x014e;
                case 37: goto L_0x014e;
                case 38: goto L_0x014e;
                case 39: goto L_0x014e;
                case 40: goto L_0x014e;
                case 41: goto L_0x014e;
                case 42: goto L_0x014e;
                case 43: goto L_0x014e;
                case 44: goto L_0x014e;
                case 45: goto L_0x014e;
                case 46: goto L_0x014e;
                case 47: goto L_0x014e;
                case 48: goto L_0x014e;
                case 49: goto L_0x014e;
                case 50: goto L_0x0142;
                case 51: goto L_0x012e;
                case 52: goto L_0x011c;
                case 53: goto L_0x010c;
                case 54: goto L_0x00fc;
                case 55: goto L_0x00ee;
                case 56: goto L_0x00de;
                case 57: goto L_0x00d0;
                case 58: goto L_0x00be;
                case 59: goto L_0x00aa;
                case 60: goto L_0x0099;
                case 61: goto L_0x0088;
                case 62: goto L_0x007b;
                case 63: goto L_0x006e;
                case 64: goto L_0x0061;
                case 65: goto L_0x0052;
                case 66: goto L_0x0045;
                case 67: goto L_0x0032;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0218
        L_0x001f:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
        L_0x002f:
            int r1 = r1 + r2
            goto L_0x0218
        L_0x0032:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            long r2 = n(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
        L_0x0040:
            long r4 = r2 >>> r7
            long r2 = r2 ^ r4
            int r2 = (int) r2
            goto L_0x002f
        L_0x0045:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x0052:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            long r2 = n(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x0061:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x006e:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x007b:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x0088:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x0099:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x00aa:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x00be:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            boolean r2 = o(r9, r4)
            int r2 = com.google.android.gms.internal.measurement.C1152l5.b(r2)
            goto L_0x002f
        L_0x00d0:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x00de:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            long r2 = n(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x00ee:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            int r2 = m(r9, r4)
            goto L_0x002f
        L_0x00fc:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            long r2 = n(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x010c:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            long r2 = n(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x011c:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            float r2 = l(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x002f
        L_0x012e:
            boolean r2 = r8.t(r9, r2, r0)
            if (r2 == 0) goto L_0x0218
            int r1 = r1 * 53
            double r2 = k(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x0142:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x014e:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x015a:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            if (r2 == 0) goto L_0x0166
            int r6 = r2.hashCode()
        L_0x0166:
            int r1 = r1 + r6
            goto L_0x0218
        L_0x0169:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.measurement.C1126i6.k(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x0173:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x017b:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.measurement.C1126i6.k(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x0185:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x018d:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x0195:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x019d:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x01a9:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            if (r2 == 0) goto L_0x0166
            int r6 = r2.hashCode()
            goto L_0x0166
        L_0x01b6:
            int r1 = r1 * 53
            java.lang.Object r2 = com.google.android.gms.internal.measurement.C1126i6.s(r9, r4)
            java.lang.String r2 = (java.lang.String) r2
            int r2 = r2.hashCode()
            goto L_0x002f
        L_0x01c4:
            int r1 = r1 * 53
            boolean r2 = com.google.android.gms.internal.measurement.C1126i6.m(r9, r4)
            int r2 = com.google.android.gms.internal.measurement.C1152l5.b(r2)
            goto L_0x002f
        L_0x01d0:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x01d8:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.measurement.C1126i6.k(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x01e2:
            int r1 = r1 * 53
            int r2 = com.google.android.gms.internal.measurement.C1126i6.i(r9, r4)
            goto L_0x002f
        L_0x01ea:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.measurement.C1126i6.k(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x01f4:
            int r1 = r1 * 53
            long r2 = com.google.android.gms.internal.measurement.C1126i6.k(r9, r4)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x01fe:
            int r1 = r1 * 53
            float r2 = com.google.android.gms.internal.measurement.C1126i6.o(r9, r4)
            int r2 = java.lang.Float.floatToIntBits(r2)
            goto L_0x002f
        L_0x020a:
            int r1 = r1 * 53
            double r2 = com.google.android.gms.internal.measurement.C1126i6.q(r9, r4)
            long r2 = java.lang.Double.doubleToLongBits(r2)
            byte[] r4 = com.google.android.gms.internal.measurement.C1152l5.f5434b
            goto L_0x0040
        L_0x0218:
            int r0 = r0 + 3
            goto L_0x0002
        L_0x021c:
            int r1 = r1 * 53
            r0 = r9
            com.google.android.gms.internal.measurement.e5 r0 = (com.google.android.gms.internal.measurement.C1089e5) r0
            com.google.android.gms.internal.measurement.c6 r0 = r0.zzc
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            boolean r0 = r8.f4974f
            if (r0 != 0) goto L_0x022d
            return r1
        L_0x022d:
            android.support.v4.media.a.a(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.I5.c(java.lang.Object):int");
    }

    public final boolean d(Object obj) {
        int i5;
        int i6;
        int i7;
        Object obj2 = obj;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (true) {
            Q5 q5 = null;
            if (i9 < this.f4976h) {
                int[] iArr = this.f4975g;
                int[] iArr2 = this.f4969a;
                int i11 = iArr[i9];
                int i12 = iArr2[i11];
                int N4 = N(i11);
                int i13 = iArr2[i11 + 2];
                int i14 = i13 & 1048575;
                int i15 = 1 << (i13 >>> 20);
                if (i14 != i10) {
                    if (i14 != 1048575) {
                        i8 = f4968m.getInt(obj2, (long) i14);
                    }
                    i5 = i8;
                    i10 = i14;
                } else {
                    i5 = i8;
                }
                if ((268435456 & N4) != 0) {
                    i7 = i11;
                    i6 = i10;
                    if (!q(obj2, i7, i6, i5, i15)) {
                        return false;
                    }
                } else {
                    i7 = i11;
                    i6 = i10;
                }
                int P4 = P(N4);
                if (P4 != 9 && P4 != 17) {
                    if (P4 != 27) {
                        if (P4 == 60 || P4 == 68) {
                            if (t(obj2, i12, i7) && !M(obj2, N4, F(i7))) {
                                return false;
                            }
                        } else if (P4 != 49) {
                            if (P4 != 50) {
                                continue;
                            } else {
                                C1275z5 z5Var = (C1275z5) C1126i6.s(obj2, (long) (N4 & 1048575));
                                if (!z5Var.isEmpty() && ((C1267y5) G(i7)).e().f5625c.a() == C1171n6.MESSAGE) {
                                    for (Object next : z5Var.values()) {
                                        if (q5 == null) {
                                            q5 = N5.a().b(next.getClass());
                                        }
                                        if (!q5.d(next)) {
                                            return false;
                                        }
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                    List list = (List) C1126i6.s(obj2, (long) (N4 & 1048575));
                    if (!list.isEmpty()) {
                        Q5 F4 = F(i7);
                        for (int i16 = 0; i16 < list.size(); i16++) {
                            if (!F4.d(list.get(i16))) {
                                return false;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (q(obj2, i7, i6, i5, i15) && !M(obj2, N4, F(i7))) {
                    return false;
                }
                i9++;
                i10 = i6;
                i8 = i5;
            } else if (!this.f4974f) {
                return true;
            } else {
                a.a(obj2);
                throw null;
            }
        }
    }

    public final void e(Object obj) {
        if (i(obj)) {
            if (obj instanceof C1089e5) {
                C1089e5 e5Var = (C1089e5) obj;
                e5Var.r(Integer.MAX_VALUE);
                e5Var.zza = 0;
                e5Var.k();
            }
            int[] iArr = this.f4969a;
            for (int i5 = 0; i5 < iArr.length; i5 += 3) {
                int N4 = N(i5);
                int i6 = 1048575 & N4;
                int P4 = P(N4);
                long j5 = (long) i6;
                if (P4 != 9) {
                    if (P4 == 60 || P4 == 68) {
                        if (t(obj, iArr[i5], i5)) {
                            F(i5).e(f4968m.getObject(obj, j5));
                        }
                    } else {
                        switch (P4) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((C1143k5) C1126i6.s(obj, j5)).B();
                                continue;
                            case 50:
                                Unsafe unsafe = f4968m;
                                Object object = unsafe.getObject(obj, j5);
                                if (object != null) {
                                    ((C1275z5) object).e();
                                    unsafe.putObject(obj, j5, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (r(obj, i5)) {
                    F(i5).e(f4968m.getObject(obj, j5));
                }
            }
            this.f4978j.b(obj);
            if (this.f4974f) {
                this.f4979k.a(obj);
            }
        }
    }

    public final void f(Object obj, byte[] bArr, int i5, int i6, C1240v4 v4Var) {
        z(obj, bArr, i5, i6, 0, v4Var);
    }

    public final void g(Object obj, C1180o6 o6Var) {
        int i5;
        I5 i52 = this;
        Object obj2 = obj;
        C1180o6 o6Var2 = o6Var;
        if (!i52.f4974f) {
            int[] iArr = i52.f4969a;
            Unsafe unsafe = f4968m;
            int i6 = 1048575;
            int i7 = 1048575;
            int i8 = 0;
            int i9 = 0;
            while (i8 < iArr.length) {
                int N4 = i52.N(i8);
                int P4 = P(N4);
                int i10 = iArr[i8];
                if (P4 <= 17) {
                    int i11 = iArr[i8 + 2];
                    int i12 = i11 & i6;
                    if (i12 != i7) {
                        if (i12 == i6) {
                            i9 = 0;
                        } else {
                            i9 = unsafe.getInt(obj2, (long) i12);
                        }
                        i7 = i12;
                    }
                    i5 = 1 << (i11 >>> 20);
                } else {
                    i5 = 0;
                }
                long j5 = (long) (N4 & i6);
                switch (P4) {
                    case 0:
                        if (!i52.q(obj2, i8, i7, i9, i5)) {
                            break;
                        } else {
                            o6Var2.v(i10, C1126i6.q(obj2, j5));
                            continue;
                        }
                    case 1:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.K(i10, C1126i6.o(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.i(i10, unsafe.getLong(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.l(i10, unsafe.getLong(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.p(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.b(i10, unsafe.getLong(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.f(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.G(i10, C1126i6.m(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            x(i10, unsafe.getObject(obj2, j5), o6Var2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.h(i10, unsafe.getObject(obj2, j5), i52.F(i8));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.a(i10, (H4) unsafe.getObject(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.y(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.B(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.d(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.H(i10, unsafe.getLong(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.C(i10, unsafe.getInt(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.m(i10, unsafe.getLong(obj2, j5));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if (i52.q(obj2, i8, i7, i9, i5)) {
                            o6Var2.F(i10, unsafe.getObject(obj2, j5), i52.F(i8));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        S5.f(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 19:
                        S5.g(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 20:
                        S5.h(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 21:
                        S5.i(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 22:
                        S5.m(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 23:
                        S5.k(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 24:
                        S5.p(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 25:
                        S5.s(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 26:
                        int i13 = iArr[i8];
                        List list = (List) unsafe.getObject(obj2, j5);
                        int i14 = S5.f5173b;
                        if (list != null && !list.isEmpty()) {
                            o6Var2.z(i13, list);
                            break;
                        }
                    case 27:
                        int i15 = iArr[i8];
                        List list2 = (List) unsafe.getObject(obj2, j5);
                        Q5 F4 = i52.F(i8);
                        int i16 = S5.f5173b;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i17 = 0; i17 < list2.size(); i17++) {
                                ((N4) o6Var2).h(i15, list2.get(i17), F4);
                            }
                            break;
                        }
                    case 28:
                        int i18 = iArr[i8];
                        List list3 = (List) unsafe.getObject(obj2, j5);
                        int i19 = S5.f5173b;
                        if (list3 != null && !list3.isEmpty()) {
                            o6Var2.t(i18, list3);
                            break;
                        }
                    case 29:
                        S5.n(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 30:
                        S5.r(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 31:
                        S5.q(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 32:
                        S5.l(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 33:
                        S5.o(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 34:
                        S5.j(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, false);
                        continue;
                    case 35:
                        S5.f(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 36:
                        S5.g(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 37:
                        S5.h(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 38:
                        S5.i(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 39:
                        S5.m(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 40:
                        S5.k(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 41:
                        S5.p(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 42:
                        S5.s(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 43:
                        S5.n(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 44:
                        S5.r(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 45:
                        S5.q(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 46:
                        S5.l(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 47:
                        S5.o(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 48:
                        S5.j(iArr[i8], (List) unsafe.getObject(obj2, j5), o6Var2, true);
                        break;
                    case 49:
                        int i20 = iArr[i8];
                        List list4 = (List) unsafe.getObject(obj2, j5);
                        Q5 F5 = i52.F(i8);
                        int i21 = S5.f5173b;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i22 = 0; i22 < list4.size(); i22++) {
                                ((N4) o6Var2).F(i20, list4.get(i22), F5);
                            }
                            break;
                        }
                    case 50:
                        Object object = unsafe.getObject(obj2, j5);
                        if (object != null) {
                            o6Var2.g(i10, ((C1267y5) i52.G(i8)).e(), (C1275z5) object);
                            break;
                        }
                        break;
                    case 51:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.v(i10, k(obj2, j5));
                            break;
                        }
                        break;
                    case 52:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.K(i10, l(obj2, j5));
                            break;
                        }
                        break;
                    case 53:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.i(i10, n(obj2, j5));
                            break;
                        }
                        break;
                    case 54:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.l(i10, n(obj2, j5));
                            break;
                        }
                        break;
                    case 55:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.p(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 56:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.b(i10, n(obj2, j5));
                            break;
                        }
                        break;
                    case 57:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.f(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 58:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.G(i10, o(obj2, j5));
                            break;
                        }
                        break;
                    case 59:
                        if (i52.t(obj2, i10, i8)) {
                            x(i10, unsafe.getObject(obj2, j5), o6Var2);
                            break;
                        }
                        break;
                    case 60:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.h(i10, unsafe.getObject(obj2, j5), i52.F(i8));
                            break;
                        }
                        break;
                    case 61:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.a(i10, (H4) unsafe.getObject(obj2, j5));
                            break;
                        }
                        break;
                    case 62:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.y(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 63:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.B(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 64:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.d(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 65:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.H(i10, n(obj2, j5));
                            break;
                        }
                        break;
                    case 66:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.C(i10, m(obj2, j5));
                            break;
                        }
                        break;
                    case 67:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.m(i10, n(obj2, j5));
                            break;
                        }
                        break;
                    case 68:
                        if (i52.t(obj2, i10, i8)) {
                            o6Var2.F(i10, unsafe.getObject(obj2, j5), i52.F(i8));
                            break;
                        }
                        break;
                }
                i8 += 3;
                i6 = 1048575;
                i52 = this;
            }
            ((C1089e5) obj2).zzc.f(o6Var2);
            return;
        }
        a.a(obj2);
        throw null;
    }

    public final boolean h(Object obj, Object obj2) {
        boolean z4;
        for (int i5 = 0; i5 < this.f4969a.length; i5 += 3) {
            int N4 = N(i5);
            long j5 = (long) (N4 & 1048575);
            switch (P(N4)) {
                case 0:
                    if (p(obj, obj2, i5) && Double.doubleToLongBits(C1126i6.q(obj, j5)) == Double.doubleToLongBits(C1126i6.q(obj2, j5))) {
                        continue;
                    }
                case 1:
                    if (p(obj, obj2, i5) && Float.floatToIntBits(C1126i6.o(obj, j5)) == Float.floatToIntBits(C1126i6.o(obj2, j5))) {
                        continue;
                    }
                case 2:
                    if (p(obj, obj2, i5) && C1126i6.k(obj, j5) == C1126i6.k(obj2, j5)) {
                        continue;
                    }
                case 3:
                    if (p(obj, obj2, i5) && C1126i6.k(obj, j5) == C1126i6.k(obj2, j5)) {
                        continue;
                    }
                case 4:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 5:
                    if (p(obj, obj2, i5) && C1126i6.k(obj, j5) == C1126i6.k(obj2, j5)) {
                        continue;
                    }
                case 6:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 7:
                    if (p(obj, obj2, i5) && C1126i6.m(obj, j5) == C1126i6.m(obj2, j5)) {
                        continue;
                    }
                case 8:
                    if (p(obj, obj2, i5) && S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5))) {
                        continue;
                    }
                case 9:
                    if (p(obj, obj2, i5) && S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5))) {
                        continue;
                    }
                case 10:
                    if (p(obj, obj2, i5) && S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5))) {
                        continue;
                    }
                case 11:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 12:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 13:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 14:
                    if (p(obj, obj2, i5) && C1126i6.k(obj, j5) == C1126i6.k(obj2, j5)) {
                        continue;
                    }
                case 15:
                    if (p(obj, obj2, i5) && C1126i6.i(obj, j5) == C1126i6.i(obj2, j5)) {
                        continue;
                    }
                case 16:
                    if (p(obj, obj2, i5) && C1126i6.k(obj, j5) == C1126i6.k(obj2, j5)) {
                        continue;
                    }
                case 17:
                    if (p(obj, obj2, i5) && S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z4 = S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5));
                    break;
                case 50:
                    z4 = S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long O4 = (long) (O(i5) & 1048575);
                    if (C1126i6.i(obj, O4) == C1126i6.i(obj2, O4) && S5.b(C1126i6.s(obj, j5), C1126i6.s(obj2, j5))) {
                        continue;
                    }
            }
            if (!z4) {
                return false;
            }
        }
        if (!((C1089e5) obj).zzc.equals(((C1089e5) obj2).zzc)) {
            return false;
        }
        if (!this.f4974f) {
            return true;
        }
        a.a(obj);
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v125, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v139, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v107, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v159, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v160, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v161, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v121, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v122, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v123, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v129, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v124, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v125, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v131, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v127, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v128, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v134, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v141, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v185, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v186, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x032c, code lost:
        r33 = r3;
        r3 = r2;
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03a7, code lost:
        r0 = r19;
        r19 = r11;
        r11 = r0;
        r1 = r40;
        r14 = r2;
        r0 = r3;
        r4 = r7;
        r3 = r8;
        r27 = "Failed to parse the message.";
        r10 = r15;
        r15 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03b7, code lost:
        r9 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x04e1, code lost:
        r14 = r36;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04e4, code lost:
        r2 = r3;
        r30 = r11;
        r15 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x04e8, code lost:
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x051e, code lost:
        r14 = r36;
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0522, code lost:
        r14 = r36;
        r2 = r3;
        r30 = r11;
        r15 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0528, code lost:
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x06af, code lost:
        r1 = r35;
        r15 = r2;
        r2 = r3;
        r13 = r4;
        r5 = r6;
        r30 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x07ad, code lost:
        r6 = r0;
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x07af, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x07b0, code lost:
        r11 = r7;
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x07c2, code lost:
        r15 = r2;
        r2 = r4;
        r11 = r7;
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x083f, code lost:
        r15 = r2;
        r2 = r4;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0906, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e6, code lost:
        r8 = r19;
        r11 = 0;
        r16 = 1048575;
        r5 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x09c9, code lost:
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x09ca, code lost:
        if (r6 == r13) goto L_0x09da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x09cc, code lost:
        r4 = r2;
        r9 = r10;
        r7 = r11;
        r3 = r14;
        r10 = r19;
        r2 = r21;
        r14 = r22;
        r8 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x09da, code lost:
        r1 = r40;
        r3 = r2;
        r4 = r6;
        r9 = r10;
        r10 = r11;
        r0 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012a, code lost:
        r7 = r10;
        r10 = r11;
        r9 = r12;
        r8 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:454:0x0b2a, code lost:
        r3 = r37;
        r31 = r10;
        r27 = r11;
        r12 = r13;
        r11 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:455:0x0b33, code lost:
        r10 = r41;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:459:0x0b61, code lost:
        r6 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x0b83, code lost:
        r10 = r6;
        r27 = r11;
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x0b89, code lost:
        r3 = r2;
        r31 = r10;
        r27 = r11;
        r11 = r12;
        r12 = r13;
        r10 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:468:0x0bb2, code lost:
        r3 = r2;
        r10 = r6;
        r27 = r11;
        r11 = r12;
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0137, code lost:
        r7 = r5;
        r31 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0c1b, code lost:
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x013a, code lost:
        r22 = r14;
        r21 = r15;
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0ccd, code lost:
        r3 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x0cef, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:528:0x0d97, code lost:
        if (r6 == r12) goto L_0x0da8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:529:0x0d99, code lost:
        r1 = r35;
        r5 = r39;
        r2 = r0;
        r4 = r3;
        r7 = r10;
        r8 = r11;
        r3 = r14;
        r10 = r19;
        r14 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:530:0x0da8, code lost:
        r1 = r40;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:534:0x0db9, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:544:0x0e13, code lost:
        if (r10 == 1048575) goto L_0x0e19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:545:0x0e15, code lost:
        r2.putInt(r14, (long) r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:546:0x0e19, code lost:
        r0 = r8.f4976h;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:548:0x0e1f, code lost:
        if (r0 >= r8.f4977i) goto L_0x0ecd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:549:0x0e21, code lost:
        r3 = r8.f4975g;
        r4 = r8.f4978j;
        r7 = r8.f4969a;
        r3 = r3[r0];
        r7 = r7[r3];
        r9 = com.google.android.gms.internal.measurement.C1126i6.s(r14, (long) (r8.N(r3) & 1048575));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:550:0x0e39, code lost:
        if (r9 == null) goto L_0x0ec1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:551:0x0e3b, code lost:
        r10 = r8.H(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:552:0x0e3f, code lost:
        if (r10 == null) goto L_0x0ec1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:553:0x0e41, code lost:
        r3 = ((com.google.android.gms.internal.measurement.C1267y5) r8.G(r3)).e();
        r9 = ((com.google.android.gms.internal.measurement.C1275z5) r9).entrySet().iterator();
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:555:0x0e59, code lost:
        if (r9.hasNext() == false) goto L_0x0ec1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:556:0x0e5b, code lost:
        r11 = (java.util.Map.Entry) r9.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:557:0x0e6f, code lost:
        if (r10.a(((java.lang.Integer) r11.getValue()).intValue()) != false) goto L_0x0ebe;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:558:0x0e71, code lost:
        if (r2 != null) goto L_0x0e77;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:559:0x0e73, code lost:
        r2 = r4.a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:560:0x0e77, code lost:
        r12 = com.google.android.gms.internal.measurement.C1267y5.c(r3, r11.getKey(), r11.getValue());
        r13 = com.google.android.gms.internal.measurement.H4.f4958b;
        r13 = new byte[r12];
        r17 = com.google.android.gms.internal.measurement.M4.f5024d;
        r17 = r0;
        r18 = r4;
        r0 = new com.google.android.gms.internal.measurement.K4(r13, 0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:562:?, code lost:
        com.google.android.gms.internal.measurement.C1267y5.b(r0, r3, r11.getKey(), r11.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:563:0x0e9e, code lost:
        ((com.google.android.gms.internal.measurement.C1072c6) r2).j((r7 << 3) | 2, com.google.android.gms.internal.measurement.E4.a(r0, r13));
        r9.remove();
        r0 = r17;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:564:0x0eb7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:566:0x0ebd, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:568:0x0ec1, code lost:
        r0 = r0 + 1;
        r2 = (com.google.android.gms.internal.measurement.C1072c6) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:569:0x0ecd, code lost:
        if (r2 == null) goto L_0x0ed4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:570:0x0ecf, code lost:
        ((com.google.android.gms.internal.measurement.C1089e5) r14).zzc = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:571:0x0ed4, code lost:
        if (r1 != 0) goto L_0x0ee1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:572:0x0ed6, code lost:
        if (r6 != r5) goto L_0x0ed9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:574:0x0ee0, code lost:
        throw new com.google.android.gms.internal.measurement.C1170n5(r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:575:0x0ee1, code lost:
        r11 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:576:0x0ee3, code lost:
        if (r6 > r5) goto L_0x0ee8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:577:0x0ee5, code lost:
        if (r15 != r1) goto L_0x0ee8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:578:0x0ee7, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:580:0x0eed, code lost:
        throw new com.google.android.gms.internal.measurement.C1170n5(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019f, code lost:
        r6 = r3;
        r3 = r2;
        r2 = r6;
        r9 = r4;
        r6 = r5;
        r4 = r8;
        r7 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:612:0x012f, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01af, code lost:
        r31 = r4;
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:671:0x0ec1, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:672:0x0ec1, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:673:0x0ec1, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:674:0x0e55, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:675:0x0e55, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:676:0x0e55, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0205, code lost:
        r16 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0208, code lost:
        r4 = r2;
        r2 = r10;
        r10 = r11;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0272, code lost:
        r3 = r8;
        r8 = r2;
        r2 = r3;
        r15 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0276, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02a0, code lost:
        r5 = r39;
        r14 = r3;
        r7 = r4;
        r3 = r8;
        r8 = r19;
        r15 = r21;
        r9 = r31;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0667  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0717  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0776  */
    /* JADX WARNING: Removed duplicated region for block: B:645:0x0697 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:649:0x073e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:653:0x07ad A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int z(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.measurement.C1240v4 r41) {
        /*
            r35 = this;
            r1 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r7 = r41
            j(r3)
            sun.misc.Unsafe r2 = f4968m
            r11 = 0
            r6 = r38
            r9 = r11
            r14 = r9
            r15 = r14
            r8 = -1
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r16 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001c:
            java.lang.String r13 = "Failed to parse the message."
            r18 = 0
            r38 = 3
            if (r6 >= r5) goto L_0x0e08
            int r15 = r6 + 1
            byte r6 = r4[r6]
            if (r6 >= 0) goto L_0x0030
            int r15 = com.google.android.gms.internal.measurement.C1249w4.b(r6, r4, r15, r7)
            int r6 = r7.f5608a
        L_0x0030:
            r7 = r15
            r15 = r6
            int r6 = r15 >>> 3
            if (r6 <= r8) goto L_0x0046
            int r9 = r9 / 3
            int r8 = r1.f4971c
            if (r6 < r8) goto L_0x0053
            int r8 = r1.f4972d
            if (r6 > r8) goto L_0x0053
            int r8 = r1.v(r6, r9)
        L_0x0044:
            r9 = -1
            goto L_0x0055
        L_0x0046:
            int r8 = r1.f4971c
            if (r6 < r8) goto L_0x0053
            int r8 = r1.f4972d
            if (r6 > r8) goto L_0x0053
            int r8 = r1.v(r6, r11)
            goto L_0x0044
        L_0x0053:
            r8 = -1
            goto L_0x0044
        L_0x0055:
            if (r8 != r9) goto L_0x006b
            r1 = r40
            r0 = r2
            r17 = r9
            r19 = r10
            r9 = r11
            r27 = r13
            r22 = r14
            r10 = r41
            r14 = r3
            r3 = r4
            r11 = r6
            r4 = r7
            goto L_0x0dad
        L_0x006b:
            r9 = r15 & 7
            int[] r11 = r1.f4969a
            int r19 = r8 + 1
            r12 = r11[r19]
            int r4 = P(r12)
            r5 = r12 & r16
            r19 = r6
            long r5 = (long) r5
            r21 = r5
            r23 = 0
            r25 = 536870912(0x20000000, float:1.0842022E-19)
            java.lang.String r6 = ""
            java.lang.String r5 = "CodedInputStream encountered an embedded string or message which claimed to have negative size."
            r28 = r11
            r11 = 17
            r29 = 1
            if (r4 > r11) goto L_0x03bb
            int r11 = r8 + 2
            r11 = r28[r11]
            int r27 = r11 >>> 20
            int r27 = r29 << r27
            r11 = r11 & r16
            r30 = r7
            if (r11 == r10) goto L_0x00b4
            r7 = r16
            r31 = r8
            if (r10 == r7) goto L_0x00a9
            long r7 = (long) r10
            r2.putInt(r3, r7, r14)
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x00a9:
            if (r11 != r7) goto L_0x00ad
            r7 = 0
            goto L_0x00b2
        L_0x00ad:
            long r7 = (long) r11
            int r7 = r2.getInt(r3, r7)
        L_0x00b2:
            r14 = r7
            goto L_0x00b7
        L_0x00b4:
            r31 = r8
            r11 = r10
        L_0x00b7:
            switch(r4) {
                case 0: goto L_0x0382;
                case 1: goto L_0x035b;
                case 2: goto L_0x0333;
                case 3: goto L_0x0333;
                case 4: goto L_0x030c;
                case 5: goto L_0x02ce;
                case 6: goto L_0x02ad;
                case 7: goto L_0x0279;
                case 8: goto L_0x021b;
                case 9: goto L_0x01d1;
                case 10: goto L_0x01b3;
                case 11: goto L_0x030c;
                case 12: goto L_0x0169;
                case 13: goto L_0x02ad;
                case 14: goto L_0x02ce;
                case 15: goto L_0x0141;
                case 16: goto L_0x0101;
                default: goto L_0x00ba;
            }
        L_0x00ba:
            r4 = r38
            if (r9 != r4) goto L_0x00f0
            r14 = r14 | r27
            r8 = r31
            java.lang.Object r4 = r1.I(r3, r8)
            int r5 = r19 << 3
            r9 = r5 | 4
            com.google.android.gms.internal.measurement.Q5 r5 = r1.F(r8)
            r6 = r37
            r10 = r41
            r12 = r8
            r7 = r30
            r17 = -1
            r8 = r39
            int r5 = com.google.android.gms.internal.measurement.C1249w4.k(r4, r5, r6, r7, r8, r9, r10)
            r8 = r6
            r1.J(r3, r12, r4)
            r6 = r5
            r4 = r8
            r7 = r10
            r10 = r11
            r9 = r12
        L_0x00e6:
            r8 = r19
            r11 = 0
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r39
            goto L_0x001c
        L_0x00f0:
            r17 = -1
            r7 = r3
            r3 = r2
            r2 = r7
            r8 = r37
            r22 = r14
            r21 = r15
            r7 = r30
            r15 = r41
            goto L_0x03a7
        L_0x0101:
            r8 = r37
            r10 = r41
            r5 = r30
            r12 = r31
            r17 = -1
            if (r9 != 0) goto L_0x0132
            r14 = r14 | r27
            int r9 = com.google.android.gms.internal.measurement.C1249w4.c(r8, r5, r10)
            long r4 = r10.f5609b
            long r6 = com.google.android.gms.internal.measurement.J4.b(r4)
            r4 = r21
            r2.putLong(r3, r4, r6)
            r33 = r3
            r3 = r2
            r2 = r33
            r4 = r3
            r3 = r2
            r2 = r4
            r5 = r39
            r4 = r8
            r6 = r9
        L_0x012a:
            r7 = r10
            r10 = r11
            r9 = r12
            r8 = r19
        L_0x012f:
            r11 = 0
            goto L_0x0019
        L_0x0132:
            r33 = r3
            r3 = r2
            r2 = r33
        L_0x0137:
            r7 = r5
            r31 = r12
        L_0x013a:
            r22 = r14
            r21 = r15
            r15 = r10
            goto L_0x03a7
        L_0x0141:
            r5 = r3
            r3 = r2
            r2 = r5
            r8 = r37
            r10 = r41
            r6 = r21
            r5 = r30
            r12 = r31
            r17 = -1
            if (r9 != 0) goto L_0x0137
            r14 = r14 | r27
            int r4 = com.google.android.gms.internal.measurement.C1249w4.a(r8, r5, r10)
            int r5 = r10.f5608a
            int r5 = com.google.android.gms.internal.measurement.J4.a(r5)
            r3.putInt(r2, r6, r5)
            r5 = r3
            r3 = r2
            r2 = r5
            r5 = r39
            r6 = r4
            r4 = r8
            goto L_0x012a
        L_0x0169:
            r4 = r3
            r3 = r2
            r2 = r4
            r8 = r37
            r10 = r41
            r6 = r21
            r5 = r30
            r4 = r31
            r17 = -1
            if (r9 != 0) goto L_0x01af
            int r5 = com.google.android.gms.internal.measurement.C1249w4.a(r8, r5, r10)
            int r9 = r10.f5608a
            com.google.android.gms.internal.measurement.h5 r13 = r1.H(r4)
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = r12 & r18
            if (r12 == 0) goto L_0x01a9
            if (r13 == 0) goto L_0x01a9
            boolean r12 = r13.a(r9)
            if (r12 == 0) goto L_0x0193
            goto L_0x01a9
        L_0x0193:
            com.google.android.gms.internal.measurement.c6 r6 = y(r2)
            long r12 = (long) r9
            java.lang.Long r7 = java.lang.Long.valueOf(r12)
            r6.j(r15, r7)
        L_0x019f:
            r6 = r3
            r3 = r2
            r2 = r6
            r9 = r4
            r6 = r5
            r4 = r8
            r7 = r10
            r10 = r11
            goto L_0x00e6
        L_0x01a9:
            r14 = r14 | r27
            r3.putInt(r2, r6, r9)
            goto L_0x019f
        L_0x01af:
            r31 = r4
            r7 = r5
            goto L_0x013a
        L_0x01b3:
            r4 = r3
            r3 = r2
            r2 = r4
            r8 = r37
            r10 = r41
            r6 = r21
            r5 = r30
            r4 = r31
            r12 = 2
            r17 = -1
            if (r9 != r12) goto L_0x01af
            r14 = r14 | r27
            int r5 = com.google.android.gms.internal.measurement.C1249w4.g(r8, r5, r10)
            java.lang.Object r9 = r10.f5610c
            r3.putObject(r2, r6, r9)
            goto L_0x019f
        L_0x01d1:
            r4 = r3
            r3 = r2
            r2 = r4
            r8 = r37
            r10 = r41
            r5 = r30
            r4 = r31
            r12 = 2
            r17 = -1
            if (r9 != r12) goto L_0x020e
            r14 = r14 | r27
            r6 = r2
            java.lang.Object r2 = r1.I(r6, r4)
            r7 = r3
            com.google.android.gms.internal.measurement.Q5 r3 = r1.F(r4)
            r9 = r10
            r10 = r7
            r7 = r9
            r9 = r4
            r4 = r8
            r8 = r6
            r6 = r39
            int r3 = com.google.android.gms.internal.measurement.C1249w4.j(r2, r3, r4, r5, r6, r7)
            r5 = r2
            r2 = r4
            r4 = r7
            r1.J(r8, r9, r5)
            r5 = r39
            r6 = r3
            r3 = r8
            r8 = r19
        L_0x0205:
            r16 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0208:
            r4 = r2
            r2 = r10
            r10 = r11
            r11 = 0
            goto L_0x001c
        L_0x020e:
            r7 = r8
            r8 = r2
            r2 = r7
            r7 = r5
            r21 = r8
            r8 = r2
            r2 = r21
            r31 = r4
            goto L_0x013a
        L_0x021b:
            r4 = r41
            r10 = r2
            r8 = r3
            r7 = r30
            r3 = 2
            r17 = -1
            r2 = r37
            r33 = r21
            r22 = r14
            r21 = r15
            r14 = r33
            if (r9 != r3) goto L_0x0272
            r3 = r12 & r25
            if (r3 == 0) goto L_0x023d
            r3 = r22 | r27
            int r5 = com.google.android.gms.internal.measurement.C1249w4.f(r2, r7, r4)
            r6 = r5
            r5 = r3
            goto L_0x0258
        L_0x023d:
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r7, r4)
            int r7 = r4.f5608a
            if (r7 < 0) goto L_0x026c
            r5 = r22 | r27
            if (r7 != 0) goto L_0x024d
            r4.f5610c = r6
        L_0x024b:
            r6 = r3
            goto L_0x0258
        L_0x024d:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r6.<init>(r2, r3, r7, r9)
            r4.f5610c = r6
            int r3 = r3 + r7
            goto L_0x024b
        L_0x0258:
            java.lang.Object r3 = r4.f5610c
            r10.putObject(r8, r14, r3)
            r7 = r4
            r14 = r5
            r3 = r8
            r8 = r19
            r15 = r21
            r9 = r31
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r39
            goto L_0x0208
        L_0x026c:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x0272:
            r3 = r8
            r8 = r2
            r2 = r3
            r15 = r4
        L_0x0276:
            r3 = r10
            goto L_0x03a7
        L_0x0279:
            r4 = r41
            r10 = r2
            r8 = r3
            r7 = r30
            r17 = -1
            r2 = r37
            r33 = r21
            r22 = r14
            r21 = r15
            r14 = r33
            if (r9 != 0) goto L_0x0272
            r3 = r22 | r27
            int r6 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r7, r4)
            long r12 = r4.f5609b
            int r5 = (r12 > r23 ? 1 : (r12 == r23 ? 0 : -1))
            if (r5 == 0) goto L_0x029c
            r5 = r29
            goto L_0x029d
        L_0x029c:
            r5 = 0
        L_0x029d:
            com.google.android.gms.internal.measurement.C1126i6.n(r8, r14, r5)
        L_0x02a0:
            r5 = r39
            r14 = r3
            r7 = r4
            r3 = r8
            r8 = r19
            r15 = r21
            r9 = r31
            goto L_0x0205
        L_0x02ad:
            r4 = r41
            r10 = r2
            r8 = r3
            r7 = r30
            r3 = 5
            r17 = -1
            r2 = r37
            r33 = r21
            r22 = r14
            r21 = r15
            r14 = r33
            if (r9 != r3) goto L_0x0272
            int r6 = r7 + 4
            r3 = r22 | r27
            int r5 = com.google.android.gms.internal.measurement.C1249w4.d(r2, r7)
            r10.putInt(r8, r14, r5)
            goto L_0x02a0
        L_0x02ce:
            r4 = r41
            r10 = r2
            r8 = r3
            r3 = r29
            r7 = r30
            r17 = -1
            r2 = r37
            r33 = r21
            r22 = r14
            r21 = r15
            r14 = r33
            if (r9 != r3) goto L_0x0306
            int r9 = r7 + 8
            r12 = r22 | r27
            long r6 = com.google.android.gms.internal.measurement.C1249w4.e(r2, r7)
            r33 = r14
            r15 = r4
            r4 = r33
            r3 = r8
            r8 = r2
            r2 = r10
            r2.putLong(r3, r4, r6)
            r5 = r39
            r4 = r8
            r6 = r9
            r10 = r11
            r14 = r12
        L_0x02fd:
            r7 = r15
            r8 = r19
            r15 = r21
        L_0x0302:
            r9 = r31
            goto L_0x012f
        L_0x0306:
            r15 = r4
            r3 = r8
            r8 = r2
            r2 = r3
            goto L_0x0276
        L_0x030c:
            r8 = r37
            r4 = r21
            r7 = r30
            r17 = -1
            r22 = r14
            r21 = r15
            r15 = r41
            if (r9 != 0) goto L_0x032c
            r14 = r22 | r27
            int r6 = com.google.android.gms.internal.measurement.C1249w4.a(r8, r7, r15)
            int r7 = r15.f5608a
            r2.putInt(r3, r4, r7)
        L_0x0327:
            r5 = r39
            r4 = r8
        L_0x032a:
            r10 = r11
            goto L_0x02fd
        L_0x032c:
            r33 = r3
            r3 = r2
            r2 = r33
            goto L_0x03a7
        L_0x0333:
            r8 = r37
            r4 = r21
            r7 = r30
            r17 = -1
            r22 = r14
            r21 = r15
            r15 = r41
            if (r9 != 0) goto L_0x032c
            r14 = r22 | r27
            int r9 = com.google.android.gms.internal.measurement.C1249w4.c(r8, r7, r15)
            long r6 = r15.f5609b
            r2.putLong(r3, r4, r6)
            r33 = r3
            r3 = r2
            r2 = r33
            r4 = r3
            r3 = r2
            r2 = r4
            r5 = r39
            r4 = r8
            r6 = r9
            goto L_0x032a
        L_0x035b:
            r4 = r3
            r3 = r2
            r2 = r4
            r8 = r37
            r4 = r21
            r7 = r30
            r6 = 5
            r17 = -1
            r22 = r14
            r21 = r15
            r15 = r41
            if (r9 != r6) goto L_0x03a7
            int r6 = r7 + 4
            r14 = r22 | r27
            int r7 = com.google.android.gms.internal.measurement.C1249w4.d(r8, r7)
            float r7 = java.lang.Float.intBitsToFloat(r7)
            com.google.android.gms.internal.measurement.C1126i6.p(r2, r4, r7)
        L_0x037e:
            r4 = r3
            r3 = r2
            r2 = r4
            goto L_0x0327
        L_0x0382:
            r4 = r3
            r3 = r2
            r2 = r4
            r8 = r37
            r4 = r21
            r6 = r29
            r7 = r30
            r17 = -1
            r22 = r14
            r21 = r15
            r15 = r41
            if (r9 != r6) goto L_0x03a7
            int r6 = r7 + 8
            r14 = r22 | r27
            long r9 = com.google.android.gms.internal.measurement.C1249w4.e(r8, r7)
            double r9 = java.lang.Double.longBitsToDouble(r9)
            com.google.android.gms.internal.measurement.C1126i6.r(r2, r4, r9)
            goto L_0x037e
        L_0x03a7:
            r0 = r19
            r19 = r11
            r11 = r0
            r1 = r40
            r14 = r2
            r0 = r3
            r4 = r7
            r3 = r8
            r27 = r13
            r10 = r15
            r15 = r21
        L_0x03b7:
            r9 = r31
            goto L_0x0dad
        L_0x03bb:
            r11 = r3
            r3 = r2
            r2 = r11
            r30 = r7
            r11 = r19
            r17 = -1
            r19 = r10
            r10 = r8
            r7 = r21
            r22 = r14
            r21 = r15
            r15 = r41
            r14 = 27
            if (r4 != r14) goto L_0x042f
            r14 = 2
            if (r9 != r14) goto L_0x041c
            java.lang.Object r4 = r3.getObject(r2, r7)
            com.google.android.gms.internal.measurement.k5 r4 = (com.google.android.gms.internal.measurement.C1143k5) r4
            boolean r5 = r4.A()
            if (r5 != 0) goto L_0x03f3
            int r5 = r4.size()
            if (r5 != 0) goto L_0x03eb
            r5 = 10
            goto L_0x03ec
        L_0x03eb:
            int r5 = r5 + r5
        L_0x03ec:
            com.google.android.gms.internal.measurement.k5 r4 = r4.m(r5)
            r3.putObject(r2, r7, r4)
        L_0x03f3:
            r7 = r4
            com.google.android.gms.internal.measurement.Q5 r2 = r1.F(r10)
            r14 = r36
            r4 = r37
            r6 = r39
            r8 = r15
            r5 = r30
            r15 = r3
            r3 = r21
            int r2 = com.google.android.gms.internal.measurement.C1249w4.n(r2, r3, r4, r5, r6, r7, r8)
            r5 = r39
            r7 = r41
            r6 = r2
            r9 = r10
            r8 = r11
            r2 = r15
            r10 = r19
            r11 = 0
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r3
            r3 = r14
            r14 = r22
            goto L_0x001c
        L_0x041c:
            r15 = r3
            r4 = r30
            r30 = r11
            r11 = r13
            r13 = r4
            r4 = r41
            r14 = r2
            r9 = r15
            r15 = r21
            r2 = r37
        L_0x042b:
            r5 = r39
            goto L_0x0b08
        L_0x042f:
            r14 = r2
            r15 = r3
            r3 = r21
            r2 = 49
            java.lang.String r3 = "Protocol message had invalid UTF-8."
            java.lang.String r0 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            if (r4 > r2) goto L_0x09f3
            r27 = r13
            long r12 = (long) r12
            java.lang.Object r2 = r15.getObject(r14, r7)
            com.google.android.gms.internal.measurement.k5 r2 = (com.google.android.gms.internal.measurement.C1143k5) r2
            boolean r25 = r2.A()
            if (r25 != 0) goto L_0x045b
            int r25 = r2.size()
            r31 = r12
            int r12 = r25 + r25
            com.google.android.gms.internal.measurement.k5 r2 = r2.m(r12)
            r15.putObject(r14, r7, r2)
        L_0x0459:
            r8 = r2
            goto L_0x045e
        L_0x045b:
            r31 = r12
            goto L_0x0459
        L_0x045e:
            switch(r4) {
                case 18: goto L_0x099d;
                case 19: goto L_0x0963;
                case 20: goto L_0x0909;
                case 21: goto L_0x0909;
                case 22: goto L_0x08e1;
                case 23: goto L_0x0875;
                case 24: goto L_0x0805;
                case 25: goto L_0x07c8;
                case 26: goto L_0x06e3;
                case 27: goto L_0x06b9;
                case 28: goto L_0x063a;
                case 29: goto L_0x08e1;
                case 30: goto L_0x0589;
                case 31: goto L_0x0805;
                case 32: goto L_0x0875;
                case 33: goto L_0x052b;
                case 34: goto L_0x04af;
                case 35: goto L_0x099d;
                case 36: goto L_0x0963;
                case 37: goto L_0x0909;
                case 38: goto L_0x0909;
                case 39: goto L_0x08e1;
                case 40: goto L_0x0875;
                case 41: goto L_0x0805;
                case 42: goto L_0x07c8;
                case 43: goto L_0x08e1;
                case 44: goto L_0x0589;
                case 45: goto L_0x0805;
                case 46: goto L_0x0875;
                case 47: goto L_0x052b;
                case 48: goto L_0x04af;
                default: goto L_0x0461;
            }
        L_0x0461:
            r4 = 3
            if (r9 != r4) goto L_0x049e
            r0 = r21 & -8
            r6 = r0 | 4
            com.google.android.gms.internal.measurement.Q5 r2 = r1.F(r10)
            r3 = r37
            r5 = r39
            r7 = r41
            r12 = r21
            r4 = r30
            int r0 = com.google.android.gms.internal.measurement.C1249w4.i(r2, r3, r4, r5, r6, r7)
            r13 = r4
            java.lang.Object r4 = r7.f5610c
            r8.add(r4)
        L_0x0480:
            if (r0 >= r5) goto L_0x0494
            int r4 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r0, r7)
            int r9 = r7.f5608a
            if (r12 != r9) goto L_0x0494
            int r0 = com.google.android.gms.internal.measurement.C1249w4.i(r2, r3, r4, r5, r6, r7)
            java.lang.Object r4 = r7.f5610c
            r8.add(r4)
            goto L_0x0480
        L_0x0494:
            r6 = r0
            r2 = r3
            r30 = r11
            r21 = r15
            r11 = r7
            r15 = r12
            goto L_0x09ca
        L_0x049e:
            r2 = r21
            r21 = r15
            r15 = r2
            r2 = r37
            r5 = r39
            r13 = r30
            r30 = r11
            r11 = r41
            goto L_0x09c9
        L_0x04af:
            r3 = r37
            r5 = r39
            r7 = r41
            r12 = r21
            r13 = r30
            r2 = 2
            if (r9 != r2) goto L_0x04f1
            int r2 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            com.google.android.gms.internal.measurement.t5 r8 = (com.google.android.gms.internal.measurement.C1223t5) r8
            int r2 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r13, r7)
            int r4 = r7.f5608a
            int r4 = r4 + r2
        L_0x04c7:
            if (r2 >= r4) goto L_0x04dd
            int r2 = com.google.android.gms.internal.measurement.C1249w4.c(r3, r2, r7)
            r21 = r15
            long r14 = r7.f5609b
            long r14 = com.google.android.gms.internal.measurement.J4.b(r14)
            r8.f(r14)
            r14 = r36
            r15 = r21
            goto L_0x04c7
        L_0x04dd:
            r21 = r15
            if (r2 != r4) goto L_0x04eb
        L_0x04e1:
            r14 = r36
            r6 = r2
        L_0x04e4:
            r2 = r3
            r30 = r11
            r15 = r12
        L_0x04e8:
            r11 = r7
            goto L_0x09ca
        L_0x04eb:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x04f1:
            r21 = r15
            if (r9 != 0) goto L_0x0522
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            com.google.android.gms.internal.measurement.t5 r8 = (com.google.android.gms.internal.measurement.C1223t5) r8
            int r0 = com.google.android.gms.internal.measurement.C1249w4.c(r3, r13, r7)
            long r14 = r7.f5609b
            long r14 = com.google.android.gms.internal.measurement.J4.b(r14)
            r8.f(r14)
        L_0x0506:
            if (r0 >= r5) goto L_0x051e
            int r2 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r0, r7)
            int r4 = r7.f5608a
            if (r12 != r4) goto L_0x051e
            int r0 = com.google.android.gms.internal.measurement.C1249w4.c(r3, r2, r7)
            long r14 = r7.f5609b
            long r14 = com.google.android.gms.internal.measurement.J4.b(r14)
            r8.f(r14)
            goto L_0x0506
        L_0x051e:
            r14 = r36
            r6 = r0
            goto L_0x04e4
        L_0x0522:
            r14 = r36
            r2 = r3
            r30 = r11
            r15 = r12
        L_0x0528:
            r11 = r7
            goto L_0x09c9
        L_0x052b:
            r3 = r37
            r5 = r39
            r7 = r41
            r12 = r21
            r13 = r30
            r14 = 2
            r21 = r15
            if (r9 != r14) goto L_0x055e
            int r2 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            com.google.android.gms.internal.measurement.f5 r8 = (com.google.android.gms.internal.measurement.C1098f5) r8
            int r2 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r13, r7)
            int r4 = r7.f5608a
            int r4 = r4 + r2
        L_0x0545:
            if (r2 >= r4) goto L_0x0555
            int r2 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r2, r7)
            int r6 = r7.f5608a
            int r6 = com.google.android.gms.internal.measurement.J4.a(r6)
            r8.g(r6)
            goto L_0x0545
        L_0x0555:
            if (r2 != r4) goto L_0x0558
            goto L_0x04e1
        L_0x0558:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x055e:
            if (r9 != 0) goto L_0x0522
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            com.google.android.gms.internal.measurement.f5 r8 = (com.google.android.gms.internal.measurement.C1098f5) r8
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r13, r7)
            int r2 = r7.f5608a
            int r2 = com.google.android.gms.internal.measurement.J4.a(r2)
            r8.g(r2)
        L_0x0571:
            if (r0 >= r5) goto L_0x051e
            int r2 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r0, r7)
            int r4 = r7.f5608a
            if (r12 != r4) goto L_0x051e
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r2, r7)
            int r2 = r7.f5608a
            int r2 = com.google.android.gms.internal.measurement.J4.a(r2)
            r8.g(r2)
            goto L_0x0571
        L_0x0589:
            r3 = r37
            r5 = r39
            r7 = r41
            r12 = r21
            r13 = r30
            r14 = 2
            r21 = r15
            if (r9 != r14) goto L_0x05a0
            int r0 = com.google.android.gms.internal.measurement.C1249w4.m(r3, r13, r8, r7)
            r2 = r12
            r4 = r13
        L_0x059e:
            r6 = r5
            goto L_0x05aa
        L_0x05a0:
            if (r9 != 0) goto L_0x0636
            r6 = r8
            r2 = r12
            r4 = r13
            int r0 = com.google.android.gms.internal.measurement.C1249w4.l(r2, r3, r4, r5, r6, r7)
            goto L_0x059e
        L_0x05aa:
            com.google.android.gms.internal.measurement.h5 r5 = r1.H(r10)
            com.google.android.gms.internal.measurement.b6 r9 = r1.f4978j
            int r12 = com.google.android.gms.internal.measurement.S5.f5173b
            if (r5 == 0) goto L_0x0625
            boolean r12 = b.w.a(r8)
            if (r12 == 0) goto L_0x05fd
            int r12 = r8.size()
            r15 = r18
            r13 = 0
            r14 = 0
        L_0x05c2:
            if (r13 >= r12) goto L_0x05ef
            java.lang.Object r23 = r8.get(r13)
            r24 = r0
            r0 = r23
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r1 = r0.intValue()
            boolean r23 = r5.a(r1)
            if (r23 == 0) goto L_0x05e2
            if (r13 == r14) goto L_0x05dd
            r8.set(r14, r0)
        L_0x05dd:
            int r14 = r14 + 1
            r0 = r36
            goto L_0x05e8
        L_0x05e2:
            r0 = r36
            java.lang.Object r15 = com.google.android.gms.internal.measurement.S5.e(r0, r11, r1, r15, r9)
        L_0x05e8:
            int r13 = r13 + 1
            r1 = r35
            r0 = r24
            goto L_0x05c2
        L_0x05ef:
            r24 = r0
            r0 = r36
            if (r14 == r12) goto L_0x0629
            java.util.List r1 = r8.subList(r14, r12)
            r1.clear()
            goto L_0x0629
        L_0x05fd:
            r24 = r0
            r0 = r36
            java.util.Iterator r1 = r8.iterator()
            r8 = r18
        L_0x0607:
            boolean r12 = r1.hasNext()
            if (r12 == 0) goto L_0x0629
            java.lang.Object r12 = r1.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            boolean r13 = r5.a(r12)
            if (r13 != 0) goto L_0x0607
            java.lang.Object r8 = com.google.android.gms.internal.measurement.S5.e(r0, r11, r12, r8, r9)
            r1.remove()
            goto L_0x0607
        L_0x0625:
            r24 = r0
            r0 = r36
        L_0x0629:
            r1 = r35
            r14 = r0
            r15 = r2
            r2 = r3
            r13 = r4
            r5 = r6
            r30 = r11
            r6 = r24
            goto L_0x04e8
        L_0x0636:
            r1 = r35
            goto L_0x0522
        L_0x063a:
            r3 = r37
            r6 = r39
            r7 = r41
            r2 = r21
            r4 = r30
            r12 = 2
            r21 = r15
            if (r9 != r12) goto L_0x06af
            int r1 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r4, r7)
            int r9 = r7.f5608a
            if (r9 < 0) goto L_0x06a9
            int r12 = r3.length
            int r12 = r12 - r1
            if (r9 > r12) goto L_0x06a3
            if (r9 != 0) goto L_0x065d
            com.google.android.gms.internal.measurement.H4 r9 = com.google.android.gms.internal.measurement.H4.f4958b
            r8.add(r9)
            goto L_0x0665
        L_0x065d:
            com.google.android.gms.internal.measurement.H4 r12 = com.google.android.gms.internal.measurement.H4.k(r3, r1, r9)
            r8.add(r12)
        L_0x0664:
            int r1 = r1 + r9
        L_0x0665:
            if (r1 >= r6) goto L_0x0697
            int r9 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r1, r7)
            int r12 = r7.f5608a
            if (r2 != r12) goto L_0x0697
            int r1 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r9, r7)
            int r9 = r7.f5608a
            if (r9 < 0) goto L_0x0691
            int r12 = r3.length
            int r12 = r12 - r1
            if (r9 > r12) goto L_0x068b
            if (r9 != 0) goto L_0x0683
            com.google.android.gms.internal.measurement.H4 r9 = com.google.android.gms.internal.measurement.H4.f4958b
            r8.add(r9)
            goto L_0x0665
        L_0x0683:
            com.google.android.gms.internal.measurement.H4 r12 = com.google.android.gms.internal.measurement.H4.k(r3, r1, r9)
            r8.add(r12)
            goto L_0x0664
        L_0x068b:
            com.google.android.gms.internal.measurement.n5 r1 = new com.google.android.gms.internal.measurement.n5
            r1.<init>(r0)
            throw r1
        L_0x0691:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x0697:
            r15 = r2
            r2 = r3
            r13 = r4
            r5 = r6
            r30 = r11
            r6 = r1
            r11 = r7
            r1 = r35
            goto L_0x09ca
        L_0x06a3:
            com.google.android.gms.internal.measurement.n5 r1 = new com.google.android.gms.internal.measurement.n5
            r1.<init>(r0)
            throw r1
        L_0x06a9:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x06af:
            r1 = r35
            r15 = r2
            r2 = r3
            r13 = r4
            r5 = r6
            r30 = r11
            goto L_0x0528
        L_0x06b9:
            r3 = r37
            r6 = r39
            r7 = r41
            r2 = r21
            r4 = r30
            r12 = 2
            r21 = r15
            if (r9 != r12) goto L_0x06af
            r1 = r35
            r3 = r2
            com.google.android.gms.internal.measurement.Q5 r2 = r1.F(r10)
            r5 = r8
            r8 = r7
            r7 = r5
            r5 = r4
            r4 = r37
            int r0 = com.google.android.gms.internal.measurement.C1249w4.n(r2, r3, r4, r5, r6, r7, r8)
            r15 = r3
            r2 = r4
            r13 = r5
            r5 = r6
            r30 = r11
            r6 = r0
            r11 = r8
            goto L_0x09ca
        L_0x06e3:
            r4 = r37
            r7 = r41
            r2 = r21
            r13 = r30
            r12 = 2
            r21 = r15
            r15 = r8
            r8 = r39
            if (r9 != r12) goto L_0x07c0
            r25 = 536870912(0x20000000, double:2.652494739E-315)
            long r25 = r31 & r25
            int r0 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r0 != 0) goto L_0x074c
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r13, r7)
            int r3 = r7.f5608a
            if (r3 < 0) goto L_0x0746
            if (r3 != 0) goto L_0x070a
            r15.add(r6)
            goto L_0x0715
        L_0x070a:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r9.<init>(r4, r0, r3, r12)
            r15.add(r9)
        L_0x0714:
            int r0 = r0 + r3
        L_0x0715:
            if (r0 >= r8) goto L_0x073e
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r0, r7)
            int r9 = r7.f5608a
            if (r2 != r9) goto L_0x073e
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r3, r7)
            int r3 = r7.f5608a
            if (r3 < 0) goto L_0x0738
            if (r3 != 0) goto L_0x072d
            r15.add(r6)
            goto L_0x0715
        L_0x072d:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r9.<init>(r4, r0, r3, r12)
            r15.add(r9)
            goto L_0x0714
        L_0x0738:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x073e:
            r6 = r0
            r15 = r2
            r2 = r4
            r5 = r8
            r30 = r11
            goto L_0x04e8
        L_0x0746:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x074c:
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r13, r7)
            int r9 = r7.f5608a
            if (r9 < 0) goto L_0x07ba
            if (r9 != 0) goto L_0x075c
            r15.add(r6)
            r30 = r11
            goto L_0x0774
        L_0x075c:
            int r12 = r0 + r9
            boolean r23 = com.google.android.gms.internal.measurement.C1153l6.a(r4, r0, r12)
            if (r23 == 0) goto L_0x07b4
            r23 = r12
            java.lang.String r12 = new java.lang.String
            r30 = r11
            java.nio.charset.Charset r11 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r12.<init>(r4, r0, r9, r11)
            r15.add(r12)
        L_0x0772:
            r0 = r23
        L_0x0774:
            if (r0 >= r8) goto L_0x07ad
            int r9 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r0, r7)
            int r11 = r7.f5608a
            if (r2 != r11) goto L_0x07ad
            int r0 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r9, r7)
            int r9 = r7.f5608a
            if (r9 < 0) goto L_0x07a7
            if (r9 != 0) goto L_0x078c
            r15.add(r6)
            goto L_0x0774
        L_0x078c:
            int r11 = r0 + r9
            boolean r12 = com.google.android.gms.internal.measurement.C1153l6.a(r4, r0, r11)
            if (r12 == 0) goto L_0x07a1
            java.lang.String r12 = new java.lang.String
            r23 = r11
            java.nio.charset.Charset r11 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r12.<init>(r4, r0, r9, r11)
            r15.add(r12)
            goto L_0x0772
        L_0x07a1:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r3)
            throw r0
        L_0x07a7:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x07ad:
            r6 = r0
            r15 = r2
        L_0x07af:
            r2 = r4
        L_0x07b0:
            r11 = r7
            r5 = r8
            goto L_0x09ca
        L_0x07b4:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r3)
            throw r0
        L_0x07ba:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r5)
            throw r0
        L_0x07c0:
            r30 = r11
        L_0x07c2:
            r15 = r2
            r2 = r4
            r11 = r7
            r5 = r8
            goto L_0x09c9
        L_0x07c8:
            r4 = r37
            r7 = r41
            r2 = r21
            r13 = r30
            r12 = 2
            r30 = r11
            r21 = r15
            r15 = r8
            r8 = r39
            if (r9 != r12) goto L_0x07f7
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r15)
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r13, r7)
            int r5 = r7.f5608a
            int r5 = r5 + r3
            if (r3 < r5) goto L_0x07f3
            if (r3 != r5) goto L_0x07ed
            r15 = r2
            r6 = r3
            goto L_0x07af
        L_0x07ed:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x07f3:
            com.google.android.gms.internal.measurement.C1249w4.c(r4, r3, r7)
            throw r18
        L_0x07f7:
            if (r9 == 0) goto L_0x07fa
            goto L_0x07c2
        L_0x07fa:
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r15)
            com.google.android.gms.internal.measurement.C1249w4.c(r4, r13, r7)
            long r2 = r7.f5609b
            throw r18
        L_0x0805:
            r4 = r37
            r7 = r41
            r2 = r21
            r13 = r30
            r12 = 2
            r30 = r11
            r21 = r15
            r15 = r8
            r8 = r39
            if (r9 != r12) goto L_0x0850
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r3 = r15
            com.google.android.gms.internal.measurement.f5 r3 = (com.google.android.gms.internal.measurement.C1098f5) r3
            int r5 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r13, r7)
            int r6 = r7.f5608a
            int r9 = r5 + r6
            int r11 = r4.length
            if (r9 > r11) goto L_0x084a
            int r11 = r3.size()
            int r6 = r6 / 4
            int r11 = r11 + r6
            r3.i(r11)
        L_0x0831:
            if (r5 >= r9) goto L_0x083d
            int r6 = com.google.android.gms.internal.measurement.C1249w4.d(r4, r5)
            r3.g(r6)
            int r5 = r5 + 4
            goto L_0x0831
        L_0x083d:
            if (r5 != r9) goto L_0x0844
        L_0x083f:
            r15 = r2
            r2 = r4
            r6 = r5
            goto L_0x07b0
        L_0x0844:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x084a:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x0850:
            r3 = 5
            if (r9 != r3) goto L_0x07c2
            int r0 = r13 + 4
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r3 = r15
            com.google.android.gms.internal.measurement.f5 r3 = (com.google.android.gms.internal.measurement.C1098f5) r3
            int r5 = com.google.android.gms.internal.measurement.C1249w4.d(r4, r13)
            r3.g(r5)
        L_0x0861:
            if (r0 >= r8) goto L_0x07ad
            int r5 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r0, r7)
            int r6 = r7.f5608a
            if (r2 != r6) goto L_0x07ad
            int r0 = com.google.android.gms.internal.measurement.C1249w4.d(r4, r5)
            r3.g(r0)
            int r0 = r5 + 4
            goto L_0x0861
        L_0x0875:
            r4 = r37
            r7 = r41
            r2 = r21
            r13 = r30
            r12 = 2
            r30 = r11
            r21 = r15
            r15 = r8
            r8 = r39
            if (r9 != r12) goto L_0x08bc
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r3 = r15
            com.google.android.gms.internal.measurement.t5 r3 = (com.google.android.gms.internal.measurement.C1223t5) r3
            int r5 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r13, r7)
            int r6 = r7.f5608a
            int r9 = r5 + r6
            int r11 = r4.length
            if (r9 > r11) goto L_0x08b6
            int r11 = r3.size()
            int r6 = r6 / 8
            int r11 = r11 + r6
            r3.g(r11)
        L_0x08a1:
            if (r5 >= r9) goto L_0x08ad
            long r11 = com.google.android.gms.internal.measurement.C1249w4.e(r4, r5)
            r3.f(r11)
            int r5 = r5 + 8
            goto L_0x08a1
        L_0x08ad:
            if (r5 != r9) goto L_0x08b0
            goto L_0x083f
        L_0x08b0:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x08b6:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x08bc:
            r3 = 1
            if (r9 != r3) goto L_0x07c2
            int r0 = r13 + 8
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r3 = r15
            com.google.android.gms.internal.measurement.t5 r3 = (com.google.android.gms.internal.measurement.C1223t5) r3
            long r5 = com.google.android.gms.internal.measurement.C1249w4.e(r4, r13)
            r3.f(r5)
        L_0x08cd:
            if (r0 >= r8) goto L_0x07ad
            int r5 = com.google.android.gms.internal.measurement.C1249w4.a(r4, r0, r7)
            int r6 = r7.f5608a
            if (r2 != r6) goto L_0x07ad
            long r11 = com.google.android.gms.internal.measurement.C1249w4.e(r4, r5)
            r3.f(r11)
            int r0 = r5 + 8
            goto L_0x08cd
        L_0x08e1:
            r4 = r37
            r7 = r41
            r2 = r21
            r13 = r30
            r12 = 2
            r30 = r11
            r21 = r15
            r15 = r8
            r8 = r39
            if (r9 != r12) goto L_0x08f9
            int r0 = com.google.android.gms.internal.measurement.C1249w4.m(r4, r13, r15, r7)
            goto L_0x07ad
        L_0x08f9:
            if (r9 != 0) goto L_0x07c2
            r3 = r4
            r5 = r8
            r4 = r13
            r6 = r15
            int r0 = com.google.android.gms.internal.measurement.C1249w4.l(r2, r3, r4, r5, r6, r7)
            r15 = r2
            r2 = r3
            r11 = r7
        L_0x0906:
            r6 = r0
            goto L_0x09ca
        L_0x0909:
            r2 = r21
            r21 = r15
            r15 = r2
            r2 = r37
            r5 = r39
            r6 = r8
            r13 = r30
            r12 = 2
            r30 = r11
            r11 = r41
            if (r9 != r12) goto L_0x093f
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r8 = r6
            com.google.android.gms.internal.measurement.t5 r8 = (com.google.android.gms.internal.measurement.C1223t5) r8
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r11)
            int r4 = r11.f5608a
            int r4 = r4 + r3
        L_0x0928:
            if (r3 >= r4) goto L_0x0934
            int r3 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r3, r11)
            long r6 = r11.f5609b
            r8.f(r6)
            goto L_0x0928
        L_0x0934:
            if (r3 != r4) goto L_0x0939
            r6 = r3
            goto L_0x09ca
        L_0x0939:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x093f:
            if (r9 != 0) goto L_0x09c9
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r8 = r6
            com.google.android.gms.internal.measurement.t5 r8 = (com.google.android.gms.internal.measurement.C1223t5) r8
            int r0 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r13, r11)
            long r3 = r11.f5609b
            r8.f(r3)
        L_0x094f:
            if (r0 >= r5) goto L_0x0906
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r0, r11)
            int r4 = r11.f5608a
            if (r15 != r4) goto L_0x0906
            int r0 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r3, r11)
            long r3 = r11.f5609b
            r8.f(r3)
            goto L_0x094f
        L_0x0963:
            r2 = r21
            r21 = r15
            r15 = r2
            r2 = r37
            r5 = r39
            r6 = r8
            r13 = r30
            r12 = 2
            r30 = r11
            r11 = r41
            if (r9 != r12) goto L_0x098c
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r6)
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r11)
            int r4 = r11.f5608a
            int r3 = r3 + r4
            int r2 = r2.length
            if (r3 <= r2) goto L_0x098b
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x098b:
            throw r18
        L_0x098c:
            r3 = 5
            if (r9 == r3) goto L_0x0990
            goto L_0x09c9
        L_0x0990:
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r6)
            int r0 = com.google.android.gms.internal.measurement.C1249w4.d(r2, r13)
            java.lang.Float.intBitsToFloat(r0)
            throw r18
        L_0x099d:
            r2 = r21
            r21 = r15
            r15 = r2
            r2 = r37
            r5 = r39
            r6 = r8
            r13 = r30
            r12 = 2
            r30 = r11
            r11 = r41
            if (r9 != r12) goto L_0x09c6
            int r3 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r6)
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r11)
            int r4 = r11.f5608a
            int r3 = r3 + r4
            int r2 = r2.length
            if (r3 <= r2) goto L_0x09c5
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x09c5:
            throw r18
        L_0x09c6:
            r3 = 1
            if (r9 == r3) goto L_0x09e6
        L_0x09c9:
            r6 = r13
        L_0x09ca:
            if (r6 == r13) goto L_0x09da
            r4 = r2
            r9 = r10
            r7 = r11
            r3 = r14
            r10 = r19
            r2 = r21
            r14 = r22
            r8 = r30
            goto L_0x012f
        L_0x09da:
            r1 = r40
            r3 = r2
            r4 = r6
            r9 = r10
            r10 = r11
            r0 = r21
        L_0x09e2:
            r11 = r30
            goto L_0x0dad
        L_0x09e6:
            int r0 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            android.support.v4.media.a.a(r6)
            long r2 = com.google.android.gms.internal.measurement.C1249w4.e(r2, r13)
            java.lang.Double.longBitsToDouble(r2)
            throw r18
        L_0x09f3:
            r2 = r21
            r21 = r15
            r15 = r2
            r2 = r37
            r27 = r13
            r13 = r30
            r30 = r11
            r11 = r41
            r5 = 50
            if (r4 != r5) goto L_0x0b15
            r5 = 2
            if (r9 != r5) goto L_0x0b01
            java.lang.Object r3 = r1.G(r10)
            r9 = r21
            java.lang.Object r4 = r9.getObject(r14, r7)
            r5 = r4
            com.google.android.gms.internal.measurement.z5 r5 = (com.google.android.gms.internal.measurement.C1275z5) r5
            boolean r5 = r5.f()
            if (r5 != 0) goto L_0x0a2b
            com.google.android.gms.internal.measurement.z5 r5 = com.google.android.gms.internal.measurement.C1275z5.a()
            com.google.android.gms.internal.measurement.z5 r5 = r5.c()
            com.google.android.gms.internal.measurement.A5.a(r5, r4)
            r9.putObject(r14, r7, r5)
            r4 = r5
        L_0x0a2b:
            com.google.android.gms.internal.measurement.y5 r3 = (com.google.android.gms.internal.measurement.C1267y5) r3
            com.google.android.gms.internal.measurement.x5 r8 = r3.e()
            r12 = r4
            com.google.android.gms.internal.measurement.z5 r12 = (com.google.android.gms.internal.measurement.C1275z5) r12
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r11)
            int r4 = r11.f5608a
            if (r4 < 0) goto L_0x0afb
            int r5 = r39 - r3
            if (r4 > r5) goto L_0x0afb
            int r0 = r3 + r4
            java.lang.Object r4 = r8.f5624b
            java.lang.Object r5 = r8.f5626d
            r6 = r5
        L_0x0a47:
            if (r3 >= r0) goto L_0x0acb
            int r7 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0a55
            int r7 = com.google.android.gms.internal.measurement.C1249w4.b(r3, r2, r7, r11)
            int r3 = r11.f5608a
        L_0x0a55:
            int r2 = r3 >>> 3
            r21 = r4
            r4 = r3 & 7
            r23 = r5
            r5 = 1
            if (r2 == r5) goto L_0x0a96
            r5 = 2
            if (r2 == r5) goto L_0x0a6c
            r2 = r37
            r5 = r39
            r4 = r11
            r11 = r21
            goto L_0x0ac3
        L_0x0a6c:
            com.google.android.gms.internal.measurement.m6 r5 = r8.f5625c
            int r2 = r5.b()
            if (r4 != r2) goto L_0x0a8b
            java.lang.Class r6 = r23.getClass()
            r2 = r37
            r4 = r39
            r3 = r7
            r7 = r11
            r11 = r21
            int r3 = w(r2, r3, r4, r5, r6, r7)
            java.lang.Object r6 = r7.f5610c
            r4 = r11
            r5 = r23
            r11 = r7
            goto L_0x0a47
        L_0x0a8b:
            r2 = r7
            r7 = r11
            r11 = r21
            r5 = r39
            r4 = r7
            r7 = r2
            r2 = r37
            goto L_0x0ac3
        L_0x0a96:
            r2 = r7
            r7 = r11
            r11 = r21
            com.google.android.gms.internal.measurement.m6 r5 = r8.f5623a
            r21 = r2
            int r2 = r5.b()
            if (r4 != r2) goto L_0x0abc
            r2 = r6
            r6 = 0
            r4 = r39
            r11 = r2
            r3 = r21
            r2 = r37
            int r3 = w(r2, r3, r4, r5, r6, r7)
            r5 = r4
            r4 = r7
            java.lang.Object r6 = r4.f5610c
            r5 = r11
            r11 = r4
            r4 = r6
            r6 = r5
        L_0x0ab9:
            r5 = r23
            goto L_0x0a47
        L_0x0abc:
            r2 = r37
            r5 = r39
            r4 = r7
            r7 = r21
        L_0x0ac3:
            int r3 = com.google.android.gms.internal.measurement.C1249w4.p(r3, r2, r7, r5, r4)
            r5 = r11
            r11 = r4
            r4 = r5
            goto L_0x0ab9
        L_0x0acb:
            r5 = r11
            r11 = r4
            r4 = r5
            r5 = r39
            if (r3 != r0) goto L_0x0af3
            r12.put(r11, r6)
            if (r0 == r13) goto L_0x0ae9
            r6 = r0
            r7 = r4
            r3 = r14
            r14 = r22
            r8 = r30
            r11 = 0
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r2 = r9
            r9 = r10
            r10 = r19
            goto L_0x001c
        L_0x0ae9:
            r1 = r4
            r4 = r0
            r0 = r9
            r9 = r10
            r10 = r1
            r1 = r40
            r3 = r2
            goto L_0x09e2
        L_0x0af3:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r11 = r27
            r0.<init>(r11)
            throw r0
        L_0x0afb:
            com.google.android.gms.internal.measurement.n5 r2 = new com.google.android.gms.internal.measurement.n5
            r2.<init>(r0)
            throw r2
        L_0x0b01:
            r4 = r11
            r9 = r21
            r11 = r27
            goto L_0x042b
        L_0x0b08:
            r1 = r40
            r3 = r2
            r0 = r9
            r9 = r10
            r27 = r11
            r11 = r30
            r10 = r4
            r4 = r13
            goto L_0x0dad
        L_0x0b15:
            r5 = r39
            r0 = r21
            r11 = r27
            int r21 = r10 + 2
            r21 = r28[r21]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r21 & r16
            r21 = r4
            long r4 = (long) r2
            switch(r21) {
                case 51: goto L_0x0d72;
                case 52: goto L_0x0d4e;
                case 53: goto L_0x0d2f;
                case 54: goto L_0x0d2f;
                case 55: goto L_0x0d11;
                case 56: goto L_0x0cf2;
                case 57: goto L_0x0cd1;
                case 58: goto L_0x0ca2;
                case 59: goto L_0x0c5a;
                case 60: goto L_0x0c1e;
                case 61: goto L_0x0bfe;
                case 62: goto L_0x0d11;
                case 63: goto L_0x0bba;
                case 64: goto L_0x0cd1;
                case 65: goto L_0x0cf2;
                case 66: goto L_0x0b93;
                case 67: goto L_0x0b65;
                case 68: goto L_0x0b37;
                default: goto L_0x0b2a;
            }
        L_0x0b2a:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
        L_0x0b33:
            r10 = r41
            goto L_0x0d96
        L_0x0b37:
            r4 = 3
            if (r9 != r4) goto L_0x0b2a
            r2 = r15 & -8
            r7 = r2 | 4
            r12 = r30
            java.lang.Object r2 = r1.K(r14, r12, r10)
            com.google.android.gms.internal.measurement.Q5 r3 = r1.F(r10)
            r4 = r37
            r6 = r39
            r8 = r41
            r5 = r13
            int r3 = com.google.android.gms.internal.measurement.C1249w4.k(r2, r3, r4, r5, r6, r7, r8)
            r6 = r4
            r4 = r2
            r2 = r6
            r6 = r8
            r1.L(r14, r12, r10, r4)
            r31 = r10
            r27 = r11
            r11 = r12
            r12 = r13
            r10 = r6
        L_0x0b61:
            r6 = r3
            r3 = r2
            goto L_0x0d97
        L_0x0b65:
            r2 = r37
            r6 = r41
            r12 = r30
            if (r9 != 0) goto L_0x0b89
            int r3 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r13, r6)
            r31 = r10
            long r9 = r6.f5609b
            long r9 = com.google.android.gms.internal.measurement.J4.b(r9)
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r0.putObject(r14, r7, r9)
            r0.putInt(r14, r4, r12)
        L_0x0b83:
            r10 = r6
            r27 = r11
            r11 = r12
            r12 = r13
            goto L_0x0b61
        L_0x0b89:
            r3 = r2
            r31 = r10
            r27 = r11
            r11 = r12
            r12 = r13
            r10 = r6
            goto L_0x0d96
        L_0x0b93:
            r2 = r37
            r6 = r41
            r31 = r10
            r12 = r30
            if (r9 != 0) goto L_0x0bb2
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r6)
            int r9 = r6.f5608a
            int r9 = com.google.android.gms.internal.measurement.J4.a(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r0.putObject(r14, r7, r9)
            r0.putInt(r14, r4, r12)
            goto L_0x0b83
        L_0x0bb2:
            r3 = r2
            r10 = r6
            r27 = r11
            r11 = r12
            r12 = r13
            goto L_0x0d96
        L_0x0bba:
            r2 = r37
            r6 = r41
            r31 = r10
            r12 = r30
            if (r9 != 0) goto L_0x0bb2
            int r3 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r13, r6)
            int r9 = r6.f5608a
            r21 = r3
            r10 = r31
            com.google.android.gms.internal.measurement.h5 r3 = r1.H(r10)
            if (r3 == 0) goto L_0x0be8
            boolean r3 = r3.a(r9)
            if (r3 == 0) goto L_0x0bdb
            goto L_0x0be8
        L_0x0bdb:
            com.google.android.gms.internal.measurement.c6 r3 = y(r14)
            long r4 = (long) r9
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3.j(r15, r4)
            goto L_0x0bf2
        L_0x0be8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r0.putObject(r14, r7, r3)
            r0.putInt(r14, r4, r12)
        L_0x0bf2:
            r3 = r2
            r31 = r10
            r27 = r11
            r11 = r12
            r12 = r13
            r10 = r6
            r6 = r21
            goto L_0x0d97
        L_0x0bfe:
            r2 = r37
            r6 = r41
            r12 = r30
            r3 = 2
            if (r9 != r3) goto L_0x0b89
            int r9 = com.google.android.gms.internal.measurement.C1249w4.g(r2, r13, r6)
            java.lang.Object r3 = r6.f5610c
            r0.putObject(r14, r7, r3)
            r0.putInt(r14, r4, r12)
            r3 = r2
            r31 = r10
            r27 = r11
            r11 = r12
            r12 = r13
            r10 = r6
        L_0x0c1b:
            r6 = r9
            goto L_0x0d97
        L_0x0c1e:
            r2 = r37
            r6 = r41
            r12 = r30
            r3 = 2
            if (r9 != r3) goto L_0x0c51
            java.lang.Object r2 = r1.K(r14, r12, r10)
            r20 = r3
            com.google.android.gms.internal.measurement.Q5 r3 = r1.F(r10)
            r4 = r37
            r7 = r6
            r5 = r13
            r13 = r20
            r6 = r39
            int r3 = com.google.android.gms.internal.measurement.C1249w4.j(r2, r3, r4, r5, r6, r7)
            r33 = r4
            r4 = r2
            r2 = r33
            r1.L(r14, r12, r10, r4)
            r6 = r3
            r31 = r10
            r27 = r11
            r11 = r12
            r10 = r41
            r3 = r2
            r12 = r5
            goto L_0x0d97
        L_0x0c51:
            r3 = r2
            r31 = r10
            r27 = r11
            r11 = r12
            r12 = r13
            goto L_0x0b33
        L_0x0c5a:
            r2 = r37
            r31 = r10
            r27 = r11
            r21 = r12
            r12 = r13
            r11 = r30
            r13 = 2
            r10 = r41
            if (r9 != r13) goto L_0x0c9f
            int r9 = com.google.android.gms.internal.measurement.C1249w4.a(r2, r12, r10)
            int r13 = r10.f5608a
            if (r13 != 0) goto L_0x0c76
            r0.putObject(r14, r7, r6)
            goto L_0x0c99
        L_0x0c76:
            r6 = r21 & r25
            r21 = r6
            int r6 = r9 + r13
            if (r21 == 0) goto L_0x0c8b
            boolean r21 = com.google.android.gms.internal.measurement.C1153l6.a(r2, r9, r6)
            if (r21 == 0) goto L_0x0c85
            goto L_0x0c8b
        L_0x0c85:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r3)
            throw r0
        L_0x0c8b:
            java.lang.String r3 = new java.lang.String
            r21 = r6
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.C1152l5.f5433a
            r3.<init>(r2, r9, r13, r6)
            r0.putObject(r14, r7, r3)
            r9 = r21
        L_0x0c99:
            r0.putInt(r14, r4, r11)
            r3 = r2
            goto L_0x0c1b
        L_0x0c9f:
            r3 = r2
            goto L_0x0d96
        L_0x0ca2:
            r2 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r10 = r41
            if (r9 != 0) goto L_0x0ccd
            int r3 = com.google.android.gms.internal.measurement.C1249w4.c(r2, r12, r10)
            long r1 = r10.f5609b
            int r1 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x0cbc
            r29 = 1
            goto L_0x0cbe
        L_0x0cbc:
            r29 = 0
        L_0x0cbe:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r29)
            r0.putObject(r14, r7, r1)
            r0.putInt(r14, r4, r11)
            r6 = r3
            r3 = r37
            goto L_0x0d97
        L_0x0ccd:
            r3 = r37
            goto L_0x0d96
        L_0x0cd1:
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r3 = 5
            r10 = r41
            if (r9 != r3) goto L_0x0ccd
            int r1 = r12 + 4
            r3 = r37
            int r2 = com.google.android.gms.internal.measurement.C1249w4.d(r3, r12)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.putObject(r14, r7, r2)
            r0.putInt(r14, r4, r11)
        L_0x0cef:
            r6 = r1
            goto L_0x0d97
        L_0x0cf2:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r6 = 1
            r10 = r41
            if (r9 != r6) goto L_0x0d96
            int r1 = r12 + 8
            long r23 = com.google.android.gms.internal.measurement.C1249w4.e(r3, r12)
            java.lang.Long r2 = java.lang.Long.valueOf(r23)
            r0.putObject(r14, r7, r2)
            r0.putInt(r14, r4, r11)
            goto L_0x0cef
        L_0x0d11:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r10 = r41
            if (r9 != 0) goto L_0x0d96
            int r1 = com.google.android.gms.internal.measurement.C1249w4.a(r3, r12, r10)
            int r2 = r10.f5608a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.putObject(r14, r7, r2)
            r0.putInt(r14, r4, r11)
            goto L_0x0cef
        L_0x0d2f:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r10 = r41
            if (r9 != 0) goto L_0x0d96
            int r1 = com.google.android.gms.internal.measurement.C1249w4.c(r3, r12, r10)
            r6 = r1
            long r1 = r10.f5609b
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.putObject(r14, r7, r1)
            r0.putInt(r14, r4, r11)
            goto L_0x0d97
        L_0x0d4e:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r6 = 5
            r10 = r41
            if (r9 != r6) goto L_0x0d96
            int r1 = r12 + 4
            int r2 = com.google.android.gms.internal.measurement.C1249w4.d(r3, r12)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r0.putObject(r14, r7, r2)
            r0.putInt(r14, r4, r11)
            goto L_0x0cef
        L_0x0d72:
            r3 = r37
            r31 = r10
            r27 = r11
            r12 = r13
            r11 = r30
            r6 = 1
            r10 = r41
            if (r9 != r6) goto L_0x0d96
            int r1 = r12 + 8
            long r23 = com.google.android.gms.internal.measurement.C1249w4.e(r3, r12)
            double r23 = java.lang.Double.longBitsToDouble(r23)
            java.lang.Double r2 = java.lang.Double.valueOf(r23)
            r0.putObject(r14, r7, r2)
            r0.putInt(r14, r4, r11)
            goto L_0x0cef
        L_0x0d96:
            r6 = r12
        L_0x0d97:
            if (r6 == r12) goto L_0x0da8
            r1 = r35
            r5 = r39
            r2 = r0
            r4 = r3
            r7 = r10
            r8 = r11
            r3 = r14
            r10 = r19
            r14 = r22
            goto L_0x0302
        L_0x0da8:
            r1 = r40
            r4 = r6
            goto L_0x03b7
        L_0x0dad:
            if (r15 != r1) goto L_0x0dc0
            if (r1 == 0) goto L_0x0dc0
            r8 = r35
            r5 = r39
            r2 = r0
            r6 = r4
            r10 = r19
        L_0x0db9:
            r0 = r22
            r7 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0e13
        L_0x0dc0:
            r8 = r35
            boolean r2 = r8.f4974f
            if (r2 == 0) goto L_0x0de5
            com.google.android.gms.internal.measurement.R4 r2 = r10.f5611d
            com.google.android.gms.internal.measurement.R4 r5 = com.google.android.gms.internal.measurement.R4.f5163c
            int r5 = com.google.android.gms.internal.measurement.N5.f5036d
            com.google.android.gms.internal.measurement.R4 r5 = com.google.android.gms.internal.measurement.R4.f5163c
            if (r2 == r5) goto L_0x0de5
            com.google.android.gms.internal.measurement.F5 r5 = r8.f4973e
            int r6 = com.google.android.gms.internal.measurement.C1249w4.f5616b
            r2.b(r5, r11)
            com.google.android.gms.internal.measurement.c6 r6 = y(r14)
            r5 = r39
            r7 = r10
            r2 = r15
            int r4 = com.google.android.gms.internal.measurement.C1249w4.o(r2, r3, r4, r5, r6, r7)
        L_0x0de3:
            r6 = r4
            goto L_0x0df5
        L_0x0de5:
            r2 = r15
            com.google.android.gms.internal.measurement.c6 r6 = y(r14)
            r3 = r37
            r5 = r39
            r7 = r41
            int r4 = com.google.android.gms.internal.measurement.C1249w4.o(r2, r3, r4, r5, r6, r7)
            goto L_0x0de3
        L_0x0df5:
            r4 = r37
            r7 = r41
            r15 = r2
            r1 = r8
            r8 = r11
            r3 = r14
            r10 = r19
            r14 = r22
            r11 = 0
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r0
            goto L_0x001c
        L_0x0e08:
            r8 = r1
            r19 = r10
            r27 = r13
            r22 = r14
            r1 = r40
            r14 = r3
            goto L_0x0db9
        L_0x0e13:
            if (r10 == r7) goto L_0x0e19
            long r3 = (long) r10
            r2.putInt(r14, r3, r0)
        L_0x0e19:
            int r0 = r8.f4976h
            r2 = r18
        L_0x0e1d:
            int r3 = r8.f4977i
            if (r0 >= r3) goto L_0x0ecd
            int[] r3 = r8.f4975g
            com.google.android.gms.internal.measurement.b6 r4 = r8.f4978j
            int[] r7 = r8.f4969a
            r3 = r3[r0]
            r7 = r7[r3]
            int r9 = r8.N(r3)
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r16
            long r9 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.C1126i6.s(r14, r9)
            if (r9 == 0) goto L_0x0ec1
            com.google.android.gms.internal.measurement.h5 r10 = r8.H(r3)
            if (r10 == 0) goto L_0x0ec1
            com.google.android.gms.internal.measurement.z5 r9 = (com.google.android.gms.internal.measurement.C1275z5) r9
            java.lang.Object r3 = r8.G(r3)
            com.google.android.gms.internal.measurement.y5 r3 = (com.google.android.gms.internal.measurement.C1267y5) r3
            com.google.android.gms.internal.measurement.x5 r3 = r3.e()
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x0e55:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0ec1
            java.lang.Object r11 = r9.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r12 = r11.getValue()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            boolean r12 = r10.a(r12)
            if (r12 != 0) goto L_0x0ebe
            if (r2 != 0) goto L_0x0e77
            java.lang.Object r2 = r4.a(r14)
        L_0x0e77:
            java.lang.Object r12 = r11.getKey()
            java.lang.Object r13 = r11.getValue()
            int r12 = com.google.android.gms.internal.measurement.C1267y5.c(r3, r12, r13)
            com.google.android.gms.internal.measurement.H4 r13 = com.google.android.gms.internal.measurement.H4.f4958b
            byte[] r13 = new byte[r12]
            int r17 = com.google.android.gms.internal.measurement.M4.f5024d
            r17 = r0
            com.google.android.gms.internal.measurement.K4 r0 = new com.google.android.gms.internal.measurement.K4
            r18 = r4
            r4 = 0
            r0.<init>(r13, r4, r12)
            java.lang.Object r12 = r11.getKey()     // Catch:{ IOException -> 0x0eb7 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ IOException -> 0x0eb7 }
            com.google.android.gms.internal.measurement.C1267y5.b(r0, r3, r12, r11)     // Catch:{ IOException -> 0x0eb7 }
            com.google.android.gms.internal.measurement.H4 r0 = com.google.android.gms.internal.measurement.E4.a(r0, r13)
            r11 = 3
            int r12 = r7 << 3
            r13 = r2
            com.google.android.gms.internal.measurement.c6 r13 = (com.google.android.gms.internal.measurement.C1072c6) r13
            r20 = 2
            r12 = r12 | 2
            r13.j(r12, r0)
            r9.remove()
            r0 = r17
            r4 = r18
            goto L_0x0e55
        L_0x0eb7:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x0ebe:
            r20 = 2
            goto L_0x0e55
        L_0x0ec1:
            r17 = r0
            r4 = 0
            r11 = 3
            r20 = 2
            com.google.android.gms.internal.measurement.c6 r2 = (com.google.android.gms.internal.measurement.C1072c6) r2
            int r0 = r17 + 1
            goto L_0x0e1d
        L_0x0ecd:
            if (r2 == 0) goto L_0x0ed4
            r0 = r14
            com.google.android.gms.internal.measurement.e5 r0 = (com.google.android.gms.internal.measurement.C1089e5) r0
            r0.zzc = r2
        L_0x0ed4:
            if (r1 != 0) goto L_0x0ee1
            if (r6 != r5) goto L_0x0ed9
            goto L_0x0ee7
        L_0x0ed9:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r11 = r27
            r0.<init>(r11)
            throw r0
        L_0x0ee1:
            r11 = r27
            if (r6 > r5) goto L_0x0ee8
            if (r15 != r1) goto L_0x0ee8
        L_0x0ee7:
            return r6
        L_0x0ee8:
            com.google.android.gms.internal.measurement.n5 r0 = new com.google.android.gms.internal.measurement.n5
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.I5.z(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.v4):int");
    }
}
