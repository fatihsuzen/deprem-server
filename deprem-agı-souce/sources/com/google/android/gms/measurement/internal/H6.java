package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.mbridge.msdk.MBridgeConstans;

public final class H6 {

    /* renamed from: a  reason: collision with root package name */
    private final X2 f5913a;

    public H6(X2 x22) {
        this.f5913a = x22;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        String str;
        X2 x22 = this.f5913a;
        x22.b().h();
        if (e()) {
            if (d()) {
                x22.x().f5854x.b((String) null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                x22.B().t("auto", "_cmpx", bundle);
            } else {
                String a5 = x22.x().f5854x.a();
                if (TextUtils.isEmpty(a5)) {
                    x22.a().p().a("Cache still valid but referrer not found");
                } else {
                    long a6 = x22.x().f5855y.a() / 3600000;
                    Uri parse = Uri.parse(a5);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", (a6 - 1) * 3600000);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
                    } else {
                        str = (String) obj;
                    }
                    x22.B().t(str, "_cmp", (Bundle) pair.second);
                }
                x22.x().f5854x.b((String) null);
            }
            x22.x().f5855y.b(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, Bundle bundle) {
        String str2;
        X2 x22 = this.f5913a;
        x22.b().h();
        if (!x22.g()) {
            if (bundle.isEmpty()) {
                str2 = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String next : bundle.keySet()) {
                    builder.appendQueryParameter(next, bundle.getString(next));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                x22.x().f5854x.b(str2);
                x22.x().f5855y.b(x22.f().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (e() && d()) {
            this.f5913a.x().f5854x.b((String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        if (!e()) {
            return false;
        }
        X2 x22 = this.f5913a;
        if (x22.f().currentTimeMillis() - x22.x().f5855y.a() > x22.w().D((String) null, C1304d2.f6343k0)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        if (this.f5913a.x().f5855y.a() > 0) {
            return true;
        }
        return false;
    }
}
