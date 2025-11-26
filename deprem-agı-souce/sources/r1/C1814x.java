package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s1.C1839c;
import s1.O0;

/* renamed from: r1.x  reason: case insensitive filesystem */
public class C1814x extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16449e = 6;

    /* renamed from: f  reason: collision with root package name */
    public static int f16450f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16451g = "uspv1";

    public C1814x() {
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
        arrayList.add(new O0());
        return arrayList;
    }

    public int getId() {
        return f16449e;
    }

    public C1814x(String str) {
        d(str);
    }
}
