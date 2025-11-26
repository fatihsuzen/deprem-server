package n1;

import o1.C1741j;
import p1.C1752a;
import p1.C1753b;

public class l extends C1725b {

    /* renamed from: d  reason: collision with root package name */
    private int f15622d;

    public l(int i5, String str) {
        super(true);
        this.f15622d = i5;
        setValue(str);
    }

    public void b(String str) {
        try {
            this.f15615c = C1741j.a(str);
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1741j.b((String) this.f15615c, this.f15622d);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            return str.substring(i5, (this.f15622d * 6) + i5);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }
}
