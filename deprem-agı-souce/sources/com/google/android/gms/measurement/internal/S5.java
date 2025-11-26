package com.google.android.gms.measurement.internal;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class S5 extends C0732a {
    public static final Parcelable.Creator<S5> CREATOR = new T5();

    /* renamed from: a  reason: collision with root package name */
    public final String f6081a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6082b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6083c;

    S5(String str, long j5, int i5) {
        this.f6081a = str;
        this.f6082b = j5;
        this.f6083c = i5;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f6081a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 1, str, false);
        C0734c.m(parcel, 2, this.f6082b);
        C0734c.j(parcel, 3, this.f6083c);
        C0734c.b(parcel, a5);
    }
}
