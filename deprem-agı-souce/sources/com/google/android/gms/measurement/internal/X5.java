package com.google.android.gms.measurement.internal;

import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class X5 extends C0732a {
    public static final Parcelable.Creator<X5> CREATOR = new Y5();

    /* renamed from: a  reason: collision with root package name */
    public final long f6168a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f6169b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6170c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f6171d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6172e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6173f;

    /* renamed from: g  reason: collision with root package name */
    public String f6174g;

    X5(long j5, byte[] bArr, String str, Bundle bundle, int i5, long j6, String str2) {
        this.f6168a = j5;
        this.f6169b = bArr;
        this.f6170c = str;
        this.f6171d = bundle;
        this.f6172e = i5;
        this.f6173f = j6;
        this.f6174g = str2;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        long j5 = this.f6168a;
        int a5 = C0734c.a(parcel);
        C0734c.m(parcel, 1, j5);
        C0734c.f(parcel, 2, this.f6169b, false);
        C0734c.p(parcel, 3, this.f6170c, false);
        C0734c.e(parcel, 4, this.f6171d, false);
        C0734c.j(parcel, 5, this.f6172e);
        C0734c.m(parcel, 6, this.f6173f);
        C0734c.p(parcel, 7, this.f6174g, false);
        C0734c.b(parcel, a5);
    }
}
