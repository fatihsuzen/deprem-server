package J2;

import L2.g;
import java.util.List;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class j {
    public static k a(String str) {
        m mVar;
        t.e(str, "hash");
        String str2 = str;
        List G02 = s.G0(str2, new String[]{"-"}, false, 0, 6, (Object) null);
        if (G02.size() == 2) {
            int parseInt = Integer.parseInt((String) G02.get(0));
            int parseInt2 = Integer.parseInt((String) G02.get(1));
            if (parseInt2 == 1) {
                mVar = m.REQUIRE_CONSENT;
            } else if (parseInt2 != 2) {
                mVar = m.NOT_ALLOWED;
            } else {
                mVar = m.REQUIRE_LI;
            }
            return new k(parseInt, mVar);
        }
        throw new g("f.k" + ": TCModelError, hash: " + str2);
    }
}
