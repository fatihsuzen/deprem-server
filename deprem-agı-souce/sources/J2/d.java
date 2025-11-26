package J2;

import kotlin.jvm.internal.t;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f18271a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18272b;

    public d(String str, String str2) {
        this.f18271a = str;
        this.f18272b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (t.a(this.f18271a, dVar.f18271a) && t.a(this.f18272b, dVar.f18272b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        String str = this.f18271a;
        int i6 = 0;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i7 = i5 * 31;
        String str2 = this.f18272b;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return "GPPEncodingResult(gppString=" + this.f18271a + ", tcString=" + this.f18272b + ')';
    }
}
