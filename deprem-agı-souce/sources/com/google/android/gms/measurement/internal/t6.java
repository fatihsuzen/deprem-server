package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.C1186p3;
import com.google.android.gms.internal.measurement.Y2;
import f0.C1643K;
import java.util.Map;

public final class t6 {

    /* renamed from: a  reason: collision with root package name */
    private final long f6740a;

    /* renamed from: b  reason: collision with root package name */
    private final Y2 f6741b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6742c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f6743d;

    /* renamed from: e  reason: collision with root package name */
    private final C1643K f6744e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6745f;

    /* renamed from: g  reason: collision with root package name */
    private final long f6746g;

    /* renamed from: h  reason: collision with root package name */
    private final long f6747h;

    /* renamed from: i  reason: collision with root package name */
    private final int f6748i;

    /* synthetic */ t6(long j5, Y2 y22, String str, Map map, C1643K k5, long j6, long j7, long j8, int i5, byte[] bArr) {
        this.f6740a = j5;
        this.f6741b = y22;
        this.f6742c = str;
        this.f6743d = map;
        this.f6744e = k5;
        this.f6745f = j6;
        this.f6746g = j7;
        this.f6747h = j8;
        this.f6748i = i5;
    }

    public final C1300c6 a() {
        return new C1300c6(this.f6742c, this.f6743d, this.f6744e, (C1186p3) null);
    }

    public final X5 b() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f6743d.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j5 = this.f6740a;
        Y2 y22 = this.f6741b;
        String str = this.f6742c;
        C1643K k5 = this.f6744e;
        long j6 = this.f6746g;
        return new X5(j5, y22.e(), str, bundle, k5.A(), j6, "");
    }

    public final long c() {
        return this.f6740a;
    }

    public final Y2 d() {
        return this.f6741b;
    }

    public final String e() {
        return this.f6742c;
    }

    public final C1643K f() {
        return this.f6744e;
    }

    public final long g() {
        return this.f6745f;
    }

    public final long h() {
        return this.f6747h;
    }

    public final int i() {
        return this.f6748i;
    }
}
