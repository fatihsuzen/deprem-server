package o1;

import java.util.regex.Pattern;
import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.j  reason: case insensitive filesystem */
public abstract class C1741j {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15670a = Pattern.compile("^[0-1]*$", 2);

    public static String a(String str) {
        if (!f15670a.matcher(str).matches() || str.length() % 6 != 0) {
            throw new C1752a("Undecodable FixedString '" + str + "'");
        }
        String str2 = "";
        int i5 = 0;
        while (i5 < str.length()) {
            int i6 = i5 + 6;
            int a5 = C1737f.a(str.substring(i5, i6));
            if (a5 == 63) {
                str2 = str2 + " ";
            } else {
                str2 = str2 + ((char) (a5 + 65));
            }
            i5 = i6;
        }
        return str2.trim();
    }

    public static String b(String str, int i5) {
        while (str.length() < i5) {
            str = str + " ";
        }
        String str2 = "";
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            if (charAt == ' ') {
                str2 = str2 + C1737f.b(63, 6);
            } else if (charAt >= 'A') {
                str2 = str2 + C1737f.b(str.charAt(i6) - 'A', 6);
            } else {
                throw new C1753b("Unencodable FixedString '" + str + "'");
            }
        }
        return str2;
    }
}
