package com.google.android.gms.measurement.internal;

import N.C0722p;
import T.e;
import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.internal.measurement.C1160m4;
import com.google.android.gms.internal.measurement.J0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class X2 implements C3 {

    /* renamed from: E  reason: collision with root package name */
    private static volatile X2 f6133E;

    /* renamed from: A  reason: collision with root package name */
    private int f6134A;

    /* renamed from: B  reason: collision with root package name */
    private int f6135B;

    /* renamed from: C  reason: collision with root package name */
    private final AtomicInteger f6136C = new AtomicInteger(0);

    /* renamed from: D  reason: collision with root package name */
    final long f6137D;

    /* renamed from: a  reason: collision with root package name */
    private final Context f6138a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6139b;

    /* renamed from: c  reason: collision with root package name */
    private final C1317f f6140c;

    /* renamed from: d  reason: collision with root package name */
    private final C1371m f6141d;

    /* renamed from: e  reason: collision with root package name */
    private final E2 f6142e;

    /* renamed from: f  reason: collision with root package name */
    private final C1402q2 f6143f;

    /* renamed from: g  reason: collision with root package name */
    private final T2 f6144g;

    /* renamed from: h  reason: collision with root package name */
    private final N5 f6145h;

    /* renamed from: i  reason: collision with root package name */
    private final z6 f6146i;

    /* renamed from: j  reason: collision with root package name */
    private final C1352j2 f6147j;

    /* renamed from: k  reason: collision with root package name */
    private final d f6148k;

    /* renamed from: l  reason: collision with root package name */
    private final M4 f6149l;

    /* renamed from: m  reason: collision with root package name */
    private final C1452x4 f6150m;

    /* renamed from: n  reason: collision with root package name */
    private final C0 f6151n;

    /* renamed from: o  reason: collision with root package name */
    private final B4 f6152o;

    /* renamed from: p  reason: collision with root package name */
    private final String f6153p;

    /* renamed from: q  reason: collision with root package name */
    private C1344i2 f6154q;

    /* renamed from: r  reason: collision with root package name */
    private C1446w5 f6155r;

    /* renamed from: s  reason: collision with root package name */
    private A f6156s;

    /* renamed from: t  reason: collision with root package name */
    private C1328g2 f6157t;

    /* renamed from: u  reason: collision with root package name */
    private D4 f6158u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f6159v = false;

    /* renamed from: w  reason: collision with root package name */
    private Boolean f6160w;

    /* renamed from: x  reason: collision with root package name */
    private long f6161x;

    /* renamed from: y  reason: collision with root package name */
    private volatile Boolean f6162y;

    /* renamed from: z  reason: collision with root package name */
    private volatile boolean f6163z;

    X2(G3 g32) {
        long j5;
        boolean z4 = false;
        C0722p.k(g32);
        Context context = g32.f5891a;
        C1317f fVar = new C1317f(context);
        this.f6140c = fVar;
        W1.f6124a = fVar;
        this.f6138a = context;
        this.f6139b = g32.f5895e;
        this.f6162y = g32.f5892b;
        this.f6153p = g32.f5897g;
        this.f6163z = true;
        C1160m4.b(context);
        d b5 = g.b();
        this.f6148k = b5;
        Long l5 = g32.f5896f;
        if (l5 != null) {
            j5 = l5.longValue();
        } else {
            j5 = b5.currentTimeMillis();
        }
        this.f6137D = j5;
        this.f6141d = new C1371m(this);
        E2 e22 = new E2(this);
        e22.m();
        this.f6142e = e22;
        C1402q2 q2Var = new C1402q2(this);
        q2Var.m();
        this.f6143f = q2Var;
        z6 z6Var = new z6(this);
        z6Var.m();
        this.f6146i = z6Var;
        this.f6147j = new C1352j2(new F3(g32, this));
        this.f6151n = new C0(this);
        M4 m42 = new M4(this);
        m42.k();
        this.f6149l = m42;
        C1452x4 x4Var = new C1452x4(this);
        x4Var.k();
        this.f6150m = x4Var;
        N5 n5 = new N5(this);
        n5.k();
        this.f6145h = n5;
        B4 b42 = new B4(this);
        b42.m();
        this.f6152o = b42;
        T2 t22 = new T2(this);
        t22.m();
        this.f6144g = t22;
        J0 j02 = g32.f5894d;
        z4 = (j02 == null || j02.f4986b == 0) ? true : z4;
        if (context.getApplicationContext() instanceof Application) {
            t(x4Var);
            if (x4Var.f5730a.f6138a.getApplicationContext() instanceof Application) {
                Application application = (Application) x4Var.f5730a.f6138a.getApplicationContext();
                if (x4Var.f6868c == null) {
                    x4Var.f6868c = new C1369l4(x4Var);
                }
                if (z4) {
                    application.unregisterActivityLifecycleCallbacks(x4Var.f6868c);
                    application.registerActivityLifecycleCallbacks(x4Var.f6868c);
                    C1402q2 q2Var2 = x4Var.f5730a.f6143f;
                    u(q2Var2);
                    q2Var2.w().a("Registered activity lifecycle callback");
                }
            }
        } else {
            u(q2Var);
            q2Var.r().a("Application context is not an Application");
        }
        t22.t(new V2(this, g32));
    }

    public static X2 O(Context context, J0 j02, Long l5) {
        Bundle bundle;
        if (j02 != null) {
            Bundle bundle2 = j02.f4988d;
            boolean z4 = j02.f4987c;
            j02 = new J0(j02.f4985a, j02.f4986b, z4, bundle2, (String) null);
        }
        C0722p.k(context);
        C0722p.k(context.getApplicationContext());
        if (f6133E == null) {
            synchronized (X2.class) {
                try {
                    if (f6133E == null) {
                        f6133E = new X2(new G3(context, j02, l5));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (!(j02 == null || (bundle = j02.f4988d) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            C0722p.k(f6133E);
            f6133E.f6162y = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        C0722p.k(f6133E);
        return f6133E;
    }

    static final void q() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void r(E1 e12) {
        if (e12 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void s(A3 a32) {
        if (a32 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void t(C1320f2 f2Var) {
        if (f2Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!f2Var.i()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(f2Var.getClass())));
        }
    }

    private static final void u(B3 b32) {
        if (b32 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!b32.k()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(b32.getClass())));
        }
    }

    /* access modifiers changed from: package-private */
    public final T2 A() {
        return this.f6144g;
    }

    public final C1452x4 B() {
        C1452x4 x4Var = this.f6150m;
        t(x4Var);
        return x4Var;
    }

    public final z6 C() {
        z6 z6Var = this.f6146i;
        s(z6Var);
        return z6Var;
    }

    public final C1352j2 D() {
        return this.f6147j;
    }

    public final C1344i2 E() {
        t(this.f6154q);
        return this.f6154q;
    }

    public final B4 F() {
        B4 b42 = this.f6152o;
        u(b42);
        return b42;
    }

    public final boolean G() {
        return this.f6139b;
    }

    public final String H() {
        return this.f6153p;
    }

    public final M4 I() {
        M4 m42 = this.f6149l;
        t(m42);
        return m42;
    }

    public final C1446w5 J() {
        t(this.f6155r);
        return this.f6155r;
    }

    public final A K() {
        u(this.f6156s);
        return this.f6156s;
    }

    public final C1328g2 L() {
        t(this.f6157t);
        return this.f6157t;
    }

    public final C0 M() {
        C0 c02 = this.f6151n;
        r(c02);
        return c02;
    }

    public final D4 N() {
        r(this.f6158u);
        return this.f6158u;
    }

    /* access modifiers changed from: package-private */
    public final void P(boolean z4) {
        this.f6162y = Boolean.valueOf(z4);
    }

    public final C1402q2 a() {
        C1402q2 q2Var = this.f6143f;
        u(q2Var);
        return q2Var;
    }

    public final T2 b() {
        T2 t22 = this.f6144g;
        u(t22);
        return t22;
    }

    public final C1317f c() {
        return this.f6140c;
    }

    public final boolean d() {
        if (this.f6162y == null || !this.f6162y.booleanValue()) {
            return false;
        }
        return true;
    }

    public final Context e() {
        return this.f6138a;
    }

    public final d f() {
        return this.f6148k;
    }

    public final boolean g() {
        if (h() == 0) {
            return true;
        }
        return false;
    }

    public final int h() {
        T2 t22 = this.f6144g;
        u(t22);
        t22.h();
        C1371m mVar = this.f6141d;
        if (mVar.L()) {
            return 1;
        }
        u(t22);
        t22.h();
        if (!this.f6163z) {
            return 8;
        }
        E2 e22 = this.f6142e;
        s(e22);
        Boolean t5 = e22.t();
        if (t5 == null) {
            C1317f fVar = mVar.f5730a.f6140c;
            Boolean J4 = mVar.J("firebase_analytics_collection_enabled");
            if (J4 != null) {
                if (J4.booleanValue()) {
                    return 0;
                }
                return 4;
            } else if (this.f6162y == null || this.f6162y.booleanValue()) {
                return 0;
            } else {
                return 7;
            }
        } else if (t5.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final void i(boolean z4) {
        T2 t22 = this.f6144g;
        u(t22);
        t22.h();
        this.f6163z = z4;
    }

    public final boolean j() {
        T2 t22 = this.f6144g;
        u(t22);
        t22.h();
        return this.f6163z;
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        this.f6134A++;
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        this.f6136C.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        if (this.f6159v) {
            T2 t22 = this.f6144g;
            u(t22);
            t22.h();
            Boolean bool = this.f6160w;
            if (bool == null || this.f6161x == 0 || (!bool.booleanValue() && Math.abs(this.f6148k.elapsedRealtime() - this.f6161x) > 1000)) {
                this.f6161x = this.f6148k.elapsedRealtime();
                z6 z6Var = this.f6146i;
                s(z6Var);
                boolean z4 = false;
                if (z6Var.M("android.permission.INTERNET")) {
                    s(z6Var);
                    if (z6Var.M("android.permission.ACCESS_NETWORK_STATE")) {
                        Context context = this.f6138a;
                        if (e.a(context).f() || this.f6141d.m() || (z6.j0(context) && z6.E(context, false))) {
                            z4 = true;
                        }
                    }
                }
                Boolean valueOf = Boolean.valueOf(z4);
                this.f6160w = valueOf;
                if (valueOf.booleanValue()) {
                    s(z6Var);
                    this.f6160w = Boolean.valueOf(z6Var.o(L().r()));
                }
            }
            return this.f6160w.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
        if (r3.W() >= 234200) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean n() {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r13.f6144g
            u(r0)
            r0.h()
            com.google.android.gms.measurement.internal.B4 r0 = r13.f6152o
            u(r0)
            u(r0)
            com.google.android.gms.measurement.internal.g2 r1 = r13.L()
            java.lang.String r4 = r1.q()
            com.google.android.gms.measurement.internal.m r1 = r13.f6141d
            boolean r1 = r1.M()
            r10 = 0
            if (r1 == 0) goto L_0x01b9
            com.google.android.gms.measurement.internal.E2 r1 = r13.f6142e
            s(r1)
            android.util.Pair r1 = r1.o(r4)
            java.lang.Object r2 = r1.second
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x01aa
            java.lang.Object r2 = r1.first
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0040
            goto L_0x01aa
        L_0x0040:
            u(r0)
            r0.l()
            com.google.android.gms.measurement.internal.X2 r0 = r0.f5730a
            android.content.Context r0 = r0.f6138a
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r2 = 0
            if (r0 == 0) goto L_0x005a
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x005a }
            goto L_0x005b
        L_0x005a:
            r0 = r2
        L_0x005b:
            if (r0 == 0) goto L_0x019b
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x019b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.google.android.gms.measurement.internal.w5 r3 = r13.J()
            r3.h()
            r3.j()
            boolean r5 = r3.y()
            if (r5 != 0) goto L_0x0079
            goto L_0x0089
        L_0x0079:
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a
            com.google.android.gms.measurement.internal.z6 r3 = r3.f6146i
            s(r3)
            int r3 = r3.W()
            r5 = 234200(0x392d8, float:3.28184E-40)
            if (r3 < r5) goto L_0x0143
        L_0x0089:
            com.google.android.gms.measurement.internal.x4 r3 = r13.f6150m
            t(r3)
            com.google.android.gms.measurement.internal.X2 r5 = r3.f5730a
            r3.h()
            com.google.android.gms.measurement.internal.w5 r3 = r5.J()
            f0.a r3 = r3.l0()
            if (r3 == 0) goto L_0x009f
            android.os.Bundle r2 = r3.f15315a
        L_0x009f:
            r3 = 1
            if (r2 != 0) goto L_0x00e3
            int r0 = r13.f6135B
            int r1 = r0 + 1
            r13.f6135B = r1
            r1 = 10
            if (r0 >= r1) goto L_0x00ad
            r10 = r3
        L_0x00ad:
            com.google.android.gms.measurement.internal.q2 r2 = r13.f6143f
            u(r2)
            if (r0 >= r1) goto L_0x00b7
            java.lang.String r0 = "Retrying."
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r0 = "Skipping."
        L_0x00b9:
            com.google.android.gms.measurement.internal.o2 r1 = r2.v()
            int r2 = r0.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = r2 + 60
            r3.<init>(r2)
            java.lang.String r2 = "Failed to retrieve DMA consent from the service, "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = " retryCount"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            int r2 = r13.f6135B
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.b(r0, r2)
            return r10
        L_0x00e3:
            r5 = 100
            com.google.android.gms.measurement.internal.E3 r6 = com.google.android.gms.measurement.internal.E3.e(r2, r5)
            java.lang.String r7 = "&gcs="
            r0.append(r7)
            java.lang.String r6 = r6.k()
            r0.append(r6)
            com.google.android.gms.measurement.internal.y r5 = com.google.android.gms.measurement.internal.C1454y.h(r2, r5)
            java.lang.String r6 = "&dma="
            r0.append(r6)
            java.lang.Boolean r6 = r5.j()
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r6 = j$.util.Objects.equals(r6, r7)
            r6 = r6 ^ r3
            r0.append(r6)
            java.lang.String r6 = r5.k()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0122
            java.lang.String r6 = "&dma_cps="
            r0.append(r6)
            java.lang.String r5 = r5.k()
            r0.append(r5)
        L_0x0122:
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.C1454y.i(r2)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r2 = j$.util.Objects.equals(r2, r5)
            r2 = r2 ^ r3
            java.lang.String r3 = "&npa="
            r0.append(r3)
            r0.append(r2)
            com.google.android.gms.measurement.internal.q2 r2 = r13.f6143f
            u(r2)
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()
            java.lang.String r3 = "Consent query parameters to Bow"
            r2.b(r3, r0)
        L_0x0143:
            com.google.android.gms.measurement.internal.z6 r2 = r13.f6146i
            s(r2)
            com.google.android.gms.measurement.internal.g2 r3 = r13.L()
            com.google.android.gms.measurement.internal.X2 r3 = r3.f5730a
            com.google.android.gms.measurement.internal.m r3 = r3.f6141d
            r3.A()
            java.lang.Object r1 = r1.first
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.gms.measurement.internal.E2 r1 = r13.f6142e
            s(r1)
            com.google.android.gms.measurement.internal.B2 r1 = r1.f5852v
            long r7 = r1.a()
            r11 = -1
            long r7 = r7 + r11
            java.lang.String r9 = r0.toString()
            r5 = r4
            r3 = 133005(0x2078d, double:6.5713E-319)
            java.net.URL r0 = r2.i0(r3, r5, r6, r7, r9)
            if (r0 == 0) goto L_0x019a
            com.google.android.gms.measurement.internal.B4 r3 = r13.f6152o
            u(r3)
            com.google.android.gms.measurement.internal.W2 r8 = new com.google.android.gms.measurement.internal.W2
            r8.<init>(r13)
            r3.l()
            N.C0722p.k(r0)
            N.C0722p.k(r8)
            com.google.android.gms.measurement.internal.X2 r1 = r3.f5730a
            com.google.android.gms.measurement.internal.T2 r1 = r1.f6144g
            u(r1)
            com.google.android.gms.measurement.internal.A4 r2 = new com.google.android.gms.measurement.internal.A4
            r6 = 0
            r7 = 0
            r4 = r5
            r5 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.w(r2)
        L_0x019a:
            return r10
        L_0x019b:
            com.google.android.gms.measurement.internal.q2 r0 = r13.f6143f
            u(r0)
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()
            java.lang.String r1 = "Network is not available for Deferred Deep Link request. Skipping"
            r0.a(r1)
            return r10
        L_0x01aa:
            com.google.android.gms.measurement.internal.q2 r0 = r13.f6143f
            u(r0)
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r1 = "ADID unavailable to retrieve Deferred Deep Link. Skipping"
            r0.a(r1)
            return r10
        L_0x01b9:
            com.google.android.gms.measurement.internal.q2 r0 = r13.f6143f
            u(r0)
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r1 = "ADID collection is disabled from Manifest. Skipping"
            r0.a(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.X2.n():boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void o(String str, int i5, Throwable th, byte[] bArr, Map map) {
        int i6;
        int i7 = i5;
        Throwable th2 = th;
        byte[] bArr2 = bArr;
        if (i7 == 200 || i7 == 204) {
            i6 = i7;
        } else {
            i6 = 304;
            if (i7 != 304) {
                i6 = i7;
                C1402q2 q2Var = this.f6143f;
                u(q2Var);
                q2Var.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i6), th2);
            }
        }
        if (th2 == null) {
            E2 e22 = this.f6142e;
            s(e22);
            e22.f5851u.b(true);
            if (bArr2 == null || bArr2.length == 0) {
                C1402q2 q2Var2 = this.f6143f;
                u(q2Var2);
                q2Var2.v().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr2));
                String optString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(optString)) {
                    C1402q2 q2Var3 = this.f6143f;
                    u(q2Var3);
                    q2Var3.v().a("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble(CampaignEx.JSON_KEY_TIMESTAMP, 0.0d);
                Bundle bundle = new Bundle();
                z6 z6Var = this.f6146i;
                s(z6Var);
                X2 x22 = z6Var.f5730a;
                if (!TextUtils.isEmpty(optString)) {
                    Context context = x22.f6138a;
                    double d5 = optDouble;
                    z6 z6Var2 = z6Var;
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle.putString("gad_source", optString4);
                        }
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.f6150m.t("auto", "_cmp", bundle);
                        s(z6Var2);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong(CampaignEx.JSON_KEY_TIMESTAMP, Double.doubleToRawLongBits(d5));
                                if (edit.commit()) {
                                    Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                    Context context2 = z6Var2.f5730a.f6138a;
                                    if (Build.VERSION.SDK_INT < 34) {
                                        context2.sendBroadcast(intent);
                                        return;
                                    } else {
                                        context2.sendBroadcast(intent, (String) null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (RuntimeException e5) {
                                C1402q2 q2Var4 = z6Var2.f5730a.f6143f;
                                u(q2Var4);
                                q2Var4.o().b("Failed to persist Deferred Deep Link. exception", e5);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                C1402q2 q2Var5 = this.f6143f;
                u(q2Var5);
                q2Var5.r().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                return;
            } catch (JSONException e6) {
                C1402q2 q2Var6 = this.f6143f;
                u(q2Var6);
                q2Var6.o().b("Failed to parse the Deferred Deep Link response. exception", e6);
                return;
            }
        }
        C1402q2 q2Var7 = this.f6143f;
        u(q2Var7);
        q2Var7.r().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i6), th2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void p(G3 g32) {
        long j5;
        T2 t22 = this.f6144g;
        u(t22);
        t22.h();
        C1371m mVar = this.f6141d;
        mVar.u();
        A a5 = new A(this);
        a5.m();
        this.f6156s = a5;
        J0 j02 = g32.f5894d;
        if (j02 == null) {
            j5 = 0;
        } else {
            j5 = j02.f4985a;
        }
        C1328g2 g2Var = new C1328g2(this, g32.f5893c, j5);
        g2Var.k();
        this.f6157t = g2Var;
        C1344i2 i2Var = new C1344i2(this);
        i2Var.k();
        this.f6154q = i2Var;
        C1446w5 w5Var = new C1446w5(this);
        w5Var.k();
        this.f6155r = w5Var;
        z6 z6Var = this.f6146i;
        z6Var.n();
        this.f6142e.n();
        this.f6157t.l();
        D4 d42 = new D4(this);
        d42.k();
        this.f6158u = d42;
        d42.l();
        C1402q2 q2Var = this.f6143f;
        u(q2Var);
        C1388o2 u5 = q2Var.u();
        mVar.A();
        u5.b("App measurement initialized, version", 133005L);
        u(q2Var);
        q2Var.u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String q5 = g2Var.q();
        s(z6Var);
        if (z6Var.P(q5, mVar.R())) {
            u(q2Var);
            q2Var.u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
        } else {
            u(q2Var);
            q2Var.u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(q5)));
        }
        u(q2Var);
        q2Var.v().a("Debug-level message logging enabled");
        int i5 = this.f6134A;
        AtomicInteger atomicInteger = this.f6136C;
        if (i5 != atomicInteger.get()) {
            u(q2Var);
            q2Var.o().c("Not all components initialized", Integer.valueOf(this.f6134A), Integer.valueOf(atomicInteger.get()));
        }
        this.f6159v = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r1.G() == false) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0254  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(com.google.android.gms.internal.measurement.J0 r14) {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.T2 r0 = r13.f6144g
            u(r0)
            r0.h()
            com.google.android.gms.measurement.internal.D4 r0 = r13.N()
            com.google.android.gms.internal.measurement.k3 r0 = r0.q()
            com.google.android.gms.internal.measurement.k3 r1 = com.google.android.gms.internal.measurement.C1141k3.CLIENT_UPLOAD_ELIGIBLE
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6295R0
            com.google.android.gms.measurement.internal.m r3 = r13.f6141d
            r4 = 0
            boolean r2 = r3.H(r4, r2)
            r5 = 0
            r6 = 1
            if (r0 != r1) goto L_0x0024
            r0 = r6
            goto L_0x0025
        L_0x0024:
            r0 = r5
        L_0x0025:
            if (r2 == 0) goto L_0x0032
            com.google.android.gms.measurement.internal.z6 r1 = r13.f6146i
            s(r1)
            boolean r1 = r1.G()
            if (r1 != 0) goto L_0x0035
        L_0x0032:
            if (r0 == 0) goto L_0x007e
            r0 = r6
        L_0x0035:
            com.google.android.gms.measurement.internal.z6 r1 = r13.f6146i
            s(r1)
            r1.h()
            android.content.IntentFilter r2 = new android.content.IntentFilter
            r2.<init>()
            java.lang.String r7 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            r2.addAction(r7)
            java.lang.String r7 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            r2.addAction(r7)
            com.google.android.gms.measurement.internal.G6 r7 = new com.google.android.gms.measurement.internal.G6
            com.google.android.gms.measurement.internal.X2 r8 = r1.f5730a
            r7.<init>(r8)
            com.google.android.gms.measurement.internal.X2 r1 = r1.f5730a
            android.content.Context r8 = r1.f6138a
            r9 = 2
            androidx.core.content.ContextCompat.registerReceiver(r8, r7, r2, r9)
            com.google.android.gms.measurement.internal.q2 r1 = r1.f6143f
            u(r1)
            com.google.android.gms.measurement.internal.o2 r1 = r1.v()
            java.lang.String r2 = "Registered app receiver"
            r1.a(r2)
            if (r0 == 0) goto L_0x007e
            com.google.android.gms.measurement.internal.D4 r0 = r13.N()
            com.google.android.gms.measurement.internal.c2 r1 = com.google.android.gms.measurement.internal.C1304d2.f6264C
            java.lang.Object r1 = r1.b(r4)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r0.o(r1)
        L_0x007e:
            com.google.android.gms.measurement.internal.E2 r0 = r13.f6142e
            s(r0)
            com.google.android.gms.measurement.internal.E3 r1 = r0.w()
            int r2 = r1.b()
            java.lang.String r7 = "google_analytics_default_allow_ad_storage"
            f0.v r7 = r3.O(r7, r5)
            java.lang.String r8 = "google_analytics_default_allow_analytics_storage"
            f0.v r8 = r3.O(r8, r5)
            f0.v r9 = f0.v.UNINITIALIZED
            r10 = 30
            r11 = -10
            if (r7 != r9) goto L_0x00a1
            if (r8 == r9) goto L_0x00af
        L_0x00a1:
            s(r0)
            boolean r12 = r0.v(r11)
            if (r12 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.E3 r2 = com.google.android.gms.measurement.internal.E3.a(r7, r8, r11)
            goto L_0x00da
        L_0x00af:
            com.google.android.gms.measurement.internal.g2 r7 = r13.L()
            java.lang.String r7 = r7.r()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00ca
            if (r2 == 0) goto L_0x00cc
            if (r2 == r10) goto L_0x00cc
            r7 = 10
            if (r2 == r7) goto L_0x00cc
            r7 = 40
            if (r2 != r7) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r2 = r4
            goto L_0x00da
        L_0x00cc:
            com.google.android.gms.measurement.internal.x4 r2 = r13.f6150m
            t(r2)
            com.google.android.gms.measurement.internal.E3 r7 = new com.google.android.gms.measurement.internal.E3
            r7.<init>(r4, r4, r11)
            r2.q0(r7, r5)
            goto L_0x00ca
        L_0x00da:
            if (r2 == 0) goto L_0x00e5
            com.google.android.gms.measurement.internal.x4 r1 = r13.f6150m
            t(r1)
            r1.q0(r2, r6)
            r1 = r2
        L_0x00e5:
            com.google.android.gms.measurement.internal.x4 r2 = r13.f6150m
            t(r2)
            r2.o(r1)
            s(r0)
            com.google.android.gms.measurement.internal.y r1 = r0.u()
            int r1 = r1.b()
            java.lang.String r7 = "google_analytics_default_allow_ad_personalization_signals"
            f0.v r7 = r3.O(r7, r6)
            if (r7 == r9) goto L_0x010e
            com.google.android.gms.measurement.internal.q2 r8 = r13.f6143f
            u(r8)
            com.google.android.gms.measurement.internal.o2 r8 = r8.w()
            java.lang.String r12 = "Default ad personalization consent from Manifest"
            r8.b(r12, r7)
        L_0x010e:
            java.lang.String r7 = "google_analytics_default_allow_ad_user_data"
            f0.v r7 = r3.O(r7, r6)
            if (r7 == r9) goto L_0x0127
            boolean r8 = com.google.android.gms.measurement.internal.E3.u(r11, r1)
            if (r8 == 0) goto L_0x0127
            t(r2)
            com.google.android.gms.measurement.internal.y r14 = com.google.android.gms.measurement.internal.C1454y.a(r7, r11)
            r2.p0(r14, r6)
            goto L_0x016f
        L_0x0127:
            com.google.android.gms.measurement.internal.g2 r7 = r13.L()
            java.lang.String r7 = r7.r()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0145
            if (r1 == 0) goto L_0x0139
            if (r1 != r10) goto L_0x0145
        L_0x0139:
            t(r2)
            com.google.android.gms.measurement.internal.y r14 = new com.google.android.gms.measurement.internal.y
            r14.<init>((java.lang.Boolean) r4, (int) r11, (java.lang.Boolean) r4, (java.lang.String) r4)
            r2.p0(r14, r6)
            goto L_0x016f
        L_0x0145:
            com.google.android.gms.measurement.internal.g2 r7 = r13.L()
            java.lang.String r7 = r7.r()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x016f
            if (r14 == 0) goto L_0x016f
            android.os.Bundle r14 = r14.f4988d
            if (r14 == 0) goto L_0x016f
            boolean r1 = com.google.android.gms.measurement.internal.E3.u(r10, r1)
            if (r1 == 0) goto L_0x016f
            com.google.android.gms.measurement.internal.y r14 = com.google.android.gms.measurement.internal.C1454y.h(r14, r10)
            boolean r1 = r14.d()
            if (r1 == 0) goto L_0x016f
            t(r2)
            r2.p0(r14, r6)
        L_0x016f:
            java.lang.String r14 = "google_analytics_tcf_data_enabled"
            java.lang.Boolean r14 = r3.J(r14)
            if (r14 == 0) goto L_0x017d
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0197
        L_0x017d:
            com.google.android.gms.measurement.internal.q2 r14 = r13.f6143f
            u(r14)
            com.google.android.gms.measurement.internal.o2 r14 = r14.v()
            java.lang.String r1 = "TCF client enabled."
            r14.a(r1)
            t(r2)
            r2.s()
            t(r2)
            r2.r()
        L_0x0197:
            s(r0)
            com.google.android.gms.measurement.internal.B2 r14 = r0.f5836f
            long r7 = r14.a()
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.q2 r1 = r13.f6143f
            u(r1)
            long r7 = r13.f6137D
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            java.lang.String r3 = "Persisting first open"
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
            r1.b(r3, r9)
            s(r0)
            r14.b(r7)
        L_0x01c0:
            t(r2)
            com.google.android.gms.measurement.internal.H6 r1 = r2.f6883r
            r1.c()
            boolean r1 = r13.m()
            if (r1 != 0) goto L_0x0254
            boolean r14 = r13.g()
            if (r14 == 0) goto L_0x03a8
            com.google.android.gms.measurement.internal.z6 r14 = r13.f6146i
            s(r14)
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r0 = r14.M(r0)
            if (r0 != 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.q2 r0 = r13.f6143f
            u(r0)
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r1 = "App is missing INTERNET permission"
            r0.a(r1)
        L_0x01ef:
            s(r14)
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r14 = r14.M(r0)
            if (r14 != 0) goto L_0x0208
            com.google.android.gms.measurement.internal.q2 r14 = r13.f6143f
            u(r14)
            com.google.android.gms.measurement.internal.o2 r14 = r14.o()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r14.a(r0)
        L_0x0208:
            android.content.Context r14 = r13.f6138a
            T.d r0 = T.e.a(r14)
            boolean r0 = r0.f()
            if (r0 != 0) goto L_0x0244
            com.google.android.gms.measurement.internal.m r0 = r13.f6141d
            boolean r0 = r0.m()
            if (r0 != 0) goto L_0x0244
            boolean r0 = com.google.android.gms.measurement.internal.z6.j0(r14)
            if (r0 != 0) goto L_0x0230
            com.google.android.gms.measurement.internal.q2 r0 = r13.f6143f
            u(r0)
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r1 = "AppMeasurementReceiver not registered/enabled"
            r0.a(r1)
        L_0x0230:
            boolean r14 = com.google.android.gms.measurement.internal.z6.E(r14, r5)
            if (r14 != 0) goto L_0x0244
            com.google.android.gms.measurement.internal.q2 r14 = r13.f6143f
            u(r14)
            com.google.android.gms.measurement.internal.o2 r14 = r14.o()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r14.a(r0)
        L_0x0244:
            com.google.android.gms.measurement.internal.q2 r14 = r13.f6143f
            u(r14)
            com.google.android.gms.measurement.internal.o2 r14 = r14.o()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r14.a(r0)
            goto L_0x03a8
        L_0x0254:
            com.google.android.gms.measurement.internal.g2 r1 = r13.L()
            java.lang.String r1 = r1.r()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02ed
            com.google.android.gms.measurement.internal.z6 r1 = r13.f6146i
            s(r1)
            com.google.android.gms.measurement.internal.g2 r3 = r13.L()
            java.lang.String r3 = r3.r()
            s(r0)
            r0.h()
            android.content.SharedPreferences r5 = r0.p()
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r5 = r5.getString(r7, r4)
            boolean r1 = r1.p(r3, r5)
            if (r1 == 0) goto L_0x02d1
            com.google.android.gms.measurement.internal.q2 r1 = r13.f6143f
            u(r1)
            com.google.android.gms.measurement.internal.o2 r1 = r1.u()
            java.lang.String r3 = "Rechecking which service to use due to a GMP App Id change"
            r1.a(r3)
            s(r0)
            r0.h()
            java.lang.Boolean r1 = r0.t()
            android.content.SharedPreferences r3 = r0.p()
            android.content.SharedPreferences$Editor r3 = r3.edit()
            r3.clear()
            r3.apply()
            if (r1 == 0) goto L_0x02b0
            r0.s(r1)
        L_0x02b0:
            com.google.android.gms.measurement.internal.i2 r1 = r13.E()
            r1.o()
            com.google.android.gms.measurement.internal.w5 r1 = r13.f6155r
            r1.A()
            com.google.android.gms.measurement.internal.w5 r1 = r13.f6155r
            r1.w()
            s(r0)
            long r8 = r13.f6137D
            r14.b(r8)
            s(r0)
            com.google.android.gms.measurement.internal.D2 r14 = r0.f5838h
            r14.b(r4)
        L_0x02d1:
            s(r0)
            com.google.android.gms.measurement.internal.g2 r14 = r13.L()
            java.lang.String r14 = r14.r()
            r0.h()
            android.content.SharedPreferences r1 = r0.p()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r7, r14)
            r1.apply()
        L_0x02ed:
            s(r0)
            com.google.android.gms.measurement.internal.E3 r14 = r0.w()
            f0.w r1 = f0.w.ANALYTICS_STORAGE
            boolean r14 = r14.o(r1)
            if (r14 != 0) goto L_0x0304
            s(r0)
            com.google.android.gms.measurement.internal.D2 r14 = r0.f5838h
            r14.b(r4)
        L_0x0304:
            t(r2)
            s(r0)
            com.google.android.gms.measurement.internal.D2 r14 = r0.f5838h
            java.lang.String r14 = r14.a()
            r2.E(r14)
            com.google.android.gms.measurement.internal.z6 r14 = r13.f6146i
            s(r14)
            com.google.android.gms.measurement.internal.X2 r14 = r14.f5730a     // Catch:{ ClassNotFoundException -> 0x0326 }
            android.content.Context r14 = r14.f6138a     // Catch:{ ClassNotFoundException -> 0x0326 }
            java.lang.ClassLoader r14 = r14.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0326 }
            java.lang.String r0 = "com.google.firebase.remoteconfig.FirebaseRemoteConfig"
            r14.loadClass(r0)     // Catch:{ ClassNotFoundException -> 0x0326 }
            goto L_0x034b
        L_0x0326:
            com.google.android.gms.measurement.internal.E2 r14 = r13.f6142e
            s(r14)
            com.google.android.gms.measurement.internal.D2 r0 = r14.f5853w
            java.lang.String r1 = r0.a()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x034b
            com.google.android.gms.measurement.internal.q2 r1 = r13.f6143f
            u(r1)
            com.google.android.gms.measurement.internal.o2 r1 = r1.r()
            java.lang.String r2 = "Remote config removed with active feature rollouts"
            r1.a(r2)
            s(r14)
            r0.b(r4)
        L_0x034b:
            com.google.android.gms.measurement.internal.g2 r14 = r13.L()
            java.lang.String r14 = r14.r()
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x03a8
            boolean r14 = r13.g()
            com.google.android.gms.measurement.internal.E2 r0 = r13.f6142e
            s(r0)
            boolean r1 = r0.z()
            if (r1 != 0) goto L_0x0378
            com.google.android.gms.measurement.internal.m r1 = r13.f6141d
            boolean r1 = r1.L()
            if (r1 != 0) goto L_0x0378
            s(r0)
            r1 = r14 ^ 1
            r0.y(r1)
        L_0x0378:
            if (r14 == 0) goto L_0x0382
            com.google.android.gms.measurement.internal.x4 r14 = r13.f6150m
            t(r14)
            r14.H()
        L_0x0382:
            com.google.android.gms.measurement.internal.N5 r14 = r13.f6145h
            t(r14)
            com.google.android.gms.measurement.internal.M5 r14 = r14.f5998e
            r14.a()
            com.google.android.gms.measurement.internal.w5 r14 = r13.J()
            java.util.concurrent.atomic.AtomicReference r1 = new java.util.concurrent.atomic.AtomicReference
            r1.<init>()
            r14.q(r1)
            com.google.android.gms.measurement.internal.w5 r14 = r13.J()
            s(r0)
            com.google.android.gms.measurement.internal.A2 r0 = r0.f5856z
            android.os.Bundle r0 = r0.a()
            r14.v(r0)
        L_0x03a8:
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.m r14 = r13.f6141d
            com.google.android.gms.measurement.internal.c2 r0 = com.google.android.gms.measurement.internal.C1304d2.f6295R0
            boolean r14 = r14.H(r4, r0)
            if (r14 == 0) goto L_0x0408
            com.google.android.gms.measurement.internal.z6 r14 = r13.f6146i
            s(r14)
            boolean r14 = r14.G()
            if (r14 == 0) goto L_0x0408
            com.google.android.gms.measurement.internal.c2 r14 = com.google.android.gms.measurement.internal.C1304d2.f6373y0
            java.lang.Object r14 = r14.b(r4)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r0 = (long) r14
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            r2 = 5000(0x1388, float:7.006E-42)
            int r14 = r14.nextInt(r2)
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            long r2 = (long) r14
            com.google.android.gms.common.util.d r14 = r13.f6148k
            long r0 = r0 + r2
            long r2 = r14.elapsedRealtime()
            long r0 = r0 - r2
            r2 = 500(0x1f4, double:2.47E-321)
            long r0 = java.lang.Math.max(r2, r0)
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x0400
            com.google.android.gms.measurement.internal.q2 r14 = r13.f6143f
            u(r14)
            com.google.android.gms.measurement.internal.o2 r14 = r14.w()
            java.lang.String r2 = "Waiting to fetch trigger URIs until some time after boot. Delay in millis"
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            r14.b(r2, r3)
        L_0x0400:
            com.google.android.gms.measurement.internal.x4 r14 = r13.f6150m
            t(r14)
            r14.s0(r0)
        L_0x0408:
            com.google.android.gms.measurement.internal.E2 r14 = r13.f6142e
            s(r14)
            com.google.android.gms.measurement.internal.z2 r14 = r14.f5846p
            r14.b(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.X2.v(com.google.android.gms.internal.measurement.J0):void");
    }

    public final C1371m w() {
        return this.f6141d;
    }

    public final E2 x() {
        E2 e22 = this.f6142e;
        s(e22);
        return e22;
    }

    public final C1402q2 y() {
        C1402q2 q2Var = this.f6143f;
        if (q2Var == null || !q2Var.k()) {
            return null;
        }
        return q2Var;
    }

    public final N5 z() {
        N5 n5 = this.f6145h;
        t(n5);
        return n5;
    }
}
