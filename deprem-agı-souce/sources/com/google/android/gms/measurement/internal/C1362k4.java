package com.google.android.gms.measurement.internal;

import android.net.Uri;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.k4  reason: case insensitive filesystem */
final class C1362k4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f6517a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f6518b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f6519c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f6520d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ C1369l4 f6521e;

    C1362k4(C1369l4 l4Var, boolean z4, Uri uri, String str, String str2) {
        this.f6517a = z4;
        this.f6518b = uri;
        this.f6519c = str;
        this.f6520d = str2;
        Objects.requireNonNull(l4Var);
        this.f6521e = l4Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095 A[SYNTHETIC, Splitter:B:33:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd A[Catch:{ RuntimeException -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[Catch:{ RuntimeException -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r18 = this;
            r1 = r18
            com.google.android.gms.measurement.internal.l4 r2 = r1.f6521e
            com.google.android.gms.measurement.internal.x4 r0 = r2.f6534a
            r0.h()
            java.lang.String r3 = r1.f6520d
            android.net.Uri r4 = r1.f6518b
            com.google.android.gms.measurement.internal.X2 r5 = r0.f5730a     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.z6 r6 = r5.C()     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r7 = "https://google.com/search?"
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "Activity created with data 'referrer' without required params"
            java.lang.String r11 = "utm_medium"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 == 0) goto L_0x0029
        L_0x0027:
            r6 = 0
            goto L_0x008d
        L_0x0029:
            boolean r8 = r3.contains(r15)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "gbraid"
            boolean r8 = r3.contains(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r3.contains(r13)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r3.contains(r12)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            boolean r8 = r3.contains(r11)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "utm_id"
            boolean r8 = r3.contains(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "dclid"
            boolean r8 = r3.contains(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "srsltid"
            boolean r8 = r3.contains(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "sfmc_id"
            boolean r8 = r3.contains(r8)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.X2 r6 = r6.f5730a     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.o2 r6 = r6.v()     // Catch:{ RuntimeException -> 0x0077 }
            r6.a(r10)     // Catch:{ RuntimeException -> 0x0077 }
            goto L_0x0027
        L_0x0077:
            r0 = move-exception
            goto L_0x015a
        L_0x007a:
            java.lang.String r7 = r7.concat(r3)     // Catch:{ RuntimeException -> 0x0077 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0077 }
            android.os.Bundle r6 = r6.s0(r7)     // Catch:{ RuntimeException -> 0x0077 }
            if (r6 == 0) goto L_0x008d
            java.lang.String r7 = "referrer"
            r6.putString(r9, r7)     // Catch:{ RuntimeException -> 0x0077 }
        L_0x008d:
            java.lang.String r7 = r1.f6519c
            boolean r8 = r1.f6517a
            java.lang.String r14 = "_cmp"
            if (r8 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.z6 r8 = r5.C()     // Catch:{ RuntimeException -> 0x0077 }
            android.os.Bundle r4 = r8.s0(r4)     // Catch:{ RuntimeException -> 0x0077 }
            if (r4 == 0) goto L_0x00d5
            java.lang.String r8 = "intent"
            r4.putString(r9, r8)     // Catch:{ RuntimeException -> 0x0077 }
            boolean r8 = r4.containsKey(r15)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 != 0) goto L_0x00ca
            if (r6 == 0) goto L_0x00ca
            boolean r8 = r6.containsKey(r15)     // Catch:{ RuntimeException -> 0x0077 }
            if (r8 == 0) goto L_0x00ca
            java.lang.String r8 = "_cer"
            java.lang.String r9 = "gclid=%s"
            java.lang.String r16 = r6.getString(r15)     // Catch:{ RuntimeException -> 0x0077 }
            r17 = r5
            r1 = 1
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ RuntimeException -> 0x0077 }
            r1 = 0
            r5[r1] = r16     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r1 = java.lang.String.format(r9, r5)     // Catch:{ RuntimeException -> 0x0077 }
            r4.putString(r8, r1)     // Catch:{ RuntimeException -> 0x0077 }
            goto L_0x00cc
        L_0x00ca:
            r17 = r5
        L_0x00cc:
            r0.t(r7, r14, r4)     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.H6 r1 = r0.f6883r     // Catch:{ RuntimeException -> 0x0077 }
            r1.b(r7, r4)     // Catch:{ RuntimeException -> 0x0077 }
            goto L_0x00d7
        L_0x00d5:
            r17 = r5
        L_0x00d7:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 == 0) goto L_0x00de
            goto L_0x014d
        L_0x00de:
            com.google.android.gms.measurement.internal.q2 r1 = r17.a()     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.v()     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r4 = "Activity created with referrer"
            r1.b(r4, r3)     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.m r1 = r17.w()     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6275H0     // Catch:{ RuntimeException -> 0x0077 }
            r5 = 0
            boolean r1 = r1.H(r5, r4)     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r4 = "_ldl"
            java.lang.String r5 = "auto"
            if (r1 == 0) goto L_0x011b
            if (r6 == 0) goto L_0x0109
            r0.t(r7, r14, r6)     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.H6 r1 = r0.f6883r     // Catch:{ RuntimeException -> 0x0077 }
            r1.b(r7, r6)     // Catch:{ RuntimeException -> 0x0077 }
        L_0x0106:
            r1 = 1
            r3 = 0
            goto L_0x0117
        L_0x0109:
            com.google.android.gms.measurement.internal.q2 r1 = r17.a()     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.v()     // Catch:{ RuntimeException -> 0x0077 }
            java.lang.String r6 = "Referrer does not contain valid parameters"
            r1.b(r6, r3)     // Catch:{ RuntimeException -> 0x0077 }
            goto L_0x0106
        L_0x0117:
            r0.y(r5, r4, r3, r1)     // Catch:{ RuntimeException -> 0x0077 }
            return
        L_0x011b:
            boolean r1 = r3.contains(r15)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 == 0) goto L_0x014e
            boolean r1 = r3.contains(r13)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r3.contains(r12)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 != 0) goto L_0x0143
            boolean r1 = r3.contains(r11)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 != 0) goto L_0x0143
            java.lang.String r1 = "utm_term"
            boolean r1 = r3.contains(r1)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 != 0) goto L_0x0143
            java.lang.String r1 = "utm_content"
            boolean r1 = r3.contains(r1)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 == 0) goto L_0x014e
        L_0x0143:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ RuntimeException -> 0x0077 }
            if (r1 != 0) goto L_0x014d
            r1 = 1
            r0.y(r5, r4, r3, r1)     // Catch:{ RuntimeException -> 0x0077 }
        L_0x014d:
            return
        L_0x014e:
            com.google.android.gms.measurement.internal.q2 r0 = r17.a()     // Catch:{ RuntimeException -> 0x0077 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.v()     // Catch:{ RuntimeException -> 0x0077 }
            r0.a(r10)     // Catch:{ RuntimeException -> 0x0077 }
            return
        L_0x015a:
            com.google.android.gms.measurement.internal.x4 r1 = r2.f6534a
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r1 = r1.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1362k4.run():void");
    }
}
