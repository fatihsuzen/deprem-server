package r1;

import f0.C1648c;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import p1.C1752a;
import q1.C1762f;
import s1.C1839c;
import s1.C1849h;
import s1.C1851i;
import s1.C1853j;
import s1.C1855k;

/* renamed from: r1.g  reason: case insensitive filesystem */
public class C1797g extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16398e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f16399f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static String f16400g = "tcfeuv2";

    public C1797g() {
    }

    public void a(String str, Object obj) {
        super.a(str, obj);
        if (!str.equals(C1762f.f15922b) && !str.equals(C1762f.f15923c)) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            super.a(C1762f.f15922b, now);
            super.a(C1762f.f15923c, now);
        }
    }

    public List e(String str) {
        List g5 = g();
        if (str != null && !str.isEmpty()) {
            String[] split = str.split("\\.");
            for (int i5 = 0; i5 < split.length; i5++) {
                String str2 = split[i5];
                if (!str2.isEmpty()) {
                    char charAt = str2.charAt(0);
                    if (charAt >= 'A' && charAt <= 'H') {
                        ((C1839c) g5.get(0)).e(split[i5]);
                    } else if (charAt >= 'I' && charAt <= 'P') {
                        ((C1839c) g5.get(3)).e(split[i5]);
                    } else if (charAt >= 'Q' && charAt <= 'X') {
                        ((C1839c) g5.get(2)).e(split[i5]);
                    } else if ((charAt < 'Y' || charAt > 'Z') && (charAt < 'a' || charAt > 'f')) {
                        throw new C1752a("Invalid segment '" + str2 + "'");
                    } else {
                        ((C1839c) g5.get(1)).e(split[i5]);
                    }
                }
            }
        }
        return g5;
    }

    public String f(List list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() >= 1) {
            arrayList.add(((C1839c) list.get(0)).b());
            if (((Boolean) c(C1762f.f15930j)).booleanValue()) {
                if (list.size() >= 2) {
                    arrayList.add(((C1839c) list.get(1)).b());
                }
            } else if (list.size() >= 2) {
                arrayList.add(((C1839c) list.get(2)).b());
                if (list.size() >= 3) {
                    arrayList.add(((C1839c) list.get(3)).b());
                }
            }
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1849h());
        arrayList.add(new C1851i());
        arrayList.add(new C1853j());
        arrayList.add(new C1855k());
        return arrayList;
    }

    public int getId() {
        return f16398e;
    }

    public C1797g(String str) {
        d(str);
    }
}
