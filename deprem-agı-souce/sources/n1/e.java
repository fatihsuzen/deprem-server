package n1;

import o1.C1732a;
import p1.C1752a;
import p1.C1753b;

public class e extends C1725b {
    public e(Boolean bool) {
        super(true);
        setValue(bool);
    }

    public void b(String str) {
        try {
            this.f15615c = Boolean.valueOf(C1732a.a(str));
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1732a.b((Boolean) this.f15615c);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            return str.substring(i5, i5 + 1);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }
}
