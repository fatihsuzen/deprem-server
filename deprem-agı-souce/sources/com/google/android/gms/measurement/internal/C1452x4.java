package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C1145k7;
import com.google.android.gms.internal.measurement.C1187p4;
import com.google.android.gms.internal.measurement.C1196q4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.C1633A;
import f0.C1634B;
import f0.C1637E;
import f0.C1638F;
import f0.C1639G;
import f0.C1642J;
import f0.C1644L;
import f0.u;
import f0.w;
import j$.util.Comparator$CC;
import j$.util.Objects;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import m0.i;
import m0.j;
import m0.k;
import m0.z;
import n0.C1720b;
import n0.C1722d;

/* renamed from: com.google.android.gms.measurement.internal.x4  reason: case insensitive filesystem */
public final class C1452x4 extends C1320f2 {

    /* renamed from: c  reason: collision with root package name */
    protected C1369l4 f6868c;

    /* renamed from: d  reason: collision with root package name */
    private C1633A f6869d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f6870e = new CopyOnWriteArraySet();

    /* renamed from: f  reason: collision with root package name */
    private boolean f6871f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f6872g = new AtomicReference();

    /* renamed from: h  reason: collision with root package name */
    private final Object f6873h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private boolean f6874i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f6875j = 1;

    /* renamed from: k  reason: collision with root package name */
    private C1447x f6876k;

    /* renamed from: l  reason: collision with root package name */
    private C1447x f6877l;

    /* renamed from: m  reason: collision with root package name */
    private PriorityQueue f6878m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f6879n;

    /* renamed from: o  reason: collision with root package name */
    private E3 f6880o = E3.f5857c;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicLong f6881p = new AtomicLong(0);

    /* renamed from: q  reason: collision with root package name */
    private long f6882q = -1;

    /* renamed from: r  reason: collision with root package name */
    final H6 f6883r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f6884s = true;

    /* renamed from: t  reason: collision with root package name */
    private C1447x f6885t;

    /* renamed from: u  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f6886u;

    /* renamed from: v  reason: collision with root package name */
    private C1447x f6887v;

    /* renamed from: w  reason: collision with root package name */
    private final y6 f6888w = new C1290b4(this);

    protected C1452x4(X2 x22) {
        super(x22);
        this.f6883r = new H6(x22);
    }

    private final C1642J e0(X5 x5) {
        try {
            URL url = new URI(x5.f6170c).toURL();
            AtomicReference atomicReference = new AtomicReference();
            String s5 = this.f5730a.L().s();
            X2 x22 = this.f5730a;
            C1388o2 w4 = x22.a().w();
            Long valueOf = Long.valueOf(x5.f6168a);
            w4.d("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, x5.f6170c, Integer.valueOf(x5.f6169b.length));
            if (!TextUtils.isEmpty(x5.f6174g)) {
                x22.a().w().c("[sgtm] Uploading data from app. row_id", valueOf, x5.f6174g);
            }
            HashMap hashMap = new HashMap();
            Bundle bundle = x5.f6171d;
            for (String next : bundle.keySet()) {
                String string = bundle.getString(next);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(next, string);
                }
            }
            B4 F4 = x22.F();
            byte[] bArr = x5.f6169b;
            C1376m4 m4Var = new C1376m4(this, atomicReference, x5);
            F4.l();
            C0722p.k(url);
            C0722p.k(bArr);
            C0722p.k(m4Var);
            F4.f5730a.b().w(new A4(F4, s5, url, bArr, hashMap, m4Var));
            try {
                X2 x23 = x22.C().f5730a;
                long currentTimeMillis = x23.f().currentTimeMillis();
                long j5 = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
                long j6 = currentTimeMillis + ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
                synchronized (atomicReference) {
                    while (atomicReference.get() == null && j5 > 0) {
                        atomicReference.wait(j5);
                        j5 = j6 - x23.f().currentTimeMillis();
                    }
                }
            } catch (InterruptedException unused) {
                this.f5730a.a().r().a("[sgtm] Interrupted waiting for uploading batch");
            } catch (Throwable th) {
                throw th;
            }
            if (atomicReference.get() == null) {
                return C1642J.UNKNOWN;
            }
            return (C1642J) atomicReference.get();
        } catch (MalformedURLException | URISyntaxException e5) {
            this.f5730a.a().o().d("[sgtm] Bad upload url for row_id", x5.f6170c, Long.valueOf(x5.f6168a), e5);
            return C1642J.FAILURE;
        }
    }

    private final void f0(Boolean bool, boolean z4) {
        h();
        j();
        X2 x22 = this.f5730a;
        x22.a().v().b("Setting app measurement enabled (FE)", bool);
        x22.x().s(bool);
        if (z4) {
            E2 x4 = x22.x();
            X2 x23 = x4.f5730a;
            x4.h();
            SharedPreferences.Editor edit = x4.p().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.f5730a.j() || (bool != null && !bool.booleanValue())) {
            Y();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g0 */
    public final void Y() {
        C1452x4 x4Var;
        long j5;
        h();
        X2 x22 = this.f5730a;
        String a5 = x22.x().f5844n.a();
        if (a5 == null) {
            x4Var = this;
        } else if ("unset".equals(a5)) {
            x4Var = this;
            x4Var.B(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", (Object) null, x22.f().currentTimeMillis());
        } else {
            if (true != "true".equals(a5)) {
                j5 = 0;
            } else {
                j5 = 1;
            }
            B(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", Long.valueOf(j5), x22.f().currentTimeMillis());
            x4Var = this;
        }
        if (!x4Var.f5730a.g() || !x4Var.f6884s) {
            x22.a().v().a("Updating Scion state (FE)");
            x4Var.f5730a.J().X();
            return;
        }
        x22.a().v().a("Recording app launch after enabling measurement for the first time (FE)");
        H();
        x4Var.f5730a.z().f5998e.a();
        x22.b().t(new N3(this));
    }

    /* access modifiers changed from: package-private */
    public final void A(String str, String str2, long j5, Object obj) {
        this.f5730a.b().t(new S3(this, str, str2, obj, j5));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) {
        /*
            r9 = this;
            N.C0722p.e(r10)
            N.C0722p.e(r11)
            r9.h()
            r9.j()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0074
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0053
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            r12 = 1
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r12 == r11) goto L_0x0037
            r11 = 0
            goto L_0x0038
        L_0x0037:
            r11 = r2
        L_0x0038:
            com.google.android.gms.measurement.internal.X2 r4 = r9.f5730a
            java.lang.Long r12 = java.lang.Long.valueOf(r11)
            com.google.android.gms.measurement.internal.E2 r11 = r4.x()
            com.google.android.gms.measurement.internal.D2 r11 = r11.f5844n
            long r4 = r12.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r11.b(r0)
        L_0x0051:
            r11 = r1
            goto L_0x0063
        L_0x0053:
            if (r12 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.X2 r11 = r9.f5730a
            com.google.android.gms.measurement.internal.E2 r11 = r11.x()
            com.google.android.gms.measurement.internal.D2 r11 = r11.f5844n
            java.lang.String r0 = "unset"
            r11.b(r0)
            goto L_0x0051
        L_0x0063:
            com.google.android.gms.measurement.internal.X2 r0 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.w()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.c(r1, r2, r12)
        L_0x0074:
            r4 = r11
            r7 = r12
            com.google.android.gms.measurement.internal.X2 r11 = r9.f5730a
            boolean r12 = r11.g()
            if (r12 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.X2 r10 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r10 = r10.a()
            com.google.android.gms.measurement.internal.o2 r10 = r10.w()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.a(r11)
            return
        L_0x008e:
            boolean r11 = r11.m()
            if (r11 != 0) goto L_0x0095
            return
        L_0x0095:
            com.google.android.gms.measurement.internal.X2 r11 = r9.f5730a
            com.google.android.gms.measurement.internal.v6 r3 = new com.google.android.gms.measurement.internal.v6
            r8 = r10
            r5 = r13
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.w5 r10 = r11.J()
            r10.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1452x4.B(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final Map C(String str, String str2, boolean z4) {
        X2 x22 = this.f5730a;
        if (x22.b().p()) {
            x22.a().o().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        x22.c();
        if (C1317f.a()) {
            x22.a().o().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        T2 b5 = this.f5730a.b();
        boolean z5 = z4;
        AtomicReference atomicReference2 = atomicReference;
        Z3 z32 = new Z3(this, atomicReference2, (String) null, str, str2, z5);
        AtomicReference atomicReference3 = atomicReference2;
        b5.u(atomicReference3, 5000, "get user properties", z32);
        List<v6> list = (List) atomicReference3.get();
        if (list == null) {
            x22.a().o().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z5));
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (v6 v6Var : list) {
            Object c5 = v6Var.c();
            if (c5 != null) {
                arrayMap.put(v6Var.f6788b, c5);
            }
        }
        return arrayMap;
    }

    public final String D() {
        return (String) this.f6872g.get();
    }

    /* access modifiers changed from: package-private */
    public final void E(String str) {
        this.f6872g.set(str);
    }

    public final void F() {
        h();
        X2 x22 = this.f5730a;
        if (!x22.x().f5851u.a()) {
            long a5 = x22.x().f5852v.a();
            x22.x().f5852v.b(1 + a5);
            x22.w();
            if (a5 >= 5) {
                x22.a().r().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                x22.x().f5851u.b(true);
                return;
            }
            if (this.f6885t == null) {
                this.f6885t = new U3(this, this.f5730a);
            }
            this.f6885t.b(0);
            return;
        }
        x22.a().v().a("Deferred Deep Link already retrieved. Not fetching again.");
    }

    public final void G(long j5) {
        this.f6872g.set((Object) null);
        this.f5730a.b().t(new V3(this, j5));
    }

    public final void H() {
        h();
        j();
        if (this.f5730a.m()) {
            X2 x22 = this.f5730a;
            C1371m w4 = x22.w();
            w4.f5730a.c();
            Boolean J4 = w4.J("google_analytics_deferred_deep_link_enabled");
            if (J4 != null && J4.booleanValue()) {
                x22.a().v().a("Deferred Deep Link feature enabled.");
                x22.b().t(new C1438v4(this));
            }
            this.f5730a.J().s();
            this.f6884s = false;
            E2 x4 = x22.x();
            x4.h();
            String string = x4.p().getString("previous_os_version", (String) null);
            x4.f5730a.K().l();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = x4.p().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                x22.K().l();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    t("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void I(C1633A a5) {
        C1633A a6;
        boolean z4;
        h();
        j();
        if (!(a5 == null || a5 == (a6 = this.f6869d))) {
            if (a6 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0722p.o(z4, "EventInterceptor already set.");
        }
        this.f6869d = a5;
    }

    public final void J(C1634B b5) {
        j();
        C0722p.k(b5);
        if (!this.f6870e.add(b5)) {
            this.f5730a.a().r().a("OnEventListener already registered");
        }
    }

    public final void K(C1634B b5) {
        j();
        C0722p.k(b5);
        if (!this.f6870e.remove(b5)) {
            this.f5730a.a().r().a("OnEventListener had not been registered");
        }
    }

    public final int L(String str) {
        C0722p.e(str);
        this.f5730a.w();
        return 25;
    }

    public final void M(Bundle bundle) {
        N(bundle, this.f5730a.f().currentTimeMillis());
    }

    public final void N(Bundle bundle, long j5) {
        C0722p.k(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(MBridgeConstans.APP_ID))) {
            this.f5730a.a().r().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(MBridgeConstans.APP_ID);
        C0722p.k(bundle2);
        Class<String> cls = String.class;
        u.b(bundle2, MBridgeConstans.APP_ID, cls, (Object) null);
        u.b(bundle2, TtmlNode.ATTR_TTS_ORIGIN, cls, (Object) null);
        u.b(bundle2, RewardPlus.NAME, cls, (Object) null);
        u.b(bundle2, "value", Object.class, (Object) null);
        u.b(bundle2, "trigger_event_name", cls, (Object) null);
        Class<Long> cls2 = Long.class;
        u.b(bundle2, "trigger_timeout", cls2, 0L);
        u.b(bundle2, "timed_out_event_name", cls, (Object) null);
        Class<Bundle> cls3 = Bundle.class;
        u.b(bundle2, "timed_out_event_params", cls3, (Object) null);
        u.b(bundle2, "triggered_event_name", cls, (Object) null);
        u.b(bundle2, "triggered_event_params", cls3, (Object) null);
        u.b(bundle2, "time_to_live", cls2, 0L);
        u.b(bundle2, "expired_event_name", cls, (Object) null);
        u.b(bundle2, "expired_event_params", cls3, (Object) null);
        C0722p.e(bundle2.getString(RewardPlus.NAME));
        C0722p.e(bundle2.getString(TtmlNode.ATTR_TTS_ORIGIN));
        C0722p.k(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j5);
        String string = bundle2.getString(RewardPlus.NAME);
        Object obj = bundle2.get("value");
        X2 x22 = this.f5730a;
        if (x22.C().y0(string) != 0) {
            x22.a().o().b("Invalid conditional user property name", x22.D().c(string));
        } else if (x22.C().y(string, obj) == 0) {
            Object z4 = x22.C().z(string, obj);
            if (z4 == null) {
                x22.a().o().c("Unable to normalize conditional user property value", x22.D().c(string), obj);
                return;
            }
            u.a(bundle2, z4);
            long j6 = bundle2.getLong("trigger_timeout");
            if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
                x22.w();
                if (j6 > 15552000000L || j6 < 1) {
                    x22.a().o().c("Invalid conditional user property timeout", x22.D().c(string), Long.valueOf(j6));
                    return;
                }
            }
            long j7 = bundle2.getLong("time_to_live");
            x22.w();
            if (j7 > 15552000000L || j7 < 1) {
                x22.a().o().c("Invalid conditional user property time to live", x22.D().c(string), Long.valueOf(j7));
            } else {
                x22.b().t(new W3(this, bundle2));
            }
        } else {
            x22.a().o().c("Invalid conditional user property value", x22.D().c(string), obj);
        }
    }

    public final void O(String str, String str2, Bundle bundle) {
        X2 x22 = this.f5730a;
        long currentTimeMillis = x22.f().currentTimeMillis();
        C0722p.e(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(RewardPlus.NAME, str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        x22.b().t(new X3(this, bundle2));
    }

    public final ArrayList P(String str, String str2) {
        X2 x22 = this.f5730a;
        if (x22.b().p()) {
            x22.a().o().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        x22.c();
        if (C1317f.a()) {
            x22.a().o().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        T2 b5 = this.f5730a.b();
        AtomicReference atomicReference2 = atomicReference;
        Y3 y32 = new Y3(this, atomicReference2, (String) null, str, str2);
        AtomicReference atomicReference3 = atomicReference2;
        b5.u(atomicReference3, 5000, "get conditional user properties", y32);
        List list = (List) atomicReference3.get();
        if (list != null) {
            return z6.h0(list);
        }
        x22.a().o().b("Timed out waiting for get conditional user properties", (Object) null);
        return new ArrayList();
    }

    public final String Q() {
        E4 u5 = this.f5730a.I().u();
        if (u5 != null) {
            return u5.f5860a;
        }
        return null;
    }

    public final String R() {
        E4 u5 = this.f5730a.I().u();
        if (u5 != null) {
            return u5.f5861b;
        }
        return null;
    }

    public final String S() {
        try {
            return C1644L.a(this.f5730a.e(), "google_app_id", this.f5730a.H());
        } catch (IllegalStateException e5) {
            this.f5730a.a().o().b("getGoogleAppId failed with exception", e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void T(SharedPreferences sharedPreferences, String str) {
        X2 x22 = this.f5730a;
        if (!x22.w().H((String) null, C1304d2.f6314a1)) {
            if (Objects.equals(str, "IABTCF_TCString")) {
                x22.a().w().a("IABTCF_TCString change picked up in listener.");
                ((C1447x) C0722p.k(this.f6887v)).b(500);
            }
        } else if (Objects.equals(str, "IABTCF_TCString") || Objects.equals(str, "IABTCF_gdprApplies") || Objects.equals(str, "IABTCF_EnableAdvertiserConsentMode")) {
            x22.a().w().a("IABTCF_TCString change picked up in listener.");
            ((C1447x) C0722p.k(this.f6887v)).b(500);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void U(Bundle bundle) {
        Bundle bundle2;
        int i5;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            X2 x22 = this.f5730a;
            bundle2 = new Bundle(x22.x().f5856z.a());
            Iterator<String> it = bundle.keySet().iterator();
            while (true) {
                i5 = 0;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    if (x22.C().B0(obj)) {
                        x22.C().B(this.f6888w, (String) null, 27, (String) null, (String) null, 0);
                    }
                    x22.a().t().c("Invalid default event parameter type. Name, value", next, obj);
                } else if (z6.N(next)) {
                    x22.a().t().b("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (x22.C().C0("param", next, x22.w().x((String) null, false), obj)) {
                    x22.C().A(bundle2, next, obj);
                }
            }
            x22.C();
            int v5 = x22.w().v();
            if (bundle2.size() > v5) {
                for (String str : new TreeSet(bundle2.keySet())) {
                    i5++;
                    if (i5 > v5) {
                        bundle2.remove(str);
                    }
                }
                x22.C().B(this.f6888w, (String) null, 26, (String) null, (String) null, 0);
                x22.a().t().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        X2 x23 = this.f5730a;
        x23.x().f5856z.b(bundle2);
        if (!bundle.isEmpty() || x23.w().H((String) null, C1304d2.f6307X0)) {
            this.f5730a.J().v(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void V(int i5) {
        if (this.f6876k == null) {
            this.f6876k = new L3(this, this.f5730a);
        }
        this.f6876k.b(((long) i5) * 1000);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void W(Boolean bool, boolean z4) {
        f0(bool, true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void X(E3 e32, long j5, boolean z4, boolean z5) {
        h();
        j();
        X2 x22 = this.f5730a;
        E3 w4 = x22.x().w();
        if (j5 > this.f6882q || !E3.u(w4.b(), e32.b())) {
            E2 x4 = x22.x();
            X2 x23 = x4.f5730a;
            x4.h();
            int b5 = e32.b();
            if (x4.v(b5)) {
                X2 x24 = this.f5730a;
                SharedPreferences.Editor edit = x4.p().edit();
                edit.putString("consent_settings", e32.l());
                edit.putInt("consent_source", b5);
                edit.apply();
                x22.a().w().b("Setting storage consent(FE)", e32);
                this.f6882q = j5;
                if (x24.J().D()) {
                    x24.J().Z(z4);
                } else {
                    x24.J().Y(z4);
                }
                if (z5) {
                    x24.J().q(new AtomicReference());
                    return;
                }
                return;
            }
            x22.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(e32.b()));
            return;
        }
        x22.a().u().b("Dropped out-of-date consent setting, proposed settings", e32);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void Z(boolean z4) {
        this.f6874i = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int a0() {
        return this.f6875j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b0(int i5) {
        this.f6875j = i5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1447x c0() {
        return this.f6885t;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int d0(Throwable th) {
        String message = th.getMessage();
        this.f6879n = false;
        if (message == null) {
            return 2;
        }
        if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            if (!message.contains("Background")) {
                return 1;
            }
            this.f6879n = true;
            return 1;
        } else if (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) {
            return 2;
        } else {
            return 3;
        }
    }

    public final void h0() {
        X2 x22 = this.f5730a;
        if ((x22.e().getApplicationContext() instanceof Application) && this.f6868c != null) {
            ((Application) x22.e().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f6868c);
        }
    }

    public final Boolean i0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.f5730a.b().u(atomicReference, 15000, "boolean test flag value", new T3(this, atomicReference));
    }

    public final String j0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.f5730a.b().u(atomicReference, 15000, "String test flag value", new C1298c4(this, atomicReference));
    }

    public final Long k0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.f5730a.b().u(atomicReference, 15000, "long test flag value", new C1306d4(this, atomicReference));
    }

    public final Integer l0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.f5730a.b().u(atomicReference, 15000, "int test flag value", new C1314e4(this, atomicReference));
    }

    /* access modifiers changed from: protected */
    public final boolean m() {
        return false;
    }

    public final Double m0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.f5730a.b().u(atomicReference, 15000, "double test flag value", new C1322f4(this, atomicReference));
    }

    public final void n0(Boolean bool) {
        j();
        this.f5730a.b().t(new C1330g4(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void o(E3 e32) {
        boolean z4;
        Boolean bool;
        h();
        if ((!e32.o(w.ANALYTICS_STORAGE) || !e32.o(w.AD_STORAGE)) && !this.f5730a.J().C()) {
            z4 = false;
        } else {
            z4 = true;
        }
        X2 x22 = this.f5730a;
        if (z4 != x22.j()) {
            x22.i(z4);
            E2 x4 = this.f5730a.x();
            X2 x23 = x4.f5730a;
            x4.h();
            if (x4.p().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(x4.p().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z4 || bool == null || bool.booleanValue()) {
                f0(Boolean.valueOf(z4), false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Boolean} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o0(android.os.Bundle r9, int r10, long r11) {
        /*
            r8 = this;
            r8.j()
            com.google.android.gms.measurement.internal.E3 r0 = com.google.android.gms.measurement.internal.E3.f5857c
            com.google.android.gms.measurement.internal.D3 r0 = com.google.android.gms.measurement.internal.D3.STORAGE
            f0.w[] r0 = r0.b()
            int r1 = r0.length
            r2 = 0
        L_0x000d:
            r3 = 0
            if (r2 >= r1) goto L_0x003c
            r4 = r0[r2]
            java.lang.String r4 = r4.f15331a
            boolean r5 = r9.containsKey(r4)
            if (r5 == 0) goto L_0x0039
            java.lang.String r4 = r9.getString(r4)
            if (r4 == 0) goto L_0x0039
            java.lang.String r5 = "granted"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x002b
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            goto L_0x0035
        L_0x002b:
            java.lang.String r5 = "denied"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x0035
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
        L_0x0035:
            if (r3 != 0) goto L_0x0039
            r3 = r4
            goto L_0x003c
        L_0x0039:
            int r2 = r2 + 1
            goto L_0x000d
        L_0x003c:
            if (r3 == 0) goto L_0x005a
            com.google.android.gms.measurement.internal.X2 r0 = r8.f5730a
            com.google.android.gms.measurement.internal.q2 r1 = r0.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.t()
            java.lang.String r2 = "Ignoring invalid consent setting"
            r1.b(r2, r3)
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.t()
            java.lang.String r1 = "Valid consent values are 'granted', 'denied'"
            r0.a(r1)
        L_0x005a:
            com.google.android.gms.measurement.internal.X2 r0 = r8.f5730a
            com.google.android.gms.measurement.internal.T2 r0 = r0.b()
            boolean r0 = r0.p()
            com.google.android.gms.measurement.internal.E3 r1 = com.google.android.gms.measurement.internal.E3.e(r9, r10)
            boolean r2 = r1.c()
            if (r2 == 0) goto L_0x0071
            r8.q0(r1, r0)
        L_0x0071:
            com.google.android.gms.measurement.internal.y r1 = com.google.android.gms.measurement.internal.C1454y.h(r9, r10)
            boolean r2 = r1.d()
            if (r2 == 0) goto L_0x007e
            r8.p0(r1, r0)
        L_0x007e:
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.C1454y.i(r9)
            if (r9 == 0) goto L_0x00aa
            r1 = -30
            if (r10 != r1) goto L_0x008c
            java.lang.String r10 = "tcf"
        L_0x008a:
            r2 = r10
            goto L_0x008f
        L_0x008c:
            java.lang.String r10 = "app"
            goto L_0x008a
        L_0x008f:
            if (r0 == 0) goto L_0x009d
            java.lang.String r4 = r9.toString()
            java.lang.String r3 = "allow_personalized_ads"
            r1 = r8
            r5 = r11
            r1.B(r2, r3, r4, r5)
            return
        L_0x009d:
            r5 = r11
            java.lang.String r4 = r9.toString()
            java.lang.String r3 = "allow_personalized_ads"
            r6 = r5
            r5 = 0
            r1 = r8
            r1.z(r2, r3, r4, r5, r6)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1452x4.o0(android.os.Bundle, int, long):void");
    }

    public final void p(String str, String str2, Bundle bundle) {
        q(str, str2, bundle, true, true, this.f5730a.f().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void p0(C1454y yVar, boolean z4) {
        C1338h4 h4Var = new C1338h4(this, yVar);
        if (z4) {
            h();
            h4Var.run();
            return;
        }
        this.f5730a.b().t(h4Var);
    }

    public final void q(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j5) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, "screen_view")) {
            this.f5730a.I().s(bundle2, j5);
            return;
        }
        long j6 = j5;
        boolean z6 = true;
        if (z5 && this.f6869d != null && !z6.N(str2)) {
            z6 = false;
        }
        boolean z7 = z6;
        if (str == null) {
            str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        }
        x(str, str2, j6, bundle2, z5, z7, z4, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (r4 != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r9.f5730a.a().u().b("Ignoring lower-priority consent settings, proposed settings", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        r6 = r9.f6881p.getAndIncrement();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r3 == false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r9.f6872g.set((java.lang.Object) null);
        r4 = r9;
        r3 = new com.google.android.gms.measurement.internal.C1346i4(r4, r5, r6, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        if (r11 == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        h();
        r3.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        r4.f5730a.b().v(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
        r4 = r9;
        r3 = new com.google.android.gms.measurement.internal.C1354j4(r4, r5, r6, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        if (r11 == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a9, code lost:
        h();
        r3.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b2, code lost:
        if (r0 == 30) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b4, code lost:
        if (r0 != -10) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
        r4.f5730a.b().t(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c1, code lost:
        r4.f5730a.b().v(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ca, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q0(com.google.android.gms.measurement.internal.E3 r10, boolean r11) {
        /*
            r9 = this;
            r9.j()
            int r0 = r10.b()
            r1 = -10
            if (r0 == r1) goto L_0x002a
            f0.v r2 = r10.p()
            f0.v r3 = f0.v.UNINITIALIZED
            if (r2 != r3) goto L_0x002a
            f0.v r2 = r10.q()
            if (r2 == r3) goto L_0x001a
            goto L_0x002a
        L_0x001a:
            com.google.android.gms.measurement.internal.X2 r10 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r10 = r10.a()
            com.google.android.gms.measurement.internal.o2 r10 = r10.t()
            java.lang.String r11 = "Ignoring empty consent settings"
            r10.a(r11)
            return
        L_0x002a:
            java.lang.Object r2 = r9.f6873h
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.E3 r3 = r9.f6880o     // Catch:{ all -> 0x00cb }
            int r3 = r3.b()     // Catch:{ all -> 0x00cb }
            boolean r3 = com.google.android.gms.measurement.internal.E3.u(r0, r3)     // Catch:{ all -> 0x00cb }
            r4 = 0
            if (r3 == 0) goto L_0x0064
            com.google.android.gms.measurement.internal.E3 r3 = r9.f6880o     // Catch:{ all -> 0x0053 }
            boolean r3 = r10.r(r3)     // Catch:{ all -> 0x0053 }
            f0.w r5 = f0.w.ANALYTICS_STORAGE     // Catch:{ all -> 0x0053 }
            boolean r6 = r10.o(r5)     // Catch:{ all -> 0x0053 }
            r7 = 1
            if (r6 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.E3 r6 = r9.f6880o     // Catch:{ all -> 0x0053 }
            boolean r5 = r6.o(r5)     // Catch:{ all -> 0x0053 }
            if (r5 != 0) goto L_0x0058
            r4 = r7
            goto L_0x0058
        L_0x0053:
            r0 = move-exception
            r10 = r0
            r4 = r9
            goto L_0x00ce
        L_0x0058:
            com.google.android.gms.measurement.internal.E3 r5 = r9.f6880o     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.E3 r10 = r10.t(r5)     // Catch:{ all -> 0x0053 }
            r9.f6880o = r10     // Catch:{ all -> 0x0053 }
            r8 = r4
            r4 = r7
        L_0x0062:
            r5 = r10
            goto L_0x0067
        L_0x0064:
            r3 = r4
            r8 = r3
            goto L_0x0062
        L_0x0067:
            monitor-exit(r2)     // Catch:{ all -> 0x00cb }
            if (r4 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.X2 r10 = r9.f5730a
            com.google.android.gms.measurement.internal.q2 r10 = r10.a()
            com.google.android.gms.measurement.internal.o2 r10 = r10.u()
            java.lang.String r11 = "Ignoring lower-priority consent settings, proposed settings"
            r10.b(r11, r5)
            return
        L_0x007a:
            java.util.concurrent.atomic.AtomicLong r10 = r9.f6881p
            long r6 = r10.getAndIncrement()
            if (r3 == 0) goto L_0x00a1
            java.util.concurrent.atomic.AtomicReference r10 = r9.f6872g
            r0 = 0
            r10.set(r0)
            com.google.android.gms.measurement.internal.i4 r3 = new com.google.android.gms.measurement.internal.i4
            r4 = r9
            r3.<init>(r4, r5, r6, r8)
            if (r11 == 0) goto L_0x0097
            r9.h()
            r3.run()
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.X2 r10 = r4.f5730a
            com.google.android.gms.measurement.internal.T2 r10 = r10.b()
            r10.v(r3)
            return
        L_0x00a1:
            r4 = r9
            com.google.android.gms.measurement.internal.j4 r3 = new com.google.android.gms.measurement.internal.j4
            r3.<init>(r4, r5, r6, r8)
            if (r11 == 0) goto L_0x00b0
            r9.h()
            r3.run()
            return
        L_0x00b0:
            r10 = 30
            if (r0 == r10) goto L_0x00c1
            if (r0 != r1) goto L_0x00b7
            goto L_0x00c1
        L_0x00b7:
            com.google.android.gms.measurement.internal.X2 r10 = r4.f5730a
            com.google.android.gms.measurement.internal.T2 r10 = r10.b()
            r10.t(r3)
            return
        L_0x00c1:
            com.google.android.gms.measurement.internal.X2 r10 = r4.f5730a
            com.google.android.gms.measurement.internal.T2 r10 = r10.b()
            r10.v(r3)
            return
        L_0x00cb:
            r0 = move-exception
            r4 = r9
        L_0x00cd:
            r10 = r0
        L_0x00ce:
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            throw r10
        L_0x00d0:
            r0 = move-exception
            goto L_0x00cd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1452x4.q0(com.google.android.gms.measurement.internal.E3, boolean):void");
    }

    public final void r() {
        X2 x22;
        O5 o5;
        O5 o52;
        boolean z4;
        boolean z5;
        C1196q4 q4Var;
        h();
        X2 x23 = this.f5730a;
        x23.a().v().a("Handle tcf update.");
        SharedPreferences q5 = x23.x().q();
        HashMap hashMap = new HashMap();
        C1296c2 c2Var = C1304d2.f6314a1;
        if (((Boolean) c2Var.b((Object) null)).booleanValue()) {
            i iVar = Q5.f6046a;
            C1187p4 p4Var = C1187p4.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            P5 p5 = P5.CONSENT;
            Map.Entry a5 = C1639G.a(p4Var, p5);
            int i5 = 2;
            C1187p4 p4Var2 = C1187p4.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            int i6 = 1;
            P5 p52 = P5.FLEXIBLE_LEGITIMATE_INTEREST;
            x22 = x23;
            j l5 = j.l(a5, C1639G.a(p4Var2, p52), C1639G.a(C1187p4.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE, p5), C1639G.a(C1187p4.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS, p5), C1639G.a(C1187p4.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE, p52), C1639G.a(C1187p4.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, p52), C1639G.a(C1187p4.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, p52));
            k q6 = k.q("CH");
            char[] cArr = new char[5];
            boolean contains = q5.contains("IABTCF_TCString");
            int b5 = Q5.b(q5, "IABTCF_CmpSdkID");
            int b6 = Q5.b(q5, "IABTCF_PolicyVersion");
            int b7 = Q5.b(q5, "IABTCF_gdprApplies");
            int b8 = Q5.b(q5, "IABTCF_PurposeOneTreatment");
            int b9 = Q5.b(q5, "IABTCF_EnableAdvertiserConsentMode");
            String a6 = Q5.a(q5, "IABTCF_PublisherCC");
            j.a a7 = j.a();
            z o6 = l5.keySet().o();
            while (o6.hasNext()) {
                C1187p4 p4Var3 = (C1187p4) o6.next();
                int A4 = p4Var3.A();
                StringBuilder sb = new StringBuilder(String.valueOf(A4).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(A4);
                String a8 = Q5.a(q5, sb.toString());
                if (TextUtils.isEmpty(a8) || a8.length() < 755) {
                    q4Var = C1196q4.PURPOSE_RESTRICTION_UNDEFINED;
                } else {
                    int digit = Character.digit(a8.charAt(754), 10);
                    if (digit < 0 || digit > C1196q4.values().length || digit == 0) {
                        q4Var = C1196q4.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    } else if (digit == i6) {
                        q4Var = C1196q4.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (digit != i5) {
                        q4Var = C1196q4.PURPOSE_RESTRICTION_UNDEFINED;
                    } else {
                        q4Var = C1196q4.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                a7.f(p4Var3, q4Var);
                i5 = 2;
                i6 = 1;
            }
            j c5 = a7.c();
            String a9 = Q5.a(q5, "IABTCF_PurposeConsents");
            String a10 = Q5.a(q5, "IABTCF_VendorConsents");
            if (TextUtils.isEmpty(a10) || a10.length() < 755 || a10.charAt(754) != '1') {
                z4 = false;
            } else {
                z4 = true;
            }
            String a11 = Q5.a(q5, "IABTCF_PurposeLegitimateInterests");
            String a12 = Q5.a(q5, "IABTCF_VendorLegitimateInterests");
            if (TextUtils.isEmpty(a12) || a12.length() < 755 || a12.charAt(754) != '1') {
                z5 = false;
            } else {
                z5 = true;
            }
            cArr[0] = '2';
            o5 = new O5(Q5.d(l5, c5, q6, cArr, b5, b9, b7, b6, b8, a6, a9, a11, z4, z5, contains));
        } else {
            x22 = x23;
            String a13 = Q5.a(q5, "IABTCF_VendorConsents");
            if (!"".equals(a13) && a13.length() > 754) {
                hashMap.put("GoogleConsent", String.valueOf(a13.charAt(754)));
            }
            int b10 = Q5.b(q5, "IABTCF_gdprApplies");
            if (b10 != -1) {
                hashMap.put("gdprApplies", String.valueOf(b10));
            }
            int b11 = Q5.b(q5, "IABTCF_EnableAdvertiserConsentMode");
            if (b11 != -1) {
                hashMap.put("EnableAdvertiserConsentMode", String.valueOf(b11));
            }
            int b12 = Q5.b(q5, "IABTCF_PolicyVersion");
            if (b12 != -1) {
                hashMap.put("PolicyVersion", String.valueOf(b12));
            }
            String a14 = Q5.a(q5, "IABTCF_PurposeConsents");
            if (!"".equals(a14)) {
                hashMap.put("PurposeConsents", a14);
            }
            int b13 = Q5.b(q5, "IABTCF_CmpSdkID");
            if (b13 != -1) {
                hashMap.put("CmpSdkID", String.valueOf(b13));
            }
            o5 = new O5(hashMap);
        }
        x22.a().w().b("Tcf preferences read", o5);
        if (x22.w().H((String) null, c2Var)) {
            E2 x4 = x22.x();
            x4.h();
            String string = x4.p().getString("stored_tcf_param", "");
            HashMap hashMap2 = new HashMap();
            if (TextUtils.isEmpty(string)) {
                o52 = new O5(hashMap2);
            } else {
                for (String split : string.split(";")) {
                    String[] split2 = split.split("=");
                    if (split2.length >= 2 && Q5.f6046a.contains(split2[0])) {
                        hashMap2.put(split2[0], split2[1]);
                    }
                }
                o52 = new O5(hashMap2);
            }
            if (x22.x().x(o5)) {
                Bundle b14 = o5.b();
                x22.a().w().b("Consent generated from Tcf", b14);
                if (b14 != Bundle.EMPTY) {
                    o0(b14, -30, x22.f().currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfm", o5.d(o52));
                bundle.putString("_tcfd2", o5.c());
                bundle.putString("_tcfd", o5.e());
                t("auto", "_tcf", bundle);
            }
        } else if (x22.x().x(o5)) {
            Bundle b15 = o5.b();
            x22.a().w().b("Consent generated from Tcf", b15);
            if (b15 != Bundle.EMPTY) {
                o0(b15, -30, x22.f().currentTimeMillis());
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_tcfd", o5.e());
            t("auto", "_tcf", bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void r0(Runnable runnable) {
        j();
        X2 x22 = this.f5730a;
        if (x22.b().p()) {
            x22.a().o().a("Cannot retrieve and upload batches from analytics worker thread");
        } else if (!x22.b().q()) {
            x22.c();
            if (!C1317f.a()) {
                x22.a().w().a("[sgtm] Started client-side batch upload work.");
                boolean z4 = false;
                int i5 = 0;
                int i6 = 0;
                while (!z4) {
                    x22.a().w().a("[sgtm] Getting upload batches from service (FE)");
                    AtomicReference atomicReference = new AtomicReference();
                    x22.b().u(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "[sgtm] Getting upload batches", new C1445w4(this, atomicReference));
                    Z5 z5 = (Z5) atomicReference.get();
                    if (z5 == null) {
                        break;
                    }
                    List list = z5.f6203a;
                    if (!list.isEmpty()) {
                        x22.a().w().b("[sgtm] Retrieved upload batches. count", Integer.valueOf(list.size()));
                        i5 += list.size();
                        Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z4 = false;
                                break;
                            }
                            C1642J e02 = e0((X5) it.next());
                            if (e02 == C1642J.SUCCESS) {
                                i6++;
                            } else if (e02 == C1642J.BACKOFF) {
                                z4 = true;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                x22.a().w().c("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i5), Integer.valueOf(i6));
                runnable.run();
                return;
            }
            x22.a().o().a("Cannot retrieve and upload batches from main thread");
        } else {
            x22.a().o().a("Cannot retrieve and upload batches from analytics network thread");
        }
    }

    public final void s() {
        h();
        X2 x22 = this.f5730a;
        x22.a().v().a("Register tcfPrefChangeListener.");
        if (this.f6886u == null) {
            this.f6887v = new Q3(this, this.f5730a);
            this.f6886u = new C1417s4(this);
        }
        x22.x().q().registerOnSharedPreferenceChangeListener(this.f6886u);
    }

    /* access modifiers changed from: package-private */
    public final void s0(long j5) {
        h();
        if (this.f6877l == null) {
            this.f6877l = new I3(this, this.f5730a);
        }
        this.f6877l.b(j5);
    }

    /* access modifiers changed from: package-private */
    public final void t(String str, String str2, Bundle bundle) {
        h();
        u(str, str2, this.f5730a.f().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void t0() {
        h();
        C1447x xVar = this.f6877l;
        if (xVar != null) {
            xVar.d();
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(String str, String str2, long j5, Bundle bundle) {
        h();
        boolean z4 = true;
        if (this.f6869d != null && !z6.N(str2)) {
            z4 = false;
        }
        v(str, str2, j5, bundle, true, z4, true, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void u0() {
        C1145k7.a();
        X2 x22 = this.f5730a;
        if (!x22.w().H((String) null, C1304d2.f6295R0)) {
            return;
        }
        if (!x22.b().p()) {
            x22.c();
            if (!C1317f.a()) {
                j();
                x22.a().w().a("Getting trigger URIs (FE)");
                AtomicReference atomicReference = new AtomicReference();
                x22.b().u(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "get trigger URIs", new C1390o4(this, atomicReference));
                List list = (List) atomicReference.get();
                if (list == null) {
                    x22.a().q().a("Timed out waiting for get trigger URIs");
                } else {
                    x22.b().t(new C1397p4(this, list));
                }
            } else {
                x22.a().o().a("Cannot get trigger URIs from main thread");
            }
        } else {
            x22.a().o().a("Cannot get trigger URIs from analytics worker thread");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: int} */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v(java.lang.String r23, java.lang.String r24, long r25, android.os.Bundle r27, boolean r28, boolean r29, boolean r30, java.lang.String r31) {
        /*
            r22 = this;
            r1 = r22
            r7 = r23
            r8 = r24
            r9 = r27
            N.C0722p.e(r7)
            N.C0722p.k(r9)
            r1.h()
            r1.j()
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            boolean r2 = r0.g()
            if (r2 == 0) goto L_0x04c1
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a
            com.google.android.gms.measurement.internal.g2 r2 = r2.L()
            java.util.List r2 = r2.w()
            if (r2 == 0) goto L_0x003f
            boolean r2 = r2.contains(r8)
            if (r2 == 0) goto L_0x002f
            goto L_0x003f
        L_0x002f:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.v()
            java.lang.String r2 = "Dropping non-safelisted event. event name, origin"
            r0.c(r2, r8, r7)
            return
        L_0x003f:
            boolean r2 = r1.f6871f
            r10 = 0
            r11 = 0
            r12 = 1
            if (r2 != 0) goto L_0x009d
            r1.f6871f = r12
            boolean r0 = r0.G()     // Catch:{ ClassNotFoundException -> 0x008e }
            java.lang.String r2 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x005f
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a     // Catch:{ ClassNotFoundException -> 0x008e }
            android.content.Context r0 = r0.e()     // Catch:{ ClassNotFoundException -> 0x008e }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x008e }
            java.lang.Class r0 = java.lang.Class.forName(r2, r12, r0)     // Catch:{ ClassNotFoundException -> 0x008e }
            goto L_0x0063
        L_0x005f:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x008e }
        L_0x0063:
            java.lang.String r2 = "initialize"
            java.lang.Class[] r3 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x007d }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r3[r11] = r4     // Catch:{ Exception -> 0x007d }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r3)     // Catch:{ Exception -> 0x007d }
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ Exception -> 0x007d }
            android.content.Context r2 = r2.e()     // Catch:{ Exception -> 0x007d }
            java.lang.Object[] r3 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x007d }
            r3[r11] = r2     // Catch:{ Exception -> 0x007d }
            r0.invoke(r10, r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x009d
        L_0x007d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.X2 r2 = r1.f5730a     // Catch:{ ClassNotFoundException -> 0x008e }
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()     // Catch:{ ClassNotFoundException -> 0x008e }
            com.google.android.gms.measurement.internal.o2 r2 = r2.r()     // Catch:{ ClassNotFoundException -> 0x008e }
            java.lang.String r3 = "Failed to invoke Tag Manager's initialize() method"
            r2.b(r3, r0)     // Catch:{ ClassNotFoundException -> 0x008e }
            goto L_0x009d
        L_0x008e:
            com.google.android.gms.measurement.internal.X2 r0 = r1.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.u()
            java.lang.String r2 = "Tag Manager is not found and thus will not be used"
            r0.a(r2)
        L_0x009d:
            com.google.android.gms.measurement.internal.X2 r13 = r1.f5730a
            com.google.android.gms.measurement.internal.m r0 = r13.w()
            com.google.android.gms.measurement.internal.c2 r2 = com.google.android.gms.measurement.internal.C1304d2.f6332g1
            boolean r0 = r0.H(r10, r2)
            if (r0 != 0) goto L_0x00d1
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00d1
            java.lang.String r0 = "gclid"
            boolean r2 = r9.containsKey(r0)
            if (r2 == 0) goto L_0x00d1
            r13.c()
            java.lang.String r4 = r9.getString(r0)
            com.google.android.gms.common.util.d r0 = r13.f()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1.B(r2, r3, r4, r5)
        L_0x00d1:
            r6 = r1
            r13.c()
            if (r28 == 0) goto L_0x00ee
            boolean r0 = com.google.android.gms.measurement.internal.z6.U(r8)
            if (r0 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.z6 r0 = r13.C()
            com.google.android.gms.measurement.internal.E2 r1 = r13.x()
            com.google.android.gms.measurement.internal.A2 r1 = r1.f5856z
            android.os.Bundle r1 = r1.a()
            r0.w(r9, r1)
        L_0x00ee:
            r0 = 40
            if (r30 != 0) goto L_0x016a
            r13.c()
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x016a
            com.google.android.gms.measurement.internal.X2 r1 = r6.f5730a
            com.google.android.gms.measurement.internal.z6 r2 = r1.C()
            java.lang.String r3 = "event"
            boolean r4 = r2.t0(r3, r8)
            r5 = 2
            if (r4 != 0) goto L_0x010d
            goto L_0x0127
        L_0x010d:
            java.lang.String[] r4 = f0.x.f15332a
            java.lang.String[] r14 = f0.x.f15333b
            boolean r4 = r2.v0(r3, r4, r14, r8)
            if (r4 != 0) goto L_0x011a
            r5 = 13
            goto L_0x0127
        L_0x011a:
            com.google.android.gms.measurement.internal.X2 r4 = r2.f5730a
            r4.w()
            boolean r2 = r2.w0(r3, r0, r8)
            if (r2 != 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            r5 = r11
        L_0x0127:
            if (r5 == 0) goto L_0x016a
            com.google.android.gms.measurement.internal.q2 r2 = r13.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.q()
            com.google.android.gms.measurement.internal.j2 r3 = r13.D()
            java.lang.String r3 = r3.a(r8)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            com.google.android.gms.measurement.internal.z6 r2 = r1.C()
            r1.w()
            java.lang.String r0 = r2.q(r8, r0, r12)
            if (r8 == 0) goto L_0x014f
            int r11 = r8.length()
        L_0x014f:
            com.google.android.gms.measurement.internal.z6 r1 = r1.C()
            com.google.android.gms.measurement.internal.y6 r2 = r6.f6888w
            r3 = 0
            java.lang.String r4 = "_ev"
            r28 = r0
            r23 = r1
            r24 = r2
            r25 = r3
            r27 = r4
            r26 = r5
            r29 = r11
            r23.B(r24, r25, r26, r27, r28, r29)
            return
        L_0x016a:
            r13.c()
            com.google.android.gms.measurement.internal.X2 r14 = r6.f5730a
            com.google.android.gms.measurement.internal.M4 r1 = r14.I()
            com.google.android.gms.measurement.internal.E4 r1 = r1.q(r11)
            java.lang.String r2 = "_sc"
            if (r1 == 0) goto L_0x0183
            boolean r3 = r9.containsKey(r2)
            if (r3 != 0) goto L_0x0183
            r1.f5863d = r12
        L_0x0183:
            if (r28 == 0) goto L_0x0189
            if (r30 != 0) goto L_0x0189
            r3 = r12
            goto L_0x018a
        L_0x0189:
            r3 = r11
        L_0x018a:
            com.google.android.gms.measurement.internal.z6.k0(r1, r9, r3)
            java.lang.String r1 = "am"
            boolean r1 = r1.equals(r7)
            boolean r3 = com.google.android.gms.measurement.internal.z6.N(r8)
            if (r28 == 0) goto L_0x01d0
            f0.A r4 = r6.f6869d
            if (r4 == 0) goto L_0x01d0
            if (r3 != 0) goto L_0x01d0
            if (r1 == 0) goto L_0x01a3
            r9 = r12
            goto L_0x01d1
        L_0x01a3:
            com.google.android.gms.measurement.internal.q2 r0 = r13.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.v()
            com.google.android.gms.measurement.internal.j2 r1 = r13.D()
            java.lang.String r1 = r1.a(r8)
            com.google.android.gms.measurement.internal.j2 r2 = r13.D()
            java.lang.String r2 = r2.e(r9)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.c(r3, r1, r2)
            f0.A r0 = r6.f6869d
            N.C0722p.k(r0)
            f0.A r0 = r6.f6869d
            r4 = r25
            r1 = r7
            r2 = r8
            r3 = r9
            r0.a(r1, r2, r3, r4)
            return
        L_0x01d0:
            r9 = r1
        L_0x01d1:
            com.google.android.gms.measurement.internal.X2 r15 = r6.f5730a
            boolean r1 = r15.m()
            if (r1 != 0) goto L_0x01db
            goto L_0x04c0
        L_0x01db:
            com.google.android.gms.measurement.internal.z6 r1 = r13.C()
            int r1 = r1.x0(r8)
            if (r1 == 0) goto L_0x0225
            com.google.android.gms.measurement.internal.q2 r2 = r13.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.q()
            com.google.android.gms.measurement.internal.j2 r3 = r13.D()
            java.lang.String r3 = r3.a(r8)
            java.lang.String r4 = "Invalid event name. Event will not be logged (FE)"
            r2.b(r4, r3)
            com.google.android.gms.measurement.internal.z6 r2 = r13.C()
            r13.w()
            java.lang.String r0 = r2.q(r8, r0, r12)
            if (r8 == 0) goto L_0x020b
            int r11 = r8.length()
        L_0x020b:
            com.google.android.gms.measurement.internal.z6 r2 = r15.C()
            com.google.android.gms.measurement.internal.y6 r3 = r6.f6888w
            java.lang.String r4 = "_ev"
            r25 = r31
            r28 = r0
            r26 = r1
            r23 = r2
            r24 = r3
            r27 = r4
            r29 = r11
            r23.B(r24, r25, r26, r27, r28, r29)
            return
        L_0x0225:
            java.lang.String r0 = "_sn"
            java.lang.String r1 = "_si"
            java.lang.String r3 = "_o"
            java.lang.String[] r0 = new java.lang.String[]{r3, r0, r2, r1}
            java.util.List r4 = com.google.android.gms.common.util.e.b(r0)
            com.google.android.gms.measurement.internal.z6 r0 = r13.C()
            r5 = r30
            r1 = r31
            r2 = r8
            r16 = r13
            r8 = r3
            r3 = r27
            android.os.Bundle r0 = r0.t(r1, r2, r3, r4, r5)
            r1 = r2
            N.C0722p.k(r0)
            r16.c()
            com.google.android.gms.measurement.internal.M4 r2 = r14.I()
            com.google.android.gms.measurement.internal.E4 r2 = r2.q(r11)
            java.lang.String r3 = "_ae"
            if (r2 == 0) goto L_0x0286
            boolean r2 = r3.equals(r1)
            if (r2 == 0) goto L_0x0286
            com.google.android.gms.measurement.internal.N5 r2 = r14.z()
            com.google.android.gms.measurement.internal.L5 r2 = r2.f5999f
            r27 = 0
            com.google.android.gms.measurement.internal.N5 r4 = r2.f5967d
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a
            com.google.android.gms.common.util.d r4 = r4.f()
            long r4 = r4.elapsedRealtime()
            r17 = r11
            long r11 = r2.f5965b
            long r11 = r4 - r11
            r2.f5965b = r4
            int r2 = (r11 > r27 ? 1 : (r11 == r27 ? 0 : -1))
            if (r2 <= 0) goto L_0x028a
            com.google.android.gms.measurement.internal.z6 r2 = r16.C()
            r2.Z(r0, r11)
            goto L_0x028a
        L_0x0286:
            r17 = r11
            r27 = 0
        L_0x028a:
            java.lang.String r2 = "auto"
            boolean r2 = r2.equals(r7)
            java.lang.String r4 = "_ffr"
            if (r2 != 0) goto L_0x02dc
            java.lang.String r2 = "_ssr"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x02dc
            com.google.android.gms.measurement.internal.z6 r2 = r16.C()
            java.lang.String r4 = r0.getString(r4)
            boolean r5 = com.google.android.gms.common.util.o.a(r4)
            if (r5 == 0) goto L_0x02ac
            r4 = r10
            goto L_0x02b2
        L_0x02ac:
            if (r4 == 0) goto L_0x02b2
            java.lang.String r4 = r4.trim()
        L_0x02b2:
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a
            com.google.android.gms.measurement.internal.E2 r5 = r2.x()
            com.google.android.gms.measurement.internal.D2 r5 = r5.f5853w
            java.lang.String r5 = r5.a()
            boolean r5 = j$.util.Objects.equals(r4, r5)
            if (r5 != 0) goto L_0x02ce
            com.google.android.gms.measurement.internal.E2 r2 = r2.x()
            com.google.android.gms.measurement.internal.D2 r2 = r2.f5853w
            r2.b(r4)
            goto L_0x02fb
        L_0x02ce:
            com.google.android.gms.measurement.internal.q2 r0 = r2.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.v()
            java.lang.String r1 = "Not logging duplicate session_start_with_rollout event"
            r0.a(r1)
            return
        L_0x02dc:
            boolean r2 = r3.equals(r1)
            if (r2 == 0) goto L_0x02fb
            com.google.android.gms.measurement.internal.z6 r2 = r16.C()
            com.google.android.gms.measurement.internal.X2 r2 = r2.f5730a
            com.google.android.gms.measurement.internal.E2 r2 = r2.x()
            com.google.android.gms.measurement.internal.D2 r2 = r2.f5853w
            java.lang.String r2 = r2.a()
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x02fb
            r0.putString(r4, r2)
        L_0x02fb:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r0)
            com.google.android.gms.measurement.internal.m r2 = r16.w()
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6303V0
            boolean r2 = r2.H(r10, r4)
            if (r2 == 0) goto L_0x0318
            com.google.android.gms.measurement.internal.N5 r2 = r14.z()
            boolean r2 = r2.p()
            goto L_0x0322
        L_0x0318:
            com.google.android.gms.measurement.internal.E2 r2 = r16.x()
            com.google.android.gms.measurement.internal.z2 r2 = r2.f5850t
            boolean r2 = r2.a()
        L_0x0322:
            com.google.android.gms.measurement.internal.E2 r4 = r16.x()
            com.google.android.gms.measurement.internal.B2 r4 = r4.f5847q
            long r4 = r4.a()
            int r4 = (r4 > r27 ? 1 : (r4 == r27 ? 0 : -1))
            if (r4 <= 0) goto L_0x039f
            com.google.android.gms.measurement.internal.E2 r4 = r16.x()
            r12 = r25
            boolean r4 = r4.A(r12)
            if (r4 == 0) goto L_0x0396
            if (r2 == 0) goto L_0x0396
            com.google.android.gms.measurement.internal.q2 r2 = r16.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.w()
            java.lang.String r4 = "Current session is expired, remove the session number, ID, and engagement time"
            r2.a(r4)
            com.google.android.gms.common.util.d r2 = r16.f()
            long r4 = r2.currentTimeMillis()
            r2 = r3
            java.lang.String r3 = "_sid"
            r5 = r4
            r4 = 0
            r18 = r2
            java.lang.String r2 = "auto"
            r20 = r27
            r27 = r11
            r10 = r20
            r1 = r22
            r19 = r18
            r1.B(r2, r3, r4, r5)
            com.google.android.gms.common.util.d r1 = r16.f()
            long r5 = r1.currentTimeMillis()
            java.lang.String r3 = "_sno"
            java.lang.String r2 = "auto"
            r1 = r22
            r1.B(r2, r3, r4, r5)
            com.google.android.gms.common.util.d r1 = r16.f()
            long r5 = r1.currentTimeMillis()
            java.lang.String r3 = "_se"
            java.lang.String r2 = "auto"
            r1 = r22
            r1.B(r2, r3, r4, r5)
            r6 = r1
            com.google.android.gms.measurement.internal.E2 r1 = r16.x()
            com.google.android.gms.measurement.internal.B2 r1 = r1.f5848r
            r1.b(r10)
            goto L_0x03a7
        L_0x0396:
            r20 = r27
            r27 = r11
            r10 = r20
        L_0x039c:
            r19 = r3
            goto L_0x03a7
        L_0x039f:
            r12 = r27
            r27 = r11
            r10 = r12
            r12 = r25
            goto L_0x039c
        L_0x03a7:
            java.lang.String r1 = "extend_session"
            long r1 = r0.getLong(r1, r10)
            r3 = 1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.q2 r1 = r16.a()
            com.google.android.gms.measurement.internal.o2 r1 = r1.w()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            com.google.android.gms.measurement.internal.N5 r1 = r15.z()
            com.google.android.gms.measurement.internal.M5 r1 = r1.f5998e
            r2 = 1
            r1.b(r12, r2)
        L_0x03ca:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            java.util.Collections.sort(r1)
            int r2 = r1.size()
            r3 = r17
        L_0x03dc:
            if (r3 >= r2) goto L_0x0427
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0424
            r16.C()
            java.lang.Object r5 = r0.get(r4)
            boolean r10 = r5 instanceof android.os.Bundle
            if (r10 == 0) goto L_0x03f9
            r10 = 1
            android.os.Bundle[] r11 = new android.os.Bundle[r10]
            android.os.Bundle r5 = (android.os.Bundle) r5
            r11[r17] = r5
            goto L_0x041f
        L_0x03f9:
            boolean r10 = r5 instanceof android.os.Parcelable[]
            if (r10 == 0) goto L_0x040a
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r10 = r5.length
            java.lang.Class<android.os.Bundle[]> r11 = android.os.Bundle[].class
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r10, r11)
            r11 = r5
            android.os.Bundle[] r11 = (android.os.Bundle[]) r11
            goto L_0x041f
        L_0x040a:
            boolean r10 = r5 instanceof java.util.ArrayList
            if (r10 == 0) goto L_0x041e
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r10 = r5.size()
            android.os.Bundle[] r10 = new android.os.Bundle[r10]
            java.lang.Object[] r5 = r5.toArray(r10)
            r11 = r5
            android.os.Bundle[] r11 = (android.os.Bundle[]) r11
            goto L_0x041f
        L_0x041e:
            r11 = 0
        L_0x041f:
            if (r11 == 0) goto L_0x0424
            r0.putParcelableArray(r4, r11)
        L_0x0424:
            int r3 = r3 + 1
            goto L_0x03dc
        L_0x0427:
            r10 = r17
        L_0x0429:
            int r0 = r27.size()
            if (r10 >= r0) goto L_0x0495
            r11 = r27
            java.lang.Object r0 = r11.get(r10)
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r10 == 0) goto L_0x043c
            java.lang.String r1 = "_ep"
            goto L_0x043e
        L_0x043c:
            r1 = r24
        L_0x043e:
            r0.putString(r8, r7)
            if (r29 == 0) goto L_0x044d
            com.google.android.gms.measurement.internal.z6 r2 = r16.C()
            r15 = 0
            android.os.Bundle r0 = r2.Q(r0, r15)
            goto L_0x044e
        L_0x044d:
            r15 = 0
        L_0x044e:
            com.google.android.gms.measurement.internal.G r2 = new com.google.android.gms.measurement.internal.G
            r3 = r2
            com.google.android.gms.measurement.internal.E r2 = new com.google.android.gms.measurement.internal.E
            r2.<init>(r0)
            r4 = r7
            r7 = r0
            r0 = r3
            r3 = r4
            r4 = r12
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.measurement.internal.w5 r1 = r14.J()
            r12 = r31
            r1.c0(r0, r12)
            if (r9 != 0) goto L_0x048a
            java.util.Set r0 = r6.f6870e
            java.util.Iterator r13 = r0.iterator()
        L_0x046f:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x048a
            java.lang.Object r0 = r13.next()
            f0.B r0 = (f0.C1634B) r0
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>(r7)
            r1 = r23
            r2 = r24
            r4 = r25
            r0.a(r1, r2, r3, r4)
            goto L_0x046f
        L_0x048a:
            r2 = r24
            int r10 = r10 + 1
            r7 = r23
            r12 = r25
            r27 = r11
            goto L_0x0429
        L_0x0495:
            r2 = r24
            r16.c()
            com.google.android.gms.measurement.internal.M4 r0 = r14.I()
            r1 = r17
            com.google.android.gms.measurement.internal.E4 r0 = r0.q(r1)
            if (r0 == 0) goto L_0x04c0
            r0 = r19
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x04c0
            com.google.android.gms.measurement.internal.N5 r0 = r14.z()
            com.google.android.gms.common.util.d r1 = r16.f()
            long r1 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.L5 r0 = r0.f5999f
            r10 = 1
            r0.d(r10, r10, r1)
        L_0x04c0:
            return
        L_0x04c1:
            r6 = r1
            com.google.android.gms.measurement.internal.X2 r0 = r6.f5730a
            com.google.android.gms.measurement.internal.q2 r0 = r0.a()
            com.google.android.gms.measurement.internal.o2 r0 = r0.v()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1452x4.v(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean v0() {
        return this.f6879n;
    }

    public final void w(String str, String str2, Bundle bundle, String str3) {
        X2.q();
        x("auto", str2, this.f5730a.f().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* access modifiers changed from: package-private */
    public final PriorityQueue w0() {
        if (this.f6878m == null) {
            C1638F.a();
            this.f6878m = C1637E.a(Comparator$CC.comparing(C1404q4.f6642a, C1410r4.f6696a));
        }
        return this.f6878m;
    }

    /* access modifiers changed from: protected */
    public final void x(String str, String str2, long j5, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        int i5 = z6.f6939k;
        Bundle bundle2 = new Bundle(bundle);
        for (String next : bundle2.keySet()) {
            Object obj = bundle2.get(next);
            if (obj instanceof Bundle) {
                bundle2.putBundle(next, new Bundle((Bundle) obj));
            } else {
                int i6 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i6 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i6];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i6] = new Bundle((Bundle) parcelable);
                        }
                        i6++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i6 < list.size()) {
                        Object obj2 = list.get(i6);
                        if (obj2 instanceof Bundle) {
                            list.set(i6, new Bundle((Bundle) obj2));
                        }
                        i6++;
                    }
                }
            }
        }
        this.f5730a.b().t(new R3(this, str, str2, j5, bundle2, z4, z5, z6, str3));
    }

    /* access modifiers changed from: package-private */
    public final void x0() {
        S5 s5;
        h();
        this.f6879n = false;
        if (!w0().isEmpty() && !this.f6874i && (s5 = (S5) w0().poll()) != null) {
            X2 x22 = this.f5730a;
            MeasurementManagerFutures H4 = x22.C().H();
            if (H4 != null) {
                this.f6874i = true;
                C1388o2 w4 = x22.a().w();
                String str = s5.f6081a;
                w4.b("Registering trigger URI", str);
                C1722d registerTriggerAsync = H4.registerTriggerAsync(Uri.parse(str));
                if (registerTriggerAsync == null) {
                    this.f6874i = false;
                    w0().add(s5);
                    return;
                }
                C1720b.a(registerTriggerAsync, new K3(this, s5), new J3(this));
            }
        }
    }

    public final void y(String str, String str2, Object obj, boolean z4) {
        z("auto", "_ldl", obj, true, this.f5730a.f().currentTimeMillis());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(java.lang.String r17, java.lang.String r18, java.lang.Object r19, boolean r20, long r21) {
        /*
            r16 = this;
            r0 = r16
            r2 = r18
            r1 = r19
            r3 = 0
            r4 = 24
            if (r20 == 0) goto L_0x0017
            com.google.android.gms.measurement.internal.X2 r5 = r0.f5730a
            com.google.android.gms.measurement.internal.z6 r5 = r5.C()
            int r5 = r5.y0(r2)
        L_0x0015:
            r12 = r5
            goto L_0x0041
        L_0x0017:
            com.google.android.gms.measurement.internal.X2 r5 = r0.f5730a
            com.google.android.gms.measurement.internal.z6 r5 = r5.C()
            java.lang.String r6 = "user property"
            boolean r7 = r5.t0(r6, r2)
            r8 = 6
            if (r7 != 0) goto L_0x0028
        L_0x0026:
            r12 = r8
            goto L_0x0041
        L_0x0028:
            java.lang.String[] r7 = f0.z.f15340a
            r9 = 0
            boolean r7 = r5.v0(r6, r7, r9, r2)
            if (r7 != 0) goto L_0x0034
            r5 = 15
            goto L_0x0015
        L_0x0034:
            com.google.android.gms.measurement.internal.X2 r7 = r5.f5730a
            r7.w()
            boolean r5 = r5.w0(r6, r4, r2)
            if (r5 != 0) goto L_0x0040
            goto L_0x0026
        L_0x0040:
            r12 = r3
        L_0x0041:
            r5 = 1
            if (r12 == 0) goto L_0x0067
            com.google.android.gms.measurement.internal.X2 r1 = r0.f5730a
            com.google.android.gms.measurement.internal.z6 r6 = r1.C()
            r1.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            if (r2 == 0) goto L_0x0057
            int r3 = r2.length()
        L_0x0057:
            r15 = r3
            com.google.android.gms.measurement.internal.X2 r1 = r0.f5730a
            com.google.android.gms.measurement.internal.y6 r10 = r0.f6888w
            com.google.android.gms.measurement.internal.z6 r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        L_0x0067:
            if (r17 != 0) goto L_0x006c
            java.lang.String r6 = "app"
            goto L_0x006e
        L_0x006c:
            r6 = r17
        L_0x006e:
            if (r1 == 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.X2 r7 = r0.f5730a
            com.google.android.gms.measurement.internal.z6 r8 = r7.C()
            int r12 = r8.y(r2, r1)
            if (r12 == 0) goto L_0x00aa
            com.google.android.gms.measurement.internal.z6 r6 = r7.C()
            r7.w()
            java.lang.String r14 = r6.q(r2, r4, r5)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0092
            boolean r2 = r1 instanceof java.lang.CharSequence
            if (r2 == 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r15 = r3
            goto L_0x009b
        L_0x0092:
            java.lang.String r1 = r1.toString()
            int r3 = r1.length()
            goto L_0x0090
        L_0x009b:
            com.google.android.gms.measurement.internal.X2 r1 = r0.f5730a
            com.google.android.gms.measurement.internal.y6 r10 = r0.f6888w
            com.google.android.gms.measurement.internal.z6 r9 = r1.C()
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.B(r10, r11, r12, r13, r14, r15)
            return
        L_0x00aa:
            com.google.android.gms.measurement.internal.z6 r3 = r7.C()
            java.lang.Object r5 = r3.z(r2, r1)
            if (r5 == 0) goto L_0x00ba
            r3 = r21
            r1 = r6
            r0.A(r1, r2, r3, r5)
        L_0x00ba:
            return
        L_0x00bb:
            r1 = r6
            r5 = 0
            r0 = r16
            r2 = r18
            r3 = r21
            r0.A(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1452x4.z(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }
}
