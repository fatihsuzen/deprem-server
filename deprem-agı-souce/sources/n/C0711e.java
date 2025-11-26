package N;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: N.e  reason: case insensitive filesystem */
public class C0711e extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0711e> CREATOR = new k0();

    /* renamed from: a  reason: collision with root package name */
    private final r f3062a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3063b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3064c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f3065d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3066e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f3067f;

    public C0711e(r rVar, boolean z4, boolean z5, int[] iArr, int i5, int[] iArr2) {
        this.f3062a = rVar;
        this.f3063b = z4;
        this.f3064c = z5;
        this.f3065d = iArr;
        this.f3066e = i5;
        this.f3067f = iArr2;
    }

    public int c() {
        return this.f3066e;
    }

    public int[] d() {
        return this.f3065d;
    }

    public int[] f() {
        return this.f3067f;
    }

    public boolean g() {
        return this.f3063b;
    }

    public boolean i() {
        return this.f3064c;
    }

    public final r j() {
        return this.f3062a;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.o(parcel, 1, this.f3062a, i5, false);
        C0734c.c(parcel, 2, g());
        C0734c.c(parcel, 3, i());
        C0734c.k(parcel, 4, d(), false);
        C0734c.j(parcel, 5, c());
        C0734c.k(parcel, 6, f(), false);
        C0734c.b(parcel, a5);
    }
}
