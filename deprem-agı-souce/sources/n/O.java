package N;

import K.C0655b;
import N.C0716j;
import O.C0732a;
import O.C0734c;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class O extends C0732a {
    public static final Parcelable.Creator<O> CREATOR = new P();

    /* renamed from: a  reason: collision with root package name */
    final int f2997a;

    /* renamed from: b  reason: collision with root package name */
    final IBinder f2998b;

    /* renamed from: c  reason: collision with root package name */
    private final C0655b f2999c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3000d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3001e;

    O(int i5, IBinder iBinder, C0655b bVar, boolean z4, boolean z5) {
        this.f2997a = i5;
        this.f2998b = iBinder;
        this.f2999c = bVar;
        this.f3000d = z4;
        this.f3001e = z5;
    }

    public final C0655b c() {
        return this.f2999c;
    }

    public final C0716j d() {
        IBinder iBinder = this.f2998b;
        if (iBinder == null) {
            return null;
        }
        return C0716j.a.j(iBinder);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o5 = (O) obj;
        if (!this.f2999c.equals(o5.f2999c) || !C0720n.a(d(), o5.d())) {
            return false;
        }
        return true;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f2997a);
        C0734c.i(parcel, 2, this.f2998b, false);
        C0734c.o(parcel, 3, this.f2999c, i5, false);
        C0734c.c(parcel, 4, this.f3000d);
        C0734c.c(parcel, 5, this.f3001e);
        C0734c.b(parcel, a5);
    }
}
