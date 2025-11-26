package N2;

import L2.g;
import java.util.Locale;
import kotlin.jvm.internal.t;
import q3.C2729e;
import t3.s;

public abstract class e {
    public static String a(int i5, String str) {
        t.e(str, "value");
        if (i5 == str.length()) {
            int length = str.length() / 2;
            StringBuilder sb = new StringBuilder();
            sb.append((char) (d.a(length, s.c1(str, C2729e.l(0, length))) + 65));
            sb.append((char) (d.a(length, s.c1(str, C2729e.l(length, str.length()))) + 65));
            return sb.toString();
        }
        throw new g(t.n("h.i", ": invalid bit length for language"));
    }

    public static String b(int i5, String str) {
        t.e(str, "value");
        String upperCase = str.toUpperCase(Locale.ROOT);
        t.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        int charAt = upperCase.charAt(0) - 'A';
        int charAt2 = upperCase.charAt(1) - 'A';
        if (charAt < 0 || charAt > 25 || charAt2 < 0 || charAt2 > 25) {
            throw new g("h.i" + ": invalid language code: " + upperCase);
        } else if (i5 % 2 != 1) {
            int i6 = i5 / 2;
            return t.n(d.b(Integer.valueOf(charAt), i6), d.b(Integer.valueOf(charAt2), i6));
        } else {
            throw new g("h.i" + ": numBits must be even, " + i5 + " is not valid");
        }
    }
}
