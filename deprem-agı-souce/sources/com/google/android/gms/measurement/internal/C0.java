package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Map;

public final class C0 extends E1 {

    /* renamed from: b  reason: collision with root package name */
    private final Map f5802b = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map f5803c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    private long f5804d;

    public C0(X2 x22) {
        super(x22);
    }

    private final void o(long j5, E4 e42) {
        if (e42 == null) {
            this.f5730a.a().w().a("Not logging ad exposure. No active activity");
        } else if (j5 < 1000) {
            this.f5730a.a().w().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j5));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j5);
            z6.k0(e42, bundle, true);
            this.f5730a.B().t("am", "_xa", bundle);
        }
    }

    private final void p(String str, long j5, E4 e42) {
        if (e42 == null) {
            this.f5730a.a().w().a("Not logging ad unit exposure. No active activity");
        } else if (j5 < 1000) {
            this.f5730a.a().w().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j5));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j5);
            z6.k0(e42, bundle, true);
            this.f5730a.B().t("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public final void n(long j5) {
        Map map = this.f5802b;
        for (String put : map.keySet()) {
            map.put(put, Long.valueOf(j5));
        }
        if (!map.isEmpty()) {
            this.f5804d = j5;
        }
    }

    public final void i(String str, long j5) {
        if (str == null || str.length() == 0) {
            this.f5730a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f5730a.b().t(new C1277a(this, str, j5));
        }
    }

    public final void j(String str, long j5) {
        if (str == null || str.length() == 0) {
            this.f5730a.a().o().a("Ad unit id must be a non-empty string");
        } else {
            this.f5730a.b().t(new C1461z(this, str, j5));
        }
    }

    public final void k(long j5) {
        E4 q5 = this.f5730a.I().q(false);
        Map map = this.f5802b;
        for (String str : map.keySet()) {
            p(str, j5 - ((Long) map.get(str)).longValue(), q5);
        }
        if (!map.isEmpty()) {
            o(j5 - this.f5804d, q5);
        }
        n(j5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void l(String str, long j5) {
        h();
        C0722p.e(str);
        Map map = this.f5803c;
        if (map.isEmpty()) {
            this.f5804d = j5;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.f5730a.a().r().a("Too many ads visible");
        } else {
            map.put(str, 1);
            this.f5802b.put(str, Long.valueOf(j5));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void m(String str, long j5) {
        h();
        C0722p.e(str);
        Map map = this.f5803c;
        Integer num = (Integer) map.get(str);
        if (num != null) {
            E4 q5 = this.f5730a.I().q(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                map.remove(str);
                Map map2 = this.f5802b;
                Long l5 = (Long) map2.get(str);
                if (l5 == null) {
                    this.f5730a.a().o().a("First ad unit exposure time was never set");
                } else {
                    map2.remove(str);
                    p(str, j5 - l5.longValue(), q5);
                }
                if (map.isEmpty()) {
                    long j6 = this.f5804d;
                    if (j6 == 0) {
                        this.f5730a.a().o().a("First ad exposure time was never set");
                        return;
                    }
                    o(j5 - j6, q5);
                    this.f5804d = 0;
                    return;
                }
                return;
            }
            map.put(str, Integer.valueOf(intValue));
            return;
        }
        this.f5730a.a().o().b("Call to endAdUnitExposure for unknown ad unit id", str);
    }
}
