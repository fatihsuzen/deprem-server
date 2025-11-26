package R2;

import X2.C2250q;
import java.util.List;
import kotlin.jvm.internal.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f18953a;

    /* renamed from: b  reason: collision with root package name */
    public final a f18954b;

    /* renamed from: c  reason: collision with root package name */
    public final List f18955c;

    public c(String str, a aVar, List list) {
        t.e(aVar, "banner");
        t.e(list, "purposes");
        this.f18953a = str;
        this.f18954b = aVar;
        this.f18955c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (t.a(this.f18953a, cVar.f18953a) && t.a(this.f18954b, cVar.f18954b) && t.a(this.f18955c, cVar.f18955c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        String str = this.f18953a;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int hashCode = this.f18954b.hashCode();
        return this.f18955c.hashCode() + ((hashCode + (i5 * 31)) * 31);
    }

    public final String toString() {
        return "GBCPurposeResponse(language=" + this.f18953a + ", banner=" + this.f18954b + ", purposes=" + this.f18955c + ')';
    }

    public /* synthetic */ c() {
        this("", new a((String) null, (String) null, 15), C2250q.g());
    }
}
