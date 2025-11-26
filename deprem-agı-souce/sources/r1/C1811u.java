package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.List;
import q1.C1776t;
import s1.B0;
import s1.C0;
import s1.C1839c;

/* renamed from: r1.u  reason: case insensitive filesystem */
public class C1811u extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16440e = 16;

    /* renamed from: f  reason: collision with root package name */
    public static int f16441f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16442g = "ustx";

    public C1811u() {
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
                ((C1839c) g5.get(1)).a(C1776t.f16179n, Boolean.TRUE);
                ((C1839c) g5.get(1)).e(split[1]);
                return g5;
            }
            ((C1839c) g5.get(1)).a(C1776t.f16179n, Boolean.FALSE);
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (list.size() >= 2 && ((C1839c) list.get(1)).c(C1776t.f16179n).equals(Boolean.TRUE)) {
                arrayList.add(((C1839c) list.get(1)).b());
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new B0());
        arrayList.add(new C0());
        return arrayList;
    }

    public int getId() {
        return f16440e;
    }

    public C1811u(String str) {
        d(str);
    }
}
