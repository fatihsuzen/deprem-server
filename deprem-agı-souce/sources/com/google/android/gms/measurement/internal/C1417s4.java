package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.measurement.internal.s4  reason: case insensitive filesystem */
final /* synthetic */ class C1417s4 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C1452x4 f6706a;

    /* synthetic */ C1417s4(C1452x4 x4Var) {
        this.f6706a = x4Var;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.f6706a.T(sharedPreferences, str);
    }
}
