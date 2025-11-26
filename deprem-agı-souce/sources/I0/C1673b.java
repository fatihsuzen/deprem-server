package i0;

import L.j;
import O.C0732a;
import O.C0734c;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* renamed from: i0.b  reason: case insensitive filesystem */
public final class C1673b extends C0732a implements j {
    public static final Parcelable.Creator<C1673b> CREATOR = new C1674c();

    /* renamed from: a  reason: collision with root package name */
    final int f15372a;

    /* renamed from: b  reason: collision with root package name */
    private int f15373b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f15374c;

    C1673b(int i5, int i6, Intent intent) {
        this.f15372a = i5;
        this.f15373b = i6;
        this.f15374c = intent;
    }

    public final Status getStatus() {
        if (this.f15373b == 0) {
            return Status.f4849f;
        }
        return Status.f4853j;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f15372a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.j(parcel, 2, this.f15373b);
        C0734c.o(parcel, 3, this.f15374c, i5, false);
        C0734c.b(parcel, a5);
    }
}
