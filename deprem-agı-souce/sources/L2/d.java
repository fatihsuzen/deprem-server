package L2;

import com.inmobi.cmp.core.model.Vector;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class d {
    public static Vector a(String str) {
        Vector vector = new Vector((Map) null, 1, (C2633k) null);
        int i5 = 0;
        int i6 = 0;
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            i5++;
            i6++;
            if (charAt == '1') {
                vector.set(i6);
            }
        }
        return vector;
    }

    public static String b(Vector vector) {
        t.e(vector, "vector");
        L l5 = new L();
        l5.f24690a = s.H("0", vector.getMaxId());
        vector.forEach(new c(l5));
        return (String) l5.f24690a;
    }
}
