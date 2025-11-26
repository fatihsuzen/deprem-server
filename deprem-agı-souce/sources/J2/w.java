package J2;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.t;

public final class w extends Throwable {

    /* renamed from: a  reason: collision with root package name */
    public final String f18340a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18341b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18342c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(String str, String str2, String str3) {
        super("invalid value " + str2 + " passed for " + str + ' ' + str3);
        t.e(str, "fieldName");
        t.e(str2, "fieldValue");
        t.e(str3, NotificationCompat.CATEGORY_MESSAGE);
        this.f18340a = str;
        this.f18341b = str2;
        this.f18342c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (t.a(this.f18340a, wVar.f18340a) && t.a(this.f18341b, wVar.f18341b) && t.a(this.f18342c, wVar.f18342c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f18342c.hashCode() + v.a(this.f18341b, this.f18340a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "TCModelError(fieldName=" + this.f18340a + ", fieldValue=" + this.f18341b + ", msg=" + this.f18342c + ')';
    }
}
