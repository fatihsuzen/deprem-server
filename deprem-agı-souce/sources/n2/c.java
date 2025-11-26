package N2;

import L2.g;
import com.inmobi.cmp.core.model.Vector;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class c {
    public static Vector a(int i5, String str) {
        t.e(str, "value");
        if (str.length() == i5) {
            int i6 = 1;
            Vector vector = new Vector((Map) null, 1, (C2633k) null);
            if (1 <= i5) {
                while (true) {
                    int i7 = i6 + 1;
                    String valueOf = String.valueOf(str.charAt(i6 - 1));
                    t.e(valueOf, "value");
                    if (t.a(valueOf, "1")) {
                        vector.set(i6);
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6 = i7;
                }
            }
            vector.setBitLength(str.length());
            return vector;
        }
        throw new g(t.n("h.e", ": bitfield encoding length mismatch"));
    }
}
