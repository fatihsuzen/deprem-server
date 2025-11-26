package com.google.android.gms.measurement.internal;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.measurement.internal.g  reason: case insensitive filesystem */
public final class C1325g extends C0732a {
    public static final Parcelable.Creator<C1325g> CREATOR = new C1333h();

    /* renamed from: a  reason: collision with root package name */
    public final long f6420a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6421b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6422c;

    C1325g(long j5, int i5, long j6) {
        this.f6420a = j5;
        this.f6421b = i5;
        this.f6422c = j6;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        long j5 = this.f6420a;
        int a5 = C0734c.a(parcel);
        C0734c.m(parcel, 1, j5);
        C0734c.j(parcel, 2, this.f6421b);
        C0734c.m(parcel, 3, this.f6422c);
        C0734c.b(parcel, a5);
    }
}
