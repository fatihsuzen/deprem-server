package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.List;
import q1.C1769m;
import s1.C1839c;
import s1.S;
import s1.T;

/* renamed from: r1.n  reason: case insensitive filesystem */
public class C1804n extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16419e = 14;

    /* renamed from: f  reason: collision with root package name */
    public static int f16420f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16421g = "usmt";

    public C1804n() {
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
                ((C1839c) g5.get(1)).a(C1769m.f16056n, Boolean.TRUE);
                ((C1839c) g5.get(1)).e(split[1]);
                return g5;
            }
            ((C1839c) g5.get(1)).a(C1769m.f16056n, Boolean.FALSE);
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (list.size() >= 2 && ((C1839c) list.get(1)).c(C1769m.f16056n).equals(Boolean.TRUE)) {
                arrayList.add(((C1839c) list.get(1)).b());
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new S());
        arrayList.add(new T());
        return arrayList;
    }

    public int getId() {
        return f16419e;
    }

    public C1804n(String str) {
        d(str);
    }
}
