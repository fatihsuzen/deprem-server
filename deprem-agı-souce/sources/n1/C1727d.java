package n1;

import java.util.ArrayList;
import java.util.List;
import o1.C1737f;
import o1.C1739h;
import p1.C1752a;
import p1.C1753b;

/* renamed from: n1.d  reason: case insensitive filesystem */
public class C1727d extends C1725b {

    /* renamed from: d  reason: collision with root package name */
    private int f15616d;

    /* renamed from: e  reason: collision with root package name */
    private int f15617e;

    public C1727d(int i5, int i6, List list, boolean z4) {
        super(z4);
        this.f15616d = i5;
        this.f15617e = i6;
        setValue(list);
    }

    public void b(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            int i5 = 12;
            int a5 = C1737f.a(str.substring(0, 12));
            for (int i6 = 0; i6 < a5; i6++) {
                int a6 = C1737f.a(str.substring(i5, this.f15616d + i5));
                int i7 = i5 + this.f15616d;
                int a7 = C1737f.a(str.substring(i7, this.f15617e + i7));
                int i8 = i7 + this.f15617e;
                String e5 = new k().e(str, i8);
                List a8 = C1739h.a(e5);
                i5 = i8 + e5.length();
                arrayList.add(new o(a6, a7, a8));
            }
            this.f15615c = arrayList;
        } catch (Exception e6) {
            throw new C1752a(e6);
        }
    }

    public String c() {
        try {
            List<o> list = (List) this.f15615c;
            StringBuilder sb = new StringBuilder();
            sb.append(C1737f.b(list.size(), 12));
            for (o oVar : list) {
                sb.append(C1737f.b(oVar.b(), this.f15616d));
                sb.append(C1737f.b(oVar.c(), this.f15617e));
                sb.append(C1739h.b(oVar.a()));
            }
            return sb.toString();
        } catch (Exception e5) {
            throw new C1753b(e5);
        }
    }

    public String e(String str, int i5) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(i5, i5 + 12));
            int a5 = C1737f.a(sb.toString());
            int length = i5 + sb.length();
            for (int i6 = 0; i6 < a5; i6++) {
                String substring = str.substring(length, this.f15616d + length);
                int length2 = length + substring.length();
                sb.append(substring);
                String substring2 = str.substring(length2, this.f15617e + length2);
                int length3 = length2 + substring2.length();
                sb.append(substring2);
                String e5 = new k().e(str, length3);
                length = length3 + e5.length();
                sb.append(e5);
            }
            return sb.toString();
        } catch (Exception e6) {
            throw new p(e6);
        }
    }
}
