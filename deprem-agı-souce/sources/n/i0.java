package N;

import K.C0657d;
import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class i0 extends C0732a {
    public static final Parcelable.Creator<i0> CREATOR = new j0();

    /* renamed from: a  reason: collision with root package name */
    Bundle f3102a;

    /* renamed from: b  reason: collision with root package name */
    C0657d[] f3103b;

    /* renamed from: c  reason: collision with root package name */
    int f3104c;

    /* renamed from: d  reason: collision with root package name */
    C0711e f3105d;

    i0(Bundle bundle, C0657d[] dVarArr, int i5, C0711e eVar) {
        this.f3102a = bundle;
        this.f3103b = dVarArr;
        this.f3104c = i5;
        this.f3105d = eVar;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.e(parcel, 1, this.f3102a, false);
        C0734c.r(parcel, 2, this.f3103b, i5, false);
        C0734c.j(parcel, 3, this.f3104c);
        C0734c.o(parcel, 4, this.f3105d, i5, false);
        C0734c.b(parcel, a5);
    }
}
