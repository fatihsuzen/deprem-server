package n1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import o1.C1736e;
import p1.C1752a;
import p1.C1753b;

public class h extends C1725b {

    /* renamed from: d  reason: collision with root package name */
    private int f15618d;

    public h(List list) {
        super(true);
        this.f15618d = list.size();
        setValue(list);
    }

    public void b(String str) {
        try {
            this.f15615c = C1736e.a(str);
        } catch (Exception e5) {
            throw new C1752a(e5);
        }
    }

    public String c() {
        try {
            return C1736e.b((List) this.f15615c, this.f15618d);
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            return str.substring(i5, this.f15618d + i5);
        } catch (Exception e5) {
            throw new p(e5);
        }
    }

    /* renamed from: g */
    public List getValue() {
        return new ArrayList((Collection) super.getValue());
    }

    public void setValue(Object obj) {
        List arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < this.f15618d; size++) {
            arrayList.add(Boolean.FALSE);
        }
        int size2 = arrayList.size();
        int i5 = this.f15618d;
        if (size2 > i5) {
            arrayList = arrayList.subList(0, i5);
        }
        super.setValue(arrayList);
    }
}
