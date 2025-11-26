package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.squareup.picasso.q;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import e4.C2358g;
import e4.L;
import e4.Z;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.squareup.picasso.c  reason: case insensitive filesystem */
class C1587c implements Runnable {

    /* renamed from: t  reason: collision with root package name */
    private static final Object f13264t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static final ThreadLocal f13265u = new a();

    /* renamed from: v  reason: collision with root package name */
    private static final AtomicInteger f13266v = new AtomicInteger();

    /* renamed from: w  reason: collision with root package name */
    private static final x f13267w = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f13268a = f13266v.incrementAndGet();

    /* renamed from: b  reason: collision with root package name */
    final s f13269b;

    /* renamed from: c  reason: collision with root package name */
    final g f13270c;

    /* renamed from: d  reason: collision with root package name */
    final M1.a f13271d;

    /* renamed from: e  reason: collision with root package name */
    final z f13272e;

    /* renamed from: f  reason: collision with root package name */
    final String f13273f;

    /* renamed from: g  reason: collision with root package name */
    final v f13274g;

    /* renamed from: h  reason: collision with root package name */
    final int f13275h;

    /* renamed from: i  reason: collision with root package name */
    int f13276i;

    /* renamed from: j  reason: collision with root package name */
    final x f13277j;

    /* renamed from: k  reason: collision with root package name */
    C1585a f13278k;

    /* renamed from: l  reason: collision with root package name */
    List f13279l;

    /* renamed from: m  reason: collision with root package name */
    Bitmap f13280m;

    /* renamed from: n  reason: collision with root package name */
    Future f13281n;

    /* renamed from: o  reason: collision with root package name */
    s.e f13282o;

    /* renamed from: p  reason: collision with root package name */
    Exception f13283p;

    /* renamed from: q  reason: collision with root package name */
    int f13284q;

    /* renamed from: r  reason: collision with root package name */
    int f13285r;

    /* renamed from: s  reason: collision with root package name */
    s.f f13286s;

    /* renamed from: com.squareup.picasso.c$a */
    static class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.squareup.picasso.c$b */
    static class b extends x {
        b() {
        }

        public boolean c(v vVar) {
            return true;
        }

        public x.a f(v vVar, int i5) {
            throw new IllegalStateException("Unrecognized type of request: " + vVar);
        }
    }

    /* renamed from: com.squareup.picasso.c$c  reason: collision with other inner class name */
    static class C0116c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ M1.e f13287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RuntimeException f13288b;

        C0116c(M1.e eVar, RuntimeException runtimeException) {
            this.f13287a = eVar;
            this.f13288b = runtimeException;
        }

        public void run() {
            throw new RuntimeException("Transformation " + this.f13287a.key() + " crashed with exception.", this.f13288b);
        }
    }

    /* renamed from: com.squareup.picasso.c$d */
    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StringBuilder f13289a;

        d(StringBuilder sb) {
            this.f13289a = sb;
        }

        public void run() {
            throw new NullPointerException(this.f13289a.toString());
        }
    }

    /* renamed from: com.squareup.picasso.c$e */
    static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ M1.e f13290a;

        e(M1.e eVar) {
            this.f13290a = eVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f13290a.key() + " returned input Bitmap but recycled it.");
        }
    }

    /* renamed from: com.squareup.picasso.c$f */
    static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ M1.e f13291a;

        f(M1.e eVar) {
            this.f13291a = eVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f13291a.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    C1587c(s sVar, g gVar, M1.a aVar, z zVar, C1585a aVar2, x xVar) {
        this.f13269b = sVar;
        this.f13270c = gVar;
        this.f13271d = aVar;
        this.f13272e = zVar;
        this.f13278k = aVar2;
        this.f13273f = aVar2.d();
        this.f13274g = aVar2.i();
        this.f13286s = aVar2.h();
        this.f13275h = aVar2.e();
        this.f13276i = aVar2.f();
        this.f13277j = xVar;
        this.f13285r = xVar.e();
    }

    static Bitmap a(List list, Bitmap bitmap) {
        int size = list.size();
        int i5 = 0;
        while (i5 < size) {
            M1.e eVar = (M1.e) list.get(i5);
            try {
                Bitmap a5 = eVar.a(bitmap);
                if (a5 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(eVar.key());
                    sb.append(" returned null after ");
                    sb.append(i5);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(((M1.e) it.next()).key());
                        sb.append(10);
                    }
                    s.f13356o.post(new d(sb));
                    return null;
                } else if (a5 == bitmap && bitmap.isRecycled()) {
                    s.f13356o.post(new e(eVar));
                    return null;
                } else if (a5 == bitmap || bitmap.isRecycled()) {
                    i5++;
                    bitmap = a5;
                } else {
                    s.f13356o.post(new f(eVar));
                    return null;
                }
            } catch (RuntimeException e5) {
                s.f13356o.post(new C0116c(eVar, e5));
                return null;
            }
        }
        return bitmap;
    }

    private s.f d() {
        boolean z4;
        s.f fVar = s.f.LOW;
        List list = this.f13279l;
        if (list == null || list.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        C1585a aVar = this.f13278k;
        if (aVar == null && !z4) {
            return fVar;
        }
        if (aVar != null) {
            fVar = aVar.h();
        }
        if (z4) {
            int size = this.f13279l.size();
            for (int i5 = 0; i5 < size; i5++) {
                s.f h5 = ((C1585a) this.f13279l.get(i5)).h();
                if (h5.ordinal() > fVar.ordinal()) {
                    fVar = h5;
                }
            }
        }
        return fVar;
    }

    static Bitmap e(Z z4, v vVar) {
        C2358g d5 = L.d(z4);
        boolean s5 = C.s(d5);
        boolean z5 = vVar.f13422r;
        BitmapFactory.Options d6 = x.d(vVar);
        boolean g5 = x.g(d6);
        if (!s5) {
            InputStream inputStream = d5.inputStream();
            if (g5) {
                m mVar = new m(inputStream);
                mVar.a(false);
                long l5 = mVar.l(1024);
                BitmapFactory.decodeStream(mVar, (Rect) null, d6);
                x.b(vVar.f13412h, vVar.f13413i, d6, vVar);
                mVar.d(l5);
                mVar.a(true);
                inputStream = mVar;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, d6);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] readByteArray = d5.readByteArray();
        if (g5) {
            BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d6);
            x.b(vVar.f13412h, vVar.f13413i, d6, vVar);
        }
        return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d6);
    }

    static C1587c g(s sVar, g gVar, M1.a aVar, z zVar, C1585a aVar2) {
        v i5 = aVar2.i();
        List i6 = sVar.i();
        int size = i6.size();
        for (int i7 = 0; i7 < size; i7++) {
            x xVar = (x) i6.get(i7);
            if (xVar.c(i5)) {
                return new C1587c(sVar, gVar, aVar, zVar, aVar2, xVar);
            }
        }
        return new C1587c(sVar, gVar, aVar, zVar, aVar2, f13267w);
    }

    static int l(int i5) {
        switch (i5) {
            case 3:
            case 4:
                return SubsamplingScaleImageView.ORIENTATION_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    static int m(int i5) {
        return (i5 == 2 || i5 == 7 || i5 == 4 || i5 == 5) ? -1 : 1;
    }

    private static boolean v(boolean z4, int i5, int i6, int i7, int i8) {
        if (!z4) {
            return true;
        }
        if (i7 == 0 || i5 <= i7) {
            return i8 != 0 && i6 > i8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap y(com.squareup.picasso.v r27, android.graphics.Bitmap r28, int r29) {
        /*
            r0 = r27
            int r1 = r28.getWidth()
            int r2 = r28.getHeight()
            boolean r3 = r0.f13417m
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            boolean r4 = r0.e()
            if (r4 != 0) goto L_0x001e
            if (r29 == 0) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            r3 = r1
            r6 = r2
            goto L_0x026a
        L_0x001e:
            int r4 = r0.f13412h
            int r7 = r0.f13413i
            float r8 = r0.f13418n
            r9 = 0
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x014b
            double r9 = (double) r8
            double r11 = java.lang.Math.toRadians(r9)
            double r11 = java.lang.Math.cos(r11)
            double r9 = java.lang.Math.toRadians(r9)
            double r9 = java.lang.Math.sin(r9)
            boolean r4 = r0.f13421q
            if (r4 == 0) goto L_0x00da
            float r4 = r0.f13419o
            float r7 = r0.f13420p
            r5.setRotate(r8, r4, r7)
            float r4 = r0.f13419o
            double r7 = (double) r4
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r13 - r11
            double r7 = r7 * r13
            float r15 = r0.f13420p
            r17 = r7
            double r6 = (double) r15
            double r6 = r6 * r9
            double r7 = r17 + r6
            r17 = r9
            double r9 = (double) r15
            double r9 = r9 * r13
            double r13 = (double) r4
            double r13 = r13 * r17
            double r9 = r9 - r13
            int r4 = r0.f13412h
            double r13 = (double) r4
            double r13 = r13 * r11
            double r13 = r13 + r7
            r19 = r11
            double r11 = (double) r4
            double r11 = r11 * r17
            double r11 = r11 + r9
            r6 = r2
            r15 = r3
            double r2 = (double) r4
            double r2 = r2 * r19
            double r2 = r2 + r7
            r21 = r2
            int r2 = r0.f13413i
            r3 = r1
            double r0 = (double) r2
            double r0 = r0 * r17
            double r0 = r21 - r0
            r21 = r3
            double r3 = (double) r4
            double r3 = r3 * r17
            double r3 = r3 + r9
            r22 = r3
            double r3 = (double) r2
            double r3 = r3 * r19
            double r3 = r22 + r3
            r22 = r5
            r23 = r6
            double r5 = (double) r2
            double r5 = r5 * r17
            double r5 = r7 - r5
            r24 = r3
            double r2 = (double) r2
            double r2 = r2 * r19
            double r2 = r2 + r9
            r17 = r2
            double r2 = java.lang.Math.max(r7, r13)
            double r2 = java.lang.Math.max(r0, r2)
            double r2 = java.lang.Math.max(r5, r2)
            double r7 = java.lang.Math.min(r7, r13)
            double r0 = java.lang.Math.min(r0, r7)
            double r0 = java.lang.Math.min(r5, r0)
            double r4 = java.lang.Math.max(r9, r11)
            r6 = r24
            double r4 = java.lang.Math.max(r6, r4)
            r13 = r17
            double r4 = java.lang.Math.max(r13, r4)
            double r8 = java.lang.Math.min(r9, r11)
            double r6 = java.lang.Math.min(r6, r8)
            double r6 = java.lang.Math.min(r13, r6)
            double r2 = r2 - r0
            double r0 = java.lang.Math.floor(r2)
            int r0 = (int) r0
            double r4 = r4 - r6
            double r1 = java.lang.Math.floor(r4)
            int r7 = (int) r1
            r4 = r0
            r17 = r15
            goto L_0x0153
        L_0x00da:
            r21 = r1
            r23 = r2
            r15 = r3
            r17 = r9
            r19 = r11
            r5.setRotate(r8)
            r0 = r27
            int r1 = r0.f13412h
            double r2 = (double) r1
            double r2 = r2 * r19
            double r6 = (double) r1
            double r6 = r6 * r17
            double r8 = (double) r1
            double r8 = r8 * r19
            int r4 = r0.f13413i
            double r10 = (double) r4
            double r10 = r10 * r17
            double r8 = r8 - r10
            double r10 = (double) r1
            double r10 = r10 * r17
            double r12 = (double) r4
            double r12 = r12 * r19
            double r10 = r10 + r12
            double r12 = (double) r4
            double r12 = r12 * r17
            double r12 = -r12
            r1 = r15
            double r14 = (double) r4
            double r14 = r14 * r19
            r17 = r1
            r0 = 0
            r22 = r5
            double r4 = java.lang.Math.max(r0, r2)
            double r4 = java.lang.Math.max(r8, r4)
            double r4 = java.lang.Math.max(r12, r4)
            double r2 = java.lang.Math.min(r0, r2)
            double r2 = java.lang.Math.min(r8, r2)
            double r2 = java.lang.Math.min(r12, r2)
            double r8 = java.lang.Math.max(r0, r6)
            double r8 = java.lang.Math.max(r10, r8)
            double r8 = java.lang.Math.max(r14, r8)
            double r0 = java.lang.Math.min(r0, r6)
            double r0 = java.lang.Math.min(r10, r0)
            double r0 = java.lang.Math.min(r14, r0)
            double r4 = r4 - r2
            double r2 = java.lang.Math.floor(r4)
            int r4 = (int) r2
            double r8 = r8 - r0
            double r0 = java.lang.Math.floor(r8)
            int r7 = (int) r0
            goto L_0x0153
        L_0x014b:
            r21 = r1
            r23 = r2
            r17 = r3
            r22 = r5
        L_0x0153:
            if (r29 == 0) goto L_0x0181
            int r0 = l(r29)
            int r1 = m(r29)
            if (r0 == 0) goto L_0x0173
            float r2 = (float) r0
            r5 = r22
            r5.preRotate(r2)
            r2 = 90
            if (r0 == r2) goto L_0x016d
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x0175
        L_0x016d:
            r26 = r7
            r7 = r4
            r4 = r26
            goto L_0x0175
        L_0x0173:
            r5 = r22
        L_0x0175:
            r0 = 1
            if (r1 == r0) goto L_0x017e
            float r0 = (float) r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r5.postScale(r0, r1)
        L_0x017e:
            r0 = r27
            goto L_0x0184
        L_0x0181:
            r5 = r22
            goto L_0x017e
        L_0x0184:
            boolean r1 = r0.f13414j
            if (r1 == 0) goto L_0x021b
            if (r4 == 0) goto L_0x0192
            float r1 = (float) r4
            r3 = r21
            float r2 = (float) r3
            float r1 = r1 / r2
            r6 = r23
            goto L_0x0199
        L_0x0192:
            r3 = r21
            float r1 = (float) r7
            r6 = r23
            float r2 = (float) r6
            float r1 = r1 / r2
        L_0x0199:
            if (r7 == 0) goto L_0x019f
            float r2 = (float) r7
            float r8 = (float) r6
        L_0x019d:
            float r2 = r2 / r8
            goto L_0x01a2
        L_0x019f:
            float r2 = (float) r4
            float r8 = (float) r3
            goto L_0x019d
        L_0x01a2:
            int r8 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x01d2
            float r8 = (float) r6
            float r2 = r2 / r1
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r0 = r0.f13415k
            r8 = r0 & 48
            r9 = 48
            if (r8 != r9) goto L_0x01b9
            r0 = 0
            goto L_0x01c5
        L_0x01b9:
            r8 = 80
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01c1
            int r0 = r6 - r2
            goto L_0x01c5
        L_0x01c1:
            int r0 = r6 - r2
            int r0 = r0 / 2
        L_0x01c5:
            float r8 = (float) r7
            float r9 = (float) r2
            float r8 = r8 / r9
            r23 = r2
            r21 = r3
            r2 = r8
            r15 = r17
        L_0x01cf:
            r16 = 0
            goto L_0x020a
        L_0x01d2:
            int r8 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0201
            float r8 = (float) r3
            float r1 = r1 / r2
            float r8 = r8 * r1
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r1 = (int) r8
            int r0 = r0.f13415k
            r8 = r0 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01e8
            r0 = 0
            goto L_0x01f3
        L_0x01e8:
            r8 = 5
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01ef
            int r0 = r3 - r1
            goto L_0x01f3
        L_0x01ef:
            int r0 = r3 - r1
            int r0 = r0 / 2
        L_0x01f3:
            float r8 = (float) r4
            float r9 = (float) r1
            float r8 = r8 / r9
            r16 = r0
            r21 = r1
            r23 = r6
            r1 = r8
            r15 = r17
            r0 = 0
            goto L_0x020a
        L_0x0201:
            r1 = r2
            r21 = r3
            r23 = r6
            r15 = r17
            r0 = 0
            goto L_0x01cf
        L_0x020a:
            boolean r3 = v(r15, r3, r6, r4, r7)
            if (r3 == 0) goto L_0x0213
            r5.preScale(r1, r2)
        L_0x0213:
            r2 = r0
            r1 = r16
            r3 = r21
            r4 = r23
            goto L_0x026d
        L_0x021b:
            r15 = r17
            r3 = r21
            r6 = r23
            boolean r0 = r0.f13416l
            if (r0 == 0) goto L_0x0247
            if (r4 == 0) goto L_0x022b
            float r0 = (float) r4
            float r1 = (float) r3
        L_0x0229:
            float r0 = r0 / r1
            goto L_0x022e
        L_0x022b:
            float r0 = (float) r7
            float r1 = (float) r6
            goto L_0x0229
        L_0x022e:
            if (r7 == 0) goto L_0x0234
            float r1 = (float) r7
            float r2 = (float) r6
        L_0x0232:
            float r1 = r1 / r2
            goto L_0x0237
        L_0x0234:
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0232
        L_0x0237:
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x023c
            goto L_0x023d
        L_0x023c:
            r0 = r1
        L_0x023d:
            boolean r1 = v(r15, r3, r6, r4, r7)
            if (r1 == 0) goto L_0x026a
            r5.preScale(r0, r0)
            goto L_0x026a
        L_0x0247:
            if (r4 != 0) goto L_0x024b
            if (r7 == 0) goto L_0x026a
        L_0x024b:
            if (r4 != r3) goto L_0x024f
            if (r7 == r6) goto L_0x026a
        L_0x024f:
            if (r4 == 0) goto L_0x0255
            float r0 = (float) r4
            float r1 = (float) r3
        L_0x0253:
            float r0 = r0 / r1
            goto L_0x0258
        L_0x0255:
            float r0 = (float) r7
            float r1 = (float) r6
            goto L_0x0253
        L_0x0258:
            if (r7 == 0) goto L_0x025e
            float r1 = (float) r7
            float r2 = (float) r6
        L_0x025c:
            float r1 = r1 / r2
            goto L_0x0261
        L_0x025e:
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x025c
        L_0x0261:
            boolean r2 = v(r15, r3, r6, r4, r7)
            if (r2 == 0) goto L_0x026a
            r5.preScale(r0, r1)
        L_0x026a:
            r4 = r6
            r1 = 0
            r2 = 0
        L_0x026d:
            r6 = 1
            r0 = r28
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == r0) goto L_0x027a
            r0.recycle()
            return r1
        L_0x027a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1587c.y(com.squareup.picasso.v, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static void z(v vVar) {
        String a5 = vVar.a();
        StringBuilder sb = (StringBuilder) f13265u.get();
        sb.ensureCapacity(a5.length() + 8);
        sb.replace(8, sb.length(), a5);
        Thread.currentThread().setName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void b(C1585a aVar) {
        boolean z4 = this.f13269b.f13370m;
        v vVar = aVar.f13248b;
        if (this.f13278k == null) {
            this.f13278k = aVar;
            if (z4) {
                List list = this.f13279l;
                if (list == null || list.isEmpty()) {
                    C.u("Hunter", "joined", vVar.d(), "to empty hunter");
                } else {
                    C.u("Hunter", "joined", vVar.d(), C.l(this, "to "));
                }
            }
        } else {
            if (this.f13279l == null) {
                this.f13279l = new ArrayList(3);
            }
            this.f13279l.add(aVar);
            if (z4) {
                C.u("Hunter", "joined", vVar.d(), C.l(this, "to "));
            }
            s.f h5 = aVar.h();
            if (h5.ordinal() > this.f13286s.ordinal()) {
                this.f13286s = h5;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        List list;
        Future future;
        if (this.f13278k != null || (((list = this.f13279l) != null && !list.isEmpty()) || (future = this.f13281n) == null || !future.cancel(false))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(C1585a aVar) {
        boolean z4;
        if (this.f13278k == aVar) {
            this.f13278k = null;
            z4 = true;
        } else {
            List list = this.f13279l;
            if (list != null) {
                z4 = list.remove(aVar);
            } else {
                z4 = false;
            }
        }
        if (z4 && aVar.h() == this.f13286s) {
            this.f13286s = d();
        }
        if (this.f13269b.f13370m) {
            C.u("Hunter", "removed", aVar.f13248b.d(), C.l(this, "from "));
        }
    }

    /* access modifiers changed from: package-private */
    public C1585a h() {
        return this.f13278k;
    }

    /* access modifiers changed from: package-private */
    public List i() {
        return this.f13279l;
    }

    /* access modifiers changed from: package-private */
    public v j() {
        return this.f13274g;
    }

    /* access modifiers changed from: package-private */
    public Exception k() {
        return this.f13283p;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        return this.f13273f;
    }

    /* access modifiers changed from: package-private */
    public s.e o() {
        return this.f13282o;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f13275h;
    }

    /* access modifiers changed from: package-private */
    public s q() {
        return this.f13269b;
    }

    /* access modifiers changed from: package-private */
    public s.f r() {
        return this.f13286s;
    }

    public void run() {
        try {
            z(this.f13274g);
            if (this.f13269b.f13370m) {
                C.t("Hunter", "executing", C.k(this));
            }
            Bitmap t5 = t();
            this.f13280m = t5;
            if (t5 == null) {
                this.f13270c.e(this);
            } else {
                this.f13270c.d(this);
            }
            Thread.currentThread().setName("Picasso-Idle");
            return;
        } catch (q.b e5) {
            if (!p.a(e5.f13352b) || e5.f13351a != 504) {
                this.f13283p = e5;
            }
            this.f13270c.e(this);
        } catch (IOException e6) {
            this.f13283p = e6;
            this.f13270c.g(this);
        } catch (OutOfMemoryError e7) {
            StringWriter stringWriter = new StringWriter();
            this.f13272e.a().a(new PrintWriter(stringWriter));
            this.f13283p = new RuntimeException(stringWriter.toString(), e7);
            this.f13270c.e(this);
        } catch (Exception e8) {
            this.f13283p = e8;
            this.f13270c.e(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    public Bitmap s() {
        return this.f13280m;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ca A[Catch:{ all -> 0x00a5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap t() {
        /*
            r6 = this;
            int r0 = r6.f13275h
            boolean r0 = com.squareup.picasso.o.a(r0)
            if (r0 == 0) goto L_0x0031
            M1.a r0 = r6.f13271d
            java.lang.String r1 = r6.f13273f
            android.graphics.Bitmap r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0032
            com.squareup.picasso.z r1 = r6.f13272e
            r1.d()
            com.squareup.picasso.s$e r1 = com.squareup.picasso.s.e.MEMORY
            r6.f13282o = r1
            com.squareup.picasso.s r1 = r6.f13269b
            boolean r1 = r1.f13370m
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            com.squareup.picasso.v r3 = r6.f13274g
            java.lang.String r3 = r3.d()
            java.lang.String r4 = "from cache"
            com.squareup.picasso.C.u(r1, r2, r3, r4)
        L_0x0030:
            return r0
        L_0x0031:
            r0 = 0
        L_0x0032:
            int r1 = r6.f13285r
            if (r1 != 0) goto L_0x003b
            com.squareup.picasso.p r1 = com.squareup.picasso.p.OFFLINE
            int r1 = r1.f13348a
            goto L_0x003d
        L_0x003b:
            int r1 = r6.f13276i
        L_0x003d:
            r6.f13276i = r1
            com.squareup.picasso.x r2 = r6.f13277j
            com.squareup.picasso.v r3 = r6.f13274g
            com.squareup.picasso.x$a r1 = r2.f(r3, r1)
            if (r1 == 0) goto L_0x006f
            com.squareup.picasso.s$e r0 = r1.c()
            r6.f13282o = r0
            int r0 = r1.b()
            r6.f13284q = r0
            android.graphics.Bitmap r0 = r1.a()
            if (r0 != 0) goto L_0x006f
            e4.Z r0 = r1.d()
            com.squareup.picasso.v r1 = r6.f13274g     // Catch:{ all -> 0x006a }
            android.graphics.Bitmap r1 = e(r0, r1)     // Catch:{ all -> 0x006a }
            r0.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            r0 = r1
            goto L_0x006f
        L_0x006a:
            r1 = move-exception
            r0.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x00f2
            com.squareup.picasso.s r1 = r6.f13269b
            boolean r1 = r1.f13370m
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            com.squareup.picasso.v r3 = r6.f13274g
            java.lang.String r3 = r3.d()
            com.squareup.picasso.C.t(r1, r2, r3)
        L_0x0084:
            com.squareup.picasso.z r1 = r6.f13272e
            r1.b(r0)
            com.squareup.picasso.v r1 = r6.f13274g
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0095
            int r1 = r6.f13284q
            if (r1 == 0) goto L_0x00f2
        L_0x0095:
            java.lang.Object r1 = f13264t
            monitor-enter(r1)
            com.squareup.picasso.v r2 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.e()     // Catch:{ all -> 0x00a5 }
            if (r2 != 0) goto L_0x00a7
            int r2 = r6.f13284q     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x00c2
            goto L_0x00a7
        L_0x00a5:
            r0 = move-exception
            goto L_0x00f0
        L_0x00a7:
            com.squareup.picasso.v r2 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            int r3 = r6.f13284q     // Catch:{ all -> 0x00a5 }
            android.graphics.Bitmap r0 = y(r2, r0, r3)     // Catch:{ all -> 0x00a5 }
            com.squareup.picasso.s r2 = r6.f13269b     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.f13370m     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.v r4 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = r4.d()     // Catch:{ all -> 0x00a5 }
            com.squareup.picasso.C.t(r2, r3, r4)     // Catch:{ all -> 0x00a5 }
        L_0x00c2:
            com.squareup.picasso.v r2 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.b()     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x00e7
            com.squareup.picasso.v r2 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            java.util.List r2 = r2.f13411g     // Catch:{ all -> 0x00a5 }
            android.graphics.Bitmap r0 = a(r2, r0)     // Catch:{ all -> 0x00a5 }
            com.squareup.picasso.s r2 = r6.f13269b     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.f13370m     // Catch:{ all -> 0x00a5 }
            if (r2 == 0) goto L_0x00e7
            java.lang.String r2 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.v r4 = r6.f13274g     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = r4.d()     // Catch:{ all -> 0x00a5 }
            java.lang.String r5 = "from custom transformations"
            com.squareup.picasso.C.u(r2, r3, r4, r5)     // Catch:{ all -> 0x00a5 }
        L_0x00e7:
            monitor-exit(r1)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x00f2
            com.squareup.picasso.z r1 = r6.f13272e
            r1.c(r0)
            goto L_0x00f2
        L_0x00f0:
            monitor-exit(r1)     // Catch:{ all -> 0x00a5 }
            throw r0
        L_0x00f2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1587c.t():android.graphics.Bitmap");
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        Future future = this.f13281n;
        if (future == null || !future.isCancelled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean w(boolean z4, NetworkInfo networkInfo) {
        int i5 = this.f13285r;
        if (i5 <= 0) {
            return false;
        }
        this.f13285r = i5 - 1;
        return this.f13277j.h(z4, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f13277j.i();
    }
}
