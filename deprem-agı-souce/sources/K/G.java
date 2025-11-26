package K;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;

public final class G extends C0732a {
    public static final Parcelable.Creator<G> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2685a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2686b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2687c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2688d;

    G(boolean z4, String str, int i5, int i6) {
        this.f2685a = z4;
        this.f2686b = str;
        this.f2687c = N.a(i5) - 1;
        this.f2688d = t.a(i6) - 1;
    }

    public final String c() {
        return this.f2686b;
    }

    public final boolean d() {
        return this.f2685a;
    }

    public final int f() {
        return t.a(this.f2688d);
    }

    public final int g() {
        return N.a(this.f2687c);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.c(parcel, 1, this.f2685a);
        C0734c.p(parcel, 2, this.f2686b, false);
        C0734c.j(parcel, 3, this.f2687c);
        C0734c.j(parcel, 4, this.f2688d);
        C0734c.b(parcel, a5);
    }
}
