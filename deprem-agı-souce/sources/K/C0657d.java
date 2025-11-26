package K;

import N.C0720n;
import O.C0732a;
import O.C0734c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.RewardPlus;

/* renamed from: K.d  reason: case insensitive filesystem */
public class C0657d extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0657d> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final String f2709a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2710b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2711c;

    public C0657d(String str, int i5, long j5) {
        this.f2709a = str;
        this.f2710b = i5;
        this.f2711c = j5;
    }

    public String c() {
        return this.f2709a;
    }

    public long d() {
        long j5 = this.f2711c;
        if (j5 == -1) {
            return (long) this.f2710b;
        }
        return j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0657d) {
            C0657d dVar = (C0657d) obj;
            if (((c() == null || !c().equals(dVar.c())) && (c() != null || dVar.c() != null)) || d() != dVar.d()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C0720n.b(c(), Long.valueOf(d()));
    }

    public final String toString() {
        C0720n.a c5 = C0720n.c(this);
        c5.a(RewardPlus.NAME, c());
        c5.a("version", Long.valueOf(d()));
        return c5.toString();
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.p(parcel, 1, c(), false);
        C0734c.j(parcel, 2, this.f2710b);
        C0734c.m(parcel, 3, d());
        C0734c.b(parcel, a5);
    }

    public C0657d(String str, long j5) {
        this.f2709a = str;
        this.f2711c = j5;
        this.f2710b = -1;
    }
}
