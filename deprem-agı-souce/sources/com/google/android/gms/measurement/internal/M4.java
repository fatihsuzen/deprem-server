package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.L0;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

public final class M4 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    private volatile E4 f5974c;

    /* renamed from: d  reason: collision with root package name */
    private volatile E4 f5975d;

    /* renamed from: e  reason: collision with root package name */
    protected E4 f5976e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f5977f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private L0 f5978g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f5979h;

    /* renamed from: i  reason: collision with root package name */
    private volatile E4 f5980i;

    /* renamed from: j  reason: collision with root package name */
    private E4 f5981j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5982k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f5983l = new Object();

    public M4(X2 x22) {
        super(x22);
    }

    private final void F(String str, E4 e42, boolean z4) {
        E4 e43;
        E4 e44;
        String str2;
        if (this.f5974c == null) {
            e43 = this.f5975d;
        } else {
            e43 = this.f5974c;
        }
        if (e42.f5861b == null) {
            if (str != null) {
                str2 = r(str, "Activity");
            } else {
                str2 = null;
            }
            e44 = new E4(e42.f5860a, str2, e42.f5862c, e42.f5864e, e42.f5865f);
        } else {
            e44 = e42;
        }
        this.f5975d = this.f5974c;
        this.f5974c = e44;
        X2 x22 = this.f5730a;
        x22.b().t(new G4(this, e44, e43, x22.f().elapsedRealtime(), z4));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void G(com.google.android.gms.measurement.internal.E4 r15, com.google.android.gms.measurement.internal.E4 r16, long r17, boolean r19, android.os.Bundle r20) {
        /*
            r14 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r4 = r20
            r14.h()
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x002a
            long r7 = r0.f5862c
            long r9 = r1.f5862c
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x002a
            java.lang.String r7 = r1.f5861b
            java.lang.String r8 = r0.f5861b
            boolean r7 = j$.util.Objects.equals(r7, r8)
            if (r7 == 0) goto L_0x002a
            java.lang.String r7 = r1.f5860a
            java.lang.String r8 = r0.f5860a
            boolean r7 = j$.util.Objects.equals(r7, r8)
            if (r7 != 0) goto L_0x002c
        L_0x002a:
            r7 = r6
            goto L_0x002d
        L_0x002c:
            r7 = r5
        L_0x002d:
            if (r19 == 0) goto L_0x0034
            com.google.android.gms.measurement.internal.E4 r8 = r14.f5976e
            if (r8 == 0) goto L_0x0034
            r5 = r6
        L_0x0034:
            if (r7 == 0) goto L_0x00bf
            if (r4 == 0) goto L_0x003f
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>(r4)
        L_0x003d:
            r13 = r7
            goto L_0x0045
        L_0x003f:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            goto L_0x003d
        L_0x0045:
            com.google.android.gms.measurement.internal.z6.k0(r15, r13, r6)
            if (r1 == 0) goto L_0x0063
            java.lang.String r4 = r1.f5860a
            if (r4 == 0) goto L_0x0053
            java.lang.String r7 = "_pn"
            r13.putString(r7, r4)
        L_0x0053:
            java.lang.String r4 = r1.f5861b
            if (r4 == 0) goto L_0x005c
            java.lang.String r7 = "_pc"
            r13.putString(r7, r4)
        L_0x005c:
            long r7 = r1.f5862c
            java.lang.String r1 = "_pi"
            r13.putLong(r1, r7)
        L_0x0063:
            r7 = 0
            if (r5 == 0) goto L_0x0082
            com.google.android.gms.measurement.internal.X2 r1 = r14.f5730a
            com.google.android.gms.measurement.internal.N5 r1 = r1.z()
            com.google.android.gms.measurement.internal.L5 r1 = r1.f5999f
            long r9 = r1.f5965b
            long r9 = r2 - r9
            r1.f5965b = r2
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0082
            com.google.android.gms.measurement.internal.X2 r1 = r14.f5730a
            com.google.android.gms.measurement.internal.z6 r1 = r1.C()
            r1.Z(r13, r9)
        L_0x0082:
            com.google.android.gms.measurement.internal.X2 r1 = r14.f5730a
            com.google.android.gms.measurement.internal.m r4 = r1.w()
            boolean r4 = r4.N()
            if (r4 != 0) goto L_0x0095
            java.lang.String r4 = "_mst"
            r9 = 1
            r13.putLong(r4, r9)
        L_0x0095:
            boolean r4 = r0.f5864e
            if (r6 == r4) goto L_0x009c
            java.lang.String r9 = "auto"
            goto L_0x009e
        L_0x009c:
            java.lang.String r9 = "app"
        L_0x009e:
            com.google.android.gms.common.util.d r1 = r1.f()
            long r10 = r1.currentTimeMillis()
            if (r4 == 0) goto L_0x00b3
            r19 = r7
            long r7 = r0.f5865f
            int r1 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r1 != 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r11 = r7
            goto L_0x00b4
        L_0x00b3:
            r11 = r10
        L_0x00b4:
            com.google.android.gms.measurement.internal.X2 r1 = r14.f5730a
            java.lang.String r10 = "_vs"
            com.google.android.gms.measurement.internal.x4 r8 = r1.B()
            r8.u(r9, r10, r11, r13)
        L_0x00bf:
            if (r5 == 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.E4 r1 = r14.f5976e
            r14.o(r1, r6, r2)
        L_0x00c6:
            r14.f5976e = r0
            boolean r1 = r0.f5864e
            if (r1 == 0) goto L_0x00ce
            r14.f5981j = r0
        L_0x00ce:
            com.google.android.gms.measurement.internal.X2 r1 = r14.f5730a
            com.google.android.gms.measurement.internal.w5 r1 = r1.J()
            r1.u(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.M4.G(com.google.android.gms.measurement.internal.E4, com.google.android.gms.measurement.internal.E4, long, boolean, android.os.Bundle):void");
    }

    private final void o(E4 e42, boolean z4, long j5) {
        boolean z5;
        X2 x22 = this.f5730a;
        x22.M().k(x22.f().elapsedRealtime());
        if (e42 == null || !e42.f5863d) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (x22.z().f5999f.d(z5, z4, j5) && e42 != null) {
            e42.f5863d = false;
        }
    }

    private final E4 p(L0 l02) {
        C0722p.k(l02);
        Integer valueOf = Integer.valueOf(l02.f5011a);
        Map map = this.f5977f;
        E4 e42 = (E4) map.get(valueOf);
        if (e42 == null) {
            E4 e43 = new E4((String) null, r(l02.f5012b, "Activity"), this.f5730a.C().p0());
            map.put(valueOf, e43);
            e42 = e43;
        }
        if (this.f5980i != null) {
            return this.f5980i;
        }
        return e42;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void A(Bundle bundle, E4 e42, E4 e43, long j5) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        G(e42, e43, j5, true, this.f5730a.C().t((String) null, "screen_view", bundle, (List) null, false));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void B(E4 e42, E4 e43, long j5, boolean z4, Bundle bundle) {
        G(e42, e43, j5, z4, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void C(E4 e42, boolean z4, long j5) {
        o(e42, false, j5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ E4 D() {
        return this.f5981j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void E(E4 e42) {
        this.f5981j = null;
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return false;
    }

    public final E4 q(boolean z4) {
        j();
        h();
        if (!z4) {
            return this.f5976e;
        }
        E4 e42 = this.f5976e;
        if (e42 != null) {
            return e42;
        }
        return this.f5981j;
    }

    /* access modifiers changed from: package-private */
    public final String r(String str, String str2) {
        String str3;
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length > 0) {
            str3 = split[length - 1];
        } else {
            str3 = "";
        }
        X2 x22 = this.f5730a;
        if (str3.length() > x22.w().x((String) null, false)) {
            return str3.substring(0, x22.w().x((String) null, false));
        }
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c9, code lost:
        r0 = r12.f5730a;
        r1 = r0.a().w();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        if (r3 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d5, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d8, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d9, code lost:
        if (r4 != null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00db, code lost:
        r5 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00df, code lost:
        r1.c("Logging screen view with name, class", r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e6, code lost:
        if (r12.f5974c != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e8, code lost:
        r1 = r12.f5975d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        r1 = r12.f5974c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ed, code lost:
        r2 = new com.google.android.gms.measurement.internal.E4(r3, r4, r0.C().p0(), true, r14);
        r12.f5974c = r2;
        r12.f5975d = r1;
        r12.f5980i = r2;
        r8 = r2;
        r0.b().t(new com.google.android.gms.measurement.internal.F4(r12, r13, r8, r1, r0.f().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r1 = r12.f5983l
            monitor-enter(r1)
            boolean r0 = r12.f5982k     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.X2 r13 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.t()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.a(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r0 = move-exception
            r13 = r0
            goto L_0x011b
        L_0x001c:
            java.lang.String r0 = "screen_name"
            java.lang.String r3 = r13.getString(r0)     // Catch:{ all -> 0x0018 }
            r0 = 0
            r2 = 0
            if (r3 == 0) goto L_0x0055
            int r4 = r3.length()     // Catch:{ all -> 0x0018 }
            if (r4 <= 0) goto L_0x003c
            int r4 = r3.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.X2 r5 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.m r5 = r5.w()     // Catch:{ all -> 0x0018 }
            int r5 = r5.x(r0, r2)     // Catch:{ all -> 0x0018 }
            if (r4 <= r5) goto L_0x0055
        L_0x003c:
            com.google.android.gms.measurement.internal.X2 r13 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.t()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.b(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x0055:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r13.getString(r4)     // Catch:{ all -> 0x0018 }
            if (r4 == 0) goto L_0x008c
            int r5 = r4.length()     // Catch:{ all -> 0x0018 }
            if (r5 <= 0) goto L_0x0073
            int r5 = r4.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.X2 r6 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.m r6 = r6.w()     // Catch:{ all -> 0x0018 }
            int r0 = r6.x(r0, r2)     // Catch:{ all -> 0x0018 }
            if (r5 <= r0) goto L_0x008c
        L_0x0073:
            com.google.android.gms.measurement.internal.X2 r13 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.t()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r4.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.b(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x008c:
            if (r4 != 0) goto L_0x009d
            com.google.android.gms.internal.measurement.L0 r0 = r12.f5978g     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = r0.f5012b     // Catch:{ all -> 0x0018 }
            java.lang.String r4 = "Activity"
            java.lang.String r4 = r12.r(r0, r4)     // Catch:{ all -> 0x0018 }
            goto L_0x009d
        L_0x009b:
            java.lang.String r4 = "Activity"
        L_0x009d:
            com.google.android.gms.measurement.internal.E4 r0 = r12.f5974c     // Catch:{ all -> 0x0018 }
            boolean r5 = r12.f5979h     // Catch:{ all -> 0x0018 }
            if (r5 == 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c8
            r12.f5979h = r2     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = r0.f5861b     // Catch:{ all -> 0x0018 }
            boolean r2 = j$.util.Objects.equals(r2, r4)     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.f5860a     // Catch:{ all -> 0x0018 }
            boolean r0 = j$.util.Objects.equals(r0, r3)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00c8
            com.google.android.gms.measurement.internal.X2 r13 = r12.f5730a     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.q2 r13 = r13.a()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.o2 r13 = r13.t()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.a(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            return
        L_0x00c8:
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.X2 r0 = r12.f5730a
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            if (r3 != 0) goto L_0x00d8
            java.lang.String r2 = "null"
            goto L_0x00d9
        L_0x00d8:
            r2 = r3
        L_0x00d9:
            if (r4 != 0) goto L_0x00de
            java.lang.String r5 = "null"
            goto L_0x00df
        L_0x00de:
            r5 = r4
        L_0x00df:
            java.lang.String r6 = "Logging screen view with name, class"
            r1.c(r6, r2, r5)
            com.google.android.gms.measurement.internal.E4 r1 = r12.f5974c
            if (r1 != 0) goto L_0x00eb
            com.google.android.gms.measurement.internal.E4 r1 = r12.f5975d
            goto L_0x00ed
        L_0x00eb:
            com.google.android.gms.measurement.internal.E4 r1 = r12.f5974c
        L_0x00ed:
            com.google.android.gms.measurement.internal.E4 r2 = new com.google.android.gms.measurement.internal.E4
            com.google.android.gms.measurement.internal.z6 r5 = r0.C()
            long r5 = r5.p0()
            r7 = 1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.f5974c = r2
            r12.f5975d = r1
            r12.f5980i = r2
            com.google.android.gms.common.util.d r14 = r0.f()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.T2 r14 = r0.b()
            com.google.android.gms.measurement.internal.F4 r5 = new com.google.android.gms.measurement.internal.F4
            r6 = r12
            r7 = r13
            r9 = r1
            r8 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            r14.t(r5)
            return
        L_0x011b:
            monitor-exit(r1)     // Catch:{ all -> 0x0018 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.M4.s(android.os.Bundle, long):void");
    }

    public final void t(L0 l02, String str, String str2) {
        String str3;
        X2 x22 = this.f5730a;
        if (!x22.w().N()) {
            x22.a().t().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        E4 e42 = this.f5974c;
        if (e42 == null) {
            x22.a().t().a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map = this.f5977f;
        Integer valueOf = Integer.valueOf(l02.f5011a);
        if (map.get(valueOf) == null) {
            x22.a().t().a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = r(l02.f5012b, "Activity");
        }
        String str4 = e42.f5861b;
        String str5 = e42.f5860a;
        boolean equals = Objects.equals(str4, str2);
        boolean equals2 = Objects.equals(str5, str);
        if (equals && equals2) {
            x22.a().t().a("setCurrentScreen cannot be called with the same class and name");
        } else if (str != null && (str.length() <= 0 || str.length() > x22.w().x((String) null, false))) {
            x22.a().t().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
        } else if (str2 == null || (str2.length() > 0 && str2.length() <= x22.w().x((String) null, false))) {
            C1388o2 w4 = x22.a().w();
            if (str == null) {
                str3 = "null";
            } else {
                str3 = str;
            }
            w4.c("Setting current screen to name, class", str3, str2);
            E4 e43 = new E4(str, str2, x22.C().p0());
            map.put(valueOf, e43);
            F(l02.f5012b, e43, true);
        } else {
            x22.a().t().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
        }
    }

    public final E4 u() {
        return this.f5974c;
    }

    public final void v(L0 l02, Bundle bundle) {
        Bundle bundle2;
        if (this.f5730a.w().N() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f5977f.put(Integer.valueOf(l02.f5011a), new E4(bundle2.getString(RewardPlus.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void w(com.google.android.gms.internal.measurement.L0 r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f5983l
            monitor-enter(r0)
            r1 = 1
            r4.f5982k = r1     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.measurement.L0 r1 = r4.f5978g     // Catch:{ all -> 0x0031 }
            boolean r1 = j$.util.Objects.equals(r5, r1)     // Catch:{ all -> 0x0031 }
            r2 = 0
            if (r1 != 0) goto L_0x0036
            monitor-enter(r0)     // Catch:{ all -> 0x0031 }
            r4.f5978g = r5     // Catch:{ all -> 0x0033 }
            r4.f5979h = r2     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            com.google.android.gms.measurement.internal.X2 r1 = r4.f5730a     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.m r3 = r1.w()     // Catch:{ all -> 0x0031 }
            boolean r3 = r3.N()     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x0036
            r3 = 0
            r4.f5980i = r3     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.T2 r1 = r1.b()     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.L4 r3 = new com.google.android.gms.measurement.internal.L4     // Catch:{ all -> 0x0031 }
            r3.<init>(r4)     // Catch:{ all -> 0x0031 }
            r1.t(r3)     // Catch:{ all -> 0x0031 }
            goto L_0x0036
        L_0x0031:
            r5 = move-exception
            goto L_0x007a
        L_0x0033:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.X2 r0 = r4.f5730a
            com.google.android.gms.measurement.internal.m r1 = r0.w()
            boolean r1 = r1.N()
            if (r1 != 0) goto L_0x0054
            com.google.android.gms.measurement.internal.E4 r5 = r4.f5980i
            r4.f5974c = r5
            com.google.android.gms.measurement.internal.T2 r5 = r0.b()
            com.google.android.gms.measurement.internal.H4 r0 = new com.google.android.gms.measurement.internal.H4
            r0.<init>(r4)
            r5.t(r0)
            return
        L_0x0054:
            com.google.android.gms.measurement.internal.E4 r0 = r4.p(r5)
            java.lang.String r5 = r5.f5012b
            r4.F(r5, r0, r2)
            com.google.android.gms.measurement.internal.X2 r5 = r4.f5730a
            com.google.android.gms.measurement.internal.C0 r5 = r5.M()
            com.google.android.gms.measurement.internal.X2 r0 = r5.f5730a
            com.google.android.gms.common.util.d r1 = r0.f()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.T2 r0 = r0.b()
            com.google.android.gms.measurement.internal.b0 r3 = new com.google.android.gms.measurement.internal.b0
            r3.<init>(r5, r1)
            r0.t(r3)
            return
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.M4.w(com.google.android.gms.internal.measurement.L0):void");
    }

    public final void x(L0 l02) {
        synchronized (this.f5983l) {
            this.f5982k = false;
            this.f5979h = true;
        }
        X2 x22 = this.f5730a;
        long elapsedRealtime = x22.f().elapsedRealtime();
        if (!x22.w().N()) {
            this.f5974c = null;
            x22.b().t(new I4(this, elapsedRealtime));
            return;
        }
        E4 p5 = p(l02);
        this.f5975d = this.f5974c;
        this.f5974c = null;
        x22.b().t(new J4(this, p5, elapsedRealtime));
    }

    public final void y(L0 l02, Bundle bundle) {
        E4 e42;
        if (this.f5730a.w().N() && bundle != null && (e42 = (E4) this.f5977f.get(Integer.valueOf(l02.f5011a))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", e42.f5862c);
            bundle2.putString(RewardPlus.NAME, e42.f5860a);
            bundle2.putString("referrer_name", e42.f5861b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void z(L0 l02) {
        synchronized (this.f5983l) {
            try {
                if (Objects.equals(this.f5978g, l02)) {
                    this.f5978g = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (this.f5730a.w().N()) {
            this.f5977f.remove(Integer.valueOf(l02.f5011a));
        }
    }
}
