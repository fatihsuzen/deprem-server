package com.google.android.gms.measurement.internal;

import D.C0635a;
import android.content.pm.PackageManager;
import android.util.Pair;
import f0.w;
import j$.util.Objects;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.y5  reason: case insensitive filesystem */
public final class C1460y5 extends C1292b6 {

    /* renamed from: d  reason: collision with root package name */
    private final Map f6910d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final B2 f6911e;

    /* renamed from: f  reason: collision with root package name */
    public final B2 f6912f;

    /* renamed from: g  reason: collision with root package name */
    public final B2 f6913g;

    /* renamed from: h  reason: collision with root package name */
    public final B2 f6914h;

    /* renamed from: i  reason: collision with root package name */
    public final B2 f6915i;

    /* renamed from: j  reason: collision with root package name */
    public final B2 f6916j;

    C1460y5(q6 q6Var) {
        super(q6Var);
        E2 x4 = this.f5730a.x();
        Objects.requireNonNull(x4);
        this.f6911e = new B2(x4, "last_delete_stale", 0);
        E2 x5 = this.f5730a.x();
        Objects.requireNonNull(x5);
        this.f6912f = new B2(x5, "last_delete_stale_batch", 0);
        E2 x6 = this.f5730a.x();
        Objects.requireNonNull(x6);
        this.f6913g = new B2(x6, "backoff", 0);
        E2 x7 = this.f5730a.x();
        Objects.requireNonNull(x7);
        this.f6914h = new B2(x7, "last_upload", 0);
        E2 x8 = this.f5730a.x();
        Objects.requireNonNull(x8);
        this.f6915i = new B2(x8, "last_upload_attempt", 0);
        E2 x9 = this.f5730a.x();
        Objects.requireNonNull(x9);
        this.f6916j = new B2(x9, "midnight_offset", 0);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Pair m(String str, E3 e32) {
        if (e32.o(w.AD_STORAGE)) {
            return n(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    public final Pair n(String str) {
        C1453x5 x5Var;
        C0635a.C0043a aVar;
        h();
        X2 x22 = this.f5730a;
        long elapsedRealtime = x22.f().elapsedRealtime();
        C1453x5 x5Var2 = (C1453x5) this.f6910d.get(str);
        if (x5Var2 != null && elapsedRealtime < x5Var2.f6891c) {
            return new Pair(x5Var2.f6889a, Boolean.valueOf(x5Var2.f6890b));
        }
        C0635a.b(true);
        long D4 = x22.w().D(str, C1304d2.f6315b) + elapsedRealtime;
        try {
            aVar = C0635a.a(x22.e());
        } catch (PackageManager.NameNotFoundException unused) {
            aVar = null;
            if (x5Var2 != null) {
                try {
                    if (elapsedRealtime < x5Var2.f6891c + this.f5730a.w().D(str, C1304d2.f6318c)) {
                        return new Pair(x5Var2.f6889a, Boolean.valueOf(x5Var2.f6890b));
                    }
                } catch (Exception e5) {
                    this.f5730a.a().v().b("Unable to get advertising id", e5);
                    x5Var = new C1453x5("", false, D4);
                }
            }
        }
        if (aVar == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String a5 = aVar.a();
        if (a5 != null) {
            x5Var = new C1453x5(a5, aVar.b(), D4);
        } else {
            x5Var = new C1453x5("", aVar.b(), D4);
        }
        this.f6910d.put(str, x5Var);
        C0635a.b(false);
        return new Pair(x5Var.f6889a, Boolean.valueOf(x5Var.f6890b));
    }

    /* access modifiers changed from: package-private */
    public final String o(String str, boolean z4) {
        String str2;
        h();
        if (z4) {
            str2 = (String) n(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest C4 = z6.C();
        if (C4 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, C4.digest(str2.getBytes()))});
    }
}
