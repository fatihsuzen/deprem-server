package Y3;

import U3.k;
import U3.l;
import U3.q;
import U3.r;
import U3.x;
import U3.z;
import V3.c;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20203a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(q qVar) {
        return j(qVar.a("Content-Length"));
    }

    public static long b(z zVar) {
        return a(zVar.q());
    }

    public static boolean c(z zVar) {
        if (zVar.A().g().equals("HEAD")) {
            return false;
        }
        int m5 = zVar.m();
        if (((m5 >= 100 && m5 < 200) || m5 == 204 || m5 == 304) && b(zVar) == -1 && !"chunked".equalsIgnoreCase(zVar.o("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static boolean d(q qVar) {
        return k(qVar).contains("*");
    }

    public static boolean e(z zVar) {
        return d(zVar.q());
    }

    public static int f(String str, int i5) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i5;
        }
    }

    public static void g(l lVar, r rVar, q qVar) {
        if (lVar != l.f19539a) {
            List f5 = k.f(rVar, qVar);
            if (!f5.isEmpty()) {
                lVar.a(rVar, f5);
            }
        }
    }

    public static int h(String str, int i5, String str2) {
        while (i5 < str.length() && str2.indexOf(str.charAt(i5)) == -1) {
            i5++;
        }
        return i5;
    }

    public static int i(String str, int i5) {
        while (i5 < str.length() && ((r0 = str.charAt(i5)) == ' ' || r0 == 9)) {
            i5++;
        }
        return i5;
    }

    private static long j(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static Set k(q qVar) {
        Set set = Collections.EMPTY_SET;
        int e5 = qVar.e();
        for (int i5 = 0; i5 < e5; i5++) {
            if ("Vary".equalsIgnoreCase(qVar.c(i5))) {
                String f5 = qVar.f(i5);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : f5.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    private static Set l(z zVar) {
        return k(zVar.q());
    }

    public static q m(q qVar, q qVar2) {
        Set k5 = k(qVar2);
        if (k5.isEmpty()) {
            return new q.a().d();
        }
        q.a aVar = new q.a();
        int e5 = qVar.e();
        for (int i5 = 0; i5 < e5; i5++) {
            String c5 = qVar.c(i5);
            if (k5.contains(c5)) {
                aVar.a(c5, qVar.f(i5));
            }
        }
        return aVar.d();
    }

    public static q n(z zVar) {
        return m(zVar.u().A().d(), zVar.q());
    }

    public static boolean o(z zVar, q qVar, x xVar) {
        for (String str : l(zVar)) {
            if (!c.n(qVar.g(str), xVar.e(str))) {
                return false;
            }
        }
        return true;
    }
}
