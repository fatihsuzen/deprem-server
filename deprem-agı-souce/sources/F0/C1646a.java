package f0;

import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f0.a  reason: case insensitive filesystem */
public final class C1646a extends C0732a {
    public static final Parcelable.Creator<C1646a> CREATOR = new C1647b();

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f15315a;

    public C1646a(Bundle bundle) {
        this.f15315a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        Bundle bundle = this.f15315a;
        int a5 = C0734c.a(parcel);
        C0734c.e(parcel, 1, bundle, false);
        C0734c.b(parcel, a5);
    }
}
