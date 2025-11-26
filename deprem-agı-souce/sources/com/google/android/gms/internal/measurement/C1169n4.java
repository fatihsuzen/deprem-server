package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.measurement.n4  reason: case insensitive filesystem */
final /* synthetic */ class C1169n4 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1178o4 f5484a;

    /* synthetic */ C1169n4(C1178o4 o4Var) {
        this.f5484a = o4Var;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f5484a.d(sharedPreferences, str);
    }
}
