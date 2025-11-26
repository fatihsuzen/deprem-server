package com.google.android.gms.measurement.internal;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class Z5 extends C0732a {
    public static final Parcelable.Creator<Z5> CREATOR = new C1284a6();

    /* renamed from: a  reason: collision with root package name */
    public final List f6203a;

    Z5(List list) {
        this.f6203a = list;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        List list = this.f6203a;
        int a5 = C0734c.a(parcel);
        C0734c.s(parcel, 1, list, false);
        C0734c.b(parcel, a5);
    }
}
