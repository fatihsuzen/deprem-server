package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.List;
import q1.C1768l;
import s1.C1839c;
import s1.M;
import s1.N;

/* renamed from: r1.m  reason: case insensitive filesystem */
public class C1803m extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16416e = 18;

    /* renamed from: f  reason: collision with root package name */
    public static int f16417f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16418g = "usia";

    public C1803m() {
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
                ((C1839c) g5.get(1)).a(C1768l.f16039n, Boolean.TRUE);
                ((C1839c) g5.get(1)).e(split[1]);
                return g5;
            }
            ((C1839c) g5.get(1)).a(C1768l.f16039n, Boolean.FALSE);
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (list.size() >= 2 && ((C1839c) list.get(1)).c(C1768l.f16039n).equals(Boolean.TRUE)) {
                arrayList.add(((C1839c) list.get(1)).b());
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new M());
        arrayList.add(new N());
        return arrayList;
    }

    public int getId() {
        return f16416e;
    }

    public C1803m(String str) {
        d(str);
    }
}
