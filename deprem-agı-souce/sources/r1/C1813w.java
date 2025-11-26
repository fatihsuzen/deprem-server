package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s1.C1839c;
import s1.K0;

/* renamed from: r1.w  reason: case insensitive filesystem */
public class C1813w extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16446e = 9;

    /* renamed from: f  reason: collision with root package name */
    public static int f16447f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16448g = "usva";

    public C1813w() {
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
        arrayList.add(new K0());
        return arrayList;
    }

    public int getId() {
        return f16446e;
    }

    public C1813w(String str) {
        d(str);
    }
}
