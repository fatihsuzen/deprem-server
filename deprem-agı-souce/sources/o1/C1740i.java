package o1;

import java.util.regex.Pattern;
import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.i  reason: case insensitive filesystem */
public abstract class C1740i {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15669a = Pattern.compile("^[0-1]*$", 2);

    public static long a(String str) {
        if (f15669a.matcher(str).matches()) {
            long j5 = 0;
            int i5 = 0;
            while (i5 < str.length()) {
                int i6 = i5 + 1;
                if (str.charAt(str.length() - i6) == '1') {
                    j5 += 1 << i5;
                }
                i5 = i6;
            }
            return j5;
        }
        throw new C1752a("Undecodable FixedLong '" + str + "'");
    }

    public static String b(long j5, int i5) {
        String str = "";
        while (j5 > 0) {
            if ((j5 & 1) == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            j5 >>= 1;
        }
        if (str.length() <= i5) {
            while (str.length() < i5) {
                str = "0" + str;
            }
            return str;
        }
        throw new C1753b("Numeric value '" + j5 + "' is too large for a bit string length of '" + i5 + "'");
    }
}
