package H;

import O.C0732a;
import O.C0734c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: H.a  reason: case insensitive filesystem */
public class C0641a extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0641a> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f2484a;

    /* renamed from: b  reason: collision with root package name */
    private int f2485b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f2486c;

    C0641a(int i5, int i6, Bundle bundle) {
        this.f2484a = i5;
        this.f2485b = i6;
        this.f2486c = bundle;
    }

    public int c() {
        return this.f2485b;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, this.f2484a);
        C0734c.j(parcel, 2, c());
        C0734c.e(parcel, 3, this.f2486c, false);
        C0734c.b(parcel, a5);
    }
}
