package N3;

import M3.C2128b;
import kotlin.jvm.internal.t;

public abstract class P {
    public static final O a(C2128b bVar, String str) {
        t.e(bVar, "json");
        t.e(str, "source");
        if (!bVar.c().a()) {
            return new O(str);
        }
        return new Q(str);
    }
}
