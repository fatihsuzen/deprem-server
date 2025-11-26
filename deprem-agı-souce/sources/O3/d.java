package O3;

import H3.a;
import H3.b;
import H3.l;
import X2.C2250q;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import r3.C2733c;

public abstract class d {
    public /* synthetic */ d(C2633k kVar) {
        this();
    }

    public static /* synthetic */ b c(d dVar, C2733c cVar, List list, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                list = C2250q.g();
            }
            return dVar.b(cVar, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    public abstract void a(g gVar);

    public abstract b b(C2733c cVar, List list);

    public abstract boolean d();

    public abstract a e(C2733c cVar, String str);

    public abstract l f(C2733c cVar, Object obj);

    private d() {
    }
}
