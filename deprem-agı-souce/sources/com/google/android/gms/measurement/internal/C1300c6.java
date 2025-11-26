package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1186p3;
import f0.C1643K;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.c6  reason: case insensitive filesystem */
public final class C1300c6 {

    /* renamed from: a  reason: collision with root package name */
    private final String f6252a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f6253b;

    /* renamed from: c  reason: collision with root package name */
    private final C1643K f6254c;

    /* renamed from: d  reason: collision with root package name */
    private final C1186p3 f6255d;

    C1300c6(String str, Map map, C1643K k5, C1186p3 p3Var) {
        this.f6252a = str;
        this.f6253b = map;
        this.f6254c = k5;
        this.f6255d = p3Var;
    }

    public final String a() {
        return this.f6252a;
    }

    public final Map b() {
        Map map = this.f6253b;
        if (map == null) {
            return Collections.EMPTY_MAP;
        }
        return map;
    }

    public final C1643K c() {
        return this.f6254c;
    }

    public final C1186p3 d() {
        return this.f6255d;
    }
}
