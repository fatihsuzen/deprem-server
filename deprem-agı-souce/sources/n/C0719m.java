package N;

import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: N.m  reason: case insensitive filesystem */
public class C0719m extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0719m> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    private final int f3106a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3107b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3108c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3109d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3110e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3111f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3112g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3113h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3114i;

    public C0719m(int i5, int i6, int i7, long j5, long j6, String str, String str2, int i8, int i9) {
        this.f3106a = i5;
        this.f3107b = i6;
        this.f3108c = i7;
        this.f3109d = j5;
        this.f3110e = j6;
        this.f3111f = str;
        this.f3112g = str2;
        this.f3113h = i8;
        this.f3114i = i9;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.f3106a;
        int a5 = C0734c.a(parcel);
        C0734c.j(parcel, 1, i6);
        C0734c.j(parcel, 2, this.f3107b);
        C0734c.j(parcel, 3, this.f3108c);
        C0734c.m(parcel, 4, this.f3109d);
        C0734c.m(parcel, 5, this.f3110e);
        C0734c.p(parcel, 6, this.f3111f, false);
        C0734c.p(parcel, 7, this.f3112g, false);
        C0734c.j(parcel, 8, this.f3113h);
        C0734c.j(parcel, 9, this.f3114i);
        C0734c.b(parcel, a5);
    }
}
