package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import j$.util.Objects;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import m0.w;
import m0.z;

/* renamed from: com.google.android.gms.internal.measurement.i0  reason: case insensitive filesystem */
final class C1120i0 implements SharedPreferences.Editor {

    /* renamed from: a  reason: collision with root package name */
    boolean f5372a = false;

    /* renamed from: b  reason: collision with root package name */
    final Set f5373b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    final Map f5374c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C1129j0 f5375d;

    /* synthetic */ C1120i0(C1129j0 j0Var, byte[] bArr) {
        Objects.requireNonNull(j0Var);
        this.f5375d = j0Var;
    }

    private final void a(String str, Object obj) {
        if (obj != null) {
            this.f5374c.put(str, obj);
        } else {
            remove(str);
        }
    }

    public final void apply() {
        commit();
    }

    public final SharedPreferences.Editor clear() {
        this.f5372a = true;
        return this;
    }

    public final boolean commit() {
        if (this.f5372a) {
            this.f5375d.a().clear();
        }
        C1129j0 j0Var = this.f5375d;
        Set set = this.f5373b;
        j0Var.a().keySet().removeAll(set);
        Map map = this.f5374c;
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            j0Var.a().put((String) entry.getKey(), value);
        }
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : j0Var.b()) {
            z c5 = w.c(set, map.keySet()).c();
            while (c5.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(j0Var, (String) c5.next());
            }
        }
        if (this.f5372a || !set.isEmpty() || !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public final SharedPreferences.Editor putBoolean(String str, boolean z4) {
        a(str, Boolean.valueOf(z4));
        return this;
    }

    public final SharedPreferences.Editor putFloat(String str, float f5) {
        a(str, Float.valueOf(f5));
        return this;
    }

    public final SharedPreferences.Editor putInt(String str, int i5) {
        a(str, Integer.valueOf(i5));
        return this;
    }

    public final SharedPreferences.Editor putLong(String str, long j5) {
        a(str, Long.valueOf(j5));
        return this;
    }

    public final SharedPreferences.Editor putString(String str, String str2) {
        a(str, str2);
        return this;
    }

    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        a(str, set);
        return this;
    }

    public final SharedPreferences.Editor remove(String str) {
        this.f5373b.add(str);
        return this;
    }
}
