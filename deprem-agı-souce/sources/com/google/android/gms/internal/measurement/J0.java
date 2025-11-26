package com.google.android.gms.internal.measurement;

import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class J0 extends C0732a {
    public static final Parcelable.Creator<J0> CREATOR = new K0();

    /* renamed from: a  reason: collision with root package name */
    public final long f4985a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4986b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4987c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f4988d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4989e;

    public J0(long j5, long j6, boolean z4, Bundle bundle, String str) {
        this.f4985a = j5;
        this.f4986b = j6;
        this.f4987c = z4;
        this.f4988d = bundle;
        this.f4989e = str;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        long j5 = this.f4985a;
        int a5 = C0734c.a(parcel);
        C0734c.m(parcel, 1, j5);
        C0734c.m(parcel, 2, this.f4986b);
        C0734c.c(parcel, 3, this.f4987c);
        C0734c.e(parcel, 7, this.f4988d, false);
        C0734c.p(parcel, 8, this.f4989e, false);
        C0734c.b(parcel, a5);
    }
}
