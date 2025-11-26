package N;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: N.t  reason: case insensitive filesystem */
public class C0725t extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0725t> CREATOR = new C0729x();

    /* renamed from: a  reason: collision with root package name */
    private final int f3153a;

    /* renamed from: b  reason: collision with root package name */
    private List f3154b;

    public C0725t(int i5, List list) {
        this.f3153a = i5;
        this.f3154b = list;
    }

    public final int c() {
        return this.f3153a;
    }

    public final List d() {
        return this.f3154b;
    }

    public final void f(C0719m mVar) {
        if (this.f3154b == null) {
            this.f3154b = new ArrayList();
        }
        this.f3154b.add(mVar);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f3153a);
        C0734c.s(parcel, 2, this.f3154b, false);
        C0734c.b(parcel, a5);
    }
}
