package N2;

import H2.d;
import L2.g;
import com.inmobi.cmp.model.ChoiceError;
import kotlin.jvm.internal.t;
import t3.C2777a;

public abstract class a {
    public static long a(int i5, String str) {
        long j5;
        t.e(str, "value");
        if (i5 == str.length()) {
            t.e(str, "value");
            if (i5 != str.length()) {
                d.c((String) null, ChoiceError.ENCODE_INVALID_BIT_LENGTH.getMessage(), (Exception) null, Boolean.TRUE, 5);
                j5 = -1;
            } else {
                j5 = Long.parseLong(str, C2777a.a(2));
            }
            return j5 * ((long) 100);
        }
        throw new g(t.n("h.b", ": invalid bit length"));
    }
}
