package U2;

import J2.v;
import kotlin.jvm.internal.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f19303a;

    /* renamed from: b  reason: collision with root package name */
    public final String f19304b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19305c;

    public c(String str, String str2, String str3) {
        t.e(str, "country");
        t.e(str2, TtmlNode.TAG_REGION);
        t.e(str3, "city");
        this.f19303a = str;
        this.f19304b = str2;
        this.f19305c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (t.a(this.f19303a, cVar.f19303a) && t.a(this.f19304b, cVar.f19304b) && t.a(this.f19305c, cVar.f19305c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f19305c.hashCode() + v.a(this.f19304b, this.f19303a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "GeoIP(country=" + this.f19303a + ", region=" + this.f19304b + ", city=" + this.f19305c + ')';
    }
}
