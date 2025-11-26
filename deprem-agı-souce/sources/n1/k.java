package n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import o1.C1737f;
import o1.C1739h;
import p1.C1752a;
import p1.C1753b;

public class k extends C1725b {
    protected k() {
        super(true);
    }

    public void b(String str) {
        try {
            this.f15615c = C1739h.a(str);
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1739h.b((List) this.f15615c);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        int i6 = i5 + 12;
        try {
            int a5 = C1737f.a(str.substring(i5, i6));
            for (int i7 = 0; i7 < a5; i7++) {
                if (str.charAt(i6) == '1') {
                    i6 += 33;
                } else {
                    i6 += 17;
                }
            }
            return str.substring(i5, i6);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }

    /* renamed from: g */
    public List getValue() {
        return new ArrayList((Collection) super.getValue());
    }

    public void setValue(Object obj) {
        super.setValue(new ArrayList(new TreeSet((List) obj)));
    }
}
