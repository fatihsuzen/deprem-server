package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.r2  reason: case insensitive filesystem */
public final class C1408r2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f6689a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6690b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6691c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f6692d;

    public C1408r2(String str, String str2, Bundle bundle, long j5) {
        this.f6689a = str;
        this.f6690b = str2;
        this.f6692d = bundle;
        this.f6691c = j5;
    }

    public static C1408r2 a(G g5) {
        return new C1408r2(g5.f5883a, g5.f5885c, g5.f5884b.j(), g5.f5886d);
    }

    public final G b() {
        return new G(this.f6689a, new E(new Bundle(this.f6692d)), this.f6690b, this.f6691c);
    }

    public final String toString() {
        String str = this.f6690b;
        String obj = this.f6692d.toString();
        int length = String.valueOf(str).length();
        String str2 = this.f6689a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + obj.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(obj);
        return sb.toString();
    }
}
