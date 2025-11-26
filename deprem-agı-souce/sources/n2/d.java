package N2;

import L2.g;
import kotlin.jvm.internal.t;
import t3.C2777a;
import t3.s;

public abstract class d {
    public static int a(int i5, String str) {
        t.e(str, "value");
        if (i5 == str.length()) {
            return Integer.parseInt(str, C2777a.a(2));
        }
        throw new g(t.n("h.g", ": invalid bit length"));
    }

    public static String b(Number number, int i5) {
        String str;
        t.e(number, "value");
        if ((number instanceof Integer) && number.intValue() >= 0) {
            str = Integer.toString(number.intValue(), C2777a.a(2));
            t.d(str, "toString(this, checkRadix(radix))");
        } else if (!(number instanceof Long) || number.longValue() < 0) {
            throw new g(t.n("h.g", ": incorrect format passed"));
        } else {
            str = Long.toString(number.longValue(), C2777a.a(2));
            t.d(str, "toString(this, checkRadix(radix))");
        }
        if (str.length() <= i5) {
            return s.s0(str, i5, '0');
        }
        throw new g("h.g" + ": " + number + " too large to encode into " + i5);
    }
}
