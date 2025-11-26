package r1;

import f0.C1648c;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import p1.C1752a;
import q1.C1761e;
import s1.C1839c;
import s1.C1843e;
import s1.C1845f;
import s1.C1847g;

/* renamed from: r1.f  reason: case insensitive filesystem */
public class C1796f extends C1791a {

    /* renamed from: e  reason: collision with root package name */
    public static int f16395e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static int f16396f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static String f16397g = "tcfcav1";

    public C1796f() {
    }

    public void a(String str, Object obj) {
        super.a(str, obj);
        if (!str.equals(C1761e.f15889b) && !str.equals(C1761e.f15890c)) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            super.a(C1761e.f15889b, now);
            super.a(C1761e.f15890c, now);
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
        arrayList.add(((C1839c) list.get(0)).b());
        arrayList.add(((C1839c) list.get(1)).b());
        if (!h().isEmpty()) {
            arrayList.add(((C1839c) list.get(2)).b());
        }
        return C1648c.a(".", arrayList);
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1843e());
        arrayList.add(new C1847g());
        arrayList.add(new C1845f());
        return arrayList;
    }

    public int getId() {
        return f16395e;
    }

    public List h() {
        return (List) c(C1761e.f15911x);
    }

    public C1796f(String str) {
        d(str);
    }
}
