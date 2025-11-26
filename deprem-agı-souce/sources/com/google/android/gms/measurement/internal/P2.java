package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.internal.measurement.C1050a2;
import com.google.android.gms.internal.measurement.C1068c2;
import com.google.android.gms.internal.measurement.C1077d2;
import com.google.android.gms.internal.measurement.C1093f0;
import com.google.android.gms.internal.measurement.C1095f2;
import com.google.android.gms.internal.measurement.C1104g2;
import com.google.android.gms.internal.measurement.C1170n5;
import com.google.android.gms.internal.measurement.C1176o2;
import com.google.android.gms.internal.measurement.C1239v3;
import com.google.android.gms.internal.measurement.C1243v7;
import com.google.android.gms.internal.measurement.C1265y3;
import com.google.android.gms.internal.measurement.F0;
import com.google.android.gms.internal.measurement.O1;
import com.google.android.gms.internal.measurement.Q1;
import com.google.android.gms.internal.measurement.X1;
import f0.v;
import f0.w;
import f0.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class P2 extends C1292b6 implements C1364l {

    /* renamed from: d  reason: collision with root package name */
    private final Map f6016d = new ArrayMap();

    /* renamed from: e  reason: collision with root package name */
    final Map f6017e = new ArrayMap();

    /* renamed from: f  reason: collision with root package name */
    final Map f6018f = new ArrayMap();

    /* renamed from: g  reason: collision with root package name */
    final Map f6019g = new ArrayMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map f6020h = new ArrayMap();

    /* renamed from: i  reason: collision with root package name */
    private final Map f6021i = new ArrayMap();

    /* renamed from: j  reason: collision with root package name */
    final LruCache f6022j = new I2(this, 20);

    /* renamed from: k  reason: collision with root package name */
    final C1243v7 f6023k = new J2(this);

    /* renamed from: l  reason: collision with root package name */
    private final Map f6024l = new ArrayMap();

    /* renamed from: m  reason: collision with root package name */
    private final Map f6025m = new ArrayMap();

    /* renamed from: n  reason: collision with root package name */
    private final Map f6026n = new ArrayMap();

    P2(q6 q6Var) {
        super(q6Var);
    }

    private final void q(String str) {
        j();
        h();
        C0722p.e(str);
        Map map = this.f6020h;
        if (map.get(str) == null) {
            C1392p N02 = this.f6129b.F0().N0(str);
            if (N02 == null) {
                this.f6016d.put(str, (Object) null);
                this.f6018f.put(str, (Object) null);
                this.f6017e.put(str, (Object) null);
                this.f6019g.put(str, (Object) null);
                map.put(str, (Object) null);
                this.f6024l.put(str, (Object) null);
                this.f6025m.put(str, (Object) null);
                this.f6026n.put(str, (Object) null);
                this.f6021i.put(str, (Object) null);
                return;
            }
            C1095f2 f2Var = (C1095f2) t(str, N02.f6604a).q();
            r(str, f2Var);
            this.f6016d.put(str, u((C1104g2) f2Var.o()));
            map.put(str, (C1104g2) f2Var.o());
            s(str, (C1104g2) f2Var.o());
            this.f6024l.put(str, f2Var.A());
            this.f6025m.put(str, N02.f6605b);
            this.f6026n.put(str, N02.f6606c);
        }
    }

    private final void r(String str, C1095f2 f2Var) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (C1068c2 F4 : f2Var.z()) {
            hashSet.add(F4.F());
        }
        for (int i5 = 0; i5 < f2Var.r(); i5++) {
            C1077d2 d2Var = (C1077d2) f2Var.s(i5).q();
            if (d2Var.r().isEmpty()) {
                this.f5730a.a().r().a("EventConfig contained null event name");
            } else {
                String r5 = d2Var.r();
                String b5 = x.b(d2Var.r());
                if (!TextUtils.isEmpty(b5)) {
                    d2Var.s(b5);
                    f2Var.t(i5, d2Var);
                }
                if (d2Var.t() && d2Var.w()) {
                    arrayMap.put(r5, Boolean.TRUE);
                }
                if (d2Var.x() && d2Var.y()) {
                    arrayMap2.put(d2Var.r(), Boolean.TRUE);
                }
                if (d2Var.z()) {
                    if (d2Var.A() < 2 || d2Var.A() > 65535) {
                        this.f5730a.a().r().c("Invalid sampling rate. Event name, sample rate", d2Var.r(), Integer.valueOf(d2Var.A()));
                    } else {
                        arrayMap3.put(d2Var.r(), Integer.valueOf(d2Var.A()));
                    }
                }
            }
        }
        this.f6017e.put(str, hashSet);
        this.f6018f.put(str, arrayMap);
        this.f6019g.put(str, arrayMap2);
        this.f6021i.put(str, arrayMap3);
    }

    private final void s(String str, C1104g2 g2Var) {
        if (g2Var.O() != 0) {
            X2 x22 = this.f5730a;
            x22.a().w().b("EES programs found", Integer.valueOf(g2Var.O()));
            C1265y3 y3Var = (C1265y3) g2Var.N().get(0);
            try {
                C1093f0 f0Var = new C1093f0();
                f0Var.a("internal.remoteConfig", new O2(this, str));
                f0Var.a("internal.appMetadata", new L2(this, str));
                f0Var.a("internal.logger", new M2(this));
                f0Var.f(y3Var);
                this.f6022j.put(str, f0Var);
                x22.a().w().c("EES program loaded for appId, activities", str, Integer.valueOf(y3Var.G().G()));
                for (C1239v3 F4 : y3Var.G().F()) {
                    x22.a().w().b("EES program activity", F4.F());
                }
            } catch (F0 unused) {
                this.f5730a.a().o().b("Failed to load EES program. appId", str);
            }
        } else {
            this.f6022j.remove(str);
        }
    }

    private final C1104g2 t(String str, byte[] bArr) {
        Long l5;
        if (bArr == null) {
            return C1104g2.W();
        }
        try {
            C1104g2 g2Var = (C1104g2) ((C1095f2) u6.W(C1104g2.V(), bArr)).o();
            C1388o2 w4 = this.f5730a.a().w();
            String str2 = null;
            if (g2Var.F()) {
                l5 = Long.valueOf(g2Var.G());
            } else {
                l5 = null;
            }
            if (g2Var.H()) {
                str2 = g2Var.I();
            }
            w4.c("Parsed config. version, gmp_app_id", l5, str2);
            return g2Var;
        } catch (C1170n5 e5) {
            this.f5730a.a().r().c("Unable to merge remote config. appId", C1402q2.x(str), e5);
            return C1104g2.W();
        } catch (RuntimeException e6) {
            this.f5730a.a().r().c("Unable to merge remote config. appId", C1402q2.x(str), e6);
            return C1104g2.W();
        }
    }

    private static final Map u(C1104g2 g2Var) {
        ArrayMap arrayMap = new ArrayMap();
        if (g2Var != null) {
            for (C1176o2 o2Var : g2Var.J()) {
                arrayMap.put(o2Var.F(), o2Var.G());
            }
        }
        return arrayMap;
    }

    private static final w v(int i5) {
        int i6 = i5 - 1;
        if (i6 == 1) {
            return w.AD_STORAGE;
        }
        if (i6 == 2) {
            return w.ANALYTICS_STORAGE;
        }
        if (i6 == 3) {
            return w.AD_USER_DATA;
        }
        if (i6 != 4) {
            return null;
        }
        return w.AD_PERSONALIZATION;
    }

    /* access modifiers changed from: protected */
    public final void A(String str) {
        h();
        this.f6025m.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void B(String str) {
        h();
        this.f6020h.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean C(String str, byte[] bArr, String str2, String str3) {
        j();
        h();
        C0722p.e(str);
        C1095f2 f2Var = (C1095f2) t(str, bArr).q();
        r(str, f2Var);
        s(str, (C1104g2) f2Var.o());
        this.f6020h.put(str, (C1104g2) f2Var.o());
        this.f6024l.put(str, f2Var.A());
        this.f6025m.put(str, str2);
        this.f6026n.put(str, str3);
        this.f6016d.put(str, u((C1104g2) f2Var.o()));
        this.f6129b.F0().Y(str, new ArrayList(f2Var.w()));
        try {
            f2Var.x();
            bArr = ((C1104g2) f2Var.o()).e();
        } catch (RuntimeException e5) {
            this.f5730a.a().r().c("Unable to serialize reduced-size config. Storing full config instead. appId", C1402q2.x(str), e5);
        }
        C1426u F02 = this.f6129b.F0();
        C0722p.e(str);
        F02.h();
        F02.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (((long) F02.u0().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                F02.f5730a.a().o().b("Failed to update remote config (got 0). appId", C1402q2.x(str));
            }
        } catch (SQLiteException e6) {
            F02.f5730a.a().o().c("Error storing remote config. appId", C1402q2.x(str), e6);
        }
        f2Var.y();
        this.f6020h.put(str, (C1104g2) f2Var.o());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean D(String str, String str2) {
        Boolean bool;
        h();
        q(str);
        if (H(str) && z6.N(str2)) {
            return true;
        }
        if (I(str) && z6.r0(str2)) {
            return true;
        }
        Map map = (Map) this.f6018f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean E(String str, String str2) {
        Boolean bool;
        h();
        q(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f6019g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final Set F(String str) {
        h();
        q(str);
        return (Set) this.f6017e.get(str);
    }

    /* access modifiers changed from: package-private */
    public final int G(String str, String str2) {
        Integer num;
        h();
        q(str);
        Map map = (Map) this.f6021i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean H(String str) {
        return "1".equals(d(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean I(String str) {
        return "1".equals(d(str, "measurement.upload.blacklist_public"));
    }

    /* access modifiers changed from: package-private */
    public final boolean J(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null) {
            return false;
        }
        if (((Set) map.get(str)).contains("device_model") || ((Set) map.get(str)).contains("device_info")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean K(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null) {
            return false;
        }
        if (((Set) map.get(str)).contains("os_version") || ((Set) map.get(str)).contains("device_info")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean L(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null || !((Set) map.get(str)).contains("user_id")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null || !((Set) map.get(str)).contains("google_signals")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null || !((Set) map.get(str)).contains("app_instance_id")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean O(String str) {
        h();
        q(str);
        Map map = this.f6017e;
        if (map.get(str) == null || !((Set) map.get(str)).contains("enhanced_user_id")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean P(String str, w wVar) {
        h();
        q(str);
        C1050a2 R4 = R(str);
        if (R4 == null) {
            return false;
        }
        Iterator it = R4.F().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            O1 o12 = (O1) it.next();
            if (wVar == v(o12.G())) {
                if (o12.H() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final w Q(String str, w wVar) {
        h();
        q(str);
        C1050a2 R4 = R(str);
        if (R4 == null) {
            return null;
        }
        for (Q1 q12 : R4.G()) {
            if (wVar == v(q12.G())) {
                return v(q12.H());
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final C1050a2 R(String str) {
        h();
        q(str);
        C1104g2 w4 = w(str);
        if (w4 == null || !w4.R()) {
            return null;
        }
        return w4.S();
    }

    /* access modifiers changed from: package-private */
    public final boolean S(String str) {
        h();
        q(str);
        C1050a2 R4 = R(str);
        if (R4 != null && R4.I() && !R4.J()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final SortedSet T(String str) {
        h();
        q(str);
        TreeSet treeSet = new TreeSet();
        C1050a2 R4 = R(str);
        if (R4 != null) {
            for (X1 F4 : R4.H()) {
                treeSet.add(F4.F());
            }
        }
        return treeSet;
    }

    public final String d(String str, String str2) {
        h();
        q(str);
        Map map = (Map) this.f6016d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final v m(String str, w wVar) {
        h();
        q(str);
        C1050a2 R4 = R(str);
        if (R4 == null) {
            return v.UNINITIALIZED;
        }
        for (O1 o12 : R4.K()) {
            if (v(o12.G()) == wVar) {
                int H4 = o12.H() - 1;
                if (H4 == 1) {
                    return v.GRANTED;
                }
                if (H4 != 2) {
                    return v.UNINITIALIZED;
                }
                return v.DENIED;
            }
        }
        return v.UNINITIALIZED;
    }

    /* access modifiers changed from: package-private */
    public final boolean n(String str) {
        h();
        q(str);
        C1050a2 R4 = R(str);
        if (R4 == null) {
            return false;
        }
        for (O1 o12 : R4.F()) {
            if (o12.G() == 3 && o12.I() == 3) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C1093f0 o(String str) {
        j();
        C0722p.e(str);
        C1392p N02 = this.f6129b.F0().N0(str);
        if (N02 == null) {
            return null;
        }
        this.f5730a.a().w().b("Populate EES config from database on cache miss. appId", str);
        s(str, t(str, N02.f6604a));
        return (C1093f0) this.f6022j.snapshot().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map p() {
        return this.f6016d;
    }

    /* access modifiers changed from: protected */
    public final C1104g2 w(String str) {
        j();
        h();
        C0722p.e(str);
        q(str);
        return (C1104g2) this.f6020h.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String x(String str) {
        h();
        q(str);
        return (String) this.f6024l.get(str);
    }

    /* access modifiers changed from: protected */
    public final String y(String str) {
        h();
        return (String) this.f6025m.get(str);
    }

    /* access modifiers changed from: protected */
    public final String z(String str) {
        h();
        return (String) this.f6026n.get(str);
    }
}
