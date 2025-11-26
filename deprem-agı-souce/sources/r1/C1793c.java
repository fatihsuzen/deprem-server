package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s1.C1839c;
import s1.C1841d;

/* renamed from: r1.c  reason: case insensitive filesystem */
public class C1793c extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16390e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static int f16391f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16392g = "header";

    public C1793c() {
    }

    /* access modifiers changed from: protected */
    public List e(String str) {
        List g5 = g();
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("\\.");
            for (int i5 = 0; i5 < g5.size(); i5++) {
                if (split.length > i5) {
                    ((C1839c) g5.get(i5)).e(split[i5]);
                }
            }
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((C1839c) it.next()).b());
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1841d());
        return arrayList;
    }

    public int getId() {
        return f16390e;
    }

    public int h() {
        return f16391f;
    }

    public C1793c(String str) {
        d(str);
    }
}
