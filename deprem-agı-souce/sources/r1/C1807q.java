package r1;

import f0.C1648c;
import java.util.ArrayList;
import java.util.List;
import q1.C1772p;
import s1.C1839c;
import s1.C1850h0;
import s1.C1852i0;

/* renamed from: r1.q  reason: case insensitive filesystem */
public class C1807q extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16428e = 20;

    /* renamed from: f  reason: collision with root package name */
    public static int f16429f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16430g = "usnh";

    public C1807q() {
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
                ((C1839c) g5.get(1)).a(C1772p.f16111n, Boolean.TRUE);
                ((C1839c) g5.get(1)).e(split[1]);
                return g5;
            }
            ((C1839c) g5.get(1)).a(C1772p.f16111n, Boolean.FALSE);
        }
        return g5;
    }

    /* access modifiers changed from: protected */
    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (list.size() >= 2 && ((C1839c) list.get(1)).c(C1772p.f16111n).equals(Boolean.TRUE)) {
                arrayList.add(((C1839c) list.get(1)).b());
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1850h0());
        arrayList.add(new C1852i0());
        return arrayList;
    }

    public int getId() {
        return f16428e;
    }

    public C1807q(String str) {
        d(str);
    }
}
