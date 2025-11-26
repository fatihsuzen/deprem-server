package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.List;
import q1.C1765i;
import s1.C1839c;
import s1.C1873y;
import s1.C1874z;

/* renamed from: r1.j  reason: case insensitive filesystem */
public class C1800j extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16407e = 12;

    /* renamed from: f  reason: collision with root package name */
    public static int f16408f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16409g = "usct";

    public C1800j() {
    }

    /* access modifiers changed from: protected */
    public List e(String str) {
        List g5 = g();
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                ((C1839c) g5.get(0)).e(split[0]);
            }
            if (split.length > 1) {
                ((C1839c) g5.get(1)).a(C1765i.f15992m, Boolean.TRUE);
                ((C1839c) g5.get(1)).e(split[1]);
                return g5;
            }
            ((C1839c) g5.get(1)).a(C1765i.f15992m, Boolean.FALSE);
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (list.size() >= 2 && ((C1839c) list.get(1)).c(C1765i.f15992m).equals(Boolean.TRUE)) {
                arrayList.add(((C1839c) list.get(1)).b());
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1873y());
        arrayList.add(new C1874z());
        return arrayList;
    }

    public int getId() {
        return f16407e;
    }

    public C1800j(String str) {
        d(str);
    }
}
