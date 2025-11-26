package o1;

import java.util.regex.Pattern;
import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.f  reason: case insensitive filesystem */
public abstract class C1737f {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15665a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (f15665a.matcher(str).matches()) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < str.length()) {
                int i7 = i5 + 1;
                if (str.charAt(str.length() - i7) == '1') {
                    i6 += 1 << i5;
                }
                i5 = i7;
            }
            return i6;
        }
        throw new C1752a("Undecodable FixedInteger '" + str + "'");
    }

    public static String b(int i5, int i6) {
        String str = "";
        while (i5 > 0) {
            if ((i5 & 1) == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            i5 >>= 1;
        }
        if (str.length() <= i6) {
            while (str.length() < i6) {
                str = "0" + str;
            }
            return str;
        }
        throw new C1753b("Numeric value '" + i5 + "' is too large for a bit string length of '" + i6 + "'");
    }
}
