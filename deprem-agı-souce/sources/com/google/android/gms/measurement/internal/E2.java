package com.google.android.gms.measurement.internal;

import D.C0635a;
import N.C0722p;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import f0.w;

final class E2 extends B3 {

    /* renamed from: A  reason: collision with root package name */
    static final Pair f5832A = new Pair("", 0L);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f5833c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences f5834d;

    /* renamed from: e  reason: collision with root package name */
    public C2 f5835e;

    /* renamed from: f  reason: collision with root package name */
    public final B2 f5836f = new B2(this, "first_open_time", 0);

    /* renamed from: g  reason: collision with root package name */
    public final B2 f5837g = new B2(this, "app_install_time", 0);

    /* renamed from: h  reason: collision with root package name */
    public final D2 f5838h = new D2(this, "app_instance_id", (String) null);

    /* renamed from: i  reason: collision with root package name */
    private String f5839i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5840j;

    /* renamed from: k  reason: collision with root package name */
    private long f5841k;

    /* renamed from: l  reason: collision with root package name */
    public final B2 f5842l = new B2(this, "session_timeout", 1800000);

    /* renamed from: m  reason: collision with root package name */
    public final C1464z2 f5843m = new C1464z2(this, "start_new_session", true);

    /* renamed from: n  reason: collision with root package name */
    public final D2 f5844n = new D2(this, "non_personalized_ads", (String) null);

    /* renamed from: o  reason: collision with root package name */
    public final A2 f5845o = new A2(this, "last_received_uri_timestamps_by_source", (Bundle) null);

    /* renamed from: p  reason: collision with root package name */
    public final C1464z2 f5846p = new C1464z2(this, "allow_remote_dynamite", false);

    /* renamed from: q  reason: collision with root package name */
    public final B2 f5847q = new B2(this, "last_pause_time", 0);

    /* renamed from: r  reason: collision with root package name */
    public final B2 f5848r = new B2(this, "session_id", 0);

    /* renamed from: s  reason: collision with root package name */
    public boolean f5849s;

    /* renamed from: t  reason: collision with root package name */
    public final C1464z2 f5850t = new C1464z2(this, "app_backgrounded", false);

    /* renamed from: u  reason: collision with root package name */
    public final C1464z2 f5851u = new C1464z2(this, "deep_link_retrieval_complete", false);

    /* renamed from: v  reason: collision with root package name */
    public final B2 f5852v = new B2(this, "deep_link_retrieval_attempts", 0);

    /* renamed from: w  reason: collision with root package name */
    public final D2 f5853w = new D2(this, "firebase_feature_rollouts", (String) null);

    /* renamed from: x  reason: collision with root package name */
    public final D2 f5854x = new D2(this, "deferred_attribution_cache", (String) null);

    /* renamed from: y  reason: collision with root package name */
    public final B2 f5855y = new B2(this, "deferred_attribution_cache_timestamp", 0);

    /* renamed from: z  reason: collision with root package name */
    public final A2 f5856z = new A2(this, "default_event_parameters", (Bundle) null);

    E2(X2 x22) {
        super(x22);
    }

    /* access modifiers changed from: package-private */
    public final boolean A(long j5) {
        if (j5 - this.f5842l.a() > this.f5847q.a()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void j() {
        X2 x22 = this.f5730a;
        SharedPreferences sharedPreferences = x22.e().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f5833c = sharedPreferences;
        boolean z4 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f5849s = z4;
        if (!z4) {
            SharedPreferences.Editor edit = this.f5833c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        x22.w();
        this.f5835e = new C2(this, "health_monitor", Math.max(0, ((Long) C1304d2.f6321d.b((Object) null)).longValue()), (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final Pair o(String str) {
        h();
        if (!w().o(w.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        X2 x22 = this.f5730a;
        long elapsedRealtime = x22.f().elapsedRealtime();
        String str2 = this.f5839i;
        if (str2 != null && elapsedRealtime < this.f5841k) {
            return new Pair(str2, Boolean.valueOf(this.f5840j));
        }
        this.f5841k = elapsedRealtime + x22.w().D(str, C1304d2.f6315b);
        C0635a.b(true);
        try {
            C0635a.C0043a a5 = C0635a.a(x22.e());
            this.f5839i = "";
            String a6 = a5.a();
            if (a6 != null) {
                this.f5839i = a6;
            }
            this.f5840j = a5.b();
        } catch (Exception e5) {
            this.f5730a.a().v().b("Unable to get advertising id", e5);
            this.f5839i = "";
        }
        C0635a.b(false);
        return new Pair(this.f5839i, Boolean.valueOf(this.f5840j));
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences p() {
        h();
        l();
        C0722p.k(this.f5833c);
        return this.f5833c;
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences q() {
        h();
        l();
        if (this.f5834d == null) {
            X2 x22 = this.f5730a;
            String valueOf = String.valueOf(x22.e().getPackageName());
            C1388o2 w4 = x22.a().w();
            String concat = valueOf.concat("_preferences");
            w4.b("Default prefs file", concat);
            this.f5834d = x22.e().getSharedPreferences(concat, 0);
        }
        return this.f5834d;
    }

    /* access modifiers changed from: package-private */
    public final SparseArray r() {
        Bundle a5 = this.f5845o.a();
        int[] intArray = a5.getIntArray("uriSources");
        long[] longArray = a5.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.f5730a.a().o().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i5 = 0; i5 < intArray.length; i5++) {
            sparseArray.put(intArray[i5], Long.valueOf(longArray[i5]));
        }
        return sparseArray;
    }

    /* access modifiers changed from: package-private */
    public final void s(Boolean bool) {
        h();
        SharedPreferences.Editor edit = p().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final Boolean t() {
        h();
        if (p().contains("measurement_enabled")) {
            return Boolean.valueOf(p().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final C1454y u() {
        h();
        return C1454y.g(p().getString("dma_consent_settings", (String) null));
    }

    /* access modifiers changed from: package-private */
    public final boolean v(int i5) {
        return E3.u(i5, p().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    public final E3 w() {
        h();
        return E3.f(p().getString("consent_settings", "G1"), p().getInt("consent_source", 100));
    }

    /* access modifiers changed from: protected */
    public final boolean x(O5 o5) {
        h();
        String string = p().getString("stored_tcf_param", "");
        String a5 = o5.a();
        if (a5.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = p().edit();
        edit.putString("stored_tcf_param", a5);
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void y(boolean z4) {
        h();
        this.f5730a.a().w().b("App measurement setting deferred collection", Boolean.valueOf(z4));
        SharedPreferences.Editor edit = p().edit();
        edit.putBoolean("deferred_analytics_collection", z4);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean z() {
        SharedPreferences sharedPreferences = this.f5833c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }
}
