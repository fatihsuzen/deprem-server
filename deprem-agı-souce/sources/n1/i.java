package n1;

import o1.C1737f;
import p1.C1752a;
import p1.C1753b;

public class i extends C1725b {

    /* renamed from: d  reason: collision with root package name */
    private int f15619d;

    public i(int i5, Integer num) {
        super(true);
        this.f15619d = i5;
        setValue(num);
    }

    public void b(String str) {
        try {
            this.f15615c = Integer.valueOf(C1737f.a(str));
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1737f.b(((Integer) this.f15615c).intValue(), this.f15619d);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            return str.substring(i5, this.f15619d + i5);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }
}
