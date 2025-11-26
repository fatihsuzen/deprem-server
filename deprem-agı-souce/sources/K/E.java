package K;

import O.C0732a;
import O.C0734c;
import U.a;
import U.b;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class E extends C0732a {
    public static final Parcelable.Creator<E> CREATOR = new F();

    /* renamed from: a  reason: collision with root package name */
    private final String f2679a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2680b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f2681c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f2682d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2683e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2684f;

    E(String str, boolean z4, boolean z5, IBinder iBinder, boolean z6, boolean z7) {
        this.f2679a = str;
        this.f2680b = z4;
        this.f2681c = z5;
        this.f2682d = (Context) b.k(a.C0060a.j(iBinder));
        this.f2683e = z6;
        this.f2684f = z7;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [U.a, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i5) {
        String str = this.f2679a;
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 1, str, false);
        C0734c.c(parcel, 2, this.f2680b);
        C0734c.c(parcel, 3, this.f2681c);
        C0734c.i(parcel, 4, b.q0(this.f2682d), false);
        C0734c.c(parcel, 5, this.f2683e);
        C0734c.c(parcel, 6, this.f2684f);
        C0734c.b(parcel, a5);
    }
}
