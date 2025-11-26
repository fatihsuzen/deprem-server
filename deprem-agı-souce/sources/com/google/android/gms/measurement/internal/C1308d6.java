package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C1104g2;
import com.google.android.gms.internal.measurement.C1123i3;
import com.google.android.gms.internal.measurement.C1141k3;
import com.google.android.gms.internal.measurement.C1186p3;
import f0.C1643K;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.measurement.internal.d6  reason: case insensitive filesystem */
public final class C1308d6 extends W5 {
    C1308d6(q6 q6Var) {
        super(q6Var);
    }

    private final String k(String str) {
        String x4 = this.f6129b.D0().x(str);
        if (TextUtils.isEmpty(x4)) {
            return (String) C1304d2.f6358r.b((Object) null);
        }
        Uri parse = Uri.parse((String) C1304d2.f6358r.b((Object) null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(x4).length() + 1 + String.valueOf(authority).length());
        sb.append(x4);
        sb.append(".");
        sb.append(authority);
        buildUpon.authority(sb.toString());
        return buildUpon.build().toString();
    }

    private static final boolean l(String str) {
        String str2 = (String) C1304d2.f6362t.b((Object) null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String trim : str2.split(",")) {
            if (str.equalsIgnoreCase(trim.trim())) {
                return true;
            }
        }
        return false;
    }

    public final C1300c6 i(String str) {
        C1443w2 J02;
        q6 q6Var = this.f6129b;
        C1443w2 J03 = q6Var.F0().J0(str);
        C1300c6 c6Var = null;
        if (J03 == null || !J03.V()) {
            return new C1300c6(k(str), Collections.EMPTY_MAP, C1643K.GOOGLE_ANALYTICS, (C1186p3) null);
        }
        C1123i3 G4 = C1186p3.G();
        G4.s(2);
        G4.r((C1141k3) C0722p.k(C1141k3.a(J03.M())));
        String p02 = J03.p0();
        C1104g2 w4 = q6Var.D0().w(str);
        if (w4 == null || (J02 = q6Var.F0().J0(str)) == null || ((!w4.T() || w4.U().H() != 100) && !this.f5730a.C().P(str, J02.l0()) && (TextUtils.isEmpty(p02) || Math.abs(p02.hashCode() % 100) >= w4.U().H()))) {
            G4.t(3);
            return new C1300c6(k(str), Collections.EMPTY_MAP, C1643K.GOOGLE_ANALYTICS, (C1186p3) G4.o());
        }
        String o02 = J03.o0();
        G4.s(2);
        C1104g2 w5 = q6Var.D0().w(J03.o0());
        if (w5 == null || !w5.T()) {
            this.f5730a.a().w().b("[sgtm] Missing sgtm_setting in remote config. appId", o02);
            G4.t(4);
        } else {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(J03.l0())) {
                hashMap.put("x-gtm-server-preview", J03.l0());
            }
            String I4 = w5.U().I();
            C1141k3 a5 = C1141k3.a(J03.M());
            if (a5 != null && a5 != C1141k3.CLIENT_UPLOAD_ELIGIBLE) {
                G4.r(a5);
            } else if (l(J03.o0())) {
                G4.r(C1141k3.PINNED_TO_SERVICE_UPLOAD);
            } else if (TextUtils.isEmpty(I4)) {
                G4.r(C1141k3.MISSING_SGTM_SERVER_URL);
            } else {
                this.f5730a.a().w().b("[sgtm] Eligible for client side upload. appId", o02);
                G4.s(3);
                G4.r(C1141k3.CLIENT_UPLOAD_ELIGIBLE);
                c6Var = new C1300c6(I4, hashMap, C1643K.SGTM_CLIENT, (C1186p3) G4.o());
            }
            w5.U().F();
            w5.U().G();
            X2 x22 = this.f5730a;
            x22.c();
            if (!TextUtils.isEmpty(I4)) {
                x22.a().w().b("[sgtm] Eligible for local service direct upload. appId", o02);
                G4.s(5);
                G4.t(2);
                c6Var = new C1300c6(I4, hashMap, C1643K.SGTM, (C1186p3) G4.o());
            } else {
                G4.t(6);
                x22.a().w().b("[sgtm] Local service, missing sgtm_server_url", J03.o0());
            }
        }
        if (c6Var != null) {
            return c6Var;
        }
        return new C1300c6(k(str), Collections.EMPTY_MAP, C1643K.GOOGLE_ANALYTICS, (C1186p3) G4.o());
    }

    /* access modifiers changed from: package-private */
    public final boolean j(String str, C1141k3 k3Var) {
        C1104g2 w4;
        h();
        if (k3Var != C1141k3.CLIENT_UPLOAD_ELIGIBLE || l(str) || (w4 = this.f6129b.D0().w(str)) == null || !w4.T() || w4.U().I().isEmpty()) {
            return false;
        }
        return true;
    }
}
