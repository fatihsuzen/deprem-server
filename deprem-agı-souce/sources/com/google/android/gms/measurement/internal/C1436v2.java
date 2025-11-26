package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.google.android.gms.internal.measurement.Y2;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.v2  reason: case insensitive filesystem */
public final class C1436v2 extends C1292b6 {
    public C1436v2(q6 q6Var) {
        super(q6Var);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    public final boolean m() {
        j();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f5730a.e().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public final void n(String str, C1300c6 c6Var, Y2 y22, C1415s2 s2Var) {
        String str2;
        C1436v2 v2Var;
        h();
        j();
        try {
            URL url = new URI(c6Var.a()).toURL();
            this.f6129b.K0();
            byte[] e5 = y22.e();
            v2Var = this;
            str2 = str;
            try {
                this.f5730a.b().w(new C1429u2(v2Var, str2, url, e5, c6Var.b(), s2Var));
            } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
                v2Var.f5730a.a().o().c("Failed to parse URL. Not uploading MeasurementBatch. appId", C1402q2.x(str2), c6Var.a());
            }
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            v2Var = this;
            str2 = str;
            v2Var.f5730a.a().o().c("Failed to parse URL. Not uploading MeasurementBatch. appId", C1402q2.x(str2), c6Var.a());
        }
    }

    public final void o(C1443w2 w2Var, Map map, C1415s2 s2Var) {
        C1436v2 v2Var;
        h();
        j();
        C0722p.k(w2Var);
        C0722p.k(s2Var);
        C1308d6 C02 = this.f6129b.C0();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendQueryParameter = builder.scheme((String) C1304d2.f6327f.b((Object) null)).encodedAuthority((String) C1304d2.f6330g.b((Object) null)).path("config/app/".concat(String.valueOf(w2Var.r0()))).appendQueryParameter("platform", "android");
        C02.f5730a.w().A();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(133005)).appendQueryParameter("runtime_version", "0");
        String uri = builder.build().toString();
        try {
            URL url = new URI(uri).toURL();
            v2Var = this;
            try {
                this.f5730a.b().w(new C1429u2(v2Var, w2Var.o0(), url, (byte[]) null, map, s2Var));
            } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
                v2Var.f5730a.a().o().c("Failed to parse config URL. Not fetching. appId", C1402q2.x(w2Var.o0()), uri);
            }
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            v2Var = this;
            v2Var.f5730a.a().o().c("Failed to parse config URL. Not fetching. appId", C1402q2.x(w2Var.o0()), uri);
        }
    }
}
