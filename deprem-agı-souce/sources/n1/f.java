package n1;

import j$.time.ZonedDateTime;
import o1.C1733b;
import p1.C1752a;
import p1.C1753b;

public class f extends C1725b {
    public f(ZonedDateTime zonedDateTime) {
        super(true);
        setValue(zonedDateTime);
    }

    public void b(String str) {
        try {
            this.f15615c = C1733b.a(str);
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1733b.b((ZonedDateTime) this.f15615c);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            return str.substring(i5, i5 + 36);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }
}
