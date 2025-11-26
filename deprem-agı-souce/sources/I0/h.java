package i0;

import L.j;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class h extends C0732a implements j {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final List f15375a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15376b;

    public h(List list, String str) {
        this.f15375a = list;
        this.f15376b = str;
    }

    public final Status getStatus() {
        if (this.f15376b != null) {
            return Status.f4849f;
        }
        return Status.f4853j;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        List list = this.f15375a;
        int a5 = C0734c.a(parcel);
        C0734c.q(parcel, 1, list, false);
        C0734c.p(parcel, 2, this.f15376b, false);
        C0734c.b(parcel, a5);
    }
}
