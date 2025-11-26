package N;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class r extends C0732a {
    @NonNull
    public static final Parcelable.Creator<r> CREATOR = new b0();

    /* renamed from: a  reason: collision with root package name */
    private final int f3143a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3144b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3145c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3146d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3147e;

    public r(int i5, boolean z4, boolean z5, int i6, int i7) {
        this.f3143a = i5;
        this.f3144b = z4;
        this.f3145c = z5;
        this.f3146d = i6;
        this.f3147e = i7;
    }

    public int c() {
        return this.f3146d;
    }

    public int d() {
        return this.f3147e;
    }

    public boolean f() {
        return this.f3144b;
    }

    public boolean g() {
        return this.f3145c;
    }

    public int i() {
        return this.f3143a;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i());
        C0734c.c(parcel, 2, f());
        C0734c.c(parcel, 3, g());
        C0734c.j(parcel, 4, c());
        C0734c.j(parcel, 5, d());
        C0734c.b(parcel, a5);
    }
}
