package n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import o1.C1737f;
import o1.C1742k;
import p1.C1752a;
import p1.C1753b;

public class n extends C1725b {
    public n(List list) {
        super(true);
        setValue(list);
    }

    public void b(String str) {
        try {
            this.f15615c = C1742k.a(str);
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1742k.b((List) this.f15615c);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        int i6 = i5 + 16;
        try {
            int a5 = C1737f.a(str.substring(i5, i6));
            if (str.charAt(i6) != '1') {
                return str.substring(i5, i5 + 17 + a5);
            }
            StringBuilder sb = new StringBuilder();
            int i7 = i5 + 17;
            sb.append(str.substring(i5, i7));
            sb.append(new k().e(str, i7));
            return sb.toString();
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
