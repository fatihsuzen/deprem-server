package K2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;

public final class c implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List f18396a;

    public c(List list) {
        t.e(list, "disclosures");
        this.f18396a = list;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof c) && t.a(this.f18396a, ((c) obj).f18396a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18396a.hashCode();
    }

    public final String toString() {
        return "PartnersDisclosureArgs(disclosures=" + this.f18396a + ')';
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeList(new ArrayList());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.t.e(r5, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            java.lang.Class<v4.i> r3 = v4.i.class
            if (r1 < r2) goto L_0x001a
            java.lang.ClassLoader r1 = r3.getClassLoader()
            r5.readList(r0, r1, r3)
            goto L_0x0021
        L_0x001a:
            java.lang.ClassLoader r1 = r3.getClassLoader()
            r5.readList(r0, r1)
        L_0x0021:
            r4.<init>((java.util.List) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K2.c.<init>(android.os.Parcel):void");
    }
}
