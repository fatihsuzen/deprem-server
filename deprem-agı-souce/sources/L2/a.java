package L2;

import java.util.Map;
import kotlin.jvm.internal.t;
import t3.C2777a;
import t3.p;
import t3.s;

public abstract class a {
    public static String a(String str) {
        String str2;
        t.e(str, "str");
        if (new p("^[A-Za-z0-9\\-_]+$").g(str)) {
            int length = str.length();
            String str3 = "";
            int i5 = 0;
            while (i5 < length) {
                char charAt = str.charAt(i5);
                i5++;
                Integer num = (Integer) b.f18402a.get(String.valueOf(charAt));
                if (num == null) {
                    str2 = null;
                } else {
                    str2 = Integer.toString(num.intValue(), C2777a.a(2));
                    t.d(str2, "toString(this, checkRadix(radix))");
                }
                if (str2 != null) {
                    str3 = str3 + s.H("0", 6 - str2.length()) + str2;
                }
            }
            return str3;
        }
        Map map = b.f18402a;
        throw new g(t.n("g.b", ": Invalidly encoded Base64URL string"));
    }

    public static String b(String str) {
        t.e(str, "str");
        if (new p("^[0-1]+$").g(str)) {
            String str2 = "";
            for (String parseInt : s.Y0(str, 6)) {
                str2 = t.n(str2, Character.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(Integer.parseInt(parseInt, 2))));
            }
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        Map map = b.f18402a;
        sb.append("g.b");
        sb.append(": invalid bitField + ");
        sb.append(str);
        throw new g(sb.toString());
    }
}
