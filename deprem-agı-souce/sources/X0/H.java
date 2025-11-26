package x0;

import kotlin.jvm.internal.t;

public final class H {

    /* renamed from: a  reason: collision with root package name */
    private final String f16816a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16817b;

    public H(String str, String str2) {
        this.f16816a = str;
        this.f16817b = str2;
    }

    public final String a() {
        return this.f16817b;
    }

    public final String b() {
        return this.f16816a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h5 = (H) obj;
        if (t.a(this.f16816a, h5.f16816a) && t.a(this.f16817b, h5.f16817b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        String str = this.f16816a;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i7 = i5 * 31;
        String str2 = this.f16817b;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i7 + i6;
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f16816a + ", authToken=" + this.f16817b + ')';
    }
}
