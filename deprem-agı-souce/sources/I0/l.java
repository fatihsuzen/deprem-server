package i0;

import K.C0655b;
import N.O;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class l extends C0732a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    final int f15379a;

    /* renamed from: b  reason: collision with root package name */
    private final C0655b f15380b;

    /* renamed from: c  reason: collision with root package name */
    private final O f15381c;

    l(int i5, C0655b bVar, O o5) {
        this.f15379a = i5;
        this.f15380b = bVar;
        this.f15381c = o5;
    }

    public final C0655b c() {
        return this.f15380b;
    }

    public final O d() {
        return this.f15381c;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f15379a);
        C0734c.o(parcel, 2, this.f15380b, i5, false);
        C0734c.o(parcel, 3, this.f15381c, i5, false);
        C0734c.b(parcel, a5);
    }
}
