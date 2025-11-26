package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import f0.v;
import f0.w;
import j$.util.Objects;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.y  reason: case insensitive filesystem */
public final class C1454y {

    /* renamed from: f  reason: collision with root package name */
    public static final C1454y f6897f = new C1454y((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f6898a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6899b = l();

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f6900c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6901d;

    /* renamed from: e  reason: collision with root package name */
    private final EnumMap f6902e;

    C1454y(Boolean bool, int i5, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(w.class);
        this.f6902e = enumMap;
        enumMap.put(w.AD_USER_DATA, E3.h(bool));
        this.f6898a = i5;
        this.f6900c = bool2;
        this.f6901d = str;
    }

    static C1454y a(v vVar, int i5) {
        EnumMap enumMap = new EnumMap(w.class);
        enumMap.put(w.AD_USER_DATA, vVar);
        return new C1454y(enumMap, -10, (Boolean) null, (String) null);
    }

    public static C1454y g(String str) {
        if (str == null || str.length() <= 0) {
            return f6897f;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(w.class);
        w[] a5 = D3.DMA.a();
        int length = a5.length;
        int i5 = 1;
        int i6 = 0;
        while (i6 < length) {
            enumMap.put(a5[i6], E3.j(split[i5].charAt(0)));
            i6++;
            i5++;
        }
        return new C1454y(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static C1454y h(Bundle bundle, int i5) {
        Boolean bool = null;
        if (bundle == null) {
            return new C1454y((Boolean) null, i5, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(w.class);
        for (w wVar : D3.DMA.a()) {
            enumMap.put(wVar, E3.g(bundle.getString(wVar.f15331a)));
        }
        if (bundle.containsKey("is_dma_region")) {
            bool = Boolean.valueOf(bundle.getString("is_dma_region"));
        }
        return new C1454y(enumMap, i5, bool, bundle.getString("cps_display_str"));
    }

    public static Boolean i(Bundle bundle) {
        v g5;
        if (bundle == null || (g5 = E3.g(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int ordinal = g5.ordinal();
        if (ordinal == 2) {
            return Boolean.FALSE;
        }
        if (ordinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6898a);
        for (w wVar : D3.DMA.a()) {
            sb.append(":");
            sb.append(E3.m((v) this.f6902e.get(wVar)));
        }
        return sb.toString();
    }

    public final int b() {
        return this.f6898a;
    }

    public final v c() {
        v vVar = (v) this.f6902e.get(w.AD_USER_DATA);
        if (vVar == null) {
            return v.UNINITIALIZED;
        }
        return vVar;
    }

    public final boolean d() {
        for (v vVar : this.f6902e.values()) {
            if (vVar != v.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String e() {
        return this.f6899b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1454y)) {
            return false;
        }
        C1454y yVar = (C1454y) obj;
        if (!this.f6899b.equalsIgnoreCase(yVar.f6899b) || !Objects.equals(this.f6900c, yVar.f6900c)) {
            return false;
        }
        return Objects.equals(this.f6901d, yVar.f6901d);
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f6902e.entrySet()) {
            String i5 = E3.i((v) entry.getValue());
            if (i5 != null) {
                bundle.putString(((w) entry.getKey()).f15331a, i5);
            }
        }
        Boolean bool = this.f6900c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f6901d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final int hashCode() {
        int i5;
        int i6;
        Boolean bool = this.f6900c;
        if (bool == null) {
            i5 = 3;
        } else if (true != bool.booleanValue()) {
            i5 = 13;
        } else {
            i5 = 7;
        }
        String str = this.f6901d;
        if (str == null) {
            i6 = 17;
        } else {
            i6 = str.hashCode();
        }
        return this.f6899b.hashCode() + (i5 * 29) + (i6 * 137);
    }

    public final Boolean j() {
        return this.f6900c;
    }

    public final String k() {
        return this.f6901d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(E3.d(this.f6898a));
        for (w wVar : D3.DMA.a()) {
            sb.append(",");
            sb.append(wVar.f15331a);
            sb.append("=");
            v vVar = (v) this.f6902e.get(wVar);
            if (vVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = vVar.ordinal();
                if (ordinal == 0) {
                    sb.append("uninitialized");
                } else if (ordinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (ordinal == 2) {
                    sb.append("denied");
                } else if (ordinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f6900c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f6901d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    private C1454y(EnumMap enumMap, int i5, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(w.class);
        this.f6902e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f6898a = i5;
        this.f6900c = bool;
        this.f6901d = str;
    }
}
