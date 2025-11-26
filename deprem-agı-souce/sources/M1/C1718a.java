package m1;

import java.util.List;
import n1.C1725b;
import n1.p;
import p1.C1752a;
import p1.C1753b;
import q1.C1757a;

/* renamed from: m1.a  reason: case insensitive filesystem */
public class C1718a {

    /* renamed from: a  reason: collision with root package name */
    private static C1718a f15610a = new C1718a();

    private C1718a() {
    }

    public static C1718a c() {
        return f15610a;
    }

    public void a(String str, List list, C1757a aVar) {
        int i5 = 0;
        int i6 = 0;
        while (i5 < list.size()) {
            String str2 = (String) list.get(i5);
            if (aVar.a(str2)) {
                C1725b b5 = aVar.get(str2);
                try {
                    String e5 = b5.e(str, i6);
                    b5.b(e5);
                    i6 += e5.length();
                    i5++;
                } catch (p e6) {
                    if (b5.d()) {
                        throw new C1752a("Unable to decode " + str2, e6);
                    }
                    return;
                } catch (Exception e7) {
                    throw new C1752a("Unable to decode " + str2, e7);
                }
            } else {
                throw new C1752a("Field not found: '" + str2 + "'");
            }
        }
    }

    public String b(C1757a aVar, List list) {
        String str = "";
        int i5 = 0;
        while (i5 < list.size()) {
            String str2 = (String) list.get(i5);
            if (aVar.a(str2)) {
                C1725b b5 = aVar.get(str2);
                str = str + b5.c();
                i5++;
            } else {
                throw new C1753b("Field not found: '" + str2 + "'");
            }
        }
        return str;
    }
}
