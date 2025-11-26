package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

public final class B {

    /* renamed from: a  reason: collision with root package name */
    final String f5744a;

    /* renamed from: b  reason: collision with root package name */
    final String f5745b;

    /* renamed from: c  reason: collision with root package name */
    final String f5746c;

    /* renamed from: d  reason: collision with root package name */
    final long f5747d;

    /* renamed from: e  reason: collision with root package name */
    final long f5748e;

    /* renamed from: f  reason: collision with root package name */
    final E f5749f;

    B(X2 x22, String str, String str2, String str3, long j5, long j6, Bundle bundle) {
        E e5;
        C0722p.e(str2);
        C0722p.e(str3);
        this.f5744a = str2;
        this.f5745b = str3;
        this.f5746c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5747d = j5;
        this.f5748e = j6;
        if (j6 != 0 && j6 > j5) {
            x22.a().r().b("Event created with reverse previous/current timestamps. appId", C1402q2.x(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            e5 = new E(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    x22.a().o().a("Param name can't be null");
                    it.remove();
                } else {
                    Object s5 = x22.C().s(next, bundle2.get(next));
                    if (s5 == null) {
                        x22.a().r().b("Param value can't be null", x22.D().b(next));
                        it.remove();
                    } else {
                        x22.C().A(bundle2, next, s5);
                    }
                }
            }
            e5 = new E(bundle2);
        }
        this.f5749f = e5;
    }

    /* access modifiers changed from: package-private */
    public final B a(X2 x22, long j5) {
        return new B(x22, this.f5746c, this.f5744a, this.f5745b, this.f5747d, j5, this.f5749f);
    }

    public final String toString() {
        String obj = this.f5749f.toString();
        String str = this.f5744a;
        int length = String.valueOf(str).length();
        String str2 = this.f5745b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + obj.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }

    private B(X2 x22, String str, String str2, String str3, long j5, long j6, E e5) {
        C0722p.e(str2);
        C0722p.e(str3);
        C0722p.k(e5);
        this.f5744a = str2;
        this.f5745b = str3;
        this.f5746c = true == TextUtils.isEmpty(str) ? null : str;
        this.f5747d = j5;
        this.f5748e = j6;
        if (j6 != 0 && j6 > j5) {
            x22.a().r().c("Event created with reverse previous/current timestamps. appId, name", C1402q2.x(str2), C1402q2.x(str3));
        }
        this.f5749f = e5;
    }
}
