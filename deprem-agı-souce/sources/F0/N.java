package f0;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class N extends C0732a {
    public static final Parcelable.Creator<N> CREATOR = new O();

    /* renamed from: a  reason: collision with root package name */
    public final List f15314a;

    N(List list) {
        this.f15314a = list;
    }

    public static N c(C1643K... kArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(kArr[0].A()));
        return new N(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        List list = this.f15314a;
        int a5 = C0734c.a(parcel);
        C0734c.l(parcel, 1, list, false);
        C0734c.b(parcel, a5);
    }
}
