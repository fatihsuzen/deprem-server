package v4;

import J2.v;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

public final class i implements Parcelable {
    public static final h CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public final String f26070a;

    /* renamed from: b  reason: collision with root package name */
    public final String f26071b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26072c;

    /* renamed from: d  reason: collision with root package name */
    public final String f26073d;

    /* renamed from: e  reason: collision with root package name */
    public final String f26074e;

    public i(String str, String str2, String str3, String str4, String str5) {
        t.e(str, RewardPlus.NAME);
        t.e(str2, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        t.e(str3, "maxAge");
        t.e(str4, "domain");
        t.e(str5, "purposes");
        this.f26070a = str;
        this.f26071b = str2;
        this.f26072c = str3;
        this.f26073d = str4;
        this.f26074e = str5;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (t.a(this.f26070a, iVar.f26070a) && t.a(this.f26071b, iVar.f26071b) && t.a(this.f26072c, iVar.f26072c) && t.a(this.f26073d, iVar.f26073d) && t.a(this.f26074e, iVar.f26074e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f26074e.hashCode() + v.a(this.f26073d, v.a(this.f26072c, v.a(this.f26071b, this.f26070a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "DisclosureInfo(name=" + this.f26070a + ", type=" + this.f26071b + ", maxAge=" + this.f26072c + ", domain=" + this.f26073d + ", purposes=" + this.f26074e + ')';
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeString(this.f26070a);
        parcel.writeString(this.f26071b);
        parcel.writeString(this.f26072c);
        parcel.writeString(this.f26073d);
        parcel.writeString(this.f26074e);
    }
}
