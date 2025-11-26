package com.google.android.gms.measurement.internal;

import N.C0722p;
import T.e;
import android.app.BroadcastOptions;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.C1048a0;
import com.google.android.gms.internal.measurement.C1102g0;
import com.google.android.gms.internal.measurement.C1104g2;
import com.google.android.gms.internal.measurement.C1141k3;
import com.google.android.gms.internal.measurement.C1145k7;
import com.google.android.gms.internal.measurement.C1170n5;
import com.google.android.gms.internal.measurement.C1195q3;
import com.google.android.gms.internal.measurement.C1203r3;
import com.google.android.gms.internal.measurement.C1211s2;
import com.google.android.gms.internal.measurement.C1247w2;
import com.google.android.gms.internal.measurement.I6;
import com.google.android.gms.internal.measurement.J0;
import com.google.android.gms.internal.measurement.N2;
import com.google.android.gms.internal.measurement.O2;
import com.google.android.gms.internal.measurement.R2;
import com.google.android.gms.internal.measurement.S2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.Z2;
import com.mbridge.msdk.MBridgeConstans;
import f0.C1642J;
import f0.C1643K;
import f0.N;
import f0.v;
import f0.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class q6 implements C3 {

    /* renamed from: K  reason: collision with root package name */
    private static volatile q6 f6646K;

    /* renamed from: A  reason: collision with root package name */
    private long f6647A;

    /* renamed from: B  reason: collision with root package name */
    private final Map f6648B;

    /* renamed from: C  reason: collision with root package name */
    private final Map f6649C;

    /* renamed from: D  reason: collision with root package name */
    private final Map f6650D;

    /* renamed from: E  reason: collision with root package name */
    private final Map f6651E = new HashMap();

    /* renamed from: F  reason: collision with root package name */
    private E4 f6652F;

    /* renamed from: G  reason: collision with root package name */
    private String f6653G;

    /* renamed from: H  reason: collision with root package name */
    private C1447x f6654H;

    /* renamed from: I  reason: collision with root package name */
    private long f6655I;

    /* renamed from: J  reason: collision with root package name */
    private final y6 f6656J = new l6(this);

    /* renamed from: a  reason: collision with root package name */
    private final P2 f6657a;

    /* renamed from: b  reason: collision with root package name */
    private final C1436v2 f6658b;

    /* renamed from: c  reason: collision with root package name */
    private C1426u f6659c;

    /* renamed from: d  reason: collision with root package name */
    private C1457y2 f6660d;

    /* renamed from: e  reason: collision with root package name */
    private V5 f6661e;

    /* renamed from: f  reason: collision with root package name */
    private C1309e f6662f;

    /* renamed from: g  reason: collision with root package name */
    private final u6 f6663g;

    /* renamed from: h  reason: collision with root package name */
    private C4 f6664h;

    /* renamed from: i  reason: collision with root package name */
    private C1460y5 f6665i;

    /* renamed from: j  reason: collision with root package name */
    private final C1308d6 f6666j;

    /* renamed from: k  reason: collision with root package name */
    private H2 f6667k;

    /* renamed from: l  reason: collision with root package name */
    private final X2 f6668l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicBoolean f6669m = new AtomicBoolean(false);

    /* renamed from: n  reason: collision with root package name */
    private boolean f6670n;

    /* renamed from: o  reason: collision with root package name */
    long f6671o;

    /* renamed from: p  reason: collision with root package name */
    private List f6672p;

    /* renamed from: q  reason: collision with root package name */
    private final Deque f6673q = new LinkedList();

    /* renamed from: r  reason: collision with root package name */
    private int f6674r;

    /* renamed from: s  reason: collision with root package name */
    private int f6675s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6676t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6677u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f6678v;

    /* renamed from: w  reason: collision with root package name */
    private FileLock f6679w;

    /* renamed from: x  reason: collision with root package name */
    private FileChannel f6680x;

    /* renamed from: y  reason: collision with root package name */
    private List f6681y;

    /* renamed from: z  reason: collision with root package name */
    private List f6682z;

    q6(r6 r6Var, X2 x22) {
        C0722p.k(r6Var);
        this.f6668l = X2.O(r6Var.f6698a, (J0) null, (Long) null);
        this.f6647A = -1;
        this.f6666j = new C1308d6(this);
        u6 u6Var = new u6(this);
        u6Var.k();
        this.f6663g = u6Var;
        C1436v2 v2Var = new C1436v2(this);
        v2Var.k();
        this.f6658b = v2Var;
        P2 p22 = new P2(this);
        p22.k();
        this.f6657a = p22;
        this.f6648B = new HashMap();
        this.f6649C = new HashMap();
        this.f6650D = new HashMap();
        b().t(new C1316e6(this, r6Var));
    }

    public static q6 F(Context context) {
        C0722p.k(context);
        C0722p.k(context.getApplicationContext());
        if (f6646K == null) {
            synchronized (q6.class) {
                try {
                    if (f6646K == null) {
                        f6646K = new q6((r6) C0722p.k(new r6(context)), (X2) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6646K;
    }

    static final void G(N2 n22, int i5, String str) {
        List r5 = n22.r();
        int i6 = 0;
        while (i6 < r5.size()) {
            if (!"_err".equals(((S2) r5.get(i6)).G())) {
                i6++;
            } else {
                return;
            }
        }
        R2 R4 = S2.R();
        R4.s("_err");
        R4.y((long) i5);
        R2 R5 = S2.R();
        R5.s("_ev");
        R5.w(str);
        n22.y((S2) R4.o());
        n22.y((S2) R5.o());
    }

    static final void H(N2 n22, String str) {
        List r5 = n22.r();
        for (int i5 = 0; i5 < r5.size(); i5++) {
            if (str.equals(((S2) r5.get(i5)).G())) {
                n22.C(i5);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = f0.w.f15329e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int I(java.lang.String r7, com.google.android.gms.measurement.internal.C1385o r8) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r6.f6657a
            com.google.android.gms.internal.measurement.a2 r1 = r0.R(r7)
            r2 = 1
            if (r1 != 0) goto L_0x0011
            f0.w r7 = f0.w.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.n r0 = com.google.android.gms.measurement.internal.C1378n.FAILSAFE
            r8.c(r7, r0)
            return r2
        L_0x0011:
            com.google.android.gms.measurement.internal.u r1 = r6.F0()
            com.google.android.gms.measurement.internal.w2 r1 = r1.J0(r7)
            r3 = 0
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r1.I()
            com.google.android.gms.measurement.internal.d1 r1 = com.google.android.gms.measurement.internal.C1303d1.c(r1)
            f0.v r1 = r1.a()
            f0.v r4 = f0.v.POLICY
            if (r1 != r4) goto L_0x0041
            f0.w r1 = f0.w.AD_PERSONALIZATION
            f0.v r4 = r0.m(r7, r1)
            f0.v r5 = f0.v.UNINITIALIZED
            if (r4 == r5) goto L_0x0041
            com.google.android.gms.measurement.internal.n r7 = com.google.android.gms.measurement.internal.C1378n.REMOTE_ENFORCED_DEFAULT
            r8.c(r1, r7)
            f0.v r7 = f0.v.GRANTED
            if (r4 != r7) goto L_0x0040
            return r3
        L_0x0040:
            return r2
        L_0x0041:
            f0.w r1 = f0.w.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.n r4 = com.google.android.gms.measurement.internal.C1378n.REMOTE_DEFAULT
            r8.c(r1, r4)
            boolean r7 = r0.P(r7, r1)
            if (r7 == 0) goto L_0x004f
            return r3
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.I(java.lang.String, com.google.android.gms.measurement.internal.o):int");
    }

    private final Map J(O2 o22) {
        HashMap hashMap = new HashMap();
        K0();
        for (Map.Entry entry : u6.t(o22, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final C1447x K() {
        if (this.f6654H == null) {
            this.f6654H = new C1340h6(this, this.f6668l);
        }
        return this.f6654H;
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public final void v0() {
        b().h();
        if (!this.f6673q.isEmpty() && !K().c()) {
            long max = Math.max(0, ((long) ((Integer) C1304d2.f6265C0.b((Object) null)).intValue()) - (f().elapsedRealtime() - this.f6655I));
            a().w().b("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
            K().b(max);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:187:0x056e, code lost:
        if ("_v".equals(r11.D()) != false) goto L_0x0570;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x038c A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03b4 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03bd A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03d5 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03ee A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04b1 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04fc A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x05b1 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x06bb A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0a99 A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0abc A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0b36 A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0b3a A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x0b3f A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0b6e A[Catch:{ all -> 0x0a7b }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0cfa  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0d5c A[Catch:{ SQLiteException -> 0x0dd9, all -> 0x0d20 }] */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x0d7b A[Catch:{ SQLiteException -> 0x0dd9, all -> 0x0d20 }] */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0dac A[Catch:{ SQLiteException -> 0x0dd9, all -> 0x0d20 }] */
    /* JADX WARNING: Removed duplicated region for block: B:501:0x0284 A[EDGE_INSN: B:501:0x0284->B:88:0x0284 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0171 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01eb A[SYNTHETIC, Splitter:B:67:0x01eb] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0228 A[SYNTHETIC, Splitter:B:80:0x0228] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0288 A[ADDED_TO_REGION, Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02bf A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0322 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0326 A[Catch:{ NumberFormatException -> 0x0a14, all -> 0x00f6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean M(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r0 = "_f"
            java.lang.String r2 = "_ai"
            java.lang.String r3 = "purchase"
            java.lang.String r4 = "items"
            r5 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            com.google.android.gms.measurement.internal.u r8 = r1.F0()
            r8.r0()
            com.google.android.gms.measurement.internal.m6 r15 = new com.google.android.gms.measurement.internal.m6     // Catch:{ all -> 0x00f6 }
            r8 = 0
            r15.<init>(r1, r8)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u r9 = r1.F0()     // Catch:{ all -> 0x00f6 }
            long r13 = r1.f6647A     // Catch:{ all -> 0x00f6 }
            r10 = r44
            r11 = r45
            r9.n0(r10, r11, r13, r15)     // Catch:{ all -> 0x00f6 }
            java.util.List r9 = r15.f6557c     // Catch:{ all -> 0x00f6 }
            if (r9 == 0) goto L_0x0034
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x00f6 }
            if (r9 == 0) goto L_0x0038
        L_0x0034:
            r2 = r1
            r4 = 0
            goto L_0x0df6
        L_0x0038:
            com.google.android.gms.internal.measurement.a3 r9 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r9 = r9.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.Z2 r9 = (com.google.android.gms.internal.measurement.Z2) r9     // Catch:{ all -> 0x00f6 }
            r9.S0()     // Catch:{ all -> 0x00f6 }
            r17 = r8
            r18 = r17
            r8 = -1
            r10 = -1
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
        L_0x004e:
            java.util.List r11 = r15.f6557c     // Catch:{ all -> 0x00f6 }
            int r11 = r11.size()     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = "_et"
            java.lang.String r6 = "_fr"
            r46 = r13
            java.lang.String r13 = "_e"
            r21 = r14
            if (r12 >= r11) goto L_0x06dc
            java.util.List r11 = r15.f6557c     // Catch:{ all -> 0x00f6 }
            java.lang.Object r11 = r11.get(r12)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r11 = (com.google.android.gms.internal.measurement.O2) r11     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r11 = r11.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.N2 r11 = (com.google.android.gms.internal.measurement.N2) r11     // Catch:{ all -> 0x00f6 }
            r22 = 1
            com.google.android.gms.measurement.internal.P2 r14 = r1.D0()     // Catch:{ all -> 0x00f6 }
            r23 = r7
            com.google.android.gms.internal.measurement.a3 r7 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.F()     // Catch:{ all -> 0x00f6 }
            r24 = r12
            java.lang.String r12 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r7 = r14.D(r7, r12)     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = "_err"
            if (r7 == 0) goto L_0x0107
            com.google.android.gms.measurement.internal.q2 r5 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.r()     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.a3 r7 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.F()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r7)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.X2 r13 = r1.f6668l     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.j2 r13 = r13.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r14 = r11.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r13 = r13.a(r14)     // Catch:{ all -> 0x00f6 }
            r5.c(r6, r7, r13)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.P2 r5 = r1.D0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            boolean r5 = r5.H(r6)     // Catch:{ all -> 0x00f6 }
            if (r5 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.P2 r5 = r1.D0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            boolean r5 = r5.I(r6)     // Catch:{ all -> 0x00f6 }
            if (r5 == 0) goto L_0x00d0
            goto L_0x00fa
        L_0x00d0:
            java.lang.String r5 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r5 = r12.equals(r5)     // Catch:{ all -> 0x00f6 }
            if (r5 != 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.z6 r25 = r1.N0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.y6 r5 = r1.f6656J     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r27 = r6.F()     // Catch:{ all -> 0x00f6 }
            java.lang.String r29 = "_ev"
            java.lang.String r30 = r11.D()     // Catch:{ all -> 0x00f6 }
            r31 = 0
            r28 = 11
            r26 = r5
            r25.B(r26, r27, r28, r29, r30, r31)     // Catch:{ all -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r0 = move-exception
            r2 = r1
            goto L_0x0e06
        L_0x00fa:
            r13 = r46
            r27 = r3
            r7 = r4
            r14 = r21
            r4 = r24
            r21 = r2
            goto L_0x06cf
        L_0x0107:
            java.lang.String r7 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r14 = r7.equals(r3)     // Catch:{ all -> 0x00f6 }
            r25 = r14
            java.lang.String r14 = "ecommerce_purchase"
            r26 = r4
            java.lang.String r4 = "_iap"
            if (r25 != 0) goto L_0x012b
            boolean r25 = r7.equals(r4)     // Catch:{ all -> 0x00f6 }
            if (r25 != 0) goto L_0x012b
            boolean r7 = r7.equals(r14)     // Catch:{ all -> 0x00f6 }
            if (r7 == 0) goto L_0x0126
            goto L_0x012b
        L_0x0126:
            r25 = r10
            r14 = r21
            goto L_0x0163
        L_0x012b:
            com.google.android.gms.internal.measurement.R2 r7 = com.google.android.gms.internal.measurement.S2.R()     // Catch:{ all -> 0x00f6 }
            r25 = r10
            java.lang.String r10 = "_ct"
            r7.s(r10)     // Catch:{ all -> 0x00f6 }
            if (r21 != 0) goto L_0x0153
            com.google.android.gms.internal.measurement.a3 r10 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r10.F()     // Catch:{ all -> 0x00f6 }
            boolean r21 = r1.V(r10, r3)     // Catch:{ all -> 0x00f6 }
            if (r21 == 0) goto L_0x0153
            boolean r4 = r1.V(r10, r4)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x0153
            boolean r4 = r1.V(r10, r14)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x0153
            java.lang.String r4 = "new"
            goto L_0x0155
        L_0x0153:
            java.lang.String r4 = "returning"
        L_0x0155:
            r7.w(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r4 = r7.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r4 = (com.google.android.gms.internal.measurement.S2) r4     // Catch:{ all -> 0x00f6 }
            r11.y(r4)     // Catch:{ all -> 0x00f6 }
            r14 = r22
        L_0x0163:
            java.lang.String r4 = r11.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = f0.x.a(r2)     // Catch:{ all -> 0x00f6 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x01d5
            r11.E(r2)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.q2 r4 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = "Renaming ad_impression to _ai"
            r4.a(r7)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.q2 r4 = r1.a()     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r4.z()     // Catch:{ all -> 0x00f6 }
            r7 = 5
            boolean r4 = android.util.Log.isLoggable(r4, r7)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x01d5
            r4 = 0
        L_0x0191:
            int r7 = r11.s()     // Catch:{ all -> 0x00f6 }
            if (r4 >= r7) goto L_0x01d5
            java.lang.String r7 = "ad_platform"
            com.google.android.gms.internal.measurement.S2 r10 = r11.t(r4)     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r10.G()     // Catch:{ all -> 0x00f6 }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x00f6 }
            if (r7 == 0) goto L_0x01d2
            com.google.android.gms.internal.measurement.S2 r7 = r11.t(r4)     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.I()     // Catch:{ all -> 0x00f6 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x00f6 }
            if (r7 != 0) goto L_0x01d2
            java.lang.String r7 = "admob"
            com.google.android.gms.internal.measurement.S2 r10 = r11.t(r4)     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r10.I()     // Catch:{ all -> 0x00f6 }
            boolean r7 = r7.equalsIgnoreCase(r10)     // Catch:{ all -> 0x00f6 }
            if (r7 == 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.q2 r7 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r7 = r7.t()     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = "AdMob ad impression logged from app. Potentially duplicative."
            r7.a(r10)     // Catch:{ all -> 0x00f6 }
        L_0x01d2:
            int r4 = r4 + 1
            goto L_0x0191
        L_0x01d5:
            com.google.android.gms.measurement.internal.P2 r4 = r1.D0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r7 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.F()     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r4 = r4.E(r7, r10)     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = "_c"
            if (r4 != 0) goto L_0x0219
            r1.K0()     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r11.D()     // Catch:{ all -> 0x00f6 }
            N.C0722p.e(r10)     // Catch:{ all -> 0x00f6 }
            r21 = r2
            int r2 = r10.hashCode()     // Catch:{ all -> 0x00f6 }
            r27 = r3
            r3 = 95027(0x17333, float:1.33161E-40)
            if (r2 == r3) goto L_0x0203
            goto L_0x0210
        L_0x0203:
            java.lang.String r2 = "_ui"
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x0210
        L_0x020b:
            r2 = 0
            r10 = 0
            r28 = 0
            goto L_0x021e
        L_0x0210:
            r30 = r5
            r5 = r8
            r28 = r9
            r29 = 0
            goto L_0x03ec
        L_0x0219:
            r21 = r2
            r27 = r3
            goto L_0x020b
        L_0x021e:
            int r3 = r11.s()     // Catch:{ all -> 0x00f6 }
            r29 = r4
            java.lang.String r4 = "_r"
            if (r2 >= r3) goto L_0x0284
            com.google.android.gms.internal.measurement.S2 r3 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = r3.G()     // Catch:{ all -> 0x00f6 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x00f6 }
            if (r3 == 0) goto L_0x0253
            com.google.android.gms.internal.measurement.S2 r3 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r3 = r3.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r3 = (com.google.android.gms.internal.measurement.R2) r3     // Catch:{ all -> 0x00f6 }
            r30 = r5
            r4 = 1
            r3.y(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r3 = r3.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3     // Catch:{ all -> 0x00f6 }
            r11.w(r2, r3)     // Catch:{ all -> 0x00f6 }
            r28 = r22
            goto L_0x027d
        L_0x0253:
            r30 = r5
            com.google.android.gms.internal.measurement.S2 r3 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = r3.G()     // Catch:{ all -> 0x00f6 }
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x00f6 }
            if (r3 == 0) goto L_0x027d
            com.google.android.gms.internal.measurement.S2 r3 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r3 = r3.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r3 = (com.google.android.gms.internal.measurement.R2) r3     // Catch:{ all -> 0x00f6 }
            r4 = 1
            r3.y(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r3 = r3.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3     // Catch:{ all -> 0x00f6 }
            r11.w(r2, r3)     // Catch:{ all -> 0x00f6 }
            r10 = r22
        L_0x027d:
            int r2 = r2 + 1
            r4 = r29
            r5 = r30
            goto L_0x021e
        L_0x0284:
            r30 = r5
            if (r28 != 0) goto L_0x02b9
            if (r29 == 0) goto L_0x02b9
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.X2 r5 = r1.f6668l     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.j2 r5 = r5.D()     // Catch:{ all -> 0x00f6 }
            r28 = r10
            java.lang.String r10 = r11.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.a(r10)     // Catch:{ all -> 0x00f6 }
            r2.b(r3, r5)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r2 = com.google.android.gms.internal.measurement.S2.R()     // Catch:{ all -> 0x00f6 }
            r2.s(r7)     // Catch:{ all -> 0x00f6 }
            r5 = r8
            r3 = r9
            r8 = 1
            r2.y(r8)     // Catch:{ all -> 0x00f6 }
            r11.z(r2)     // Catch:{ all -> 0x00f6 }
            goto L_0x02bd
        L_0x02b9:
            r5 = r8
            r3 = r9
            r28 = r10
        L_0x02bd:
            if (r28 != 0) goto L_0x02e9
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ all -> 0x00f6 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.X2 r9 = r1.f6668l     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.j2 r9 = r9.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r11.D()     // Catch:{ all -> 0x00f6 }
            java.lang.String r9 = r9.a(r10)     // Catch:{ all -> 0x00f6 }
            r2.b(r8, r9)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r2 = com.google.android.gms.internal.measurement.S2.R()     // Catch:{ all -> 0x00f6 }
            r2.s(r4)     // Catch:{ all -> 0x00f6 }
            r8 = 1
            r2.y(r8)     // Catch:{ all -> 0x00f6 }
            r11.z(r2)     // Catch:{ all -> 0x00f6 }
        L_0x02e9:
            com.google.android.gms.measurement.internal.u r31 = r1.F0()     // Catch:{ all -> 0x00f6 }
            long r32 = r1.h()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r2 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r34 = r2.F()     // Catch:{ all -> 0x00f6 }
            r40 = 0
            r41 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 1
            com.google.android.gms.measurement.internal.q r2 = r31.L0(r32, r34, r35, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x00f6 }
            long r8 = r2.f6622e     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.m r2 = r1.B0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r10 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r10.F()     // Catch:{ all -> 0x00f6 }
            r28 = r3
            com.google.android.gms.measurement.internal.c2 r3 = com.google.android.gms.measurement.internal.C1304d2.f6354p     // Catch:{ all -> 0x00f6 }
            int r2 = r2.E(r10, r3)     // Catch:{ all -> 0x00f6 }
            long r2 = (long) r2     // Catch:{ all -> 0x00f6 }
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0326
            H(r11, r4)     // Catch:{ all -> 0x00f6 }
            goto L_0x0328
        L_0x0326:
            r16 = r22
        L_0x0328:
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = com.google.android.gms.measurement.internal.z6.r0(r2)     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x03ec
            if (r29 == 0) goto L_0x03ec
            com.google.android.gms.measurement.internal.u r31 = r1.F0()     // Catch:{ all -> 0x00f6 }
            long r32 = r1.h()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r2 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r34 = r2.F()     // Catch:{ all -> 0x00f6 }
            r40 = 0
            r41 = 0
            r35 = 0
            r36 = 0
            r37 = 1
            r38 = 0
            r39 = 0
            com.google.android.gms.measurement.internal.q r2 = r31.L0(r32, r34, r35, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x00f6 }
            long r2 = r2.f6620c     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.m r4 = r1.B0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r8 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r8 = r8.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6352o     // Catch:{ all -> 0x00f6 }
            int r4 = r4.E(r8, r9)     // Catch:{ all -> 0x00f6 }
            long r8 = (long) r4     // Catch:{ all -> 0x00f6 }
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x03ec
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.r()     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.a3 r4 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r4.F()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ all -> 0x00f6 }
            r2.b(r3, r4)     // Catch:{ all -> 0x00f6 }
            r2 = 0
            r3 = 0
            r4 = -1
            r8 = 0
        L_0x0386:
            int r9 = r11.s()     // Catch:{ all -> 0x00f6 }
            if (r2 >= r9) goto L_0x03b2
            com.google.android.gms.internal.measurement.S2 r9 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = r9.G()     // Catch:{ all -> 0x00f6 }
            boolean r10 = r7.equals(r10)     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x03a3
            com.google.android.gms.internal.measurement.c5 r4 = r9.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r4 = (com.google.android.gms.internal.measurement.R2) r4     // Catch:{ all -> 0x00f6 }
            r8 = r4
            r4 = r2
            goto L_0x03af
        L_0x03a3:
            java.lang.String r9 = r9.G()     // Catch:{ all -> 0x00f6 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x00f6 }
            if (r9 == 0) goto L_0x03af
            r3 = r22
        L_0x03af:
            int r2 = r2 + 1
            goto L_0x0386
        L_0x03b2:
            if (r3 == 0) goto L_0x03bb
            if (r8 == 0) goto L_0x03ba
            r11.C(r4)     // Catch:{ all -> 0x00f6 }
            goto L_0x03ec
        L_0x03ba:
            r8 = 0
        L_0x03bb:
            if (r8 == 0) goto L_0x03d5
            com.google.android.gms.internal.measurement.c5 r2 = r8.clone()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r2 = (com.google.android.gms.internal.measurement.R2) r2     // Catch:{ all -> 0x00f6 }
            r2.s(r12)     // Catch:{ all -> 0x00f6 }
            r8 = 10
            r2.y(r8)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r2 = r2.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r2 = (com.google.android.gms.internal.measurement.S2) r2     // Catch:{ all -> 0x00f6 }
            r11.w(r4, r2)     // Catch:{ all -> 0x00f6 }
            goto L_0x03ec
        L_0x03d5:
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.a3 r4 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r4.F()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ all -> 0x00f6 }
            r2.b(r3, r4)     // Catch:{ all -> 0x00f6 }
        L_0x03ec:
            if (r29 == 0) goto L_0x045f
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00f6 }
            java.util.List r3 = r11.r()     // Catch:{ all -> 0x00f6 }
            r2.<init>(r3)     // Catch:{ all -> 0x00f6 }
            r3 = 0
            r4 = -1
            r8 = -1
        L_0x03fa:
            int r9 = r2.size()     // Catch:{ all -> 0x00f6 }
            java.lang.String r10 = "currency"
            java.lang.String r12 = "value"
            if (r3 >= r9) goto L_0x042a
            java.lang.Object r9 = r2.get(r3)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r9 = (com.google.android.gms.internal.measurement.S2) r9     // Catch:{ all -> 0x00f6 }
            java.lang.String r9 = r9.G()     // Catch:{ all -> 0x00f6 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x00f6 }
            if (r9 == 0) goto L_0x0416
            r4 = r3
            goto L_0x0427
        L_0x0416:
            java.lang.Object r9 = r2.get(r3)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r9 = (com.google.android.gms.internal.measurement.S2) r9     // Catch:{ all -> 0x00f6 }
            java.lang.String r9 = r9.G()     // Catch:{ all -> 0x00f6 }
            boolean r9 = r10.equals(r9)     // Catch:{ all -> 0x00f6 }
            if (r9 == 0) goto L_0x0427
            r8 = r3
        L_0x0427:
            int r3 = r3 + 1
            goto L_0x03fa
        L_0x042a:
            r3 = -1
            if (r4 != r3) goto L_0x042f
            goto L_0x04a5
        L_0x042f:
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3     // Catch:{ all -> 0x00f6 }
            boolean r3 = r3.J()     // Catch:{ all -> 0x00f6 }
            if (r3 != 0) goto L_0x0461
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3     // Catch:{ all -> 0x00f6 }
            boolean r3 = r3.N()     // Catch:{ all -> 0x00f6 }
            if (r3 != 0) goto L_0x0461
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.t()     // Catch:{ all -> 0x00f6 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.a(r3)     // Catch:{ all -> 0x00f6 }
            r11.C(r4)     // Catch:{ all -> 0x00f6 }
            H(r11, r7)     // Catch:{ all -> 0x00f6 }
            r2 = 18
            G(r11, r2, r12)     // Catch:{ all -> 0x00f6 }
        L_0x045f:
            r3 = -1
            goto L_0x04a5
        L_0x0461:
            r3 = -1
            if (r8 != r3) goto L_0x0465
            goto L_0x048d
        L_0x0465:
            java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r2 = (com.google.android.gms.internal.measurement.S2) r2     // Catch:{ all -> 0x00f6 }
            java.lang.String r2 = r2.I()     // Catch:{ all -> 0x00f6 }
            int r8 = r2.length()     // Catch:{ all -> 0x00f6 }
            r9 = 3
            if (r8 != r9) goto L_0x048d
            r8 = 0
        L_0x0477:
            int r9 = r2.length()     // Catch:{ all -> 0x00f6 }
            if (r8 >= r9) goto L_0x04a5
            int r9 = r2.codePointAt(r8)     // Catch:{ all -> 0x00f6 }
            boolean r12 = java.lang.Character.isLetter(r9)     // Catch:{ all -> 0x00f6 }
            if (r12 == 0) goto L_0x048d
            int r9 = java.lang.Character.charCount(r9)     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            goto L_0x0477
        L_0x048d:
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.t()     // Catch:{ all -> 0x00f6 }
            java.lang.String r8 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r8)     // Catch:{ all -> 0x00f6 }
            r11.C(r4)     // Catch:{ all -> 0x00f6 }
            H(r11, r7)     // Catch:{ all -> 0x00f6 }
            r2 = 19
            G(r11, r2, r10)     // Catch:{ all -> 0x00f6 }
        L_0x04a5:
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r13.equals(r2)     // Catch:{ all -> 0x00f6 }
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04fc
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r2 = r11.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r2 = (com.google.android.gms.internal.measurement.O2) r2     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r2 = com.google.android.gms.measurement.internal.u6.r(r2, r6)     // Catch:{ all -> 0x00f6 }
            if (r2 != 0) goto L_0x04f6
            if (r18 == 0) goto L_0x04ed
            long r9 = r18.G()     // Catch:{ all -> 0x00f6 }
            long r12 = r11.G()     // Catch:{ all -> 0x00f6 }
            long r9 = r9 - r12
            long r9 = java.lang.Math.abs(r9)     // Catch:{ all -> 0x00f6 }
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x04ed
            com.google.android.gms.internal.measurement.c5 r2 = r18.clone()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.N2 r2 = (com.google.android.gms.internal.measurement.N2) r2     // Catch:{ all -> 0x00f6 }
            boolean r4 = r1.O(r11, r2)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x04ed
            r9 = r28
            r9.P0(r5, r2)     // Catch:{ all -> 0x00f6 }
            r8 = r5
            r10 = r25
        L_0x04e7:
            r17 = 0
            r18 = 0
            goto L_0x05ab
        L_0x04ed:
            r9 = r28
            r10 = r46
            r8 = r5
            r17 = r11
            goto L_0x05ab
        L_0x04f6:
            r9 = r28
        L_0x04f8:
            r4 = r25
            goto L_0x05a9
        L_0x04fc:
            r9 = r28
            java.lang.String r2 = "_vs"
            java.lang.String r4 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x054b
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r2 = r11.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r2 = (com.google.android.gms.internal.measurement.O2) r2     // Catch:{ all -> 0x00f6 }
            r4 = r30
            com.google.android.gms.internal.measurement.S2 r2 = com.google.android.gms.measurement.internal.u6.r(r2, r4)     // Catch:{ all -> 0x00f6 }
            if (r2 != 0) goto L_0x04f8
            if (r17 == 0) goto L_0x0543
            long r12 = r17.G()     // Catch:{ all -> 0x00f6 }
            long r28 = r11.G()     // Catch:{ all -> 0x00f6 }
            long r12 = r12 - r28
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x00f6 }
            int r2 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0543
            com.google.android.gms.internal.measurement.c5 r2 = r17.clone()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.N2 r2 = (com.google.android.gms.internal.measurement.N2) r2     // Catch:{ all -> 0x00f6 }
            boolean r4 = r1.O(r2, r11)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x0543
            r4 = r25
            r9.P0(r4, r2)     // Catch:{ all -> 0x00f6 }
            r10 = r4
            r8 = r5
            goto L_0x04e7
        L_0x0543:
            r4 = r25
            r8 = r46
            r10 = r4
            r18 = r11
            goto L_0x05ab
        L_0x054b:
            r4 = r25
            com.google.android.gms.measurement.internal.m r2 = r1.B0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.c2 r6 = com.google.android.gms.measurement.internal.C1304d2.f6344k1     // Catch:{ all -> 0x00f6 }
            r7 = 0
            boolean r2 = r2.H(r7, r6)     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x05a9
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = "_v"
            if (r2 != 0) goto L_0x0570
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r6.equals(r2)     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x05a9
        L_0x0570:
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x00f6 }
            if (r2 != 0) goto L_0x0584
            java.lang.String r2 = r11.D()     // Catch:{ all -> 0x00f6 }
            boolean r2 = r6.equals(r2)     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x05a9
        L_0x0584:
            r2 = 0
        L_0x0585:
            int r6 = r11.s()     // Catch:{ all -> 0x00f6 }
            if (r2 >= r6) goto L_0x05a9
            com.google.android.gms.internal.measurement.S2 r6 = r11.t(r2)     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = "_elt"
            java.lang.String r8 = r6.G()     // Catch:{ all -> 0x00f6 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00f6 }
            if (r7 == 0) goto L_0x05a6
            long r6 = r6.K()     // Catch:{ all -> 0x00f6 }
            r11.K(r6)     // Catch:{ all -> 0x00f6 }
            r11.C(r2)     // Catch:{ all -> 0x00f6 }
            goto L_0x05a9
        L_0x05a6:
            int r2 = r2 + 1
            goto L_0x0585
        L_0x05a9:
            r10 = r4
            r8 = r5
        L_0x05ab:
            int r2 = r11.s()     // Catch:{ all -> 0x00f6 }
            if (r2 == 0) goto L_0x06bb
            r1.K0()     // Catch:{ all -> 0x00f6 }
            java.util.List r2 = r11.r()     // Catch:{ all -> 0x00f6 }
            android.os.Bundle r2 = com.google.android.gms.measurement.internal.u6.q(r2)     // Catch:{ all -> 0x00f6 }
            r4 = 0
        L_0x05bd:
            int r5 = r11.s()     // Catch:{ all -> 0x00f6 }
            if (r4 >= r5) goto L_0x066c
            com.google.android.gms.internal.measurement.S2 r5 = r11.t(r4)     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r5.G()     // Catch:{ all -> 0x00f6 }
            r7 = r26
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x0646
            java.util.List r6 = r5.P()     // Catch:{ all -> 0x00f6 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00f6 }
            if (r6 != 0) goto L_0x0646
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            java.util.List r5 = r5.P()     // Catch:{ all -> 0x00f6 }
            int r12 = r5.size()     // Catch:{ all -> 0x00f6 }
            android.os.Bundle[] r12 = new android.os.Bundle[r12]     // Catch:{ all -> 0x00f6 }
            r13 = 0
        L_0x05ee:
            int r3 = r5.size()     // Catch:{ all -> 0x00f6 }
            if (r13 >= r3) goto L_0x0640
            java.lang.Object r3 = r5.get(r13)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r3 = (com.google.android.gms.internal.measurement.S2) r3     // Catch:{ all -> 0x00f6 }
            r1.K0()     // Catch:{ all -> 0x00f6 }
            java.util.List r22 = r3.P()     // Catch:{ all -> 0x00f6 }
            r25 = r3
            android.os.Bundle r3 = com.google.android.gms.measurement.internal.u6.q(r22)     // Catch:{ all -> 0x00f6 }
            java.util.List r22 = r25.P()     // Catch:{ all -> 0x00f6 }
            java.util.Iterator r22 = r22.iterator()     // Catch:{ all -> 0x00f6 }
        L_0x060f:
            boolean r25 = r22.hasNext()     // Catch:{ all -> 0x00f6 }
            if (r25 == 0) goto L_0x0633
            java.lang.Object r25 = r22.next()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r25 = (com.google.android.gms.internal.measurement.S2) r25     // Catch:{ all -> 0x00f6 }
            r26 = r4
            java.lang.String r4 = r11.D()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r25 = r25.q()     // Catch:{ all -> 0x00f6 }
            r28 = r5
            r5 = r25
            com.google.android.gms.internal.measurement.R2 r5 = (com.google.android.gms.internal.measurement.R2) r5     // Catch:{ all -> 0x00f6 }
            r1.z(r4, r5, r3, r6)     // Catch:{ all -> 0x00f6 }
            r4 = r26
            r5 = r28
            goto L_0x060f
        L_0x0633:
            r26 = r4
            r28 = r5
            r12[r13] = r3     // Catch:{ all -> 0x00f6 }
            int r13 = r13 + 1
            r4 = r26
            r5 = r28
            goto L_0x05ee
        L_0x0640:
            r26 = r4
            r2.putParcelableArray(r7, r12)     // Catch:{ all -> 0x00f6 }
            goto L_0x0665
        L_0x0646:
            r26 = r4
            java.lang.String r3 = r5.G()     // Catch:{ all -> 0x00f6 }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x00f6 }
            if (r3 != 0) goto L_0x0665
            java.lang.String r3 = r11.D()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.c5 r4 = r5.q()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r4 = (com.google.android.gms.internal.measurement.R2) r4     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r5 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.F()     // Catch:{ all -> 0x00f6 }
            r1.z(r3, r4, r2, r5)     // Catch:{ all -> 0x00f6 }
        L_0x0665:
            int r4 = r26 + 1
            r26 = r7
            r3 = -1
            goto L_0x05bd
        L_0x066c:
            r7 = r26
            r11.B()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u6 r3 = r1.K0()     // Catch:{ all -> 0x00f6 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00f6 }
            r4.<init>()     // Catch:{ all -> 0x00f6 }
            java.util.Set r5 = r2.keySet()     // Catch:{ all -> 0x00f6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00f6 }
        L_0x0682:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x06a8
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.R2 r12 = com.google.android.gms.internal.measurement.S2.R()     // Catch:{ all -> 0x00f6 }
            r12.s(r6)     // Catch:{ all -> 0x00f6 }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x0682
            r3.H(r12, r6)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r6 = r12.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r6 = (com.google.android.gms.internal.measurement.S2) r6     // Catch:{ all -> 0x00f6 }
            r4.add(r6)     // Catch:{ all -> 0x00f6 }
            goto L_0x0682
        L_0x06a8:
            int r2 = r4.size()     // Catch:{ all -> 0x00f6 }
            r3 = 0
        L_0x06ad:
            if (r3 >= r2) goto L_0x06bd
            java.lang.Object r5 = r4.get(r3)     // Catch:{ all -> 0x00f6 }
            int r3 = r3 + 1
            com.google.android.gms.internal.measurement.S2 r5 = (com.google.android.gms.internal.measurement.S2) r5     // Catch:{ all -> 0x00f6 }
            r11.y(r5)     // Catch:{ all -> 0x00f6 }
            goto L_0x06ad
        L_0x06bb:
            r7 = r26
        L_0x06bd:
            java.util.List r2 = r15.f6557c     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r3 = r11.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r3 = (com.google.android.gms.internal.measurement.O2) r3     // Catch:{ all -> 0x00f6 }
            r4 = r24
            r2.set(r4, r3)     // Catch:{ all -> 0x00f6 }
            r9.Q0(r11)     // Catch:{ all -> 0x00f6 }
            int r13 = r46 + 1
        L_0x06cf:
            int r12 = r4 + 1
            r4 = r7
            r2 = r21
            r7 = r23
            r3 = r27
            r5 = 1
            goto L_0x004e
        L_0x06dc:
            r4 = r5
            r23 = r7
            r22 = 1
            r2 = 0
            r5 = r46
            r7 = r2
            r0 = 0
        L_0x06e7:
            if (r0 >= r5) goto L_0x0733
            com.google.android.gms.internal.measurement.O2 r10 = r9.N0(r0)     // Catch:{ all -> 0x00f6 }
            java.lang.String r11 = r10.I()     // Catch:{ all -> 0x00f6 }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x00f6 }
            if (r11 == 0) goto L_0x0708
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r11 = com.google.android.gms.measurement.internal.u6.r(r10, r6)     // Catch:{ all -> 0x00f6 }
            if (r11 == 0) goto L_0x0708
            r9.T0(r0)     // Catch:{ all -> 0x00f6 }
            int r5 = r5 + -1
            int r0 = r0 + -1
            goto L_0x0730
        L_0x0708:
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.S2 r10 = com.google.android.gms.measurement.internal.u6.r(r10, r4)     // Catch:{ all -> 0x00f6 }
            if (r10 == 0) goto L_0x0730
            boolean r11 = r10.J()     // Catch:{ all -> 0x00f6 }
            if (r11 == 0) goto L_0x0720
            long r10 = r10.K()     // Catch:{ all -> 0x00f6 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x00f6 }
            goto L_0x0721
        L_0x0720:
            r10 = 0
        L_0x0721:
            if (r10 == 0) goto L_0x0730
            long r11 = r10.longValue()     // Catch:{ all -> 0x00f6 }
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 <= 0) goto L_0x0730
            long r10 = r10.longValue()     // Catch:{ all -> 0x00f6 }
            long r7 = r7 + r10
        L_0x0730:
            int r0 = r0 + 1
            goto L_0x06e7
        L_0x0733:
            r4 = 0
            r1.N(r9, r7, r4)     // Catch:{ all -> 0x00f6 }
            java.util.List r0 = r9.L0()     // Catch:{ all -> 0x00f6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00f6 }
        L_0x073f:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = "_se"
            if (r4 == 0) goto L_0x0764
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r4 = (com.google.android.gms.internal.measurement.O2) r4     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = "_s"
            java.lang.String r4 = r4.I()     // Catch:{ all -> 0x00f6 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x073f
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r9.D()     // Catch:{ all -> 0x00f6 }
            r0.z0(r4, r5)     // Catch:{ all -> 0x00f6 }
        L_0x0764:
            java.lang.String r0 = "_sid"
            int r0 = com.google.android.gms.measurement.internal.u6.X(r9, r0)     // Catch:{ all -> 0x00f6 }
            if (r0 < 0) goto L_0x0772
            r4 = r22
            r1.N(r9, r7, r4)     // Catch:{ all -> 0x00f6 }
            goto L_0x0792
        L_0x0772:
            int r0 = com.google.android.gms.measurement.internal.u6.X(r9, r5)     // Catch:{ all -> 0x00f6 }
            if (r0 < 0) goto L_0x0792
            r9.b1(r0)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.a3 r5 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.F()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ all -> 0x00f6 }
            r0.b(r4, r5)     // Catch:{ all -> 0x00f6 }
        L_0x0792:
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r0 = r0.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.T2 r4 = r1.b()     // Catch:{ all -> 0x00f6 }
            r4.h()     // Catch:{ all -> 0x00f6 }
            r1.O0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.w2 r4 = r4.J0(r0)     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x07be
            com.google.android.gms.measurement.internal.q2 r4 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = "Cannot fix consent fields without appInfo. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C1402q2.x(r0)     // Catch:{ all -> 0x00f6 }
            r4.b(r5, r0)     // Catch:{ all -> 0x00f6 }
            goto L_0x07c1
        L_0x07be:
            r1.n(r4, r9)     // Catch:{ all -> 0x00f6 }
        L_0x07c1:
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r0 = r0.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.T2 r4 = r1.b()     // Catch:{ all -> 0x00f6 }
            r4.h()     // Catch:{ all -> 0x00f6 }
            r1.O0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.w2 r4 = r4.J0(r0)     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x07ed
            com.google.android.gms.measurement.internal.q2 r4 = r1.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.r()     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = "Cannot populate ad_campaign_info without appInfo. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C1402q2.x(r0)     // Catch:{ all -> 0x00f6 }
            r4.b(r5, r0)     // Catch:{ all -> 0x00f6 }
            goto L_0x07f0
        L_0x07ed:
            r1.o(r4, r9)     // Catch:{ all -> 0x00f6 }
        L_0x07f0:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9.f1(r4)     // Catch:{ all -> 0x00f6 }
            r4 = -9223372036854775808
            r9.h1(r4)     // Catch:{ all -> 0x00f6 }
            r4 = 0
        L_0x07fe:
            int r0 = r9.M0()     // Catch:{ all -> 0x00f6 }
            if (r4 >= r0) goto L_0x0831
            com.google.android.gms.internal.measurement.O2 r0 = r9.N0(r4)     // Catch:{ all -> 0x00f6 }
            long r5 = r0.K()     // Catch:{ all -> 0x00f6 }
            long r7 = r9.e1()     // Catch:{ all -> 0x00f6 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x081b
            long r5 = r0.K()     // Catch:{ all -> 0x00f6 }
            r9.f1(r5)     // Catch:{ all -> 0x00f6 }
        L_0x081b:
            long r5 = r0.K()     // Catch:{ all -> 0x00f6 }
            long r7 = r9.g1()     // Catch:{ all -> 0x00f6 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x082e
            long r5 = r0.K()     // Catch:{ all -> 0x00f6 }
            r9.h1(r5)     // Catch:{ all -> 0x00f6 }
        L_0x082e:
            int r4 = r4 + 1
            goto L_0x07fe
        L_0x0831:
            r9.v0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.E3 r0 = com.google.android.gms.measurement.internal.E3.f5857c     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r0 = r0.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.E3 r0 = r1.g(r0)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r4 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r4.L0()     // Catch:{ all -> 0x00f6 }
            r5 = 100
            com.google.android.gms.measurement.internal.E3 r4 = com.google.android.gms.measurement.internal.E3.f(r4, r5)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.E3 r0 = r0.s(r4)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r5 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.E3 r4 = r4.X(r5)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u r5 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            r5.W(r6, r0)     // Catch:{ all -> 0x00f6 }
            f0.w r5 = f0.w.ANALYTICS_STORAGE     // Catch:{ all -> 0x00f6 }
            boolean r6 = r0.o(r5)     // Catch:{ all -> 0x00f6 }
            if (r6 != 0) goto L_0x0887
            boolean r6 = r4.o(r5)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x0887
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            r4.x0(r6)     // Catch:{ all -> 0x00f6 }
            goto L_0x08a0
        L_0x0887:
            boolean r6 = r0.o(r5)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x08a0
            boolean r4 = r4.o(r5)     // Catch:{ all -> 0x00f6 }
            if (r4 != 0) goto L_0x08a0
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            r4.y0(r6)     // Catch:{ all -> 0x00f6 }
        L_0x08a0:
            f0.w r4 = f0.w.AD_STORAGE     // Catch:{ all -> 0x00f6 }
            boolean r6 = r0.o(r4)     // Catch:{ all -> 0x00f6 }
            if (r6 != 0) goto L_0x08b1
            r9.K()     // Catch:{ all -> 0x00f6 }
            r9.N()     // Catch:{ all -> 0x00f6 }
            r9.y0()     // Catch:{ all -> 0x00f6 }
        L_0x08b1:
            boolean r6 = r0.o(r5)     // Catch:{ all -> 0x00f6 }
            if (r6 != 0) goto L_0x08bd
            r9.Q()     // Catch:{ all -> 0x00f6 }
            r9.G0()     // Catch:{ all -> 0x00f6 }
        L_0x08bd:
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.m r6 = r1.B0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r7 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.c2 r8 = com.google.android.gms.measurement.internal.C1304d2.f6293Q0     // Catch:{ all -> 0x00f6 }
            boolean r6 = r6.H(r7, r8)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x08fd
            com.google.android.gms.measurement.internal.z6 r6 = r1.N0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r7 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = r7.F()     // Catch:{ all -> 0x00f6 }
            boolean r6 = r6.L(r7)     // Catch:{ all -> 0x00f6 }
            if (r6 == 0) goto L_0x08fd
            com.google.android.gms.internal.measurement.a3 r6 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r6.F()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.E3 r6 = r1.g(r6)     // Catch:{ all -> 0x00f6 }
            boolean r4 = r6.o(r4)     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x08fd
            com.google.android.gms.internal.measurement.a3 r4 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            boolean r4 = r4.Q0()     // Catch:{ all -> 0x00f6 }
            if (r4 == 0) goto L_0x08fd
            r1.y(r9, r15)     // Catch:{ all -> 0x00f6 }
        L_0x08fd:
            r9.r0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.e r24 = r1.I0()     // Catch:{ all -> 0x00f6 }
            java.lang.String r25 = r9.D()     // Catch:{ all -> 0x00f6 }
            java.util.List r26 = r9.L0()     // Catch:{ all -> 0x00f6 }
            java.util.List r27 = r9.U0()     // Catch:{ all -> 0x00f6 }
            long r6 = r9.e1()     // Catch:{ all -> 0x00f6 }
            java.lang.Long r28 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00f6 }
            long r6 = r9.g1()     // Catch:{ all -> 0x00f6 }
            java.lang.Long r29 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00f6 }
            boolean r0 = r0.o(r5)     // Catch:{ all -> 0x00f6 }
            r22 = 1
            r30 = r0 ^ 1
            java.util.List r0 = r24.m(r25, r26, r27, r28, r29, r30)     // Catch:{ all -> 0x00f6 }
            r9.q0(r0)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r4 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = r4.F()     // Catch:{ all -> 0x00f6 }
            boolean r0 = r0.l(r4)     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x0c63
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0a7b }
            r4.<init>()     // Catch:{ all -> 0x0a7b }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0a7b }
            r5.<init>()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.z6 r0 = r1.N0()     // Catch:{ all -> 0x0a7b }
            java.security.SecureRandom r6 = r0.q0()     // Catch:{ all -> 0x0a7b }
            r7 = 0
        L_0x0952:
            int r0 = r9.M0()     // Catch:{ all -> 0x0a7b }
            if (r7 >= r0) goto L_0x0c29
            com.google.android.gms.internal.measurement.O2 r0 = r9.N0(r7)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.c5 r0 = r0.q()     // Catch:{ all -> 0x0a7b }
            r8 = r0
            com.google.android.gms.internal.measurement.N2 r8 = (com.google.android.gms.internal.measurement.N2) r8     // Catch:{ all -> 0x0a7b }
            java.lang.String r0 = r8.D()     // Catch:{ all -> 0x0a7b }
            java.lang.String r10 = "_ep"
            boolean r0 = r0.equals(r10)     // Catch:{ all -> 0x0a7b }
            java.lang.String r10 = "_efs"
            java.lang.String r11 = "_sr"
            if (r0 == 0) goto L_0x09f3
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ all -> 0x00f6 }
            java.lang.String r12 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.u6.u(r0, r12)     // Catch:{ all -> 0x00f6 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00f6 }
            java.lang.Object r12 = r4.get(r0)     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.C r12 = (com.google.android.gms.measurement.internal.C) r12     // Catch:{ all -> 0x00f6 }
            if (r12 != 0) goto L_0x09a5
            com.google.android.gms.measurement.internal.u r12 = r1.F0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.a3 r13 = r15.f6555a     // Catch:{ all -> 0x00f6 }
            java.lang.String r13 = r13.F()     // Catch:{ all -> 0x00f6 }
            java.lang.Object r14 = N.C0722p.k(r0)     // Catch:{ all -> 0x00f6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.C r12 = r12.v0(r13, r14)     // Catch:{ all -> 0x00f6 }
            if (r12 == 0) goto L_0x09a5
            r4.put(r0, r12)     // Catch:{ all -> 0x00f6 }
        L_0x09a5:
            if (r12 == 0) goto L_0x09e1
            java.lang.Long r0 = r12.f5799i     // Catch:{ all -> 0x00f6 }
            if (r0 != 0) goto L_0x09e1
            java.lang.Long r0 = r12.f5800j     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x09c0
            long r13 = r0.longValue()     // Catch:{ all -> 0x00f6 }
            r19 = 1
            int r13 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r13 <= 0) goto L_0x09c2
            r1.K0()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.u6.o(r8, r11, r0)     // Catch:{ all -> 0x00f6 }
            goto L_0x09c2
        L_0x09c0:
            r19 = 1
        L_0x09c2:
            java.lang.Boolean r0 = r12.f5801k     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x09d5
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x09d5
            r1.K0()     // Catch:{ all -> 0x00f6 }
            r12 = r23
            com.google.android.gms.measurement.internal.u6.o(r8, r10, r12)     // Catch:{ all -> 0x00f6 }
            goto L_0x09d7
        L_0x09d5:
            r12 = r23
        L_0x09d7:
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ all -> 0x00f6 }
            r5.add(r0)     // Catch:{ all -> 0x00f6 }
            goto L_0x09e5
        L_0x09e1:
            r12 = r23
            r19 = 1
        L_0x09e5:
            r9.P0(r7, r8)     // Catch:{ all -> 0x00f6 }
            r45 = r2
        L_0x09ea:
            r21 = r6
            r1 = r7
            r6 = r12
            r17 = r15
            r12 = 1
            goto L_0x0c1b
        L_0x09f3:
            r12 = r23
            r19 = 1
            com.google.android.gms.measurement.internal.P2 r13 = r1.D0()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r14 = r0.F()     // Catch:{ all -> 0x0a7b }
            java.lang.String r0 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r0 = r13.d(r14, r0)     // Catch:{ all -> 0x0a7b }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0a7b }
            if (r17 != 0) goto L_0x0a2d
            long r13 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0a14 }
            r45 = r2
            goto L_0x0a30
        L_0x0a14:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r13 = r13.f5730a     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x00f6 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.r()     // Catch:{ all -> 0x00f6 }
            r45 = r2
            java.lang.String r2 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r14)     // Catch:{ all -> 0x00f6 }
            r13.c(r2, r3, r0)     // Catch:{ all -> 0x00f6 }
        L_0x0a2a:
            r13 = r45
            goto L_0x0a30
        L_0x0a2d:
            r45 = r2
            goto L_0x0a2a
        L_0x0a30:
            com.google.android.gms.measurement.internal.z6 r0 = r1.N0()     // Catch:{ all -> 0x0a7b }
            long r2 = r8.G()     // Catch:{ all -> 0x0a7b }
            long r2 = r0.Y(r2, r13)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ all -> 0x0a7b }
            java.lang.String r1 = "_dbg"
            boolean r17 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0a7b }
            if (r17 != 0) goto L_0x0a83
            java.util.List r0 = r0.F()     // Catch:{ all -> 0x0a7b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0a7b }
        L_0x0a52:
            boolean r17 = r0.hasNext()     // Catch:{ all -> 0x0a7b }
            if (r17 == 0) goto L_0x0a83
            java.lang.Object r17 = r0.next()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.S2 r17 = (com.google.android.gms.internal.measurement.S2) r17     // Catch:{ all -> 0x0a7b }
            r18 = r10
            java.lang.String r10 = r17.G()     // Catch:{ all -> 0x0a7b }
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x0a7b }
            if (r10 == 0) goto L_0x0a80
            long r0 = r17.K()     // Catch:{ all -> 0x0a7b }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0a7b }
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x0a7b }
            if (r0 != 0) goto L_0x0a79
            goto L_0x0a85
        L_0x0a79:
            r0 = 1
            goto L_0x0a97
        L_0x0a7b:
            r0 = move-exception
            r2 = r43
            goto L_0x0e06
        L_0x0a80:
            r10 = r18
            goto L_0x0a52
        L_0x0a83:
            r18 = r10
        L_0x0a85:
            com.google.android.gms.measurement.internal.P2 r0 = r43.D0()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.a3 r1 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r1 = r1.F()     // Catch:{ all -> 0x0a7b }
            java.lang.String r10 = r8.D()     // Catch:{ all -> 0x0a7b }
            int r0 = r0.G(r1, r10)     // Catch:{ all -> 0x0a7b }
        L_0x0a97:
            if (r0 > 0) goto L_0x0abc
            com.google.android.gms.measurement.internal.q2 r1 = r43.a()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()     // Catch:{ all -> 0x0a7b }
            java.lang.String r2 = "Sample rate must be positive. event, rate"
            java.lang.String r3 = r8.D()     // Catch:{ all -> 0x0a7b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0a7b }
            r1.c(r2, r3, r0)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ all -> 0x0a7b }
            r5.add(r0)     // Catch:{ all -> 0x0a7b }
            r9.P0(r7, r8)     // Catch:{ all -> 0x0a7b }
            goto L_0x09ea
        L_0x0abc:
            java.lang.String r1 = r8.D()     // Catch:{ all -> 0x0a7b }
            java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r1 = (com.google.android.gms.measurement.internal.C) r1     // Catch:{ all -> 0x0a7b }
            if (r1 != 0) goto L_0x0b20
            com.google.android.gms.measurement.internal.u r1 = r43.F0()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.a3 r10 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r10 = r10.F()     // Catch:{ all -> 0x0a7b }
            r23 = r12
            java.lang.String r12 = r8.D()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r1 = r1.v0(r10, r12)     // Catch:{ all -> 0x0a7b }
            if (r1 != 0) goto L_0x0b1d
            com.google.android.gms.measurement.internal.q2 r1 = r43.a()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()     // Catch:{ all -> 0x0a7b }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.a3 r12 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r12 = r12.F()     // Catch:{ all -> 0x0a7b }
            r24 = r13
            java.lang.String r13 = r8.D()     // Catch:{ all -> 0x0a7b }
            r1.c(r10, r12, r13)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r26 = new com.google.android.gms.measurement.internal.C     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.a3 r1 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r27 = r1.F()     // Catch:{ all -> 0x0a7b }
            java.lang.String r28 = r8.D()     // Catch:{ all -> 0x0a7b }
            long r35 = r8.G()     // Catch:{ all -> 0x0a7b }
            r41 = 0
            r42 = 0
            r29 = 1
            r31 = 1
            r33 = 1
            r37 = 0
            r39 = 0
            r40 = 0
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0a7b }
            r1 = r26
            goto L_0x0b23
        L_0x0b1d:
            r24 = r13
            goto L_0x0b23
        L_0x0b20:
            r23 = r12
            goto L_0x0b1d
        L_0x0b23:
            r43.K0()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.e5 r10 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r10 = (com.google.android.gms.internal.measurement.O2) r10     // Catch:{ all -> 0x0a7b }
            java.lang.String r12 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.u6.u(r10, r12)     // Catch:{ all -> 0x0a7b }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0a7b }
            if (r10 == 0) goto L_0x0b3a
            r22 = 1
        L_0x0b38:
            r12 = 1
            goto L_0x0b3d
        L_0x0b3a:
            r22 = 0
            goto L_0x0b38
        L_0x0b3d:
            if (r0 != r12) goto L_0x0b6e
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ all -> 0x0a7b }
            r5.add(r0)     // Catch:{ all -> 0x0a7b }
            if (r22 == 0) goto L_0x0b62
            java.lang.Long r0 = r1.f5799i     // Catch:{ all -> 0x0a7b }
            if (r0 != 0) goto L_0x0b56
            java.lang.Long r0 = r1.f5800j     // Catch:{ all -> 0x0a7b }
            if (r0 != 0) goto L_0x0b56
            java.lang.Boolean r0 = r1.f5801k     // Catch:{ all -> 0x0a7b }
            if (r0 == 0) goto L_0x0b62
        L_0x0b56:
            r2 = 0
            com.google.android.gms.measurement.internal.C r0 = r1.c(r2, r2, r2)     // Catch:{ all -> 0x0a7b }
            java.lang.String r1 = r8.D()     // Catch:{ all -> 0x0a7b }
            r4.put(r1, r0)     // Catch:{ all -> 0x0a7b }
        L_0x0b62:
            r9.P0(r7, r8)     // Catch:{ all -> 0x0a7b }
            r21 = r6
            r1 = r7
            r17 = r15
            r6 = r23
            goto L_0x0c1b
        L_0x0b6e:
            int r13 = r6.nextInt(r0)     // Catch:{ all -> 0x0a7b }
            if (r13 != 0) goto L_0x0ba7
            r43.K0()     // Catch:{ all -> 0x0a7b }
            long r13 = (long) r0     // Catch:{ all -> 0x0a7b }
            java.lang.Long r0 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.u6.o(r8, r11, r0)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.e5 r10 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r10 = (com.google.android.gms.internal.measurement.O2) r10     // Catch:{ all -> 0x0a7b }
            r5.add(r10)     // Catch:{ all -> 0x0a7b }
            if (r22 == 0) goto L_0x0b8f
            r10 = 0
            com.google.android.gms.measurement.internal.C r1 = r1.c(r10, r0, r10)     // Catch:{ all -> 0x0a7b }
        L_0x0b8f:
            java.lang.String r0 = r8.D()     // Catch:{ all -> 0x0a7b }
            long r10 = r8.G()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r1 = r1.b(r10, r2)     // Catch:{ all -> 0x0a7b }
            r4.put(r0, r1)     // Catch:{ all -> 0x0a7b }
            r21 = r6
            r1 = r7
            r17 = r15
            r6 = r23
            goto L_0x0c18
        L_0x0ba7:
            java.lang.Long r13 = r1.f5798h     // Catch:{ all -> 0x0a7b }
            if (r13 == 0) goto L_0x0bb6
            long r13 = r13.longValue()     // Catch:{ all -> 0x0a7b }
            r21 = r6
            r26 = r7
            r17 = r15
            goto L_0x0bca
        L_0x0bb6:
            com.google.android.gms.measurement.internal.z6 r13 = r43.N0()     // Catch:{ all -> 0x0a7b }
            r17 = r15
            long r14 = r8.I()     // Catch:{ all -> 0x0a7b }
            r21 = r6
            r26 = r7
            r6 = r24
            long r13 = r13.Y(r14, r6)     // Catch:{ all -> 0x0a7b }
        L_0x0bca:
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0c07
            r43.K0()     // Catch:{ all -> 0x0a7b }
            r7 = r18
            r6 = r23
            com.google.android.gms.measurement.internal.u6.o(r8, r7, r6)     // Catch:{ all -> 0x0a7b }
            r43.K0()     // Catch:{ all -> 0x0a7b }
            long r13 = (long) r0     // Catch:{ all -> 0x0a7b }
            java.lang.Long r0 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.u6.o(r8, r11, r0)     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.e5 r7 = r8.o()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.internal.measurement.O2 r7 = (com.google.android.gms.internal.measurement.O2) r7     // Catch:{ all -> 0x0a7b }
            r5.add(r7)     // Catch:{ all -> 0x0a7b }
            if (r22 == 0) goto L_0x0bf5
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0a7b }
            r10 = 0
            com.google.android.gms.measurement.internal.C r1 = r1.c(r10, r0, r7)     // Catch:{ all -> 0x0a7b }
        L_0x0bf5:
            java.lang.String r0 = r8.D()     // Catch:{ all -> 0x0a7b }
            long r10 = r8.G()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r1 = r1.b(r10, r2)     // Catch:{ all -> 0x0a7b }
            r4.put(r0, r1)     // Catch:{ all -> 0x0a7b }
        L_0x0c04:
            r1 = r26
            goto L_0x0c18
        L_0x0c07:
            r6 = r23
            if (r22 == 0) goto L_0x0c04
            java.lang.String r0 = r8.D()     // Catch:{ all -> 0x0a7b }
            r2 = 0
            com.google.android.gms.measurement.internal.C r1 = r1.c(r10, r2, r2)     // Catch:{ all -> 0x0a7b }
            r4.put(r0, r1)     // Catch:{ all -> 0x0a7b }
            goto L_0x0c04
        L_0x0c18:
            r9.P0(r1, r8)     // Catch:{ all -> 0x0a7b }
        L_0x0c1b:
            int r7 = r1 + 1
            r1 = r43
            r2 = r45
            r23 = r6
            r15 = r17
            r6 = r21
            goto L_0x0952
        L_0x0c29:
            r45 = r2
            r17 = r15
            r12 = 1
            int r0 = r5.size()     // Catch:{ all -> 0x0a7b }
            int r1 = r9.M0()     // Catch:{ all -> 0x0a7b }
            if (r0 >= r1) goto L_0x0c3e
            r9.S0()     // Catch:{ all -> 0x0a7b }
            r9.R0(r5)     // Catch:{ all -> 0x0a7b }
        L_0x0c3e:
            java.util.Set r0 = r4.entrySet()     // Catch:{ all -> 0x0a7b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0a7b }
        L_0x0c46:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0a7b }
            if (r1 == 0) goto L_0x0c60
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0a7b }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.u r2 = r43.F0()     // Catch:{ all -> 0x0a7b }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.C r1 = (com.google.android.gms.measurement.internal.C) r1     // Catch:{ all -> 0x0a7b }
            r2.w0(r1)     // Catch:{ all -> 0x0a7b }
            goto L_0x0c46
        L_0x0c60:
            r15 = r17
            goto L_0x0c66
        L_0x0c63:
            r45 = r2
            r12 = 1
        L_0x0c66:
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r1 = r0.F()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.u r0 = r43.F0()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.w2 r0 = r0.J0(r1)     // Catch:{ all -> 0x0a7b }
            if (r0 != 0) goto L_0x0c8f
            com.google.android.gms.measurement.internal.q2 r0 = r43.a()     // Catch:{ all -> 0x0a7b }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0a7b }
            java.lang.String r2 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.a3 r3 = r15.f6555a     // Catch:{ all -> 0x0a7b }
            java.lang.String r3 = r3.F()     // Catch:{ all -> 0x0a7b }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r3)     // Catch:{ all -> 0x0a7b }
            r0.b(r2, r3)     // Catch:{ all -> 0x0a7b }
        L_0x0c8d:
            r4 = 0
            goto L_0x0cf4
        L_0x0c8f:
            int r2 = r9.M0()     // Catch:{ all -> 0x0a7b }
            if (r2 <= 0) goto L_0x0c8d
            long r2 = r0.B0()     // Catch:{ all -> 0x0a7b }
            int r4 = (r2 > r45 ? 1 : (r2 == r45 ? 0 : -1))
            if (r4 == 0) goto L_0x0ca1
            r9.r(r2)     // Catch:{ all -> 0x0a7b }
            goto L_0x0ca4
        L_0x0ca1:
            r9.s()     // Catch:{ all -> 0x0a7b }
        L_0x0ca4:
            long r4 = r0.z0()     // Catch:{ all -> 0x0a7b }
            int r6 = (r4 > r45 ? 1 : (r4 == r45 ? 0 : -1))
            if (r6 != 0) goto L_0x0cad
            goto L_0x0cae
        L_0x0cad:
            r2 = r4
        L_0x0cae:
            int r4 = (r2 > r45 ? 1 : (r2 == r45 ? 0 : -1))
            if (r4 == 0) goto L_0x0cb6
            r9.i1(r2)     // Catch:{ all -> 0x0a7b }
            goto L_0x0cb9
        L_0x0cb6:
            r9.j1()     // Catch:{ all -> 0x0a7b }
        L_0x0cb9:
            int r2 = r9.M0()     // Catch:{ all -> 0x0a7b }
            long r2 = (long) r2     // Catch:{ all -> 0x0a7b }
            r0.m(r2)     // Catch:{ all -> 0x0a7b }
            long r2 = r0.G()     // Catch:{ all -> 0x0a7b }
            int r2 = (int) r2     // Catch:{ all -> 0x0a7b }
            r9.d0(r2)     // Catch:{ all -> 0x0a7b }
            long r2 = r0.g()     // Catch:{ all -> 0x0a7b }
            int r2 = (int) r2     // Catch:{ all -> 0x0a7b }
            r9.S(r2)     // Catch:{ all -> 0x0a7b }
            long r2 = r9.e1()     // Catch:{ all -> 0x0a7b }
            r0.A0(r2)     // Catch:{ all -> 0x0a7b }
            long r2 = r9.g1()     // Catch:{ all -> 0x0a7b }
            r0.C0(r2)     // Catch:{ all -> 0x0a7b }
            java.lang.String r2 = r0.N()     // Catch:{ all -> 0x0a7b }
            if (r2 == 0) goto L_0x0ce9
            r9.l0(r2)     // Catch:{ all -> 0x0a7b }
            goto L_0x0cec
        L_0x0ce9:
            r9.m0()     // Catch:{ all -> 0x0a7b }
        L_0x0cec:
            com.google.android.gms.measurement.internal.u r2 = r43.F0()     // Catch:{ all -> 0x0a7b }
            r4 = 0
            r2.K0(r0, r4, r4)     // Catch:{ all -> 0x0a7b }
        L_0x0cf4:
            int r0 = r9.M0()     // Catch:{ all -> 0x0a7b }
            if (r0 <= 0) goto L_0x0d5c
            r2 = r43
            com.google.android.gms.measurement.internal.X2 r0 = r2.f6668l     // Catch:{ all -> 0x0d20 }
            r0.c()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.P2 r0 = r2.D0()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.internal.measurement.a3 r3 = r15.f6555a     // Catch:{ all -> 0x0d20 }
            java.lang.String r3 = r3.F()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.internal.measurement.g2 r0 = r0.w(r3)     // Catch:{ all -> 0x0d20 }
            if (r0 == 0) goto L_0x0d23
            boolean r3 = r0.F()     // Catch:{ all -> 0x0d20 }
            if (r3 != 0) goto L_0x0d18
            goto L_0x0d23
        L_0x0d18:
            long r5 = r0.G()     // Catch:{ all -> 0x0d20 }
            r9.w0(r5)     // Catch:{ all -> 0x0d20 }
            goto L_0x0d4c
        L_0x0d20:
            r0 = move-exception
            goto L_0x0e06
        L_0x0d23:
            com.google.android.gms.internal.measurement.a3 r0 = r15.f6555a     // Catch:{ all -> 0x0d20 }
            java.lang.String r0 = r0.U()     // Catch:{ all -> 0x0d20 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0d20 }
            if (r0 == 0) goto L_0x0d35
            r5 = -1
            r9.w0(r5)     // Catch:{ all -> 0x0d20 }
            goto L_0x0d4c
        L_0x0d35:
            com.google.android.gms.measurement.internal.q2 r0 = r2.a()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x0d20 }
            java.lang.String r3 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.a3 r5 = r15.f6555a     // Catch:{ all -> 0x0d20 }
            java.lang.String r5 = r5.F()     // Catch:{ all -> 0x0d20 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.C1402q2.x(r5)     // Catch:{ all -> 0x0d20 }
            r0.b(r3, r5)     // Catch:{ all -> 0x0d20 }
        L_0x0d4c:
            com.google.android.gms.measurement.internal.u r0 = r2.F0()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.internal.measurement.e5 r3 = r9.o()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.internal.measurement.a3 r3 = (com.google.android.gms.internal.measurement.C1051a3) r3     // Catch:{ all -> 0x0d20 }
            r10 = r16
            r0.O0(r3, r10)     // Catch:{ all -> 0x0d20 }
            goto L_0x0d5e
        L_0x0d5c:
            r2 = r43
        L_0x0d5e:
            com.google.android.gms.measurement.internal.u r0 = r2.F0()     // Catch:{ all -> 0x0d20 }
            java.util.List r3 = r15.f6556b     // Catch:{ all -> 0x0d20 }
            N.C0722p.k(r3)     // Catch:{ all -> 0x0d20 }
            r0.h()     // Catch:{ all -> 0x0d20 }
            r0.j()     // Catch:{ all -> 0x0d20 }
            java.lang.String r5 = "rowid in ("
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d20 }
            r6.<init>(r5)     // Catch:{ all -> 0x0d20 }
            r10 = r4
        L_0x0d75:
            int r4 = r3.size()     // Catch:{ all -> 0x0d20 }
            if (r10 >= r4) goto L_0x0d92
            if (r10 == 0) goto L_0x0d82
            java.lang.String r4 = ","
            r6.append(r4)     // Catch:{ all -> 0x0d20 }
        L_0x0d82:
            java.lang.Object r4 = r3.get(r10)     // Catch:{ all -> 0x0d20 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0d20 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0d20 }
            r6.append(r4)     // Catch:{ all -> 0x0d20 }
            int r10 = r10 + 1
            goto L_0x0d75
        L_0x0d92:
            java.lang.String r4 = ")"
            r6.append(r4)     // Catch:{ all -> 0x0d20 }
            android.database.sqlite.SQLiteDatabase r4 = r0.u0()     // Catch:{ all -> 0x0d20 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0d20 }
            java.lang.String r6 = "raw_events"
            r10 = 0
            int r4 = r4.delete(r6, r5, r10)     // Catch:{ all -> 0x0d20 }
            int r5 = r3.size()     // Catch:{ all -> 0x0d20 }
            if (r4 == r5) goto L_0x0dc7
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0d20 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0d20 }
            int r3 = r3.size()     // Catch:{ all -> 0x0d20 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d20 }
            java.lang.String r5 = "Deleted fewer rows from raw events table than expected"
            r0.c(r5, r4, r3)     // Catch:{ all -> 0x0d20 }
        L_0x0dc7:
            com.google.android.gms.measurement.internal.u r3 = r2.F0()     // Catch:{ all -> 0x0d20 }
            android.database.sqlite.SQLiteDatabase r0 = r3.u0()     // Catch:{ all -> 0x0d20 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            java.lang.String[] r5 = new java.lang.String[]{r1, r1}     // Catch:{ SQLiteException -> 0x0dd9 }
            r0.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x0dd9 }
            goto L_0x0ded
        L_0x0dd9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0d20 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0d20 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.C1402q2.x(r1)     // Catch:{ all -> 0x0d20 }
            r3.c(r4, r1, r0)     // Catch:{ all -> 0x0d20 }
        L_0x0ded:
            com.google.android.gms.measurement.internal.u r0 = r2.F0()     // Catch:{ all -> 0x0d20 }
            r0.s0()     // Catch:{ all -> 0x0d20 }
            r10 = r12
            goto L_0x0dfe
        L_0x0df6:
            com.google.android.gms.measurement.internal.u r0 = r2.F0()     // Catch:{ all -> 0x0d20 }
            r0.s0()     // Catch:{ all -> 0x0d20 }
            r10 = r4
        L_0x0dfe:
            com.google.android.gms.measurement.internal.u r0 = r2.F0()
            r0.t0()
            return r10
        L_0x0e06:
            com.google.android.gms.measurement.internal.u r1 = r2.F0()
            r1.t0()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.M(java.lang.String, long):boolean");
    }

    private final void N(Z2 z22, long j5, boolean z4) {
        String str;
        x6 x6Var;
        String str2;
        Object obj;
        if (true != z4) {
            str = "_lte";
        } else {
            str = "_se";
        }
        String str3 = str;
        x6 B02 = F0().B0(z22.D(), str3);
        if (B02 == null || (obj = B02.f6896e) == null) {
            x6Var = new x6(z22.D(), "auto", str3, f().currentTimeMillis(), Long.valueOf(j5));
        } else {
            x6Var = new x6(z22.D(), "auto", str3, f().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j5));
        }
        C1195q3 Q4 = C1203r3.Q();
        Q4.s(str3);
        Q4.r(f().currentTimeMillis());
        Object obj2 = x6Var.f6896e;
        Q4.x(((Long) obj2).longValue());
        C1203r3 r3Var = (C1203r3) Q4.o();
        int X4 = u6.X(z22, str3);
        if (X4 >= 0) {
            z22.X0(X4, r3Var);
        } else {
            z22.Y0(r3Var);
        }
        if (j5 > 0) {
            F0().A0(x6Var);
            if (true != z4) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            a().w().c("Updated engagement user property. scope, value", str2, obj2);
        }
    }

    private final boolean O(N2 n22, N2 n23) {
        String str;
        C0722p.a("_e".equals(n22.D()));
        K0();
        S2 r5 = u6.r((O2) n22.o(), "_sc");
        String str2 = null;
        if (r5 == null) {
            str = null;
        } else {
            str = r5.I();
        }
        K0();
        S2 r6 = u6.r((O2) n23.o(), "_pc");
        if (r6 != null) {
            str2 = r6.I();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        C0722p.a("_e".equals(n22.D()));
        K0();
        S2 r7 = u6.r((O2) n22.o(), "_et");
        if (r7 == null || !r7.J() || r7.K() <= 0) {
            return true;
        }
        long K4 = r7.K();
        K0();
        S2 r8 = u6.r((O2) n23.o(), "_et");
        if (r8 != null && r8.K() > 0) {
            K4 += r8.K();
        }
        K0();
        u6.o(n23, "_et", Long.valueOf(K4));
        K0();
        u6.o(n22, "_fr", 1L);
        return true;
    }

    private final boolean P() {
        b().h();
        O0();
        if (F0().B() || !TextUtils.isEmpty(F0().r())) {
            return true;
        }
        return false;
    }

    private static String Q(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (!((List) entry.getValue()).isEmpty()) {
                    return (String) ((List) entry.getValue()).get(0);
                }
                return null;
            }
        }
        return null;
    }

    private final void R() {
        long j5;
        long j6;
        b().h();
        O0();
        if (this.f6671o > 0) {
            long abs = 3600000 - Math.abs(f().elapsedRealtime() - this.f6671o);
            if (abs > 0) {
                a().w().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                G0().b();
                H0().n();
                return;
            }
            this.f6671o = 0;
        }
        if (!this.f6668l.m() || !P()) {
            a().w().a("Nothing to upload or uploading impossible");
            G0().b();
            H0().n();
            return;
        }
        long currentTimeMillis = f().currentTimeMillis();
        B0();
        long max = Math.max(0, ((Long) C1304d2.f6290P.b((Object) null)).longValue());
        boolean z4 = true;
        if (!F0().D() && !F0().s()) {
            z4 = false;
        }
        if (z4) {
            String i5 = B0().i();
            if (TextUtils.isEmpty(i5) || ".none.".equals(i5)) {
                B0();
                j5 = Math.max(0, ((Long) C1304d2.f6278J.b((Object) null)).longValue());
            } else {
                B0();
                j5 = Math.max(0, ((Long) C1304d2.f6280K.b((Object) null)).longValue());
            }
        } else {
            B0();
            j5 = Math.max(0, ((Long) C1304d2.f6276I.b((Object) null)).longValue());
        }
        long a5 = this.f6665i.f6914h.a();
        long a6 = this.f6665i.f6915i.a();
        long j7 = 0;
        boolean z5 = z4;
        long max2 = Math.max(F0().y(), F0().A());
        if (max2 == 0) {
            j6 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(a5 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(a6 - currentTimeMillis);
            j6 = max + abs2;
            long max3 = Math.max(abs3, abs4);
            if (z5 && max3 > 0) {
                j6 = Math.min(abs2, max3) + j5;
            }
            if (!K0().S(max3, j5)) {
                j6 = max3 + j5;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i6 = 0;
                while (true) {
                    B0();
                    if (i6 >= Math.min(20, Math.max(0, ((Integer) C1304d2.f6294R.b((Object) null)).intValue()))) {
                        j6 = 0;
                        break;
                    }
                    B0();
                    j6 += Math.max(j7, ((Long) C1304d2.f6292Q.b((Object) null)).longValue()) * (1 << i6);
                    if (j6 > abs4) {
                        break;
                    }
                    i6++;
                    j7 = 0;
                }
            }
            j7 = 0;
        }
        if (j6 == j7) {
            a().w().a("Next upload time is 0");
            G0().b();
            H0().n();
        } else if (E0().m()) {
            long a7 = this.f6665i.f6913g.a();
            B0();
            long max4 = Math.max(0, ((Long) C1304d2.f6272G.b((Object) null)).longValue());
            if (!K0().S(a7, max4)) {
                j6 = Math.max(j6, a7 + max4);
            }
            G0().b();
            long currentTimeMillis2 = j6 - f().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                B0();
                currentTimeMillis2 = Math.max(0, ((Long) C1304d2.f6282L.b((Object) null)).longValue());
                this.f6665i.f6914h.b(f().currentTimeMillis());
            }
            a().w().b("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            H0().m(currentTimeMillis2);
        } else {
            a().w().a("No network");
            G0().a();
            H0().n();
        }
    }

    private final void S() {
        b().h();
        if (this.f6676t || this.f6677u || this.f6678v) {
            a().w().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f6676t), Boolean.valueOf(this.f6677u), Boolean.valueOf(this.f6678v));
            return;
        }
        a().w().a("Stopping uploading service(s)");
        List<Runnable> list = this.f6672p;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) C0722p.k(this.f6672p)).clear();
        }
    }

    private final Boolean T(C1443w2 w2Var) {
        try {
            if (w2Var.F0() != -2147483648L) {
                if (w2Var.F0() == ((long) e.a(this.f6668l.e()).e(w2Var.o0(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = e.a(this.f6668l.e()).e(w2Var.o0(), 0).versionName;
                String D02 = w2Var.D0();
                if (D02 != null && D02.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final B6 U(String str) {
        String str2 = str;
        C1443w2 J02 = F0().J0(str2);
        if (J02 == null || TextUtils.isEmpty(J02.D0())) {
            a().v().b("No app data available; dropping", str2);
            return null;
        }
        Boolean T4 = T(J02);
        if (T4 == null || T4.booleanValue()) {
            C1443w2 w2Var = J02;
            C1443w2 w2Var2 = w2Var;
            C1443w2 w2Var3 = w2Var2;
            C1443w2 w2Var4 = w2Var3;
            C1443w2 w2Var5 = w2Var4;
            return new B6(str2, w2Var.r0(), w2Var.D0(), w2Var2.F0(), w2Var3.H0(), w2Var4.J0(), w2Var5.L0(), (String) null, w2Var5.d(), false, w2Var5.x0(), 0, 0, w2Var5.P(), false, w2Var5.R(), w2Var5.b(), w2Var5.T(), g(str).l(), "", (String) null, w2Var5.V(), w2Var5.X(), g(str).b(), R0(str).e(), w2Var5.b0(), w2Var5.j0(), w2Var5.l0(), w2Var5.I(), 0, w2Var5.M());
        }
        a().o().b("App version does not match; dropping. appId", C1402q2.x(str2));
        return null;
    }

    private final boolean V(String str, String str2) {
        C v02 = F0().v0(str, str2);
        if (v02 == null || v02.f5793c < 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void W(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, (String) null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean X(B6 b6) {
        if (!TextUtils.isEmpty(b6.f5766b)) {
            return true;
        }
        return false;
    }

    private static final C1292b6 Y(C1292b6 b6Var) {
        if (b6Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (b6Var.i()) {
            return b6Var;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(b6Var.getClass())));
        }
    }

    private static final Boolean Z(B6 b6) {
        Boolean bool = b6.f5780p;
        String str = b6.f5762C;
        if (!TextUtils.isEmpty(str)) {
            v a5 = C1303d1.c(str).a();
            v vVar = v.UNINITIALIZED;
            int ordinal = a5.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return Boolean.TRUE;
            }
            if (ordinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r2 != null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A(boolean r19, int r20, java.lang.Throwable r21, byte[] r22, java.lang.String r23, java.util.List r24) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            r2 = r21
            com.google.android.gms.measurement.internal.T2 r3 = r1.b()
            r3.h()
            r1.O0()
            r9 = 0
            if (r22 != 0) goto L_0x0019
            byte[] r3 = new byte[r9]     // Catch:{ all -> 0x0016 }
            goto L_0x001b
        L_0x0016:
            r0 = move-exception
            goto L_0x0297
        L_0x0019:
            r3 = r22
        L_0x001b:
            java.util.List r4 = r1.f6681y     // Catch:{ all -> 0x0016 }
            java.lang.Object r4 = N.C0722p.k(r4)     // Catch:{ all -> 0x0016 }
            r10 = r4
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0016 }
            r11 = 0
            r1.f6681y = r11     // Catch:{ all -> 0x0016 }
            if (r19 == 0) goto L_0x008c
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == r4) goto L_0x0032
            r4 = 204(0xcc, float:2.86E-43)
            if (r0 != r4) goto L_0x0034
            r0 = r4
        L_0x0032:
            if (r2 == 0) goto L_0x008c
        L_0x0034:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0016 }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0016 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0016 }
            int r3 = r4.length()     // Catch:{ all -> 0x0016 }
            r5 = 32
            int r3 = java.lang.Math.min(r5, r3)     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = r4.substring(r9, r3)     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.q2 r4 = r1.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.t()     // Catch:{ all -> 0x0016 }
            java.lang.String r5 = "Network upload failed. Will retry later. code, error"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0016 }
            r4.d(r5, r6, r2, r3)     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.y5 r2 = r1.f6665i     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.B2 r2 = r2.f6915i     // Catch:{ all -> 0x0016 }
            com.google.android.gms.common.util.d r3 = r1.f()     // Catch:{ all -> 0x0016 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0016 }
            r2.b(r3)     // Catch:{ all -> 0x0016 }
            r2 = 503(0x1f7, float:7.05E-43)
            if (r0 == r2) goto L_0x0071
            r2 = 429(0x1ad, float:6.01E-43)
            if (r0 != r2) goto L_0x0080
        L_0x0071:
            com.google.android.gms.measurement.internal.y5 r0 = r1.f6665i     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.B2 r0 = r0.f6913g     // Catch:{ all -> 0x0016 }
            com.google.android.gms.common.util.d r2 = r1.f()     // Catch:{ all -> 0x0016 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0016 }
            r0.b(r2)     // Catch:{ all -> 0x0016 }
        L_0x0080:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0016 }
            r0.v(r10)     // Catch:{ all -> 0x0016 }
            r1.R()     // Catch:{ all -> 0x0016 }
            goto L_0x0291
        L_0x008c:
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ all -> 0x0016 }
            java.lang.String r4 = "Network upload successful with code, uploadAttempted"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0016 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r19)     // Catch:{ all -> 0x0016 }
            r2.c(r4, r0, r5)     // Catch:{ all -> 0x0016 }
            if (r19 == 0) goto L_0x00b6
            com.google.android.gms.measurement.internal.y5 r2 = r1.f6665i     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.measurement.internal.B2 r2 = r2.f6914h     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.common.util.d r4 = r1.f()     // Catch:{ SQLiteException -> 0x00b3 }
            long r4 = r4.currentTimeMillis()     // Catch:{ SQLiteException -> 0x00b3 }
            r2.b(r4)     // Catch:{ SQLiteException -> 0x00b3 }
            goto L_0x00b6
        L_0x00b3:
            r0 = move-exception
            goto L_0x0267
        L_0x00b6:
            com.google.android.gms.measurement.internal.y5 r2 = r1.f6665i     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.measurement.internal.B2 r2 = r2.f6915i     // Catch:{ SQLiteException -> 0x00b3 }
            r12 = 0
            r2.b(r12)     // Catch:{ SQLiteException -> 0x00b3 }
            r1.R()     // Catch:{ SQLiteException -> 0x00b3 }
            if (r19 == 0) goto L_0x00d7
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r4 = "Successful upload. Got network response. code, size"
            int r3 = r3.length     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00b3 }
            r2.c(r4, r0, r3)     // Catch:{ SQLiteException -> 0x00b3 }
            goto L_0x00e4
        L_0x00d7:
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r2 = "Purged empty bundles"
            r0.a(r2)     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x00e4:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ SQLiteException -> 0x00b3 }
            r0.r0()     // Catch:{ SQLiteException -> 0x00b3 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0155 }
            r0.<init>()     // Catch:{ all -> 0x0155 }
            java.util.Iterator r14 = r24.iterator()     // Catch:{ all -> 0x0155 }
        L_0x00f4:
            boolean r2 = r14.hasNext()     // Catch:{ all -> 0x0155 }
            r3 = -1
            if (r2 == 0) goto L_0x0158
            java.lang.Object r2 = r14.next()     // Catch:{ all -> 0x0155 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0155 }
            java.lang.Object r5 = r2.first     // Catch:{ all -> 0x0155 }
            com.google.android.gms.internal.measurement.Y2 r5 = (com.google.android.gms.internal.measurement.Y2) r5     // Catch:{ all -> 0x0155 }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0155 }
            r15 = r2
            com.google.android.gms.measurement.internal.c6 r15 = (com.google.android.gms.measurement.internal.C1300c6) r15     // Catch:{ all -> 0x0155 }
            f0.K r2 = r15.c()     // Catch:{ all -> 0x0155 }
            f0.K r6 = f0.C1643K.SGTM_CLIENT     // Catch:{ all -> 0x0155 }
            if (r2 == r6) goto L_0x00f4
            com.google.android.gms.measurement.internal.u r2 = r1.F0()     // Catch:{ all -> 0x0155 }
            r6 = r3
            r4 = r5
            java.lang.String r5 = r15.a()     // Catch:{ all -> 0x0155 }
            r7 = r6
            java.util.Map r6 = r15.b()     // Catch:{ all -> 0x0155 }
            r16 = r7
            f0.K r7 = r15.c()     // Catch:{ all -> 0x0155 }
            r8 = 0
            r3 = r23
            r12 = r16
            long r5 = r2.m(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0155 }
            f0.K r2 = r15.c()     // Catch:{ all -> 0x0155 }
            f0.K r3 = f0.C1643K.GOOGLE_SIGNAL_PENDING     // Catch:{ all -> 0x0155 }
            if (r2 != r3) goto L_0x0152
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0152
            java.lang.String r2 = r4.J()     // Catch:{ all -> 0x0155 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0155 }
            if (r2 != 0) goto L_0x0152
            java.lang.String r2 = r4.J()     // Catch:{ all -> 0x0155 }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0155 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0155 }
        L_0x0152:
            r12 = 0
            goto L_0x00f4
        L_0x0155:
            r0 = move-exception
            goto L_0x025f
        L_0x0158:
            r12 = r3
            java.util.Iterator r14 = r24.iterator()     // Catch:{ all -> 0x0155 }
        L_0x015d:
            boolean r2 = r14.hasNext()     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x019f
            java.lang.Object r2 = r14.next()     // Catch:{ all -> 0x0155 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = r2.first     // Catch:{ all -> 0x0155 }
            r4 = r3
            com.google.android.gms.internal.measurement.Y2 r4 = (com.google.android.gms.internal.measurement.Y2) r4     // Catch:{ all -> 0x0155 }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.c6 r2 = (com.google.android.gms.measurement.internal.C1300c6) r2     // Catch:{ all -> 0x0155 }
            f0.K r3 = r2.c()     // Catch:{ all -> 0x0155 }
            f0.K r5 = f0.C1643K.SGTM_CLIENT     // Catch:{ all -> 0x0155 }
            if (r3 != r5) goto L_0x019c
            java.lang.String r3 = r4.J()     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0155 }
            r8 = r3
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0155 }
            r3 = r2
            com.google.android.gms.measurement.internal.u r2 = r1.F0()     // Catch:{ all -> 0x0155 }
            java.lang.String r5 = r3.a()     // Catch:{ all -> 0x0155 }
            java.util.Map r6 = r3.b()     // Catch:{ all -> 0x0155 }
            f0.K r7 = r3.c()     // Catch:{ all -> 0x0155 }
            r3 = r23
            r2.m(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0155 }
            goto L_0x015d
        L_0x019c:
            r3 = r23
            goto L_0x015d
        L_0x019f:
            r3 = r23
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0155 }
            r2 = 1
            f0.K[] r4 = new f0.C1643K[r2]     // Catch:{ all -> 0x0155 }
            f0.K r5 = f0.C1643K.SGTM_CLIENT     // Catch:{ all -> 0x0155 }
            r4[r9] = r5     // Catch:{ all -> 0x0155 }
            f0.N r4 = f0.N.c(r4)     // Catch:{ all -> 0x0155 }
            java.util.List r0 = r0.o(r3, r4, r2)     // Catch:{ all -> 0x0155 }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0155 }
            if (r2 != 0) goto L_0x01ee
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.t6 r0 = (com.google.android.gms.measurement.internal.t6) r0     // Catch:{ all -> 0x0155 }
            long r4 = r0.g()     // Catch:{ all -> 0x0155 }
            com.google.android.gms.common.util.d r0 = r1.f()     // Catch:{ all -> 0x0155 }
            long r6 = r0.currentTimeMillis()     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.c2 r0 = com.google.android.gms.measurement.internal.C1304d2.f6270F     // Catch:{ all -> 0x0155 }
            java.lang.Object r0 = r0.b(r11)     // Catch:{ all -> 0x0155 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0155 }
            long r14 = r0.longValue()     // Catch:{ all -> 0x0155 }
            long r14 = r14 + r4
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x01ee
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = "[sgtm] client batches are queued too long. appId, creationTime"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0155 }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x0155 }
        L_0x01ee:
            java.util.Iterator r2 = r10.iterator()     // Catch:{ all -> 0x0155 }
        L_0x01f2:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0155 }
            if (r0 == 0) goto L_0x0218
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0155 }
            r4 = r0
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ SQLiteException -> 0x020b }
            long r5 = r4.longValue()     // Catch:{ SQLiteException -> 0x020b }
            r0.t(r5)     // Catch:{ SQLiteException -> 0x020b }
            goto L_0x01f2
        L_0x020b:
            r0 = move-exception
            java.util.List r5 = r1.f6682z     // Catch:{ all -> 0x0155 }
            if (r5 == 0) goto L_0x0217
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x0155 }
            if (r4 == 0) goto L_0x0217
            goto L_0x01f2
        L_0x0217:
            throw r0     // Catch:{ all -> 0x0155 }
        L_0x0218:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0155 }
            r0.s0()     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ SQLiteException -> 0x00b3 }
            r0.t0()     // Catch:{ SQLiteException -> 0x00b3 }
            r1.f6682z = r11     // Catch:{ SQLiteException -> 0x00b3 }
            com.google.android.gms.measurement.internal.v2 r0 = r1.E0()     // Catch:{ SQLiteException -> 0x00b3 }
            boolean r0 = r0.m()     // Catch:{ SQLiteException -> 0x00b3 }
            if (r0 == 0) goto L_0x0242
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ SQLiteException -> 0x00b3 }
            boolean r0 = r0.p(r3)     // Catch:{ SQLiteException -> 0x00b3 }
            if (r0 == 0) goto L_0x0242
            r1.u(r3)     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x023f:
            r2 = 0
            goto L_0x025c
        L_0x0242:
            com.google.android.gms.measurement.internal.v2 r0 = r1.E0()     // Catch:{ SQLiteException -> 0x00b3 }
            boolean r0 = r0.m()     // Catch:{ SQLiteException -> 0x00b3 }
            if (r0 == 0) goto L_0x0256
            boolean r0 = r1.P()     // Catch:{ SQLiteException -> 0x00b3 }
            if (r0 == 0) goto L_0x0256
            r1.r()     // Catch:{ SQLiteException -> 0x00b3 }
            goto L_0x023f
        L_0x0256:
            r1.f6647A = r12     // Catch:{ SQLiteException -> 0x00b3 }
            r1.R()     // Catch:{ SQLiteException -> 0x00b3 }
            goto L_0x023f
        L_0x025c:
            r1.f6671o = r2     // Catch:{ SQLiteException -> 0x00b3 }
            goto L_0x0291
        L_0x025f:
            com.google.android.gms.measurement.internal.u r2 = r1.F0()     // Catch:{ SQLiteException -> 0x00b3 }
            r2.t0()     // Catch:{ SQLiteException -> 0x00b3 }
            throw r0     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x0267:
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = "Database error while trying to delete uploaded bundles"
            r2.b(r3, r0)     // Catch:{ all -> 0x0016 }
            com.google.android.gms.common.util.d r0 = r1.f()     // Catch:{ all -> 0x0016 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0016 }
            r1.f6671o = r2     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ all -> 0x0016 }
            java.lang.String r2 = "Disable upload, time"
            long r3 = r1.f6671o     // Catch:{ all -> 0x0016 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0016 }
            r0.b(r2, r3)     // Catch:{ all -> 0x0016 }
        L_0x0291:
            r1.f6677u = r9
            r1.S()
            return
        L_0x0297:
            r1.f6677u = r9
            r1.S()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.A(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: protected */
    public final void A0() {
        b().h();
        F0().u();
        C1426u F02 = F0();
        F02.h();
        F02.j();
        if (F02.a0()) {
            C1296c2 c2Var = C1304d2.f6369w0;
            if (((Long) c2Var.b((Object) null)).longValue() != 0) {
                SQLiteDatabase u02 = F02.u0();
                X2 x22 = F02.f5730a;
                int delete = u02.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(x22.f().currentTimeMillis()), String.valueOf(c2Var.b((Object) null))});
                if (delete > 0) {
                    x22.a().w().b("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.f6665i.f6914h.a() == 0) {
            this.f6665i.f6914h.b(f().currentTimeMillis());
        }
        R();
    }

    /* access modifiers changed from: package-private */
    public final void B(C1443w2 w2Var) {
        b().h();
        if (TextUtils.isEmpty(w2Var.r0())) {
            C((String) C0722p.k(w2Var.o0()), 204, (Throwable) null, (byte[]) null, (Map) null);
            return;
        }
        String str = (String) C0722p.k(w2Var.o0());
        a().w().b("Fetching remote configuration", str);
        C1104g2 w4 = D0().w(str);
        String y4 = D0().y(str);
        ArrayMap arrayMap = null;
        if (w4 != null) {
            if (!TextUtils.isEmpty(y4)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", y4);
            }
            String z4 = D0().z(str);
            if (!TextUtils.isEmpty(z4)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put("If-None-Match", z4);
            }
        }
        this.f6676t = true;
        E0().o(w2Var, arrayMap, new p6(this));
    }

    public final C1371m B0() {
        return ((X2) C0722p.k(this.f6668l)).w();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010b A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012c A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130 A[Catch:{ all -> 0x005f, all -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r6.b()
            r0.h()
            r6.O0()
            N.C0722p.e(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0016
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r7 = move-exception
            goto L_0x016f
        L_0x0016:
            com.google.android.gms.measurement.internal.q2 r1 = r6.a()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0013 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0013 }
            r1.b(r2, r3)     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.u r1 = r6.F0()     // Catch:{ all -> 0x0013 }
            r1.r0()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.u r1 = r6.F0()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.w2 r1 = r1.J0(r7)     // Catch:{ all -> 0x005f }
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r2) goto L_0x0047
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x0047
            if (r8 != r4) goto L_0x0045
            r8 = r4
            goto L_0x0047
        L_0x0045:
            r2 = r0
            goto L_0x004a
        L_0x0047:
            if (r9 != 0) goto L_0x0045
            r2 = 1
        L_0x004a:
            if (r1 != 0) goto L_0x0062
            com.google.android.gms.measurement.internal.q2 r8 = r6.a()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.o2 r8 = r8.r()     // Catch:{ all -> 0x005f }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C1402q2.x(r7)     // Catch:{ all -> 0x005f }
            r8.b(r9, r7)     // Catch:{ all -> 0x005f }
            goto L_0x0153
        L_0x005f:
            r7 = move-exception
            goto L_0x0167
        L_0x0062:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00be
            if (r8 != r5) goto L_0x0069
            goto L_0x00be
        L_0x0069:
            com.google.android.gms.common.util.d r10 = r6.f()     // Catch:{ all -> 0x005f }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x005f }
            r1.k(r10)     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.u r10 = r6.F0()     // Catch:{ all -> 0x005f }
            r10.K0(r1, r0, r0)     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.q2 r10 = r6.a()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.o2 r10 = r10.w()     // Catch:{ all -> 0x005f }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x005f }
            r10.c(r11, r1, r9)     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.P2 r9 = r6.D0()     // Catch:{ all -> 0x005f }
            r9.A(r7)     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.y5 r7 = r6.f6665i     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.B2 r7 = r7.f6915i     // Catch:{ all -> 0x005f }
            com.google.android.gms.common.util.d r9 = r6.f()     // Catch:{ all -> 0x005f }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x005f }
            r7.b(r9)     // Catch:{ all -> 0x005f }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00aa
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b9
        L_0x00aa:
            com.google.android.gms.measurement.internal.y5 r7 = r6.f6665i     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.B2 r7 = r7.f6913g     // Catch:{ all -> 0x005f }
            com.google.android.gms.common.util.d r8 = r6.f()     // Catch:{ all -> 0x005f }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x005f }
            r7.b(r8)     // Catch:{ all -> 0x005f }
        L_0x00b9:
            r6.R()     // Catch:{ all -> 0x005f }
            goto L_0x0153
        L_0x00be:
            java.lang.String r9 = "Last-Modified"
            java.lang.String r9 = Q(r11, r9)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = "ETag"
            java.lang.String r11 = Q(r11, r2)     // Catch:{ all -> 0x005f }
            if (r8 == r5) goto L_0x00d7
            if (r8 != r4) goto L_0x00cf
            goto L_0x00d7
        L_0x00cf:
            com.google.android.gms.measurement.internal.P2 r2 = r6.D0()     // Catch:{ all -> 0x005f }
            r2.C(r7, r10, r9, r11)     // Catch:{ all -> 0x005f }
            goto L_0x00e9
        L_0x00d7:
            com.google.android.gms.measurement.internal.P2 r9 = r6.D0()     // Catch:{ all -> 0x005f }
            com.google.android.gms.internal.measurement.g2 r9 = r9.w(r7)     // Catch:{ all -> 0x005f }
            if (r9 != 0) goto L_0x00e9
            com.google.android.gms.measurement.internal.P2 r9 = r6.D0()     // Catch:{ all -> 0x005f }
            r10 = 0
            r9.C(r7, r10, r10, r10)     // Catch:{ all -> 0x005f }
        L_0x00e9:
            com.google.android.gms.common.util.d r9 = r6.f()     // Catch:{ all -> 0x005f }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x005f }
            r1.i(r9)     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.u r9 = r6.F0()     // Catch:{ all -> 0x005f }
            r9.K0(r1, r0, r0)     // Catch:{ all -> 0x005f }
            if (r8 != r5) goto L_0x010b
            com.google.android.gms.measurement.internal.q2 r8 = r6.a()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.o2 r8 = r8.t()     // Catch:{ all -> 0x005f }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.b(r9, r7)     // Catch:{ all -> 0x005f }
            goto L_0x011c
        L_0x010b:
            com.google.android.gms.measurement.internal.q2 r7 = r6.a()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.o2 r7 = r7.w()     // Catch:{ all -> 0x005f }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x005f }
            r7.c(r9, r8, r3)     // Catch:{ all -> 0x005f }
        L_0x011c:
            com.google.android.gms.measurement.internal.v2 r7 = r6.E0()     // Catch:{ all -> 0x005f }
            boolean r7 = r7.m()     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x0130
            boolean r7 = r6.P()     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x0130
            r6.r()     // Catch:{ all -> 0x005f }
            goto L_0x0153
        L_0x0130:
            com.google.android.gms.measurement.internal.v2 r7 = r6.E0()     // Catch:{ all -> 0x005f }
            boolean r7 = r7.m()     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x0150
            com.google.android.gms.measurement.internal.u r7 = r6.F0()     // Catch:{ all -> 0x005f }
            java.lang.String r8 = r1.o0()     // Catch:{ all -> 0x005f }
            boolean r7 = r7.p(r8)     // Catch:{ all -> 0x005f }
            if (r7 == 0) goto L_0x0150
            java.lang.String r7 = r1.o0()     // Catch:{ all -> 0x005f }
            r6.u(r7)     // Catch:{ all -> 0x005f }
            goto L_0x0153
        L_0x0150:
            r6.R()     // Catch:{ all -> 0x005f }
        L_0x0153:
            com.google.android.gms.measurement.internal.u r7 = r6.F0()     // Catch:{ all -> 0x005f }
            r7.s0()     // Catch:{ all -> 0x005f }
            com.google.android.gms.measurement.internal.u r7 = r6.F0()     // Catch:{ all -> 0x0013 }
            r7.t0()     // Catch:{ all -> 0x0013 }
            r6.f6676t = r0
            r6.S()
            return
        L_0x0167:
            com.google.android.gms.measurement.internal.u r8 = r6.F0()     // Catch:{ all -> 0x0013 }
            r8.t0()     // Catch:{ all -> 0x0013 }
            throw r7     // Catch:{ all -> 0x0013 }
        L_0x016f:
            r6.f6676t = r0
            r6.S()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.C(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final C1308d6 C0() {
        return this.f6666j;
    }

    /* access modifiers changed from: package-private */
    public final void D(Runnable runnable) {
        b().h();
        if (this.f6672p == null) {
            this.f6672p = new ArrayList();
        }
        this.f6672p.add(runnable);
    }

    public final P2 D0() {
        P2 p22 = this.f6657a;
        Y(p22);
        return p22;
    }

    /* access modifiers changed from: package-private */
    public final void E() {
        b().h();
        O0();
        if (!this.f6670n) {
            this.f6670n = true;
            if (a0()) {
                FileChannel fileChannel = this.f6680x;
                b().h();
                int i5 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    a().o().a("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i5 = allocate.getInt();
                        } else if (read != -1) {
                            a().r().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e5) {
                        a().o().b("Failed to read from channel", e5);
                    }
                }
                int t5 = this.f6668l.L().t();
                b().h();
                if (i5 > t5) {
                    a().o().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i5), Integer.valueOf(t5));
                } else if (i5 < t5) {
                    FileChannel fileChannel2 = this.f6680x;
                    b().h();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        a().o().a("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(t5);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                a().o().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            a().w().c("Storage version upgraded. Previous, current version", Integer.valueOf(i5), Integer.valueOf(t5));
                            return;
                        } catch (IOException e6) {
                            a().o().b("Failed to write to channel", e6);
                        }
                    }
                    a().o().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i5), Integer.valueOf(t5));
                }
            }
        }
    }

    public final C1436v2 E0() {
        C1436v2 v2Var = this.f6658b;
        Y(v2Var);
        return v2Var;
    }

    public final C1426u F0() {
        C1426u uVar = this.f6659c;
        Y(uVar);
        return uVar;
    }

    public final C1457y2 G0() {
        C1457y2 y2Var = this.f6660d;
        if (y2Var != null) {
            return y2Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final V5 H0() {
        V5 v5 = this.f6661e;
        Y(v5);
        return v5;
    }

    public final C1309e I0() {
        C1309e eVar = this.f6662f;
        Y(eVar);
        return eVar;
    }

    public final C4 J0() {
        C4 c42 = this.f6664h;
        Y(c42);
        return c42;
    }

    public final u6 K0() {
        u6 u6Var = this.f6663g;
        Y(u6Var);
        return u6Var;
    }

    public final C1460y5 L0() {
        return this.f6665i;
    }

    public final C1352j2 M0() {
        return this.f6668l.D();
    }

    public final z6 N0() {
        return ((X2) C0722p.k(this.f6668l)).C();
    }

    /* access modifiers changed from: package-private */
    public final void O0() {
        if (!this.f6669m.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void P0(B6 b6) {
        b().h();
        O0();
        String str = b6.f5765a;
        C0722p.e(str);
        E3 f5 = E3.f(b6.f5783s, b6.f5788x);
        g(str);
        a().w().c("Setting storage consent for package", str, f5);
        d(str, f5);
    }

    /* access modifiers changed from: package-private */
    public final void Q0(B6 b6) {
        boolean z4;
        b().h();
        O0();
        String str = b6.f5765a;
        C0722p.e(str);
        C1454y g5 = C1454y.g(b6.f5789y);
        a().w().c("Setting DMA consent for package", str, g5);
        b().h();
        O0();
        v c5 = C1454y.h(S0(str), 100).c();
        this.f6649C.put(str, g5);
        F0().V(str, g5);
        v c6 = C1454y.h(S0(str), 100).c();
        b().h();
        O0();
        v vVar = v.DENIED;
        boolean z5 = true;
        if (c5 == vVar && c6 == v.GRANTED) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!(c5 == v.GRANTED && c6 == vVar)) {
            z5 = false;
        }
        if (z4 || z5) {
            a().w().b("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (F0().L0(h(), str, false, false, false, false, false, false, false).f6623f < ((long) B0().E(str, C1304d2.f6351n0))) {
                bundle.putLong("_r", 1);
                a().w().c("_dcu realtime event count", str, Long.valueOf(F0().L0(h(), str, false, false, false, false, false, true, false).f6623f));
            }
            this.f6656J.b(str, "_dcu", bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final C1454y R0(String str) {
        b().h();
        O0();
        Map map = this.f6649C;
        C1454y yVar = (C1454y) map.get(str);
        if (yVar != null) {
            return yVar;
        }
        C1454y U4 = F0().U(str);
        map.put(str, U4);
        return U4;
    }

    /* access modifiers changed from: package-private */
    public final Bundle S0(String str) {
        int i5;
        String str2;
        b().h();
        O0();
        if (D0().R(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        E3 g5 = g(str);
        bundle.putAll(g5.n());
        bundle.putAll(T0(str, R0(str), g5, new C1385o()).f());
        x6 B02 = F0().B0(str, "_npa");
        if (B02 != null) {
            i5 = B02.f6896e.equals(1L);
        } else {
            i5 = I(str, new C1385o());
        }
        if (1 != i5) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final C1454y T0(String str, C1454y yVar, E3 e32, C1385o oVar) {
        v vVar;
        boolean z4;
        w wVar;
        v m5;
        int i5 = 90;
        if (D0().R(str) == null) {
            if (yVar.c() == v.DENIED) {
                i5 = yVar.b();
                oVar.b(w.AD_USER_DATA, i5);
            } else {
                oVar.c(w.AD_USER_DATA, C1378n.FAILSAFE);
            }
            return new C1454y(Boolean.FALSE, i5, Boolean.TRUE, "-");
        }
        v c5 = yVar.c();
        v vVar2 = v.GRANTED;
        if (c5 == vVar2 || c5 == (vVar = v.DENIED)) {
            i5 = yVar.b();
            oVar.b(w.AD_USER_DATA, i5);
        } else if (c5 != v.POLICY || (m5 = this.f6657a.m(str, wVar)) == v.UNINITIALIZED) {
            P2 p22 = this.f6657a;
            w wVar2 = w.AD_USER_DATA;
            w Q4 = p22.Q(str, wVar2);
            v p5 = e32.p();
            if (p5 == vVar2 || p5 == vVar) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (Q4 != w.AD_STORAGE || !z4) {
                oVar.c(wVar2, C1378n.REMOTE_DEFAULT);
                if (true != p22.P(str, wVar2)) {
                    c5 = vVar;
                } else {
                    c5 = vVar2;
                }
            } else {
                oVar.c(wVar2, C1378n.REMOTE_DELEGATION);
                c5 = p5;
            }
        } else {
            oVar.c((wVar = w.AD_USER_DATA), C1378n.REMOTE_ENFORCED_DEFAULT);
            c5 = m5;
        }
        boolean S4 = this.f6657a.S(str);
        SortedSet T4 = D0().T(str);
        if (c5 == v.DENIED || T4.isEmpty()) {
            return new C1454y(Boolean.FALSE, i5, Boolean.valueOf(S4), "-");
        }
        Boolean bool = Boolean.TRUE;
        Boolean valueOf = Boolean.valueOf(S4);
        String str2 = "";
        if (S4) {
            str2 = TextUtils.join(str2, T4);
        }
        return new C1454y(bool, i5, valueOf, str2);
    }

    public final C1402q2 a() {
        return ((X2) C0722p.k(this.f6668l)).a();
    }

    /* access modifiers changed from: package-private */
    public final boolean a0() {
        b().h();
        FileLock fileLock = this.f6679w;
        if (fileLock == null || !fileLock.isValid()) {
            this.f6659c.f5730a.w();
            File filesDir = this.f6668l.e().getFilesDir();
            C1048a0.a();
            int i5 = C1102g0.f5355b;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.f6680x = channel;
                FileLock tryLock = channel.tryLock();
                this.f6679w = tryLock;
                if (tryLock != null) {
                    a().w().a("Storage concurrent access okay");
                    return true;
                }
                a().o().a("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e5) {
                a().o().b("Failed to acquire storage lock", e5);
                return false;
            } catch (IOException e6) {
                a().o().b("Failed to access storage lock file", e6);
                return false;
            } catch (OverlappingFileLockException e7) {
                a().r().b("Storage lock already acquired", e7);
                return false;
            }
        } else {
            a().w().a("Storage concurrent access okay");
            return true;
        }
    }

    public final T2 b() {
        return ((X2) C0722p.k(this.f6668l)).b();
    }

    /* access modifiers changed from: package-private */
    public final void b0(B6 b6) {
        if (this.f6681y != null) {
            ArrayList arrayList = new ArrayList();
            this.f6682z = arrayList;
            arrayList.addAll(this.f6681y);
        }
        C1426u F02 = F0();
        String str = (String) C0722p.k(b6.f5765a);
        C0722p.e(str);
        F02.h();
        F02.j();
        try {
            SQLiteDatabase u02 = F02.u0();
            String[] strArr = {str};
            int delete = u02.delete("apps", "app_id=?", strArr) + u02.delete("events", "app_id=?", strArr) + u02.delete("events_snapshot", "app_id=?", strArr) + u02.delete("user_attributes", "app_id=?", strArr) + u02.delete("conditional_properties", "app_id=?", strArr) + u02.delete("raw_events", "app_id=?", strArr) + u02.delete("raw_events_metadata", "app_id=?", strArr) + u02.delete("queue", "app_id=?", strArr) + u02.delete("audience_filter_values", "app_id=?", strArr) + u02.delete("main_event_params", "app_id=?", strArr) + u02.delete("default_event_params", "app_id=?", strArr) + u02.delete("trigger_uris", "app_id=?", strArr) + u02.delete("upload_queue", "app_id=?", strArr);
            I6.a();
            X2 x22 = F02.f5730a;
            if (x22.w().H((String) null, C1304d2.f6338i1)) {
                delete += u02.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (delete > 0) {
                x22.a().w().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e5) {
            F02.f5730a.a().o().c("Error resetting analytics data. appId, error", C1402q2.x(str), e5);
        }
        if (b6.f5772h) {
            h0(b6);
        }
    }

    public final C1317f c() {
        return this.f6668l.c();
    }

    /* access modifiers changed from: package-private */
    public final void c0(v6 v6Var, B6 b6) {
        x6 B02;
        long j5;
        v6 v6Var2 = v6Var;
        B6 b62 = b6;
        b().h();
        O0();
        if (X(b62)) {
            if (!b62.f5772h) {
                o0(b62);
                return;
            }
            z6 N02 = N0();
            String str = v6Var2.f6788b;
            int y02 = N02.y0(str);
            int i5 = 0;
            if (y02 != 0) {
                z6 N03 = N0();
                B0();
                String q5 = N03.q(str, 24, true);
                if (str != null) {
                    i5 = str.length();
                }
                N0().B(this.f6656J, b62.f5765a, y02, "_ev", q5, i5);
                return;
            }
            int y4 = N0().y(str, v6Var2.c());
            if (y4 != 0) {
                z6 N04 = N0();
                B0();
                String q6 = N04.q(str, 24, true);
                Object c5 = v6Var2.c();
                if (c5 != null && ((c5 instanceof String) || (c5 instanceof CharSequence))) {
                    i5 = c5.toString().length();
                }
                N0().B(this.f6656J, b62.f5765a, y4, "_ev", q6, i5);
                return;
            }
            Object z4 = N0().z(str, v6Var2.c());
            if (z4 != null) {
                if ("_sid".equals(str)) {
                    long j6 = v6Var2.f6789c;
                    String str2 = v6Var2.f6792f;
                    String str3 = (String) C0722p.k(b62.f5765a);
                    x6 B03 = F0().B0(str3, "_sno");
                    if (B03 != null) {
                        Object obj = B03.f6896e;
                        if (obj instanceof Long) {
                            j5 = ((Long) obj).longValue();
                            c0(new v6("_sno", j6, Long.valueOf(j5 + 1), str2), b62);
                        }
                    }
                    if (B03 != null) {
                        a().r().b("Retrieved last session number from database does not contain a valid (long) value", B03.f6896e);
                    }
                    C v02 = F0().v0(str3, "_s");
                    if (v02 != null) {
                        C1388o2 w4 = a().w();
                        long j7 = v02.f5793c;
                        w4.b("Backfill the session number. Last used session number", Long.valueOf(j7));
                        j5 = j7;
                    } else {
                        j5 = 0;
                    }
                    c0(new v6("_sno", j6, Long.valueOf(j5 + 1), str2), b62);
                }
                String str4 = b62.f5765a;
                x6 x6Var = new x6((String) C0722p.k(str4), (String) C0722p.k(v6Var2.f6792f), str, v6Var2.f6789c, z4);
                C1388o2 w5 = a().w();
                X2 x22 = this.f6668l;
                String str5 = x6Var.f6894c;
                w5.c("Setting user property", x22.D().c(str5), z4);
                F0().r0();
                try {
                    if ("_id".equals(str5) && (B02 = F0().B0(str4, "_id")) != null && !x6Var.f6896e.equals(B02.f6896e)) {
                        F0().z0(str4, "_lair");
                    }
                    o0(b62);
                    boolean A02 = F0().A0(x6Var);
                    if ("_sid".equals(str)) {
                        long U4 = K0().U(b62.f5785u);
                        C1443w2 J02 = F0().J0(str4);
                        if (J02 != null) {
                            J02.a0(U4);
                            if (J02.A()) {
                                F0().K0(J02, false, false);
                            }
                        }
                    }
                    F0().s0();
                    if (!A02) {
                        a().o().c("Too many unique user properties are set. Ignoring user property", x22.D().c(str5), x6Var.f6896e);
                        N0().B(this.f6656J, str4, 9, (String) null, (String) null, 0);
                    }
                    F0().t0();
                } catch (Throwable th) {
                    F0().t0();
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, E3 e32) {
        b().h();
        O0();
        this.f6648B.put(str, e32);
        F0().L(str, e32);
    }

    /* access modifiers changed from: package-private */
    public final void d0(String str, B6 b6) {
        long j5;
        b().h();
        O0();
        if (X(b6)) {
            if (!b6.f5772h) {
                o0(b6);
                return;
            }
            Boolean Z4 = Z(b6);
            if (!"_npa".equals(str) || Z4 == null) {
                C1388o2 v5 = a().v();
                X2 x22 = this.f6668l;
                v5.b("Removing user property", x22.D().c(str));
                F0().r0();
                try {
                    o0(b6);
                    if ("_id".equals(str)) {
                        F0().z0((String) C0722p.k(b6.f5765a), "_lair");
                    }
                    F0().z0((String) C0722p.k(b6.f5765a), str);
                    F0().s0();
                    a().v().b("User property removed", x22.D().c(str));
                    F0().t0();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    F0().t0();
                    throw th2;
                }
            } else {
                a().v().a("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = f().currentTimeMillis();
                if (true != Z4.booleanValue()) {
                    j5 = 0;
                } else {
                    j5 = 1;
                }
                c0(new v6("_npa", currentTimeMillis, Long.valueOf(j5), "auto"), b6);
            }
        }
    }

    public final Context e() {
        return this.f6668l.e();
    }

    /* access modifiers changed from: package-private */
    public final void e0() {
        this.f6674r++;
    }

    public final d f() {
        return ((X2) C0722p.k(this.f6668l)).f();
    }

    /* access modifiers changed from: package-private */
    public final void f0() {
        this.f6675s++;
    }

    /* access modifiers changed from: package-private */
    public final E3 g(String str) {
        E3 e32 = E3.f5857c;
        b().h();
        O0();
        E3 e33 = (E3) this.f6648B.get(str);
        if (e33 == null) {
            e33 = F0().J(str);
            if (e33 == null) {
                e33 = E3.f5857c;
            }
            d(str, e33);
        }
        return e33;
    }

    /* access modifiers changed from: package-private */
    public final X2 g0() {
        return this.f6668l;
    }

    /* access modifiers changed from: package-private */
    public final long h() {
        long currentTimeMillis = f().currentTimeMillis();
        C1460y5 y5Var = this.f6665i;
        y5Var.j();
        y5Var.h();
        B2 b22 = y5Var.f6916j;
        long a5 = b22.a();
        if (a5 == 0) {
            a5 = ((long) y5Var.f5730a.C().q0().nextInt(86400000)) + 1;
            b22.b(a5);
        }
        return ((((currentTimeMillis + a5) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x040b A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100 A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106 A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010e A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011a A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0127 A[Catch:{ RuntimeException -> 0x020f, all -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h0(com.google.android.gms.measurement.internal.B6 r28) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r0 = "com.android.vending"
            java.lang.String r6 = "_npa"
            java.lang.String r7 = "_uwa"
            com.google.android.gms.measurement.internal.T2 r8 = r1.b()
            r8.h()
            r1.O0()
            N.C0722p.k(r2)
            java.lang.String r8 = r2.f5765a
            N.C0722p.e(r8)
            boolean r9 = X(r2)
            if (r9 != 0) goto L_0x0029
            return
        L_0x0029:
            com.google.android.gms.measurement.internal.u r9 = r1.F0()
            com.google.android.gms.measurement.internal.w2 r9 = r9.J0(r8)
            r10 = 0
            r11 = 0
            if (r9 == 0) goto L_0x0059
            java.lang.String r13 = r9.r0()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0059
            java.lang.String r13 = r2.f5766b
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0059
            r9.i(r11)
            com.google.android.gms.measurement.internal.u r13 = r1.F0()
            r13.K0(r9, r10, r10)
            com.google.android.gms.measurement.internal.P2 r9 = r1.D0()
            r9.B(r8)
        L_0x0059:
            boolean r9 = r2.f5772h
            if (r9 != 0) goto L_0x0061
            r27.o0(r28)
            return
        L_0x0061:
            long r13 = r2.f5776l
            int r9 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x006f
            com.google.android.gms.common.util.d r9 = r1.f()
            long r13 = r9.currentTimeMillis()
        L_0x006f:
            r17 = r13
            int r9 = r2.f5777m
            r13 = 1
            if (r9 == 0) goto L_0x008e
            if (r9 == r13) goto L_0x008e
            com.google.android.gms.measurement.internal.q2 r14 = r1.a()
            com.google.android.gms.measurement.internal.o2 r14 = r14.r()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.C1402q2.x(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.c(r11, r15, r9)
            r9 = r10
        L_0x008e:
            com.google.android.gms.measurement.internal.u r11 = r1.F0()
            r11.r0()
            com.google.android.gms.measurement.internal.u r11 = r1.F0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.x6 r11 = r11.B0(r8, r6)     // Catch:{ all -> 0x00b3 }
            java.lang.Boolean r12 = Z(r2)     // Catch:{ all -> 0x00b3 }
            if (r11 == 0) goto L_0x00b6
            java.lang.String r14 = "auto"
            java.lang.String r15 = r11.f6893b     // Catch:{ all -> 0x00b3 }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x00b3 }
            if (r14 == 0) goto L_0x00ae
            goto L_0x00b6
        L_0x00ae:
            r12 = r17
            r24 = 1
            goto L_0x00f3
        L_0x00b3:
            r0 = move-exception
            goto L_0x043a
        L_0x00b6:
            if (r12 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.v6 r15 = new com.google.android.gms.measurement.internal.v6     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_npa"
            boolean r6 = r12.booleanValue()     // Catch:{ all -> 0x00b3 }
            if (r13 == r6) goto L_0x00c5
            r23 = 0
            goto L_0x00c7
        L_0x00c5:
            r23 = 1
        L_0x00c7:
            java.lang.Long r6 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x00b3 }
            r23 = 1
            java.lang.String r20 = "auto"
            r19 = r6
            r13 = r23
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b3 }
            r24 = r13
            r12 = r17
            if (r11 == 0) goto L_0x00e6
            java.lang.Object r6 = r11.f6896e     // Catch:{ all -> 0x00b3 }
            java.lang.Long r11 = r15.f6790d     // Catch:{ all -> 0x00b3 }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x00f3
        L_0x00e6:
            r1.c0(r15, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x00f3
        L_0x00ea:
            r12 = r17
            r24 = 1
            if (r11 == 0) goto L_0x00f3
            r1.d0(r6, r2)     // Catch:{ all -> 0x00b3 }
        L_0x00f3:
            com.google.android.gms.measurement.internal.m r6 = r1.B0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.c2 r11 = com.google.android.gms.measurement.internal.C1304d2.f6320c1     // Catch:{ all -> 0x00b3 }
            r14 = 0
            boolean r6 = r6.H(r14, r11)     // Catch:{ all -> 0x00b3 }
            if (r6 == 0) goto L_0x0106
            long r14 = r2.f5763D     // Catch:{ all -> 0x00b3 }
            r1.n0(r2, r14)     // Catch:{ all -> 0x00b3 }
            goto L_0x0109
        L_0x0106:
            r1.n0(r2, r12)     // Catch:{ all -> 0x00b3 }
        L_0x0109:
            r27.o0(r28)     // Catch:{ all -> 0x00b3 }
            if (r9 != 0) goto L_0x011a
            com.google.android.gms.measurement.internal.u r9 = r1.F0()     // Catch:{ all -> 0x00b3 }
            java.lang.String r11 = "_f"
            com.google.android.gms.measurement.internal.C r9 = r9.v0(r8, r11)     // Catch:{ all -> 0x00b3 }
            r11 = r10
            goto L_0x0125
        L_0x011a:
            com.google.android.gms.measurement.internal.u r9 = r1.F0()     // Catch:{ all -> 0x00b3 }
            java.lang.String r11 = "_v"
            com.google.android.gms.measurement.internal.C r9 = r9.v0(r8, r11)     // Catch:{ all -> 0x00b3 }
            r11 = 1
        L_0x0125:
            if (r9 != 0) goto L_0x040b
            r14 = 3600000(0x36ee80, double:1.7786363E-317)
            long r17 = r12 / r14
            long r17 = r17 + r24
            long r17 = r17 * r14
            java.lang.String r9 = "_elt"
            java.lang.String r14 = "_dac"
            java.lang.String r15 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r11 != 0) goto L_0x03a4
            r11 = r15
            com.google.android.gms.measurement.internal.v6 r15 = new com.google.android.gms.measurement.internal.v6     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_fot"
            java.lang.Long r19 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x00b3 }
            java.lang.String r20 = "auto"
            r17 = r12
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b3 }
            r1.c0(r15, r2)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.T2 r12 = r1.b()     // Catch:{ all -> 0x00b3 }
            r12.h()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.H2 r12 = r1.f6667k     // Catch:{ all -> 0x00b3 }
            java.lang.Object r12 = N.C0722p.k(r12)     // Catch:{ all -> 0x00b3 }
            r13 = r12
            com.google.android.gms.measurement.internal.H2 r13 = (com.google.android.gms.measurement.internal.H2) r13     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x0167
            boolean r12 = r8.isEmpty()     // Catch:{ all -> 0x00b3 }
            if (r12 == 0) goto L_0x016b
        L_0x0167:
            r26 = r9
            goto L_0x0247
        L_0x016b:
            com.google.android.gms.measurement.internal.X2 r15 = r13.f5907a     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.T2 r12 = r15.b()     // Catch:{ all -> 0x00b3 }
            r12.h()     // Catch:{ all -> 0x00b3 }
            boolean r12 = r13.a()     // Catch:{ all -> 0x00b3 }
            if (r12 != 0) goto L_0x018b
            com.google.android.gms.measurement.internal.q2 r0 = r15.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.u()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = "Install Referrer Reporter is not available"
            r0.a(r8)     // Catch:{ all -> 0x00b3 }
            r26 = r9
            goto L_0x0256
        L_0x018b:
            com.google.android.gms.measurement.internal.G2 r12 = new com.google.android.gms.measurement.internal.G2     // Catch:{ all -> 0x00b3 }
            r12.<init>(r13, r8)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.T2 r8 = r15.b()     // Catch:{ all -> 0x00b3 }
            r8.h()     // Catch:{ all -> 0x00b3 }
            android.content.Intent r8 = new android.content.Intent     // Catch:{ all -> 0x00b3 }
            r16 = r15
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r8.<init>(r15)     // Catch:{ all -> 0x00b3 }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x00b3 }
            r26 = r9
            java.lang.String r9 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r0, r9)     // Catch:{ all -> 0x00b3 }
            r8.setComponent(r15)     // Catch:{ all -> 0x00b3 }
            android.content.Context r9 = r16.e()     // Catch:{ all -> 0x00b3 }
            android.content.pm.PackageManager r9 = r9.getPackageManager()     // Catch:{ all -> 0x00b3 }
            if (r9 != 0) goto L_0x01c5
            com.google.android.gms.measurement.internal.q2 r0 = r16.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.s()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.a(r8)     // Catch:{ all -> 0x00b3 }
            goto L_0x0256
        L_0x01c5:
            r15 = 0
            java.util.List r9 = r9.queryIntentServices(r8, r15)     // Catch:{ all -> 0x00b3 }
            if (r9 == 0) goto L_0x0239
            boolean r19 = r9.isEmpty()     // Catch:{ all -> 0x00b3 }
            if (r19 != 0) goto L_0x0239
            java.lang.Object r9 = r9.get(r15)     // Catch:{ all -> 0x00b3 }
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9     // Catch:{ all -> 0x00b3 }
            android.content.pm.ServiceInfo r9 = r9.serviceInfo     // Catch:{ all -> 0x00b3 }
            if (r9 == 0) goto L_0x0256
            java.lang.String r15 = r9.packageName     // Catch:{ all -> 0x00b3 }
            java.lang.String r9 = r9.name     // Catch:{ all -> 0x00b3 }
            if (r9 == 0) goto L_0x022b
            boolean r0 = r0.equals(r15)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x022b
            boolean r0 = r13.a()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x022b
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00b3 }
            r0.<init>(r8)     // Catch:{ all -> 0x00b3 }
            R.b r8 = R.b.b()     // Catch:{ RuntimeException -> 0x020f }
            android.content.Context r9 = r16.e()     // Catch:{ RuntimeException -> 0x020f }
            r15 = 1
            boolean r0 = r8.a(r9, r0, r12, r15)     // Catch:{ RuntimeException -> 0x020f }
            com.google.android.gms.measurement.internal.q2 r8 = r16.a()     // Catch:{ RuntimeException -> 0x020f }
            com.google.android.gms.measurement.internal.o2 r8 = r8.w()     // Catch:{ RuntimeException -> 0x020f }
            java.lang.String r9 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0211
            java.lang.String r0 = "available"
            goto L_0x0213
        L_0x020f:
            r0 = move-exception
            goto L_0x0217
        L_0x0211:
            java.lang.String r0 = "not available"
        L_0x0213:
            r8.b(r9, r0)     // Catch:{ RuntimeException -> 0x020f }
            goto L_0x0256
        L_0x0217:
            com.google.android.gms.measurement.internal.X2 r8 = r13.f5907a     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.q2 r8 = r8.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r8 = r8.o()     // Catch:{ all -> 0x00b3 }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b3 }
            r8.b(r9, r0)     // Catch:{ all -> 0x00b3 }
            goto L_0x0256
        L_0x022b:
            com.google.android.gms.measurement.internal.q2 r0 = r16.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.a(r8)     // Catch:{ all -> 0x00b3 }
            goto L_0x0256
        L_0x0239:
            com.google.android.gms.measurement.internal.q2 r0 = r16.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.u()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.a(r8)     // Catch:{ all -> 0x00b3 }
            goto L_0x0256
        L_0x0247:
            com.google.android.gms.measurement.internal.X2 r0 = r13.f5907a     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.s()     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = "Install Referrer Reporter was called with invalid app package name"
            r0.a(r8)     // Catch:{ all -> 0x00b3 }
        L_0x0256:
            com.google.android.gms.measurement.internal.T2 r0 = r1.b()     // Catch:{ all -> 0x00b3 }
            r0.h()     // Catch:{ all -> 0x00b3 }
            r1.O0()     // Catch:{ all -> 0x00b3 }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x00b3 }
            r8.<init>()     // Catch:{ all -> 0x00b3 }
            r12 = r24
            r8.putLong(r10, r12)     // Catch:{ all -> 0x00b3 }
            r8.putLong(r6, r12)     // Catch:{ all -> 0x00b3 }
            r9 = 0
            r8.putLong(r7, r9)     // Catch:{ all -> 0x00b3 }
            r8.putLong(r5, r9)     // Catch:{ all -> 0x00b3 }
            r8.putLong(r4, r9)     // Catch:{ all -> 0x00b3 }
            r8.putLong(r3, r9)     // Catch:{ all -> 0x00b3 }
            r8.putLong(r11, r12)     // Catch:{ all -> 0x00b3 }
            boolean r0 = r2.f5779o     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0285
            r8.putLong(r14, r12)     // Catch:{ all -> 0x00b3 }
        L_0x0285:
            java.lang.String r0 = r2.f5765a     // Catch:{ all -> 0x00b3 }
            java.lang.Object r0 = N.C0722p.k(r0)     // Catch:{ all -> 0x00b3 }
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x00b3 }
            N.C0722p.e(r9)     // Catch:{ all -> 0x00b3 }
            r0.h()     // Catch:{ all -> 0x00b3 }
            r0.j()     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = "first_open_count"
            long r10 = r0.z(r9, r6)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.X2 r0 = r1.f6668l     // Catch:{ all -> 0x00b3 }
            android.content.Context r6 = r0.e()     // Catch:{ all -> 0x00b3 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x02c2
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r9)     // Catch:{ all -> 0x00b3 }
            r0.b(r3, r4)     // Catch:{ all -> 0x00b3 }
        L_0x02be:
            r21 = 0
            goto L_0x036c
        L_0x02c2:
            android.content.Context r0 = r0.e()     // Catch:{ NameNotFoundException -> 0x02d0 }
            T.d r0 = T.e.a(r0)     // Catch:{ NameNotFoundException -> 0x02d0 }
            r15 = 0
            android.content.pm.PackageInfo r6 = r0.e(r9, r15)     // Catch:{ NameNotFoundException -> 0x02d0 }
            goto L_0x02e3
        L_0x02d0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q2 r6 = r1.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r6 = r6.o()     // Catch:{ all -> 0x00b3 }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.C1402q2.x(r9)     // Catch:{ all -> 0x00b3 }
            r6.c(r12, r13, r0)     // Catch:{ all -> 0x00b3 }
            r6 = 0
        L_0x02e3:
            if (r6 == 0) goto L_0x032e
            long r12 = r6.firstInstallTime     // Catch:{ all -> 0x00b3 }
            r21 = 0
            int r0 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x032e
            long r14 = r6.lastUpdateTime     // Catch:{ all -> 0x00b3 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0315
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.c2 r6 = com.google.android.gms.measurement.internal.C1304d2.f6279J0     // Catch:{ all -> 0x00b3 }
            r12 = 0
            boolean r0 = r0.H(r12, r6)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x030f
            r21 = 0
            int r0 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x030d
            r12 = 1
            r8.putLong(r7, r12)     // Catch:{ all -> 0x00b3 }
            r10 = 0
        L_0x030d:
            r12 = 0
            goto L_0x0316
        L_0x030f:
            r12 = 1
            r8.putLong(r7, r12)     // Catch:{ all -> 0x00b3 }
            goto L_0x030d
        L_0x0315:
            r12 = 1
        L_0x0316:
            com.google.android.gms.measurement.internal.v6 r15 = new com.google.android.gms.measurement.internal.v6     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_fi"
            r7 = 1
            if (r7 == r12) goto L_0x0320
            r13 = 0
            goto L_0x0322
        L_0x0320:
            r13 = 1
        L_0x0322:
            java.lang.Long r19 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00b3 }
            java.lang.String r20 = "auto"
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b3 }
            r1.c0(r15, r2)     // Catch:{ all -> 0x00b3 }
        L_0x032e:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f6668l     // Catch:{ NameNotFoundException -> 0x033e }
            android.content.Context r0 = r0.e()     // Catch:{ NameNotFoundException -> 0x033e }
            T.d r0 = T.e.a(r0)     // Catch:{ NameNotFoundException -> 0x033e }
            r15 = 0
            android.content.pm.ApplicationInfo r0 = r0.c(r9, r15)     // Catch:{ NameNotFoundException -> 0x033e }
            goto L_0x0351
        L_0x033e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q2 r7 = r1.a()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()     // Catch:{ all -> 0x00b3 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r9)     // Catch:{ all -> 0x00b3 }
            r7.c(r13, r9, r0)     // Catch:{ all -> 0x00b3 }
            r0 = 0
        L_0x0351:
            if (r0 == 0) goto L_0x02be
            int r7 = r0.flags     // Catch:{ all -> 0x00b3 }
            r12 = 1
            r7 = r7 & r12
            if (r7 == 0) goto L_0x035f
            r12 = 1
            r8.putLong(r4, r12)     // Catch:{ all -> 0x00b3 }
            goto L_0x0361
        L_0x035f:
            r12 = 1
        L_0x0361:
            int r0 = r0.flags     // Catch:{ all -> 0x00b3 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x02be
            r8.putLong(r3, r12)     // Catch:{ all -> 0x00b3 }
            goto L_0x02be
        L_0x036c:
            int r0 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r0 < 0) goto L_0x0373
            r8.putLong(r5, r10)     // Catch:{ all -> 0x00b3 }
        L_0x0373:
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.c2 r3 = com.google.android.gms.measurement.internal.C1304d2.f6344k1     // Catch:{ all -> 0x00b3 }
            r6 = 0
            boolean r0 = r0.H(r6, r3)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x038d
            com.google.android.gms.common.util.d r0 = r1.f()     // Catch:{ all -> 0x00b3 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x00b3 }
            r5 = r26
            r8.putLong(r5, r3)     // Catch:{ all -> 0x00b3 }
        L_0x038d:
            com.google.android.gms.measurement.internal.G r15 = new com.google.android.gms.measurement.internal.G     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_f"
            com.google.android.gms.measurement.internal.E r0 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00b3 }
            r0.<init>(r8)     // Catch:{ all -> 0x00b3 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r0
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b3 }
            r1.j(r15, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x042b
        L_0x03a4:
            r5 = r9
            r19 = r12
            r11 = r15
            com.google.android.gms.measurement.internal.v6 r15 = new com.google.android.gms.measurement.internal.v6     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_fvt"
            java.lang.Long r0 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x00b3 }
            r17 = r19
            java.lang.String r20 = "auto"
            r19 = r0
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b3 }
            r1.c0(r15, r2)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.T2 r0 = r1.b()     // Catch:{ all -> 0x00b3 }
            r0.h()     // Catch:{ all -> 0x00b3 }
            r1.O0()     // Catch:{ all -> 0x00b3 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00b3 }
            r0.<init>()     // Catch:{ all -> 0x00b3 }
            r12 = 1
            r0.putLong(r10, r12)     // Catch:{ all -> 0x00b3 }
            r0.putLong(r6, r12)     // Catch:{ all -> 0x00b3 }
            r0.putLong(r11, r12)     // Catch:{ all -> 0x00b3 }
            boolean r3 = r2.f5779o     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x03dd
            r0.putLong(r14, r12)     // Catch:{ all -> 0x00b3 }
        L_0x03dd:
            com.google.android.gms.measurement.internal.m r3 = r1.B0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6344k1     // Catch:{ all -> 0x00b3 }
            r6 = 0
            boolean r3 = r3.H(r6, r4)     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x03f5
            com.google.android.gms.common.util.d r3 = r1.f()     // Catch:{ all -> 0x00b3 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x00b3 }
            r0.putLong(r5, r3)     // Catch:{ all -> 0x00b3 }
        L_0x03f5:
            com.google.android.gms.measurement.internal.G r15 = new com.google.android.gms.measurement.internal.G     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_v"
            com.google.android.gms.measurement.internal.E r3 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00b3 }
            r3.<init>(r0)     // Catch:{ all -> 0x00b3 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b3 }
            r1.j(r15, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x042b
        L_0x040b:
            r17 = r12
            boolean r0 = r2.f5773i     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x042b
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00b3 }
            r0.<init>()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.G r15 = new com.google.android.gms.measurement.internal.G     // Catch:{ all -> 0x00b3 }
            java.lang.String r16 = "_cd"
            com.google.android.gms.measurement.internal.E r3 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00b3 }
            r3.<init>(r0)     // Catch:{ all -> 0x00b3 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b3 }
            r1.j(r15, r2)     // Catch:{ all -> 0x00b3 }
        L_0x042b:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x00b3 }
            r0.s0()     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()
            r0.t0()
            return
        L_0x043a:
            com.google.android.gms.measurement.internal.u r2 = r1.F0()
            r2.t0()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.h0(com.google.android.gms.measurement.internal.B6):void");
    }

    /* access modifiers changed from: package-private */
    public final void i(G g5, String str) {
        G g6 = g5;
        String str2 = str;
        C1443w2 J02 = F0().J0(str2);
        if (J02 == null || TextUtils.isEmpty(J02.D0())) {
            a().v().b("No app data available; dropping event", str2);
            return;
        }
        Boolean T4 = T(J02);
        if (T4 == null) {
            if (!"_ui".equals(g6.f5883a)) {
                a().r().b("Could not find package. appId", C1402q2.x(str2));
            }
        } else if (!T4.booleanValue()) {
            a().o().b("App version does not match; dropping event. appId", C1402q2.x(str2));
            return;
        }
        C1443w2 w2Var = J02;
        C1443w2 w2Var2 = w2Var;
        C1443w2 w2Var3 = w2Var2;
        C1443w2 w2Var4 = w2Var3;
        C1443w2 w2Var5 = w2Var4;
        C1443w2 w2Var6 = w2Var5;
        j(g6, new B6(str2, w2Var.r0(), w2Var2.D0(), w2Var3.F0(), w2Var4.H0(), w2Var5.J0(), w2Var6.L0(), (String) null, w2Var6.d(), false, w2Var6.x0(), 0, 0, w2Var6.P(), false, w2Var6.R(), w2Var6.b(), w2Var6.T(), g(str2).l(), "", (String) null, w2Var6.V(), w2Var6.X(), g(str2).b(), R0(str2).e(), w2Var6.b0(), w2Var6.j0(), w2Var6.l0(), w2Var6.I(), 0, w2Var6.M()));
    }

    /* access modifiers changed from: package-private */
    public final void i0(B6 b6) {
        b().h();
        O0();
        C0722p.k(b6);
        String str = b6.f5765a;
        C0722p.e(str);
        int i5 = 0;
        if (B0().H((String) null, C1304d2.f6261A0)) {
            long currentTimeMillis = f().currentTimeMillis();
            int E4 = B0().E((String) null, C1304d2.f6340j0);
            B0();
            long n5 = currentTimeMillis - C1371m.n();
            while (i5 < E4 && M((String) null, n5)) {
                i5++;
            }
        } else {
            B0();
            long p5 = C1371m.p();
            while (((long) i5) < p5 && M(str, 0)) {
                i5++;
            }
        }
        if (B0().H((String) null, C1304d2.f6263B0)) {
            b().h();
            v0();
        }
        if (this.f6666j.j(str, C1141k3.a(b6.f5764E))) {
            a().w().b("[sgtm] Going background, trigger client side upload. appId", str);
            s(str, f().currentTimeMillis());
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(G g5, B6 b6) {
        String str = b6.f5765a;
        C0722p.e(str);
        C1408r2 a5 = C1408r2.a(g5);
        N0().w(a5.f6692d, F0().G(str));
        N0().u(a5, B0().w(str));
        G b5 = a5.b();
        if (!B0().H((String) null, C1304d2.f6332g1) && "_cmp".equals(b5.f5883a)) {
            E e5 = b5.f5884b;
            if ("referrer API v2".equals(e5.g("_cis"))) {
                String g6 = e5.g("gclid");
                if (!TextUtils.isEmpty(g6)) {
                    c0(new v6("_lgclid", b5.f5886d, g6, "auto"), b6);
                }
            }
        }
        k(b5, b6);
    }

    /* access modifiers changed from: package-private */
    public final void j0(C1341i iVar) {
        B6 U4 = U((String) C0722p.k(iVar.f6470a));
        if (U4 != null) {
            k0(iVar, U4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(G g5, B6 b6) {
        E4 e42;
        G g6;
        List<C1341i> list;
        List<C1341i> list2;
        List<C1341i> list3;
        String str;
        B6 b62 = b6;
        C0722p.k(b62);
        String str2 = b62.f5765a;
        C0722p.e(str2);
        b().h();
        O0();
        G g7 = g5;
        long j5 = g7.f5886d;
        C1408r2 a5 = C1408r2.a(g7);
        b().h();
        if (this.f6652F == null || (str = this.f6653G) == null || !str.equals(str2)) {
            e42 = null;
        } else {
            e42 = this.f6652F;
        }
        z6.k0(e42, a5.f6692d, false);
        G b5 = a5.b();
        K0();
        if (u6.p(b5, b62)) {
            if (!b62.f5772h) {
                o0(b62);
                return;
            }
            List list4 = b62.f5782r;
            if (list4 != null) {
                String str3 = b5.f5883a;
                if (list4.contains(str3)) {
                    Bundle j6 = b5.f5884b.j();
                    j6.putLong("ga_safelisted", 1);
                    g6 = new G(str3, new E(j6), b5.f5885c, b5.f5886d);
                } else {
                    a().v().d("Dropping non-safelisted event. appId, event name, origin", str2, b5.f5883a, b5.f5885c);
                    return;
                }
            } else {
                g6 = b5;
            }
            F0().r0();
            try {
                String str4 = g6.f5883a;
                if ("_s".equals(str4) && !F0().C(str2, "_s") && g6.f5884b.d("_sid").longValue() != 0) {
                    if (!F0().C(str2, "_f")) {
                        if (!F0().C(str2, "_v")) {
                            F0().I(str2, Long.valueOf(f().currentTimeMillis() - 15000), "_sid", l(str2, g6));
                        }
                    }
                    F0().I(str2, (Long) null, "_sid", l(str2, g6));
                }
                C1426u F02 = F0();
                C0722p.e(str2);
                F02.h();
                F02.j();
                int i5 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
                if (i5 < 0) {
                    F02.f5730a.a().r().c("Invalid time querying timed out conditional properties", C1402q2.x(str2), Long.valueOf(j5));
                    list = Collections.EMPTY_LIST;
                } else {
                    list = F02.I0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j5)});
                }
                for (C1341i iVar : list) {
                    if (iVar != null) {
                        a().w().d("User property timed out", iVar.f6470a, this.f6668l.D().c(iVar.f6472c.f6788b), iVar.f6472c.c());
                        G g8 = iVar.f6476g;
                        if (g8 != null) {
                            m(new G(g8, j5), b62);
                        }
                        F0().G0(str2, iVar.f6472c.f6788b);
                    }
                }
                C1426u F03 = F0();
                C0722p.e(str2);
                F03.h();
                F03.j();
                if (i5 < 0) {
                    F03.f5730a.a().r().c("Invalid time querying expired conditional properties", C1402q2.x(str2), Long.valueOf(j5));
                    list2 = Collections.EMPTY_LIST;
                } else {
                    list2 = F03.I0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j5)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (C1341i iVar2 : list2) {
                    if (iVar2 != null) {
                        a().w().d("User property expired", iVar2.f6470a, this.f6668l.D().c(iVar2.f6472c.f6788b), iVar2.f6472c.c());
                        F0().z0(str2, iVar2.f6472c.f6788b);
                        G g9 = iVar2.f6480k;
                        if (g9 != null) {
                            arrayList.add(g9);
                        }
                        F0().G0(str2, iVar2.f6472c.f6788b);
                    }
                }
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    m(new G((G) obj, j5), b62);
                }
                C1426u F04 = F0();
                C0722p.e(str2);
                C0722p.e(str4);
                F04.h();
                F04.j();
                if (i5 < 0) {
                    X2 x22 = F04.f5730a;
                    x22.a().r().d("Invalid time querying triggered conditional properties", C1402q2.x(str2), x22.D().a(str4), Long.valueOf(j5));
                    list3 = Collections.EMPTY_LIST;
                } else {
                    list3 = F04.I0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j5)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (C1341i iVar3 : list3) {
                    if (iVar3 != null) {
                        v6 v6Var = iVar3.f6472c;
                        x6 x6Var = new x6((String) C0722p.k(iVar3.f6470a), iVar3.f6471b, v6Var.f6788b, j5, C0722p.k(v6Var.c()));
                        if (F0().A0(x6Var)) {
                            a().w().d("User property triggered", iVar3.f6470a, this.f6668l.D().c(x6Var.f6894c), x6Var.f6896e);
                        } else {
                            a().o().d("Too many active user properties, ignoring", C1402q2.x(iVar3.f6470a), this.f6668l.D().c(x6Var.f6894c), x6Var.f6896e);
                        }
                        G g10 = iVar3.f6478i;
                        if (g10 != null) {
                            arrayList2.add(g10);
                        }
                        iVar3.f6472c = new v6(x6Var);
                        iVar3.f6474e = true;
                        F0().E0(iVar3);
                    }
                }
                m(g6, b62);
                int size2 = arrayList2.size();
                int i7 = 0;
                while (i7 < size2) {
                    Object obj2 = arrayList2.get(i7);
                    i7++;
                    m(new G((G) obj2, j5), b62);
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                F0().t0();
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void k0(C1341i iVar, B6 b6) {
        C0722p.k(iVar);
        C0722p.e(iVar.f6470a);
        C0722p.k(iVar.f6471b);
        C0722p.k(iVar.f6472c);
        C0722p.e(iVar.f6472c.f6788b);
        b().h();
        O0();
        if (X(b6)) {
            if (!b6.f5772h) {
                o0(b6);
                return;
            }
            C1341i iVar2 = new C1341i(iVar);
            boolean z4 = false;
            iVar2.f6474e = false;
            F0().r0();
            try {
                C1341i F02 = F0().F0((String) C0722p.k(iVar2.f6470a), iVar2.f6472c.f6788b);
                if (F02 != null && !F02.f6471b.equals(iVar2.f6471b)) {
                    a().r().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f6668l.D().c(iVar2.f6472c.f6788b), iVar2.f6471b, F02.f6471b);
                }
                if (F02 != null && F02.f6474e) {
                    iVar2.f6471b = F02.f6471b;
                    iVar2.f6473d = F02.f6473d;
                    iVar2.f6477h = F02.f6477h;
                    iVar2.f6475f = F02.f6475f;
                    iVar2.f6478i = F02.f6478i;
                    iVar2.f6474e = true;
                    v6 v6Var = iVar2.f6472c;
                    iVar2.f6472c = new v6(v6Var.f6788b, F02.f6472c.f6789c, v6Var.c(), F02.f6472c.f6792f);
                } else if (TextUtils.isEmpty(iVar2.f6475f)) {
                    v6 v6Var2 = iVar2.f6472c;
                    iVar2.f6472c = new v6(v6Var2.f6788b, iVar2.f6473d, v6Var2.c(), iVar2.f6472c.f6792f);
                    iVar2.f6474e = true;
                    z4 = true;
                }
                if (iVar2.f6474e) {
                    v6 v6Var3 = iVar2.f6472c;
                    x6 x6Var = new x6((String) C0722p.k(iVar2.f6470a), iVar2.f6471b, v6Var3.f6788b, v6Var3.f6789c, C0722p.k(v6Var3.c()));
                    if (F0().A0(x6Var)) {
                        a().v().d("User property updated immediately", iVar2.f6470a, this.f6668l.D().c(x6Var.f6894c), x6Var.f6896e);
                    } else {
                        a().o().d("(2)Too many active user properties, ignoring", C1402q2.x(iVar2.f6470a), this.f6668l.D().c(x6Var.f6894c), x6Var.f6896e);
                    }
                    if (z4 && iVar2.f6478i != null) {
                        m(new G(iVar2.f6478i, iVar2.f6473d), b6);
                    }
                }
                if (F0().E0(iVar2)) {
                    a().v().d("Conditional property added", iVar2.f6470a, this.f6668l.D().c(iVar2.f6472c.f6788b), iVar2.f6472c.c());
                } else {
                    a().o().d("Too many conditional properties, ignoring", C1402q2.x(iVar2.f6470a), this.f6668l.D().c(iVar2.f6472c.f6788b), iVar2.f6472c.c());
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                Throwable th2 = th;
                F0().t0();
                throw th2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle l(String str, G g5) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", g5.f5884b.d("_sid").longValue());
        x6 B02 = F0().B0(str, "_sno");
        if (B02 != null) {
            Object obj = B02.f6896e;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final void l0(C1341i iVar) {
        B6 U4 = U((String) C0722p.k(iVar.f6470a));
        if (U4 != null) {
            m0(iVar, U4);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(68:(2:106|(3:108|(1:110)|111))|112|(2:114|(3:116|(1:118)|119))(1:120)|121|122|(2:124|125)|126|(2:130|(1:132))|133|(2:139|(2:141|142))|143|144|(3:145|146|147)|151|(1:153)|154|(2:156|(2:162|163)(1:159))(1:164)|165|(1:167)|168|(1:170)|171|(1:173)|174|(1:176)|177|(1:179)|180|(1:182)|183|(6:187|(1:191)|192|(1:194)(1:195)|196|(1:198)(15:199|(1:201)(1:202)|203|(1:205)(1:206)|207|(1:209)(1:210)|211|(1:213)(1:214)|215|(1:217)(1:218)|219|(1:221)(1:222)|223|(1:225)(1:226)|227))|228|(1:230)|231|(1:233)(1:234)|(35:239|(2:240|(3:242|(3:244|245|(2:247|(2:367|249)(1:370))(1:369))(1:368)|365)(1:366))|253|(1:255)|(1:257)|258|(1:260)|261|(2:265|(4:267|(1:269)|270|(29:278|(1:280)(1:281)|282|(1:284)|285|287|(2:289|(1:291))|292|(3:294|(1:296)|297)(1:298)|299|(1:303)|304|(1:306)|307|(4:310|(2:316|372)|317|308)|318|319|320|321|322|323|(2:324|(2:326|(1:376))(3:377|329|(1:334)(1:333)))|335|336|337|(1:339)(3:341|342|343)|352|353|354)))|286|287|(0)|292|(0)(0)|299|301|303|304|(0)|307|(1:308)|318|319|320|321|322|323|(3:324|(0)(0)|327)|335|336|337|(0)(0)|352|353|354)|238|(0)|258|(0)|261|263|265|(0)|286|287|(0)|292|(0)(0)|299|301|303|304|(0)|307|(1:308)|318|319|320|321|322|323|(3:324|(0)(0)|327)|335|(3:336|337|(0)(0))|352|353|354) */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0a32, code lost:
        r30 = 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:143:0x04ad */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0366 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x038b A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x04fc A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0533 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x05a2 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x05e8 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x05f3 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x05fe A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0609 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0615 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0626 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x067d A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x067f A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0687 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0689 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x06f8 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x071e A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0721 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0750 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x07ac A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x07af A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x07bf A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x07f6 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x08ae A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x08c5 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0923 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x094d A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0969 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0a28 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0ad1 A[Catch:{ SQLiteException -> 0x0ae5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0ae7  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x07a6 A[EDGE_INSN: B:366:0x07a6->B:253:0x07a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0a35 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019d A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01fc A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x020e A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02c5 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0303 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0306 A[Catch:{ SQLiteException -> 0x028a, all -> 0x0176 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.google.android.gms.measurement.internal.G r45, com.google.android.gms.measurement.internal.B6 r46) {
        /*
            r44 = this;
            r1 = r44
            r2 = r46
            java.lang.String r3 = "metadata_fingerprint"
            java.lang.String r4 = "app_id"
            java.lang.String r5 = "_fx"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            N.C0722p.k(r2)
            java.lang.String r10 = r2.f5765a
            N.C0722p.e(r10)
            long r25 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.T2 r0 = r1.b()
            r0.h()
            r1.O0()
            r1.K0()
            boolean r0 = com.google.android.gms.measurement.internal.u6.p(r45, r46)
            if (r0 != 0) goto L_0x002f
            goto L_0x00d3
        L_0x002f:
            boolean r0 = r2.f5772h
            if (r0 != 0) goto L_0x0037
            r1.o0(r2)
            return
        L_0x0037:
            com.google.android.gms.measurement.internal.P2 r0 = r1.D0()
            r8 = r45
            java.lang.String r13 = r8.f5883a
            boolean r0 = r0.D(r10, r13)
            java.lang.String r15 = "_err"
            r9 = 0
            if (r0 == 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.C1402q2.x(r10)
            com.google.android.gms.measurement.internal.X2 r3 = r1.f6668l
            com.google.android.gms.measurement.internal.j2 r3 = r3.D()
            java.lang.String r3 = r3.a(r13)
            java.lang.String r4 = "Dropping blocked event. appId"
            r0.c(r4, r2, r3)
            com.google.android.gms.measurement.internal.P2 r0 = r1.D0()
            boolean r0 = r0.H(r10)
            if (r0 != 0) goto L_0x008d
            com.google.android.gms.measurement.internal.P2 r0 = r1.D0()
            boolean r0 = r0.I(r10)
            if (r0 == 0) goto L_0x0078
            goto L_0x008d
        L_0x0078:
            boolean r0 = r15.equals(r13)
            if (r0 != 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()
            com.google.android.gms.measurement.internal.y6 r9 = r1.f6656J
            java.lang.String r12 = "_ev"
            r14 = 0
            r11 = 11
            r8.B(r9, r10, r11, r12, r13, r14)
            return
        L_0x008d:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()
            com.google.android.gms.measurement.internal.w2 r0 = r0.J0(r10)
            if (r0 == 0) goto L_0x00d3
            long r2 = r0.j()
            long r4 = r0.h()
            long r2 = java.lang.Math.max(r2, r4)
            com.google.android.gms.common.util.d r4 = r1.f()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            r1.B0()
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6288O
            java.lang.Object r4 = r4.b(r9)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.v()
            java.lang.String r3 = "Fetching config for blocked app"
            r2.a(r3)
            r1.B(r0)
        L_0x00d3:
            return
        L_0x00d4:
            com.google.android.gms.measurement.internal.r2 r0 = com.google.android.gms.measurement.internal.C1408r2.a(r8)
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()
            com.google.android.gms.measurement.internal.m r11 = r1.B0()
            int r11 = r11.w(r10)
            r8.u(r0, r11)
            com.google.android.gms.measurement.internal.m r8 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r11 = com.google.android.gms.measurement.internal.C1304d2.f6334h0
            r12 = 10
            r13 = 35
            int r8 = r8.F(r10, r11, r12, r13)
            android.os.Bundle r11 = r0.f6692d
            java.util.TreeSet r12 = new java.util.TreeSet
            java.util.Set r13 = r11.keySet()
            r12.<init>(r13)
            java.util.Iterator r12 = r12.iterator()
        L_0x0104:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0124
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "items"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.z6 r14 = r1.N0()
            android.os.Parcelable[] r13 = r11.getParcelableArray(r13)
            r14.v(r13, r8)
            goto L_0x0104
        L_0x0124:
            com.google.android.gms.measurement.internal.G r8 = r0.b()
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            java.lang.String r0 = r0.z()
            r11 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r11)
            if (r0 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            com.google.android.gms.measurement.internal.X2 r11 = r1.f6668l
            com.google.android.gms.measurement.internal.j2 r11 = r11.D()
            java.lang.String r11 = r11.d(r8)
            java.lang.String r12 = "Logging event"
            r0.b(r12, r11)
        L_0x014e:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()
            r0.r0()
            r1.o0(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = "ecommerce_purchase"
            java.lang.String r11 = r8.f5883a     // Catch:{ all -> 0x0176 }
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "refund"
            if (r0 != 0) goto L_0x0172
            java.lang.String r0 = "purchase"
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x0172
            boolean r0 = r12.equals(r11)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0174
        L_0x0172:
            r0 = 1
            goto L_0x0179
        L_0x0174:
            r0 = 0
            goto L_0x0179
        L_0x0176:
            r0 = move-exception
            goto L_0x0b63
        L_0x0179:
            java.lang.String r9 = "_iap"
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0176 }
            r27 = r3
            java.lang.String r3 = "value"
            if (r9 != 0) goto L_0x0191
            if (r0 == 0) goto L_0x0189
            r0 = 1
            goto L_0x0191
        L_0x0189:
            r28 = r4
            r29 = r5
        L_0x018d:
            r5 = r8
            r4 = 0
            goto L_0x02f2
        L_0x0191:
            java.lang.String r9 = "_ltv_"
            com.google.android.gms.measurement.internal.E r13 = r8.f5884b     // Catch:{ all -> 0x0176 }
            java.lang.String r14 = "currency"
            java.lang.String r14 = r13.g(r14)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x01fc
            java.lang.Double r0 = r13.f(r3)     // Catch:{ all -> 0x0176 }
            double r18 = r0.doubleValue()     // Catch:{ all -> 0x0176 }
            r20 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r18 = r18 * r20
            r22 = 0
            int r0 = (r18 > r22 ? 1 : (r18 == r22 ? 0 : -1))
            if (r0 != 0) goto L_0x01c2
            java.lang.Long r0 = r13.d(r3)     // Catch:{ all -> 0x0176 }
            r28 = r4
            r29 = r5
            long r4 = r0.longValue()     // Catch:{ all -> 0x0176 }
            double r4 = (double) r4     // Catch:{ all -> 0x0176 }
            double r18 = r4 * r20
            goto L_0x01c6
        L_0x01c2:
            r28 = r4
            r29 = r5
        L_0x01c6:
            r4 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x01de
            r4 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x01de
            long r4 = java.lang.Math.round(r18)     // Catch:{ all -> 0x0176 }
            boolean r0 = r12.equals(r11)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0208
            long r4 = -r4
            goto L_0x0208
        L_0x01de:
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Data lost. Currency value is too big. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            java.lang.Double r4 = java.lang.Double.valueOf(r18)     // Catch:{ all -> 0x0176 }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.s0()     // Catch:{ all -> 0x0176 }
            goto L_0x057d
        L_0x01fc:
            r28 = r4
            r29 = r5
            java.lang.Long r0 = r13.d(r3)     // Catch:{ all -> 0x0176 }
            long r4 = r0.longValue()     // Catch:{ all -> 0x0176 }
        L_0x0208:
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x018d
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r14.toUpperCase(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r0.matches(r11)     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x018d
            java.lang.String r11 = r9.concat(r0)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r0 = r0.B0(r10, r11)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0230
            java.lang.Object r0 = r0.f6896e     // Catch:{ all -> 0x0176 }
            boolean r9 = r0 instanceof java.lang.Long     // Catch:{ all -> 0x0176 }
            if (r9 != 0) goto L_0x0236
        L_0x0230:
            r9 = 1
            r16 = 0
            r17 = 0
            goto L_0x025f
        L_0x0236:
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x0176 }
            long r12 = r0.longValue()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r0 = new com.google.android.gms.measurement.internal.x6     // Catch:{ all -> 0x0176 }
            r9 = r10
            java.lang.String r10 = r8.f5885c     // Catch:{ all -> 0x0176 }
            com.google.android.gms.common.util.d r14 = r1.f()     // Catch:{ all -> 0x0176 }
            long r18 = r14.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            long r12 = r12 + r4
            java.lang.Long r14 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0176 }
            r5 = r8
            r12 = r18
            r4 = 1
            r16 = 0
            r17 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0176 }
            r10 = r9
            r4 = r16
        L_0x025d:
            r0 = r8
            goto L_0x02bb
        L_0x025f:
            com.google.android.gms.measurement.internal.u r12 = r1.F0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r13 = com.google.android.gms.measurement.internal.C1304d2.f6300U     // Catch:{ all -> 0x0176 }
            int r0 = r0.E(r10, r13)     // Catch:{ all -> 0x0176 }
            int r0 = r0 + -1
            N.C0722p.e(r10)     // Catch:{ all -> 0x0176 }
            r12.h()     // Catch:{ all -> 0x0176 }
            r12.j()     // Catch:{ all -> 0x0176 }
            android.database.sqlite.SQLiteDatabase r13 = r12.u0()     // Catch:{ SQLiteException -> 0x028a }
            java.lang.String r14 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x028a }
            java.lang.String[] r0 = new java.lang.String[]{r10, r10, r0}     // Catch:{ SQLiteException -> 0x028a }
            r13.execSQL(r14, r0)     // Catch:{ SQLiteException -> 0x028a }
            goto L_0x029e
        L_0x028a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r12 = r12.f5730a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q2 r12 = r12.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r12 = r12.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r13 = "Error pruning currencies. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            r12.c(r13, r14, r0)     // Catch:{ all -> 0x0176 }
        L_0x029e:
            com.google.android.gms.measurement.internal.x6 r0 = new com.google.android.gms.measurement.internal.x6     // Catch:{ all -> 0x0176 }
            r12 = r9
            r9 = r10
            java.lang.String r10 = r8.f5885c     // Catch:{ all -> 0x0176 }
            com.google.android.gms.common.util.d r13 = r1.f()     // Catch:{ all -> 0x0176 }
            long r13 = r13.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0176 }
            r5 = r8
            r12 = r13
            r8 = r0
            r14 = r4
            r4 = r16
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0176 }
            r10 = r9
            goto L_0x025d
        L_0x02bb:
            com.google.android.gms.measurement.internal.u r8 = r1.F0()     // Catch:{ all -> 0x0176 }
            boolean r8 = r8.A0(r0)     // Catch:{ all -> 0x0176 }
            if (r8 != 0) goto L_0x02f2
            com.google.android.gms.measurement.internal.q2 r8 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r8 = r8.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r9 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.X2 r12 = r1.f6668l     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.j2 r12 = r12.D()     // Catch:{ all -> 0x0176 }
            java.lang.String r13 = r0.f6894c     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = r12.c(r13)     // Catch:{ all -> 0x0176 }
            java.lang.Object r0 = r0.f6896e     // Catch:{ all -> 0x0176 }
            r8.d(r9, r11, r12, r0)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.y6 r9 = r1.f6656J     // Catch:{ all -> 0x0176 }
            r13 = 0
            r14 = 0
            r11 = 9
            r12 = 0
            r8.B(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0176 }
        L_0x02f2:
            java.lang.String r0 = r5.f5883a     // Catch:{ all -> 0x0176 }
            boolean r8 = com.google.android.gms.measurement.internal.z6.r0(r0)     // Catch:{ all -> 0x0176 }
            boolean r17 = r15.equals(r0)     // Catch:{ all -> 0x0176 }
            r1.N0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E r9 = r5.f5884b     // Catch:{ all -> 0x0176 }
            if (r9 != 0) goto L_0x0306
            r14 = 0
            goto L_0x0325
        L_0x0306:
            com.google.android.gms.measurement.internal.D r13 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x0176 }
            r13.<init>(r9)     // Catch:{ all -> 0x0176 }
            r14 = 0
        L_0x030d:
            boolean r16 = r13.hasNext()     // Catch:{ all -> 0x0176 }
            if (r16 == 0) goto L_0x0325
            java.lang.String r11 = r13.next()     // Catch:{ all -> 0x0176 }
            java.lang.Object r11 = r9.c(r11)     // Catch:{ all -> 0x0176 }
            boolean r12 = r11 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0176 }
            if (r12 == 0) goto L_0x030d
            android.os.Parcelable[] r11 = (android.os.Parcelable[]) r11     // Catch:{ all -> 0x0176 }
            int r11 = r11.length     // Catch:{ all -> 0x0176 }
            long r11 = (long) r11     // Catch:{ all -> 0x0176 }
            long r14 = r14 + r11
            goto L_0x030d
        L_0x0325:
            r11 = 1
            long r14 = r14 + r11
            r20 = r11
            r12 = r14
            r15 = r8
            com.google.android.gms.measurement.internal.u r8 = r1.F0()     // Catch:{ all -> 0x0176 }
            r14 = r9
            r11 = r10
            long r9 = r1.h()     // Catch:{ all -> 0x0176 }
            r22 = 0
            r19 = 0
            r31 = r20
            r20 = 0
            r16 = r14
            r14 = 1
            r18 = r16
            r16 = 0
            r21 = r18
            r18 = 0
            r24 = r5
            r4 = r31
            r31 = r22
            com.google.android.gms.measurement.internal.q r8 = r8.M0(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0176 }
            r10 = r11
            r18 = r15
            long r11 = r8.f6619b     // Catch:{ all -> 0x0176 }
            r1.B0()     // Catch:{ all -> 0x0176 }
            long r13 = com.google.android.gms.measurement.internal.C1371m.p()     // Catch:{ all -> 0x0176 }
            long r11 = r11 - r13
            int r9 = (r11 > r31 ? 1 : (r11 == r31 ? 0 : -1))
            r13 = 1000(0x3e8, double:4.94E-321)
            if (r9 <= 0) goto L_0x038b
            long r11 = r11 % r13
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0382
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            long r4 = r8.f6619b     // Catch:{ all -> 0x0176 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0176 }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x0176 }
        L_0x0382:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.s0()     // Catch:{ all -> 0x0176 }
            goto L_0x057d
        L_0x038b:
            if (r18 == 0) goto L_0x03dd
            long r11 = r8.f6618a     // Catch:{ all -> 0x0176 }
            r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6350n     // Catch:{ all -> 0x0176 }
            r15 = 0
            java.lang.Object r9 = r9.b(r15)     // Catch:{ all -> 0x0176 }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x0176 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0176 }
            r15 = r13
            long r13 = (long) r9     // Catch:{ all -> 0x0176 }
            long r11 = r11 - r13
            int r9 = (r11 > r31 ? 1 : (r11 == r31 ? 0 : -1))
            if (r9 <= 0) goto L_0x03dd
            long r11 = r11 % r15
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x03c2
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            long r4 = r8.f6618a     // Catch:{ all -> 0x0176 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0176 }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x0176 }
        L_0x03c2:
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.y6 r9 = r1.f6656J     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "_ev"
            r11 = r24
            java.lang.String r13 = r11.f5883a     // Catch:{ all -> 0x0176 }
            r14 = 0
            r11 = 16
            r8.B(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.s0()     // Catch:{ all -> 0x0176 }
            goto L_0x057d
        L_0x03dd:
            r11 = r24
            r9 = 1000000(0xf4240, float:1.401298E-39)
            if (r17 == 0) goto L_0x0427
            long r12 = r8.f6621d     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r14 = r1.B0()     // Catch:{ all -> 0x0176 }
            java.lang.String r15 = r2.f5765a     // Catch:{ all -> 0x0176 }
            r33 = r4
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6348m     // Catch:{ all -> 0x0176 }
            int r4 = r14.E(r15, r4)     // Catch:{ all -> 0x0176 }
            int r4 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x0176 }
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)     // Catch:{ all -> 0x0176 }
            long r14 = (long) r4     // Catch:{ all -> 0x0176 }
            long r12 = r12 - r14
            int r4 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r4 <= 0) goto L_0x042a
            int r0 = (r12 > r33 ? 1 : (r12 == r33 ? 0 : -1))
            if (r0 != 0) goto L_0x041e
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Too many error events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            long r4 = r8.f6621d     // Catch:{ all -> 0x0176 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0176 }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x0176 }
        L_0x041e:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.s0()     // Catch:{ all -> 0x0176 }
            goto L_0x057d
        L_0x0427:
            r33 = r4
            r5 = 0
        L_0x042a:
            android.os.Bundle r4 = r21.j()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "_o"
            java.lang.String r13 = r11.f5885c     // Catch:{ all -> 0x0176 }
            r8.A(r4, r12, r13)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = r2.f5761B     // Catch:{ all -> 0x0176 }
            boolean r8 = r8.P(r10, r12)     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "_r"
            if (r8 == 0) goto L_0x045b
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            java.lang.String r14 = "_dbg"
            java.lang.Long r15 = java.lang.Long.valueOf(r33)     // Catch:{ all -> 0x0176 }
            r8.A(r4, r14, r15)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            r8.A(r4, r12, r15)     // Catch:{ all -> 0x0176 }
        L_0x045b:
            java.lang.String r8 = "_s"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x047c
            com.google.android.gms.measurement.internal.u r8 = r1.F0()     // Catch:{ all -> 0x0176 }
            java.lang.String r14 = r2.f5765a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r8 = r8.B0(r14, r7)     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x047c
            java.lang.Object r8 = r8.f6896e     // Catch:{ all -> 0x0176 }
            boolean r14 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x047c
            com.google.android.gms.measurement.internal.z6 r14 = r1.N0()     // Catch:{ all -> 0x0176 }
            r14.A(r4, r7, r8)     // Catch:{ all -> 0x0176 }
        L_0x047c:
            com.google.android.gms.measurement.internal.m r7 = r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r8 = com.google.android.gms.measurement.internal.C1304d2.f6309Y0     // Catch:{ all -> 0x0176 }
            r15 = 0
            boolean r7 = r7.H(r15, r8)     // Catch:{ all -> 0x0176 }
            if (r7 == 0) goto L_0x04ad
            java.lang.String r7 = "am"
            boolean r7 = j$.util.Objects.equals(r13, r7)     // Catch:{ all -> 0x0176 }
            if (r7 == 0) goto L_0x04ad
            java.lang.String r7 = "_ai"
            boolean r0 = j$.util.Objects.equals(r0, r7)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x04ad
            java.lang.Object r0 = r4.get(r3)     // Catch:{ all -> 0x0176 }
            boolean r7 = r0 instanceof java.lang.String     // Catch:{ all -> 0x0176 }
            if (r7 == 0) goto L_0x04ad
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x04ad }
            double r7 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x04ad }
            r4.remove(r3)     // Catch:{ NumberFormatException -> 0x04ad }
            r4.putDouble(r3, r7)     // Catch:{ NumberFormatException -> 0x04ad }
        L_0x04ad:
            com.google.android.gms.measurement.internal.u r3 = r1.F0()     // Catch:{ all -> 0x0176 }
            N.C0722p.e(r10)     // Catch:{ all -> 0x0176 }
            r3.h()     // Catch:{ all -> 0x0176 }
            r3.j()     // Catch:{ all -> 0x0176 }
            android.database.sqlite.SQLiteDatabase r0 = r3.u0()     // Catch:{ SQLiteException -> 0x04e2 }
            com.google.android.gms.measurement.internal.X2 r7 = r3.f5730a     // Catch:{ SQLiteException -> 0x04e2 }
            com.google.android.gms.measurement.internal.m r7 = r7.w()     // Catch:{ SQLiteException -> 0x04e2 }
            com.google.android.gms.measurement.internal.c2 r8 = com.google.android.gms.measurement.internal.C1304d2.f6356q     // Catch:{ SQLiteException -> 0x04e2 }
            int r7 = r7.E(r10, r8)     // Catch:{ SQLiteException -> 0x04e2 }
            int r7 = java.lang.Math.min(r9, r7)     // Catch:{ SQLiteException -> 0x04e2 }
            int r7 = java.lang.Math.max(r5, r7)     // Catch:{ SQLiteException -> 0x04e2 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x04e2 }
            java.lang.String r8 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            java.lang.String[] r7 = new java.lang.String[]{r10, r7}     // Catch:{ SQLiteException -> 0x04e2 }
            int r0 = r0.delete(r6, r8, r7)     // Catch:{ SQLiteException -> 0x04e2 }
            long r7 = (long) r0
            goto L_0x04f8
        L_0x04e2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r7 = "Error deleting over the limit events. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            r3.c(r7, r8, r0)     // Catch:{ all -> 0x0176 }
            r7 = r31
        L_0x04f8:
            int r0 = (r7 > r31 ? 1 : (r7 == r31 ? 0 : -1))
            if (r0 <= 0) goto L_0x0511
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ all -> 0x0176 }
            java.lang.String r3 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0176 }
            r0.c(r3, r9, r7)     // Catch:{ all -> 0x0176 }
        L_0x0511:
            com.google.android.gms.measurement.internal.B r8 = new com.google.android.gms.measurement.internal.B     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.X2 r9 = r1.f6668l     // Catch:{ all -> 0x0176 }
            r3 = r10
            java.lang.String r10 = r11.f5885c     // Catch:{ all -> 0x0176 }
            r7 = r12
            java.lang.String r12 = r11.f5883a     // Catch:{ all -> 0x0176 }
            long r13 = r11.f5886d     // Catch:{ all -> 0x0176 }
            r15 = 0
            r11 = r3
            r17 = r4
            r8.<init>((com.google.android.gms.measurement.internal.X2) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (long) r13, (long) r15, (android.os.Bundle) r17)     // Catch:{ all -> 0x0176 }
            r0 = r8
            r10 = r11
            com.google.android.gms.measurement.internal.u r3 = r1.F0()     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = r0.f5745b     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.C r3 = r3.v0(r10, r4)     // Catch:{ all -> 0x0176 }
            if (r3 != 0) goto L_0x05a2
            com.google.android.gms.measurement.internal.u r3 = r1.F0()     // Catch:{ all -> 0x0176 }
            long r11 = r3.E(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r3 = r1.B0()     // Catch:{ all -> 0x0176 }
            int r3 = r3.z(r10)     // Catch:{ all -> 0x0176 }
            long r13 = (long) r3     // Catch:{ all -> 0x0176 }
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 < 0) goto L_0x0585
            if (r18 == 0) goto L_0x0585
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.j2 r5 = r9.D()     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = r5.a(r4)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r5 = r1.B0()     // Catch:{ all -> 0x0176 }
            int r5 = r5.z(r10)     // Catch:{ all -> 0x0176 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0176 }
            r0.d(r2, r3, r4, r5)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.z6 r8 = r1.N0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.y6 r9 = r1.f6656J     // Catch:{ all -> 0x0176 }
            r13 = 0
            r14 = 0
            r11 = 8
            r12 = 0
            r8.B(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0176 }
        L_0x057d:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()
            r0.t0()
            return
        L_0x0585:
            com.google.android.gms.measurement.internal.C r8 = new com.google.android.gms.measurement.internal.C     // Catch:{ all -> 0x0176 }
            long r11 = r0.f5747d     // Catch:{ all -> 0x0176 }
            r23 = 0
            r24 = 0
            r17 = r11
            r11 = 0
            r13 = 0
            r15 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r9 = r10
            r10 = r4
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)     // Catch:{ all -> 0x0176 }
            r3 = r0
            goto L_0x05b0
        L_0x05a2:
            long r10 = r3.f5796f     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.B r8 = r0.a(r9, r10)     // Catch:{ all -> 0x0176 }
            long r9 = r8.f5747d     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.C r0 = r3.a(r9)     // Catch:{ all -> 0x0176 }
            r3 = r8
            r8 = r0
        L_0x05b0:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.w0(r8)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.T2 r0 = r1.b()     // Catch:{ all -> 0x0176 }
            r0.h()     // Catch:{ all -> 0x0176 }
            r1.O0()     // Catch:{ all -> 0x0176 }
            N.C0722p.k(r3)     // Catch:{ all -> 0x0176 }
            N.C0722p.k(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r3.f5744a     // Catch:{ all -> 0x0176 }
            N.C0722p.e(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = r2.f5765a     // Catch:{ all -> 0x0176 }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x0176 }
            N.C0722p.a(r0)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.Z2 r8 = com.google.android.gms.internal.measurement.C1051a3.k0()     // Catch:{ all -> 0x0176 }
            r9 = 1
            r8.T(r9)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = "android"
            r8.t(r0)     // Catch:{ all -> 0x0176 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x05eb
            r8.E(r4)     // Catch:{ all -> 0x0176 }
        L_0x05eb:
            java.lang.String r0 = r2.f5768d     // Catch:{ all -> 0x0176 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0176 }
            if (r10 != 0) goto L_0x05f6
            r8.C(r0)     // Catch:{ all -> 0x0176 }
        L_0x05f6:
            java.lang.String r0 = r2.f5767c     // Catch:{ all -> 0x0176 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0176 }
            if (r10 != 0) goto L_0x0601
            r8.F(r0)     // Catch:{ all -> 0x0176 }
        L_0x0601:
            java.lang.String r0 = r2.f5785u     // Catch:{ all -> 0x0176 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0176 }
            if (r10 != 0) goto L_0x060c
            r8.F0(r0)     // Catch:{ all -> 0x0176 }
        L_0x060c:
            long r10 = r2.f5774j     // Catch:{ all -> 0x0176 }
            r12 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0619
            int r0 = (int) r10     // Catch:{ all -> 0x0176 }
            r8.u0(r0)     // Catch:{ all -> 0x0176 }
        L_0x0619:
            long r10 = r2.f5769e     // Catch:{ all -> 0x0176 }
            r8.G(r10)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r2.f5766b     // Catch:{ all -> 0x0176 }
            boolean r10 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0176 }
            if (r10 != 0) goto L_0x0629
            r8.o0(r0)     // Catch:{ all -> 0x0176 }
        L_0x0629:
            java.lang.Object r0 = N.C0722p.k(r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E3 r0 = r1.g(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r2.f5783s     // Catch:{ all -> 0x0176 }
            r11 = 100
            com.google.android.gms.measurement.internal.E3 r10 = com.google.android.gms.measurement.internal.E3.f(r10, r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E3 r0 = r0.s(r10)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r0.k()     // Catch:{ all -> 0x0176 }
            r8.E0(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r10 = r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r12 = com.google.android.gms.measurement.internal.C1304d2.f6293Q0     // Catch:{ all -> 0x0176 }
            boolean r10 = r10.H(r4, r12)     // Catch:{ all -> 0x0176 }
            if (r10 == 0) goto L_0x06f2
            com.google.android.gms.measurement.internal.z6 r10 = r1.N0()     // Catch:{ all -> 0x0176 }
            boolean r4 = r10.L(r4)     // Catch:{ all -> 0x0176 }
            if (r4 == 0) goto L_0x06f2
            int r4 = r2.f5790z     // Catch:{ all -> 0x0176 }
            r8.b0(r4)     // Catch:{ all -> 0x0176 }
            long r12 = r2.f5760A     // Catch:{ all -> 0x0176 }
            f0.w r4 = f0.w.AD_STORAGE     // Catch:{ all -> 0x0176 }
            boolean r0 = r0.o(r4)     // Catch:{ all -> 0x0176 }
            r14 = 32
            if (r0 != 0) goto L_0x0679
            int r0 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r0 == 0) goto L_0x0679
            r16 = -2
            long r12 = r12 & r16
            long r12 = r12 | r14
        L_0x0679:
            int r0 = (r12 > r33 ? 1 : (r12 == r33 ? 0 : -1))
            if (r0 != 0) goto L_0x067f
            r0 = r9
            goto L_0x0680
        L_0x067f:
            r0 = r5
        L_0x0680:
            r8.K0(r0)     // Catch:{ all -> 0x0176 }
            int r0 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r0 != 0) goto L_0x0689
            goto L_0x06f2
        L_0x0689:
            com.google.android.gms.internal.measurement.z2 r0 = com.google.android.gms.internal.measurement.A2.M()     // Catch:{ all -> 0x0176 }
            long r16 = r12 & r33
            int r4 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x0695
            r4 = r9
            goto L_0x0696
        L_0x0695:
            r4 = r5
        L_0x0696:
            r0.r(r4)     // Catch:{ all -> 0x0176 }
            r16 = 2
            long r16 = r12 & r16
            int r4 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06a3
            r4 = r9
            goto L_0x06a4
        L_0x06a3:
            r4 = r5
        L_0x06a4:
            r0.s(r4)     // Catch:{ all -> 0x0176 }
            r16 = 4
            long r16 = r12 & r16
            int r4 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06b1
            r4 = r9
            goto L_0x06b2
        L_0x06b1:
            r4 = r5
        L_0x06b2:
            r0.t(r4)     // Catch:{ all -> 0x0176 }
            r16 = 8
            long r16 = r12 & r16
            int r4 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06bf
            r4 = r9
            goto L_0x06c0
        L_0x06bf:
            r4 = r5
        L_0x06c0:
            r0.w(r4)     // Catch:{ all -> 0x0176 }
            r16 = 16
            long r16 = r12 & r16
            int r4 = (r16 > r31 ? 1 : (r16 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06cd
            r4 = r9
            goto L_0x06ce
        L_0x06cd:
            r4 = r5
        L_0x06ce:
            r0.x(r4)     // Catch:{ all -> 0x0176 }
            long r14 = r14 & r12
            int r4 = (r14 > r31 ? 1 : (r14 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06d8
            r4 = r9
            goto L_0x06d9
        L_0x06d8:
            r4 = r5
        L_0x06d9:
            r0.y(r4)     // Catch:{ all -> 0x0176 }
            r14 = 64
            long r12 = r12 & r14
            int r4 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06e5
            r13 = r9
            goto L_0x06e6
        L_0x06e5:
            r13 = r5
        L_0x06e6:
            r0.z(r13)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.A2 r0 = (com.google.android.gms.internal.measurement.A2) r0     // Catch:{ all -> 0x0176 }
            r8.c0(r0)     // Catch:{ all -> 0x0176 }
        L_0x06f2:
            long r12 = r2.f5770f     // Catch:{ all -> 0x0176 }
            int r0 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r0 == 0) goto L_0x06fb
            r8.R(r12)     // Catch:{ all -> 0x0176 }
        L_0x06fb:
            long r12 = r2.f5781q     // Catch:{ all -> 0x0176 }
            r8.C0(r12)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u6 r4 = r1.K0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q6 r0 = r4.f6129b     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.X2 r0 = r0.f6668l     // Catch:{ all -> 0x0176 }
            android.content.Context r0 = r0.e()     // Catch:{ all -> 0x0176 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "com.google.android.gms.measurement"
            android.net.Uri r10 = com.google.android.gms.internal.measurement.C1061b4.a(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.Z1 r12 = com.google.android.gms.measurement.internal.Z1.f6191a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.Q3 r0 = com.google.android.gms.internal.measurement.Q3.b(r0, r10, r12)     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x0721
            java.util.Map r0 = java.util.Collections.EMPTY_MAP     // Catch:{ all -> 0x0176 }
            goto L_0x0725
        L_0x0721:
            java.util.Map r0 = r0.c()     // Catch:{ all -> 0x0176 }
        L_0x0725:
            if (r0 == 0) goto L_0x072d
            boolean r10 = r0.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r10 == 0) goto L_0x0730
        L_0x072d:
            r10 = 0
            goto L_0x07ad
        L_0x0730:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0176 }
            r10.<init>()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r12 = com.google.android.gms.measurement.internal.C1304d2.f6331g0     // Catch:{ all -> 0x0176 }
            r15 = 0
            java.lang.Object r12 = r12.b(r15)     // Catch:{ all -> 0x0176 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0176 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0176 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0176 }
            java.util.Iterator r13 = r0.iterator()     // Catch:{ all -> 0x0176 }
        L_0x074a:
            boolean r0 = r13.hasNext()     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x07a6
            java.lang.Object r0 = r13.next()     // Catch:{ all -> 0x0176 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0176 }
            java.lang.Object r14 = r0.getKey()     // Catch:{ all -> 0x0176 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x0176 }
            java.lang.String r15 = "measurement.id."
            boolean r14 = r14.startsWith(r15)     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x074a
            java.lang.Object r0 = r0.getValue()     // Catch:{ NumberFormatException -> 0x0795 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0795 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0795 }
            if (r0 == 0) goto L_0x074a
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0795 }
            r10.add(r0)     // Catch:{ NumberFormatException -> 0x0795 }
            int r0 = r10.size()     // Catch:{ NumberFormatException -> 0x0795 }
            if (r0 < r12) goto L_0x074a
            com.google.android.gms.measurement.internal.X2 r0 = r4.f5730a     // Catch:{ NumberFormatException -> 0x0795 }
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()     // Catch:{ NumberFormatException -> 0x0795 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ NumberFormatException -> 0x0795 }
            java.lang.String r14 = "Too many experiment IDs. Number of IDs"
            int r15 = r10.size()     // Catch:{ NumberFormatException -> 0x0795 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ NumberFormatException -> 0x0795 }
            r0.b(r14, r15)     // Catch:{ NumberFormatException -> 0x0795 }
            goto L_0x07a6
        L_0x0795:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r14 = r4.f5730a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q2 r14 = r14.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r14 = r14.r()     // Catch:{ all -> 0x0176 }
            java.lang.String r15 = "Experiment ID NumberFormatException"
            r14.b(r15, r0)     // Catch:{ all -> 0x0176 }
            goto L_0x074a
        L_0x07a6:
            boolean r0 = r10.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x07ad
            goto L_0x072d
        L_0x07ad:
            if (r10 == 0) goto L_0x07b2
            r8.B0(r10)     // Catch:{ all -> 0x0176 }
        L_0x07b2:
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6317b1     // Catch:{ all -> 0x0176 }
            r15 = 0
            boolean r0 = r0.H(r15, r4)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x07c4
            java.lang.String r0 = ""
            r8.j0(r0)     // Catch:{ all -> 0x0176 }
        L_0x07c4:
            java.lang.String r0 = r2.f5765a     // Catch:{ all -> 0x0176 }
            java.lang.Object r4 = N.C0722p.k(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E3 r4 = r1.g(r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r2.f5783s     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E3 r10 = com.google.android.gms.measurement.internal.E3.f(r10, r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E3 r4 = r4.s(r10)     // Catch:{ all -> 0x0176 }
            f0.w r10 = f0.w.AD_STORAGE     // Catch:{ all -> 0x0176 }
            boolean r11 = r4.o(r10)     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x086f
            boolean r11 = r2.f5778n     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x086f
            com.google.android.gms.measurement.internal.y5 r11 = r1.f6665i     // Catch:{ all -> 0x0176 }
            android.util.Pair r11 = r11.m(r0, r4)     // Catch:{ all -> 0x0176 }
            java.lang.Object r12 = r11.first     // Catch:{ all -> 0x0176 }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x0176 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0176 }
            if (r12 != 0) goto L_0x086f
            java.lang.Object r12 = r11.first     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0176 }
            r8.J(r12)     // Catch:{ all -> 0x0176 }
            java.lang.Object r12 = r11.second     // Catch:{ all -> 0x0176 }
            if (r12 == 0) goto L_0x080a
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0176 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0176 }
            r8.M(r12)     // Catch:{ all -> 0x0176 }
        L_0x080a:
            java.lang.String r12 = r3.f5745b     // Catch:{ all -> 0x0176 }
            r13 = r29
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0176 }
            if (r12 != 0) goto L_0x086f
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "00000000-0000-0000-0000-000000000000"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0176 }
            if (r11 != 0) goto L_0x086f
            com.google.android.gms.measurement.internal.u r11 = r1.F0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.w2 r11 = r11.J0(r0)     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x086f
            boolean r12 = r11.d0()     // Catch:{ all -> 0x0176 }
            if (r12 == 0) goto L_0x086f
            r15 = 0
            r1.w(r0, r5, r15, r15)     // Catch:{ all -> 0x0176 }
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ all -> 0x0176 }
            r12.<init>()     // Catch:{ all -> 0x0176 }
            java.lang.Long r14 = r11.f0()     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x0852
            java.lang.String r15 = "_pfo"
            r16 = r6
            long r5 = r14.longValue()     // Catch:{ all -> 0x0176 }
            r14 = r10
            r9 = r31
            long r5 = java.lang.Math.max(r9, r5)     // Catch:{ all -> 0x0176 }
            r12.putLong(r15, r5)     // Catch:{ all -> 0x0176 }
            goto L_0x0855
        L_0x0852:
            r16 = r6
            r14 = r10
        L_0x0855:
            java.lang.Long r5 = r11.h0()     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x0864
            java.lang.String r6 = "_uwa"
            long r9 = r5.longValue()     // Catch:{ all -> 0x0176 }
            r12.putLong(r6, r9)     // Catch:{ all -> 0x0176 }
        L_0x0864:
            r5 = r33
            r12.putLong(r7, r5)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.y6 r5 = r1.f6656J     // Catch:{ all -> 0x0176 }
            r5.b(r0, r13, r12)     // Catch:{ all -> 0x0176 }
            goto L_0x0872
        L_0x086f:
            r16 = r6
            r14 = r10
        L_0x0872:
            com.google.android.gms.measurement.internal.X2 r5 = r1.f6668l     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.A r6 = r5.K()     // Catch:{ all -> 0x0176 }
            r6.l()     // Catch:{ all -> 0x0176 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0176 }
            r8.y(r6)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.A r6 = r5.K()     // Catch:{ all -> 0x0176 }
            r6.l()     // Catch:{ all -> 0x0176 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0176 }
            r8.x(r6)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.A r6 = r5.K()     // Catch:{ all -> 0x0176 }
            long r9 = r6.o()     // Catch:{ all -> 0x0176 }
            int r6 = (int) r9     // Catch:{ all -> 0x0176 }
            r8.B(r6)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.A r6 = r5.K()     // Catch:{ all -> 0x0176 }
            java.lang.String r6 = r6.p()     // Catch:{ all -> 0x0176 }
            r8.A(r6)     // Catch:{ all -> 0x0176 }
            long r9 = r2.f5787w     // Catch:{ all -> 0x0176 }
            r8.J0(r9)     // Catch:{ all -> 0x0176 }
            boolean r6 = r5.g()     // Catch:{ all -> 0x0176 }
            if (r6 == 0) goto L_0x08bb
            r8.D()     // Catch:{ all -> 0x0176 }
            r15 = 0
            boolean r6 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x08bb
            r8.x0(r15)     // Catch:{ all -> 0x0176 }
        L_0x08bb:
            com.google.android.gms.measurement.internal.u r6 = r1.F0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.w2 r6 = r6.J0(r0)     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x0923
            com.google.android.gms.measurement.internal.w2 r6 = new com.google.android.gms.measurement.internal.w2     // Catch:{ all -> 0x0176 }
            r6.<init>(r5, r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r1.p(r4)     // Catch:{ all -> 0x0176 }
            r6.q0(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r2.f5775k     // Catch:{ all -> 0x0176 }
            r6.y0(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r2.f5766b     // Catch:{ all -> 0x0176 }
            r6.s0(r5)     // Catch:{ all -> 0x0176 }
            boolean r5 = r4.o(r14)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x08ec
            com.google.android.gms.measurement.internal.y5 r5 = r1.f6665i     // Catch:{ all -> 0x0176 }
            boolean r9 = r2.f5778n     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r5.o(r0, r9)     // Catch:{ all -> 0x0176 }
            r6.w0(r5)     // Catch:{ all -> 0x0176 }
        L_0x08ec:
            r9 = 0
            r6.f(r9)     // Catch:{ all -> 0x0176 }
            r6.A0(r9)     // Catch:{ all -> 0x0176 }
            r6.C0(r9)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r2.f5767c     // Catch:{ all -> 0x0176 }
            r6.E0(r5)     // Catch:{ all -> 0x0176 }
            long r9 = r2.f5774j     // Catch:{ all -> 0x0176 }
            r6.G0(r9)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r2.f5768d     // Catch:{ all -> 0x0176 }
            r6.I0(r5)     // Catch:{ all -> 0x0176 }
            long r9 = r2.f5769e     // Catch:{ all -> 0x0176 }
            r6.K0(r9)     // Catch:{ all -> 0x0176 }
            long r9 = r2.f5770f     // Catch:{ all -> 0x0176 }
            r6.a(r9)     // Catch:{ all -> 0x0176 }
            boolean r5 = r2.f5772h     // Catch:{ all -> 0x0176 }
            r6.e(r5)     // Catch:{ all -> 0x0176 }
            long r9 = r2.f5781q     // Catch:{ all -> 0x0176 }
            r6.c(r9)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r5 = r1.F0()     // Catch:{ all -> 0x0176 }
            r9 = 0
            r5.K0(r6, r9, r9)     // Catch:{ all -> 0x0176 }
            goto L_0x0924
        L_0x0923:
            r9 = 0
        L_0x0924:
            f0.w r5 = f0.w.ANALYTICS_STORAGE     // Catch:{ all -> 0x0176 }
            boolean r4 = r4.o(r5)     // Catch:{ all -> 0x0176 }
            if (r4 == 0) goto L_0x0943
            java.lang.String r4 = r6.p0()     // Catch:{ all -> 0x0176 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0176 }
            if (r4 != 0) goto L_0x0943
            java.lang.String r4 = r6.p0()     // Catch:{ all -> 0x0176 }
            java.lang.Object r4 = N.C0722p.k(r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0176 }
            r8.P(r4)     // Catch:{ all -> 0x0176 }
        L_0x0943:
            java.lang.String r4 = r6.x0()     // Catch:{ all -> 0x0176 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0176 }
            if (r4 != 0) goto L_0x095a
            java.lang.String r4 = r6.x0()     // Catch:{ all -> 0x0176 }
            java.lang.Object r4 = N.C0722p.k(r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0176 }
            r8.s0(r4)     // Catch:{ all -> 0x0176 }
        L_0x095a:
            com.google.android.gms.measurement.internal.u r4 = r1.F0()     // Catch:{ all -> 0x0176 }
            java.util.List r0 = r4.C0(r0)     // Catch:{ all -> 0x0176 }
            r14 = r9
        L_0x0963:
            int r4 = r0.size()     // Catch:{ all -> 0x0176 }
            if (r14 >= r4) goto L_0x09c7
            com.google.android.gms.internal.measurement.q3 r4 = com.google.android.gms.internal.measurement.C1203r3.Q()     // Catch:{ all -> 0x0176 }
            java.lang.Object r5 = r0.get(r14)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r5 = (com.google.android.gms.measurement.internal.x6) r5     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r5.f6894c     // Catch:{ all -> 0x0176 }
            r4.s(r5)     // Catch:{ all -> 0x0176 }
            java.lang.Object r5 = r0.get(r14)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r5 = (com.google.android.gms.measurement.internal.x6) r5     // Catch:{ all -> 0x0176 }
            long r10 = r5.f6895d     // Catch:{ all -> 0x0176 }
            r4.r(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u6 r5 = r1.K0()     // Catch:{ all -> 0x0176 }
            java.lang.Object r10 = r0.get(r14)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r10 = (com.google.android.gms.measurement.internal.x6) r10     // Catch:{ all -> 0x0176 }
            java.lang.Object r10 = r10.f6896e     // Catch:{ all -> 0x0176 }
            r5.G(r4, r10)     // Catch:{ all -> 0x0176 }
            r8.Z0(r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = "_sid"
            java.lang.Object r5 = r0.get(r14)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.x6 r5 = (com.google.android.gms.measurement.internal.x6) r5     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r5.f6894c     // Catch:{ all -> 0x0176 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0176 }
            if (r4 == 0) goto L_0x09c4
            long r4 = r6.Z()     // Catch:{ all -> 0x0176 }
            r31 = 0
            int r4 = (r4 > r31 ? 1 : (r4 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x09c4
            com.google.android.gms.measurement.internal.u6 r4 = r1.K0()     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r2.f5785u     // Catch:{ all -> 0x0176 }
            long r4 = r4.U(r5)     // Catch:{ all -> 0x0176 }
            long r10 = r6.Z()     // Catch:{ all -> 0x0176 }
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x09c4
            r8.G0()     // Catch:{ all -> 0x0176 }
        L_0x09c4:
            int r14 = r14 + 1
            goto L_0x0963
        L_0x09c7:
            com.google.android.gms.measurement.internal.u r2 = r1.F0()     // Catch:{ IOException -> 0x0b02 }
            com.google.android.gms.internal.measurement.e5 r0 = r8.o()     // Catch:{ IOException -> 0x0b02 }
            r4 = r0
            com.google.android.gms.internal.measurement.a3 r4 = (com.google.android.gms.internal.measurement.C1051a3) r4     // Catch:{ IOException -> 0x0b02 }
            r2.h()     // Catch:{ IOException -> 0x0b02 }
            r2.j()     // Catch:{ IOException -> 0x0b02 }
            N.C0722p.k(r4)     // Catch:{ IOException -> 0x0b02 }
            java.lang.String r0 = r4.F()     // Catch:{ IOException -> 0x0b02 }
            N.C0722p.e(r0)     // Catch:{ IOException -> 0x0b02 }
            byte[] r0 = r4.e()     // Catch:{ IOException -> 0x0b02 }
            com.google.android.gms.measurement.internal.q6 r5 = r2.f6129b     // Catch:{ IOException -> 0x0b02 }
            com.google.android.gms.measurement.internal.u6 r5 = r5.K0()     // Catch:{ IOException -> 0x0b02 }
            long r5 = r5.T(r0)     // Catch:{ IOException -> 0x0b02 }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b02 }
            r10.<init>()     // Catch:{ IOException -> 0x0b02 }
            java.lang.String r11 = r4.F()     // Catch:{ IOException -> 0x0b02 }
            r12 = r28
            r10.put(r12, r11)     // Catch:{ IOException -> 0x0b02 }
            java.lang.Long r11 = java.lang.Long.valueOf(r5)     // Catch:{ IOException -> 0x0b02 }
            r13 = r27
            r10.put(r13, r11)     // Catch:{ IOException -> 0x0b02 }
            java.lang.String r11 = "metadata"
            r10.put(r11, r0)     // Catch:{ IOException -> 0x0b02 }
            android.database.sqlite.SQLiteDatabase r0 = r2.u0()     // Catch:{ SQLiteException -> 0x0b04 }
            java.lang.String r11 = "raw_events_metadata"
            r14 = 4
            r15 = 0
            r0.insertWithOnConflict(r11, r15, r10, r14)     // Catch:{ SQLiteException -> 0x0b04 }
            com.google.android.gms.measurement.internal.u r2 = r1.F0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.E r0 = r3.f5749f     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.D r4 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x0176 }
            r4.<init>(r0)     // Catch:{ all -> 0x0176 }
        L_0x0a22:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0a35
            java.lang.String r0 = r4.next()     // Catch:{ all -> 0x0176 }
            boolean r0 = r7.equals(r0)     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0a22
        L_0x0a32:
            r30 = 1
            goto L_0x0a75
        L_0x0a35:
            com.google.android.gms.measurement.internal.P2 r0 = r1.D0()     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = r3.f5744a     // Catch:{ all -> 0x0176 }
            java.lang.String r7 = r3.f5745b     // Catch:{ all -> 0x0176 }
            boolean r0 = r0.E(r4, r7)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r33 = r1.F0()     // Catch:{ all -> 0x0176 }
            long r34 = r1.h()     // Catch:{ all -> 0x0176 }
            r42 = 0
            r43 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r36 = r4
            com.google.android.gms.measurement.internal.q r4 = r33.L0(r34, r36, r37, r38, r39, r40, r41, r42, r43)     // Catch:{ all -> 0x0176 }
            r7 = r36
            if (r0 == 0) goto L_0x0a73
            long r10 = r4.f6622e     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.m r0 = r1.B0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6354p     // Catch:{ all -> 0x0176 }
            int r0 = r0.E(r7, r4)     // Catch:{ all -> 0x0176 }
            long r7 = (long) r0     // Catch:{ all -> 0x0176 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0a73
            goto L_0x0a32
        L_0x0a73:
            r30 = r9
        L_0x0a75:
            r2.h()     // Catch:{ all -> 0x0176 }
            r2.j()     // Catch:{ all -> 0x0176 }
            N.C0722p.k(r3)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r3.f5744a     // Catch:{ all -> 0x0176 }
            N.C0722p.e(r0)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q6 r4 = r2.f6129b     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u6 r4 = r4.K0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.O2 r4 = r4.J(r3)     // Catch:{ all -> 0x0176 }
            byte[] r4 = r4.e()     // Catch:{ all -> 0x0176 }
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0176 }
            r7.<init>()     // Catch:{ all -> 0x0176 }
            r7.put(r12, r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r8 = "name"
            java.lang.String r9 = r3.f5745b     // Catch:{ all -> 0x0176 }
            r7.put(r8, r9)     // Catch:{ all -> 0x0176 }
            java.lang.String r8 = "timestamp"
            long r9 = r3.f5747d     // Catch:{ all -> 0x0176 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0176 }
            r7.put(r8, r9)     // Catch:{ all -> 0x0176 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0176 }
            r7.put(r13, r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = "data"
            r7.put(r5, r4)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = "realtime"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r30)     // Catch:{ all -> 0x0176 }
            r7.put(r4, r5)     // Catch:{ all -> 0x0176 }
            android.database.sqlite.SQLiteDatabase r4 = r2.u0()     // Catch:{ SQLiteException -> 0x0ae5 }
            r5 = r16
            r15 = 0
            long r4 = r4.insert(r5, r15, r7)     // Catch:{ SQLiteException -> 0x0ae5 }
            r6 = -1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0ae7
            com.google.android.gms.measurement.internal.X2 r4 = r2.f5730a     // Catch:{ SQLiteException -> 0x0ae5 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ SQLiteException -> 0x0ae5 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ SQLiteException -> 0x0ae5 }
            java.lang.String r5 = "Failed to insert raw event (got -1). appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C1402q2.x(r0)     // Catch:{ SQLiteException -> 0x0ae5 }
            r4.b(r5, r0)     // Catch:{ SQLiteException -> 0x0ae5 }
            goto L_0x0b32
        L_0x0ae5:
            r0 = move-exception
            goto L_0x0aec
        L_0x0ae7:
            r9 = 0
            r1.f6671o = r9     // Catch:{ all -> 0x0176 }
            goto L_0x0b32
        L_0x0aec:
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r3 = r3.f5744a     // Catch:{ all -> 0x0176 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C1402q2.x(r3)     // Catch:{ all -> 0x0176 }
            r2.c(r4, r3, r0)     // Catch:{ all -> 0x0176 }
            goto L_0x0b32
        L_0x0b02:
            r0 = move-exception
            goto L_0x0b1d
        L_0x0b04:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a     // Catch:{ IOException -> 0x0b02 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ IOException -> 0x0b02 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ IOException -> 0x0b02 }
            java.lang.String r3 = "Error storing raw event metadata. appId"
            java.lang.String r4 = r4.F()     // Catch:{ IOException -> 0x0b02 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ IOException -> 0x0b02 }
            r2.c(r3, r4, r0)     // Catch:{ IOException -> 0x0b02 }
            throw r0     // Catch:{ IOException -> 0x0b02 }
        L_0x0b1d:
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.o()     // Catch:{ all -> 0x0176 }
            java.lang.String r3 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r8.D()     // Catch:{ all -> 0x0176 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r4)     // Catch:{ all -> 0x0176 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x0176 }
        L_0x0b32:
            com.google.android.gms.measurement.internal.u r0 = r1.F0()     // Catch:{ all -> 0x0176 }
            r0.s0()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.u r0 = r1.F0()
            r0.t0()
            r1.R()
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r25
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r0.b(r3, r2)
            return
        L_0x0b63:
            com.google.android.gms.measurement.internal.u r2 = r1.F0()
            r2.t0()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.m(com.google.android.gms.measurement.internal.G, com.google.android.gms.measurement.internal.B6):void");
    }

    /* access modifiers changed from: package-private */
    public final void m0(C1341i iVar, B6 b6) {
        Bundle bundle;
        C0722p.k(iVar);
        C0722p.e(iVar.f6470a);
        C0722p.k(iVar.f6472c);
        C0722p.e(iVar.f6472c.f6788b);
        b().h();
        O0();
        if (X(b6)) {
            if (!b6.f5772h) {
                o0(b6);
                return;
            }
            F0().r0();
            try {
                o0(b6);
                String str = (String) C0722p.k(iVar.f6470a);
                C1341i F02 = F0().F0(str, iVar.f6472c.f6788b);
                if (F02 != null) {
                    a().v().c("Removing conditional user property", iVar.f6470a, this.f6668l.D().c(iVar.f6472c.f6788b));
                    F0().G0(str, iVar.f6472c.f6788b);
                    if (F02.f6474e) {
                        F0().z0(str, iVar.f6472c.f6788b);
                    }
                    G g5 = iVar.f6480k;
                    if (g5 != null) {
                        E e5 = g5.f5884b;
                        if (e5 != null) {
                            bundle = e5.j();
                        } else {
                            bundle = null;
                        }
                        m((G) C0722p.k(N0().R(str, ((G) C0722p.k(g5)).f5883a, bundle, F02.f6471b, g5.f5886d, true, true)), b6);
                    }
                } else {
                    a().r().c("Conditional user property doesn't exist", C1402q2.x(iVar.f6470a), this.f6668l.D().c(iVar.f6472c.f6788b));
                }
                F0().s0();
                F0().t0();
            } catch (Throwable th) {
                Throwable th2 = th;
                F0().t0();
                throw th2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void n(C1443w2 w2Var, Z2 z22) {
        C1203r3 r3Var;
        b().h();
        O0();
        C1385o d5 = C1385o.d(z22.U());
        String o02 = w2Var.o0();
        b().h();
        O0();
        E3 g5 = g(o02);
        v vVar = v.UNINITIALIZED;
        int ordinal = g5.p().ordinal();
        if (ordinal == 1) {
            d5.c(w.AD_STORAGE, C1378n.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            d5.b(w.AD_STORAGE, g5.b());
        } else {
            d5.c(w.AD_STORAGE, C1378n.FAILSAFE);
        }
        int ordinal2 = g5.q().ordinal();
        if (ordinal2 == 1) {
            d5.c(w.ANALYTICS_STORAGE, C1378n.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            d5.b(w.ANALYTICS_STORAGE, g5.b());
        } else {
            d5.c(w.ANALYTICS_STORAGE, C1378n.FAILSAFE);
        }
        String o03 = w2Var.o0();
        b().h();
        O0();
        C1454y T02 = T0(o03, R0(o03), g(o03), d5);
        z22.X(((Boolean) C0722p.k(T02.j())).booleanValue());
        if (!TextUtils.isEmpty(T02.k())) {
            z22.Z(T02.k());
        }
        b().h();
        O0();
        Iterator it = z22.U0().iterator();
        while (true) {
            if (!it.hasNext()) {
                r3Var = null;
                break;
            }
            r3Var = (C1203r3) it.next();
            if ("_npa".equals(r3Var.H())) {
                break;
            }
        }
        if (r3Var != null) {
            w wVar = w.AD_PERSONALIZATION;
            if (d5.a(wVar) == C1378n.UNSET) {
                x6 B02 = F0().B0(w2Var.o0(), "_npa");
                if (B02 != null) {
                    String str = B02.f6893b;
                    if ("tcf".equals(str)) {
                        d5.c(wVar, C1378n.TCF);
                    } else if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equals(str)) {
                        d5.c(wVar, C1378n.API);
                    } else {
                        d5.c(wVar, C1378n.MANIFEST);
                    }
                } else {
                    Boolean R4 = w2Var.R();
                    if (R4 == null || ((R4.booleanValue() && r3Var.L() != 1) || (!R4.booleanValue() && r3Var.L() != 0))) {
                        d5.c(wVar, C1378n.API);
                    } else {
                        d5.c(wVar, C1378n.MANIFEST);
                    }
                }
            }
        } else {
            int I4 = I(w2Var.o0(), d5);
            C1195q3 Q4 = C1203r3.Q();
            Q4.s("_npa");
            Q4.r(f().currentTimeMillis());
            Q4.x((long) I4);
            z22.Y0((C1203r3) Q4.o());
            a().w().c("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(I4));
        }
        z22.V(d5.toString());
        boolean S4 = this.f6657a.S(w2Var.o0());
        List L02 = z22.L0();
        int i5 = 0;
        for (int i6 = 0; i6 < L02.size(); i6++) {
            if ("_tcf".equals(((O2) L02.get(i6)).I())) {
                N2 n22 = (N2) ((O2) L02.get(i6)).q();
                List r5 = n22.r();
                int i7 = 0;
                while (true) {
                    if (i7 >= r5.size()) {
                        break;
                    } else if ("_tcfd".equals(((S2) r5.get(i7)).G())) {
                        String I5 = ((S2) r5.get(i7)).I();
                        if (S4 && I5.length() > 4) {
                            char[] charArray = I5.toCharArray();
                            int i8 = 1;
                            while (true) {
                                if (i8 >= 64) {
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i8)) {
                                    i5 = i8;
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5 | 1);
                            I5 = String.valueOf(charArray);
                        }
                        R2 R5 = S2.R();
                        R5.s("_tcfd");
                        R5.w(I5);
                        n22.x(i7, R5);
                    } else {
                        i7++;
                    }
                }
                z22.P0(i6, n22);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void n0(B6 b6, long j5) {
        boolean z4;
        B6 b62 = b6;
        C1443w2 J02 = F0().J0((String) C0722p.k(b62.f5765a));
        if (J02 != null && N0().p(b62.f5766b, J02.r0())) {
            a().r().b("New GMP App Id passed in. Removing cached database data. appId", C1402q2.x(J02.o0()));
            C1426u F02 = F0();
            String o02 = J02.o0();
            F02.j();
            F02.h();
            C0722p.e(o02);
            try {
                SQLiteDatabase u02 = F02.u0();
                String[] strArr = {o02};
                int delete = u02.delete("events", "app_id=?", strArr) + u02.delete("user_attributes", "app_id=?", strArr) + u02.delete("conditional_properties", "app_id=?", strArr) + u02.delete("apps", "app_id=?", strArr) + u02.delete("raw_events", "app_id=?", strArr) + u02.delete("raw_events_metadata", "app_id=?", strArr) + u02.delete("event_filters", "app_id=?", strArr) + u02.delete("property_filters", "app_id=?", strArr) + u02.delete("audience_filter_values", "app_id=?", strArr) + u02.delete("consent_settings", "app_id=?", strArr) + u02.delete("default_event_params", "app_id=?", strArr) + u02.delete("trigger_uris", "app_id=?", strArr);
                I6.a();
                X2 x22 = F02.f5730a;
                if (x22.w().H((String) null, C1304d2.f6338i1)) {
                    delete += u02.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    x22.a().w().c("Deleted application data. app, records", o02, Integer.valueOf(delete));
                }
            } catch (SQLiteException e5) {
                F02.f5730a.a().o().c("Error deleting application data. appId, error", C1402q2.x(o02), e5);
            }
            J02 = null;
        }
        if (J02 != null) {
            boolean z5 = true;
            if (J02.F0() == -2147483648L || J02.F0() == b62.f5774j) {
                z4 = false;
            } else {
                z4 = true;
            }
            String D02 = J02.D0();
            if (J02.F0() != -2147483648L || D02 == null || D02.equals(b62.f5767c)) {
                z5 = false;
            }
            if (z4 || z5) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", D02);
                G g5 = new G("_au", new E(bundle), "auto", j5);
                if (B0().H((String) null, C1304d2.f6323d1)) {
                    j(g5, b62);
                } else {
                    k(g5, b62);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void o(C1443w2 w2Var, Z2 z22) {
        b().h();
        O0();
        C1211s2 f02 = C1247w2.f0();
        byte[] K4 = w2Var.K();
        if (K4 != null) {
            try {
                f02 = (C1211s2) u6.W(f02, K4);
            } catch (C1170n5 unused) {
                a().r().b("Failed to parse locally stored ad campaign info. appId", C1402q2.x(w2Var.o0()));
            }
        }
        for (O2 o22 : z22.L0()) {
            if (o22.I().equals("_cmp")) {
                String str = (String) u6.v(o22, "gclid", "");
                String str2 = (String) u6.v(o22, "gbraid", "");
                String str3 = (String) u6.v(o22, "gad_source", "");
                String[] split = ((String) C1304d2.f6335h1.b((Object) null)).split(",");
                K0();
                if (!u6.s(o22, split).isEmpty()) {
                    long longValue = ((Long) u6.v(o22, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = o22.K();
                    }
                    if ("referrer API v2".equals(u6.u(o22, "_cis"))) {
                        if (longValue > f02.H()) {
                            if (str.isEmpty()) {
                                f02.C();
                            } else {
                                f02.B(str);
                            }
                            if (str2.isEmpty()) {
                                f02.E();
                            } else {
                                f02.D(str2);
                            }
                            if (str3.isEmpty()) {
                                f02.G();
                            } else {
                                f02.F(str3);
                            }
                            f02.I(longValue);
                            f02.L();
                            f02.M(J(o22));
                        }
                    } else if (longValue > f02.z()) {
                        if (str.isEmpty()) {
                            f02.s();
                        } else {
                            f02.r(str);
                        }
                        if (str2.isEmpty()) {
                            f02.w();
                        } else {
                            f02.t(str2);
                        }
                        if (str3.isEmpty()) {
                            f02.y();
                        } else {
                            f02.x(str3);
                        }
                        f02.A(longValue);
                        f02.J();
                        f02.K(J(o22));
                    }
                }
            }
        }
        if (!((C1247w2) f02.o()).equals(C1247w2.g0())) {
            z22.g0((C1247w2) f02.o());
        }
        w2Var.J(((C1247w2) f02.o()).e());
        if (w2Var.A()) {
            F0().K0(w2Var, false, false);
        }
        if (B0().H((String) null, C1304d2.f6332g1)) {
            F0().z0(w2Var.o0(), "_lgclid");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C1443w2 o0(com.google.android.gms.measurement.internal.B6 r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r12.b()
            r0.h()
            r12.O0()
            N.C0722p.k(r13)
            java.lang.String r2 = r13.f5765a
            N.C0722p.e(r2)
            java.lang.String r0 = r13.f5784t
            boolean r1 = r0.isEmpty()
            r8 = 0
            if (r1 != 0) goto L_0x0025
            java.util.Map r1 = r12.f6650D
            com.google.android.gms.measurement.internal.n6 r3 = new com.google.android.gms.measurement.internal.n6
            r3.<init>(r12, r0, r8)
            r1.put(r2, r3)
        L_0x0025:
            com.google.android.gms.measurement.internal.u r0 = r12.F0()
            com.google.android.gms.measurement.internal.w2 r0 = r0.J0(r2)
            com.google.android.gms.measurement.internal.E3 r1 = r12.g(r2)
            java.lang.String r3 = r13.f5783s
            r4 = 100
            com.google.android.gms.measurement.internal.E3 r3 = com.google.android.gms.measurement.internal.E3.f(r3, r4)
            com.google.android.gms.measurement.internal.E3 r1 = r1.s(r3)
            f0.w r3 = f0.w.AD_STORAGE
            boolean r4 = r1.o(r3)
            if (r4 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.y5 r4 = r12.f6665i
            boolean r5 = r13.f5778n
            java.lang.String r4 = r4.o(r2, r5)
            goto L_0x0050
        L_0x004e:
            java.lang.String r4 = ""
        L_0x0050:
            r9 = 1
            r10 = 0
            if (r0 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.X2 r0 = r12.f6668l
            com.google.android.gms.measurement.internal.w2 r5 = new com.google.android.gms.measurement.internal.w2
            r5.<init>(r0, r2)
            f0.w r0 = f0.w.ANALYTICS_STORAGE
            boolean r0 = r1.o(r0)
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r12.p(r1)
            r5.q0(r0)
        L_0x006a:
            boolean r0 = r1.o(r3)
            if (r0 == 0) goto L_0x0073
            r5.w0(r4)
        L_0x0073:
            r0 = r5
        L_0x0074:
            r11 = r10
            goto L_0x0129
        L_0x0077:
            boolean r3 = r1.o(r3)
            if (r3 == 0) goto L_0x010e
            if (r4 == 0) goto L_0x010e
            java.lang.String r3 = r0.v0()
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x010e
            java.lang.String r3 = r0.v0()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r0.w0(r4)
            boolean r4 = r13.f5778n
            if (r4 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.y5 r4 = r12.f6665i
            android.util.Pair r4 = r4.m(r2, r1)
            java.lang.Object r4 = r4.first
            java.lang.String r5 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00f3
            if (r3 != 0) goto L_0x00f3
            f0.w r3 = f0.w.ANALYTICS_STORAGE
            boolean r3 = r1.o(r3)
            if (r3 == 0) goto L_0x00bb
            java.lang.String r1 = r12.p(r1)
            r0.q0(r1)
            r11 = r10
            goto L_0x00bc
        L_0x00bb:
            r11 = r9
        L_0x00bc:
            com.google.android.gms.measurement.internal.u r1 = r12.F0()
            java.lang.String r3 = "_id"
            com.google.android.gms.measurement.internal.x6 r1 = r1.B0(r2, r3)
            if (r1 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.u r1 = r12.F0()
            java.lang.String r3 = "_lair"
            com.google.android.gms.measurement.internal.x6 r1 = r1.B0(r2, r3)
            if (r1 != 0) goto L_0x0129
            com.google.android.gms.common.util.d r1 = r12.f()
            long r5 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.x6 r1 = new com.google.android.gms.measurement.internal.x6
            r3 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "auto"
            java.lang.String r4 = "_lair"
            r1.<init>(r2, r3, r4, r5, r7)
            com.google.android.gms.measurement.internal.u r2 = r12.F0()
            r2.A0(r1)
            goto L_0x0129
        L_0x00f3:
            java.lang.String r2 = r0.p0()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0074
            f0.w r2 = f0.w.ANALYTICS_STORAGE
            boolean r2 = r1.o(r2)
            if (r2 == 0) goto L_0x0074
            java.lang.String r1 = r12.p(r1)
            r0.q0(r1)
            goto L_0x0074
        L_0x010e:
            java.lang.String r2 = r0.p0()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0074
            f0.w r2 = f0.w.ANALYTICS_STORAGE
            boolean r2 = r1.o(r2)
            if (r2 == 0) goto L_0x0074
            java.lang.String r1 = r12.p(r1)
            r0.q0(r1)
            goto L_0x0074
        L_0x0129:
            java.lang.String r1 = r13.f5766b
            r0.s0(r1)
            java.lang.String r1 = r13.f5775k
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0139
            r0.y0(r1)
        L_0x0139:
            long r1 = r13.f5769e
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0144
            r0.K0(r1)
        L_0x0144:
            java.lang.String r1 = r13.f5767c
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x014f
            r0.E0(r1)
        L_0x014f:
            long r1 = r13.f5774j
            r0.G0(r1)
            java.lang.String r1 = r13.f5768d
            if (r1 == 0) goto L_0x015b
            r0.I0(r1)
        L_0x015b:
            long r1 = r13.f5770f
            r0.a(r1)
            boolean r1 = r13.f5772h
            r0.e(r1)
            java.lang.String r1 = r13.f5771g
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0170
            r0.O(r1)
        L_0x0170:
            boolean r1 = r13.f5778n
            r0.Q(r1)
            java.lang.Boolean r1 = r13.f5780p
            r0.S(r1)
            long r1 = r13.f5781q
            r0.c(r1)
            java.lang.String r1 = r13.f5785u
            r0.u0(r1)
            com.google.android.gms.internal.measurement.L6.a()
            com.google.android.gms.measurement.internal.m r1 = r12.B0()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6285M0
            boolean r1 = r1.H(r8, r2)
            if (r1 == 0) goto L_0x0199
            java.util.List r1 = r13.f5782r
            r0.U(r1)
            goto L_0x01ab
        L_0x0199:
            com.google.android.gms.internal.measurement.L6.a()
            com.google.android.gms.measurement.internal.m r1 = r12.B0()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6283L0
            boolean r1 = r1.H(r8, r2)
            if (r1 == 0) goto L_0x01ab
            r0.U(r8)
        L_0x01ab:
            boolean r1 = r13.f5786v
            r0.W(r1)
            java.lang.String r1 = r13.f5761B
            r0.m0(r1)
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.m r1 = r12.B0()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6293Q0
            boolean r1 = r1.H(r8, r2)
            if (r1 == 0) goto L_0x01c9
            int r1 = r13.f5790z
            r0.c0(r1)
        L_0x01c9:
            long r1 = r13.f5787w
            r0.Y(r1)
            java.lang.String r1 = r13.f5762C
            r0.H(r1)
            int r13 = r13.f5764E
            r0.L(r13)
            boolean r13 = r0.A()
            if (r13 != 0) goto L_0x01e2
            if (r11 == 0) goto L_0x01e1
            goto L_0x01e3
        L_0x01e1:
            return r0
        L_0x01e2:
            r9 = r11
        L_0x01e3:
            com.google.android.gms.measurement.internal.u r13 = r12.F0()
            r13.K0(r0, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.o0(com.google.android.gms.measurement.internal.B6):com.google.android.gms.measurement.internal.w2");
    }

    /* access modifiers changed from: package-private */
    public final String p(E3 e32) {
        if (!e32.o(w.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        N0().q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String p0(B6 b6) {
        try {
            return (String) b().r(new C1348i6(this, b6)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            a().o().c("Failed to get app instance id. appId", C1402q2.x(b6.f5765a), e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(List list) {
        C0722p.a(!list.isEmpty());
        if (this.f6681y != null) {
            a().o().a("Set uploading progress before finishing the previous upload");
        } else {
            this.f6681y = new ArrayList(list);
        }
    }

    /* access modifiers changed from: package-private */
    public final List q0(B6 b6, Bundle bundle) {
        B6 b62 = b6;
        Bundle bundle2 = bundle;
        b().h();
        C1145k7.a();
        C1371m B02 = B0();
        String str = b62.f5765a;
        if (!B02.H(str, C1304d2.f6293Q0) || str == null) {
            return new ArrayList();
        }
        if (bundle2 != null) {
            int[] intArray = bundle2.getIntArray("uriSources");
            long[] longArray = bundle2.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    a().o().a("Uri sources and timestamps do not match");
                } else {
                    for (int i5 = 0; i5 < intArray.length; i5++) {
                        C1426u F02 = F0();
                        int i6 = intArray[i5];
                        long j5 = longArray[i5];
                        C0722p.e(str);
                        F02.h();
                        F02.j();
                        try {
                            int delete = F02.u0().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i6), String.valueOf(j5)});
                            C1388o2 w4 = F02.f5730a.a().w();
                            StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(delete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            w4.d(sb.toString(), str, Integer.valueOf(i6), Long.valueOf(j5));
                        } catch (SQLiteException e5) {
                            F02.f5730a.a().o().c("Error pruning trigger URIs. appId", C1402q2.x(str), e5);
                        }
                    }
                }
            }
        }
        C1426u F03 = F0();
        String str2 = b62.f5765a;
        C0722p.e(str2);
        F03.h();
        F03.j();
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = F03.u0().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, (String) null, (String) null, "rowid", (String) null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new S5(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e6) {
            F03.f5730a.a().o().c("Error querying trigger uris. appId", C1402q2.x(str2), e6);
            arrayList = Collections.EMPTY_LIST;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0124, code lost:
        if (r7 == 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0194, code lost:
        if (r1 != null) goto L_0x0170;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b2 A[SYNTHETIC, Splitter:B:80:0x01b2] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0170=Splitter:B:57:0x0170, B:44:0x0127=Splitter:B:44:0x0127, B:71:0x0197=Splitter:B:71:0x0197, B:35:0x0109=Splitter:B:35:0x0109} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r11.b()
            r0.h()
            r11.O0()
            r0 = 1
            r11.f6678v = r0
            r0 = 0
            com.google.android.gms.measurement.internal.X2 r1 = r11.f6668l     // Catch:{ all -> 0x002c }
            r1.c()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.w5 r1 = r1.J()     // Catch:{ all -> 0x002c }
            java.lang.Boolean r1 = r1.x()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.q2 r1 = r11.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r1.a(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x002c:
            r1 = move-exception
            goto L_0x01b6
        L_0x002f:
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0044
            com.google.android.gms.measurement.internal.q2 r1 = r11.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.o2 r1 = r1.o()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r1.a(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0044:
            long r1 = r11.f6671o     // Catch:{ all -> 0x002c }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0051
            r11.R()     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0051:
            com.google.android.gms.measurement.internal.T2 r1 = r11.b()     // Catch:{ all -> 0x002c }
            r1.h()     // Catch:{ all -> 0x002c }
            java.util.List r1 = r11.f6681y     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x006b
            com.google.android.gms.measurement.internal.q2 r1 = r11.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Uploading requested multiple times"
            r1.a(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x006b:
            com.google.android.gms.measurement.internal.v2 r1 = r11.E0()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.m()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0087
            com.google.android.gms.measurement.internal.q2 r1 = r11.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r1.a(r2)     // Catch:{ all -> 0x002c }
            r11.R()     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0087:
            com.google.android.gms.common.util.d r1 = r11.f()     // Catch:{ all -> 0x002c }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.m r5 = r11.B0()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.c2 r6 = com.google.android.gms.measurement.internal.C1304d2.f6340j0     // Catch:{ all -> 0x002c }
            r7 = 0
            int r5 = r5.E(r7, r6)     // Catch:{ all -> 0x002c }
            r11.B0()     // Catch:{ all -> 0x002c }
            long r8 = com.google.android.gms.measurement.internal.C1371m.n()     // Catch:{ all -> 0x002c }
            long r8 = r1 - r8
            r6 = r0
        L_0x00a4:
            if (r6 >= r5) goto L_0x00af
            boolean r10 = r11.M(r7, r8)     // Catch:{ all -> 0x002c }
            if (r10 == 0) goto L_0x00af
            int r6 = r6 + 1
            goto L_0x00a4
        L_0x00af:
            com.google.android.gms.internal.measurement.C1145k7.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.T2 r5 = r11.b()     // Catch:{ all -> 0x002c }
            r5.h()     // Catch:{ all -> 0x002c }
            r11.v0()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.y5 r5 = r11.f6665i     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.B2 r5 = r5.f6914h     // Catch:{ all -> 0x002c }
            long r5 = r5.a()     // Catch:{ all -> 0x002c }
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.q2 r3 = r11.a()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.o2 r3 = r3.v()     // Catch:{ all -> 0x002c }
            java.lang.String r4 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r5 = r1 - r5
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x002c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x002c }
            r3.b(r4, r5)     // Catch:{ all -> 0x002c }
        L_0x00df:
            com.google.android.gms.measurement.internal.u r3 = r11.F0()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = r3.r()     // Catch:{ all -> 0x002c }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002c }
            r5 = -1
            if (r4 != 0) goto L_0x0135
            long r8 = r11.f6647A     // Catch:{ all -> 0x002c }
            int r4 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.u r4 = r11.F0()     // Catch:{ all -> 0x002c }
            android.database.sqlite.SQLiteDatabase r8 = r4.u0()     // Catch:{ SQLiteException -> 0x0114 }
            java.lang.String r9 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r7 = r8.rawQuery(r9, r7)     // Catch:{ SQLiteException -> 0x0114 }
            boolean r8 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0114 }
            if (r8 != 0) goto L_0x010d
        L_0x0109:
            r7.close()     // Catch:{ all -> 0x002c }
            goto L_0x0127
        L_0x010d:
            long r5 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0114 }
            goto L_0x0109
        L_0x0112:
            r1 = move-exception
            goto L_0x012a
        L_0x0114:
            r8 = move-exception
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x0112 }
            java.lang.String r9 = "Error querying raw events"
            r4.b(r9, r8)     // Catch:{ all -> 0x0112 }
            if (r7 == 0) goto L_0x0127
            goto L_0x0109
        L_0x0127:
            r11.f6647A = r5     // Catch:{ all -> 0x002c }
            goto L_0x0130
        L_0x012a:
            if (r7 == 0) goto L_0x012f
            r7.close()     // Catch:{ all -> 0x002c }
        L_0x012f:
            throw r1     // Catch:{ all -> 0x002c }
        L_0x0130:
            r11.s(r3, r1)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0135:
            r11.f6647A = r5     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.u r3 = r11.F0()     // Catch:{ all -> 0x002c }
            r11.B0()     // Catch:{ all -> 0x002c }
            long r4 = com.google.android.gms.measurement.internal.C1371m.n()     // Catch:{ all -> 0x002c }
            long r1 = r1 - r4
            r3.h()     // Catch:{ all -> 0x002c }
            r3.j()     // Catch:{ all -> 0x002c }
            android.database.sqlite.SQLiteDatabase r4 = r3.u0()     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            java.lang.String r5 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            android.database.Cursor r1 = r4.rawQuery(r5, r1)     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0176 }
            if (r2 != 0) goto L_0x0178
            com.google.android.gms.measurement.internal.X2 r2 = r3.f5730a     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r2.a(r4)     // Catch:{ SQLiteException -> 0x0176 }
        L_0x0170:
            r1.close()     // Catch:{ all -> 0x002c }
            goto L_0x0197
        L_0x0174:
            r2 = move-exception
            goto L_0x017d
        L_0x0176:
            r2 = move-exception
            goto L_0x0185
        L_0x0178:
            java.lang.String r7 = r1.getString(r0)     // Catch:{ SQLiteException -> 0x0176 }
            goto L_0x0170
        L_0x017d:
            r7 = r1
            goto L_0x01b0
        L_0x017f:
            r1 = move-exception
            r2 = r1
            goto L_0x01b0
        L_0x0182:
            r1 = move-exception
            r2 = r1
            r1 = r7
        L_0x0185:
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.q2 r3 = r3.a()     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.o2 r3 = r3.o()     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = "Error selecting expired configs"
            r3.b(r4, r2)     // Catch:{ all -> 0x0174 }
            if (r1 == 0) goto L_0x0197
            goto L_0x0170
        L_0x0197:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.u r1 = r11.F0()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.w2 r1 = r1.J0(r7)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x01aa
            r11.B(r1)     // Catch:{ all -> 0x002c }
        L_0x01aa:
            r11.f6678v = r0
            r11.S()
            return
        L_0x01b0:
            if (r7 == 0) goto L_0x01b5
            r7.close()     // Catch:{ all -> 0x002c }
        L_0x01b5:
            throw r2     // Catch:{ all -> 0x002c }
        L_0x01b6:
            r11.f6678v = r0
            r11.S()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.r():void");
    }

    /* access modifiers changed from: package-private */
    public final void r0(String str, C1325g gVar) {
        b().h();
        O0();
        C1426u F02 = F0();
        long j5 = gVar.f6420a;
        t6 n5 = F02.n(j5);
        if (n5 == null) {
            a().r().c("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j5));
            return;
        }
        String e5 = n5.e();
        if (gVar.f6421b == C1642J.SUCCESS.A()) {
            Map map = this.f6651E;
            if (map.containsKey(e5)) {
                map.remove(e5);
            }
            C1426u F03 = F0();
            Long valueOf = Long.valueOf(j5);
            F03.q(valueOf);
            a().w().c("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j6 = gVar.f6422c;
            if (j6 > 0) {
                C1426u F04 = F0();
                F04.h();
                F04.j();
                Long valueOf2 = Long.valueOf(j6);
                C0722p.k(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(C1643K.GOOGLE_SIGNAL.A()));
                X2 x22 = F04.f5730a;
                contentValues.put("creation_timestamp", Long.valueOf(x22.f().currentTimeMillis()));
                try {
                    if (((long) F04.u0().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j6), str, String.valueOf(C1643K.GOOGLE_SIGNAL_PENDING.A())})) != 1) {
                        x22.a().r().c("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    a().w().c("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(gVar.f6422c));
                    u(str);
                } catch (SQLiteException e6) {
                    F04.f5730a.a().o().d("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j6), e6);
                    throw e6;
                }
            }
        } else {
            if (gVar.f6421b == C1642J.BACKOFF.A()) {
                Map map2 = this.f6651E;
                o6 o6Var = (o6) map2.get(e5);
                if (o6Var == null) {
                    o6Var = new o6(this);
                    map2.put(e5, o6Var);
                } else {
                    o6Var.a();
                }
                a().w().d("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, e5, Long.valueOf((o6Var.c() - f().currentTimeMillis()) / 1000));
            }
            C1426u F05 = F0();
            Long valueOf3 = Long.valueOf(gVar.f6420a);
            F05.w(valueOf3);
            a().w().c("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0209, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0211, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022a, code lost:
        if (r10 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0450, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0452, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x046a, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0484, code lost:
        if (r23 == null) goto L_0x0487;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x055c, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0a05, code lost:
        r13.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0209 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0450 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:151:0x039e] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0492  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x07c7  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x07f7  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0808  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x081e A[LOOP:14: B:340:0x0818->B:342:0x081e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0849  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x084c  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x0861  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x093d  */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0940  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x09aa  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0a05  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x07dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:438:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(java.lang.String r33, long r34) {
        /*
            r32 = this;
            r1 = r32
            r6 = r33
            r2 = r34
            java.lang.String r4 = "data"
            com.google.android.gms.measurement.internal.m r0 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r5 = com.google.android.gms.measurement.internal.C1304d2.f6333h
            int r0 = r0.E(r6, r5)
            com.google.android.gms.measurement.internal.m r5 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r7 = com.google.android.gms.measurement.internal.C1304d2.f6336i
            int r5 = r5.E(r6, r7)
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            com.google.android.gms.measurement.internal.u r8 = r1.F0()
            r8.h()
            r8.j()
            r9 = 1
            if (r0 <= 0) goto L_0x0030
            r10 = r9
            goto L_0x0031
        L_0x0030:
            r10 = r7
        L_0x0031:
            N.C0722p.a(r10)
            if (r5 <= 0) goto L_0x0038
            r10 = r9
            goto L_0x0039
        L_0x0038:
            r10 = r7
        L_0x0039:
            N.C0722p.a(r10)
            N.C0722p.e(r6)
            android.database.sqlite.SQLiteDatabase r14 = r8.u0()     // Catch:{ SQLiteException -> 0x020d, all -> 0x0209 }
            java.lang.String r15 = "queue"
            r23 = -1
            java.lang.String r10 = "rowid"
            java.lang.String r11 = "retry_count"
            java.lang.String[] r16 = new java.lang.String[]{r10, r4, r11}     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r17 = "app_id=?"
            java.lang.String[] r18 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            java.lang.String r21 = "rowid"
            java.lang.String r22 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            r19 = 0
            r20 = 0
            android.database.Cursor r10 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x020b, all -> 0x0209 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r0 != 0) goto L_0x007b
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
        L_0x006b:
            r10.close()
        L_0x006e:
            r11 = r0
            goto L_0x022e
        L_0x0071:
            r0 = move-exception
            r22 = r10
            goto L_0x0202
        L_0x0076:
            r0 = move-exception
            r22 = r10
            goto L_0x0206
        L_0x007b:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r14 = r7
        L_0x0081:
            long r15 = r10.getLong(r7)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            byte[] r0 = r10.getBlob(r9)     // Catch:{ IOException -> 0x01d9 }
            com.google.android.gms.measurement.internal.q6 r9 = r8.f6129b     // Catch:{ IOException -> 0x01d9 }
            com.google.android.gms.measurement.internal.u6 r9 = r9.K0()     // Catch:{ IOException -> 0x01d9 }
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x01b4 }
            r13.<init>(r0)     // Catch:{ IOException -> 0x01b4 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x01b4 }
            r0.<init>(r13)     // Catch:{ IOException -> 0x01b4 }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01b4 }
            r12.<init>()     // Catch:{ IOException -> 0x01b4 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x01b4 }
            r21 = r13
        L_0x00a4:
            int r13 = r0.read(r7)     // Catch:{ IOException -> 0x01b4 }
            if (r13 > 0) goto L_0x01b8
            r0.close()     // Catch:{ IOException -> 0x01b4 }
            r21.close()     // Catch:{ IOException -> 0x01b4 }
            byte[] r0 = r12.toByteArray()     // Catch:{ IOException -> 0x01b4 }
            boolean r7 = r11.isEmpty()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r7 != 0) goto L_0x00c2
            int r7 = r0.length     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            int r7 = r7 + r14
            if (r7 <= r5) goto L_0x00c2
        L_0x00be:
            r22 = r10
            goto L_0x01fe
        L_0x00c2:
            com.google.android.gms.internal.measurement.Z2 r7 = com.google.android.gms.internal.measurement.C1051a3.k0()     // Catch:{ IOException -> 0x019f }
            com.google.android.gms.internal.measurement.E5 r7 = com.google.android.gms.measurement.internal.u6.W(r7, r0)     // Catch:{ IOException -> 0x019f }
            com.google.android.gms.internal.measurement.Z2 r7 = (com.google.android.gms.internal.measurement.Z2) r7     // Catch:{ IOException -> 0x019f }
            boolean r9 = r11.isEmpty()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r9 != 0) goto L_0x017b
            r9 = 0
            java.lang.Object r12 = r11.get(r9)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.Object r9 = r12.first     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.a3 r9 = (com.google.android.gms.internal.measurement.C1051a3) r9     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.e5 r12 = r7.o()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.a3 r12 = (com.google.android.gms.internal.measurement.C1051a3) r12     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.String r13 = r9.L0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r21 = r9
            java.lang.String r9 = r12.L0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r9 = r13.equals(r9)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r9 == 0) goto L_0x00be
            java.lang.String r9 = r21.S0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.String r13 = r12.S0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r9 = r9.equals(r13)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r9 == 0) goto L_0x00be
            boolean r9 = r21.U0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r13 = r12.U0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r9 != r13) goto L_0x00be
            java.lang.String r9 = r21.W0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.String r13 = r12.W0()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r9 = r9.equals(r13)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r9 == 0) goto L_0x00be
            java.util.List r9 = r21.n2()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
        L_0x0121:
            boolean r13 = r9.hasNext()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r21 = r9
            java.lang.String r9 = "_npa"
            if (r13 == 0) goto L_0x0147
            java.lang.Object r13 = r21.next()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.r3 r13 = (com.google.android.gms.internal.measurement.C1203r3) r13     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r22 = r12
            java.lang.String r12 = r13.H()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r12 = r9.equals(r12)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r12 == 0) goto L_0x0142
            long r12 = r13.L()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            goto L_0x014b
        L_0x0142:
            r9 = r21
            r12 = r22
            goto L_0x0121
        L_0x0147:
            r22 = r12
            r12 = r23
        L_0x014b:
            java.util.List r21 = r22.n2()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.util.Iterator r21 = r21.iterator()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
        L_0x0153:
            boolean r22 = r21.hasNext()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r22 == 0) goto L_0x0173
            java.lang.Object r22 = r21.next()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.r3 r22 = (com.google.android.gms.internal.measurement.C1203r3) r22     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r25 = r12
            java.lang.String r12 = r22.H()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            boolean r12 = r9.equals(r12)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r12 == 0) goto L_0x0170
            long r12 = r22.L()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            goto L_0x0177
        L_0x0170:
            r12 = r25
            goto L_0x0153
        L_0x0173:
            r25 = r12
            r12 = r23
        L_0x0177:
            int r9 = (r25 > r12 ? 1 : (r25 == r12 ? 0 : -1))
            if (r9 != 0) goto L_0x00be
        L_0x017b:
            r9 = 2
            boolean r12 = r10.isNull(r9)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            if (r12 != 0) goto L_0x0189
            int r12 = r10.getInt(r9)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r7.z0(r12)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
        L_0x0189:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            int r14 = r14 + r0
            com.google.android.gms.internal.measurement.e5 r0 = r7.o()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.measurement.a3 r0 = (com.google.android.gms.internal.measurement.C1051a3) r0     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.Long r7 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            android.util.Pair r0 = android.util.Pair.create(r0, r7)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r11.add(r0)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
        L_0x019c:
            r22 = r10
            goto L_0x01ef
        L_0x019f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r7 = r8.f5730a     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            java.lang.String r9 = "Failed to merge queued bundle. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            r7.c(r9, r12, r0)     // Catch:{ SQLiteException -> 0x0076, all -> 0x0071 }
            goto L_0x019c
        L_0x01b4:
            r0 = move-exception
            r22 = r10
            goto L_0x01c7
        L_0x01b8:
            r22 = r10
            r10 = 0
            r12.write(r7, r10, r13)     // Catch:{ IOException -> 0x01c6 }
            r10 = r22
            goto L_0x00a4
        L_0x01c2:
            r0 = move-exception
            goto L_0x0202
        L_0x01c4:
            r0 = move-exception
            goto L_0x0206
        L_0x01c6:
            r0 = move-exception
        L_0x01c7:
            com.google.android.gms.measurement.internal.X2 r7 = r9.f5730a     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()     // Catch:{ IOException -> 0x01d7 }
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()     // Catch:{ IOException -> 0x01d7 }
            java.lang.String r9 = "Failed to ungzip content"
            r7.b(r9, r0)     // Catch:{ IOException -> 0x01d7 }
            throw r0     // Catch:{ IOException -> 0x01d7 }
        L_0x01d7:
            r0 = move-exception
            goto L_0x01dc
        L_0x01d9:
            r0 = move-exception
            r22 = r10
        L_0x01dc:
            com.google.android.gms.measurement.internal.X2 r7 = r8.f5730a     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
            com.google.android.gms.measurement.internal.q2 r7 = r7.a()     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
            com.google.android.gms.measurement.internal.o2 r7 = r7.o()     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
            java.lang.String r9 = "Failed to unzip queued bundle. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
            r7.c(r9, r10, r0)     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
        L_0x01ef:
            boolean r0 = r22.moveToNext()     // Catch:{ SQLiteException -> 0x01c4, all -> 0x01c2 }
            if (r0 == 0) goto L_0x01fe
            if (r14 <= r5) goto L_0x01f8
            goto L_0x01fe
        L_0x01f8:
            r10 = r22
            r7 = 0
            r9 = 1
            goto L_0x0081
        L_0x01fe:
            r22.close()
            goto L_0x022e
        L_0x0202:
            r13 = r22
            goto L_0x0a03
        L_0x0206:
            r10 = r22
            goto L_0x0215
        L_0x0209:
            r0 = move-exception
            goto L_0x0211
        L_0x020b:
            r0 = move-exception
            goto L_0x0214
        L_0x020d:
            r0 = move-exception
            r23 = -1
            goto L_0x0214
        L_0x0211:
            r13 = 0
            goto L_0x0a03
        L_0x0214:
            r10 = 0
        L_0x0215:
            com.google.android.gms.measurement.internal.X2 r5 = r8.f5730a     // Catch:{ all -> 0x0a01 }
            com.google.android.gms.measurement.internal.q2 r5 = r5.a()     // Catch:{ all -> 0x0a01 }
            com.google.android.gms.measurement.internal.o2 r5 = r5.o()     // Catch:{ all -> 0x0a01 }
            java.lang.String r7 = "Error querying bundles. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ all -> 0x0a01 }
            r5.c(r7, r8, r0)     // Catch:{ all -> 0x0a01 }
            java.util.List r0 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x0a01 }
            if (r10 == 0) goto L_0x006e
            goto L_0x006b
        L_0x022e:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0236
            goto L_0x0a00
        L_0x0236:
            com.google.android.gms.internal.measurement.I6.a()
            com.google.android.gms.measurement.internal.m r0 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r5 = com.google.android.gms.measurement.internal.C1304d2.f6338i1
            r7 = 0
            boolean r0 = r0.H(r7, r5)
            java.lang.String r8 = "_f"
            if (r0 == 0) goto L_0x0569
            com.google.android.gms.internal.measurement.I6.a()
            com.google.android.gms.measurement.internal.m r0 = r1.B0()
            boolean r0 = r0.H(r7, r5)
            if (r0 == 0) goto L_0x0560
            com.google.android.gms.measurement.internal.E3 r0 = r32.g(r33)
            f0.w r5 = f0.w.ANALYTICS_STORAGE
            boolean r0 = r0.o(r5)
            java.lang.String r5 = "no_data_mode_events"
            if (r0 != 0) goto L_0x037f
            com.google.android.gms.measurement.internal.P2 r0 = r1.D0()
            boolean r0 = r0.n(r6)
            if (r0 == 0) goto L_0x037f
            com.google.android.gms.measurement.internal.c2 r0 = com.google.android.gms.measurement.internal.C1304d2.f6341j1
            java.lang.Object r0 = r0.b(r7)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r7 = ","
            java.lang.String[] r0 = r0.split(r7)
            java.util.List r7 = java.util.Arrays.asList(r0)
            java.util.Iterator r9 = r11.iterator()
        L_0x0283:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x037b
            java.lang.Object r0 = r9.next()
            android.util.Pair r0 = (android.util.Pair) r0
            com.google.android.gms.measurement.internal.u r10 = r1.F0()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.Object r11 = r0.second     // Catch:{ SQLiteException -> 0x036c }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ SQLiteException -> 0x036c }
            long r11 = r11.longValue()     // Catch:{ SQLiteException -> 0x036c }
            r10.t(r11)     // Catch:{ SQLiteException -> 0x036c }
            java.lang.Object r0 = r0.first     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.internal.measurement.a3 r0 = (com.google.android.gms.internal.measurement.C1051a3) r0     // Catch:{ SQLiteException -> 0x036c }
            java.util.List r0 = r0.h2()     // Catch:{ SQLiteException -> 0x036c }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ SQLiteException -> 0x036c }
        L_0x02aa:
            boolean r0 = r10.hasNext()     // Catch:{ SQLiteException -> 0x036c }
            if (r0 == 0) goto L_0x0283
            java.lang.Object r0 = r10.next()     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r11 = r0.I()     // Catch:{ SQLiteException -> 0x036c }
            boolean r11 = r7.contains(r11)     // Catch:{ SQLiteException -> 0x036c }
            if (r11 == 0) goto L_0x02aa
            java.lang.String r11 = r0.I()     // Catch:{ SQLiteException -> 0x036c }
            boolean r11 = r11.equals(r8)     // Catch:{ SQLiteException -> 0x036c }
            if (r11 != 0) goto L_0x02d6
            java.lang.String r11 = r0.I()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r12 = "_v"
            boolean r11 = r11.equals(r12)     // Catch:{ SQLiteException -> 0x036c }
            if (r11 == 0) goto L_0x02f0
        L_0x02d6:
            com.google.android.gms.internal.measurement.c5 r0 = r0.q()     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.internal.measurement.N2 r0 = (com.google.android.gms.internal.measurement.N2) r0     // Catch:{ SQLiteException -> 0x036c }
            r1.K0()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r11 = "_dac"
            r12 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.u6.o(r0, r11, r12)     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ SQLiteException -> 0x036c }
        L_0x02f0:
            com.google.android.gms.measurement.internal.u r11 = r1.F0()     // Catch:{ SQLiteException -> 0x036c }
            r11.h()     // Catch:{ SQLiteException -> 0x036c }
            r11.j()     // Catch:{ SQLiteException -> 0x036c }
            N.C0722p.k(r0)     // Catch:{ SQLiteException -> 0x036c }
            N.C0722p.e(r6)     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.X2 r12 = r11.f5730a     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.q2 r13 = r12.a()     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.o2 r13 = r13.w()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r14 = "Caching events in NO_DATA mode"
            r13.b(r14, r0)     // Catch:{ SQLiteException -> 0x036c }
            android.content.ContentValues r13 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x036c }
            r13.<init>()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r14 = "app_id"
            r13.put(r14, r6)     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r14 = "name"
            java.lang.String r15 = r0.I()     // Catch:{ SQLiteException -> 0x036c }
            r13.put(r14, r15)     // Catch:{ SQLiteException -> 0x036c }
            byte[] r14 = r0.e()     // Catch:{ SQLiteException -> 0x036c }
            r13.put(r4, r14)     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r14 = "timestamp_millis"
            long r15 = r0.K()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.Long r0 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x036c }
            r13.put(r14, r0)     // Catch:{ SQLiteException -> 0x036c }
            android.database.sqlite.SQLiteDatabase r0 = r11.u0()     // Catch:{ SQLiteException -> 0x0356 }
            r14 = 0
            long r15 = r0.insert(r5, r14, r13)     // Catch:{ SQLiteException -> 0x0356 }
            int r0 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r0 != 0) goto L_0x02aa
            com.google.android.gms.measurement.internal.q2 r0 = r12.a()     // Catch:{ SQLiteException -> 0x0356 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()     // Catch:{ SQLiteException -> 0x0356 }
            java.lang.String r12 = "Failed to insert NO_DATA mode event (got -1). appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x0356 }
            r0.b(r12, r13)     // Catch:{ SQLiteException -> 0x0356 }
            goto L_0x02aa
        L_0x0356:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r11 = r11.f5730a     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.q2 r11 = r11.a()     // Catch:{ SQLiteException -> 0x036c }
            com.google.android.gms.measurement.internal.o2 r11 = r11.o()     // Catch:{ SQLiteException -> 0x036c }
            java.lang.String r12 = "Error storing NO_DATA mode event. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x036c }
            r11.c(r12, r13, r0)     // Catch:{ SQLiteException -> 0x036c }
            goto L_0x02aa
        L_0x036c:
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.t()
            java.lang.String r10 = "Failed handling NO_DATA mode bundles. appId"
            r0.b(r10, r6)
            goto L_0x0283
        L_0x037b:
            java.util.List r11 = java.util.Collections.EMPTY_LIST
            goto L_0x0562
        L_0x037f:
            java.util.ArrayList r7 = new java.util.ArrayList
            int r0 = r11.size()
            r7.<init>(r0)
            com.google.android.gms.measurement.internal.u r9 = r1.F0()
            N.C0722p.e(r6)
            r9.h()
            r9.j()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r12 = " NO_DATA mode events. appId"
            java.lang.String r13 = "Pruned "
            android.database.sqlite.SQLiteDatabase r21 = r9.u0()     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            com.google.android.gms.measurement.internal.X2 r0 = r9.f5730a     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            com.google.android.gms.common.util.d r0 = r0.f()     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            long r14 = r0.currentTimeMillis()     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            java.lang.String r22 = "no_data_mode_events"
            java.lang.String[] r23 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            java.lang.String r24 = "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)"
            java.lang.String r0 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            java.lang.String[] r25 = new java.lang.String[]{r6, r0}     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            java.lang.String r28 = "rowid"
            r29 = 0
            r26 = 0
            r27 = 0
            android.database.Cursor r4 = r21.query(r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ SQLiteException -> 0x0466, all -> 0x0450 }
            r16 = r11
            r11 = r21
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x03f4, all -> 0x03ef }
            if (r0 == 0) goto L_0x045c
            r21 = r14
        L_0x03d4:
            r14 = 0
            byte[] r0 = r4.getBlob(r14)     // Catch:{ n5 -> 0x03f9 }
            com.google.android.gms.internal.measurement.N2 r14 = com.google.android.gms.internal.measurement.O2.P()     // Catch:{ n5 -> 0x03f9 }
            com.google.android.gms.internal.measurement.E5 r0 = com.google.android.gms.measurement.internal.u6.W(r14, r0)     // Catch:{ n5 -> 0x03f9 }
            com.google.android.gms.internal.measurement.N2 r0 = (com.google.android.gms.internal.measurement.N2) r0     // Catch:{ n5 -> 0x03f9 }
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()     // Catch:{ n5 -> 0x03f9 }
            com.google.android.gms.internal.measurement.O2 r0 = (com.google.android.gms.internal.measurement.O2) r0     // Catch:{ n5 -> 0x03f9 }
            r10.add(r0)     // Catch:{ n5 -> 0x03f9 }
            r23 = r4
            goto L_0x040f
        L_0x03ef:
            r0 = move-exception
            r23 = r4
            goto L_0x0462
        L_0x03f4:
            r0 = move-exception
            r23 = r4
            goto L_0x046f
        L_0x03f9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r14 = r9.f5730a     // Catch:{ SQLiteException -> 0x03f4, all -> 0x03ef }
            com.google.android.gms.measurement.internal.q2 r14 = r14.a()     // Catch:{ SQLiteException -> 0x03f4, all -> 0x03ef }
            com.google.android.gms.measurement.internal.o2 r14 = r14.t()     // Catch:{ SQLiteException -> 0x03f4, all -> 0x03ef }
            java.lang.String r15 = "Failed to parse stored NO_DATA mode event, appId"
            r23 = r4
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ SQLiteException -> 0x0456 }
            r14.c(r15, r4, r0)     // Catch:{ SQLiteException -> 0x0456 }
        L_0x040f:
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0456 }
            if (r0 != 0) goto L_0x0458
            r23.close()     // Catch:{ SQLiteException -> 0x0456 }
            java.lang.String r0 = "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)"
            java.lang.String r4 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            java.lang.String[] r4 = new java.lang.String[]{r6, r4}     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            int r0 = r11.delete(r5, r0, r4)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            com.google.android.gms.measurement.internal.X2 r4 = r9.f5730a     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.w()     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            int r5 = r5.length()     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            int r5 = r5 + 34
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            r11.<init>(r5)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            r11.append(r13)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            r11.append(r0)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            r11.append(r12)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            java.lang.String r0 = r11.toString()     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            r4.b(r0, r6)     // Catch:{ SQLiteException -> 0x0452, all -> 0x0450 }
            goto L_0x0487
        L_0x0450:
            r0 = move-exception
            goto L_0x046a
        L_0x0452:
            r0 = move-exception
            goto L_0x046d
        L_0x0454:
            r0 = move-exception
            goto L_0x0462
        L_0x0456:
            r0 = move-exception
            goto L_0x046f
        L_0x0458:
            r4 = r23
            goto L_0x03d4
        L_0x045c:
            r23 = r4
        L_0x045e:
            r23.close()
            goto L_0x0487
        L_0x0462:
            r13 = r23
            goto L_0x055a
        L_0x0466:
            r0 = move-exception
            r16 = r11
            goto L_0x046d
        L_0x046a:
            r13 = 0
            goto L_0x055a
        L_0x046d:
            r23 = 0
        L_0x046f:
            com.google.android.gms.measurement.internal.X2 r4 = r9.f5730a     // Catch:{ all -> 0x0454 }
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()     // Catch:{ all -> 0x0454 }
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()     // Catch:{ all -> 0x0454 }
            java.lang.String r5 = "Error flushing NO_DATA mode events. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r6)     // Catch:{ all -> 0x0454 }
            r4.c(r5, r9, r0)     // Catch:{ all -> 0x0454 }
            java.util.List r10 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x0454 }
            if (r23 == 0) goto L_0x0487
            goto L_0x045e
        L_0x0487:
            java.util.Iterator r0 = r16.iterator()
            r4 = 1
        L_0x048c:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0558
            java.lang.Object r5 = r0.next()
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r9 = r5.first
            com.google.android.gms.internal.measurement.a3 r9 = (com.google.android.gms.internal.measurement.C1051a3) r9
            com.google.android.gms.internal.measurement.c5 r9 = r9.q()
            com.google.android.gms.internal.measurement.Z2 r9 = (com.google.android.gms.internal.measurement.Z2) r9
            if (r4 == 0) goto L_0x04b8
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x04b8
            java.util.List r4 = r9.L0()
            r9.S0()
            r9.R0(r10)
            r9.R0(r4)
            r4 = 0
        L_0x04b8:
            com.google.android.gms.internal.measurement.D2 r11 = com.google.android.gms.internal.measurement.K2.G()
            com.google.android.gms.measurement.internal.P2 r12 = r1.D0()
            com.google.android.gms.internal.measurement.a2 r12 = r12.R(r6)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            if (r12 != 0) goto L_0x04d3
        L_0x04cb:
            r21 = r0
            r16 = r4
            r23 = r10
            goto L_0x0539
        L_0x04d3:
            java.util.List r12 = r12.F()
            java.util.Iterator r12 = r12.iterator()
        L_0x04db:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x04cb
            java.lang.Object r14 = r12.next()
            com.google.android.gms.internal.measurement.O1 r14 = (com.google.android.gms.internal.measurement.O1) r14
            com.google.android.gms.internal.measurement.G2 r15 = com.google.android.gms.internal.measurement.H2.F()
            int r16 = r14.G()
            f0.v r21 = f0.v.UNINITIALIZED
            r21 = r0
            int r0 = r16 + -1
            r16 = r4
            r4 = 1
            if (r0 == r4) goto L_0x0510
            r4 = 2
            if (r0 == r4) goto L_0x050b
            r4 = 4
            r23 = r10
            r10 = 3
            if (r0 == r10) goto L_0x0509
            if (r0 == r4) goto L_0x0507
            r0 = 1
            goto L_0x0514
        L_0x0507:
            r0 = 5
            goto L_0x0514
        L_0x0509:
            r0 = r4
            goto L_0x0514
        L_0x050b:
            r23 = r10
            r10 = 3
            r0 = r10
            goto L_0x0514
        L_0x0510:
            r23 = r10
            r10 = 3
            r0 = 2
        L_0x0514:
            r15.r(r0)
            int r0 = r14.I()
            int r0 = r0 + -1
            r4 = 1
            if (r0 == r4) goto L_0x0525
            r4 = 2
            if (r0 == r4) goto L_0x0526
            r10 = 1
            goto L_0x0526
        L_0x0525:
            r10 = 2
        L_0x0526:
            r15.s(r10)
            com.google.android.gms.internal.measurement.e5 r0 = r15.o()
            com.google.android.gms.internal.measurement.H2 r0 = (com.google.android.gms.internal.measurement.H2) r0
            r13.add(r0)
            r4 = r16
            r0 = r21
            r10 = r23
            goto L_0x04db
        L_0x0539:
            r11.r(r13)
            r9.k0(r11)
            com.google.android.gms.internal.measurement.e5 r0 = r9.o()
            com.google.android.gms.internal.measurement.a3 r0 = (com.google.android.gms.internal.measurement.C1051a3) r0
            java.lang.Object r4 = r5.second
            java.lang.Long r4 = (java.lang.Long) r4
            android.util.Pair r0 = android.util.Pair.create(r0, r4)
            r7.add(r0)
            r4 = r16
            r0 = r21
            r10 = r23
            goto L_0x048c
        L_0x0558:
            r11 = r7
            goto L_0x0562
        L_0x055a:
            if (r13 == 0) goto L_0x055f
            r13.close()
        L_0x055f:
            throw r0
        L_0x0560:
            r16 = r11
        L_0x0562:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x0a00
            goto L_0x056b
        L_0x0569:
            r16 = r11
        L_0x056b:
            com.google.android.gms.measurement.internal.E3 r0 = r32.g(r33)
            f0.w r4 = f0.w.AD_STORAGE
            boolean r0 = r0.o(r4)
            if (r0 == 0) goto L_0x05cc
            java.util.Iterator r0 = r11.iterator()
        L_0x057b:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x059a
            java.lang.Object r5 = r0.next()
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r5 = r5.first
            com.google.android.gms.internal.measurement.a3 r5 = (com.google.android.gms.internal.measurement.C1051a3) r5
            java.lang.String r7 = r5.L()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x057b
            java.lang.String r0 = r5.L()
            goto L_0x059b
        L_0x059a:
            r0 = 0
        L_0x059b:
            if (r0 == 0) goto L_0x05cc
            r9 = 0
        L_0x059e:
            int r5 = r11.size()
            if (r9 >= r5) goto L_0x05cc
            java.lang.Object r5 = r11.get(r9)
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r5 = r5.first
            com.google.android.gms.internal.measurement.a3 r5 = (com.google.android.gms.internal.measurement.C1051a3) r5
            java.lang.String r7 = r5.L()
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x05b9
            goto L_0x05c9
        L_0x05b9:
            java.lang.String r5 = r5.L()
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x05c9
            r14 = 0
            java.util.List r11 = r11.subList(r14, r9)
            goto L_0x05cc
        L_0x05c9:
            int r9 = r9 + 1
            goto L_0x059e
        L_0x05cc:
            com.google.android.gms.internal.measurement.V2 r0 = com.google.android.gms.internal.measurement.Y2.M()
            int r5 = r11.size()
            java.util.ArrayList r7 = new java.util.ArrayList
            int r9 = r11.size()
            r7.<init>(r9)
            com.google.android.gms.measurement.internal.m r9 = r1.B0()
            boolean r9 = r9.k(r6)
            if (r9 == 0) goto L_0x05f3
            com.google.android.gms.measurement.internal.E3 r9 = r32.g(r33)
            boolean r9 = r9.o(r4)
            if (r9 == 0) goto L_0x05f3
            r9 = 1
            goto L_0x05f4
        L_0x05f3:
            r9 = 0
        L_0x05f4:
            com.google.android.gms.measurement.internal.E3 r10 = r32.g(r33)
            boolean r4 = r10.o(r4)
            com.google.android.gms.measurement.internal.E3 r10 = r32.g(r33)
            f0.w r12 = f0.w.ANALYTICS_STORAGE
            boolean r10 = r10.o(r12)
            com.google.android.gms.internal.measurement.x7.a()
            com.google.android.gms.measurement.internal.m r12 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r13 = com.google.android.gms.measurement.internal.C1304d2.f6287N0
            boolean r12 = r12.H(r6, r13)
            com.google.android.gms.measurement.internal.d6 r13 = r1.f6666j
            com.google.android.gms.measurement.internal.c6 r14 = r13.i(r6)
            r15 = 0
        L_0x061a:
            if (r15 >= r5) goto L_0x0778
            java.lang.Object r16 = r11.get(r15)
            r21 = r4
            r4 = r16
            android.util.Pair r4 = (android.util.Pair) r4
            java.lang.Object r4 = r4.first
            com.google.android.gms.internal.measurement.a3 r4 = (com.google.android.gms.internal.measurement.C1051a3) r4
            com.google.android.gms.internal.measurement.c5 r4 = r4.q()
            com.google.android.gms.internal.measurement.Z2 r4 = (com.google.android.gms.internal.measurement.Z2) r4
            java.lang.Object r16 = r11.get(r15)
            r22 = r5
            r5 = r16
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r5 = r5.second
            java.lang.Long r5 = (java.lang.Long) r5
            r7.add(r5)
            com.google.android.gms.measurement.internal.m r5 = r1.B0()
            r5.A()
            r5 = r9
            r16 = r10
            r9 = 133005(0x2078d, double:6.5713E-319)
            r4.H(r9)
            r4.c1(r2)
            com.google.android.gms.measurement.internal.X2 r9 = r1.f6668l
            r9.c()
            r9 = 0
            r4.p0(r9)
            if (r5 != 0) goto L_0x0662
            r4.y0()
        L_0x0662:
            if (r21 != 0) goto L_0x066a
            r4.K()
            r4.N()
        L_0x066a:
            if (r16 != 0) goto L_0x066f
            r4.Q()
        L_0x066f:
            r1.x(r6, r4)
            if (r12 != 0) goto L_0x0677
            r4.G0()
        L_0x0677:
            if (r16 != 0) goto L_0x067c
            r4.r0()
        L_0x067c:
            java.lang.String r10 = r4.I()
            boolean r20 = android.text.TextUtils.isEmpty(r10)
            if (r20 != 0) goto L_0x0699
            java.lang.String r9 = "00000000-0000-0000-0000-000000000000"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x068f
            goto L_0x0699
        L_0x068f:
            r25 = r5
            r28 = r11
            r27 = r12
            r29 = r15
            goto L_0x0734
        L_0x0699:
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.List r10 = r4.L0()
            r9.<init>(r10)
            java.util.Iterator r10 = r9.iterator()
            r25 = r5
            r26 = r10
            r5 = 0
            r10 = 0
            r23 = 0
            r24 = 0
        L_0x06b0:
            boolean r27 = r26.hasNext()
            if (r27 == 0) goto L_0x071c
            java.lang.Object r27 = r26.next()
            r28 = r11
            r11 = r27
            com.google.android.gms.internal.measurement.O2 r11 = (com.google.android.gms.internal.measurement.O2) r11
            r27 = r12
            java.lang.String r12 = r11.I()
            r29 = r15
            java.lang.String r15 = "_fx"
            boolean r12 = r15.equals(r12)
            if (r12 == 0) goto L_0x06de
            r26.remove()
            r12 = r27
            r11 = r28
            r15 = r29
            r23 = 1
        L_0x06db:
            r24 = 1
            goto L_0x06b0
        L_0x06de:
            java.lang.String r12 = r11.I()
            boolean r12 = r8.equals(r12)
            if (r12 == 0) goto L_0x0715
            r1.K0()
            java.lang.String r12 = "_pfo"
            com.google.android.gms.internal.measurement.S2 r12 = com.google.android.gms.measurement.internal.u6.r(r11, r12)
            if (r12 == 0) goto L_0x06fb
            long r30 = r12.K()
            java.lang.Long r5 = java.lang.Long.valueOf(r30)
        L_0x06fb:
            r1.K0()
            java.lang.String r12 = "_uwa"
            com.google.android.gms.internal.measurement.S2 r11 = com.google.android.gms.measurement.internal.u6.r(r11, r12)
            if (r11 == 0) goto L_0x070e
            long r10 = r11.K()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
        L_0x070e:
            r12 = r27
            r11 = r28
            r15 = r29
            goto L_0x06db
        L_0x0715:
            r12 = r27
            r11 = r28
            r15 = r29
            goto L_0x06b0
        L_0x071c:
            r28 = r11
            r27 = r12
            r29 = r15
            if (r23 == 0) goto L_0x072a
            r4.S0()
            r4.R0(r9)
        L_0x072a:
            if (r24 == 0) goto L_0x0734
            java.lang.String r9 = r4.D()
            r11 = 1
            r1.w(r9, r11, r5, r10)
        L_0x0734:
            int r5 = r4.M0()
            if (r5 != 0) goto L_0x073b
            goto L_0x0768
        L_0x073b:
            com.google.android.gms.measurement.internal.m r5 = r1.B0()
            com.google.android.gms.measurement.internal.c2 r9 = com.google.android.gms.measurement.internal.C1304d2.f6267D0
            boolean r5 = r5.H(r6, r9)
            if (r5 == 0) goto L_0x075c
            com.google.android.gms.internal.measurement.e5 r5 = r4.o()
            com.google.android.gms.internal.measurement.a3 r5 = (com.google.android.gms.internal.measurement.C1051a3) r5
            byte[] r5 = r5.e()
            com.google.android.gms.measurement.internal.u6 r9 = r1.K0()
            long r9 = r9.T(r5)
            r4.D0(r9)
        L_0x075c:
            com.google.android.gms.internal.measurement.p3 r5 = r14.d()
            if (r5 == 0) goto L_0x0765
            r4.h0(r5)
        L_0x0765:
            r0.x(r4)
        L_0x0768:
            int r15 = r29 + 1
            r10 = r16
            r4 = r21
            r5 = r22
            r9 = r25
            r12 = r27
            r11 = r28
            goto L_0x061a
        L_0x0778:
            int r4 = r0.s()
            if (r4 != 0) goto L_0x078c
            r1.q(r7)
            r5 = 0
            java.util.List r7 = java.util.Collections.EMPTY_LIST
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r1.A(r2, r3, r4, r5, r6, r7)
            return
        L_0x078c:
            com.google.android.gms.internal.measurement.e5 r4 = r0.o()
            com.google.android.gms.internal.measurement.Y2 r4 = (com.google.android.gms.internal.measurement.Y2) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            f0.K r8 = r14.c()
            f0.K r9 = f0.C1643K.SGTM_CLIENT
            if (r8 != r9) goto L_0x07a1
            r8 = 1
            goto L_0x07a2
        L_0x07a1:
            r8 = 0
        L_0x07a2:
            f0.K r9 = r14.c()
            f0.K r10 = f0.C1643K.SGTM
            if (r9 == r10) goto L_0x07b2
            if (r8 == 0) goto L_0x07ae
            r4 = 1
            goto L_0x07b3
        L_0x07ae:
            r13 = 0
        L_0x07af:
            r0 = r5
            goto L_0x09ad
        L_0x07b2:
            r4 = r8
        L_0x07b3:
            com.google.android.gms.internal.measurement.e5 r8 = r0.o()
            com.google.android.gms.internal.measurement.Y2 r8 = (com.google.android.gms.internal.measurement.Y2) r8
            java.util.List r8 = r8.F()
            java.util.Iterator r8 = r8.iterator()
        L_0x07c1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x07dc
            java.lang.Object r9 = r8.next()
            com.google.android.gms.internal.measurement.a3 r9 = (com.google.android.gms.internal.measurement.C1051a3) r9
            boolean r9 = r9.d0()
            if (r9 == 0) goto L_0x07c1
            java.util.UUID r8 = java.util.UUID.randomUUID()
            java.lang.String r8 = r8.toString()
            goto L_0x07dd
        L_0x07dc:
            r8 = 0
        L_0x07dd:
            com.google.android.gms.internal.measurement.e5 r9 = r0.o()
            com.google.android.gms.internal.measurement.Y2 r9 = (com.google.android.gms.internal.measurement.Y2) r9
            com.google.android.gms.measurement.internal.T2 r10 = r1.b()
            r10.h()
            r1.O0()
            com.google.android.gms.internal.measurement.V2 r10 = com.google.android.gms.internal.measurement.Y2.N(r9)
            boolean r11 = android.text.TextUtils.isEmpty(r8)
            if (r11 != 0) goto L_0x07fa
            r10.B(r8)
        L_0x07fa:
            com.google.android.gms.measurement.internal.P2 r11 = r1.D0()
            java.lang.String r11 = r11.x(r6)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x080b
            r10.C(r11)
        L_0x080b:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r9 = r9.F()
            java.util.Iterator r9 = r9.iterator()
        L_0x0818:
            boolean r12 = r9.hasNext()
            if (r12 == 0) goto L_0x0835
            java.lang.Object r12 = r9.next()
            com.google.android.gms.internal.measurement.a3 r12 = (com.google.android.gms.internal.measurement.C1051a3) r12
            com.google.android.gms.internal.measurement.Z2 r12 = com.google.android.gms.internal.measurement.C1051a3.l0(r12)
            r12.y0()
            com.google.android.gms.internal.measurement.e5 r12 = r12.o()
            com.google.android.gms.internal.measurement.a3 r12 = (com.google.android.gms.internal.measurement.C1051a3) r12
            r11.add(r12)
            goto L_0x0818
        L_0x0835:
            r10.z()
            r10.y(r11)
            com.google.android.gms.measurement.internal.q2 r9 = r1.a()
            com.google.android.gms.measurement.internal.o2 r9 = r9.w()
            boolean r11 = android.text.TextUtils.isEmpty(r8)
            if (r11 == 0) goto L_0x084c
            java.lang.String r11 = "null"
            goto L_0x0850
        L_0x084c:
            java.lang.String r11 = r10.A()
        L_0x0850:
            java.lang.String r12 = "[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: "
            r9.b(r12, r11)
            com.google.android.gms.internal.measurement.e5 r9 = r10.o()
            com.google.android.gms.internal.measurement.Y2 r9 = (com.google.android.gms.internal.measurement.Y2) r9
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 != 0) goto L_0x093d
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()
            com.google.android.gms.internal.measurement.Y2 r0 = (com.google.android.gms.internal.measurement.Y2) r0
            com.google.android.gms.measurement.internal.T2 r10 = r1.b()
            r10.h()
            r1.O0()
            com.google.android.gms.internal.measurement.V2 r10 = com.google.android.gms.internal.measurement.Y2.M()
            com.google.android.gms.measurement.internal.q2 r11 = r1.a()
            com.google.android.gms.measurement.internal.o2 r11 = r11.w()
            java.lang.String r12 = "[sgtm] Processing Google Signal, sgtmJoinId:"
            r11.b(r12, r8)
            r10.B(r8)
            java.util.List r0 = r0.F()
            java.util.Iterator r0 = r0.iterator()
        L_0x088d:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x08af
            java.lang.Object r8 = r0.next()
            com.google.android.gms.internal.measurement.a3 r8 = (com.google.android.gms.internal.measurement.C1051a3) r8
            com.google.android.gms.internal.measurement.Z2 r11 = com.google.android.gms.internal.measurement.C1051a3.k0()
            java.lang.String r12 = r8.e0()
            r11.x0(r12)
            int r8 = r8.b1()
            r11.d0(r8)
            r10.x(r11)
            goto L_0x088d
        L_0x08af:
            com.google.android.gms.internal.measurement.e5 r0 = r10.o()
            com.google.android.gms.internal.measurement.Y2 r0 = (com.google.android.gms.internal.measurement.Y2) r0
            com.google.android.gms.measurement.internal.q6 r8 = r13.f6129b
            com.google.android.gms.measurement.internal.P2 r8 = r8.D0()
            java.lang.String r8 = r8.x(r6)
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 != 0) goto L_0x091e
            com.google.android.gms.measurement.internal.c2 r10 = com.google.android.gms.measurement.internal.C1304d2.f6360s
            r11 = 0
            java.lang.Object r10 = r10.b(r11)
            java.lang.String r10 = (java.lang.String) r10
            android.net.Uri r10 = android.net.Uri.parse(r10)
            android.net.Uri$Builder r11 = r10.buildUpon()
            java.lang.String r10 = r10.getAuthority()
            java.lang.String r12 = java.lang.String.valueOf(r8)
            int r12 = r12.length()
            java.lang.String r13 = java.lang.String.valueOf(r10)
            r17 = 1
            int r12 = r12 + 1
            int r13 = r13.length()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            int r12 = r12 + r13
            r15.<init>(r12)
            r15.append(r8)
            java.lang.String r8 = "."
            r15.append(r8)
            r15.append(r10)
            java.lang.String r8 = r15.toString()
            r11.authority(r8)
            com.google.android.gms.measurement.internal.c6 r8 = new com.google.android.gms.measurement.internal.c6
            android.net.Uri r10 = r11.build()
            java.lang.String r10 = r10.toString()
            if (r4 == 0) goto L_0x0915
            f0.K r11 = f0.C1643K.GOOGLE_SIGNAL_PENDING
            goto L_0x0917
        L_0x0915:
            f0.K r11 = f0.C1643K.GOOGLE_SIGNAL
        L_0x0917:
            java.util.Map r12 = java.util.Collections.EMPTY_MAP
            r13 = 0
            r8.<init>(r10, r12, r11, r13)
            goto L_0x0935
        L_0x091e:
            r13 = 0
            com.google.android.gms.measurement.internal.c6 r8 = new com.google.android.gms.measurement.internal.c6
            com.google.android.gms.measurement.internal.c2 r10 = com.google.android.gms.measurement.internal.C1304d2.f6360s
            java.lang.Object r10 = r10.b(r13)
            java.lang.String r10 = (java.lang.String) r10
            if (r4 == 0) goto L_0x092e
            f0.K r11 = f0.C1643K.GOOGLE_SIGNAL_PENDING
            goto L_0x0930
        L_0x092e:
            f0.K r11 = f0.C1643K.GOOGLE_SIGNAL
        L_0x0930:
            java.util.Map r12 = java.util.Collections.EMPTY_MAP
            r8.<init>(r10, r12, r11, r13)
        L_0x0935:
            android.util.Pair r0 = android.util.Pair.create(r0, r8)
            r5.add(r0)
            goto L_0x093e
        L_0x093d:
            r13 = 0
        L_0x093e:
            if (r4 == 0) goto L_0x09aa
            com.google.android.gms.internal.measurement.c5 r0 = r9.q()
            com.google.android.gms.internal.measurement.V2 r0 = (com.google.android.gms.internal.measurement.V2) r0
            r4 = 0
        L_0x0947:
            int r8 = r9.G()
            if (r4 >= r8) goto L_0x0963
            com.google.android.gms.internal.measurement.a3 r8 = r9.H(r4)
            com.google.android.gms.internal.measurement.c5 r8 = r8.q()
            com.google.android.gms.internal.measurement.Z2 r8 = (com.google.android.gms.internal.measurement.Z2) r8
            r8.d1()
            r8.i0(r2)
            r0.w(r4, r8)
            int r4 = r4 + 1
            goto L_0x0947
        L_0x0963:
            com.google.android.gms.internal.measurement.e5 r0 = r0.o()
            com.google.android.gms.internal.measurement.Y2 r0 = (com.google.android.gms.internal.measurement.Y2) r0
            android.util.Pair r0 = android.util.Pair.create(r0, r14)
            r5.add(r0)
            r1.q(r7)
            r4 = 0
            r7 = r5
            r5 = 0
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r1.A(r2, r3, r4, r5, r6, r7)
            java.lang.String r0 = r14.a()
            boolean r0 = r1.t(r6, r0)
            if (r0 == 0) goto L_0x0a00
            com.google.android.gms.measurement.internal.q2 r0 = r1.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r2 = "[sgtm] Sending sgtm batches available notification to app"
            r0.b(r2, r6)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r2 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            r0.setAction(r2)
            r0.setPackage(r6)
            com.google.android.gms.measurement.internal.X2 r2 = r1.f6668l
            android.content.Context r2 = r2.e()
            W(r2, r0)
            return
        L_0x09aa:
            r4 = r9
            goto L_0x07af
        L_0x09ad:
            com.google.android.gms.measurement.internal.v2 r5 = r1.E0()
            boolean r5 = r5.m()
            if (r5 == 0) goto L_0x0a00
            com.google.android.gms.measurement.internal.q2 r5 = r1.a()
            java.lang.String r5 = r5.z()
            r9 = 2
            boolean r5 = android.util.Log.isLoggable(r5, r9)
            if (r5 == 0) goto L_0x09ce
            com.google.android.gms.measurement.internal.u6 r5 = r1.K0()
            java.lang.String r13 = r5.K(r4)
        L_0x09ce:
            r1.K0()
            byte[] r5 = r4.e()
            r1.q(r7)
            com.google.android.gms.measurement.internal.y5 r7 = r1.f6665i
            com.google.android.gms.measurement.internal.B2 r7 = r7.f6915i
            r7.b(r2)
            com.google.android.gms.measurement.internal.q2 r2 = r1.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()
            int r3 = r5.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "Uploading data. app, uncompressed size, data"
            r2.d(r5, r6, r3, r13)
            r11 = 1
            r1.f6677u = r11
            com.google.android.gms.measurement.internal.v2 r2 = r1.E0()
            com.google.android.gms.measurement.internal.f6 r3 = new com.google.android.gms.measurement.internal.f6
            r3.<init>(r1, r6, r0)
            r2.n(r6, r14, r4, r3)
        L_0x0a00:
            return
        L_0x0a01:
            r0 = move-exception
            r13 = r10
        L_0x0a03:
            if (r13 == 0) goto L_0x0a08
            r13.close()
        L_0x0a08:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.s(java.lang.String, long):void");
    }

    /* access modifiers changed from: package-private */
    public final void s0(boolean z4) {
        R();
    }

    /* access modifiers changed from: package-private */
    public final boolean t(String str, String str2) {
        C1443w2 J02 = F0().J0(str);
        if (J02 == null || !N0().P(str, J02.l0())) {
            o6 o6Var = (o6) this.f6651E.get(str2);
            if (o6Var == null) {
                return true;
            }
            return o6Var.b();
        }
        this.f6651E.remove(str2);
        return true;
    }

    public final void t0(String str, E4 e42) {
        b().h();
        String str2 = this.f6653G;
        if (str2 == null || str2.equals(str) || e42 != null) {
            this.f6653G = str;
            this.f6652F = e42;
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(String str) {
        t6 t6Var;
        Y2 d5;
        b().h();
        O0();
        this.f6678v = true;
        try {
            X2 x22 = this.f6668l;
            x22.c();
            Boolean x4 = x22.J().x();
            if (x4 == null) {
                a().r().a("Upload data called on the client side before use of service was decided");
            } else if (x4.booleanValue()) {
                a().o().a("Upload called in the client side when service should be used");
            } else if (this.f6671o > 0) {
                R();
            } else if (!E0().m()) {
                a().w().a("Network not connected, ignoring upload request");
                R();
            } else if (!F0().p(str)) {
                a().w().b("[sgtm] Upload queue has no batches for appId", str);
            } else {
                C1426u F02 = F0();
                C0722p.e(str);
                F02.h();
                F02.j();
                List o5 = F02.o(str, N.c(C1643K.GOOGLE_SIGNAL), 1);
                if (o5.isEmpty()) {
                    t6Var = null;
                } else {
                    t6Var = (t6) o5.get(0);
                }
                if (!(t6Var == null || (d5 = t6Var.d()) == null)) {
                    a().w().d("[sgtm] Uploading data from upload queue. appId, type, url", str, t6Var.f(), t6Var.e());
                    byte[] e5 = d5.e();
                    if (Log.isLoggable(a().z(), 2)) {
                        a().w().d("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(e5.length), K0().K(d5));
                    }
                    C1300c6 a5 = t6Var.a();
                    this.f6677u = true;
                    E0().n(str, a5, d5, new C1332g6(this, str, t6Var));
                }
            }
        } finally {
            this.f6678v = false;
            S();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void u0(r6 r6Var) {
        b().h();
        this.f6667k = new H2(this);
        C1426u uVar = new C1426u(this);
        uVar.k();
        this.f6659c = uVar;
        B0().t((C1364l) C0722p.k(this.f6657a));
        C1460y5 y5Var = new C1460y5(this);
        y5Var.k();
        this.f6665i = y5Var;
        C1309e eVar = new C1309e(this);
        eVar.k();
        this.f6662f = eVar;
        C4 c42 = new C4(this);
        c42.k();
        this.f6664h = c42;
        V5 v5 = new V5(this);
        v5.k();
        this.f6661e = v5;
        this.f6660d = new C1457y2(this);
        if (this.f6674r != this.f6675s) {
            a().o().c("Not all upload components initialized", Integer.valueOf(this.f6674r), Integer.valueOf(this.f6675s));
        }
        this.f6669m.set(true);
        a().w().a("UploadController is now fully initialized");
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.String] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f A[Catch:{ all -> 0x0010 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.t6 r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r3.b()
            r0.h()
            r3.O0()
            r0 = 0
            if (r7 != 0) goto L_0x0013
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0010 }
            goto L_0x0013
        L_0x0010:
            r4 = move-exception
            goto L_0x009b
        L_0x0013:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L_0x001c
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L_0x005a
            r5 = r1
        L_0x001c:
            if (r6 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.u r6 = r3.F0()     // Catch:{ all -> 0x0010 }
            long r7 = r8.c()     // Catch:{ all -> 0x0010 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0010 }
            r6.q(r7)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.q2 r6 = r3.a()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.o2 r6 = r6.w()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r6.c(r7, r4, r5)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.v2 r5 = r3.E0()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.m()     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.u r5 = r3.F0()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.p(r4)     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x0056
            r3.u(r4)     // Catch:{ all -> 0x0010 }
            goto L_0x0095
        L_0x0056:
            r3.R()     // Catch:{ all -> 0x0010 }
            goto L_0x0095
        L_0x005a:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0010 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0010 }
            r1.<init>(r7, r2)     // Catch:{ all -> 0x0010 }
            int r7 = r1.length()     // Catch:{ all -> 0x0010 }
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = r1.substring(r0, r7)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.q2 r1 = r3.a()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.o2 r1 = r1.t()     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            if (r6 != 0) goto L_0x0080
            r6 = r7
        L_0x0080:
            r1.d(r2, r4, r5, r6)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.u r4 = r3.F0()     // Catch:{ all -> 0x0010 }
            long r5 = r8.c()     // Catch:{ all -> 0x0010 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r4.w(r5)     // Catch:{ all -> 0x0010 }
            r3.R()     // Catch:{ all -> 0x0010 }
        L_0x0095:
            r3.f6677u = r0
            r3.S()
            return
        L_0x009b:
            r3.f6677u = r0
            r3.S()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.q6.v(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.t6):void");
    }

    /* access modifiers changed from: package-private */
    public final void w(String str, boolean z4, Long l5, Long l6) {
        C1443w2 J02 = F0().J0(str);
        if (J02 != null) {
            J02.e0(z4);
            J02.g0(l5);
            J02.i0(l6);
            if (J02.A()) {
                F0().K0(J02, false, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void x(String str, Z2 z22) {
        int X4;
        int indexOf;
        Set F4 = D0().F(str);
        if (F4 != null) {
            z22.H0(F4);
        }
        if (D0().J(str)) {
            z22.z();
        }
        if (D0().K(str)) {
            String w4 = z22.w();
            if (!TextUtils.isEmpty(w4) && (indexOf = w4.indexOf(".")) != -1) {
                z22.x(w4.substring(0, indexOf));
            }
        }
        if (D0().L(str) && (X4 = u6.X(z22, "_id")) != -1) {
            z22.b1(X4);
        }
        if (D0().M(str)) {
            z22.y0();
        }
        if (D0().N(str)) {
            z22.Q();
            if (g(str).o(w.ANALYTICS_STORAGE)) {
                Map map = this.f6650D;
                n6 n6Var = (n6) map.get(str);
                if (n6Var == null || n6Var.f6587b + B0().D(str, C1304d2.f6346l0) < f().elapsedRealtime()) {
                    n6Var = new n6(this, (byte[]) null);
                    map.put(str, n6Var);
                }
                z22.I0(n6Var.f6586a);
            }
        }
        if (D0().O(str)) {
            z22.G0();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ X2 x0() {
        return this.f6668l;
    }

    /* access modifiers changed from: package-private */
    public final void y(Z2 z22, m6 m6Var) {
        Z2 z23 = z22;
        m6 m6Var2 = m6Var;
        for (int i5 = 0; i5 < z23.M0(); i5++) {
            N2 n22 = (N2) z23.N0(i5).q();
            Iterator it = n22.r().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("_c".equals(((S2) it.next()).G())) {
                    if (m6Var2.f6555a.X0() >= B0().E(m6Var2.f6555a.F(), C1304d2.f6349m0)) {
                        int E4 = B0().E(m6Var2.f6555a.F(), C1304d2.f6375z0);
                        String str = null;
                        if (E4 <= 0) {
                            if (B0().H(m6Var2.f6555a.F(), C1304d2.f6297S0)) {
                                str = N0().l0();
                                R2 R4 = S2.R();
                                R4.s("_tu");
                                R4.w(str);
                                n22.y((S2) R4.o());
                            }
                            R2 R5 = S2.R();
                            R5.s("_tr");
                            R5.y(1);
                            n22.y((S2) R5.o());
                            S5 I4 = K0().I(m6Var2.f6555a.F(), z23, n22, str);
                            if (I4 != null) {
                                a().w().c("Generated trigger URI. appId, uri", m6Var2.f6555a.F(), I4.f6081a);
                                F0().K(m6Var2.f6555a.F(), I4);
                                Deque deque = this.f6673q;
                                if (!deque.contains(m6Var2.f6555a.F())) {
                                    deque.add(m6Var2.f6555a.F());
                                }
                            }
                        } else if (F0().L0(h(), m6Var2.f6555a.F(), false, false, false, false, false, false, true).f6624g > ((long) E4)) {
                            R2 R6 = S2.R();
                            R6.s("_tnr");
                            R6.y(1);
                            n22.y((S2) R6.o());
                        } else {
                            if (B0().H(m6Var2.f6555a.F(), C1304d2.f6297S0)) {
                                str = N0().l0();
                                R2 R7 = S2.R();
                                R7.s("_tu");
                                R7.w(str);
                                n22.y((S2) R7.o());
                            }
                            R2 R8 = S2.R();
                            R8.s("_tr");
                            R8.y(1);
                            n22.y((S2) R8.o());
                            S5 I5 = K0().I(m6Var2.f6555a.F(), z23, n22, str);
                            if (I5 != null) {
                                a().w().c("Generated trigger URI. appId, uri", m6Var2.f6555a.F(), I5.f6081a);
                                F0().K(m6Var2.f6555a.F(), I5);
                                Deque deque2 = this.f6673q;
                                if (!deque2.contains(m6Var2.f6555a.F())) {
                                    deque2.add(m6Var2.f6555a.F());
                                }
                            }
                        }
                    }
                    z23.O0(i5, (O2) n22.o());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Deque y0() {
        return this.f6673q;
    }

    /* access modifiers changed from: package-private */
    public final void z(String str, R2 r22, Bundle bundle, String str2) {
        int y4;
        List b5 = com.google.android.gms.common.util.e.b("_o", "_sn", "_sc", "_si");
        if (z6.N(r22.r()) || z6.N(str)) {
            y4 = B0().y(str2, true);
        } else {
            y4 = B0().x(str2, true);
        }
        long j5 = (long) y4;
        long codePointCount = (long) r22.t().codePointCount(0, r22.t().length());
        z6 N02 = N0();
        String r5 = r22.r();
        B0();
        String q5 = N02.q(r5, 40, true);
        if (codePointCount > j5 && !b5.contains(r22.r())) {
            if ("_ev".equals(r22.r())) {
                bundle.putString("_ev", N0().q(r22.t(), B0().y(str2, true), true));
                return;
            }
            a().t().c("Param value is too long; discarded. Name, value length", q5, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", q5);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(r22.r());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void z0(long j5) {
        this.f6655I = j5;
    }
}
