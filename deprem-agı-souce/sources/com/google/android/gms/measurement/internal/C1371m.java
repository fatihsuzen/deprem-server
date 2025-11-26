package com.google.android.gms.measurement.internal;

import N.C0722p;
import T.e;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.n;
import f0.v;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.gms.measurement.internal.m  reason: case insensitive filesystem */
public final class C1371m extends A3 {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f6538b;

    /* renamed from: c  reason: collision with root package name */
    private String f6539c;

    /* renamed from: d  reason: collision with root package name */
    private C1364l f6540d = C1357k.f6512a;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f6541e;

    C1371m(X2 x22) {
        super(x22);
    }

    public static final long n() {
        return ((Long) C1304d2.f6324e.b((Object) null)).longValue();
    }

    public static final int o() {
        return Math.max(0, ((Integer) C1304d2.f6339j.b((Object) null)).intValue());
    }

    public static final long p() {
        return (long) ((Integer) C1304d2.f6345l.b((Object) null)).intValue();
    }

    public static final long q() {
        return ((Long) C1304d2.f6296S.b((Object) null)).longValue();
    }

    public static final long r() {
        return ((Long) C1304d2.f6286N.b((Object) null)).longValue();
    }

    private final String s(String str, String str2) {
        try {
            Class<String> cls = String.class;
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, ""});
            C0722p.k(str3);
            return str3;
        } catch (ClassNotFoundException e5) {
            this.f5730a.a().o().b("Could not find SystemProperties class", e5);
            return "";
        } catch (NoSuchMethodException e6) {
            this.f5730a.a().o().b("Could not find SystemProperties.get() method", e6);
            return "";
        } catch (IllegalAccessException e7) {
            this.f5730a.a().o().b("Could not access SystemProperties.get()", e7);
            return "";
        } catch (InvocationTargetException e8) {
            this.f5730a.a().o().b("SystemProperties.get() threw an exception", e8);
            return "";
        }
    }

    public final long A() {
        this.f5730a.c();
        return 133005;
    }

    public final boolean B() {
        if (this.f6541e == null) {
            synchronized (this) {
                try {
                    if (this.f6541e == null) {
                        X2 x22 = this.f5730a;
                        ApplicationInfo applicationInfo = x22.e().getApplicationInfo();
                        String a5 = n.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z4 = false;
                            if (str != null && str.equals(a5)) {
                                z4 = true;
                            }
                            this.f6541e = Boolean.valueOf(z4);
                        }
                        if (this.f6541e == null) {
                            this.f6541e = Boolean.TRUE;
                            x22.a().o().a("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f6541e.booleanValue();
    }

    public final String C(String str, C1296c2 c2Var) {
        if (TextUtils.isEmpty(str)) {
            return (String) c2Var.b((Object) null);
        }
        return (String) c2Var.b(this.f6540d.d(str, c2Var.a()));
    }

    public final long D(String str, C1296c2 c2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) c2Var.b((Object) null)).longValue();
        }
        String d5 = this.f6540d.d(str, c2Var.a());
        if (TextUtils.isEmpty(d5)) {
            return ((Long) c2Var.b((Object) null)).longValue();
        }
        try {
            return ((Long) c2Var.b(Long.valueOf(Long.parseLong(d5)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) c2Var.b((Object) null)).longValue();
        }
    }

    public final int E(String str, C1296c2 c2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) c2Var.b((Object) null)).intValue();
        }
        String d5 = this.f6540d.d(str, c2Var.a());
        if (TextUtils.isEmpty(d5)) {
            return ((Integer) c2Var.b((Object) null)).intValue();
        }
        try {
            return ((Integer) c2Var.b(Integer.valueOf(Integer.parseInt(d5)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) c2Var.b((Object) null)).intValue();
        }
    }

    public final int F(String str, C1296c2 c2Var, int i5, int i6) {
        return Math.max(Math.min(E(str, c2Var), i6), i5);
    }

    public final double G(String str, C1296c2 c2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) c2Var.b((Object) null)).doubleValue();
        }
        String d5 = this.f6540d.d(str, c2Var.a());
        if (TextUtils.isEmpty(d5)) {
            return ((Double) c2Var.b((Object) null)).doubleValue();
        }
        try {
            return ((Double) c2Var.b(Double.valueOf(Double.parseDouble(d5)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) c2Var.b((Object) null)).doubleValue();
        }
    }

    public final boolean H(String str, C1296c2 c2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) c2Var.b((Object) null)).booleanValue();
        }
        String d5 = this.f6540d.d(str, c2Var.a());
        if (TextUtils.isEmpty(d5)) {
            return ((Boolean) c2Var.b((Object) null)).booleanValue();
        }
        return ((Boolean) c2Var.b(Boolean.valueOf("1".equals(d5)))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Bundle I() {
        try {
            X2 x22 = this.f5730a;
            if (x22.e().getPackageManager() == null) {
                x22.a().o().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c5 = e.a(x22.e()).c(x22.e().getPackageName(), 128);
            if (c5 != null) {
                return c5.metaData;
            }
            x22.a().o().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            this.f5730a.a().o().b("Failed to load metadata: Package name not found", e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean J(String str) {
        C0722p.e(str);
        Bundle I4 = I();
        if (I4 == null) {
            this.f5730a.a().o().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!I4.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(I4.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List K(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            N.C0722p.e(r4)
            android.os.Bundle r0 = r3.I()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.X2 r4 = r3.f5730a
            com.google.android.gms.measurement.internal.q2 r4 = r4.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.o()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.X2 r0 = r3.f5730a     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.e()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.X2 r0 = r3.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.o()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1371m.K(java.lang.String):java.util.List");
    }

    public final boolean L() {
        this.f5730a.c();
        Boolean J4 = J("firebase_analytics_collection_deactivated");
        if (J4 == null || !J4.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean M() {
        Boolean J4 = J("google_analytics_adid_collection_enabled");
        if (J4 == null || J4.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean N() {
        Boolean J4 = J("google_analytics_automatic_screen_reporting_enabled");
        if (J4 == null || J4.booleanValue()) {
            return true;
        }
        return false;
    }

    public final v O(String str, boolean z4) {
        Object obj;
        C0722p.e(str);
        X2 x22 = this.f5730a;
        Bundle I4 = I();
        if (I4 == null) {
            x22.a().o().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = I4.get(str);
        }
        if (obj == null) {
            return v.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return v.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return v.DENIED;
        }
        if (z4 && "eu_consent_policy".equals(obj)) {
            return v.POLICY;
        }
        x22.a().r().b("Invalid manifest metadata for", str);
        return v.UNINITIALIZED;
    }

    public final boolean P() {
        Boolean J4 = J("google_analytics_sgtm_upload_enabled");
        if (J4 == null) {
            return false;
        }
        return J4.booleanValue();
    }

    public final void Q(String str) {
        this.f6539c = str;
    }

    public final String R() {
        return this.f6539c;
    }

    public final String i() {
        return s("debug.firebase.analytics.app", "");
    }

    public final String j() {
        return s("debug.deferred.deeplink", "");
    }

    public final boolean k(String str) {
        return "1".equals(this.f6540d.d(str, "gaia_collection_enabled"));
    }

    public final boolean l(String str) {
        return "1".equals(this.f6540d.d(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        if (this.f6538b == null) {
            Boolean J4 = J("app_measurement_lite");
            this.f6538b = J4;
            if (J4 == null) {
                this.f6538b = Boolean.FALSE;
            }
        }
        if (this.f6538b.booleanValue() || !this.f5730a.G()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void t(C1364l lVar) {
        this.f6540d = lVar;
    }

    /* access modifiers changed from: package-private */
    public final String u() {
        this.f5730a.c();
        return "FA";
    }

    public final int v() {
        if (this.f5730a.C().V(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int w(String str) {
        return F(str, C1304d2.f6308Y, 25, 100);
    }

    /* access modifiers changed from: package-private */
    public final int x(String str, boolean z4) {
        if (z4) {
            return F(str, C1304d2.f6337i0, 100, 500);
        }
        return 500;
    }

    /* access modifiers changed from: package-private */
    public final int y(String str, boolean z4) {
        return Math.max(x(str, z4), 256);
    }

    /* access modifiers changed from: package-private */
    public final int z(String str) {
        return F(str, C1304d2.f6306X, 500, 2000);
    }
}
