package f4;

import X2.C2241h;
import com.mbridge.msdk.MBridgeConstans;
import e4.C2362k;
import e4.Q;
import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.t;

public abstract class c {
    public static final void a(C2362k kVar, Q q5, boolean z4) {
        t.e(kVar, "<this>");
        t.e(q5, "dir");
        C2241h hVar = new C2241h();
        Q q6 = q5;
        while (q6 != null && !kVar.g(q6)) {
            hVar.addFirst(q6);
            q6 = q6.h();
        }
        if (!z4 || !hVar.isEmpty()) {
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                kVar.c((Q) it.next());
            }
            return;
        }
        throw new IOException(q5 + " already exist.");
    }

    public static final boolean b(C2362k kVar, Q q5) {
        t.e(kVar, "<this>");
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (kVar.h(q5) != null) {
            return true;
        }
        return false;
    }
}
