package A3;

import b3.C2312i;
import b3.C2313j;
import y3.C2928a;
import z3.C2972e;

public interface o extends C2972e {

    public static final class a {
        public static /* synthetic */ C2972e a(o oVar, C2312i iVar, int i5, C2928a aVar, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 1) != 0) {
                    iVar = C2313j.f20794a;
                }
                if ((i6 & 2) != 0) {
                    i5 = -3;
                }
                if ((i6 & 4) != 0) {
                    aVar = C2928a.SUSPEND;
                }
                return oVar.b(iVar, i5, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
        }
    }

    C2972e b(C2312i iVar, int i5, C2928a aVar);
}
