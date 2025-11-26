package U2;

import H2.c;
import java.util.Locale;
import kotlin.jvm.internal.t;

public abstract class a {
    public static boolean a(String str) {
        String str2;
        int[] b5 = c.b(32);
        int length = b5.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = b5[i5];
            i5++;
            String a5 = b.a(i6);
            if (str == null) {
                str2 = null;
            } else {
                str2 = str.toUpperCase(Locale.ROOT);
                t.d(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            if (t.a(a5, str2)) {
                return true;
            }
        }
        return false;
    }
}
