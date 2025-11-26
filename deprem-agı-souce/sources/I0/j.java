package i0;

import N.M;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class j extends C0732a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    final int f15377a;

    /* renamed from: b  reason: collision with root package name */
    final M f15378b;

    j(int i5, M m5) {
        this.f15377a = i5;
        this.f15378b = m5;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f15377a);
        C0734c.o(parcel, 2, this.f15378b, i5, false);
        C0734c.b(parcel, a5);
    }
}
