package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.measurement.j0  reason: case insensitive filesystem */
public final class C1129j0 implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    private final Map f5388a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set f5389b = new HashSet();

    private final Object c(String str, Object obj) {
        Object obj2 = this.f5388a.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map a() {
        return this.f5388a;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Set b() {
        return this.f5389b;
    }

    public final boolean contains(String str) {
        return this.f5388a.containsKey(str);
    }

    public final SharedPreferences.Editor edit() {
        return new C1120i0(this, (byte[]) null);
    }

    public final Map getAll() {
        return this.f5388a;
    }

    public final boolean getBoolean(String str, boolean z4) {
        return ((Boolean) c(str, Boolean.valueOf(z4))).booleanValue();
    }

    public final float getFloat(String str, float f5) {
        return ((Float) c(str, Float.valueOf(f5))).floatValue();
    }

    public final int getInt(String str, int i5) {
        return ((Integer) c(str, Integer.valueOf(i5))).intValue();
    }

    public final long getLong(String str, long j5) {
        return ((Long) c(str, Long.valueOf(j5))).longValue();
    }

    public final String getString(String str, String str2) {
        return (String) c(str, str2);
    }

    public final Set getStringSet(String str, Set set) {
        return (Set) c(str, set);
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5389b.add(onSharedPreferenceChangeListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5389b.remove(onSharedPreferenceChangeListener);
    }
}
