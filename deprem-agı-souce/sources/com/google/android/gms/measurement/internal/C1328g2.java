package com.google.android.gms.measurement.internal;

import N.C0722p;
import f0.w;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.measurement.internal.g2  reason: case insensitive filesystem */
public final class C1328g2 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    private String f6425c;

    /* renamed from: d  reason: collision with root package name */
    private String f6426d;

    /* renamed from: e  reason: collision with root package name */
    private int f6427e;

    /* renamed from: f  reason: collision with root package name */
    private String f6428f;

    /* renamed from: g  reason: collision with root package name */
    private String f6429g;

    /* renamed from: h  reason: collision with root package name */
    private long f6430h;

    /* renamed from: i  reason: collision with root package name */
    private final long f6431i;

    /* renamed from: j  reason: collision with root package name */
    private final long f6432j;

    /* renamed from: k  reason: collision with root package name */
    private List f6433k;

    /* renamed from: l  reason: collision with root package name */
    private String f6434l;

    /* renamed from: m  reason: collision with root package name */
    private int f6435m;

    /* renamed from: n  reason: collision with root package name */
    private String f6436n;

    /* renamed from: o  reason: collision with root package name */
    private String f6437o;

    /* renamed from: p  reason: collision with root package name */
    private long f6438p = 0;

    /* renamed from: q  reason: collision with root package name */
    private String f6439q = null;

    C1328g2(X2 x22, long j5, long j6) {
        super(x22);
        this.f6431i = j5;
        this.f6432j = j6;
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0181 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0182 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0187 A[Catch:{ IllegalStateException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.X2 r0 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            long r2 = r11.f6432j
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            long r3 = r11.f6431i
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "sdkVersion bundled with app, dynamiteVersion"
            r1.c(r4, r2, r3)
            android.content.Context r1 = r0.e()
            java.lang.String r1 = r1.getPackageName()
            android.content.Context r2 = r0.e()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            r3 = 0
            java.lang.String r4 = ""
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r6 = "Unknown"
            java.lang.String r7 = "unknown"
            if (r2 != 0) goto L_0x004a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r1)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r0.b(r9, r8)
        L_0x0047:
            r8 = r6
            goto L_0x00b1
        L_0x004a:
            java.lang.String r7 = r2.getInstallerPackageName(r1)     // Catch:{ IllegalArgumentException -> 0x004f }
            goto L_0x0062
        L_0x004f:
            com.google.android.gms.measurement.internal.X2 r0 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C1402q2.x(r1)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r0.b(r9, r8)
        L_0x0062:
            if (r7 != 0) goto L_0x0068
            java.lang.String r0 = "manual_install"
            r7 = r0
            goto L_0x0071
        L_0x0068:
            java.lang.String r0 = "com.android.vending"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0071
            r7 = r4
        L_0x0071:
            com.google.android.gms.measurement.internal.X2 r0 = r11.f5730a     // Catch:{ NameNotFoundException -> 0x009b }
            android.content.Context r0 = r0.e()     // Catch:{ NameNotFoundException -> 0x009b }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x009b }
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x009b }
            if (r0 == 0) goto L_0x0047
            android.content.pm.ApplicationInfo r8 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x009b }
            java.lang.CharSequence r8 = r2.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x009b }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x009b }
            if (r9 != 0) goto L_0x0092
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x009b }
            goto L_0x0093
        L_0x0092:
            r8 = r6
        L_0x0093:
            java.lang.String r6 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0098 }
            int r5 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x0098 }
            goto L_0x00b1
        L_0x0098:
            r0 = r6
            r6 = r8
            goto L_0x009c
        L_0x009b:
            r0 = r6
        L_0x009c:
            com.google.android.gms.measurement.internal.X2 r8 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r8 = r8.a()
            com.google.android.gms.measurement.internal.o2 r8 = r8.o()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C1402q2.x(r1)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.c(r10, r9, r6)
            r8 = r6
            r6 = r0
        L_0x00b1:
            r11.f6425c = r1
            r11.f6428f = r7
            r11.f6426d = r6
            r11.f6427e = r5
            r11.f6429g = r8
            r5 = 0
            r11.f6430h = r5
            com.google.android.gms.measurement.internal.X2 r0 = r11.f5730a
            int r5 = r0.h()
            if (r5 == 0) goto L_0x0157
            r6 = 1
            if (r5 == r6) goto L_0x0147
            r6 = 3
            if (r5 == r6) goto L_0x0137
            r6 = 4
            if (r5 == r6) goto L_0x0127
            r6 = 6
            if (r5 == r6) goto L_0x0117
            r6 = 7
            if (r5 == r6) goto L_0x0107
            r6 = 8
            if (r5 == r6) goto L_0x00f7
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r7 = r6.a()
            com.google.android.gms.measurement.internal.o2 r7 = r7.u()
            java.lang.String r8 = "App measurement disabled"
            r7.a(r8)
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.p()
            java.lang.String r7 = "Invalid scion state in identity"
            r6.a(r7)
            goto L_0x0166
        L_0x00f7:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            r6.a(r7)
            goto L_0x0166
        L_0x0107:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            r6.a(r7)
            goto L_0x0166
        L_0x0117:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.t()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.a(r7)
            goto L_0x0166
        L_0x0127:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the manifest"
            r6.a(r7)
            goto L_0x0166
        L_0x0137:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.a(r7)
            goto L_0x0166
        L_0x0147:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.u()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            r6.a(r7)
            goto L_0x0166
        L_0x0157:
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r6 = r6.a()
            com.google.android.gms.measurement.internal.o2 r6 = r6.w()
            java.lang.String r7 = "App measurement collection enabled"
            r6.a(r7)
        L_0x0166:
            r11.f6436n = r4
            com.google.android.gms.measurement.internal.X2 r6 = r11.f5730a
            r6.c()
            android.content.Context r7 = r6.e()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r0 = r0.H()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r8 = "google_app_id"
            java.lang.String r0 = f0.C1644L.a(r7, r8, r0)     // Catch:{ IllegalStateException -> 0x0199 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x0199 }
            if (r7 == 0) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r4 = r0
        L_0x0183:
            r11.f6436n = r4     // Catch:{ IllegalStateException -> 0x0199 }
            if (r5 != 0) goto L_0x01ad
            com.google.android.gms.measurement.internal.q2 r0 = r6.a()     // Catch:{ IllegalStateException -> 0x0199 }
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.f6425c     // Catch:{ IllegalStateException -> 0x0199 }
            java.lang.String r6 = r11.f6436n     // Catch:{ IllegalStateException -> 0x0199 }
            r0.c(r4, r5, r6)     // Catch:{ IllegalStateException -> 0x0199 }
            goto L_0x01ad
        L_0x0199:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r4 = r11.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.C1402q2.x(r1)
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            r4.c(r5, r1, r0)
        L_0x01ad:
            r0 = 0
            r11.f6433k = r0
            com.google.android.gms.measurement.internal.X2 r0 = r11.f5730a
            r0.c()
            com.google.android.gms.measurement.internal.m r1 = r0.w()
            java.lang.String r4 = "analytics.safelisted_events"
            java.util.List r1 = r1.K(r4)
            if (r1 != 0) goto L_0x01c2
            goto L_0x01f3
        L_0x01c2:
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.t()
            java.lang.String r4 = "Safelisted event list is empty. Ignoring"
            r1.a(r4)
            goto L_0x01f5
        L_0x01d6:
            java.util.Iterator r4 = r1.iterator()
        L_0x01da:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01f3
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.measurement.internal.z6 r6 = r0.C()
            java.lang.String r7 = "safelisted event"
            boolean r5 = r6.u0(r7, r5)
            if (r5 != 0) goto L_0x01da
            goto L_0x01f5
        L_0x01f3:
            r11.f6433k = r1
        L_0x01f5:
            if (r2 == 0) goto L_0x0202
            android.content.Context r0 = r0.e()
            boolean r0 = T.b.a(r0)
            r11.f6435m = r0
            return
        L_0x0202:
            r11.f6435m = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1328g2.n():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x027d A[SYNTHETIC, Splitter:B:89:0x027d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.B6 o(java.lang.String r50) {
        /*
            r49 = this;
            r1 = r49
            r1.h()
            com.google.android.gms.measurement.internal.B6 r2 = new com.google.android.gms.measurement.internal.B6
            java.lang.String r3 = r1.q()
            java.lang.String r4 = r1.r()
            r1.j()
            java.lang.String r5 = r1.f6426d
            r1.j()
            int r0 = r1.f6427e
            long r6 = (long) r0
            r1.j()
            java.lang.String r0 = r1.f6428f
            N.C0722p.k(r0)
            java.lang.String r8 = r1.f6428f
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.m r9 = r0.w()
            r9.A()
            r1.j()
            r1.h()
            long r9 = r1.f6430h
            r11 = 0
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r14 = 0
            if (r13 != 0) goto L_0x00dd
            com.google.android.gms.measurement.internal.X2 r9 = r1.f5730a
            com.google.android.gms.measurement.internal.z6 r9 = r9.C()
            android.content.Context r10 = r0.e()
            android.content.Context r0 = r0.e()
            java.lang.String r0 = r0.getPackageName()
            r9.h()
            N.C0722p.k(r10)
            N.C0722p.e(r0)
            android.content.pm.PackageManager r13 = r10.getPackageManager()
            java.security.MessageDigest r15 = com.google.android.gms.measurement.internal.z6.C()
            r16 = -1
            if (r15 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.X2 r0 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.a(r9)
            r18 = r11
        L_0x0074:
            r9 = r16
            goto L_0x00d9
        L_0x0077:
            if (r13 == 0) goto L_0x00d6
            boolean r0 = r9.S(r10, r0)     // Catch:{ NameNotFoundException -> 0x00bb }
            if (r0 != 0) goto L_0x00bf
            T.d r0 = T.e.a(r10)     // Catch:{ NameNotFoundException -> 0x00bb }
            com.google.android.gms.measurement.internal.X2 r10 = r9.f5730a     // Catch:{ NameNotFoundException -> 0x00bb }
            android.content.Context r13 = r10.e()     // Catch:{ NameNotFoundException -> 0x00bb }
            java.lang.String r13 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bb }
            r18 = r11
            r11 = 64
            android.content.pm.PackageInfo r0 = r0.e(r13, r11)     // Catch:{ NameNotFoundException -> 0x00ab }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00ab }
            if (r0 == 0) goto L_0x00ad
            int r11 = r0.length     // Catch:{ NameNotFoundException -> 0x00ab }
            if (r11 <= 0) goto L_0x00ad
            r0 = r0[r14]     // Catch:{ NameNotFoundException -> 0x00ab }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00ab }
            byte[] r0 = r15.digest(r0)     // Catch:{ NameNotFoundException -> 0x00ab }
            long r16 = com.google.android.gms.measurement.internal.z6.D(r0)     // Catch:{ NameNotFoundException -> 0x00ab }
            goto L_0x0074
        L_0x00ab:
            r0 = move-exception
            goto L_0x00c4
        L_0x00ad:
            com.google.android.gms.measurement.internal.q2 r0 = r10.a()     // Catch:{ NameNotFoundException -> 0x00ab }
            com.google.android.gms.measurement.internal.o2 r0 = r0.r()     // Catch:{ NameNotFoundException -> 0x00ab }
            java.lang.String r10 = "Could not get signatures"
            r0.a(r10)     // Catch:{ NameNotFoundException -> 0x00ab }
            goto L_0x0074
        L_0x00bb:
            r0 = move-exception
            r18 = r11
            goto L_0x00c4
        L_0x00bf:
            r18 = r11
            r16 = r18
            goto L_0x0074
        L_0x00c4:
            com.google.android.gms.measurement.internal.X2 r9 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r9 = r9.a()
            com.google.android.gms.measurement.internal.o2 r9 = r9.o()
            java.lang.String r10 = "Package name not found"
            r9.b(r10, r0)
        L_0x00d3:
            r9 = r18
            goto L_0x00d9
        L_0x00d6:
            r18 = r11
            goto L_0x00d3
        L_0x00d9:
            r1.f6430h = r9
        L_0x00db:
            r11 = r9
            goto L_0x00e0
        L_0x00dd:
            r18 = r11
            goto L_0x00db
        L_0x00e0:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            boolean r9 = r0.g()
            com.google.android.gms.measurement.internal.E2 r10 = r0.x()
            boolean r10 = r10.f5849s
            r13 = 1
            r15 = r10 ^ 1
            r1.h()
            boolean r10 = r0.g()
            r16 = r14
            r14 = 0
            if (r10 != 0) goto L_0x0100
        L_0x00fb:
            r21 = r2
            r13 = r14
            goto L_0x0186
        L_0x0100:
            com.google.android.gms.internal.measurement.J7.a()
            com.google.android.gms.measurement.internal.m r10 = r0.w()
            com.google.android.gms.measurement.internal.c2 r13 = com.google.android.gms.measurement.internal.C1304d2.f6277I0
            boolean r10 = r10.H(r14, r13)
            if (r10 == 0) goto L_0x011f
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r10 = "Disabled IID for tests."
            r0.a(r10)
            goto L_0x00fb
        L_0x011f:
            android.content.Context r0 = r0.e()     // Catch:{ ClassNotFoundException -> 0x0183 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0183 }
            java.lang.String r10 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r0 = r0.loadClass(r10)     // Catch:{ ClassNotFoundException -> 0x0183 }
            if (r0 != 0) goto L_0x0130
            goto L_0x00fb
        L_0x0130:
            java.lang.String r10 = "getInstance"
            r13 = 1
            java.lang.Class[] r14 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x0171 }
            java.lang.Class<android.content.Context> r13 = android.content.Context.class
            r14[r16] = r13     // Catch:{ Exception -> 0x0171 }
            java.lang.reflect.Method r10 = r0.getDeclaredMethod(r10, r14)     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.measurement.internal.X2 r13 = r1.f5730a     // Catch:{ Exception -> 0x0171 }
            android.content.Context r13 = r13.e()     // Catch:{ Exception -> 0x0171 }
            r21 = r2
            r14 = 1
            java.lang.Object[] r2 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0173 }
            r2[r16] = r13     // Catch:{ Exception -> 0x0173 }
            r13 = 0
            java.lang.Object r2 = r10.invoke(r13, r2)     // Catch:{ Exception -> 0x0173 }
            if (r2 != 0) goto L_0x0152
            goto L_0x0186
        L_0x0152:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r10, r13)     // Catch:{ Exception -> 0x0160 }
            java.lang.Object r0 = r0.invoke(r2, r13)     // Catch:{ Exception -> 0x0160 }
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x0160 }
            goto L_0x0186
        L_0x0160:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.t()
            java.lang.String r2 = "Failed to retrieve Firebase Instance Id"
            r0.a(r2)
        L_0x016f:
            r13 = 0
            goto L_0x0186
        L_0x0171:
            r21 = r2
        L_0x0173:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.s()
            java.lang.String r2 = "Failed to obtain Firebase Analytics instance"
            r0.a(r2)
            goto L_0x016f
        L_0x0183:
            r21 = r2
            goto L_0x016f
        L_0x0186:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.E2 r2 = r0.x()
            com.google.android.gms.measurement.internal.B2 r2 = r2.f5836f
            r10 = r3
            long r2 = r2.a()
            int r14 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r14 != 0) goto L_0x019d
            long r2 = r0.f6137D
            r14 = r4
            r22 = r5
            goto L_0x01a6
        L_0x019d:
            r14 = r4
            r22 = r5
            long r4 = r0.f6137D
            long r2 = java.lang.Math.min(r4, r2)
        L_0x01a6:
            r1.j()
            int r0 = r1.f6435m
            com.google.android.gms.measurement.internal.X2 r4 = r1.f5730a
            com.google.android.gms.measurement.internal.m r5 = r4.w()
            boolean r5 = r5.M()
            com.google.android.gms.measurement.internal.E2 r23 = r4.x()
            r23.h()
            r24 = r0
            android.content.SharedPreferences r0 = r23.p()
            r25 = r2
            java.lang.String r2 = "deferred_analytics_collection"
            r3 = r16
            boolean r0 = r0.getBoolean(r2, r3)
            com.google.android.gms.measurement.internal.m r2 = r4.w()
            java.lang.String r3 = "google_analytics_default_allow_ad_personalization_signals"
            r23 = r0
            r0 = 1
            f0.v r2 = r2.O(r3, r0)
            f0.v r0 = f0.v.GRANTED
            if (r2 == r0) goto L_0x01e2
            r0 = 1
        L_0x01de:
            r2 = r4
            r27 = r5
            goto L_0x01e4
        L_0x01e2:
            r0 = 0
            goto L_0x01de
        L_0x01e4:
            long r4 = r1.f6431i
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r28 = r0
            java.util.List r0 = r1.f6433k
            com.google.android.gms.measurement.internal.E2 r29 = r2.x()
            com.google.android.gms.measurement.internal.E3 r29 = r29.w()
            java.lang.String r29 = r29.l()
            r30 = r0
            java.lang.String r0 = r1.f6434l
            if (r0 != 0) goto L_0x020a
            com.google.android.gms.measurement.internal.z6 r0 = r2.C()
            java.lang.String r0 = r0.l0()
            r1.f6434l = r0
        L_0x020a:
            java.lang.String r0 = r1.f6434l
            com.google.android.gms.measurement.internal.E2 r31 = r2.x()
            r32 = r0
            com.google.android.gms.measurement.internal.E3 r0 = r31.w()
            r31 = r2
            f0.w r2 = f0.w.ANALYTICS_STORAGE
            boolean r0 = r0.o(r2)
            if (r0 != 0) goto L_0x0224
            r33 = r4
            r0 = 0
            goto L_0x0259
        L_0x0224:
            r1.h()
            r33 = r4
            long r4 = r1.f6438p
            int r0 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x0230
            goto L_0x0250
        L_0x0230:
            com.google.android.gms.common.util.d r0 = r31.f()
            long r4 = r0.currentTimeMillis()
            r35 = r4
            long r4 = r1.f6438p
            long r4 = r35 - r4
            java.lang.String r0 = r1.f6437o
            if (r0 == 0) goto L_0x0250
            r35 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r4 > r35 ? 1 : (r4 == r35 ? 0 : -1))
            if (r0 <= 0) goto L_0x0250
            java.lang.String r0 = r1.f6439q
            if (r0 != 0) goto L_0x0250
            r1.p()
        L_0x0250:
            java.lang.String r0 = r1.f6437o
            if (r0 != 0) goto L_0x0257
            r1.p()
        L_0x0257:
            java.lang.String r0 = r1.f6437o
        L_0x0259:
            com.google.android.gms.measurement.internal.m r2 = r31.w()
            boolean r2 = r2.P()
            com.google.android.gms.measurement.internal.z6 r4 = r31.C()
            java.lang.String r5 = r1.q()
            r31 = r0
            com.google.android.gms.measurement.internal.X2 r0 = r4.f5730a
            android.content.Context r35 = r0.e()
            android.content.pm.PackageManager r35 = r35.getPackageManager()
            if (r35 != 0) goto L_0x027d
            r35 = r2
            r4 = r18
            r2 = 0
            goto L_0x02aa
        L_0x027d:
            android.content.Context r0 = r0.e()     // Catch:{ NameNotFoundException -> 0x0293 }
            T.d r0 = T.e.a(r0)     // Catch:{ NameNotFoundException -> 0x0293 }
            r35 = r2
            r2 = 0
            android.content.pm.ApplicationInfo r0 = r0.c(r5, r2)     // Catch:{ NameNotFoundException -> 0x0296 }
            if (r0 == 0) goto L_0x0291
            int r0 = r0.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x0296 }
            goto L_0x02a9
        L_0x0291:
            r0 = r2
            goto L_0x02a9
        L_0x0293:
            r35 = r2
            r2 = 0
        L_0x0296:
            com.google.android.gms.measurement.internal.X2 r0 = r4.f5730a
            r0.c()
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.u()
            java.lang.String r4 = "PackageManager failed to find running app: app_id"
            r0.b(r4, r5)
            goto L_0x0291
        L_0x02a9:
            long r4 = (long) r0
        L_0x02aa:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.E2 r16 = r0.x()
            com.google.android.gms.measurement.internal.E3 r16 = r16.w()
            int r16 = r16.b()
            com.google.android.gms.measurement.internal.E2 r36 = r0.x()
            com.google.android.gms.measurement.internal.y r36 = r36.u()
            java.lang.String r36 = r36.e()
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.m r2 = r0.w()
            r38 = r0
            com.google.android.gms.measurement.internal.c2 r0 = com.google.android.gms.measurement.internal.C1304d2.f6295R0
            r39 = r4
            r4 = 0
            boolean r2 = r2.H(r4, r0)
            if (r2 == 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.z6 r2 = r38.C()
            int r2 = r2.I()
            goto L_0x02e2
        L_0x02e1:
            r2 = 0
        L_0x02e2:
            com.google.android.gms.internal.measurement.C1145k7.a()
            com.google.android.gms.measurement.internal.m r5 = r38.w()
            boolean r0 = r5.H(r4, r0)
            if (r0 == 0) goto L_0x02f9
            com.google.android.gms.measurement.internal.z6 r0 = r38.C()
            long r4 = r0.J()
            r18 = r4
        L_0x02f9:
            com.google.android.gms.measurement.internal.m r0 = r38.w()
            java.lang.String r37 = r0.R()
            com.google.android.gms.measurement.internal.m r0 = r38.w()
            r4 = 1
            f0.v r0 = r0.O(r3, r4)
            com.google.android.gms.measurement.internal.d1 r3 = new com.google.android.gms.measurement.internal.d1
            r3.<init>(r0)
            java.lang.String r38 = r3.b()
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            long r3 = r0.f6137D
            com.google.android.gms.measurement.internal.D4 r0 = r0.N()
            com.google.android.gms.internal.measurement.k3 r0 = r0.q()
            int r41 = r0.A()
            r5 = r22
            r22 = r28
            r28 = r31
            r42 = r33
            r34 = r2
            r2 = r21
            r21 = r23
            r33 = r36
            r44 = r14
            r14 = r9
            r45 = r3
            r3 = r10
            r4 = r44
            r47 = r18
            r19 = r24
            r17 = r25
            r26 = r29
            r25 = r30
            r23 = r42
            r29 = r35
            r30 = r39
            r39 = r45
            r35 = r47
            r9 = 133005(0x2078d, double:6.5713E-319)
            r20 = r27
            r27 = r32
            r32 = r16
            r16 = r13
            r13 = r50
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (int) r19, (boolean) r20, (boolean) r21, (java.lang.Boolean) r22, (long) r23, (java.util.List) r25, (java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (boolean) r29, (long) r30, (int) r32, (java.lang.String) r33, (int) r34, (long) r35, (java.lang.String) r37, (java.lang.String) r38, (long) r39, (int) r41)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1328g2.o(java.lang.String):com.google.android.gms.measurement.internal.B6");
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        String str;
        String str2;
        h();
        X2 x22 = this.f5730a;
        if (!x22.x().w().o(w.ANALYTICS_STORAGE)) {
            x22.a().v().a("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            x22.C().q0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        C1388o2 v5 = x22.a().v();
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        v5.a(String.format("Resetting session stitching token to %s", new Object[]{str2}));
        this.f6437o = str;
        this.f6438p = x22.f().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final String q() {
        j();
        C0722p.k(this.f6425c);
        return this.f6425c;
    }

    /* access modifiers changed from: package-private */
    public final String r() {
        h();
        j();
        C0722p.k(this.f6436n);
        return this.f6436n;
    }

    /* access modifiers changed from: package-private */
    public final String s() {
        j();
        C0722p.k(this.f6429g);
        return this.f6429g;
    }

    /* access modifiers changed from: package-private */
    public final int t() {
        j();
        return this.f6427e;
    }

    /* access modifiers changed from: package-private */
    public final long u() {
        return this.f6432j;
    }

    /* access modifiers changed from: package-private */
    public final int v() {
        j();
        return this.f6435m;
    }

    /* access modifiers changed from: package-private */
    public final List w() {
        return this.f6433k;
    }

    /* access modifiers changed from: package-private */
    public final boolean x(String str) {
        String str2 = this.f6439q;
        boolean z4 = false;
        if (str2 != null && !str2.equals(str)) {
            z4 = true;
        }
        this.f6439q = str;
        return z4;
    }
}
